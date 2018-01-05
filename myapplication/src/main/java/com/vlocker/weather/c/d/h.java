package com.vlocker.weather.c.d;

import com.vlocker.new_theme.a.i;
import org.json.JSONException;
import org.json.JSONObject;

class h extends i {
    final /* synthetic */ g a;

    h(g gVar) {
        this.a = gVar;
    }

    public void a(String str) {
        try {
            this.a.d = new JSONObject(str).getJSONObject("data").getJSONArray("tag").getJSONObject(0).getString("tag_url");
            if (this.a.c != null) {
                this.a.c.k();
            }
        } catch (JSONException e) {
            if (this.a.c != null) {
                this.a.c.l();
            }
        }
    }

    public void a(Throwable th, int i, String str) {
        this.a.c.l();
    }
}
