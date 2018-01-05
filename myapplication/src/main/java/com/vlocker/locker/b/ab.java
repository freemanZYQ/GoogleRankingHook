package com.vlocker.locker.b;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.vlocker.ui.cover.g;

class ab implements AnimatorListener {
    final /* synthetic */ p a;
    private boolean b;

    public ab(p pVar, boolean z) {
        this.a = pVar;
        this.b = z;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
        this.a.a(this.b ? g.g() : "main_page", false);
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
    }
}
