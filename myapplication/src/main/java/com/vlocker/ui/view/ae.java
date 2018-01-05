package com.vlocker.ui.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class ae implements AnimatorListener {
    final /* synthetic */ MaskImageView a;

    ae(MaskImageView maskImageView) {
        this.a = maskImageView;
    }

    public void onAnimationCancel(Animator animator) {
        this.a.k = 0;
    }

    public void onAnimationEnd(Animator animator) {
        MaskImageView.b.removeCallbacks(this.a.s);
        MaskImageView.b.post(this.a.s);
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
        this.a.k = 0;
    }
}
