package com.inveno.a;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

class z extends x {
    final long h;
    final long i;
    final long j;
    final int k;

    z(String str, String str2, String str3, long j, long j2, long j3, int i, String str4, String str5) {
        super(4, j, str, str2, str3, str4, str5);
        this.h = j;
        this.i = j2;
        this.j = j3;
        this.k = i;
    }

    JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("event_id", String.valueOf(this.a));
            jSONObject.put("scenario", this.c);
            jSONObject.put("content_id", this.d);
            jSONObject.put("cpack", this.e);
            jSONObject.put("event_time", b());
            jSONObject.put("play_time", u.a(this.j, 0));
            jSONObject.put("stay_time", this.k == 0 ? "0" : u.a(this.i, this.h));
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
