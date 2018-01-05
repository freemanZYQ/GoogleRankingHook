package com.inveno.a;

import org.json.JSONException;
import org.json.JSONObject;

class ac extends v {
    final long d;
    final long e;

    ac(String str, long j, long j2) {
        super(1, j, str);
        this.d = j;
        this.e = j2;
    }

    JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("event_id", String.valueOf(this.a));
            jSONObject.put("event_time", b());
            jSONObject.put("scenario", this.c);
            jSONObject.put("dwelltime", u.a(this.e, this.d));
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
