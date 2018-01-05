package com.b.e;

import com.b.f.a;
import com.moxiu.b.c.n;
import com.moxiu.b.d.c;
import java.util.List;
import org.json.JSONObject;

class f extends n {
    final /* synthetic */ List a;
    final /* synthetic */ d b;

    f(d dVar, List list) {
        this.b = dVar;
        this.a = list;
    }

    public void a(String str) {
        int i = 0;
        super.a(str);
        if (str != null && str.length() > 20) {
            try {
                c.a("greenlist", "multi JSON-->" + str + " time-->" + System.currentTimeMillis());
                JSONObject jSONObject = new JSONObject(str);
                int i2;
                if (Integer.parseInt(jSONObject.getString("code")) != 200) {
                    for (i2 = 0; i2 < this.a.size(); i2++) {
                        ((a) this.a.get(i2)).a(com.b.d.c.a(this.b.a, "preload_sharename", ((a) this.a.get(i2)).e, ((a) this.a.get(i2)).f));
                    }
                    return;
                }
                JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                for (i2 = 0; i2 < this.a.size(); i2++) {
                    String str2 = ((a) this.a.get(i2)).e;
                    if (!jSONObject2.isNull(str2)) {
                        ((a) this.a.get(i2)).a(a.a(this.b.a, jSONObject2.getJSONObject(str2), str2, ((a) this.a.get(i2)).f));
                    }
                }
                try {
                    if (jSONObject2.has("extends")) {
                        jSONObject2.getJSONArray("extends");
                    }
                } catch (Exception e) {
                }
            } catch (Exception e2) {
                Exception exception = e2;
                while (i < this.a.size()) {
                    ((a) this.a.get(i)).a();
                    i++;
                }
                exception.printStackTrace();
            }
        }
    }

    public void a(Throwable th, int i, String str) {
        super.a(th, i, str);
        c.b("multi ad fail");
        for (int i2 = 0; i2 < this.a.size(); i2++) {
            ((a) this.a.get(i2)).a(com.b.d.c.a(this.b.a, "preload_sharename", ((a) this.a.get(i2)).e, ((a) this.a.get(i2)).f));
        }
    }
}
