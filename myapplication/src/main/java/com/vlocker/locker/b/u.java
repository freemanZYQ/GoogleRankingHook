package com.vlocker.locker.b;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.vlocker.m.ap;

class u implements AnimatorListener {
    final /* synthetic */ p a;

    u(p pVar) {
        this.a = pVar;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
        this.a.b(2);
        this.a.b.setTranslationX(0.0f);
        this.a.b.setTranslationY(0.0f);
        this.a.u().setAlpha(1.0f);
        this.a.a(0.0f, true);
        this.a.a(0.0f, false);
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
        if (this.a.r.P()) {
            ap.a(this.a.i).a("unlock1.ogg");
        }
    }
}
