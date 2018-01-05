package com.vlocker.locker.c;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class ad implements AnimatorListener {
    final /* synthetic */ b a;

    ad(b bVar) {
        this.a = bVar;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
        this.a.N.setVisibility(8);
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
    }
}
