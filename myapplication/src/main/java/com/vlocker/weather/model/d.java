package com.vlocker.weather.model;

import com.vlocker.b.i;
import org.json.JSONObject;

class d implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ c b;

    d(c cVar, String str) {
        this.b = cVar;
        this.a = str;
    }

    public void run() {
        try {
            JSONObject jSONObject = new JSONObject(this.a);
            if (jSONObject.getInt("code") != 200) {
                this.b.b.readSavedWeatherDataOfToday(false);
                return;
            }
            jSONObject = jSONObject.getJSONObject("data");
            this.b.b.parserweatherdata(jSONObject);
            this.b.a.a(jSONObject.toString());
            this.b.b.isfreshsuccess = true;
            i.e = i.c[0];
        } catch (Exception e) {
        }
    }
}
