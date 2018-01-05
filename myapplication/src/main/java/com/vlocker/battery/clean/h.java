package com.vlocker.battery.clean;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class h implements AnimatorUpdateListener {
    final /* synthetic */ CleanAnimView a;

    h(CleanAnimView cleanAnimView) {
        this.a = cleanAnimView;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.n = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.a.o = ((((Float) valueAnimator.getAnimatedValue()).floatValue() - 7.0f) * 0.6f) + 0.1f;
        this.a.postInvalidate();
    }
}
