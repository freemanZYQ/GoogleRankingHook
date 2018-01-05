package com.inveno.a;

import a.c;
import a.d;
import a.f;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.inveno.se.f.e;
import com.inveno.se.f.k;
import java.util.HashMap;
import java.util.Map;

public class l {
    private static l C;
    private int A;
    private int B;
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private int h;
    private int i = 1;
    private String j;
    private String k;
    private String l;
    private String m;
    private String n;
    private final String o = "android";
    private String p;
    private String q;
    private String r;
    private String s;
    private String t;
    private String u;
    private String v;
    private String w;
    private String x;
    private int y = 1;
    private String z;

    private l() {
    }

    public static synchronized l a() {
        l lVar;
        synchronized (l.class) {
            if (C == null) {
                C = new l();
            }
            lVar = C;
        }
        return lVar;
    }

    private static String a(String str, long j) {
        return c.a(m.b + ":" + str + ":" + j);
    }

    private void a(Map map, String str, String str2, boolean z) {
        if (map != null && !TextUtils.isEmpty(str)) {
            Object obj;
            if (TextUtils.isEmpty(str2)) {
                if (z) {
                    obj = "";
                } else {
                    return;
                }
            }
            map.put(str, obj);
        }
    }

    public String A() {
        return this.c;
    }

    Map B() {
        Map hashMap = new HashMap();
        a(hashMap, "product_id", this.a, true);
        a(hashMap, "promotion", this.b, true);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        a(hashMap, "tk", a("", currentTimeMillis), true);
        a(hashMap, "request_time", String.valueOf(currentTimeMillis), true);
        a(hashMap, "uid", this.c, true);
        a(hashMap, "fuid", this.d, false);
        a(hashMap, "app_ver", this.e, true);
        a(hashMap, "sdk_ver", this.f, false);
        a(hashMap, "api_ver", this.g, true);
        a(hashMap, "network", String.valueOf(d.b(i.a)), true);
        a(hashMap, "imei", this.j, true);
        a(hashMap, "aid", this.k, true);
        a(hashMap, "brand", this.l, true);
        a(hashMap, "model", this.m, true);
        a(hashMap, IXAdRequestInfo.OSV, this.n, false);
        a(hashMap, "platform", "android", true);
        a(hashMap, "language", this.p, false);
        a(hashMap, "app_lan", this.q, true);
        a(hashMap, "mcc", this.r, false);
        a(hashMap, "mnc", this.s, false);
        a(hashMap, "nmcc", this.t, false);
        a(hashMap, "nmnc", this.u, false);
        a(hashMap, "mac", e.b, false);
        a(hashMap, "referrer", this.x, false);
        return hashMap;
    }

    Map C() {
        Map hashMap = new HashMap();
        a(hashMap);
        if (k.b(a().l())) {
            hashMap.put("aid", a().l());
        }
        if (k.b(e.a)) {
            hashMap.put("imei", e.a);
        }
        if (k.b(e.b)) {
            hashMap.put("mac", e.b);
        }
        if (k.b(Build.BRAND)) {
            hashMap.put("brand", Build.BRAND);
        }
        if (k.b(Build.MODEL)) {
            hashMap.put("model", Build.MODEL);
        }
        hashMap.put("platform", "android");
        hashMap.put("height", Integer.toString(e.b()));
        hashMap.put("width", Integer.toString(e.a()));
        return hashMap;
    }

    void a(int i) {
        this.h = i;
    }

    void a(String str) {
        this.a = str;
    }

    void a(Map map) {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        a(map, "tk", a("", currentTimeMillis), true);
        a(map, "product_id", this.a, true);
        a(map, "promotion", this.b, true);
        a(map, "request_time", String.valueOf(currentTimeMillis), true);
        a(map, "fuid", this.d, false);
        a(map, "app_ver", this.e, true);
        a(map, "sdk_ver", this.f, false);
        a(map, "api_ver", this.g, true);
        a(map, "network", String.valueOf(d.b(i.a)), true);
        a(map, "imei", this.j, true);
        a(map, "aid", this.k, true);
        a(map, "brand", this.l, true);
        a(map, "model", this.m, true);
        a(map, IXAdRequestInfo.OSV, this.n, false);
        a(map, "platform", "android", true);
        a(map, "language", this.p, false);
        a(map, "app_lan", this.q, true);
        a(map, "mcc", this.r, false);
        a(map, "mnc", this.s, false);
        a(map, "nmcc", this.t, false);
        a(map, "nmnc", this.u, false);
        a(map, "mac", e.b, false);
        a(map, "referrer", this.x, false);
    }

    String b() {
        return this.a;
    }

    void b(int i) {
        this.i = i;
    }

    void b(String str) {
        this.b = str;
    }

    String c() {
        return this.b;
    }

    public void c(int i) {
        this.B = i;
    }

    void c(String str) {
        this.e = str;
    }

    String d() {
        return this.d;
    }

    public void d(int i) {
        this.A = i;
    }

    void d(String str) {
        this.f = str;
    }

    String e() {
        return this.e;
    }

    void e(String str) {
        this.g = str;
    }

    String f() {
        return this.f;
    }

    void f(String str) {
        this.j = str;
    }

    String g() {
        return this.g;
    }

    void g(String str) {
        this.k = str;
    }

    int h() {
        return this.h;
    }

    void h(String str) {
        this.l = str;
    }

    int i() {
        int i = this.i;
        this.i = i + 1;
        return i;
    }

    void i(String str) {
        this.m = str;
    }

    int j() {
        return this.i;
    }

    void j(String str) {
        this.n = str;
    }

    String k() {
        return this.j;
    }

    void k(String str) {
        this.p = str;
    }

    String l() {
        return this.k;
    }

    void l(String str) {
        this.q = str;
    }

    String m() {
        return this.l;
    }

    void m(String str) {
        this.s = str;
    }

    String n() {
        return this.m;
    }

    void n(String str) {
        this.r = str;
    }

    String o() {
        return this.n;
    }

    public void o(String str) {
        this.z = str;
    }

    String p() {
        return "android";
    }

    void p(String str) {
        if (str != null) {
            this.v = str;
            f.a(i.a, "data_sdk", "upack", str);
        }
    }

    String q() {
        return this.p;
    }

    public void q(String str) {
        this.c = str;
    }

    String r() {
        return this.q;
    }

    String s() {
        return this.r;
    }

    String t() {
        return this.s;
    }

    String u() {
        return this.t;
    }

    String v() {
        return this.u;
    }

    String w() {
        return this.v;
    }

    String x() {
        return this.w;
    }

    String y() {
        return this.x;
    }

    int z() {
        return this.y;
    }
}
