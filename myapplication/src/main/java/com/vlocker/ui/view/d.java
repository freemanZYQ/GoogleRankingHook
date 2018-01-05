package com.vlocker.ui.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;

class d implements AnimatorListener {
    final /* synthetic */ boolean a;
    final /* synthetic */ View b;
    final /* synthetic */ BatteryChargeView c;

    d(BatteryChargeView batteryChargeView, boolean z, View view) {
        this.c = batteryChargeView;
        this.a = z;
        this.b = view;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
        if (!this.a) {
            this.b.setVisibility(4);
        }
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
        if (this.a) {
            this.b.setVisibility(0);
        }
    }
}
