package com.tencent.wxop.stat.a;

import android.content.Context;
import com.tencent.wxop.stat.b.l;
import com.tencent.wxop.stat.b.r;
import com.tencent.wxop.stat.y;
import com.tencent.wxop.stat.z;
import org.json.JSONObject;

public final class g extends d {
    private static String a = null;
    private String m = null;
    private String n = null;

    public g(Context context, int i, y yVar) {
        super(context, i, yVar);
        this.m = z.a(context).b();
        if (a == null) {
            a = l.i(context);
        }
    }

    public final void a(String str) {
        this.n = str;
    }

    public final boolean a(JSONObject jSONObject) {
        r.a(jSONObject, "op", a);
        r.a(jSONObject, "cn", this.m);
        jSONObject.put("sp", this.n);
        return true;
    }

    public final e b() {
        return e.NETWORK_MONITOR;
    }
}
