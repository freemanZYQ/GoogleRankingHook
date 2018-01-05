package com.vlocker.battery.clean;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class ad implements AnimatorUpdateListener {
    final /* synthetic */ y a;

    ad(y yVar) {
        this.a = yVar;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.c((int) ((1.0f - ((Float) valueAnimator.getAnimatedValue()).floatValue()) * ((float) (-this.a.G))));
    }
}
