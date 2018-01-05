package com.inveno.se;

import android.content.Context;
import com.inveno.a.ai;
import com.inveno.a.i;
import com.inveno.se.e.a;
import com.inveno.se.e.b;
import com.inveno.se.f.k;
import com.inveno.se.f.m;
import com.inveno.se.model.c;
import org.json.JSONObject;

class f implements ai {
    final /* synthetic */ a a;
    final /* synthetic */ Context b;
    final /* synthetic */ d c;

    f(d dVar, a aVar, Context context) {
        this.c = dVar;
        this.a = aVar;
        this.b = context;
    }

    public void a(String str) {
        if (this.a != null) {
            this.a.a("get news error:" + str);
        }
    }

    public void a(JSONObject jSONObject) {
        try {
            c a = c.a(jSONObject);
            if (this.a instanceof b) {
                b bVar = (b) this.a;
                boolean z = k.b(a.a()) && "1".equals(a.a());
                bVar.a(a, z);
            }
            if (jSONObject != null && jSONObject.has("upack")) {
                m.a("upack", jSONObject.getString("upack"), this.b);
                i.b(jSONObject.getString("upack"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (this.a != null) {
                this.a.a("get news error:" + e.getMessage());
            }
        }
    }
}
