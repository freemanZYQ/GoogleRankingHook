package com.vlocker.g;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.ViewPropertyAnimator;

class h implements AnimatorListener {
    final /* synthetic */ ViewPropertyAnimator a;
    final /* synthetic */ b b;

    h(b bVar, ViewPropertyAnimator viewPropertyAnimator) {
        this.b = bVar;
        this.a = viewPropertyAnimator;
    }

    public void onAnimationCancel(Animator animator) {
        this.a.setListener(null);
    }

    public void onAnimationEnd(Animator animator) {
        this.a.setListener(null);
        this.b.v = false;
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
    }
}
