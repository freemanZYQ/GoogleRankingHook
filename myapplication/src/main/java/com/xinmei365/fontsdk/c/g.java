package com.xinmei365.fontsdk.c;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Build.VERSION;

public class g {
    public static int d(Context context) {
        NetworkInfo activeNetworkInfo;
        int i = 2;
        try {
            activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e) {
            activeNetworkInfo = null;
        }
        if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
            a.ap = -1;
            return -1;
        } else if (activeNetworkInfo.getTypeName().equals("WIFI")) {
            a.ap = 1;
            return 1;
        } else {
            String extraInfo = activeNetworkInfo.getExtraInfo();
            if (extraInfo == null || extraInfo.trim().length() == 0) {
                int i2 = (VERSION.SDK_INT >= 13 ? System.getProperties().getProperty("http.proxyHost") : Proxy.getHost(context)) == null ? 2 : 3;
                a.ap = i2;
                return i2;
            } else if (extraInfo.equals("cmnet") || extraInfo.equals("3gnet") || extraInfo.equals("uninet") || extraInfo.equals("ctnet") || extraInfo.equals("ctnet:CDMA") || extraInfo.equals("CTC")) {
                a.ap = 2;
                return 2;
            } else if (extraInfo.equals("cmwap") || extraInfo.equals("3gwap") || extraInfo.equals("uniwap")) {
                a.ap = 3;
                return 3;
            } else if ("ctwap:CDMA".equals(extraInfo) || extraInfo.equals("ctwap") || extraInfo.equals("#777")) {
                a.ap = 4;
                return 4;
            } else {
                if ((VERSION.SDK_INT >= 13 ? System.getProperties().getProperty("http.proxyHost") : Proxy.getHost(context)) != null) {
                    i = 3;
                }
                a.ap = i;
                return i;
            }
        }
    }
}
