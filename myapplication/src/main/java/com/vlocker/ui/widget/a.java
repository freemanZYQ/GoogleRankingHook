package com.vlocker.ui.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class a implements AnimatorListener {
    final /* synthetic */ ArcText a;

    a(ArcText arcText) {
        this.a = arcText;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
        this.a.k = 0;
        this.a.c();
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
    }
}
