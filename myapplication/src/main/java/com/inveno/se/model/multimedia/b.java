package com.inveno.se.model.multimedia;

import org.json.JSONObject;

public class b {
    private String a;
    private String b;
    private String c;
    private String d;

    public static b a(JSONObject jSONObject) {
        b bVar = new b();
        try {
            if (jSONObject.has("description")) {
                bVar.c(jSONObject.getString("description"));
            }
            if (jSONObject.has("thumbnail")) {
                bVar.d(jSONObject.getString("thumbnail"));
            }
            bVar.a(jSONObject.getString("url"));
            bVar.b(jSONObject.getString("duration"));
            return bVar;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void a(String str) {
        this.a = str;
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
}
