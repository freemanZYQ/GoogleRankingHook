package com.b.e;

import com.b.f.a;
import com.moxiu.b.c.n;
import com.moxiu.b.d.c;
import org.json.JSONObject;

class h extends n {
    final /* synthetic */ g a;

    h(g gVar) {
        this.a = gVar;
    }

    public void a(String str) {
        super.a(str);
        if (str != null && str.length() > 20) {
            try {
                c.a("debug", "load splash json-->" + str);
                JSONObject jSONObject = new JSONObject(str);
                if (Integer.parseInt(jSONObject.getString("code")) != 200) {
                    this.a.g = com.b.d.c.a(this.a.d, "preload_sharename", this.a.h, 0);
                    this.a.a(this.a.h, this.a.g);
                    return;
                }
                jSONObject = jSONObject.getJSONObject("data");
                String optString = jSONObject.optString("id", "");
                this.a.g = a.a(this.a.d, jSONObject, optString, 0);
                this.a.a(this.a.h, this.a.g);
                if (jSONObject.has("extends")) {
                    jSONObject.getJSONArray("extends");
                }
            } catch (Exception e) {
                e.printStackTrace();
            } catch (Throwable th) {
                if (this.a.f != null) {
                    this.a.f.a(0, "load moxiu error");
                }
                th.printStackTrace();
            }
        }
    }

    public void a(Throwable th, int i, String str) {
        c.b("FAIL-->" + i + " str-->" + str);
        this.a.g = com.b.d.c.a(this.a.d, "preload_sharename", this.a.h, 0);
        this.a.a(this.a.h, this.a.g);
        super.a(th, i, str);
    }
}
