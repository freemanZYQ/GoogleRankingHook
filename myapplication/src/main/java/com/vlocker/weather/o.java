package com.vlocker.weather;

import com.vlocker.msg.p;
import com.vlocker.ui.cover.LockerService;
import com.vlocker.weather.c.d.c;

class o implements Runnable {
    final /* synthetic */ m a;

    o(m mVar) {
        this.a = mVar;
    }

    public void run() {
        p.a().a("weather_news");
        this.a.a.H();
        LockerService.a().a("weather_page", true);
        c.a().c().a();
    }
}
