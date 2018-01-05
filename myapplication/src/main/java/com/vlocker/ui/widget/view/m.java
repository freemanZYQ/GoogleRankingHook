package com.vlocker.ui.widget.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class m implements AnimatorListener {
    final /* synthetic */ LockNumberPointView a;

    m(LockNumberPointView lockNumberPointView) {
        this.a = lockNumberPointView;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
        this.a.n.setVisibility(8);
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
    }
}
