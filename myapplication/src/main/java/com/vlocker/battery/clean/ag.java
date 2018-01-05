package com.vlocker.battery.clean;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class ag implements AnimatorListener {
    final /* synthetic */ af a;

    ag(af afVar) {
        this.a = afVar;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
        this.a.a.z.b();
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
    }
}
