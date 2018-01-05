package com.vlocker.battery.clean;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class x implements AnimatorListener {
    final /* synthetic */ CleanIconAnimView a;

    x(CleanIconAnimView cleanIconAnimView) {
        this.a = cleanIconAnimView;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
        this.a.y = !this.a.y;
    }

    public void onAnimationRepeat(Animator animator) {
        this.a.y = !this.a.y;
    }

    public void onAnimationStart(Animator animator) {
    }
}
