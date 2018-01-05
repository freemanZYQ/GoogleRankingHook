package com.vlocker.weather.e;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.vlocker.b.j;
import com.vlocker.c.a;
import com.vlocker.weather.b.c;
import com.vlocker.weather.model.MXWeatherWidget;

final class k implements Runnable {
    final /* synthetic */ Context a;

    k(Context context) {
        this.a = context;
    }

    public void run() {
        boolean z = true;
        if (j.d(this.a)) {
            if (j.i(this.a)) {
                if (a.a(this.a).I() && a.a(this.a).H() && TextUtils.isEmpty(a.a(this.a).C()) && (a.a(this.a).cL() || j.c(this.a))) {
                    a.a(this.a).aJ(false);
                    a.a(this.a).q(System.currentTimeMillis());
                    c.a(this.a).a(true);
                    return;
                } else if (j.a(this.a)) {
                    j.e(this.a);
                    return;
                } else if (a.a(this.a).I() && c.c(this.a)) {
                    c.a(this.a).a(false);
                    return;
                }
            }
            if (System.currentTimeMillis() - this.a.getSharedPreferences(MXWeatherWidget.WEATHER_CONFIG, 0).getLong(MXWeatherWidget.WEATHER_CONFIG_GET_TIME, 0) <= 3300000) {
                z = false;
            }
            if (Boolean.valueOf(z).booleanValue()) {
                Log.e("liu---", "isrefreshnow sendWeatherUIUpdateBroadcast");
                j.f(this.a);
            }
        }
    }
}
