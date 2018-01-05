package com.tencent.wxop.stat.b;

import org.json.JSONException;
import org.json.JSONObject;

public final class c {
    private String a = null;
    private String b = null;
    private String c = null;
    private String d = "0";
    private int e;
    private int f = 0;
    private long g = 0;

    public c(String str, String str2, int i) {
        this.a = str;
        this.b = str2;
        this.e = i;
    }

    private JSONObject e() {
        JSONObject jSONObject = new JSONObject();
        try {
            r.a(jSONObject, "ui", this.a);
            r.a(jSONObject, "mc", this.b);
            r.a(jSONObject, "mid", this.d);
            r.a(jSONObject, "aid", this.c);
            jSONObject.put("ts", this.g);
            jSONObject.put("ver", this.f);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public final String a() {
        return this.a;
    }

    public final String b() {
        return this.b;
    }

    public final void c() {
        this.e = 1;
    }

    public final int d() {
        return this.e;
    }

    public final String toString() {
        return e().toString();
    }
}
