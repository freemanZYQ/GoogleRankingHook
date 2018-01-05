package com.tencent.wxop.stat.a;

import android.content.Context;
import com.tencent.a.a.a.a.h;
import com.tencent.wxop.stat.am;
import com.tencent.wxop.stat.b.c;
import com.tencent.wxop.stat.b.l;
import com.tencent.wxop.stat.b.r;
import com.tencent.wxop.stat.v;
import com.tencent.wxop.stat.y;
import org.json.JSONObject;

public abstract class d {
    protected static String j = null;
    private y a = null;
    protected String b = null;
    protected long c;
    protected int d;
    protected c e = null;
    protected int f;
    protected String g = null;
    protected String h = null;
    protected String i = null;
    protected boolean k = false;
    protected Context l;

    d(Context context, int i, y yVar) {
        this.l = context;
        this.c = System.currentTimeMillis() / 1000;
        this.d = i;
        this.h = v.b(context);
        this.i = l.j(context);
        this.b = v.a(context);
        if (yVar != null) {
            this.a = yVar;
            if (l.c(yVar.c())) {
                this.b = yVar.c();
            }
            if (l.c(yVar.d())) {
                this.h = yVar.d();
            }
            if (l.c(yVar.b())) {
                this.i = yVar.b();
            }
            this.k = yVar.e();
        }
        this.g = v.d(context);
        this.e = am.a(context).b(context);
        if (b() != e.NETWORK_DETECTOR) {
            this.f = l.q(context).intValue();
        } else {
            this.f = -e.NETWORK_DETECTOR.a();
        }
        if (!h.b(j)) {
            String e = v.e(context);
            j = e;
            if (!l.c(e)) {
                j = "0";
            }
        }
    }

    private boolean b(JSONObject jSONObject) {
        boolean z = false;
        try {
            r.a(jSONObject, "ky", this.b);
            jSONObject.put("et", b().a());
            if (this.e != null) {
                jSONObject.put("ui", this.e.a());
                r.a(jSONObject, "mc", this.e.b());
                int d = this.e.d();
                jSONObject.put("ut", d);
                if (d == 0 && l.t(this.l) == 1) {
                    jSONObject.put("ia", 1);
                }
            }
            r.a(jSONObject, "cui", this.g);
            if (b() != e.SESSION_ENV) {
                r.a(jSONObject, "av", this.i);
                r.a(jSONObject, "ch", this.h);
            }
            if (this.k) {
                jSONObject.put("impt", 1);
            }
            r.a(jSONObject, "mid", j);
            jSONObject.put("idx", this.f);
            jSONObject.put("si", this.d);
            jSONObject.put("ts", this.c);
            jSONObject.put("dts", l.a(this.l, false));
            z = a(jSONObject);
        } catch (Throwable th) {
        }
        return z;
    }

    public abstract boolean a(JSONObject jSONObject);

    public abstract e b();

    public final long c() {
        return this.c;
    }

    public final y d() {
        return this.a;
    }

    public final Context e() {
        return this.l;
    }

    public final boolean f() {
        return this.k;
    }

    public final String g() {
        try {
            JSONObject jSONObject = new JSONObject();
            b(jSONObject);
            return jSONObject.toString();
        } catch (Throwable th) {
            return "";
        }
    }
}
