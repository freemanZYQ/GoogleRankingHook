package com.tencent.wxop.stat.a;

import android.content.Context;
import com.tencent.wxop.stat.b.r;
import com.tencent.wxop.stat.v;
import com.tencent.wxop.stat.y;
import org.json.JSONObject;

public final class f extends d {
    public static final y a;

    static {
        y yVar = new y();
        a = yVar;
        yVar.a("A9VH9B8L4GX4");
    }

    public f(Context context) {
        super(context, 0, a);
    }

    public final boolean a(JSONObject jSONObject) {
        r.a(jSONObject, "actky", v.a(this.l));
        return true;
    }

    public final e b() {
        return e.NETWORK_DETECTOR;
    }
}
