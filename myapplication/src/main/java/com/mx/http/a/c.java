package com.mx.http.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.util.Log;

public class c {
    public static Uri a = Uri.parse("content://telephony/carriers");

    public static boolean a(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            Log.w("NetworkHelpers", "couldn't get connectivity manager");
            return false;
        }
        NetworkInfo[] allNetworkInfo = connectivityManager.getAllNetworkInfo();
        if (allNetworkInfo == null) {
            return false;
        }
        for (NetworkInfo isAvailable : allNetworkInfo) {
            if (isAvailable.isAvailable()) {
                return true;
            }
        }
        return false;
    }
}
