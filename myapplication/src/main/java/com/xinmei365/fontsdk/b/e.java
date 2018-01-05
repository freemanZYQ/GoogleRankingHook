package com.xinmei365.fontsdk.b;

import android.content.Context;
import com.xinmei365.fontsdk.c.f;
import org.json.JSONException;
import org.json.JSONObject;

public class e extends c {
    public e(Context context, String str) {
        this.ai = context;
        this.E = str;
        a(f.A(str) + "cloudFont.dat", 86400000);
    }

    public void error() {
    }

    public void x() {
    }

    public void x(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("url")) {
                this.obj = jSONObject.getString("url");
            }
        } catch (JSONException e) {
            this.errorCode = 1005;
            this.aj = e.getMessage();
        }
    }
}
