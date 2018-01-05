package com.vlocker.locker.c;

import android.content.Intent;
import com.vlocker.m.al;
import com.vlocker.msg.p;
import com.vlocker.ui.cover.g;
import com.vlocker.weather.a;
import com.vlocker.weather.a.y;
import com.vlocker.weather.e.d;

class ay implements Runnable {
    final /* synthetic */ ax a;

    ay(ax axVar) {
        this.a = axVar;
    }

    public void run() {
        try {
            if (g.a() && !g.c.equals("weather_page")) {
                al.c();
                p.a().a("weather_news");
                this.a.e.a(true, true);
                this.a.e.s();
                this.a.e.o();
                this.a.a.sendBroadcast(new Intent("com.vlocker.app.msgcount.remove.weahter"));
                d.a(this.a.a, "Weathe(V)_Open_DetailMore_PPC_YZY", new String[0]);
                this.a.e.v();
                a.b = true;
                com.vlocker.b.p.a();
                this.a.e.e();
                this.a.e.f();
            } else if (g.c.equals("weather_page")) {
                al.a(false);
                this.a.e.a(false);
                this.a.e.n();
                this.a.e.a(false, true);
                this.a.e.x();
                this.a.e.l();
                a.b = false;
                y.c = false;
                a.c = false;
                this.a.e.r();
                this.a.c(this.a.e.w());
            }
        } catch (Exception e) {
        }
    }
}
