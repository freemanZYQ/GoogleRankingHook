package com.vlocker.locker.b;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.ViewPropertyAnimator;

class aj implements AnimatorListener {
    final /* synthetic */ ViewPropertyAnimator a;
    final /* synthetic */ ai b;

    aj(ai aiVar, ViewPropertyAnimator viewPropertyAnimator) {
        this.b = aiVar;
        this.a = viewPropertyAnimator;
    }

    public void onAnimationCancel(Animator animator) {
        this.a.setListener(null);
    }

    public void onAnimationEnd(Animator animator) {
        this.a.setListener(null);
        this.b.b = false;
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
    }
}
