package com.vlocker.locker.c;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class x implements AnimatorListener {
    final /* synthetic */ w a;

    x(w wVar) {
        this.a = wVar;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
        this.a.b.b.ax = false;
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
    }
}
