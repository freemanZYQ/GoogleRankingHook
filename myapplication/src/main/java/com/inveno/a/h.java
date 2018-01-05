package com.inveno.a;

import com.inveno.se.f.a;
import org.json.JSONArray;
import org.json.JSONObject;

class h implements ai {
    final /* synthetic */ String a;
    final /* synthetic */ ai b;
    final /* synthetic */ g c;

    h(g gVar, String str, ai aiVar) {
        this.c = gVar;
        this.a = str;
        this.b = aiVar;
    }

    public void a(String str) {
        if (this.b != null) {
            this.b.a(str);
        }
    }

    public void a(JSONObject jSONObject) {
        a.a("DataSDK", this.a);
        if (this.b != null && jSONObject != null) {
            if (jSONObject.optInt("code") == 200) {
                if (jSONObject.has("reset") && jSONObject.optInt("reset") == 1) {
                    i.b();
                }
                if (jSONObject.has("t_expire_c")) {
                    i.a(jSONObject.optLong("t_expire_c"));
                    jSONObject.remove("t_expire_c");
                }
                if (jSONObject.has("upack")) {
                    i.b(jSONObject.optString("upack"));
                }
                if ((this.c.c.n.equals(this.a) || this.c.c.o.equals(this.a) || this.c.c.q.equals(this.a) || this.c.c.s.equals(this.a)) && jSONObject.has("server_time")) {
                    JSONArray optJSONArray = jSONObject.optJSONArray("data");
                    if (optJSONArray != null) {
                        try {
                            if (optJSONArray.length() > 0) {
                                for (int i = 0; i < optJSONArray.length(); i++) {
                                    optJSONArray.optJSONObject(i).put("server_time", jSONObject.optLong("server_time"));
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            a("put flownewsinfo server time error!!");
                            return;
                        }
                    }
                }
                this.b.a(jSONObject);
                return;
            }
            a("unexpected code" + jSONObject.optInt("code"));
        }
    }
}
