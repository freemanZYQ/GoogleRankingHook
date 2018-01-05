package com.inveno.se.b.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import com.inveno.se.a.f;
import com.inveno.se.f.d;
import com.inveno.se.f.k;

public class a {
    public static String a;
    public static String b;

    public static void a(Context context) {
        com.inveno.se.f.a.a("pise", "getPiKeys Const.SDK_VERSION:" + d.e);
        if (d.e >= 5) {
            try {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                a = applicationInfo.metaData.getString("KEYO");
                if (k.a(a)) {
                    a = f.c;
                }
                b = applicationInfo.metaData.getString("KEYT");
                if (k.a(b)) {
                    b = f.d;
                }
                com.inveno.se.f.a.a("lhc", "key1:" + a);
                com.inveno.se.f.a.a("lhc", "key2:" + b);
            } catch (NameNotFoundException e) {
                throw new RuntimeException("packAge name not find!");
            }
        }
    }
}
