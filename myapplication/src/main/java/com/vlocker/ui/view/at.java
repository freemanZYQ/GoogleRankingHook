package com.vlocker.ui.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class at implements AnimatorListener {
    final /* synthetic */ WaveAnimView a;

    at(WaveAnimView waveAnimView) {
        this.a = waveAnimView;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
        if (this.a.e) {
            animator.setStartDelay(1100);
            animator.start();
        }
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
    }
}
