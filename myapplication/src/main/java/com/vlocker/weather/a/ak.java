package com.vlocker.weather.a;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.animation.AccelerateDecelerateInterpolator;

class ak implements AnimatorListener {
    final /* synthetic */ ah a;

    ak(ah ahVar) {
        this.a = ahVar;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
        if (this.a.n) {
            this.a.d.animate().translationX(0.0f).setDuration(250).setInterpolator(new AccelerateDecelerateInterpolator()).setListener(new al(this)).start();
        }
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
    }
}
