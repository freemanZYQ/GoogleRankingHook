package com.vlocker.setting;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class d implements AnimatorUpdateListener {
    final /* synthetic */ a a;

    d(a aVar) {
        this.a = aVar;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.a.setBackgroundColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
    }
}
