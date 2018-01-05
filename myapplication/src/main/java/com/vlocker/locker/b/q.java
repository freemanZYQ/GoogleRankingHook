package com.vlocker.locker.b;

import android.os.Handler;
import android.support.v4.view.do;
import com.vlocker.f.j;
import com.vlocker.f.n;
import com.vlocker.locker.c.a;
import com.vlocker.locker.c.ai;
import com.vlocker.locker.c.b;
import com.vlocker.ui.cover.LockerService;
import com.vlocker.ui.cover.f;
import com.vlocker.ui.cover.g;
import com.vlocker.ui.view.BatteryChargeView;

class q implements do {
    boolean a;
    int b;
    final /* synthetic */ p c;

    q(p pVar) {
        this.c = pVar;
    }

    public void a(int i) {
        if (this.c.v != null && this.c.a == 0 && i == 1) {
            this.c.v = null;
        }
        this.c.a = i;
        g.a(((a) this.c.c.get(i)).d);
        if (this.b == 0) {
            for (int i2 = 0; i2 < this.c.c.size(); i2++) {
                ((a) this.c.c.get(i2)).d();
            }
            this.c.z();
        } else {
            this.a = true;
        }
        if (g.a() && this.c.r.cg()) {
            j.a().c();
            n.a = true;
        }
        if (!LockerService.e(this.c.i) || !this.c.r.cg()) {
            return;
        }
        if (g.c.equals("weather_page")) {
            j.a().a(this.c.G());
        } else if (com.vlocker.f.a.a.e()) {
            j.a().a(this.c.G());
        }
    }

    public void a(int i, float f, int i2) {
        boolean z = false;
        this.b = i2;
        if (BatteryChargeView.c) {
            if (f.e && this.c.r.ao() && !this.c.r.i() && i == 0) {
                this.c.l.a(f, true);
                this.c.l.a(1.0f - f, false);
            } else if (i == 0 && f.e && !this.c.r.i()) {
                this.c.l.a(f, true);
                this.c.l.a(1.0f - f, false);
            } else {
                this.c.l.a(1.0f, true);
            }
        } else if (!b.e) {
            if (i == 0 && f.e) {
                this.c.l.a(1.0f - f, this.c.r.i());
            } else if (this.c.r.W()) {
                if (f.e) {
                    z = true;
                }
                if (i == z) {
                    this.c.l.a(f, true);
                }
            }
        }
    }

    public void b(int i) {
        if (i == 1) {
            this.c.d();
        } else if (i == 0) {
            if (this.a) {
                for (int i2 = 0; i2 < this.c.c.size(); i2++) {
                    ((a) this.c.c.get(i2)).d();
                }
                this.c.z();
            }
            this.c.e();
        }
        this.a = false;
        if (g.c()) {
            if (this.c.r.cA() == 0 && this.c.r.cz() && !ai.e) {
                this.c.e.m();
                new Handler().postDelayed(new r(this), 2600);
                ai.e = true;
            }
            if (this.c.r.cz()) {
                ai.h = false;
            }
        }
    }
}
