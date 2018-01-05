package com.tencent.wxop.stat;

import com.baidu.mobads.interfaces.IXAdRequestInfo;
import org.json.JSONException;
import org.json.JSONObject;

public final class u {
    private long a = 0;
    private int b = 0;
    private String c = "";
    private int d = 0;
    private String e = "";

    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(IXAdRequestInfo.MAX_TITLE_LENGTH, this.a);
            jSONObject.put("st", this.b);
            if (this.c != null) {
                jSONObject.put("dm", this.c);
            }
            jSONObject.put("pt", this.d);
            if (this.e != null) {
                jSONObject.put("rip", this.e);
            }
            jSONObject.put("ts", System.currentTimeMillis() / 1000);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public final void a(int i) {
        this.b = i;
    }

    public final void a(long j) {
        this.a = j;
    }

    public final void a(String str) {
        this.c = str;
    }

    public final void b(int i) {
        this.d = i;
    }

    public final void b(String str) {
        this.e = str;
    }
}
