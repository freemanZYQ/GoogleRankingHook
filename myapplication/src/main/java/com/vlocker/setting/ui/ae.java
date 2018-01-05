package com.vlocker.setting.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class ae implements AnimatorListener {
    final /* synthetic */ HexagonView a;

    ae(HexagonView hexagonView) {
        this.a = hexagonView;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
    }

    public void onAnimationRepeat(Animator animator) {
        this.a.D = false;
        if (!this.a.B) {
            this.a.b(false);
        }
    }

    public void onAnimationStart(Animator animator) {
        this.a.D = false;
        if (!this.a.B) {
            this.a.b(false);
        }
    }
}
