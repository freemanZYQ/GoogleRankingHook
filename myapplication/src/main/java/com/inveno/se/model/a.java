package com.inveno.se.model;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import com.inveno.se.a.f;
import com.inveno.se.f.b;
import com.inveno.se.f.k;
import com.inveno.se.f.m;

public class a {
    public static String a;
    private static a f;
    private Context b;
    private String c = "";
    private String d;
    private String e;

    private a(Context context) {
        b(context);
    }

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            if (f == null) {
                f = new a(context);
            }
            aVar = f;
        }
        return aVar;
    }

    private void b(Context context) {
        try {
            try {
                a = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString("PIKEY");
                b.c = a;
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (k.a(a)) {
                a = f.f;
                b.c = f.f;
            }
            com.inveno.se.b.a.a.a(context);
            this.d = String.valueOf(System.currentTimeMillis());
            this.e = m.b("ltk", "", context);
            this.b = context;
        } catch (NameNotFoundException e2) {
            throw new RuntimeException("packAge name not find!");
        }
    }

    public String a() {
        return this.c;
    }

    public void a(String str) {
        this.c = str;
    }
}
