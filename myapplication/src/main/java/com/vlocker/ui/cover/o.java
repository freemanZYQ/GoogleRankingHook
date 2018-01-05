package com.vlocker.ui.cover;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.vlocker.ui.graphic.LShapeHolder;

class o implements AnimatorListener {
    final /* synthetic */ LShapeHolder a;
    final /* synthetic */ LockPatternView b;

    o(LockPatternView lockPatternView, LShapeHolder lShapeHolder) {
        this.b = lockPatternView;
        this.a = lShapeHolder;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
        this.a.setAlpha(0.0f);
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
    }
}
