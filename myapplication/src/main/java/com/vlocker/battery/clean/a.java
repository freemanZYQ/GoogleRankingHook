package com.vlocker.battery.clean;

import android.text.TextUtils;
import com.moxiu.b.d.c;
import com.vlocker.security.MoSecurityApplication;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class a {
    public String a = "";
    public String b = "";
    public String c = "";
    public String d = "";
    public String e = "";
    public String f = "";
    public String g = "";
    public String h = "";
    public ArrayList i = new ArrayList();
    public int j = 2;
    public int k = 0;
    public int l = 1;
    public int m = 1;
    public int n = 0;
    public int o = 1;

    public a(JSONObject jSONObject) {
        int i = 0;
        this.a = jSONObject.optString("title");
        this.b = jSONObject.optString("desc");
        this.c = jSONObject.optString("button_value");
        this.d = jSONObject.optString("package");
        this.e = jSONObject.optString("downurl");
        this.f = jSONObject.optString("uri");
        this.g = jSONObject.optString("icon");
        this.h = jSONObject.optString("re_version");
        a(jSONObject.optString("rule_boost"));
        b(jSONObject.optString("rule_ad"));
        JSONArray optJSONArray = jSONObject.optJSONArray("mpic");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            while (i < optJSONArray.length()) {
                this.i.add(optJSONArray.optString(i));
                i++;
            }
        }
    }

    private void a(String str) {
        try {
            String[] split = str.split(":");
            this.j = Integer.parseInt(split[0]);
            this.k = Integer.parseInt(split[1]);
            this.l = Integer.parseInt(split[2]);
        } catch (Exception e) {
            this.j = 2;
            this.k = 0;
            this.l = 1;
        }
    }

    private void b(String str) {
        try {
            String[] split = str.split(":");
            this.m = Integer.parseInt(split[0]);
            this.n = Integer.parseInt(split[1]);
            this.o = Integer.parseInt(split[2]);
        } catch (Exception e) {
            this.m = 1;
            this.n = 0;
            this.o = 1;
        }
    }

    public boolean a() {
        return (TextUtils.isEmpty(this.e) && !TextUtils.isEmpty(this.f) && c.c(MoSecurityApplication.a(), this.d)) ? true : (TextUtils.isEmpty(this.e) || !TextUtils.isEmpty(this.f) || c.c(MoSecurityApplication.a(), this.d)) ? (TextUtils.isEmpty(this.e) || TextUtils.isEmpty(this.f)) ? false : true : true;
    }
}
