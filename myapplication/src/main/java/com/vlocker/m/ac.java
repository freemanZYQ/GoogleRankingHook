package com.vlocker.m;

import android.content.Context;
import com.vlocker.c.a;
import org.apache.http.HttpResponse;
import org.json.JSONObject;

final class ac extends Thread {
    final /* synthetic */ Context a;

    ac(Context context) {
        this.a = context;
    }

    public void run() {
        Boolean.valueOf(false);
        if (Boolean.valueOf(a.a(this.a).cK()).booleanValue()) {
            try {
                HttpResponse a = ab.a("http://alc.imoxiu.com/iplocation?ip=" + ab.a() + "&product=vlocker");
                if (a.getStatusLine().getStatusCode() == 200) {
                    String a2 = ab.a(a.getEntity().getContent());
                    if (a2 != null && !a2.equals("") && Boolean.valueOf(new JSONObject(a2).getBoolean("status")).booleanValue()) {
                        ab.b(this.a);
                    }
                }
            } catch (Exception e) {
            }
        }
    }
}
