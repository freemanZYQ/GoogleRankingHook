package com.inveno.a;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

class aa extends x {
    final long h;
    final int i;

    aa(String str, String str2, String str3, long j, int i, String str4, String str5) {
        super(5, j, str, str2, str3, str4, str5);
        this.h = j;
        this.i = i;
    }

    JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("event_id", String.valueOf(this.a));
            jSONObject.put("scenario", this.c);
            jSONObject.put("content_id", this.d);
            jSONObject.put("cpack", this.e);
            jSONObject.put("event_time", b());
            jSONObject.put("proportion", String.valueOf(this.i));
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
