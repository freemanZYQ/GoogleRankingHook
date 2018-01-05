package com.vlocker.locker.b;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.vlocker.ui.cover.h;

class v implements AnimatorUpdateListener {
    final /* synthetic */ float a;
    final /* synthetic */ float b;
    final /* synthetic */ p c;

    v(p pVar, float f, float f2) {
        this.c = pVar;
        this.a = f;
        this.b = f2;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        if (h.a == 1) {
            this.c.b.setTranslationX(this.a + ((((float) this.c.i.getResources().getDisplayMetrics().widthPixels) - this.a) * floatValue));
        } else if (h.a == 2) {
            this.c.b.setTranslationY(this.b + ((((float) this.c.i.getResources().getDisplayMetrics().heightPixels) - this.b) * floatValue));
        } else {
            this.c.b.setTranslationY(this.b - ((((float) this.c.i.getResources().getDisplayMetrics().heightPixels) - Math.abs(this.b)) * floatValue));
        }
        this.c.u().setAlpha(1.0f - floatValue);
    }
}
