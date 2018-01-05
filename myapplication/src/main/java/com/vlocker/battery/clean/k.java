package com.vlocker.battery.clean;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class k implements AnimatorListener {
    final /* synthetic */ CleanAnimView a;

    k(CleanAnimView cleanAnimView) {
        this.a = cleanAnimView;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
        this.a.B.a();
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
        this.a.a = 1;
        this.a.r = true;
    }
}
