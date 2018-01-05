package com.vlocker.locker.c;

import android.content.Intent;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.vlocker.b.j;
import com.vlocker.locker.b.p;
import com.vlocker.theme.activity.UnlockTextEditActivity;
import com.vlocker.ui.cover.f;
import com.vlocker.ui.cover.g;
import com.vlocker.ui.cover.h;
import com.vlocker.ui.view.BatteryChargeView;
import com.vlocker.ui.widget.c;

class i implements c {
    final /* synthetic */ b a;

    i(b bVar) {
        this.a = bVar;
    }

    public void a() {
        this.a.m();
        this.a.z();
    }

    public void a(int i, int i2) {
        float t;
        boolean z = false;
        float f = 1.0f;
        b.e = true;
        b bVar = this.a;
        if (h.a != 1) {
            i = i2;
        }
        bVar.ac = i;
        if (!this.a.ad) {
            if (this.a.ac > this.a.af) {
                this.a.ad = true;
            } else {
                this.a.ad = false;
            }
        }
        if (h.j && this.a.ac > h.i) {
            z = true;
        }
        if (z) {
            this.a.ac = h.i;
        }
        if (System.currentTimeMillis() - this.a.ag >= 1000) {
            this.a.ah = this.a.ac;
            this.a.ag = System.currentTimeMillis();
        }
        if (h.a == 1) {
            this.a.l().setTranslationX((float) this.a.ac);
        } else if (h.a == 2) {
            this.a.l().setTranslationY((float) this.a.ac);
        } else {
            this.a.l().setTranslationY((float) (-this.a.ac));
        }
        if (!(h.a == 1 || this.a.w == null)) {
            t = (((float) this.a.ac) / ((float) (this.a.A / 2))) * 3.0f;
            if (t > 1.0f) {
                t = 1.0f;
            }
            this.a.w.setAlpha(1.0f - t);
        }
        t = h.a == 1 ? (((float) this.a.ac) * 2.0f) / ((float) this.a.z) : (((float) this.a.ac) * 2.0f) / ((float) this.a.A);
        float abs = ((float) Math.abs(this.a.ac)) / ((float) ((h.a == 1 ? this.a.z : this.a.A) / 2));
        if (abs > 1.0f) {
            abs = 1.0f;
        }
        if (h.f == 2 && this.a.l() != null) {
            this.a.l().setAlpha(1.0f - abs);
        }
        if (h.d == 2 && this.a.y != null) {
            this.a.y.setAlpha(1.0f - abs);
        }
        if (!BatteryChargeView.c) {
            p pVar = this.a.c;
            if (t <= 1.0f) {
                f = t;
            }
            pVar.a(f, this.a.D.i());
        }
    }

    public void a(boolean z) {
        if (!(this.a.ad || z || this.a.ae || !g.b())) {
            this.a.aa();
        }
        this.a.m();
        if (this.a.ac >= h.i) {
            if (f.e) {
                this.a.L();
            } else {
                if ("moxiu-launcher".equals(j.p(this.a.a))) {
                    com.vlocker.b.p.a(this.a.a, "Vlocker_Times_Unlock_PPC_TF", new String[0]);
                }
                this.a.c.e(this.a.J());
            }
        } else if (this.a.ac > 0) {
            if (!(h.a == 1 || this.a.w == null)) {
                this.a.w.animate().alpha(1.0f).setDuration(300).start();
            }
            if (h.d == 2 && this.a.y != null) {
                this.a.y.animate().translationX(0.0f).translationY(0.0f).alpha(1.0f).setDuration(300).setInterpolator(new AccelerateDecelerateInterpolator()).start();
            }
            this.a.l().animate().translationX(0.0f).translationY(0.0f).alpha(1.0f).setDuration(300).setInterpolator(new AccelerateDecelerateInterpolator()).start();
            if (!BatteryChargeView.c) {
                this.a.c.a(this.a.D.i());
            }
        }
        this.a.ac = 0;
        b.e = false;
    }

    public void b() {
        Intent intent = new Intent(this.a.a, UnlockTextEditActivity.class);
        intent.setFlags(268435456);
        this.a.a.startActivity(intent);
    }

    public boolean c() {
        this.a.ae = this.a.c.p();
        this.a.f();
        this.a.n();
        this.a.ad = false;
        this.a.ac = 0;
        this.a.ah = 0;
        this.a.ag = System.currentTimeMillis();
        this.a.l().setTranslationX(0.0f);
        return this.a.ae;
    }
}
