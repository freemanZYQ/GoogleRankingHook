package com.vlocker.k;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class s implements AnimatorUpdateListener {
    final /* synthetic */ float a;
    final /* synthetic */ p b;

    s(p pVar, float f) {
        this.b = pVar;
        this.a = f;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.b.b.setX(this.a > 0.0f ? this.a + ((((float) this.b.i) - this.a) * floatValue) : this.a - ((((float) this.b.i) + this.a) * floatValue));
        this.b.b.setAlpha(1.0f - (Math.abs(this.b.b.getX()) / ((float) this.b.i)));
        if (floatValue == 1.0f) {
            this.b.b();
        }
    }
}
