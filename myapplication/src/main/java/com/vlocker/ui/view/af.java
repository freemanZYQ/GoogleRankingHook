package com.vlocker.ui.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class af implements AnimatorListener {
    final /* synthetic */ MaskImageView a;

    af(MaskImageView maskImageView) {
        this.a = maskImageView;
    }

    public void onAnimationCancel(Animator animator) {
        this.a.k = 1;
    }

    public void onAnimationEnd(Animator animator) {
        MaskImageView.b.removeCallbacks(this.a.r);
        MaskImageView.b.post(this.a.r);
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
        this.a.k = 1;
    }
}
