package com.tencent.wxop.stat.b;

import android.content.Context;
import com.tencent.wxop.stat.z;
import org.json.JSONObject;

public final class d {
    static e a;
    private static b d = l.c();
    private static JSONObject e = new JSONObject();
    Integer b = null;
    String c = null;

    public d(Context context) {
        try {
            a(context);
            this.b = l.l(context.getApplicationContext());
            this.c = z.a(context).b();
        } catch (Throwable th) {
            d.b(th);
        }
    }

    private static synchronized e a(Context context) {
        e eVar;
        synchronized (d.class) {
            if (a == null) {
                a = new e(context.getApplicationContext());
            }
            eVar = a;
        }
        return eVar;
    }

    public final void a(JSONObject jSONObject, Thread thread) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (a != null) {
                a.a(jSONObject2, thread);
            }
            r.a(jSONObject2, "cn", this.c);
            if (this.b != null) {
                jSONObject2.put("tn", this.b);
            }
            if (thread == null) {
                jSONObject.put("ev", jSONObject2);
            } else {
                jSONObject.put("errkv", jSONObject2.toString());
            }
            if (e != null && e.length() > 0) {
                jSONObject.put("eva", e);
            }
        } catch (Throwable th) {
            d.b(th);
        }
    }
}
