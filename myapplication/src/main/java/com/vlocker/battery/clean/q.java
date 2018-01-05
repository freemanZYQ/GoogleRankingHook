package com.vlocker.battery.clean;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class q implements AnimatorUpdateListener {
    final /* synthetic */ CleanAnimView a;

    q(CleanAnimView cleanAnimView) {
        this.a = cleanAnimView;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.m = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.a.postInvalidate();
    }
}
