package com.vlocker.setting.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class o implements AnimatorUpdateListener {
    final /* synthetic */ HexagonContentView a;

    o(HexagonContentView hexagonContentView) {
        this.a = hexagonContentView;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.K = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.a.postInvalidate();
    }
}
