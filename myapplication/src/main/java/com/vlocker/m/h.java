package com.vlocker.m;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.SystemProperties;
import android.telephony.TelephonyManager;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import com.vlocker.c.a;
import com.vlocker.security.MoSecurityApplication;
import java.io.File;
import java.util.Locale;
import java.util.Random;

public final class h {
    static Random a = null;
    public static int b = 0;
    private static PackageInfo c;
    private static String d;
    private static String e;

    public static int a(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }

    public static String a() {
        String str;
        if (Environment.getExternalStorageState().equals("mounted")) {
            str = Environment.getExternalStorageDirectory().getPath() + "/vlocker/lock_log/";
            File file = new File(str);
            file.mkdirs();
            if (!file.exists() && VERSION.SDK_INT >= 8) {
                file = g();
                if (file != null) {
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    str = p.a(file.getPath());
                }
            }
        } else {
            str = null;
        }
        return str == null ? p.a(MoSecurityApplication.a().getApplicationInfo().dataDir) : str;
    }

    public static boolean a(Context context) {
        for (NetworkInfo networkInfo : ((ConnectivityManager) context.getSystemService("connectivity")).getAllNetworkInfo()) {
            if (networkInfo.getTypeName().equalsIgnoreCase("WIFI")) {
                if (networkInfo.isConnected()) {
                    return true;
                }
            } else if (networkInfo.getTypeName().equalsIgnoreCase("MOBILE") && networkInfo.isConnected()) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(Context context, long j) {
        int an = a.a(context).an();
        if (!(j == 0 || an == 0)) {
            long currentTimeMillis = System.currentTimeMillis() - j;
            switch (an) {
                case 1:
                    if (currentTimeMillis < 5000) {
                        return true;
                    }
                    break;
                case 2:
                    if (currentTimeMillis < 15000) {
                        return true;
                    }
                    break;
                case 3:
                    if (currentTimeMillis < 30000) {
                        return true;
                    }
                    break;
                case 4:
                    if (currentTimeMillis < 60000) {
                        return true;
                    }
                    break;
                case 5:
                    if (currentTimeMillis < 300000) {
                        return true;
                    }
                    break;
            }
        }
        return false;
    }

    public static boolean a(Context context, Intent intent) {
        return (intent == null || context.getPackageManager().resolveActivity(intent, 0) == null) ? false : true;
    }

    public static boolean a(Context context, String str) {
        if (context == null || str == null) {
            return false;
        }
        try {
            context.getPackageManager().getPackageInfo(str, 256);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @SuppressLint({"NewApi"})
    public static int b(Context context, Intent intent) {
        try {
            context.startActivity(intent);
            return 0;
        } catch (ActivityNotFoundException e) {
            return -1;
        } catch (SecurityException e2) {
            return -2;
        } catch (NullPointerException e3) {
            return -3;
        }
    }

    public static File b(Context context) {
        File a = p.a(context);
        return a == null ? null : new File(a, "wall_user.jpg");
    }

    public static String b() {
        return a() == null ? null : a() + "log.zip";
    }

    public static File c(Context context) {
        File a = p.a(context);
        return a == null ? null : new File(a, "wall_temp.jpg");
    }

    public static String c() {
        Locale locale = MoSecurityApplication.a().getResources().getConfiguration().locale;
        return locale != null ? locale.getLanguage() : null;
    }

    public static int d(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        return identifier > 0 ? context.getResources().getDimensionPixelSize(identifier) : 0;
    }

    public static String d() {
        try {
            return SystemProperties.get("ro.product.model", IXAdSystemUtils.NT_UNKNOWN);
        } catch (Exception e) {
            return "";
        }
    }

    public static String e(Context context) {
        int i = 0;
        if (context == null) {
            return null;
        }
        String f = f(context);
        int length = f != null ? f.length() : 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (i < 32 - length) {
            stringBuilder.append('0');
            i++;
        }
        if (f != null) {
            stringBuilder.append(f);
        }
        return stringBuilder.toString();
    }

    public static boolean e() {
        return System.currentTimeMillis() - a.a(MoSecurityApplication.a()).M() > 43200000;
    }

    public static String f(Context context) {
        return context == null ? null : ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
    }

    public static boolean f() {
        long cY = a.a(MoSecurityApplication.a()).cY();
        return cY == 0 || System.currentTimeMillis() - cY > 10800000;
    }

    private static File g() {
        return MoSecurityApplication.a().b();
    }

    public static String g(Context context) {
        h(context);
        return d;
    }

    private static void h(Context context) {
        try {
            c = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            d = c.versionName;
            b = c.versionCode;
            e = c.packageName;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
    }
}
