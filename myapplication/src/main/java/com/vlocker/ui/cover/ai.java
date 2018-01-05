package com.vlocker.ui.cover;

import android.view.View;
import com.vlocker.battery.saver.b;
import com.vlocker.m.ab;
import com.vlocker.m.ak;
import com.vlocker.m.al;
import com.vlocker.m.bc;
import com.vlocker.msg.p;
import com.vlocker.security.MoSecurityApplication;
import com.vlocker.settings.DismissActivity;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ai implements af {
    final /* synthetic */ LockerService a;

    public ai(LockerService lockerService) {
        this.a = lockerService;
    }

    public void a(View view) {
        if (!this.a.y) {
            this.a.x.addView(view, bc.a(this.a.getApplicationContext(), this.a.x));
            this.a.y = true;
            try {
                this.a.l();
                if (this.a.q != null && this.a.i.cg() && ak.b(MoSecurityApplication.a())) {
                    this.a.q.a(this.a.u.G());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.a.k != null) {
                this.a.k.a(true);
            }
            view.setFocusableInTouchMode(true);
            view.setOnKeyListener(new aj(this));
            new Thread(new ak(this)).start();
        }
    }

    public void a(View view, int i) {
        if (this.a.y) {
            if (this.a.x != null) {
                this.a.x.removeViewImmediate(view);
            }
            if (this.a.i.dd()) {
                this.a.i.aS(false);
            }
            al.c();
            this.a.y = false;
            this.a.e = 0;
            this.a.w();
            try {
                if (this.a.q != null && this.a.i.cg()) {
                    this.a.q.c();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (!this.a.i.de()) {
                this.a.i.aT(true);
            }
            if (this.a.i.ch()) {
                Executors.newSingleThreadScheduledExecutor().schedule(new al(this), 10, TimeUnit.SECONDS);
            } else {
                DismissActivity.b(this.a.getApplicationContext());
            }
            this.a.p();
            ab.a(this.a.getApplicationContext());
            this.a.b(i);
            if (this.a.k != null) {
                this.a.k.a(false);
            }
            if (i == 2 || i == 10 || i == 8 || i == 15) {
                b.a(MoSecurityApplication.a()).c();
                if (i == 10 || i == 8 || i == 15) {
                    b.a(MoSecurityApplication.a()).a(true);
                }
            }
            if (i == 2) {
                p.a().a("weather_news");
                p.a().a("mx_update");
            }
        }
    }
}
