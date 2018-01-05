package com.vlocker.locker.c;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.ViewPropertyAnimator;
import android.view.animation.BounceInterpolator;
import com.vlocker.ui.cover.h;

class w implements AnimatorListener {
    final /* synthetic */ ViewPropertyAnimator a;
    final /* synthetic */ v b;

    w(v vVar, ViewPropertyAnimator viewPropertyAnimator) {
        this.b = vVar;
        this.a = viewPropertyAnimator;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
        this.a.cancel();
        this.a.setListener(new x(this));
        if (h.a == 1) {
            this.a.setInterpolator(new BounceInterpolator()).translationX(0.0f).setDuration(500).start();
        } else if (h.a == 2) {
            this.a.setInterpolator(new BounceInterpolator()).translationY(0.0f).setDuration(500).start();
        } else if (h.a == 3) {
            this.a.setInterpolator(new BounceInterpolator()).translationY(0.0f).setDuration(500).start();
        }
    }

    public void onAnimationRepeat(Animator animator) {
        animator.cancel();
    }

    public void onAnimationStart(Animator animator) {
        this.b.b.ax = true;
    }
}
