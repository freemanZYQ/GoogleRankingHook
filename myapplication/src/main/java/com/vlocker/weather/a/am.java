package com.vlocker.weather.a;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.animation.AccelerateDecelerateInterpolator;

class am implements AnimatorListener {
    final /* synthetic */ ah a;

    am(ah ahVar) {
        this.a = ahVar;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
        if (this.a.n && ah.j != null) {
            this.a.i.animate().setStartDelay(0).scaleX(1.0f).scaleY(1.0f).setDuration(150).setInterpolator(new AccelerateDecelerateInterpolator()).setListener(new an(this)).start();
        }
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
    }
}
