package com.inveno.a;

import com.inveno.se.f.a;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

class af {
    private static af a;
    private List b = new ArrayList();

    private af() {
    }

    static synchronized af a() {
        af afVar;
        synchronized (af.class) {
            if (a == null) {
                a = new af();
            }
            afVar = a;
        }
        return afVar;
    }

    void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.b.add(jSONObject);
            a.a("DataSDK", "加入事件池：" + jSONObject.toString());
            if (this.b.size() >= 30) {
                as.a().a(7);
            }
        }
    }

    boolean b() {
        return this.b.isEmpty();
    }

    String c() {
        if (b()) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (JSONObject put : this.b) {
            jSONArray.put(put);
        }
        this.b.clear();
        return jSONArray.toString();
    }
}
