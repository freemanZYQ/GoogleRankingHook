package com.vlocker.weather.c.d;

import com.vlocker.new_theme.a.i;
import org.json.JSONException;
import org.json.JSONObject;

class j extends i {
    final /* synthetic */ g a;

    j(g gVar) {
        this.a = gVar;
    }

    public void a(String str) {
        this.a.e = this.a.e + 1;
        try {
            this.a.c.b(this.a.a(this.a.a(new JSONObject(str).getJSONObject("data").getJSONArray("list")), false), false);
        } catch (JSONException e) {
            this.a.c.n();
        }
    }

    public void a(Throwable th, int i, String str) {
        this.a.c.n();
    }
}
