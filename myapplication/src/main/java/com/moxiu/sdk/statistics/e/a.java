package com.moxiu.sdk.statistics.e;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.moxiu.sdk.statistics.d.b;

public class a {
    private Context a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private Long i;
    private String j;
    private Long k;
    private String l;
    private String m;
    private Integer n;
    private Integer o;
    private String p;

    public a(Context context) {
        this.a = context;
    }

    public static String a(Integer num) {
        return a(String.valueOf(num));
    }

    public static String a(Long l) {
        return a(String.valueOf(l));
    }

    public static String a(String str) {
        if (str == null) {
            str = "";
        }
        return str.trim();
    }

    private void b() {
        if (this.b == null) {
            this.b = Build.MODEL;
        }
        if (this.c == null) {
            this.c = k.b(this.a);
        }
        if (this.d == null) {
            this.d = k.c(this.a);
        }
        if (this.e == null) {
            this.e = k.a(this.a).name();
        }
        if (this.f == null) {
            this.f = k.d(this.a);
        }
        if (this.g == null) {
            this.g = k.e(this.a);
        }
        if (this.h == null) {
            this.h = k.a();
        }
        if (this.i == null) {
            this.i = Long.valueOf(h.a(this.a));
        }
        if (this.j == null) {
            this.j = k.h(this.a);
        }
        if (this.k == null) {
            this.k = Long.valueOf(System.currentTimeMillis());
        }
        if (this.l == null) {
            this.l = h.b(this.a);
        }
        if (this.m == null) {
            this.m = Build.MANUFACTURER;
        }
        if (this.n == null) {
            this.n = Integer.valueOf(k.g(this.a));
        }
        if (this.o == null) {
            this.o = Integer.valueOf(VERSION.SDK_INT);
        }
        if (this.p == null) {
            this.p = k.f(this.a);
        }
    }

    public b a() {
        b();
        b bVar = new b();
        bVar.b = a(this.b);
        bVar.c = a(this.c);
        bVar.d = a(this.d);
        bVar.e = a(this.e);
        bVar.f = a(this.f);
        bVar.g = a(this.g);
        bVar.h = a(this.h);
        bVar.i = a(this.i);
        bVar.j = a(this.j);
        bVar.k = a(this.k);
        bVar.l = a(this.l);
        bVar.m = a(this.m);
        bVar.n = a(this.n);
        bVar.o = a(this.o);
        bVar.p = a(this.p);
        return bVar;
    }
}
