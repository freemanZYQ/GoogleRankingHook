package com.vlocker.setting.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class p implements AnimatorListener {
    final /* synthetic */ HexagonContentView a;

    p(HexagonContentView hexagonContentView) {
        this.a = hexagonContentView;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
        this.a.T = false;
        this.a.K = -1.0f;
        this.a.f();
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
    }
}
