package com.vlocker.l;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class o extends AnimatorListenerAdapter {
    final /* synthetic */ boolean a;
    final /* synthetic */ j b;

    o(j jVar, boolean z) {
        this.b = jVar;
        this.a = z;
    }

    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        if (!this.a) {
            this.b.a.run();
        }
    }
}
