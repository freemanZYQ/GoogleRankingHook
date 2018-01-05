package com.vlocker.setting.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class v implements AnimatorUpdateListener {
    final /* synthetic */ HexagonContentView a;

    v(HexagonContentView hexagonContentView) {
        this.a = hexagonContentView;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.P = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.a.postInvalidate();
    }
}
