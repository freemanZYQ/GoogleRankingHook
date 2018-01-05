package com.inveno.se.b;

import android.util.Base64;
import com.baidu.location.LocationClientOption;
import com.inveno.se.a.b;
import com.inveno.se.a.e;
import com.inveno.se.d.a.j;
import com.inveno.se.d.c;
import com.inveno.se.d.m;
import com.inveno.se.d.p;
import com.inveno.se.d.t;
import com.inveno.se.d.u;
import com.inveno.se.d.v;
import com.inveno.se.f.d;
import com.inveno.se.f.h;
import com.inveno.se.f.k;
import com.inveno.se.f.o;
import java.util.Map;
import org.json.JSONObject;

public class a extends p {
    private static int d = 180000;
    private Map a;
    private v b;
    private boolean c;

    public a(String str, v vVar, u uVar, Map map, boolean z) {
        super(1, str, uVar);
        this.b = vVar;
        this.a = map;
        this.c = z;
        if (k.b(str) && str.contains("info/list")) {
            a(false);
        }
        if (k.b(str) && str.contains("report")) {
            a(false);
        }
    }

    protected t a(m mVar) {
        try {
            String str;
            Object obj = mVar.b;
            com.inveno.se.f.a.b("parseNetworkResponse data :" + obj + "  response.data:" + mVar.b + " response.data length:" + mVar.b.length);
            Object a;
            if (mVar.c.containsKey("Content-Encoding") && "deflate".equals(mVar.c.get("Content-Encoding"))) {
                com.inveno.se.f.a.b("has Content-Encoding:deflate encryption:" + this.c + " Const.SDK_VERSION:" + d.e + " KeysManager.KEY1:" + com.inveno.se.b.a.a.a + " IOUtils.decompress(response.data):" + h.a(mVar.b) + " data:" + new String(obj, j.a(mVar.c)));
                a = (!this.c || d.e < 5) ? h.a(mVar.b) : b.b(h.a(mVar.b), com.inveno.se.b.a.a.a.getBytes());
                com.inveno.se.f.a.b("decrypt data:" + a);
                str = new String(a, j.a(mVar.c));
            } else {
                byte[] b;
                if (!this.c || d.e < 5) {
                    a = obj;
                } else {
                    b = b.b(mVar.b, com.inveno.se.b.a.a.a.getBytes());
                }
                str = new String(b, j.a(mVar.c));
            }
            long currentTimeMillis = System.currentTimeMillis();
            c a2 = j.a(mVar);
            com.inveno.se.f.a.b("返回parseNetworkResponse jsonString:" + str);
            com.inveno.se.f.a.b("返回parseNetworkResponse response.data:" + mVar.b + " charset:" + mVar.c);
            if (o.a(e.b).equals(c())) {
                a2.e = currentTimeMillis + ((long) (d * LocationClientOption.MIN_SCAN_SPAN));
                a2.d = a2.e;
            }
            return t.a(new JSONObject(str), a2);
        } catch (Throwable e) {
            return t.a(new com.inveno.se.d.o(e));
        } catch (Throwable e2) {
            return t.a(new com.inveno.se.d.o(e2));
        }
    }

    protected Map a() {
        return this.a;
    }

    protected void a(JSONObject jSONObject) {
        try {
            if (this.b != null) {
                this.b.a(jSONObject);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public byte[] b() {
        Map a = a();
        if (a == null || a.size() <= 0) {
            return null;
        }
        byte[] a2 = a(a, p());
        com.inveno.se.f.a.b("getBody  params tk :" + ((String) a.get("tk")) + " encryption:" + this.c + " orignalBody:" + a2);
        if (!this.c) {
            return a2;
        }
        Object a3 = d.e >= 5 ? b.a(a2, com.inveno.se.b.a.a.a.getBytes()) : b.a(a2, "INV!@#$)(*!776sF".getBytes());
        com.inveno.se.f.a.b("getBody Const.SDK_VERSION :" + d.e + "  enc:" + a3);
        com.inveno.se.f.a.b("解密后：" + Base64.encodeToString(a3, 0));
        return a3;
    }

    public String c() {
        return super.c();
    }

    public c d() {
        return super.d();
    }

    public String e() {
        com.inveno.se.f.a.b("getBodyContentType encryption:" + this.c + " getBodyContentType():" + super.e());
        return this.c ? "text/plain; charset=utf-8" : super.e();
    }
}
