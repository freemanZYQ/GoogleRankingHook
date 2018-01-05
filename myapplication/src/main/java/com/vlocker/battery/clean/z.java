package com.vlocker.battery.clean;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class z implements AnimatorListener {
    final /* synthetic */ y a;

    z(y yVar) {
        this.a = yVar;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
        this.a.C.e(this.a.i);
        this.a.u.removeView(this.a.v);
        this.a.s();
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
    }
}
