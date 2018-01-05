package com.vlocker.weather.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class aq extends AnimatorListenerAdapter {
    final /* synthetic */ ah a;

    aq(ah ahVar) {
        this.a = ahVar;
    }

    public void onAnimationEnd(Animator animator) {
        this.a.e.setVisibility(8);
        this.a.e.setAlpha(1.0f);
    }
}
