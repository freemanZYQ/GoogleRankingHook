package com.vlocker.setting.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class u implements AnimatorListener {
    final /* synthetic */ HexagonContentView a;

    u(HexagonContentView hexagonContentView) {
        this.a = hexagonContentView;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
        this.a.E.start();
        if (this.a.Q != null) {
            this.a.Q.a(this.a.W, this.a.V);
        }
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
    }
}
