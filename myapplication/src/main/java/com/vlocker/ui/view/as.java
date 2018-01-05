package com.vlocker.ui.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class as implements AnimatorUpdateListener {
    final /* synthetic */ WaveAnimView a;

    as(WaveAnimView waveAnimView) {
        this.a = waveAnimView;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.b = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        this.a.postInvalidate();
    }
}
