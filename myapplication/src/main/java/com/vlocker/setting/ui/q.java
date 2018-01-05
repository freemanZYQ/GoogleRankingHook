package com.vlocker.setting.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class q implements AnimatorListener {
    final /* synthetic */ HexagonContentView a;

    q(HexagonContentView hexagonContentView) {
        this.a = hexagonContentView;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
    }

    public void onAnimationRepeat(Animator animator) {
        this.a.ab = !this.a.ab;
        this.a.I = 0.0f;
        this.a.H = 0.0f;
        if (this.a.aa) {
            this.a.B.cancel();
            this.a.A.cancel();
            this.a.G.start();
            return;
        }
        this.a.B.start();
    }

    public void onAnimationStart(Animator animator) {
        this.a.ab = !this.a.ab;
        this.a.I = 0.0f;
        this.a.B.start();
    }
}
