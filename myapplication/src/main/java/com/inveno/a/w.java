package com.inveno.a;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

class w extends x {
    private final boolean h;

    w(String str, String str2, String str3, long j, boolean z, String str4, String str5) {
        super(3, j, str, str2, str3, str4, str5);
        this.h = z;
    }

    JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("event_id", String.valueOf(this.a));
            jSONObject.put("scenario", this.c);
            jSONObject.put("content_id", this.d);
            jSONObject.put("cpack", this.e == null ? "" : this.e);
            jSONObject.put("event_time", b());
            jSONObject.put("click_type", this.h ? "2" : "1");
            if (TextUtils.isEmpty(this.g)) {
                return jSONObject;
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("content_id", this.f);
            jSONObject2.put("content_type", this.g);
            jSONObject.put("refer", jSONObject2);
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
