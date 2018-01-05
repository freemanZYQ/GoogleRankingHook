package com.vlocker.search;

import org.json.JSONException;
import org.json.JSONObject;

class bh extends Thread {
    final /* synthetic */ String a;
    final /* synthetic */ bg b;

    bh(bg bgVar, String str) {
        this.b = bgVar;
        this.a = str;
    }

    public void run() {
        try {
            JSONObject jSONObject = new JSONObject(this.a);
            if (jSONObject.getInt("code") == 200) {
                this.b.a.b = new bj(this.b.a);
                jSONObject = jSONObject.getJSONObject("data");
                if (jSONObject.has("total")) {
                    this.b.a.b.a = jSONObject.getInt("total");
                }
                if (jSONObject.has("love")) {
                    this.b.a.b.b = jSONObject.getInt("love");
                }
                if (jSONObject.has("img")) {
                    this.b.a.b.c = jSONObject.getString("img");
                }
                if (jSONObject.has("name")) {
                    this.b.a.b.d = jSONObject.getString("name");
                }
                if (jSONObject.has("fortune")) {
                    this.b.a.b.e = jSONObject.getString("fortune");
                }
            }
        } catch (JSONException e) {
        } catch (Exception e2) {
        }
        this.b.a.m.post(new bi(this));
    }
}
