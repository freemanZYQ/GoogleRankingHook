package com.vlocker.locker.b;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class e implements AnimatorListener {
    final /* synthetic */ c a;

    e(c cVar) {
        this.a = cVar;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
        this.a.a.n.a(5, 0, new f(this));
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
    }
}
