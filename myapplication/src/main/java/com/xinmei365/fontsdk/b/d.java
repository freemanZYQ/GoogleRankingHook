package com.xinmei365.fontsdk.b;

import android.content.Context;
import com.xinmei365.fontsdk.c.b;
import com.xinmei365.fontsdk.c.f;
import org.json.JSONArray;
import org.json.JSONException;

public class d extends c {
    public d(Context context, String str) {
        this.ai = context;
        this.E = str;
        a(f.A(str) + "taglist.dat", 86400000);
    }

    public void error() {
    }

    public void x() {
    }

    public void x(String str) {
        try {
            Object a = b.a(new JSONArray(str));
            if (a != null && a.length != 0) {
                this.obj = a;
            }
        } catch (JSONException e) {
            this.errorCode = 1005;
            this.aj = e.getMessage();
        }
    }
}
