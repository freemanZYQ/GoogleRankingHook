package com.inveno.se.model;

import com.inveno.se.f.a;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class c extends ArrayList {
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private boolean h;
    private String i;

    public static c a(JSONObject jSONObject) {
        c cVar = new c();
        try {
            cVar.h(jSONObject.toString());
            cVar.a(jSONObject.getString("code"));
            cVar.b(jSONObject.getString("error_msg"));
            cVar.d(jSONObject.getString("server_time"));
            cVar.g(jSONObject.getString("upack"));
            if (jSONObject.has("count")) {
                cVar.c(jSONObject.getString("count"));
            }
            if (jSONObject.has("t_expire_c")) {
                cVar.e(jSONObject.getString("t_expire_c"));
            }
            if (jSONObject.has("data")) {
                JSONArray jSONArray = jSONObject.getJSONArray("data");
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    a.a("inveno", length + " ZZNews parse i" + i);
                    d a = d.a(jSONArray.getJSONObject(i));
                    if (a != null) {
                        a.B(jSONObject.getString("server_time"));
                        cVar.add(a);
                    } else {
                        cVar.a(true);
                    }
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
            cVar.a(true);
        }
        try {
            if (jSONObject.has("reset")) {
                cVar.f(jSONObject.getString("reset"));
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return cVar;
    }

    public String a() {
        return this.f;
    }

    public void a(String str) {
        this.a = str;
    }

    public void a(boolean z) {
        this.h = z;
    }

    public void b(String str) {
        this.b = str;
    }

    public void c(String str) {
        this.c = str;
    }

    public void d(String str) {
        this.d = str;
    }

    public void e(String str) {
        this.e = str;
    }

    public void f(String str) {
        this.f = str;
    }

    public void g(String str) {
        this.g = str;
    }

    public void h(String str) {
        this.i = str;
    }
}
