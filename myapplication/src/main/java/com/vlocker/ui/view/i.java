package com.vlocker.ui.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import android.widget.FrameLayout;
import com.vlocker.battery.saver.b;
import com.vlocker.m.l;
import com.vlocker.msg.p;

class i implements AnimatorListener {
    final /* synthetic */ FrameLayout a;
    final /* synthetic */ BatteryProgressView b;
    final /* synthetic */ BatteryChargeView c;

    i(BatteryChargeView batteryChargeView, FrameLayout frameLayout, BatteryProgressView batteryProgressView) {
        this.c = batteryChargeView;
        this.a = frameLayout;
        this.b = batteryProgressView;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
        this.a.setPadding(0, 0, 0, 0);
        BatteryChargeView.h = false;
        this.b.a();
        if (this.c.H != null) {
            this.c.H.t();
        }
        View l = p.a().l();
        if (l != null) {
            b.a(this.c.getContext()).a(l, false);
        }
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
        this.c.setVisibility(8);
        this.a.setPadding(0, 0, 0, l.a(130.0f));
        if (this.c.H != null) {
            this.c.H.b(((int) this.c.H.g) - l.a(150.0f));
            this.c.H.c(-l.a(130.0f));
        }
        this.c.u.b();
    }
}
