package com.vlocker.weather;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import com.vlocker.weather.model.MXWeatherWidget;

class j implements Runnable {
    final /* synthetic */ a a;

    j(a aVar) {
        this.a = aVar;
    }

    public void run() {
        this.a.p.setText("刷新成功");
        this.a.H.a();
        Context d = this.a.h;
        String str = MXWeatherWidget.WEATHER_CONFIG;
        this.a.h;
        Editor edit = d.getSharedPreferences(str, 0).edit();
        edit.putLong(MXWeatherWidget.WEATHER_CONFIG_GET_TIME, System.currentTimeMillis());
        edit.commit();
        this.a.j.c();
    }
}
