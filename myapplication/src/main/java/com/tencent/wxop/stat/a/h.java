package com.tencent.wxop.stat.a;

import android.content.Context;
import com.qq.e.comm.constants.Constants.KEYS;
import com.tencent.wxop.stat.b.r;
import com.tencent.wxop.stat.y;
import org.json.JSONObject;

public final class h extends d {
    Long a = null;
    String m;
    String n;

    public h(Context context, String str, String str2, int i, Long l, y yVar) {
        super(context, i, yVar);
        this.n = str;
        this.m = str2;
        this.a = l;
    }

    public final boolean a(JSONObject jSONObject) {
        r.a(jSONObject, "pi", this.m);
        r.a(jSONObject, KEYS.Banner_RF, this.n);
        if (this.a != null) {
            jSONObject.put("du", this.a);
        }
        return true;
    }

    public final e b() {
        return e.PAGE_VIEW;
    }
}
