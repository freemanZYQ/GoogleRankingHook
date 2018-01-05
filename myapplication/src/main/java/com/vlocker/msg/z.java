package com.vlocker.msg;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

class z implements AnimatorUpdateListener {
    final /* synthetic */ int a;
    final /* synthetic */ View b;
    final /* synthetic */ int c;
    final /* synthetic */ w d;

    z(w wVar, int i, View view, int i2) {
        this.d = wVar;
        this.a = i;
        this.b = view;
        this.c = i2;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue;
        try {
            floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        } catch (Exception e) {
            floatValue = 0.0f;
        }
        float f = ((float) this.a) * floatValue;
        if (((double) floatValue) >= 1.0d) {
            this.d.a = true;
            this.b.postDelayed(new aa(this), 2000);
        }
        this.b.scrollTo(((int) f) + this.c, 0);
    }
}
