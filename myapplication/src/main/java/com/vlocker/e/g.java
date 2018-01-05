package com.vlocker.e;

import com.qq.e.comm.constants.ErrorCode.InitError;
import com.vlocker.b.j;
import org.apache.http.HttpResponse;
import org.json.JSONObject;

class g extends Thread {
    final /* synthetic */ String a;
    final /* synthetic */ e b;

    g(e eVar, String str) {
        this.b = eVar;
        this.a = str;
    }

    public void run() {
        try {
            HttpResponse a = r.a(j.a());
            if (a.getStatusLine().getStatusCode() == 200) {
                String a2 = r.a(a.getEntity().getContent());
                if (a2 != null && !a2.equals("")) {
                    JSONObject jSONObject = new JSONObject(a2);
                    if (Integer.parseInt(jSONObject.getString("code")) == InitError.INVALID_REQUEST_ERROR) {
                        this.b.c.c(0);
                        return;
                    }
                    JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                    this.b.c.a(jSONObject2.getInt("version_code"));
                    this.b.c.p(jSONObject2.optString("version_name", "UNKNOWN"));
                    this.b.c.a(jSONObject2.getString("notification"));
                    this.b.c.e(jSONObject2.getString("type"));
                    this.b.c.b(jSONObject2.getString("md5"));
                    this.b.c.c(jSONObject2.getString("url"));
                    this.b.c.q(this.a);
                    try {
                        this.b.c.o(jSONObject2.getString("markets"));
                        this.b.c.a(jSONObject2.getBoolean("third"));
                    } catch (Exception e) {
                    }
                    this.b.a.sendEmptyMessage(1);
                    return;
                }
                return;
            }
            this.b.a.sendEmptyMessage(2);
        } catch (Exception e2) {
            this.b.a.sendEmptyMessage(2);
        }
    }
}
