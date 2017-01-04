package com.amigo.gms;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.UserHandle;
import android.os.UserManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Enumeration;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class MainActivity extends AppCompatActivity {

    public static String TAG = "AmigoGms";
    private static Pattern ESN_PATTERN = Pattern.compile("^([0-9a-fA-F]{8})$");
    private static Pattern DEVICE_ID_PATTERN = Pattern.compile("^(([0-9]{15})|([0-9a-fA-F]{14}))$");
    private static Pattern MAC_ADDR_PATTERN = Pattern.compile("^([0-9a-fA-F][0-9a-fA-F][:-]?){5}[0-9a-fA-F][0-9a-fA-F]$");
    ConnectivityManager cm;
    TelephonyManager tm;
    WifiManager wm ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String radioVersion = getRadioVersion();
        Toast.makeText(this,radioVersion,Toast.LENGTH_LONG).show();
        Log.d("radio",radioVersion);
        getOtacerts();

        cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        tm = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        wm = (WifiManager) getSystemService(Context.WIFI_SERVICE);

        logTm();
        logScreen();
    }

    public void logScreen(){
        WindowManager windowManager = (WindowManager)getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        Log.d(TAG,"sd:"+displayMetrics.densityDpi);
        Log.d(TAG,"sw:"+displayMetrics.widthPixels);
        Log.d(TAG,"sh:"+displayMetrics.heightPixels);
        ConfigurationInfo deviceConfigurationInfo = ((ActivityManager) getSystemService(Context.ACTIVITY_SERVICE)).getDeviceConfigurationInfo();
        Log.d(TAG,"gle:"+deviceConfigurationInfo.reqGlEsVersion);
    }

    public void logDigest(){
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void logTm(){
        String id = tm.getDeviceId();
        Log.d(TAG,"deviceId:"+id);
        int phoneType = getCurrentPhoneType(tm);
        Log.d(TAG,"phoneType:"+phoneType);
        switch (phoneType) {
            case 0:
                break;
            case 2:
                if (id != null && ESN_PATTERN.matcher(id).matches()) {
                    if (id.substring(0, 2) != "80") {
                        Log.d(TAG,"esn:"+id);
                        break;
                    } else {
                        Log.e(TAG, "TelephonyManager.getDeviceId() is returning a pseudo-ESN instead of an MEID");
                        break;
                    }
                }
            case 1:
                if (id != null) {
                    if (!DEVICE_ID_PATTERN.matcher(id).matches()) {
                        Log.e(TAG, "TelephonyManager.getDeviceId() must return a 15-decimal-digit IMEI, a 14-hex-digit MEID or an 8-hex-digit ESN ");
                        break;
                    } else {
                        Log.d(TAG,"meid:"+id);
                        break;
                    }
                }
                break;
            default:
                Log.w("CheckinRequestBuilder", "Unknown phone type: " + phoneType + " id=" + id);
                break;
        }
        String cell = tm.getNetworkOperator();
        if (!TextUtils.isEmpty(cell)) {
            Log.d(TAG,"cellOperator:"+cell);
        }
        String sim = tm.getSimOperator();
        if (!TextUtils.isEmpty(sim)) {
            Log.d(TAG,"simOperator:"+sim);
        }

        NetworkInfo ni = cm.getNetworkInfo(9);
        if (ni != null) {
            String hwAddr = ni.getExtraInfo();
            if (hwAddr != null && MAC_ADDR_PATTERN.matcher(hwAddr).matches()) {
                Log.d(TAG,"hwAddr:"+hwAddr.replace(":", "").replace("-", ""));
                Log.d(TAG,"ethernet");
            }
        }
        ni = cm.getNetworkInfo(0);
        String isMobile = ni == null ? "unknown" : ni.getType() == 0 ? "mobile" : "notmobile";
        String isRoaming = tm == null ? "unknown" : tm.isNetworkRoaming() ? "roaming" : "notroaming";
        Log.d(TAG,"roaming:"+(isMobile + "-"+isRoaming));
        if (wm != null) {
            WifiInfo wi = wm.getConnectionInfo();
            if (wi != null) {
                String mac = wi.getMacAddress();
                if (mac != null) {
                    Log.d(TAG,"macAddr:"+mac);
                    Log.d(TAG,"macAddr:"+mac.replaceAll(":", ""));
                    Log.d(TAG,"macAddrType:wifi");
                }
            }
        }
    }

    private static int getCurrentPhoneType(TelephonyManager tm) {
        try {
            return ((Integer) tm.getClass().getMethod("getCurrentPhoneType", new Class[0]).invoke(tm, new Object[0])).intValue();
        } catch (Throwable th) {
            return tm.getPhoneType();
        }
    }


    public void getOtacerts() {
        NoSuchAlgorithmException e2;
        Throwable th;
        ZipFile zip = null;
        int count = 0;
        try {
            ZipFile zip2 = new ZipFile("/system/etc/security/otacerts.zip");
            Enumeration<? extends ZipEntry> entries = zip2.entries();
            byte[] temp = new byte[2048];
            while (entries.hasMoreElements()) {
                InputStream is = zip2.getInputStream((ZipEntry) entries.nextElement());
                MessageDigest md = MessageDigest.getInstance("SHA-1");
                while (true) {
                    int read = is.read(temp);
                    if (read <= 0) {
                        break;
                    }
                    md.update(temp, 0, read);
                }
                Log.d("otacerts",Base64.encodeToString(md.digest(), 2));
                count++;
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
    private static String getRadioVersion() {
        try {
            Class c = Class.forName("android.os.Build");
            return (String) c.getMethod("getRadioVersion", new Class[0]).invoke(c, new Object[0]);
        } catch (Throwable th) {
            return Build.RADIO;
        }
    }

}
