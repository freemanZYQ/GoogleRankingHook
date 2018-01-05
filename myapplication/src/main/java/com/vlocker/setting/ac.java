package com.vlocker.setting;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class ac implements AnimatorUpdateListener {
    final /* synthetic */ aa a;

    ac(aa aaVar) {
        this.a = aaVar;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.a.setBackgroundColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
    }
}
