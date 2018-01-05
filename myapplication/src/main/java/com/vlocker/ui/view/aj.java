package com.vlocker.ui.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class aj implements AnimatorUpdateListener {
    final /* synthetic */ NextView a;

    aj(NextView nextView) {
        this.a = nextView;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.h = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        if (this.a.h > 60) {
            this.a.h = 60;
        }
        this.a.postInvalidate();
    }
}
