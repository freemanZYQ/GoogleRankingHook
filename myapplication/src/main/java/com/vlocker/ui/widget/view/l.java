package com.vlocker.ui.widget.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class l implements AnimatorListener {
    final /* synthetic */ LockNumberPointView a;

    l(LockNumberPointView lockNumberPointView) {
        this.a = lockNumberPointView;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
        this.a.g();
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
    }
}
