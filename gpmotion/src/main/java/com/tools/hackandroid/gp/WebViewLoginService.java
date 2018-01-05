package com.tools.hackandroid.gp;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.Service;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;

import com.tools.hackandroid.GlobalSettings;
import com.tools.hackandroid.gp.account.RegisterAccount;
import com.tools.hackandroid.util.AESCipher;
import com.tools.hackandroid.util.DLog;
import com.tools.hackandroid.util.FileUtil;
import com.tools.hackandroid.util.ShellUtils;

import net.luna.common.debug.LunaLog;
import net.luna.common.entity.HttpRequest;
import net.luna.common.entity.HttpResponse;
import net.luna.common.util.HttpUtils;
import net.luna.common.util.StringUtils;
import net.luna.common.util.ThreadUtils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public class WebViewLoginService extends Service {

    public static int BROWSER_TIMEOUT = 180000;
    public static int PHONE_TIMEOUT = 50000;
    public static int REGISTER_TIMEOUT = 360000;
    public static int TOOTAL_TIMEOUT = 540000;


    public static final int INIT = 0;
    public static final int START = 1;
    public static final int INPUT_PASSWORD_VERIFY = 2;
    public static final int REQUEST_PHONE_TOKEN = 4;
    public static final int GET_PHONE_TOKEN = 5;
    public static final int GET_PHONE_NUMBER = 6;
    public static final int REQUEST_PHONE_MSG = 7;
    public static final int GET_PHONE_MSG = 8;
    private static final int FINISH = 9;
    private static final int INPUT_ACCOUNT = 10;
    private static final int INPUT_PASSWORD = 11;
    private static final int SKIP_PHONE = 12;
    private static final int AGREE_AGREEMENT = 13;
    private static final int DONE = 14;
    private static final int OPEN_BROWSER = 15;
    private static final int FILL_LOCATION = 16;

    public static final int REGISTER = 17;

    private static String token = "";
    private static int count = 0;
    private static int retryGetPhoneCount = 0;

    private static int lollipopStep = -1;
    private static boolean isRetryGetPhone;
    private static int errorCount = 0;

    public WebViewHandler handler;

    private static RegisterAccount account;

    private ClipboardManager clipboard;

    private static String serialNo;

    private SharedPreferences sp;

    private SmsVerifier smsVerifier;

    private int retryActiveTime = 0;

    private int registerCount = 0;
    private GoogleRegister register;

    @Override
    public IBinder onBind(Intent intent) {
        // TODO Auto-generated method stub

        LunaLog.d("on bind");

        return null;
    }

    @SuppressLint("WorldReadableFiles")
    @Override
    public void onCreate() {

        super.onCreate();
        LunaLog.d("on create");
        clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);

        handler = new WebViewHandler(this);

        sp = getSharedPreferences("config", Context.MODE_PRIVATE);
        serialNo = sp.getString("ro.serialno", "");
        if (!TextUtils.isEmpty(serialNo)) {
            serialNo = ShellUtils.execCommand("getprop ro.serialno", false).successMsg;
            sp.edit().putString("ro.serialno", serialNo).commit();
        }

//        if (GlobalSettings.isHomeland) {
//            BROWSER_TIMEOUT = 180000;
//            PHONE_TIMEOUT = 40000;
//            REGISTER_TIMEOUT = 300000;
//        } else {
//            BROWSER_TIMEOUT = 140000;
//            PHONE_TIMEOUT = 30000;
//            REGISTER_TIMEOUT = 180000;
//        }

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        LunaLog.d("onStartCommand");

//        handler.mainTask = handler.mService.get().new MainTask();
//        handler.mService.get().handler.postDelayed(handler.mainTask, 2000);
        handler.sendEmptyMessage(REGISTER);
        return super.onStartCommand(intent, flags, startId);
    }

    @SuppressLint("SdCardPath")
    private void getDataFromClipboard() {
        try {
            ClipData clip = clipboard.getPrimaryClip();
            Intent dataIntent = clip.getItemAt(0).getIntent();
            if (dataIntent != null) {
                lollipopStep = -1;
                lollipopStep = dataIntent.getIntExtra("lollipop_web_step", -1);
                clipboard.setPrimaryClip(ClipData.newPlainText("", ""));
            }
        } catch (Exception e) {
            // e.printStackTrace();
        }
    }

    // ===========================================================================

    public class WebViewHandler extends Handler {
        WeakReference<WebViewLoginService> mService;
        public MainTask mainTask;
        public int currentStep = 0;

        public WebViewHandler(WebViewLoginService service) {
            mService = new WeakReference<WebViewLoginService>(service);


        }

        @Override
        public void handleMessage(Message msg) {
            try {
                super.handleMessage(msg);
                String commands;
                String phoneNumber;
                final WebViewLoginService service = mService.get();
                LunaLog.d("msg.what: " + msg.what);
                currentStep = msg.what;
                if (service != null) {
                    switch (msg.what) {
                        case INIT:
                            if (msg.obj != null) {
                                account = (RegisterAccount) msg.obj;
                                LunaLog.d("email: " + account.email);
                            }
                            count = 0;
                            isRetryGetPhone = false;
                            retryGetPhoneCount = 0;

                            if (mainTask == null) {
                                mainTask = service.new MainTask();
                                service.handler.postDelayed(mainTask, 2000);
                            }
                            service.handler.sendEmptyMessage(OPEN_BROWSER);
                            mainTask.openBrowserTimeMs = System.currentTimeMillis();
                            mainTask.waitPhoneNumTime = 0;
                            break;

                        case OPEN_BROWSER:
                            ShellUtils.execCommand("pm clear com.android.browser", true);
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            Intent intent = new Intent(Intent.ACTION_VIEW,
                                    Uri.parse("https://accounts.google.com/embedded/setup/chrome/usermenu"));
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            service.startActivity(intent);
                            break;


                        case REQUEST_PHONE_TOKEN:
                            mainTask.waitPhoneNumTime = System.currentTimeMillis();
                            LunaLog.d("==============GET_PHONE_TOKEN========");
                            if (isRetryGetPhone) {
                                isRetryGetPhone = false;
                            }

                            if (msg.arg1 == 15) {
                                ShellUtils.execCommand(
                                        "input tap 300 650;sleep 1;",
                                        true);
                            } else {
                                ShellUtils.execCommand(
                                        "input tap 650 800;sleep 1;input tap 300 800;sleep 1;input tap 300 800;",
                                        true);
                            }

                            smsVerifier = new SmsVerifier(service);
                            smsVerifier.getPhoneNum();
                            break;
                        case GET_PHONE_NUMBER:
                            phoneNumber = (String) msg.obj;
                            LunaLog.d("phoneNumber: " + phoneNumber);
                            if (!"error".equals(phoneNumber)) {
                                mainTask.phone = phoneNumber.toString();

                                mainTask.waitPhoneNumTime = System.currentTimeMillis();

                                account.phone = phoneNumber + "";
                                ShellUtils.execCommand("sleep 1;input text +86" + phoneNumber
                                        + ";input keyevent 66;sleep 2;input tap 540 900", true);
                            } else {
                                service.handler.sendEmptyMessage(REQUEST_PHONE_TOKEN);
                            }
                            break;

                        case REQUEST_PHONE_MSG:
                            mainTask.waitPhoneNumTime = 0;
                            count++;
                            Log.v("vcode", "--# 第" + count + "次获取...");
                            smsVerifier.getSms();
                            break;

                        case GET_PHONE_MSG:
                            String code = (String) msg.obj;
                            if (code != null && !code.contains("Null")) {
                                commands = "input tap 250 800;sleep 1;input text " + code + ";sleep 1;input keyevent 66;";
                                ShellUtils.execCommand(commands, true);
                                account.code = code.toString();
                            } else {
                                if (count >= 10) {
                                    service.handler.sendEmptyMessage(INIT);
                                    smsVerifier.putInBlackList();
                                } else {
                                    service.handler.sendEmptyMessageDelayed(REQUEST_PHONE_MSG, 5000);
                                }
                            }
                            break;

                        case START:
                            if (mainTask == null) {
                                mainTask = service.new MainTask();
                                service.handler.postDelayed(mainTask, 2000);
                            }


                            ShellUtils.execCommand("input tag 250 810;sleep 1;", true);
                            ActivityManager am = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
                            ComponentName cn = am.getRunningTasks(1).get(0).topActivity;
                            LunaLog.d("TOP CLASS NAME : " + cn.getClassName());
                            if (cn.getClassName().equals("com.android.browser.BrowserActivity")) {
                                ShellUtils.execCommand("input text " + account.email + ";sleep 3;input keyevent 66;", true);
                            } else {
                                ShellUtils.execCommand("input tag 250 810;sleep 1;input text " + account.email + ";sleep 3;input keyevent 66;", true);
                            }

                            break;

                        case INPUT_PASSWORD_VERIFY:
                            ShellUtils
                                    .execCommand(
                                            "input tag 150 400;sleep 1;input text "
                                                    + account.password
                                                    + ";sleep 3;input keyevent 66;",
                                            true);

                            break;

                        case INPUT_ACCOUNT:
                            mainTask.openBrowserTimeMs = System.currentTimeMillis();
//                        ShellUtils
//                                .execCommand(
//                                        "input touchscreen swipe 280 820 280 820 2000;sleep 2;input keyevent 67;sleep 1;",
//                        true);
                            ShellUtils.execCommand("input text " + account.userName + ";input keyevent 66;", true);
                            break;

                        case INPUT_PASSWORD:
                            ShellUtils.execCommand("input text " + account.password, true);
                            ShellUtils.execCommand("input keyevent 61;sleep 1;input text " + account.password
                                    + ";input keyevent 66;", true);
                            break;

                        case SKIP_PHONE:
                            break;

                        case AGREE_AGREEMENT:
                            ShellUtils.execCommand("input tap 550 770; sleep 1;", true);
                            ShellUtils.execCommand("input tap 500 1200", true);
                            break;

                        case DONE:
                            break;
                        case FILL_LOCATION:
//                        ShellUtils.execCommand("input tap 250 810; sleep 1;", true);
//                        ShellUtils.execCommand("input text " + account.area + "; sleep 1;input keyevent 66;", true);
                            if (retryActiveTime > 1) {
                                handler.sendEmptyMessageDelayed(REGISTER, 5000);
                            } else {
                                retryActiveTime++;
                                handler.sendEmptyMessageDelayed(INIT, 5000);
                            }
                            break;
                        case FINISH:
                            errorCount = 0;
                            try {
//                            mainTask.isFinish = true;
                                saveAccount();
                                SimpleDateFormat formatter = new SimpleDateFormat("yyyy:MM:dd HH:mm");
                                Date curDate = new Date(System.currentTimeMillis());//获取当前时间
                                String dataStr = formatter.format(curDate);
                                String line = dataStr + "," + account.email + "," + account.password + "," + account.phone + "," + account.androidId + "," + account.area;
                                writeRecord(line);
                                ShellUtils.execCommand("am force-stop com.android.browser", true);

                            } catch (Exception e) {
                                e.printStackTrace();
                            }

//                        service.handler.sendEmptyMessageDelayed(INIT, 30000);
                            break;
                        case REGISTER:
                            retryActiveTime = 0;
                            if (mainTask != null) {
                                mainTask.openBrowserTimeMs = 0;
                                mainTask.waitPhoneNumTime = 0;
                            }
                            ShellUtils.execCommand("am force-stop com.android.browser", true);
                            Context context = WebViewLoginService.this.getApplicationContext();
                            registerCount++;
                            boolean changeIp = false;
                            if (registerCount % 2 == 0) {
                                changeIp = true;
                            }
                            if (register == null) {
                                register = new GoogleRegister(context, handler, changeIp);
                                register.initBlackList();
                            }

                            //设置成13: 注册位
                            Intent clipIntent = new Intent();
                            clipIntent.putExtra("lollipop_web_step", 13);
                            ClipboardManager clipboard = (ClipboardManager) context
                                    .getSystemService(Context.CLIPBOARD_SERVICE);
                            ClipData clip = ClipData.newIntent("intent", clipIntent);
                            clipboard.setPrimaryClip(clip);
                            try {
                                ThreadUtils.runSingleThreadTimeout(register, REGISTER_TIMEOUT);
                            } catch (InterruptedException e) {
                                LunaLog.e("线程终端,重新注册");
                                handler.sendEmptyMessageDelayed(REGISTER, 3000);
                            } catch (ExecutionException e) {
                                LunaLog.e(e);
                                handler.sendEmptyMessageDelayed(REGISTER, 3000);
                            } catch (TimeoutException e) {
                                LunaLog.d("超时依然没注册完成,重新注册");
                                handler.sendEmptyMessageDelayed(REGISTER, 3000);
                            }
                    }
                }
            } catch (Exception e) {
                LunaLog.e(e);
            }
        }

    }

    private class MainTask implements Runnable {
        String phone = "";
        //        boolean isFinish;
        long openBrowserTimeMs = 0;
        long waitPhoneNumTime = 0;
        int position;
        int phoneCount;

        public MainTask() {
//            isFinish = false;
        }

        @Override
        public void run() {
            try {
                getDataFromClipboard();

                if (lollipopStep != -1) {
                    position = lollipopStep;
                }
//            if (lollipopStep != -1) {
                long waitBroswerTIme = (System.currentTimeMillis() - openBrowserTimeMs);
                LunaLog.d("---------------web register-----  " + lollipopStep + " & " + position + "    waitBroswerTIme: " + waitBroswerTIme / 1000);
//            }

                switch (lollipopStep) {
                    case 0:
                        handler.sendEmptyMessage(START);
                        break;

                    case 1:
                        handler.sendEmptyMessageDelayed(INPUT_PASSWORD_VERIFY, 3000);
                        break;

                    case 2:
                        handler.sendEmptyMessageDelayed(REQUEST_PHONE_TOKEN, 3000);
                        break;

                    case 3:
                        phoneCount = 0;
                        handler.sendEmptyMessageDelayed(REQUEST_PHONE_MSG, 3000);
                        break;

                    case 4:
                        handler.sendEmptyMessageDelayed(INPUT_ACCOUNT, 3000);
                        break;

                    case 5:
                        handler.sendEmptyMessageDelayed(INPUT_PASSWORD, 3000);
                        break;

                    case 6:
                        handler.sendEmptyMessageDelayed(SKIP_PHONE, 3000);
                        break;

                    case 7:
                        handler.sendEmptyMessageDelayed(AGREE_AGREEMENT, 3000);
                        break;

                    case 8:
                        handler.sendEmptyMessageDelayed(DONE, 3000);
                        break;

                    case 9:
//                    isFinish = true;
                        handler.sendEmptyMessageDelayed(FINISH, 3000);
                        break;

                    case 10:
//                    isFinish = true;
                        handler.sendEmptyMessageDelayed(INIT, 3000);
                        // ShellUtils.execCommand("input tap 350 760", true);
                        break;

                    case 11:
                        errorCount++;
                        if (errorCount > 5) {
                            ShellUtils.execCommand("setprop ctl.restart surfaceflinger; setprop ctl.restart zygote", true);
                        }
                        break;
                    case 12:
                        handler.sendEmptyMessageDelayed(FILL_LOCATION, 3000);
                        break;
                    case 13:
                        //什么都不做,只是置换成注册状态
                        break;
                    case 14:
                        //什么都不做,只是置换成未知网页等待状态
                        break;

                    case 15:
                        Message msg = new Message();
                        msg.what = REQUEST_PHONE_TOKEN;
                        msg.arg1 = 15;
                        handler.sendMessageDelayed(msg, 3000);
                        break;
                    case 16:
                        phoneCount = 0;
                        Message msg1 = new Message();
                        msg1.what = REQUEST_PHONE_MSG;
                        msg1.arg1 = 16;
                        handler.sendMessageDelayed(msg1, 3000);
                        break;
                }
                lollipopStep = -1;


                if ((position == 14 && waitBroswerTIme > 60000)
                        || (openBrowserTimeMs != 0 && waitBroswerTIme > BROWSER_TIMEOUT && position >= 0 && position != 13)
                        || (waitPhoneNumTime != 0 && ((System.currentTimeMillis() - waitPhoneNumTime) > PHONE_TIMEOUT) && (position == 2 || position == 15))
                        || (waitBroswerTIme > TOOTAL_TIMEOUT)) {
                    if (waitBroswerTIme > 10000000) {
                        //异常的时间
                        handler.postDelayed(this, 3000);
                        return;
                    }
                    if (position == 2) {
                        ShellUtils.execCommand("input swipe 210 880 460 880;sleep 1;input swipe 230 910 490 910;" +
                                "sleep 1;input tap 530 120;", true);
                        String text = (String) clipboard.getText();
                        LunaLog.d("粘贴板: " + text);
                        if (text != null && text.contains("号码已多次")) {
                            //加入黑名单
                            if (smsVerifier != null) {
                                smsVerifier.putInBlackList();
                            }
                        } else if (text != null && text.contains("此电话号码无法用于进行验")) {
                            LunaLog.d("IP无效");
                            ShellUtils.execCommand("am force-stop com.android.browser", true);
                            handler.sendEmptyMessageDelayed(REGISTER, 3000);
                            position = 13;
                            handler.postDelayed(this, 3000);
                            return;
                        }
                    }

                    if (position == 14 && !StringUtils.isBlank(account.ipId)) {
                        sentIpBlackList();
                    }

                    LunaLog.d("超时,重新开始运行脚本");
                    if (retryActiveTime > 1 || (position == 14 && !StringUtils.isBlank(account.ipId))) {
//                    isFinish = true;
                        LunaLog.d("重试过多,切换IP重新注册");
                        ShellUtils.execCommand("am force-stop com.android.browser", true);
                        handler.sendEmptyMessageDelayed(REGISTER, 3000);
                        position = 13;
                    } else {
                        retryActiveTime++;
                        LunaLog.d("中途卡住");
                        ShellUtils.execCommand("am force-stop com.android.browser", true);
                        openBrowserTimeMs = 0;
                        waitPhoneNumTime = 0;
                        handler.sendEmptyMessageDelayed(INIT, 0);
                    }
                }
            } catch (Exception e) {
                LunaLog.e(e);
            }

            handler.postDelayed(this, 3000);

        }
    }

    private void sentIpBlackList() {

        ThreadUtils.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    LunaLog.d("提交该IP进入黑名单");
                    String param = "imei=" + account.ipId;
                    String encryStr = Base64.encodeToString(addPrefix(AESCipher.encrypt(param.getBytes("utf-8"), "3Ce7671Ff686D51d".getBytes("utf-8"), "0123456789ABCDEF".getBytes("utf-8"))), Base64.NO_WRAP);
                    String content = "s=" + encryStr;
                    HttpRequest request = new HttpRequest("http://seoul-proxy-load-balance-1294549866.ap-northeast-2.elb.amazonaws.com/disconnect/");
                    request.setPostContent(content);

                    HttpResponse response = HttpUtils.httpPost(request);
                    if (response != null) {
                        String result = response.getResponseBody();
                        LunaLog.d("提交结果: " + result);
                    }
                } catch (Exception e) {
                    LunaLog.e(e);
                }
            }
        });
    }

    public WebViewHandler getHandler() {
        return handler;
    }

    private void writeRecord(String line) {
        try {
            if (line == null) {
                return;
            }
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
            Date curDate = new Date(System.currentTimeMillis());//获取当前时间
            String dataStr = formatter.format(curDate);
            File recordfile = Environment.getExternalStoragePublicDirectory("/gregister/active.txt");
            LunaLog.d("写入: " + line);
//            FileUtils.writeFile(recordfile.getAbsolutePath(), line, true);
            FileUtil.writeLine2File(recordfile, line);
        } catch (Exception e) {
            DLog.e(e);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    private static byte[] addPrefix(byte[] data) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            baos.write("0123456789ABCDEF".getBytes("utf-8"));
            baos.write(data);
            byte[] result = baos.toByteArray();
            baos.flush();
            baos.close();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    int resentAccoutCount = 0;

    public void saveAccount() {
        if (account.area != null) {
            try {
                account.area = URLEncoder.encode(account.area, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }

        final String param = "email=" + account.email + "&passwd=" + account.password + "&first_name=" + account.firstName + "&last_name=" + account.lastName + "&rec_phone=" +
                account.phone + "&androidid=" + account.androidId + "&city=" + account.area + "&available=" + 1 + "&device_no=cool_" + GlobalSettings.phoneNo + "&rec_email=" + account.recEmail;
        ThreadUtils.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    String encryStr = Base64.encodeToString(addPrefix(AESCipher.encrypt(param.getBytes("utf-8"), "3Ce7671Ff686D51d".getBytes("utf-8"), "0123456789ABCDEF".getBytes("utf-8"))), Base64.NO_WRAP);
                    String address = "http://api.amigov.com/gmail/account/add?s=" + encryStr;
                    LunaLog.d(address);
                    //System.out.println(address);
                    String result = HttpUtils.httpGetString(address);

                    LunaLog.d("提交结果: " + result);
                    if (result != null && (result.contains(": 0") || result.contains("-3005"))) {
                        account.isGooglePlus = false;
                        account.region = "SG";
                        account.email = "";
                        handler.sendEmptyMessageDelayed(REGISTER, 10000);
                        resentAccoutCount = 0;
                        return;
                    }
                } catch (Exception e) {
                    LunaLog.e(e);
                }
                if (resentAccoutCount > 3) {
                    resentAccoutCount = 0;
                    account.isGooglePlus = false;
                    account.region = "SG";
                    account.email = "";
                    handler.sendEmptyMessageDelayed(REGISTER, 10000);
                } else {
                    saveAccount();
                    resentAccoutCount++;
                }
            }
        });
    }

    private void getTopActivity() {
        ActivityManager am = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        ComponentName cn = am.getRunningTasks(1).get(0).topActivity;
        LunaLog.d("TOP CLASS NAME : " + cn.getClassName());
        LunaLog.d("");
        if (cn.getClassName().equals("com.android.browser.BrowserActivity")) {
        }
    }
}


