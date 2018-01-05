package com.vlocker.ui.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class an implements AnimatorUpdateListener {
    final /* synthetic */ PlayView a;

    an(PlayView playView) {
        this.a = playView;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.e = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        if (this.a.e > this.a.n) {
            this.a.e = this.a.n;
        }
        if (this.a.i) {
            this.a.e = this.a.n - this.a.e;
        }
        this.a.o = (-(90.0f / (((float) this.a.k) * 1.0f))) * ((float) this.a.e);
        if (this.a.o <= -90.0f) {
            this.a.o = -90.0f;
        }
        this.a.postInvalidate();
    }
}
