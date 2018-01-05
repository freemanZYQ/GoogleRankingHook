package com.vlocker.setting.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class x implements AnimatorListener {
    final /* synthetic */ HexagonContentView a;

    x(HexagonContentView hexagonContentView) {
        this.a = hexagonContentView;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
        this.a.J = -1.0f;
        this.a.A.start();
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
    }
}
