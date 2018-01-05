package com.inveno.a;

import com.inveno.se.f.a;
import com.inveno.se.f.k;
import org.json.JSONObject;

class at implements ai {
    final /* synthetic */ ap a;
    final /* synthetic */ as b;

    at(as asVar, ap apVar) {
        this.b = asVar;
        this.a = apVar;
    }

    public void a(String str) {
        if (k.b(str)) {
            a.a("DataSDK", "report data failed: " + str);
        }
        this.b.c(this.a);
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            this.b.c(this.a);
            return;
        }
        switch (jSONObject.optInt("code")) {
            case 200:
                this.b.b(this.a);
                return;
            default:
                this.b.c(this.a);
                return;
        }
    }
}
