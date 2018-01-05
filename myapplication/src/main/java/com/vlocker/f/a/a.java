package com.vlocker.f.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Build;
import com.samsung.android.sdk.pass.SpassFingerprint;
import com.vlocker.security.MoSecurityApplication;
import com.vlocker.settings.SettingsActivity;
import com.vlocker.theme.f.b;

public class a {
    public static void a(Context context) {
        Intent intent = new Intent();
        intent.setFlags(268435456);
        intent.setClass(context, SettingsActivity.class);
        intent.putExtra("from_fingerprint", true);
        context.startActivity(intent);
    }

    public static void a(Context context, boolean z) {
        new SpassFingerprint(context).registerFinger(context, new b());
    }

    public static boolean a() {
        return Build.MODEL.equals("SM-N910V") || Build.MODEL.equals("SM-G900H");
    }

    public static boolean b() {
        return Build.MODEL.startsWith("SM");
    }

    public static String c() {
        return b.n() ? "oppo3.0+" : b.c() ? "vivo2.5+" : (b.r() || b.s()) ? "miui7_8" : b.w() ? "gionee" : b.x() ? "nubia" : b.E() ? "letv" : b.G() ? "360" : b.g() ? "meizu4" : b.h() ? d().compareTo("5.1.60718") <= 0 ? "meizu5-low" : "meizu5-high" : b.i() ? "meizu6" : null;
    }

    public static String d() {
        try {
            PackageInfo packageInfo = MoSecurityApplication.a().getPackageManager().getPackageInfo("com.android.settings", 0);
            if (packageInfo != null) {
                return packageInfo.versionName;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean e() {
        return System.currentTimeMillis() - com.vlocker.c.a.a(MoSecurityApplication.a()).db() > 10000;
    }
}
