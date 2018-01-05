package com.vlocker.battery.clean;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class f implements AnimatorUpdateListener {
    final /* synthetic */ CleanAnimView a;

    f(CleanAnimView cleanAnimView) {
        this.a = cleanAnimView;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.n = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.a.o = 0.6f - (((Float) valueAnimator.getAnimatedValue()).floatValue() - 6.5f);
        this.a.postInvalidate();
    }
}
