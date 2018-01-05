package com.vlocker.g;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.vlocker.msg.as;
import com.vlocker.security.MoSecurityApplication;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class q {
    private String a;
    private Context b = MoSecurityApplication.a();
    private Handler c = new r(this);

    public q(String str) {
        this.a = str;
    }

    public void a() {
        a aVar = new a();
        try {
            JSONObject jSONObject = new JSONObject(this.a);
            JSONObject jSONObject2 = jSONObject.getJSONObject("train");
            aVar.u = jSONObject.optString("id");
            aVar.v = jSONObject.optString("bid");
            aVar.w = true;
            aVar.x = this.a;
            aVar.t = jSONObject2.optString("resid");
            aVar.f = jSONObject2.optString("type");
            aVar.q = jSONObject2.optString("icon");
            aVar.a(jSONObject2.optString("sdate"));
            aVar.b(jSONObject2.optString("edate"));
            JSONArray optJSONArray = jSONObject2.optJSONArray("tips");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    if (!TextUtils.isEmpty(optJSONArray.optString(i))) {
                        aVar.a.add(optJSONArray.optString(i));
                    }
                }
            }
            aVar.b = jSONObject2.optString("tips_color");
            aVar.c = jSONObject2.optString("tips_cover");
            aVar.e = jSONObject2.optBoolean("preload", false);
            aVar.s = as.d(this.b, jSONObject2.toString());
            if ("AppDown".equals(aVar.f)) {
                jSONObject = jSONObject2.optJSONObject("soft");
                if (jSONObject == null) {
                    aVar.p = true;
                } else {
                    aVar.h = jSONObject.optString("icon");
                    aVar.i = jSONObject.optString("cover");
                    aVar.l = jSONObject.optString("title");
                    aVar.m = jSONObject.optString("desc");
                    aVar.n = jSONObject.optString("button_value");
                    aVar.o = jSONObject.optString("package");
                }
                jSONObject = jSONObject2.optJSONObject("intent");
                if (jSONObject != null) {
                    aVar.g = jSONObject.optString("url");
                    if (!TextUtils.isEmpty(jSONObject.optString("package"))) {
                        aVar.o = jSONObject.optString("package");
                    }
                }
            }
            new Thread(new s(this, aVar)).start();
        } catch (JSONException e) {
        }
    }
}
