package com.vlocker.locker.b;

import android.animation.Animator.AnimatorListener;
import android.util.Log;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.BounceInterpolator;
import com.vlocker.b.p;
import com.vlocker.c.a;
import com.vlocker.g.b;
import com.vlocker.l.z;
import com.vlocker.ui.cover.g;
import com.vlocker.ui.cover.i;
import com.vlocker.ui.view.BatteryChargeView;

class ai implements z {
    final /* synthetic */ ag a;
    private boolean b = false;

    ai(ag agVar) {
        this.a = agVar;
    }

    public void a() {
        Log.e("liu---", "onOpened");
        if (!a.a(this.a.d).am()) {
            a.a(this.a.d).z(true);
            this.a.f.setVisibility(8);
        }
        this.a.g.setVisibility(4);
        this.a.c.j().setVisibility(4);
        this.a.c.d(4);
        b.a().b(false);
        this.a.c.a(1.0f, true);
        this.a.h.a(0.0f);
        p.a(this.a.d, "Vlocker_Open_Toolbox_PPC_TF", new String[0]);
        p.b("101000", "101001");
        p.a(this.a.d, "v_open", "101000", "101001", "1013");
        this.a.c.c(8);
    }

    public void a(float f) {
        Log.e("liu---", "onOpening alpha=" + f);
        if (!BatteryChargeView.c) {
            this.a.c.a(f, true);
        }
        this.a.c.c(f < 1.0f ? 0 : 8);
        this.a.c.a(1.0f - f);
    }

    public void a(boolean z) {
        float f = 0.0f;
        Log.e("liu---", "onPrepareAnim");
        p a = this.a.c;
        float f2 = (z || BatteryChargeView.c) ? 1.0f : 0.0f;
        a.a(f2, true, 200);
        p a2 = this.a.c;
        if (!z) {
            f = 1.0f;
        }
        a2.a(f, 150);
    }

    public void b() {
        Log.e("liu---", "onClosed BatteryChargeView.isShow=" + BatteryChargeView.c);
        this.a.c.a(1.0f);
        this.a.c.c(0);
        this.a.g.setVisibility(0);
        View j = this.a.c.j();
        if (j != null) {
            if (this.a.n.aw() && a.a(this.a.d)) {
                j.setVisibility(0);
            } else {
                j.setVisibility(8);
            }
        }
        this.a.c.d(0);
        b.a().b(true);
        this.a.h.a(180.0f);
        if (a.a(this.a.d).Q() && g.d()) {
            if (this.a.n.i()) {
                this.a.c.a(1.0f, true);
            } else {
                this.a.c.a(0.2f, false);
            }
        } else if (BatteryChargeView.c) {
            this.a.c.a(1.0f, true);
        } else {
            this.a.c.a(0.0f, true);
        }
    }

    public void c() {
        this.a.g.setVisibility(4);
        View j = this.a.c.j();
        j.setVisibility(4);
        b.a().b(false);
        j.clearAnimation();
        this.a.c.d(4);
        Log.e("liu---", "onPrepareOpening BatteryChargeView.isShow=" + BatteryChargeView.c);
    }

    public void d() {
        ViewPropertyAnimator animate = this.a.g.animate();
        if (animate != null && !this.b) {
            animate.cancel();
            Object iVar = new i();
            iVar.a(new AccelerateDecelerateInterpolator(), 200, false);
            iVar.a(new BounceInterpolator(), 500, true);
            animate.translationYBy((float) ((-this.a.g.getHeight()) / 4)).setInterpolator(iVar).setDuration(iVar.a());
            AnimatorListener ajVar = new aj(this, animate);
            this.b = true;
            animate.setListener(ajVar);
            animate.start();
        }
    }
}
