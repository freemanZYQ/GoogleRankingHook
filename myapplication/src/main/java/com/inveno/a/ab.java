package com.inveno.a;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

class ab extends x {
    private final long h;

    ab(String str, String str2, String str3, long j, long j2, String str4, String str5) {
        super(2, j, str, str2, str3, str4, str5);
        this.h = j2;
    }

    JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("event_id", String.valueOf(this.a));
            jSONObject.put("scenario", this.c);
            jSONObject.put("content_id", this.d);
            jSONObject.put("cpack", this.e == null ? "" : this.e);
            jSONObject.put("event_time", b());
            jSONObject.put("server_time", String.valueOf(this.h));
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
