package com.inveno.a;

import a.b;
import a.c;
import a.d;
import a.g;
import android.util.Base64;

class ar {
    private String A;
    private String B;
    private String C;
    private final long a;
    private final int b;
    private final String c;
    private final String d;
    private final String e;
    private final String f;
    private final String g;
    private final String h;
    private final long i;
    private final int j;
    private final int k;
    private final int l;
    private final String m;
    private final String n;
    private final String o;
    private final String p;
    private final String q;
    private final String r;
    private final String s;
    private final String t;
    private String u;
    private String v;
    private String w;
    private String x;
    private String y;
    private String z;

    ar(long j, int i, String str, String str2, String str3, String str4, String str5, String str6, long j2, int i2, int i3, int i4, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14) {
        this.a = j;
        this.b = i;
        this.c = str;
        this.d = str2;
        this.e = str3;
        this.f = str4;
        this.g = str5;
        this.h = str6;
        this.i = j2;
        this.j = i2;
        this.k = i3;
        this.l = i4;
        this.m = str7;
        this.n = str8;
        this.o = str9;
        this.p = str10;
        this.q = str11;
        this.r = str12;
        this.s = str13;
        this.t = str14;
    }

    ar(String str, String str2) {
        String encodeToString = Base64.encodeToString(b.a(str.getBytes(), g.a(m.a)), 2);
        l a = l.a();
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        String a2 = c.a(m.b + ":" + encodeToString + ":" + currentTimeMillis);
        this.a = 0;
        this.b = 1;
        this.c = a.b();
        this.d = a.c();
        this.e = a.A();
        this.f = a.e();
        this.g = a.g();
        this.h = a2;
        this.i = currentTimeMillis;
        this.j = d.b(i.a);
        this.k = a.h();
        this.l = a.i();
        this.m = a.k();
        this.n = a.l();
        this.o = a.m();
        this.p = a.n();
        this.q = a.p();
        this.r = a.r();
        this.s = str2;
        this.t = encodeToString;
        this.u = a.d();
        this.v = a.f();
        this.w = a.o();
        this.x = a.q();
        this.y = a.s();
        this.z = a.t();
        this.A = a.u();
        this.B = a.v();
        this.C = a.y();
    }

    ap a() {
        return new ap();
    }

    void a(String str) {
        this.u = str;
    }

    void b(String str) {
        this.v = str;
    }

    void c(String str) {
        this.w = str;
    }

    void d(String str) {
        this.x = str;
    }

    void e(String str) {
        this.y = str;
    }

    void f(String str) {
        this.z = str;
    }

    void g(String str) {
        this.A = str;
    }

    void h(String str) {
        this.B = str;
    }

    void i(String str) {
        this.C = str;
    }
}
