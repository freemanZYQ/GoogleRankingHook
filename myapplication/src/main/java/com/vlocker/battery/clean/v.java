package com.vlocker.battery.clean;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class v implements AnimatorUpdateListener {
    final /* synthetic */ CleanIconAnimView a;

    v(CleanIconAnimView cleanIconAnimView) {
        this.a = cleanIconAnimView;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.s = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.a.postInvalidate();
    }
}
