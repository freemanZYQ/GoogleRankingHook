package com.vlocker.weather;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class l implements AnimatorUpdateListener {
    final /* synthetic */ int a;
    final /* synthetic */ a b;

    l(a aVar, int i) {
        this.b = aVar;
        this.a = i;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        try {
            this.b.H.scrollTo(this.b.H.getScrollX(), ((Integer) valueAnimator.getAnimatedValue()).intValue() + this.a);
        } catch (Exception e) {
        }
    }
}
