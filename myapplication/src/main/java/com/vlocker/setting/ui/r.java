package com.vlocker.setting.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class r implements AnimatorUpdateListener {
    final /* synthetic */ HexagonContentView a;

    r(HexagonContentView hexagonContentView) {
        this.a = hexagonContentView;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.I = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.a.postInvalidate();
    }
}
