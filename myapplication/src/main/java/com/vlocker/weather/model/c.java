package com.vlocker.weather.model;

import com.vlocker.locker.d.i;

class c extends i {
    final /* synthetic */ f a;
    final /* synthetic */ MXWeatherWidget b;

    c(MXWeatherWidget mXWeatherWidget, f fVar) {
        this.b = mXWeatherWidget;
        this.a = fVar;
    }

    public void a(String str) {
        super.a(str);
        new Thread(new d(this, str)).start();
    }

    public void a(Throwable th, int i, String str) {
        super.a(th, i, str);
        new Thread(new e(this)).start();
    }

    public void c() {
        super.c();
    }
}
