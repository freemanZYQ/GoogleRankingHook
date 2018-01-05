package com.vlocker.weather;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class v implements AnimatorListener {
    final /* synthetic */ Weather2Activity a;

    v(Weather2Activity weather2Activity) {
        this.a = weather2Activity;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
        this.a.h();
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
    }
}
