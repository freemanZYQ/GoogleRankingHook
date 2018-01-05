package com.vlocker.ui.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class ar implements AnimatorUpdateListener {
    final /* synthetic */ WaveAnimView a;

    ar(WaveAnimView waveAnimView) {
        this.a = waveAnimView;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.a = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        this.a.postInvalidate();
    }
}
