package com.vlocker.weather.c.d;

import org.json.JSONException;
import org.json.JSONObject;

class i extends com.vlocker.new_theme.a.i {
    final /* synthetic */ g a;

    i(g gVar) {
        this.a = gVar;
    }

    public void a(String str) {
        this.a.e = this.a.e + 1;
        try {
            this.a.c.a(this.a.a(this.a.a(new JSONObject(str).getJSONObject("data").getJSONArray("list")), true), true);
        } catch (JSONException e) {
            e.printStackTrace();
            this.a.c.m();
        }
    }

    public void a(Throwable th, int i, String str) {
        this.a.c.m();
    }
}
