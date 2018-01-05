package com.vlocker.l;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class q implements AnimatorListener {
    final /* synthetic */ Runnable a;
    final /* synthetic */ boolean b;
    final /* synthetic */ j c;

    q(j jVar, Runnable runnable, boolean z) {
        this.c = jVar;
        this.a = runnable;
        this.b = z;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
        if (this.a != null) {
            this.a.run();
        }
        if (this.b) {
            this.c.h();
        } else {
            this.c.j();
        }
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
    }
}
