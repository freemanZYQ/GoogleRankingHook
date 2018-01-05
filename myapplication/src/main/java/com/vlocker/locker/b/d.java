package com.vlocker.locker.b;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class d implements AnimatorListener {
    final /* synthetic */ c a;

    d(c cVar) {
        this.a = cVar;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
        this.a.a.f.setAlpha(1.0f);
        this.a.a.f.setVisibility(8);
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
    }
}
