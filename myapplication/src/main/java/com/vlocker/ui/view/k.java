package com.vlocker.ui.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.vlocker.locker.R;
import com.vlocker.m.l;

class k implements AnimatorListener {
    final /* synthetic */ BatteryChargeView a;
    final /* synthetic */ BatteryChargeView b;

    k(BatteryChargeView batteryChargeView, BatteryChargeView batteryChargeView2) {
        this.b = batteryChargeView;
        this.a = batteryChargeView2;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
        BatteryChargeView.h = false;
        this.b.u.a();
        if (this.b.H != null) {
            this.b.H.t();
        }
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
        this.b.setVisibility(0);
        if (this.b.H != null) {
            this.b.H.b(((int) (-this.b.H.g)) + l.a(14.0f));
            this.b.H.c(0);
        }
        ((BatteryProgressView) this.a.findViewById(R.id.layout_battery_wave)).b();
    }
}
