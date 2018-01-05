package com.vlocker.weather.a;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class af implements AnimatorListener {
    final /* synthetic */ ad a;

    af(ad adVar) {
        this.a = adVar;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
    }

    public void onAnimationRepeat(Animator animator) {
        this.a.e.setVisibility(4);
        this.a.e.setAlpha(1.0f);
    }

    public void onAnimationStart(Animator animator) {
    }
}
