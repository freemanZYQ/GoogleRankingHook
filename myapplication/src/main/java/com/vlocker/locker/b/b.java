package com.vlocker.locker.b;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.ViewPropertyAnimator;

class b implements AnimatorListener {
    final /* synthetic */ ViewPropertyAnimator a;
    final /* synthetic */ a b;

    b(a aVar, ViewPropertyAnimator viewPropertyAnimator) {
        this.b = aVar;
        this.a = viewPropertyAnimator;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
        this.b.d();
        this.a.setListener(null);
        this.b.f.setVisibility(8);
        this.b.o = false;
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
    }
}
