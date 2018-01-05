package com.inveno.a;

import org.json.JSONArray;

abstract class x extends v {
    final String d;
    final String e;
    final String f;
    final String g;

    x(int i, long j, String str, String str2, String str3, String str4, String str5) {
        super(i, j, str);
        this.d = str2;
        this.e = str3;
        this.f = str4;
        this.g = str5;
    }

    String c() {
        return String.format("%s_%s_%s", new Object[]{Integer.valueOf(this.a), this.c, this.d});
    }

    String d() {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(a());
        return jSONArray.toString();
    }
}
