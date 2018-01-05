package com.vlocker.setting;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.vlocker.m.l;

class ab implements AnimatorUpdateListener {
    final /* synthetic */ aa a;

    ab(aa aaVar) {
        this.a = aaVar;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.a((int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * ((float) l.a(130.0f))), this.a.I);
        this.a.a((int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * ((float) l.a(200.0f))), this.a.K);
    }
}
