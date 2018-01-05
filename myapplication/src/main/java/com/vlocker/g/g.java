package com.vlocker.g;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class g implements AnimatorListener {
    final /* synthetic */ boolean a;
    final /* synthetic */ b b;

    g(b bVar, boolean z) {
        this.b = bVar;
        this.a = z;
    }

    public void onAnimationCancel(Animator animator) {
        this.b.o = false;
    }

    public void onAnimationEnd(Animator animator) {
        if (!this.a) {
            this.b.j.setVisibility(8);
        }
        this.b.o = false;
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
        this.b.o = true;
    }
}
