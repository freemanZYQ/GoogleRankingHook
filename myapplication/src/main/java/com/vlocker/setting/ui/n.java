package com.vlocker.setting.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class n implements AnimatorUpdateListener {
    final /* synthetic */ HexagonContentView a;

    n(HexagonContentView hexagonContentView) {
        this.a = hexagonContentView;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.H = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.a.postInvalidate();
    }
}
