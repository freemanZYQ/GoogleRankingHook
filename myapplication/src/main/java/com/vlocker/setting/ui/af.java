package com.vlocker.setting.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class af implements AnimatorUpdateListener {
    final /* synthetic */ HexagonView a;

    af(HexagonView hexagonView) {
        this.a = hexagonView;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.E = ((Float) valueAnimator.getAnimatedValue()).floatValue() + ((this.a.i * 1.2f) - 0.01f);
        this.a.postInvalidate();
    }
}
