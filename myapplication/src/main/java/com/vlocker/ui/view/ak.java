package com.vlocker.ui.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class ak implements AnimatorListener {
    final /* synthetic */ NextView a;

    ak(NextView nextView) {
        this.a = nextView;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
        this.a.o = false;
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
        this.a.o = true;
    }
}
