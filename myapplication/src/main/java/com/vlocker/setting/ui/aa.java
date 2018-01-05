package com.vlocker.setting.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class aa implements AnimatorUpdateListener {
    final /* synthetic */ HexagonView a;

    aa(HexagonView hexagonView) {
        this.a = hexagonView;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.p = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.a.postInvalidate();
    }
}
