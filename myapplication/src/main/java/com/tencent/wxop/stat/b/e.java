package com.tencent.wxop.stat.b;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.tencent.wxop.stat.am;
import com.tencent.wxop.stat.v;
import com.tencent.wxop.stat.z;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONObject;

final class e {
    String a;
    String b;
    DisplayMetrics c;
    int d;
    String e;
    String f;
    String g;
    String h;
    String i;
    String j;
    String k;
    int l;
    String m;
    String n;
    Context o;
    private String p;
    private String q;
    private String r;
    private String s;

    private e(Context context) {
        this.b = "2.0.3";
        this.d = VERSION.SDK_INT;
        this.e = Build.MODEL;
        this.f = Build.MANUFACTURER;
        this.g = Locale.getDefault().getLanguage();
        this.l = 0;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.o = context.getApplicationContext();
        this.c = l.d(this.o);
        this.a = l.j(this.o);
        this.h = v.b(this.o);
        this.i = l.i(this.o);
        this.j = TimeZone.getDefault().getID();
        Context context2 = this.o;
        this.l = l.b();
        this.k = l.n(this.o);
        this.m = this.o.getPackageName();
        if (this.d >= 14) {
            this.p = l.s(this.o);
        }
        context2 = this.o;
        this.q = l.g().toString();
        this.r = l.r(this.o);
        this.s = l.f();
        this.n = l.x(this.o);
    }

    final void a(JSONObject jSONObject, Thread thread) {
        if (thread == null) {
            if (this.c != null) {
                jSONObject.put("sr", this.c.widthPixels + "*" + this.c.heightPixels);
                jSONObject.put("dpi", this.c.xdpi + "*" + this.c.ydpi);
            }
            if (z.a(this.o).e()) {
                JSONObject jSONObject2 = new JSONObject();
                r.a(jSONObject2, "bs", r.c(this.o));
                r.a(jSONObject2, "ss", r.d(this.o));
                if (jSONObject2.length() > 0) {
                    r.a(jSONObject, "wf", jSONObject2.toString());
                }
            }
            JSONArray f = r.f(this.o);
            if (f != null && f.length() > 0) {
                r.a(jSONObject, "wflist", f.toString());
            }
            r.a(jSONObject, "sen", this.p);
        } else {
            r.a(jSONObject, "thn", thread.getName());
            r.a(jSONObject, "qq", v.c(this.o));
            r.a(jSONObject, "cui", v.d(this.o));
            if (l.c(this.r) && this.r.split("/").length == 2) {
                r.a(jSONObject, "fram", this.r.split("/")[0]);
            }
            if (l.c(this.s) && this.s.split("/").length == 2) {
                r.a(jSONObject, "from", this.s.split("/")[0]);
            }
            if (am.a(this.o).b(this.o) != null) {
                jSONObject.put("ui", am.a(this.o).b(this.o).a());
            }
            r.a(jSONObject, "mid", v.e(this.o));
        }
        r.a(jSONObject, "pcn", l.o(this.o));
        r.a(jSONObject, "osn", VERSION.RELEASE);
        r.a(jSONObject, "av", this.a);
        r.a(jSONObject, "ch", this.h);
        r.a(jSONObject, "mf", this.f);
        r.a(jSONObject, "sv", this.b);
        r.a(jSONObject, "osd", Build.DISPLAY);
        r.a(jSONObject, "prod", Build.PRODUCT);
        r.a(jSONObject, "tags", Build.TAGS);
        r.a(jSONObject, "id", Build.ID);
        r.a(jSONObject, "fng", Build.FINGERPRINT);
        r.a(jSONObject, "lch", this.n);
        r.a(jSONObject, "ov", Integer.toString(this.d));
        jSONObject.put(IXAdRequestInfo.OS, 1);
        r.a(jSONObject, "op", this.i);
        r.a(jSONObject, "lg", this.g);
        r.a(jSONObject, IXAdRequestInfo.TEST_MODE, this.e);
        r.a(jSONObject, "tz", this.j);
        if (this.l != 0) {
            jSONObject.put("jb", this.l);
        }
        r.a(jSONObject, "sd", this.k);
        r.a(jSONObject, "apn", this.m);
        r.a(jSONObject, "cpu", this.q);
        r.a(jSONObject, "abi", Build.CPU_ABI);
        r.a(jSONObject, "abi2", Build.CPU_ABI2);
        r.a(jSONObject, "ram", this.r);
        r.a(jSONObject, "rom", this.s);
    }
}
