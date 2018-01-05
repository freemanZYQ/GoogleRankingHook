package com.vlocker.battery.clean;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class p implements AnimatorListener {
    final /* synthetic */ CleanAnimView a;

    p(CleanAnimView cleanAnimView) {
        this.a = cleanAnimView;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
        this.a.v.start();
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
        this.a.a = 2;
    }
}
