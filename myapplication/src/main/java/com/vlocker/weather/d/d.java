package com.vlocker.weather.d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.vlocker.b.j;
import com.vlocker.c.a;
import com.vlocker.weather.model.MXWeatherWidget;

class d extends BroadcastReceiver {
    final /* synthetic */ a a;

    d(a aVar) {
        this.a = aVar;
    }

    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            if (action != null) {
                Log.e("liu---", "presenter action=" + action);
                if (action.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                    if (j.i(this.a.a)) {
                        if ((((int) (System.currentTimeMillis() - Long.valueOf(this.a.a.getSharedPreferences(MXWeatherWidget.WEATHER_CONFIG, 0).getLong(MXWeatherWidget.WEATHER_CONFIG_GET_TIME, 0)).longValue())) >= 7200000 || a.a(this.a.a).f(0) == 0) && j.i(this.a.a)) {
                            this.a.a(this.a.a);
                        }
                    }
                } else if (action.equals("android.intent.action.DATE_CHANGED") || action.equals("android.intent.action.TIME_SET")) {
                    if (j.i(this.a.a)) {
                        r0 = this.a.a.getSharedPreferences(MXWeatherWidget.WEATHER_CONFIG, 0);
                        if (r0 != null) {
                            if (System.currentTimeMillis() - r0.getLong(MXWeatherWidget.WEATHER_CONFIG_GET_TIME, 0) > 21595000) {
                                this.a.a(this.a.a);
                            }
                        }
                    }
                } else if (action.equals("com.vlocker.ACTION_WEATHER_UI_UPDATE")) {
                    r0 = this.a.a.getSharedPreferences(MXWeatherWidget.WEATHER_CONFIG, 0);
                    if (r0 != null) {
                        if (System.currentTimeMillis() - r0.getLong(MXWeatherWidget.WEATHER_CONFIG_GET_TIME, 0) > 10000) {
                            this.a.e.b();
                        }
                    }
                } else if (action.equals("com.vlocker.WEATHER_ALARM_SELECT")) {
                    this.a.e.b(intent.getStringExtra("pushjson"));
                }
            }
        }
    }
}
