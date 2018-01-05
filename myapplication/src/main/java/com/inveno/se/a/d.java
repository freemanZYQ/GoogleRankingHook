package com.inveno.se.a;

import com.baidu.mobads.interfaces.error.XAdErrorCode;
import com.inveno.se.f.a;
import org.json.JSONException;
import org.json.JSONObject;

public class d {
    private int a;
    private String b;
    private int c;

    public static d a(JSONObject jSONObject) {
        if (jSONObject == null) {
            throw new RuntimeException("jsonObject don't be null");
        }
        d dVar = new d();
        try {
            dVar.b(jSONObject.getInt("code"));
            if (jSONObject.has(XAdErrorCode.ERROR_CODE_MESSAGE)) {
                dVar.a(jSONObject.getString(XAdErrorCode.ERROR_CODE_MESSAGE));
            }
            if (jSONObject.has(c.b)) {
                dVar.a(jSONObject.getInt(c.b));
            }
        } catch (JSONException e) {
            a.b("解析result json exception：" + e);
        }
        return dVar;
    }

    public int a() {
        return this.a;
    }

    public void a(int i) {
        this.c = i;
    }

    public void a(String str) {
        this.b = str;
    }

    public void b(int i) {
        this.a = i;
    }
}
