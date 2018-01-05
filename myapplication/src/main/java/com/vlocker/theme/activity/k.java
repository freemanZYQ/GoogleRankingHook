package com.vlocker.theme.activity;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.animation.AccelerateDecelerateInterpolator;

class k implements AnimatorListener {
    final /* synthetic */ ThemeDetailActivity a;

    k(ThemeDetailActivity themeDetailActivity) {
        this.a = themeDetailActivity;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
        this.a.a.animate().setStartDelay(0).translationX(0.0f).setDuration(400).setInterpolator(new AccelerateDecelerateInterpolator()).setListener(null).start();
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
    }
}
