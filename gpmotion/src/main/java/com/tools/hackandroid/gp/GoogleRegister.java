package com.tools.hackandroid.gp;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.net.wifi.WifiConfiguration;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;

import com.tools.hackandroid.GlobalSettings;
import com.tools.hackandroid.gp.account.AccountInfoBuilder;
import com.tools.hackandroid.gp.account.RegisterAccount;
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
import com.tools.hackandroid.sp.third.TencentSp;
import com.tools.hackandroid.sp.third.WeipinhuiSp;
import com.tools.hackandroid.util.AESCipher;
import com.tools.hackandroid.util.DLog;
import com.tools.hackandroid.util.FileUtil;
import com.tools.hackandroid.util.RandomUtil;
import com.tools.hackandroid.util.StreamReader;

import net.luna.common.debug.LunaLog;
import net.luna.common.entity.HttpRequest;
import net.luna.common.entity.HttpResponse;
import net.luna.common.util.HttpUtils;
import net.luna.common.util.JSONUtils;
import net.luna.common.util.NetWorkUtil;
import net.luna.common.util.RandomUtils;
import net.luna.common.util.StringUtils;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

import be.shouldit.proxy.lib.APL;
import be.shouldit.proxy.lib.APLNetworkId;
import be.shouldit.proxy.lib.WiFiApConfig;
import be.shouldit.proxy.lib.reflection.android.ProxySetting;
import picture.PictureVerificationCodeUtil;
import vpn.VpnController;


/**
 * Created by bintou on 16/8/8.
 */
public class GoogleRegister implements Runnable {

    private static String ORI_IP = "114.37.108.101";
    private static final String BACKEND_CHECKAVAIL_PATH = "https://android.clients.google.com/setup/checkavail";
    private static final String BACKEND_RATEPW_PATH = "https://android.clients.google.com/setup/ratepw";
    private static final String BACKEND_CREATE_PATH = "https://android.clients.google.com/setup/create";
    private static final String SERVER_PROTOCOL_VERSION = "3";

    private String dirName = "/gregister/";

    Handler webHandler;
    JSONObject createJo;
    String captchaToken;
    String androidid;
    String mccmnc;
    String operatorName;

    String versionName = "5.8.11";
    String versionCode = "80381100";
    String country;
    Context context;
    private File recordfile;
    int retryRequestCaptchaCount = 0;
    boolean changeIp;
    List<String> blackList;
    String area = "";
    String ip = null;
    String imei;
    ArrayList<String> uselessImei;
    String loginEmail = "huangchaosysu@gmail.com";
    String loginPassword = "vegetta_1988";


    public GoogleRegister(Context context, Handler webHandler, boolean changeIp) {
        this.webHandler = webHandler;
        this.context = context;
        this.changeIp = changeIp;
        uselessImei = new ArrayList<>();
        if (!StringUtils.isBlank(GlobalSettings.oriIp)) {
            ORI_IP = GlobalSettings.oriIp;
            LunaLog.d("ORI_IP :" + ORI_IP);
        }
    }


    @Override
    public void run() {
//        synchronized (this) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
        Date curDate = new Date(System.currentTimeMillis());//获取当前时间
        String dataStr = formatter.format(curDate);
        LunaLog.e(dataStr);

        LunaLog.d("开始运行,version : 1.20");

        LunaLog.d("切换IP中。。。");

        if (GlobalSettings.isHomeland) {
            LunaLog.d(" 国内IP,打开VPN");
            VpnController vpnController = VpnController.getInstance(context);
            vpnController.stopVpn();
            String server = "218.2.35.94";
            String vpnUsername = "bb26";
            String vpnPassword = "123321";
            String dns1 = "8.8.8.8";
            String dns2 = "8.8.4.4";

            vpnController.setProfile(server, vpnUsername, vpnPassword, dns1, dns2, true);
            if (vpnController.startVpn()) {
                LunaLog.d("打开VPN成功");
            } else {
                LunaLog.d("打开VPN失败");
            }
        } else if (GlobalSettings.isUserProxy) {
            changeProxy();
        } else {
            try {
                String ipChangeResult = HttpUtils.httpGetString("http://52.78.211.58:8080/change_ip");
                if (ipChangeResult != null && ipChangeResult.contains("ip not match")) {
                    LunaLog.d("请先切换到指定IP");
                }
            }catch (Exception e){
                LunaLog.e(e.getMessage());
            }
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        registerProcess();
//        }
    }

    public void initBlackList() {
        try {
            File blackListFile = Environment.getExternalStoragePublicDirectory("/gregister/blackList.txt");
            blackList = FileUtil.getAllLineStringFromFile(blackListFile);
            if (blackList == null) {
                blackList = new ArrayList<String>();
            }
        }catch (Exception e){
            LunaLog.e(e.getMessage());
        }
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

    private void registerProcess() {


        int checkNetworkCount = 0;


        if (!GlobalSettings.isUserProxy) {
            LunaLog.d("检测IP");
            while (StringUtils.isBlank(ip)) {
                try {
                    ip = NetWorkUtil.getNetIp(context);
                    LunaLog.d("当前ip:"+ip);
                    area = NetWorkUtil.getIpCountry(context,ip);
                    LunaLog.d("ip: " + ip + "  area : " + area);
                    checkNetworkCount++;
                    if (checkNetworkCount > 20) {
                        LunaLog.d("无效IP,上不了网");
                        run();
                        return;
                    }
                    Thread.sleep(3000);
                } catch (Exception e) {
                    LunaLog.e(e);
                }
            }
        }

        mccmnc = "45403";
        operatorName = "Hutchison 3G";
        Locale myLocale = new Locale("en", "US");
        country = myLocale.getCountry();
        LunaLog.d("开始运行");
        Random random = new Random();
        int ran = random.nextInt(6000);
        DeviceInfo deviceInfo = DeviceInfo.getDeviceInfo(context, ran);

        modifyDefSysInfo(deviceInfo);

        loginEmail = null;
        loginPassword = null;

        int retryGetAccountCount = 0;
        while (loginEmail == null && retryGetAccountCount < 3) {
            retryGetAccountCount++;
            getLoginAccount();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (loginEmail == null) {
            run();
            return;
        }

        LunaLog.d("登录有效账号,生成Auth...使用账号: " + loginEmail + "    " + loginPassword + "     " + androidid);
        String gsfAuth = null;


        if (!GlobalSettings.isHomeland) {
            try {
                gsfAuth = AndroidAndAuthUtil.loginGSF(loginEmail, loginPassword, deviceInfo, versionName, versionCode, myLocale.getCountry());

            } catch (Exception e) {
                LunaLog.e(e);
            }
            LunaLog.d("gsfAuth: " + gsfAuth);

            if (gsfAuth == null || "error".equals(gsfAuth)) {
                LunaLog.d("gsf account error -- " + loginEmail);
                LunaLog.d("切换IP重跑");
                if (gsfAuth == null) {
                    run();
                } else {
                    registerProcess();
                }
                return;
            }

            LunaLog.d("生成Android...");
            try {
                androidid = AndroidAndAuthUtil.getAndroidId(gsfAuth, deviceInfo, mccmnc, myLocale, loginEmail)[0];

            } catch (Exception e) {
                LunaLog.e(e);
            }
            LunaLog.e("生成AndroidID ： " + androidid);
            if (androidid == null) {
                registerProcess();
                return;
            }
        }

        final RegisterAccount registerAccount = AccountInfoBuilder.getRegisterAccount(context, RandomUtils.getRandom(0, 1) > 0 ? true : false);
        registerAccount.recEmail = loginEmail;

        String ua = String.format("GoogleAuth/1.4 (%s %s)", deviceInfo.device, deviceInfo.id);
        Map<String, String> headers = new HashMap<>();
        headers.put("User-Agent", ua);
        headers.put("Content-Type", "text/plain; charset=UTF-8");

        registerAccount.androidId = androidid;
        registerAccount.area = area;
        String email = registerAccount.email;
        String psd = registerAccount.password;
        LunaLog.d("email: " + registerAccount.email + "  psw: " + registerAccount.password + "   name: " + registerAccount.firstName + " " + registerAccount.lastName);
        try {
//            JSONObject jsonObject = new JSONObject();
//            jsonObject.put("username", "JoaFitzpatrick2@gmail.com");
//            jsonObject.put("firstName", "LefeiL");
//            jsonObject.put("lastName", "jun");
//            request.setPostContent(jsonObject.toString());
//        request.setParasMap(postData);
//            String result = HttpUtils.httpPostString(BACKEND_CHECKAVAIL_PATH, jsonObject.toString());
//            if (result != null) {
//                LunaLog.d("result :" + result);
//            }
//
//            jsonObject.put("password", "livelyqueen3bce");
//            String result1 = HttpUtils.httpPostString(BACKEND_RATEPW_PATH, jsonObject.toString());
//            LunaLog.d("result1 :" + result1);

            createJo = new JSONObject();
            createJo.put("sdkVersion", deviceInfo.sdkVersion);
            createJo.put("gmsCoreVersion", 8703036);
            createJo.put("androidId", androidid); //脚本生成 机型其他
            createJo.put("username", email);
            createJo.put("version", "3");
            createJo.put("firstName", registerAccount.firstName);
            createJo.put("lastName", registerAccount.lastName);
            createJo.put("password", psd);
            createJo.put("agreeWebHistory", true);
            createJo.put("droidguard_results", "");
            createJo.put("sdkVersion", deviceInfo.sdkVersion);
            createJo.put("gmsCoreVersion", 8703036);
            createJo.put("locale", "zh_TW");
            createJo.put("operatorCountry", "");
            createJo.put("simCountry", "");

            if (uploadCaptcha(headers)) {
                String line = email + "," + psd + "," + registerAccount.area + "," + registerAccount.androidId;

                writeRecord(line);
                LunaLog.d("注册完成,等待30秒,激活账号...");
                registerAccount.ipId = imei;
                Message message = new Message();
                message.obj = registerAccount;
                message.what = WebViewLoginService.INIT;
                webHandler.sendMessageDelayed(message, 30000);
                return;
            }

        } catch (Exception e) {
            LunaLog.e(e);
        }
        run();
    }


    private boolean uploadCaptcha(Map<String, String> headers) {
        try {
            HttpRequest request = new HttpRequest(BACKEND_CREATE_PATH);
            request.setPostContent(createJo.toString());
            request.setRequestProperties(headers);
            HttpResponse captchaResponse = HttpUtils.httpPost(request);
            if (captchaResponse != null) {
                String result2 = captchaResponse.getResponseBody();
//                LunaLog.d("result2 :" + result2);
                JSONObject resultJo = JSONUtils.toJsonObject(result2);
                String captchaData = resultJo.optString("captchaData");
                captchaToken = resultJo.optString("captchaToken");
                String[] captchaResult = PictureVerificationCodeUtil.asyncGetPicCode(captchaData);

                if (captchaResult == null || captchaResult.length == 0) {
                    LunaLog.d("验证码结果为null,不正常!!!!!!!重新请求");
                    retryRequestCaptchaCount++;
                    if (retryRequestCaptchaCount < 3) {
                        return uploadCaptcha(headers);
                    } else {
                        changeIp = true;
                        retryRequestCaptchaCount = 0;
                        return false;
                    }
                }
                if (captchaResult != null && captchaResult.length > 0) {
                    String verifyCode = captchaResult[0];
                    LunaLog.d("验证码是:" + verifyCode);
                    createJo.put("captchaAnswer", verifyCode);
                    createJo.put("captchaToken", captchaToken);
                    request.setPostContent(createJo.toString());
                    HttpResponse finalrResponse = HttpUtils.httpPost(request);
                    if (finalrResponse == null) {
                        LunaLog.d("最终请求无响应,重新请求一次");
                        Thread.sleep(3000);
                        finalrResponse = HttpUtils.httpPost(request);
                        if (finalrResponse == null) {
                            LunaLog.d("最终请求依然无响应,重新注册");
                            changeIp = true;
                            return false;
                        }
                    }
                    String finalResult = finalrResponse.getResponseBody();

                    LunaLog.d("Sign Result: " + finalResult);
                    if (finalResult.contains("SUCCESS")) {
                        return true;
                    } else {
                        if (finalResult.contains("ADDRESS_NOT_AVAILABLE")) {
                            changeIp = true;
                            retryRequestCaptchaCount = 0;
                            return false;
                        }
                        retryRequestCaptchaCount++;
                        if (retryRequestCaptchaCount < 3) {
                            LunaLog.d("email: " + createJo.optString("username"));
                            LunaLog.d("验证码错误,重新请求");
                            createJo.remove("captchaAnswer");
                            createJo.remove("captchaToken");
                            return uploadCaptcha(headers);
                        } else {
                            changeIp = true;
                            retryRequestCaptchaCount = 0;
                            return false;
                        }
                    }
                }
            }
        } catch (Exception e) {
            LunaLog.e(e);
        }
        return false;
    }


    private void writeRecord(String line) {
        try {
            if (line == null) {
                return;
            }
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
            Date curDate = new Date(System.currentTimeMillis());//获取当前时间
            String dataStr = formatter.format(curDate);
            File dir = Environment.getExternalStoragePublicDirectory(dirName);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            if (recordfile == null) {
                recordfile = Environment.getExternalStoragePublicDirectory(dirName + "register.txt");
            }
            LunaLog.d("写入: " + line);
//            FileUtils.writeFile(recordfile.getAbsolutePath(), line, true);
            FileUtil.writeLine2File(recordfile, line);
        } catch (Exception e) {
            DLog.e(e);
        }
    }

    public void onGoogleCleanInfo() {
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

            PackageManager pm = context.getPackageManager();
            for (String pn : pns) {
                try {
                    pm.getPackageInfo(pn, 0);
                    out.write(("pm clear " + pn + "\n").getBytes("utf-8"));
                } catch (Exception e) {
                    //e.printStackTrace();
                    LunaLog.d("not found pn " + pn);
                }
            }

            out.write("exit\n".getBytes("utf-8"));
            out.flush();

            p.waitFor();
            String result = stdoutReader.getResult();
            LunaLog.d("the clear app data result is " + result);
            LunaLog.d("清理完成");
        } catch (Exception e) {
            LunaLog.d("清理出错");
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


    public void modifyDefSysInfo(DeviceInfo deviceInfo) {
        onGoogleCleanInfo();

        // 读取新的数据
        String newData = deviceInfo.toString();
        LunaLog.d("修改的数据" + newData);

        String afterDecodeData = URLDecoder.decode(newData);
        String[] keyValueStringArray = afterDecodeData.split(",");
        StringBuilder recordStr = new StringBuilder();
        for (int i = 0; i < keyValueStringArray.length; i++) {
            String str = keyValueStringArray[i];
            String[] kv = str.split("=", 2);
            if (kv.length != 2) {
                continue;
            }
            if (TextUtils.isEmpty(kv[0]) || TextUtils.isEmpty(kv[1])) {
                continue;
            }

            recordStr.append(keyValueStringArray[i] + " ");
        }

        writeRecord(recordStr.toString());


        new UnSpecifiedSp().initDataFromKeyValueStringArray(context, keyValueStringArray);
        new BatterySp().initDataFromKeyValueStringArray(context, keyValueStringArray);
        new BuildSp().initDataFromKeyValueStringArray(context, keyValueStringArray);
        new BuildVersionSp().initDataFromKeyValueStringArray(context, keyValueStringArray);
        new ConnectivityManagerSp().initDataFromKeyValueStringArray(context, keyValueStringArray);
        new DisplaySp().initDataFromKeyValueStringArray(context, keyValueStringArray);
        new LocaleSp().initDataFromKeyValueStringArray(context, keyValueStringArray);
        new SystemPropertiesSp().initDataFromKeyValueStringArray(context, keyValueStringArray);
        new TelephonyManagerSp().initDataFromKeyValueStringArray(context, keyValueStringArray);
        new WIfiManagerSp().initDataFromKeyValueStringArray(context, keyValueStringArray);


        new WeipinhuiSp().initRandomData(context);
        new TencentSp().initRandomData(context);

    }

    private void resetWifi() throws Exception {
        Map<APLNetworkId, WifiConfiguration> map = APL.getConfiguredNetworks();
        for (Map.Entry<APLNetworkId, WifiConfiguration> entry : map.entrySet()) {
            LunaLog.d("wifiConfiguration.ssid:" + entry.getValue().SSID);
            if (entry.getValue().SSID.contains("Ranking-HK")) {
                LunaLog.d("找到该ssid");
                WifiConfiguration configuration = entry.getValue();
                WiFiApConfig selectedWifiAp = new WiFiApConfig(configuration, ProxySetting.NONE, null, 0, null, Uri.EMPTY);

                APL.writeWifiAPConfig(selectedWifiAp, 1000, 5000);
                APL.enableWifi();
                return;
            }
        }
    }


    private void changeProxy() {
        //先重制WIFI,防止网络一直无法访问
        try {
            resetWifi();
        } catch (Exception e) {
            e.printStackTrace();
        }
//        sentIpBlackList();
        String portResult = null;
        while (portResult == null) {
            portResult = HttpUtils.httpGetString("http://seoul-proxy-load-balance-1294549866.ap-northeast-2.elb.amazonaws.com/gettunnel/");
            LunaLog.d("result: " + portResult);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            JSONArray array = JSONUtils.toJsonArray(portResult);
            if (array != null) {
                int port = 0;
                String hostIp = null;


                Map<APLNetworkId, WifiConfiguration> map = APL.getConfiguredNetworks();
                for (Map.Entry<APLNetworkId, WifiConfiguration> entry : map.entrySet()) {
                    LunaLog.d("wifiConfiguration.ssid:" + entry.getValue().SSID);
                    if (entry.getValue().SSID.contains("Ranking-HK")) {
                        LunaLog.d("找到该ssid");
                        for (int i = 0; i < array.length(); i++) {
                            port = array.optJSONObject(i).optInt("port");
                            hostIp = array.optJSONObject(i).optString("ip");
                            imei = array.optJSONObject(i).optString("imei");
                            LunaLog.d("PORT: " + port + "   hostIp: " + hostIp);

                            WifiConfiguration configuration = entry.getValue();
                            WiFiApConfig selectedWifiAp = new WiFiApConfig(configuration, ProxySetting.STATIC, hostIp, port, null, Uri.EMPTY);


                            APL.writeWifiAPConfig(selectedWifiAp, 1000, 5000);
                            APL.enableWifi();
                            LunaLog.d("检测IP");
                            Thread.sleep(5000);
                            int checkNetworkCount = 0;
                            ip = null;

                            while ((StringUtils.isBlank(ip) || ip.contains(ORI_IP)) && checkNetworkCount < 3) {// 台湾
                                try {
                                    ip = NetWorkUtil.getNetIp(context);
                                    area = NetWorkUtil.getIpCountry(context,ip);
                                    LunaLog.d("ip: " + ip + "  area : " + area);
                                    checkNetworkCount++;
                                    Thread.sleep(5000);
                                } catch (Exception e) {
                                    LunaLog.e(e);
                                }
                            }
                            if (!StringUtils.isBlank(ip) && !ip.contains(ORI_IP)) {
                                break;
                            } else {
                                uselessImei.add(imei);
                            }
                        }
                        if (!StringUtils.isBlank(ip) && !ip.contains(ORI_IP)) {
                            return;
                        }
                    }
                }
            }
        } catch (Exception e) {
            LunaLog.e(e);
        }
        sentIpBlackList();
        changeProxy();
    }

    private void sentIpBlackList() {
        if (uselessImei.size() > 0) {
            try {
                LunaLog.d("提交该IP进入黑名单");
                StringBuilder param = new StringBuilder();
                param.append("imeis=");
                for (String imei : uselessImei) {
                    param.append(imei + ",");
                }
                param.deleteCharAt(param.length() - 1);
                LunaLog.d("上传黑名单:" + param.toString());
                String encryStr = Base64.encodeToString(addPrefix(AESCipher.encrypt(param.toString().getBytes("utf-8"), "3Ce7671Ff686D51d".getBytes("utf-8"), "0123456789ABCDEF".getBytes("utf-8"))), Base64.NO_WRAP);
                String content = "s=" + encryStr;
                HttpRequest request = new HttpRequest("http://seoul-proxy-load-balance-1294549866.ap-northeast-2.elb.amazonaws.com/disconnectbylist/");
                request.setPostContent(content);

                HttpResponse response = HttpUtils.httpPost(request);
                if (response != null) {
                    String result = response.getResponseBody();
                    LunaLog.d("提交结果: " + result);
                    uselessImei.clear();
                }
            } catch (Exception e) {
                LunaLog.e(e);
            }
        }
    }

    private void getLoginAccount() {
        try {

            String result = HttpUtils.httpGetString("http://api.amigov.com/gmail/account/get_random/");
            LunaLog.d("result: " + result);
            if (!StringUtils.isBlank(result)) {
                JSONObject loginAccountJo = JSONUtils.toJsonObject(result);
                loginEmail = loginAccountJo.optString("Email");
                loginPassword = loginAccountJo.optString("Password");
                androidid = loginAccountJo.optString("Andid");
                LunaLog.d("EMAIL : " + loginEmail + "  pwd:" + loginPassword + " androidid: " + androidid);
            }
        } catch (Exception e) {
            LunaLog.e(e);
        }
        if (loginEmail == null) {
            File activeFile = Environment.getExternalStoragePublicDirectory(dirName + "active.txt");
            List<String> activeList = FileUtil.getAllLineStringFromFile(activeFile);
            if (activeList != null && activeList.size() > 0) {
                boolean isValid = false;
                while (!isValid) {
                    int ranActive = RandomUtil.getRandomNumber(0, activeList.size() - 1);
                    String line = activeList.get(ranActive);
                    LunaLog.d("读取已激活的账号" + line);
                    String[] ary = line.split(",");
                    loginEmail = ary[1];
                    loginPassword = ary[2];
                    androidid = ary[4];
                    if (!blackList.contains(loginEmail)) {
                        isValid = true;
                        LunaLog.d("不再黑名单上");
                    } else {
                        LunaLog.d("该账号在黑名单上");
                    }
                }
            }
        }
    }

}

