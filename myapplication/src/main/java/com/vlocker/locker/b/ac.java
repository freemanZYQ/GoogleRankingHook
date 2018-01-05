package com.vlocker.locker.b;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.View;
import com.vlocker.locker.R;
import com.vlocker.msg.ak;
import com.vlocker.msg.as;
import com.vlocker.msg.p;
import com.vlocker.msg.r;
import com.vlocker.msg.s;
import com.vlocker.service.NotificationListener;
import com.vlocker.setting.a.b;
import com.vlocker.ui.cover.LockerService;
import com.vlocker.ui.cover.f;
import com.vlocker.ui.cover.h;
import com.vlocker.ui.widget.CoverViewPager;

public class ac implements r, s {
    private p a;
    private Context b;
    private View c;
    private int d;
    private float e = 0.0f;
    private int f;

    public ac(Context context, p pVar) {
        this.b = context;
        this.a = pVar;
    }

    public void a() {
        this.a.x();
    }

    public void a(float f) {
        if (this.c != null) {
            this.c.setAlpha(f);
        }
    }

    public void a(float f, long j) {
        if (this.c != null) {
            this.c.animate().alpha(f).setDuration(j).start();
        }
    }

    public void a(float f, ak akVar) {
        this.e += f;
        if (f.e && h.a == 1 && h.b == 1 && !akVar.y && !"weather_news".equals(akVar.b)) {
            CoverViewPager k = this.a.k();
            if (k.d()) {
                k.b((float) ((int) f));
            }
        }
    }

    public void a(float f, boolean z) {
        CoverViewPager k = this.a.k();
        if (f.e && z) {
            int width = k.getWidth();
            if (f == 0.0f && this.e > 0.0f) {
                this.d = (int) (((float) width) - this.e);
            }
            width = (int) (((float) this.d) * f);
            if (h.a == 1 && h.b == 1) {
                if (k.d()) {
                    k.b((float) (width - this.f));
                }
                if (f == 1.0f) {
                    try {
                        k.e();
                    } catch (Exception e) {
                    }
                    this.d = 0;
                    this.f = 0;
                    this.e = 0.0f;
                    return;
                }
            }
            this.f = width;
            return;
        }
        try {
            if (k.d()) {
                k.e();
            }
        } catch (Exception e2) {
        }
        this.d = 0;
        this.f = 0;
        this.e = 0.0f;
    }

    public void a(int i) {
        if (this.c != null) {
            this.c.setVisibility(i);
        }
    }

    public void a(int i, Runnable runnable) {
        LockerService.a().a(5);
        runnable.run();
        new Handler().postDelayed(new ad(this, i), 20);
    }

    public void a(View view) {
        if (VERSION.SDK_INT >= 18 && b.CheckNotifiServiceValid(this.b)) {
            this.b.startService(new Intent(this.b, NotificationListener.class));
        }
        this.c = view;
        p.a().a(view, (r) this);
        p.a().a((s) this);
    }

    public void a(Runnable runnable, ak akVar) {
        if (runnable != null) {
            if (this.a.v() && as.a(this.b, akVar)) {
                a(5, runnable);
            } else if (!this.a.v() || akVar.y || "mx_clean".equals(akVar.b) || "weather_news".equals(akVar.b)) {
                runnable.run();
            } else {
                this.a.a(runnable, 2, this.b.getResources().getString(R.string.lk_number_password_ui_from_msg_tip));
            }
        }
    }

    public void b() {
        this.a.w();
    }

    public void c() {
        p.a().e();
    }
}
