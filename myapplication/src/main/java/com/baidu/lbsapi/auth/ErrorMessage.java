package com.baidu.lbsapi.auth;

import com.baidu.mobads.openad.d.b;
import org.json.JSONException;
import org.json.JSONObject;

class ErrorMessage {
    ErrorMessage() {
    }

    static String a(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("status", -1);
            jSONObject.put(b.EVENT_MESSAGE, str);
        } catch (JSONException e) {
        }
        return jSONObject.toString();
    }
}
