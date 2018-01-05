package com.b.e;

import com.b.f.a;
import com.moxiu.b.c.n;
import com.moxiu.b.d.c;
import org.json.JSONObject;

class e extends n {
    final /* synthetic */ a a;
    final /* synthetic */ d b;

    e(d dVar, a aVar) {
        this.b = dVar;
        this.a = aVar;
    }

    public void a(String str) {
        super.a(str);
        if (str != null && str.length() > 20) {
            try {
                c.a("greenlist", "load list json-->" + str + " time-->" + System.currentTimeMillis());
                JSONObject jSONObject = new JSONObject(str);
                if (Integer.parseInt(jSONObject.getString("code")) != 200) {
                    this.a.a(com.b.d.c.a(this.b.a, "preload_sharename", this.a.e, this.a.f));
                    return;
                }
                jSONObject = jSONObject.getJSONObject("data");
                this.a.a(a.a(this.b.a, jSONObject, jSONObject.optString("id", ""), this.a.f));
                if (jSONObject.has("extends")) {
                    jSONObject.getJSONArray("extends");
                }
            } catch (Exception e) {
                e.printStackTrace();
            } catch (Throwable th) {
                this.a.a();
                th.printStackTrace();
            }
        }
    }

    public void a(Throwable th, int i, String str) {
        c.a("greenlist", "FAIL-->" + i + " str-->" + str);
        this.a.a(com.b.d.c.a(this.b.a, "preload_sharename", this.a.e, this.a.f));
        super.a(th, i, str);
    }
}
