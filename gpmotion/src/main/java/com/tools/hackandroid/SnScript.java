package com.tools.hackandroid;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;

import com.tools.hackandroid.accessibility.handler.suning.SNHandler;
import com.tools.hackandroid.proxy.ProxyChangeAsync;
import com.tools.hackandroid.proxy.ProxyChangeParams;
import com.tools.hackandroid.proxy.ProxyConnectionListener;
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
import com.tools.hackandroid.util.DLog;
import com.tools.hackandroid.util.FileUtil;
import com.tools.hackandroid.util.IntentUtil;
import com.tools.hackandroid.util.PositionSpUtil;
import com.tools.hackandroid.util.RandomDeviceInfoGenerator;
import com.tools.hackandroid.util.ShellUtils;

import net.luna.common.util.HttpUtils;
import net.luna.common.util.NetWorkUtil;
import net.luna.common.util.StringUtils;
import net.luna.common.util.ThreadUtils;

import java.io.File;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeoutException;

import be.shouldit.proxy.lib.APL;

/**
 * Created by bintou on 16/9/20.
 */

public class SnScript implements Runnable {

    private Context context;
    public int curCount = 0;
    public int totalCount = 0;
    private File recordfile;

    private int errorCount = 0;
    private String currentip;

    class Proxy {
        String host;
        String port;
    }

    private Proxy curentProxy;

    ArrayBlockingQueue<Proxy> proxyQueue = new ArrayBlockingQueue<>(5);

    ProxyChangeAsync proxyChangeAsync;
    ProxyConnectionListener listener = new ProxyConnectionListener() {
        @Override
        public void onConnectSuccess() {
            DLog.d("切换代理成功");
            String ip = NetWorkUtil.getNetIp(context);
            DLog.d("ip: " + ip);

            if (StringUtils.isBlank(ip)) {
                DLog.d("ip为空或没生效,重新切换IP");
                startProcess();
            } else {
                String test = HttpUtils.httpGetString("https://sset.suning.com/sslserver/device/binding.do");
                if (test == null) {
                    DLog.d("请求苏宁的连接失败");
                    DLog.d("test: " + test);
                    startProcess();
                    return;
                }

                curCount++;

                ShellUtils.execCommand("adb shell am force-stop " + Constants.PKG_NAME_SUNING + " sleep 1", true);
                ShellUtils.execCommand("pm clear " + Constants.PKG_NAME_SUNING + " sleep 1;", true);

                ShellUtils.execCommand("rm -r " + SUNING_FILE, true);

                modifyDefSysInfo();

                IntentUtil.startActivityByPackageName(context, Constants.PKG_NAME_SUNING);
                DLog.d("执行第" + curCount + "次");
            }
        }

        @Override
        public void onConnectFail() {
            DLog.d("切换IP失败,重新执行这个IP");
//            changeProxy(proxyQueue.poll());
            errorCount++;
            if (errorCount < 3) {
                proxyQueue.offer(curentProxy);
            } else {
                errorCount = 0;
            }
            startProcess();
        }

        @Override
        public void onConnectError() {
            DLog.d("切换IP失败,因为网络或者其他原因。");
            net.luna.common.util.ThreadUtils.execute(new Runnable() {
                @Override
                public void run() {
                    startProcess();
                }
            });
        }
    };

    private Handler handler = new Handler() {
        @Override
        public void dispatchMessage(Message msg) {
            super.dispatchMessage(msg);
            if (msg.what == 1) {
                ThreadUtils.execute(SnScript.this);
            } else if (msg.what == 2) {
                IntentUtil.startActivityByPackageName(context, Constants.PKG_NAME_SUNING);
            }
        }
    };


    public final String SUNING_FILE = String.valueOf(Environment.getExternalStoragePublicDirectory("/suning.ebuy"));

    public SnScript(Context context, int totalCount) {
        this.context = context;
        this.totalCount = totalCount;
        SNHandler.setHandler(handler);
    }


    private void writeRecord(String str) {
        try {
            if (str == null) {
                return;
            }
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
            Date curDate = new Date(System.currentTimeMillis());//获取当前时间
            String dataStr = formatter.format(curDate);
            if (recordfile == null) {
                recordfile = Environment.getExternalStoragePublicDirectory("/123/activeRecord.txt");
            }
            String line = String.format("%s ip=%s %s", dataStr, currentip, str);
            DLog.d("写入: " + line);
//            FileUtils.writeFile(recordfile.getAbsolutePath(), line, true);
            FileUtil.writeLine2File(recordfile, line);
        } catch (Exception e) {
            DLog.e(e);
        }
    }


    private void resetProxy() {

//        Intent intent = new Intent();
//        intent.putExtra(ProxyChangeParams.SSID, "Ym-Tech");
//        intent.putExtra(ProxyChangeParams.KEY, "youmijishu");
////        intent.putExtra(ProxyChangeParams.SSID, "youmi");
////        intent.putExtra(ProxyChangeParams.KEY, "www.youmi.net");
//        intent.putExtra(ProxyChangeParams.CLEAR, true);
////        intent.putExtra(ProxyChangeParams.RESET_WIFI, true);
//
//        new ProxyChangeAsync((Activity) context, null).execute(intent);
        DLog.d("重置WIFI");
        clearWifiConfigs();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            connectToWifiNetwork();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clearWifiConfigs() {
        APL.setup(context);
        WifiManager wifiManager = APL.getWifiManager();
        try {
            // remove the existing configurations to ensure that the newly inserted one is the only one
            for (WifiConfiguration wifiConfiguration : wifiManager.getConfiguredNetworks()) {
                wifiManager.removeNetwork(wifiConfiguration.networkId);
            }
        } catch (Exception e) {
        }
        try {
            APL.enableWifi();
        } catch (Exception e) {
        }
        wifiManager.saveConfiguration();
    }

    private void startProcess() {
        DLog.d("startProcess");
//        resetProxy();

        if (curCount > totalCount) {
            return;
        }
        /**
         * 清理目标应用的数据
         */


//        if (proxyQueue.size() <= 0) {
//            getIpFromTPV();
//        }
        //        curentProxy = proxyQueue.poll();
//        changeProxy(curentProxy);


        HttpUtils.httpGet("http://proxy.abuyun.com/switch-ip");
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        currentip = NetWorkUtil.getNetIp(context);

        DLog.d("切换到IP: " + currentip);

        curCount++;

        modifyDefSysInfo();

        ShellUtils.execCommand("adb shell am force-stop " + Constants.PKG_NAME_SUNING + " sleep 1", true);
        ShellUtils.execCommand("pm clear " + Constants.PKG_NAME_SUNING + " sleep 1;", true);

        ShellUtils.execCommand("rm -r " + SUNING_FILE, true);


        IntentUtil.startActivityByPackageName(context, Constants.PKG_NAME_SUNING);
        DLog.d("执行第" + curCount + "次");


    }

    private void getIpFromTPV() {
        try {
            DLog.e("请求收费IP: ");
            String result = HttpUtils.httpGetString("http://tpv.daxiangip.com/ip/?tid=557041685220736&num=2&category=2&protocol=https&foreign=none&filter=on");
            DLog.e("" + result);
            String[] proxys = result.split("\n");
//            DLog.d("proxys: "+proxys[0]+"  "+proxys[1]);
            for (int i = 0; i < proxys.length; i++) {
                try {
                    Proxy proxy = new Proxy();
                    String[] str = proxys[i].split(":");
                    proxy.host = str[0];
                    proxy.port = str[1];
                    DLog.d("getIP : " + proxy.host + ":" + proxy.port);
                    proxyQueue.offer(proxy);
                } catch (Exception e) {
                    DLog.e(e);
                }
            }
            return;
        } catch (Exception e) {
            DLog.e(e);
            resetProxy();

        }
        listener.onConnectError();
    }


    private void changeProxy(Proxy proxy) {


        if (proxy != null) {
            if (proxyChangeAsync == null) {
                proxyChangeAsync = new ProxyChangeAsync((Activity) context, listener);
            }
            DLog.d("current proxy : " + proxy.host + " : " + proxy.port);

            Intent intent = new Intent();
//            intent.putExtra(ProxyChangeParams.HOST, "172.16.7.3");
//            intent.putExtra(ProxyChangeParams.PORT, "8888");
            intent.putExtra(ProxyChangeParams.HOST, proxy.host);
            intent.putExtra(ProxyChangeParams.PORT, proxy.port);
            intent.putExtra(ProxyChangeParams.SSID, "Ym-Tech");
            intent.putExtra(ProxyChangeParams.KEY, "youmijishu");
//            intent.putExtra(ProxyChangeParams.RESET_WIFI, true);
            intent.putExtra(ProxyChangeParams.CLEAR, true);

            proxyChangeAsync.execute(intent);
        } else {
            listener.onConnectError();
        }
    }


    public void modifyDefSysInfo() {

        int currentLineNumber = PositionSpUtil.getInt(context, "position", 70);
        int newLineNumber = currentLineNumber + 1;
        newLineNumber = newLineNumber > 1 ? newLineNumber : 1;

        // 读取新的数据
        String newData = FileUtil.getStringFromFileWithSpecLineNumber(
                Environment.getExternalStorageDirectory().getPath() + "/123/device.txt", newLineNumber);


        Log.d("luna", "更改数据  " + newLineNumber + ": " + newData);
        if (!TextUtils.isEmpty(newData)) {
            // 更新当前读取到多少行
            PositionSpUtil.putInt(context, "position", newLineNumber);
        } else {
            // 可能已经全部读取完毕了，即数据已经用完，没有返回值，这个时候要提示数据用完了
            PositionSpUtil.putInt(context, "position", -1);
            ThreadUtils.runInUiThread(new Runnable() {
                @Override
                public void run() {
                    AlertDialog dialog =
                            new AlertDialog.Builder(context).setTitle("警告").setMessage("数据已经用完，请找技术").create();
                    dialog.setCanceledOnTouchOutside(false);
                    dialog.show();
                }
            });
            return;
        }


        String afterDecodeData = URLDecoder.decode(newData);
        String[] keyValueStringArray = afterDecodeData.split("&");
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
            switch (kv[0]) {
                case "andid":
                    keyValueStringArray[i] = "andid=" + RandomDeviceInfoGenerator.getAndroidId();
                    break;
                case "ei":
                    keyValueStringArray[i] = "ei=" + RandomDeviceInfoGenerator.getIMEI();
                    break;
                case "si":
                    keyValueStringArray[i] = "si=" + RandomDeviceInfoGenerator.getImsi();
                    break;
                case "mac":
                    keyValueStringArray[i] = "mac=" + RandomDeviceInfoGenerator.getMac();
                    break;

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


    @Override
    public void run() {
        DLog.e("version 14");

        startProcess();
    }

    private void connectToWifiNetwork() throws Exception {
        DLog.d("connectToWifiNetwork");
        WifiManager wifiManager = APL.getWifiManager();
        // create new config with given ssid and key and connect to it
        WifiConfiguration wifiConfiguration = new WifiConfiguration();
        wifiConfiguration.SSID = "\"" + "Ym-Tech" + "\"";
        wifiConfiguration.preSharedKey = "\"" + "youmijishu" + "\"";
        int netId = wifiManager.addNetwork(wifiConfiguration);
        if (netId < 0) {
            netId = wifiManager.updateNetwork(wifiConfiguration);
            if (netId < 0) {
                proxyChangeAsync.onProgressUpdate("Having trouble resetting wifi, hard resetting...");
                APL.disableWifi();
                APL.enableWifi();
                try {
                    waitForWifiConnectivity();
                } catch (Exception e) {
                    DLog.d("Timeout when trying to hard reset wifi", e);
                }
                netId = wifiManager.addNetwork(wifiConfiguration);
                if (netId < 0) {
                    throw new RuntimeException("Unable to add or update network configuration for Ym-Tech");
                }
            }
        }

        wifiManager.saveConfiguration();
        wifiManager.disconnect();
        wifiManager.enableNetwork(netId, true);
        wifiManager.reconnect();
        try {
            waitForWifiConnectivity();
        } catch (Exception e) {
            DLog.d("Timeout when trying to hard reset wifi", e);
        }
    }

    private void waitForWifiConnectivity() throws TimeoutException {
        long timeout = 10000;
        long sleepTime = 2000;
        do {
            try {
                Thread.sleep(sleepTime);
            } catch (Exception e) {
                // no-op
            }
            timeout -= sleepTime;
        } while (timeout > 0 && !NetWorkUtil.isWifiAvailable());
        if (!NetWorkUtil.isWifiAvailable()) {
            throw new TimeoutException("Timeout while waiting for wifi to connect");
        }
    }

}
