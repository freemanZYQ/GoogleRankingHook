package com.vlocker.m;

import android.content.Context;
import android.net.ConnectivityManager;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage.IMediaObject;
import java.lang.reflect.Method;
import java.text.DecimalFormat;

public class ag {
    private static DecimalFormat a = new DecimalFormat("#.##");

    private static int a(int i) {
        switch (i) {
            case -101:
                return -101;
            case -1:
                return -1;
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                return 1;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case IMediaObject.TYPE_OLD_TV /*14*/:
            case 15:
            case IMediaObject.TYPE_LOCATION_SHARE /*17*/:
                return 2;
            case 13:
                return 3;
            default:
                return 0;
        }
    }

    public static String a(Context context) {
        String str = "未知";
        switch (e(context)) {
            case -101:
                return "Wi-Fi";
            case -1:
                return "无";
            case 0:
                return "未知";
            case 1:
                return "2G";
            case 2:
                return "3G";
            case 3:
                return "4G";
            default:
                return str;
        }
    }

    public static boolean b(Context context) {
        return ((TelephonyManager) context.getSystemService("phone")).getSimState() == 5;
    }

    public static boolean c(Context context) {
        return System.getInt(context.getContentResolver(), "airplane_mode_on", 0) == 1;
    }

    public static boolean d(Context context) {
        if (b(context)) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            try {
                Method method = ConnectivityManager.class.getMethod("getMobileDataEnabled", new Class[0]);
                method.setAccessible(true);
                return ((Boolean) method.invoke(connectivityManager, new Object[0])).booleanValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    private static int e(Context context) {
        int networkType;
        try {
            ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            networkType = ((TelephonyManager) context.getSystemService("phone")).getNetworkType();
        } catch (Exception e) {
            e.printStackTrace();
            networkType = -1;
        }
        return a(networkType);
    }
}
