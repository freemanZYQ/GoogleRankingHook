package com.vlocker.setting.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class w implements AnimatorUpdateListener {
    final /* synthetic */ HexagonContentView a;

    w(HexagonContentView hexagonContentView) {
        this.a = hexagonContentView;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.J = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.a.postInvalidate();
    }
}
