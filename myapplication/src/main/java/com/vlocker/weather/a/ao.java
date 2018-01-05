package com.vlocker.weather.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class ao extends AnimatorListenerAdapter {
    final /* synthetic */ ah a;

    ao(ah ahVar) {
        this.a = ahVar;
    }

    public void onAnimationEnd(Animator animator) {
        this.a.d.setVisibility(8);
        this.a.d.setAlpha(1.0f);
        this.a.i.setVisibility(8);
    }
}
