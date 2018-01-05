package com.vlocker.setting.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class ab implements AnimatorUpdateListener {
    final /* synthetic */ HexagonView a;

    ab(HexagonView hexagonView) {
        this.a = hexagonView;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.q = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.a.postInvalidate();
    }
}
