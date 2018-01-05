package com.vlocker.battery.clean;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class ah implements AnimatorUpdateListener {
    final /* synthetic */ CleanMaskButtonView a;

    ah(CleanMaskButtonView cleanMaskButtonView) {
        this.a = cleanMaskButtonView;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.b = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.a.postInvalidate();
    }
}
