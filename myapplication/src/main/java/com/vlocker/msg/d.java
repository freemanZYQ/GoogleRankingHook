package com.vlocker.msg;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

class d implements AnimatorUpdateListener {
    final /* synthetic */ ar a;
    final /* synthetic */ int b;
    final /* synthetic */ View c;
    final /* synthetic */ a d;

    d(a aVar, ar arVar, int i, View view) {
        this.d = aVar;
        this.a = arVar;
        this.b = i;
        this.c = view;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue;
        try {
            floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        } catch (Exception e) {
            floatValue = 0.0f;
        }
        if (((double) floatValue) >= 1.0d) {
            this.d.a = false;
            this.a.c();
        }
        this.c.scrollTo(((int) (floatValue * ((float) (-this.b)))) + this.b, 0);
    }
}
