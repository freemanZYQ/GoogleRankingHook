package com.xinmei365.fontsdk.c;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.text.TextUtils;
import com.xinmei365.fontsdk.a;

public class h {
    private static String a(Object... objArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (Object append : objArr) {
            stringBuffer.append(append);
        }
        return stringBuffer.toString();
    }

    public static void a(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            Uri parse = Uri.parse(b(str, context.getPackageName(), str2));
            ComponentName componentName = new ComponentName("com.android.vending", "com.android.vending.AssetBrowserActivity");
            Intent intent = new Intent("android.intent.action.VIEW", parse);
            intent.addFlags(268435456);
            intent.setComponent(componentName);
            context.startActivity(intent);
        }
    }

    private static String b(String str, String str2, String str3) {
        return a("market://details?id=", str, "&referrer=", "utm_source%3D", str2, "%26utm_medium%3D", str3);
    }

    public static boolean b(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 0);
        } catch (NameNotFoundException e) {
            packageInfo = null;
        } catch (Exception e2) {
            e2.printStackTrace();
            packageInfo = null;
        }
        return packageInfo != null;
    }

    public static void c(Context context, String str) {
        try {
            context.startActivity(context.getPackageManager().getLaunchIntentForPackage(str));
        } catch (Exception e) {
        }
    }

    public static void d(Context context, String str) {
        a(context, str, a.e);
    }
}
