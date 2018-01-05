package com.vlocker.setting.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class ac implements AnimatorListener {
    final /* synthetic */ HexagonView a;

    ac(HexagonView hexagonView) {
        this.a = hexagonView;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
        if (this.a.C) {
            this.a.C = false;
            this.a.b(true);
        }
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
    }
}
