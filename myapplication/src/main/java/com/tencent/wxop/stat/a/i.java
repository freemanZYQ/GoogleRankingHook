package com.tencent.wxop.stat.a;

import android.content.Context;
import com.tencent.wxop.stat.b.d;
import com.tencent.wxop.stat.b.l;
import com.tencent.wxop.stat.y;
import org.json.JSONObject;

public final class i extends d {
    private d a;
    private JSONObject m = null;

    public i(Context context, int i, JSONObject jSONObject, y yVar) {
        super(context, i, yVar);
        this.a = new d(context);
        this.m = jSONObject;
    }

    public final boolean a(JSONObject jSONObject) {
        if (this.e != null) {
            jSONObject.put("ut", this.e.d());
        }
        if (this.m != null) {
            jSONObject.put("cfg", this.m);
        }
        if (l.v(this.l)) {
            jSONObject.put("ncts", 1);
        }
        this.a.a(jSONObject, null);
        return true;
    }

    public final e b() {
        return e.SESSION_ENV;
    }
}
