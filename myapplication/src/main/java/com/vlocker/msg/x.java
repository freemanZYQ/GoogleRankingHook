package com.vlocker.msg;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.vlocker.ui.cover.f;

class x implements AnimatorUpdateListener {
    final /* synthetic */ View a;
    final /* synthetic */ int b;
    final /* synthetic */ boolean c;
    final /* synthetic */ int d;
    final /* synthetic */ boolean e;
    final /* synthetic */ float f;
    final /* synthetic */ w g;

    x(w wVar, View view, int i, boolean z, int i2, boolean z2, float f) {
        this.g = wVar;
        this.a = view;
        this.b = i;
        this.c = z;
        this.d = i2;
        this.e = z2;
        this.f = f;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue;
        try {
            floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        } catch (Exception e) {
            floatValue = 0.0f;
        }
        if (f.e) {
            this.a.scrollTo((int) (((float) this.b) - (((float) this.b) * floatValue)), 0);
        } else {
            this.a.scrollTo(((int) (!this.c ? ((float) this.d) * floatValue : ((float) (-this.b)) * floatValue)) + this.b, 0);
        }
        if (!(this.g.p == null || this.g.a)) {
            this.g.p.a(floatValue, this.e);
        }
        if (this.a != null) {
            this.a.setAlpha(this.f + ((1.0f - this.f) * floatValue));
        }
        if (floatValue >= 1.0f) {
            this.g.a = false;
            if (!this.c) {
                if (!f.e) {
                    this.g.a(this.a, true, false);
                }
                if (this.g.p != null) {
                    this.g.p.a(new y(this), null);
                }
            }
        }
    }
}
