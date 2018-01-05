package com.vlocker.battery.clean;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class u implements AnimatorUpdateListener {
    final /* synthetic */ CleanIconAnimView a;

    u(CleanIconAnimView cleanIconAnimView) {
        this.a = cleanIconAnimView;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.r = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.a.postInvalidate();
    }
}
