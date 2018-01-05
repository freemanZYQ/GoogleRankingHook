package com.vlocker.weather.c.d;

import android.text.TextUtils;
import com.vlocker.b.j;
import com.vlocker.security.MoSecurityApplication;
import com.vlocker.weather.c.c.b;
import com.vlocker.weather.c.c.d;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class g extends a {
    private String d = "";
    private int e;

    private List a(JSONArray jSONArray) {
        List arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                arrayList.add(jSONArray.getJSONObject(i));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    private String f() {
        return "http://iccp.moxiu.com/json.php?do=Vlocker.Card" + j.n(MoSecurityApplication.a());
    }

    private boolean g() {
        return !TextUtils.isEmpty(this.d) && j.i(MoSecurityApplication.a());
    }

    private String h() {
        return this.d + "&page=" + this.e + j.n(MoSecurityApplication.a());
    }

    public b a(JSONObject jSONObject, boolean z) {
        String str = "";
        String str2 = "";
        String str3 = "";
        String str4 = "";
        List arrayList = new ArrayList();
        try {
            str = jSONObject.getJSONObject("view").getString("title");
        } catch (JSONException e) {
        }
        try {
            str2 = jSONObject.getJSONObject("view").getString("source");
        } catch (JSONException e2) {
        }
        try {
            str3 = jSONObject.getJSONObject("view").getString("reading");
        } catch (JSONException e3) {
        }
        try {
            str4 = jSONObject.getJSONObject("oper").getString("url");
        } catch (JSONException e4) {
        }
        try {
            JSONArray jSONArray = jSONObject.getJSONObject("view").getJSONArray("img");
            for (int i = 0; i < jSONArray.length(); i++) {
                if (!TextUtils.isEmpty(jSONArray.getString(i))) {
                    arrayList.add(jSONArray.getString(i));
                }
            }
        } catch (JSONException e5) {
        }
        return new d(str, str2, str3, arrayList, str4, z);
    }

    public void a() {
        if (TextUtils.isEmpty(this.d) && j.i(MoSecurityApplication.a())) {
            new com.vlocker.new_theme.a.d().a(f(), new h(this));
        }
    }

    public void b() {
        if (g()) {
            new com.vlocker.new_theme.a.d().a(h(), new i(this));
        } else {
            this.c.m();
        }
    }

    public void c() {
        if (g()) {
            new com.vlocker.new_theme.a.d().a(h(), new j(this));
        } else {
            this.c.n();
        }
    }

    public boolean d() {
        return !TextUtils.isEmpty(this.d);
    }

    public void e() {
        this.e = 1;
    }
}
