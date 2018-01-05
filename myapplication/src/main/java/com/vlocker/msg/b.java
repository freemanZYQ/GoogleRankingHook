package com.vlocker.msg;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

class b implements AnimatorUpdateListener {
    final /* synthetic */ int a;
    final /* synthetic */ int b;
    final /* synthetic */ int c;
    final /* synthetic */ View d;
    final /* synthetic */ ar e;
    final /* synthetic */ a f;

    b(a aVar, int i, int i2, int i3, View view, ar arVar) {
        this.f = aVar;
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = view;
        this.e = arVar;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue;
        try {
            floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        } catch (Exception e) {
            floatValue = 0.0f;
        }
        float f;
        if (this.a >= this.b / 2) {
            f = ((float) this.c) * floatValue;
            if (((double) floatValue) >= 1.0d) {
                this.f.a = true;
                this.d.postDelayed(new c(this), 2000);
                floatValue = f;
            }
            floatValue = f;
        } else {
            f = ((float) (-this.a)) * floatValue;
            if (((double) floatValue) >= 1.0d) {
                this.f.a = false;
                this.e.c();
            }
            floatValue = f;
        }
        this.d.scrollTo(((int) floatValue) + this.a, 0);
    }
}
