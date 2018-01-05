package com.vlocker.ui.cover;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class n implements AnimatorUpdateListener {
    final /* synthetic */ LockPatternView a;

    n(LockPatternView lockPatternView) {
        this.a = lockPatternView;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.invalidate();
    }
}
