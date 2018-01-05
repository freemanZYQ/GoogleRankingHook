package com.tools.hackandroid;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.tencent.mid.api.MidCallback;
import com.tencent.mid.api.MidService;
import com.tools.hackandroid.accessibility.util.AccessibilityServiceUtil;
import com.tools.hackandroid.gp.WebViewLoginService;
import com.tools.hackandroid.output.SysInfo;
import com.tools.hackandroid.sp.BatterySp;
import com.tools.hackandroid.sp.BuildSp;
import com.tools.hackandroid.sp.BuildVersionSp;
import com.tools.hackandroid.sp.ConnectivityManagerSp;
import com.tools.hackandroid.sp.DisplaySp;
import com.tools.hackandroid.sp.LocaleSp;
import com.tools.hackandroid.sp.SystemPropertiesSp;
import com.tools.hackandroid.sp.TelephonyManagerSp;
import com.tools.hackandroid.sp.UnSpecifiedSp;
import com.tools.hackandroid.sp.WIfiManagerSp;
import com.tools.hackandroid.util.DLog;
import com.tools.hackandroid.util.FileUtil;
import com.tools.hackandroid.util.IntentUtil;
import com.tools.hackandroid.util.PackageUtil;
import com.tools.hackandroid.util.PositionSpUtil;
import com.tools.hackandroid.util.RandomUtil;
import com.tools.hackandroid.util.ShellUtils;
import com.tools.hackandroid.util.StreamReader;

import net.luna.common.debug.LunaLog;
import net.luna.common.util.HttpUtils;
import net.luna.common.util.JSONUtils;
import net.luna.common.util.NetWorkUtil;
import net.luna.common.util.PackageUtils;
import net.luna.common.util.PreferencesUtils;
import net.luna.common.util.StringUtils;
import net.luna.common.util.ThreadUtils;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import be.shouldit.proxy.lib.APL;

public class MainActivity extends AppCompatActivity {

    private final static int REQ_CODE_ACTION_ACCESSIBILITY_SETTINGS = 1;

    private TextView mTvSysInfo;

    private TextView mTvAccessibility;

    private CheckBox mCheckBox, mProxyCheckBox;
    private EditText mPhoneNoEdit;
    private static Activity context;

    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;



        //		try {
        //			StatService.startStatService(this, null, com.tencent.stat.common.StatConstants.VERSION);
        //		} catch (MtaSDkException e) {
        //			e.printStackTrace();
        //		}
        mTvSysInfo = (TextView) findViewById(R.id.tv_show_sysInfo);
        mTvAccessibility = (TextView) findViewById(R.id.tv_show_accessibility);
        mCheckBox = (CheckBox) findViewById(R.id.country_check);
        mPhoneNoEdit = (EditText) findViewById(R.id.ed_phone_no);
        boolean isCheck = PreferencesUtils.getBoolean(context, Constants.SP_IS_HOMELAND);
        mCheckBox.setChecked(isCheck);
        GlobalSettings.isHomeland = isCheck;

        mProxyCheckBox = (CheckBox) findViewById(R.id.proxy_check);
        boolean isProxyCheck = PreferencesUtils.getBoolean(context, Constants.SP_IS_USER_PROXY);
        mProxyCheckBox.setChecked(isProxyCheck);
        GlobalSettings.isUserProxy = isProxyCheck;

        mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                GlobalSettings.isHomeland = isChecked;
                PreferencesUtils.putBoolean(context, Constants.SP_IS_HOMELAND, isChecked);
            }
        });

        mProxyCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                GlobalSettings.isUserProxy = isChecked;
                PreferencesUtils.putBoolean(context, Constants.SP_IS_USER_PROXY, isChecked);
            }
        });

        GlobalSettings.phoneNo = PreferencesUtils.getString(context, Constants.SP_PHONE_NO);
        GlobalSettings.oriIp = PreferencesUtils.getString(context, Constants.SP_ORI_IP);
        if (!StringUtils.isBlank(GlobalSettings.phoneNo)) {
            mPhoneNoEdit.setText(GlobalSettings.phoneNo + "," + GlobalSettings.oriIp);
        }


//        NetWorkUtil.setContext(getApplicationContext());
//        try {
//            APL.setup(context);
//            APL.enableWifi();
//        } catch (Throwable e) {
//            LunaLog.e(e);
//        }


    }

    @Override
    protected void onResume() {
        super.onResume();
        //		StatService.onResume(this);
    }


    /**
     * Dispatch onPause() to fragments.
     */
    @Override
    protected void onPause() {
        super.onPause();
        //		StatService.onPause(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case REQ_CODE_ACTION_ACCESSIBILITY_SETTINGS:
                if (AccessibilityServiceUtil.isAccessibilitySettingsOn(this)) {
                    Toast.makeText(this, "成功开启辅助功能", Toast.LENGTH_SHORT).show();
                    // 打开京东应用设置详情页
                    // IntentUtil.openAppDetailSettingPage(this, Constants.PKG_NAME_JD);
                } else {
                    alertDialog("警告", "辅助功能开启失败，请找技术");
                }
                return;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    Handler printHandler = new Handler(Looper.getMainLooper()) {
        StringBuilder sb = new StringBuilder();

        @Override
        public void dispatchMessage(Message msg) {
            super.dispatchMessage(msg);

            if (mTvSysInfo != null && msg.obj instanceof String) {
                sb.append(msg.obj + "\n");
                mTvSysInfo.setText(sb.toString());
//                print.scrollTo(0,print.getHeight());
            }
        }
    };

    /**
     * 开启自动激活功能
     *
     * @param view
     */
    public void openAccessibilityService(View view) {
//        if (Build.VERSION.SDK_INT < 16) {
//            Toast.makeText(this, "失败，此功能仅支持Android 4.1以上系统", Toast.LENGTH_SHORT).show();
//            return;
//        }
//
//        // 判断辅助功能是否开启
//        if (!AccessibilityServiceUtil.isAccessibilitySettingsOn(this)) {
//            // 引导至辅助功能设置页面
//            startActivityForResult(new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS), REQ_CODE_ACTION_ACCESSIBILITY_SETTINGS);
//        } else {
//            Toast.makeText(this, "已经开启", Toast.LENGTH_SHORT).show();
//            // 打开京东应用设置详情页
//            openSuningScript();
//        }

        Intent intent = new Intent(context.getApplicationContext(), WebViewLoginService.class);
        context.startService(intent);

//        GoogleRegister register = new GoogleRegister(context,null,false);
//        ThreadUtils.execute(register);

    }

    public void onOpenGp(View view){
        final String appPackageName = getPackageName(); // getPackageName() from Context or Activity object
        try {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
        } catch (android.content.ActivityNotFoundException anfe) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
        }
    }

    /**
     * 打印默认的系统信息
     *
     * @param view
     */
    public void onPrintDefSysInfoBtnClick(View view) {
        mTvSysInfo.setText(
                String.format("默认每份设备参数报表有1000条\n当前已经使用到第%d行的设备参数\n\n", PositionSpUtil.getInt(MainActivity.this, "position",
                        0)));
        mTvSysInfo.append(SysInfo.getAllSimulatorSysInfo(this));

        MidService.enableDebug(true);
        //		mTvSysInfo.append("\n\nStatConfig get方法获取的腾讯mid: " + StatConfig.getMid(this));
        mTvSysInfo.append("\n\nMidService get方法获取的腾讯mid: " + MidService.getMid(this));
        MidService.requestMid(this, new MidCallback() {
            @Override
            public void onSuccess(final Object o) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mTvSysInfo.append("\n\nMidService request方法获取的腾讯mid: " + o +
                                (MidService.isMidValid(o.toString()) ? "  有效" : "  无效"));
                    }
                });
            }


            @Override
            public void onFail(final int i, final String s) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mTvSysInfo.append("\n\nMidService request方法获取的腾讯mid: 失败 " + i + "  " + s);
                    }
                });
            }
        });

        // TODO 后续考虑支持输出特定app部分数据修改后的值
    }

    /**
     * 从sd卡中的一份文件中，读取‘新’用户的设备信息，然后保存到sp文件中，{@link com.tools.hackandroid.xposed.XposedHooker} 会在init
     * 的时候读取这个sp文件然后获取其中的数值，最后就模拟这些数值
     *
     * @param view
     */
    public void onModifyDefSysInfoBtnClick(View view) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                int currentLineNumber = PositionSpUtil.getInt(MainActivity.this, "position", 0);
                int newLineNumber = currentLineNumber + 1;
                newLineNumber = newLineNumber > 1 ? newLineNumber : 1;

                // 读取新的数据
                String newData = FileUtil.getStringFromFileWithSpecLineNumber(
                        Environment.getExternalStorageDirectory().getPath() + "/123/device.txt", newLineNumber);
                Log.d("luna", "data  " + newLineNumber + ": " + newData);
                if (!TextUtils.isEmpty(newData)) {
                    // 更新当前读取到多少行
                    PositionSpUtil.putInt(MainActivity.this, "position", newLineNumber);
                } else {
                    // 可能已经全部读取完毕了，即数据已经用完，没有返回值，这个时候要提示数据用完了
                    PositionSpUtil.putInt(MainActivity.this, "position", -1);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            AlertDialog dialog =
                                    new AlertDialog.Builder(MainActivity.this).setTitle("警告").setMessage("数据已经用完，请找技术").create();
                            dialog.setCanceledOnTouchOutside(false);
                            dialog.show();
                        }
                    });
                    return;
                }


                DLog.i("urldecode 之前: %s", newData);
                String afterDecodeData = URLDecoder.decode(newData);
                DLog.i("urldecode 之后: %s", afterDecodeData);
                String[] keyValueStringArray = afterDecodeData.split("&");

                new UnSpecifiedSp().initDataFromKeyValueStringArray(MainActivity.this, keyValueStringArray);
                new BatterySp().initDataFromKeyValueStringArray(MainActivity.this, keyValueStringArray);
                new BuildSp().initDataFromKeyValueStringArray(MainActivity.this, keyValueStringArray);
                new BuildVersionSp().initDataFromKeyValueStringArray(MainActivity.this, keyValueStringArray);
                new ConnectivityManagerSp().initDataFromKeyValueStringArray(MainActivity.this, keyValueStringArray);
                new DisplaySp().initDataFromKeyValueStringArray(MainActivity.this, keyValueStringArray);
                new LocaleSp().initDataFromKeyValueStringArray(MainActivity.this, keyValueStringArray);
                new SystemPropertiesSp().initDataFromKeyValueStringArray(MainActivity.this, keyValueStringArray);
                new TelephonyManagerSp().initDataFromKeyValueStringArray(MainActivity.this, keyValueStringArray);
                new WIfiManagerSp().initDataFromKeyValueStringArray(MainActivity.this, keyValueStringArray);

//                new WeipinhuiSp().initRandomData(MainActivity.this);
//                new TencentSp().initRandomData(MainActivity.this);
                //				new UnSpecifiedSp().initTestData(MainActivity.this);
                //				new BatterySp().initTestData(MainActivity.this);
                //				new BuildSp().initTestData(MainActivity.this);
                //				new BuildVersionSp().initTestData(MainActivity.this);
                //				new ConnectivityManagerSp().initTestData(MainActivity.this);
                //				new DisplaySp().initTestData(MainActivity.this);
                //				new LocaleSp().initTestData(MainActivity.this);
                //				new SystemPropertiesSp().initTestData(MainActivity.this);
                //				new TelephonyManagerSp().initTestData(MainActivity.this);
                //				new WIfiManagerSp().initTestData(MainActivity.this);

                alertDialog("消息", "修改成功");
                ShellUtils.execCommand("pm clear " + "net.luna.poketool", true);
            }
        }).start();

    }

    /**
     * 清理sd卡信息
     *
     * @param view
     */
    public void onClearSdCardBtnClick(View view) {

        final ProgressDialog dialog = new ProgressDialog(this);
        dialog.setTitle("清理sd卡(第一次可能需要比较久)");
        //		dialog.setMax(100);
        //		dialog.setProgress(0);
        dialog.setIndeterminate(false);  //显示具体的进度
        dialog.setMessage("清理中...");
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        //		dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
        new Thread(new Runnable() {

            @Override
            public void run() {
                File root = Environment.getExternalStorageDirectory();
                for (File f : root.listFiles()) {
                    if ("123".equals(f.getName())) {
                        DLog.i("跳过 --> %s", f.getName());
                        continue;
                    }

                    if ("Android".equals(f.getName())) {
                        for (File file : f.listFiles()) {
                            DLog.i("删除 --> %s", file.getAbsolutePath());
                            ShellUtils.execCommand("rm -rf " + file.getAbsolutePath(), true);
                        }
                        continue;
                    }

                    DLog.i("删除 --> %s", f.getAbsolutePath());
                    ShellUtils.execCommand("rm -rf " + f.getAbsolutePath(), true);
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        dialog.cancel();
                        Toast.makeText(MainActivity.this, "清理完成", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }).start();
    }

    public void onGoogleCleanInfo(View onClick) {
        OutputStream out = null;
        try {
            ProcessBuilder pb = new ProcessBuilder().redirectErrorStream(true).command("su");
            Process p = pb.start();
            StreamReader stdoutReader = new StreamReader(p.getInputStream(), "utf-8");
            stdoutReader.start();

            out = p.getOutputStream();

            List<String> pns = new ArrayList<String>();
            pns.add("com.google.android.gsf.login");
            pns.add("com.google.android.gsf");
            pns.add("com.google.android.gms");
            pns.add("com.android.vending");
            pns.add("com.google.android.feedback");
            pns.add("com.google.android.syncadapters.bookmarks");
            pns.add("com.google.android.syncadapters.calendar");
            pns.add("com.google.android.syncadapters.contacts");

            PackageManager pm = getPackageManager();
            for (String pn : pns) {
                try {
                    pm.getPackageInfo(pn, 0);
                    out.write(("pm clear " + pn + "\n").getBytes("utf-8"));
                } catch (Exception e) {
                    //e.printStackTrace();
                    Log.v("test", "not found pn " + pn);
                }
            }

            out.write("exit\n".getBytes("utf-8"));
            out.flush();

            p.waitFor();
            String result = stdoutReader.getResult();
            Log.v("test", "the clear app data result is " + result);
            Toast.makeText(this, "清理完成", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(this, "清理出错", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    private void alertDialog(final String title, final String msg) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new AlertDialog.Builder(MainActivity.this).setTitle(title).setMessage(msg).create().show();
            }
        });
    }

    public static void showPopup(final String msg) {
        context.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(context.getBaseContext(), msg, Toast.LENGTH_SHORT).show();
                DLog.d(msg);

            }
        });
    }

    @Override
    protected void onDestroy() {
        String[] str = mPhoneNoEdit.getText().toString().split(",");
        if (str.length > 0) {
            PreferencesUtils.putString(context, Constants.SP_PHONE_NO, str[0]);
        }
        if (str.length > 1) {
            PreferencesUtils.putString(context, Constants.SP_ORI_IP, str[1]);
        }


        super.onDestroy();
    }
}
