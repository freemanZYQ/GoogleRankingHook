package com.vlocker.setting.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class k implements AnimatorUpdateListener {
    final /* synthetic */ boolean a;
    final /* synthetic */ int b;
    final /* synthetic */ b c;

    k(b bVar, boolean z, int i) {
        this.c = bVar;
        this.a = z;
        this.b = i;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        int intValue;
        try {
            intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        } catch (Exception e) {
            intValue = 0;
        }
        if (this.a) {
            this.c.b.x = ((intValue - 100) * this.b) / 100;
        } else {
            this.c.b.x = ((-intValue) * this.b) / 100;
        }
        try {
            if (this.c.g.getParent() != null) {
                this.c.f.updateViewLayout(this.c.g, this.c.b);
            }
        } catch (Exception e2) {
        }
    }
}
