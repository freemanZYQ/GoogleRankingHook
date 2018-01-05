package com.c.a.k;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import java.util.Random;

@TargetApi(9)
public class b {
    private static String a = "";
    private static String b = "";
    private static String c = "";

    private static String a() {
        StringBuffer stringBuffer = new StringBuffer();
        long currentTimeMillis = System.currentTimeMillis();
        String l = Long.toString(currentTimeMillis);
        stringBuffer.append(l.substring(l.length() - 5));
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append(Build.MODEL.replaceAll(" ", ""));
        while (stringBuffer2.length() < 6) {
            stringBuffer2.append('0');
        }
        stringBuffer.append(stringBuffer2.substring(0, 6));
        Random random = new Random(currentTimeMillis);
        currentTimeMillis = 0;
        while (currentTimeMillis < 4096) {
            currentTimeMillis = random.nextLong();
        }
        stringBuffer.append(Long.toHexString(currentTimeMillis).substring(0, 4));
        return stringBuffer.toString();
    }

    public static String a(Context context) {
        Throwable th;
        if (!TextUtils.isEmpty(a)) {
            return a;
        }
        String trim;
        SharedPreferences sharedPreferences = context.getSharedPreferences("imei", 0);
        String string = sharedPreferences.getString("imei", null);
        if (string == null || string.length() == 0) {
            try {
                string = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
                if (string == null || string.length() == 0) {
                    string = a();
                }
                trim = string.replaceAll(" ", "").trim();
                while (trim.length() < 15) {
                    try {
                        trim = "0" + trim;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
                Editor edit = sharedPreferences.edit();
                edit.putString("imei", trim);
                if (VERSION.SDK_INT >= 9) {
                    edit.apply();
                } else {
                    edit.commit();
                }
            } catch (Throwable th3) {
                Throwable th4 = th3;
                trim = string;
                th = th4;
                Log.d("AppLink", th.toString());
                a = trim.trim();
                return a;
            }
        }
        trim = string;
        a = trim.trim();
        return a;
    }
}
