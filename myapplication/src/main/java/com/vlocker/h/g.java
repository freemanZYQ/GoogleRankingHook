package com.vlocker.h;

import android.content.Context;
import android.content.pm.FeatureInfo;
import android.os.Build;
import com.vlocker.m.k;
import com.vlocker.security.MoSecurityApplication;

public class g {
    private static g b;
    private Context a;
    private a c = null;

    private g(Context context) {
        this.a = context.getApplicationContext();
        this.c = b(this.a);
    }

    public static synchronized g a(Context context) {
        g gVar;
        synchronized (g.class) {
            if (b == null) {
                b = new g(context);
            }
            gVar = b;
        }
        return gVar;
    }

    public static boolean a(String str) {
        boolean z = false;
        if (str.startsWith("m353")) {
            z = true;
        }
        return str.contains("htc d610t") ? true : z;
    }

    public static a b(Context context) {
        a eVar;
        String toLowerCase = Build.MODEL.toLowerCase();
        if (toLowerCase.startsWith("gt-s5830") || toLowerCase.startsWith("gt-s5838") || k.a() || k.b()) {
            eVar = new e(context);
            if (eVar.a()) {
                return eVar;
            }
        }
        eVar = new i(context);
        if (eVar.a()) {
            return eVar;
        }
        eVar = new c(context);
        if (eVar.a() && !a(toLowerCase)) {
            return eVar;
        }
        eVar = new h(context);
        if (eVar.a()) {
            return eVar;
        }
        eVar = new j(context);
        return !eVar.a() ? null : eVar;
    }

    private static final boolean c() {
        FeatureInfo[] systemAvailableFeatures = MoSecurityApplication.a().getPackageManager().getSystemAvailableFeatures();
        if (systemAvailableFeatures == null) {
            return false;
        }
        for (FeatureInfo featureInfo : systemAvailableFeatures) {
            if (featureInfo != null && "android.hardware.camera.flash".equals(featureInfo.name)) {
                return true;
            }
        }
        return Build.MODEL.toLowerCase().contains("vivo x3t");
    }

    @Deprecated
    public boolean a() {
        return this.c != null ? c() : false;
    }

    public boolean a(b bVar) {
        return this.c.a(bVar);
    }

    public boolean b() {
        return this.c != null ? this.c.b() : false;
    }
}
