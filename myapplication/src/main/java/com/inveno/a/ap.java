package com.inveno.a;

import android.text.TextUtils;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import java.util.HashMap;
import java.util.Map;

final class ap {
    final String A;
    final String B;
    final String C;
    final long a;
    final int b;
    final String c;
    final String d;
    final String e;
    final String f;
    final String g;
    final String h;
    final String i;
    final String j;
    final long k;
    final int l;
    int m;
    final int n;
    final String o;
    final String p;
    final String q;
    final String r;
    final String s;
    final String t;
    final String u;
    final String v;
    final String w;
    final String x;
    final String y;
    final String z;

    private ap(ar arVar) {
        this.a = arVar.a;
        this.b = arVar.b;
        this.c = arVar.c;
        this.d = arVar.d;
        this.e = arVar.u;
        this.f = arVar.e;
        this.g = arVar.f;
        this.h = arVar.v;
        this.i = arVar.g;
        this.j = arVar.h;
        this.k = arVar.i;
        this.l = arVar.j;
        this.m = arVar.k;
        this.n = arVar.l;
        this.o = arVar.m;
        this.p = arVar.n;
        this.q = arVar.o;
        this.r = arVar.p;
        this.s = arVar.w;
        this.t = arVar.q;
        this.u = arVar.x;
        this.v = arVar.r;
        this.w = arVar.y;
        this.x = arVar.z;
        this.y = arVar.A;
        this.z = arVar.B;
        this.A = arVar.s;
        this.B = arVar.C;
        this.C = arVar.t;
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

    Map a() {
        Map hashMap = new HashMap();
        a(hashMap, "product_id", this.c, true);
        a(hashMap, "promotion", String.valueOf(this.d), true);
        a(hashMap, "fuid", this.e, true);
        a(hashMap, "app_ver", this.g, true);
        a(hashMap, "sdk_ver", this.h, false);
        a(hashMap, "api_ver", this.i, true);
        a(hashMap, "tk", this.j, true);
        a(hashMap, "report_time", String.valueOf(this.k), true);
        a(hashMap, "network", String.valueOf(this.l), true);
        a(hashMap, "sid", String.valueOf(this.m), true);
        a(hashMap, "seq", String.valueOf(this.n), true);
        a(hashMap, "imei", this.o, true);
        a(hashMap, "aid", this.p, true);
        a(hashMap, "brand", this.q, true);
        a(hashMap, "model", this.r, true);
        a(hashMap, IXAdRequestInfo.OSV, this.s, false);
        a(hashMap, "platform", this.t, true);
        a(hashMap, "language", this.u, false);
        a(hashMap, "app_lan", this.v, true);
        a(hashMap, "mcc", this.w, false);
        a(hashMap, "mnc", this.x, false);
        a(hashMap, "nmcc", this.y, false);
        a(hashMap, "nmnc", this.z, false);
        a(hashMap, "upack", this.A, true);
        a(hashMap, "referrer", this.B, false);
        a(hashMap, "data", this.C, true);
        a(hashMap, "uid", TextUtils.isEmpty(this.f) ? l.a().A() : this.f, true);
        return hashMap;
    }

    public String toString() {
        return "ReportData{id=" + this.a + ", status=" + this.b + ", productId='" + this.c + '\'' + ", promotion='" + this.d + '\'' + ", fuid='" + this.e + '\'' + ", uid='" + this.f + '\'' + ", appVer='" + this.g + '\'' + ", sdkVer='" + this.h + '\'' + ", apiVer='" + this.i + '\'' + ", tk='" + this.j + '\'' + ", reportTime=" + this.k + ", network=" + this.l + ", sid=" + this.m + ", seq=" + this.n + ", imei='" + this.o + '\'' + ", aid='" + this.p + '\'' + ", brand='" + this.q + '\'' + ", model='" + this.r + '\'' + ", osv='" + this.s + '\'' + ", platform='" + this.t + '\'' + ", deviceLan='" + this.u + '\'' + ", appLan='" + this.v + '\'' + ", mcc='" + this.w + '\'' + ", mnc='" + this.x + '\'' + ", nmcc='" + this.y + '\'' + ", nmnc='" + this.z + '\'' + ", upack='" + this.A + '\'' + ", referrer='" + this.B + '\'' + ", data='" + this.C + '\'' + '}';
    }
}
