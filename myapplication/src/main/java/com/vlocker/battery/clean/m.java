package com.vlocker.battery.clean;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class m implements AnimatorUpdateListener {
    final /* synthetic */ CleanAnimView a;

    m(CleanAnimView cleanAnimView) {
        this.a = cleanAnimView;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.m = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.a.postInvalidate();
    }
}
