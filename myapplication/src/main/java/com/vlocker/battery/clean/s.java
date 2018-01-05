package com.vlocker.battery.clean;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class s implements AnimatorUpdateListener {
    final /* synthetic */ CleanAnimView a;

    s(CleanAnimView cleanAnimView) {
        this.a = cleanAnimView;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.n = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.a.o = 1.0f - (((Float) valueAnimator.getAnimatedValue()).floatValue() * 0.8f);
        this.a.postInvalidate();
    }
}
