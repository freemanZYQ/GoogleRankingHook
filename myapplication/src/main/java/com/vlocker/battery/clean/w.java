package com.vlocker.battery.clean;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class w implements AnimatorUpdateListener {
    final /* synthetic */ CleanIconAnimView a;

    w(CleanIconAnimView cleanIconAnimView) {
        this.a = cleanIconAnimView;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.t = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.a.postInvalidate();
    }
}
