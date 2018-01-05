package com.vlocker.locker.c;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.vlocker.locker.R;
import com.vlocker.locker.b.p;
import com.vlocker.m.x;
import com.vlocker.security.MoSecurityApplication;
import com.vlocker.ui.cover.LockerService;
import com.vlocker.ui.cover.g;
import com.vlocker.weather.a;
import com.vlocker.weather.a.y;
import com.vlocker.weather.c.d.c;
import com.vlocker.weather.e.d;
import com.vlocker.weather.z;

public class ax extends a {
    private a e;
    private z f;
    private Handler g = new Handler();
    private com.vlocker.c.a h;

    public ax(Context context, p pVar) {
        this.a = context;
        this.c = pVar;
        this.f = pVar.l();
        this.h = com.vlocker.c.a.a(context);
        this.d = "weather_page";
    }

    private void c(int i) {
        String str = "";
        if (i == 25 || i == 33) {
            str = "1/4";
        } else if (i == 50 || i == 75) {
            str = "1/2";
        } else {
            return;
        }
        d.a(this.a, "Weather(V)_DownScroll_PPC_YZY", "DownScroll", str);
    }

    private static boolean d(int i) {
        if ((i == 18 && x.a() == (byte) 0) || x.a() == (byte) 2) {
            MoSecurityApplication.a().sendBroadcast(new Intent("action_close_activity"));
        }
        if (i == 18 && x.a() == (byte) 0) {
            com.vlocker.c.a a = com.vlocker.c.a.a(MoSecurityApplication.a());
            if (a.S()) {
                LockerService.a().a("pwd_page", false);
            } else if (a.Q()) {
                LockerService.a().a("pattern_page", false);
            } else {
                x.a((byte) 0);
                return true;
            }
        }
        x.a((byte) 0);
        return false;
    }

    private boolean e(int i) {
        int parseInt;
        int parseInt2;
        int i2 = 2;
        try {
            String[] split = this.h.cR().split(":");
            parseInt = Integer.parseInt(split[0]);
            parseInt2 = Integer.parseInt(split[1]);
            i2 = Integer.parseInt(split[2]);
        } catch (Exception e) {
            parseInt2 = 0;
            parseInt = i2;
            i2 = 1;
        }
        parseInt2++;
        return (parseInt <= 0 || i2 <= 0 || parseInt2 < 1) ? false : i == parseInt || (i > parseInt && (i - parseInt) % parseInt2 == 0 && (i - parseInt) / parseInt2 <= i2 - 1);
    }

    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.b == null) {
            this.b = layoutInflater.inflate(R.layout.widget_weathercity, null);
            this.e = new a(this.a, this, this.b);
        }
        if (this.e == null) {
            this.e = new a(this.a, this, this.b);
        }
        return this.b;
    }

    public void a() {
        this.f.a();
    }

    public void a(int i, long j) {
        if (this.e != null) {
            this.e.a(false, false);
        }
        this.g.postDelayed(new az(i), j);
    }

    public void a(int i, Runnable runnable) {
        if (this.e != null) {
            this.e.a(false, false);
        }
        runnable.run();
        this.g.postDelayed(new az(i), 20);
    }

    public void a(Intent intent) {
        if (this.e != null) {
            this.e.a(intent);
        }
    }

    public void a(String str, String str2) {
    }

    public void a_(int i) {
        if (this.e != null) {
            this.e.b(i);
        }
    }

    public void b() {
        if (this.e != null) {
            this.e.g();
            this.e = null;
        }
    }

    public void c() {
        if (!g.a()) {
            return;
        }
        if (this.e == null || !this.e.y()) {
            this.c.a("main_page", true);
        }
    }

    public void d() {
        if (this.e != null) {
            this.g.post(new ay(this));
        }
    }

    public void e() {
        this.f.b();
    }

    public void f() {
        if (g.a() && this.e != null) {
            y.b = false;
            this.e.a(true, false);
            a.b = true;
            com.vlocker.b.p.a();
            this.e.e();
        }
    }

    public void g() {
        if (g.a() && this.e != null) {
            this.e.A();
        }
        if (this.e != null) {
            this.e.i();
        }
    }

    public void h() {
        if (a.d) {
            c.a().c().c();
            c.a().c().b();
        }
        if (this.e != null) {
            this.e.d();
        }
        if (e(this.h.cO()) && this.e != null) {
            this.e.B();
        }
    }

    public void i() {
        if (this.e != null) {
            a aVar = this.e;
            if (a.d && System.currentTimeMillis() - this.e.k() > 10800000) {
                com.vlocker.msg.p.a().a("weather_news");
            }
        }
    }
}
