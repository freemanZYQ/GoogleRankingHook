package com.inveno.se.model;

import com.inveno.se.model.multimedia.Imgs;
import com.inveno.se.model.multimedia.b;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class d implements Serializable {
    public static boolean a = false;
    private String A;
    private String B;
    private String C;
    private Imgs D;
    private b E;
    private String F;
    private String G;
    private String H;
    private boolean I = false;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private ArrayList l;
    private String m;
    private String n;
    private String o;
    private String p;
    private String q;
    private String r;
    private String s;
    private String t;
    private String u;
    private String v;
    private String w;
    private String x;
    private String y;
    private String z;

    public static d a(JSONObject jSONObject) {
        d dVar = new d();
        dVar.a(jSONObject.getString("content_id"));
        dVar.b(jSONObject.getString("content_type"));
        dVar.c(jSONObject.getString("title"));
        dVar.h(jSONObject.getString("display"));
        dVar.l(jSONObject.getString("link_type"));
        dVar.z(jSONObject.getString("cpack"));
        dVar.g(jSONObject.getString("publish_time"));
        dVar.B(jSONObject.getString("server_time"));
        if (jSONObject.has("is_Report")) {
            dVar.a(jSONObject.optBoolean("is_Report"));
        }
        if (jSONObject.has("list_images")) {
            try {
                JSONArray jSONArray = jSONObject.getJSONArray("list_images");
                int length = jSONArray.length();
                ArrayList arrayList = new ArrayList(3);
                for (int i = 0; i < length; i++) {
                    Imgs a = Imgs.a(jSONArray.getJSONObject(i));
                    if (a != null) {
                        arrayList.add(a);
                    }
                }
                dVar.a(arrayList);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        try {
            if (jSONObject.has("headvideo")) {
                try {
                    dVar.a(b.a(jSONObject.getJSONObject("headvideo")));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            if (jSONObject.has("linktype")) {
                try {
                } catch (JSONException e22) {
                    e22.printStackTrace();
                    return dVar;
                }
            }
            if (jSONObject.has("author")) {
                dVar.d(jSONObject.getString("author"));
            }
            if (jSONObject.has("summary")) {
                dVar.e(jSONObject.getString("summary"));
            }
            if (jSONObject.has("body_size")) {
                dVar.f(jSONObject.getString("body_size"));
            }
            if (jSONObject.has("source")) {
                dVar.i(jSONObject.getString("source"));
            }
            if (jSONObject.has("url")) {
                dVar.j(jSONObject.getString("url"));
            }
            if (jSONObject.has("origin_url")) {
                dVar.k(jSONObject.getString("origin_url"));
            }
            if (jSONObject.has("flag")) {
                dVar.m(jSONObject.getString("flag"));
            }
            if (jSONObject.has("top")) {
                dVar.n(jSONObject.getString("top"));
            }
            if (jSONObject.has("top_ttl")) {
                dVar.o(jSONObject.getString("top_ttl"));
            }
            if (jSONObject.has("keywords")) {
                dVar.p(jSONObject.getString("keywords"));
            }
            if (jSONObject.has("categories")) {
                dVar.q(jSONObject.getString("categories"));
            }
            if (jSONObject.has("news_score")) {
                dVar.r(jSONObject.getString("news_score"));
            }
            if (jSONObject.has("social_score")) {
                dVar.s(jSONObject.getString("social_score"));
            }
            if (jSONObject.has("erotic_score")) {
                dVar.t(jSONObject.getString("erotic_score"));
            }
            if (jSONObject.has("click_count")) {
                dVar.u(jSONObject.getString("click_count"));
            }
            if (jSONObject.has("like_count")) {
                dVar.v(jSONObject.getString("like_count"));
            }
            if (jSONObject.has("dislike_count")) {
                dVar.w(jSONObject.getString("dislike_count"));
            }
            if (jSONObject.has("share_count")) {
                dVar.x(jSONObject.getString("share_count"));
            }
            if (jSONObject.has("comment_count")) {
                dVar.y(jSONObject.getString("comment_count"));
            }
            if (jSONObject.has("cpid")) {
                dVar.A(jSONObject.getString("cpid"));
            }
            if (jSONObject.has("headimage")) {
                dVar.a(Imgs.a(jSONObject.getJSONObject("headimage")));
            }
            if (jSONObject.has("share_url")) {
                dVar.D(jSONObject.getString("share_url"));
            }
            if (jSONObject == null) {
                return dVar;
            }
            dVar.C(jSONObject.toString());
            return dVar;
        } catch (JSONException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public void A(String str) {
        this.C = str;
    }

    public void B(String str) {
        this.F = str;
    }

    public void C(String str) {
        this.G = str;
    }

    public void D(String str) {
        this.H = str;
    }

    public String a() {
        return this.b;
    }

    public void a(Imgs imgs) {
        this.D = imgs;
    }

    public void a(b bVar) {
        this.E = bVar;
    }

    public void a(String str) {
        this.b = str;
    }

    public void a(ArrayList arrayList) {
        this.l = arrayList;
    }

    public void a(boolean z) {
        this.I = z;
    }

    public String b() {
        return this.d;
    }

    public void b(String str) {
        this.c = str;
    }

    public String c() {
        return this.m;
    }

    public void c(String str) {
        this.d = str;
    }

    public String d() {
        return this.n;
    }

    public void d(String str) {
        this.i = str;
    }

    public String e() {
        return this.e;
    }

    public void e(String str) {
        this.j = str;
    }

    public ArrayList f() {
        return this.l;
    }

    public void f(String str) {
        this.k = str;
    }

    public String g() {
        return this.F;
    }

    public void g(String str) {
        this.f = str;
    }

    public void h(String str) {
        this.g = str;
    }

    public void i(String str) {
        this.m = str;
    }

    public void j(String str) {
        this.n = str;
    }

    public void k(String str) {
        this.o = str;
    }

    public void l(String str) {
        this.h = str;
    }

    public void m(String str) {
        this.p = str;
    }

    public void n(String str) {
        this.q = str;
    }

    public void o(String str) {
        this.r = str;
    }

    public void p(String str) {
        this.s = str;
    }

    public void q(String str) {
        this.t = str;
    }

    public void r(String str) {
        this.u = str;
    }

    public void s(String str) {
        this.v = str;
    }

    public void t(String str) {
        this.w = str;
    }

    public void u(String str) {
        this.x = str;
    }

    public void v(String str) {
        this.y = str;
    }

    public void w(String str) {
        this.z = str;
    }

    public void x(String str) {
        this.A = str;
    }

    public void y(String str) {
        this.B = str;
    }

    public void z(String str) {
        this.e = str;
    }
}
