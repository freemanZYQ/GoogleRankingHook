package com.vlocker.setting.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class ad implements AnimatorUpdateListener {
    final /* synthetic */ HexagonView a;

    ad(HexagonView hexagonView) {
        this.a = hexagonView;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.i = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        if (!(this.a.i < 0.5f || this.a.D || this.a.B)) {
            this.a.D = true;
            this.a.b(false);
        }
        this.a.postInvalidate();
    }
}
