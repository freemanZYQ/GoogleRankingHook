package com.vlocker.battery.clean;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class ai implements AnimatorListener {
    final /* synthetic */ CleanMaskButtonView a;

    ai(CleanMaskButtonView cleanMaskButtonView) {
        this.a = cleanMaskButtonView;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
        this.a.c.cancel();
        this.a.c.start();
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
    }
}
