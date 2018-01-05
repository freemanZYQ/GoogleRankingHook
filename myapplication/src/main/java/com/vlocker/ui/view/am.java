package com.vlocker.ui.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class am implements AnimatorListener {
    final /* synthetic */ PlayView a;

    am(PlayView playView) {
        this.a = playView;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
        this.a.j = false;
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
        this.a.j = true;
    }
}
