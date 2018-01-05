package com.vlocker.setting.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class ag implements AnimatorListener {
    final /* synthetic */ HexagonView a;

    ag(HexagonView hexagonView) {
        this.a = hexagonView;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
        this.a.w.postDelayed(new ah(this), 700);
    }
}
