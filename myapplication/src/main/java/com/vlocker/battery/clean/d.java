package com.vlocker.battery.clean;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class d implements AnimatorUpdateListener {
    final /* synthetic */ CleanAnimView a;

    d(CleanAnimView cleanAnimView) {
        this.a = cleanAnimView;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.n = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.a.postInvalidate();
    }
}
