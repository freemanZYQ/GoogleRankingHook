package com.vlocker.ui.widget.view;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class n implements AnimationListener {
    final /* synthetic */ LockNumberPointView a;

    n(LockNumberPointView lockNumberPointView) {
        this.a = lockNumberPointView;
    }

    public void onAnimationEnd(Animation animation) {
        try {
            this.a.m.setAlpha(1.0f);
            this.a.m.startAnimation(this.a.o);
        } catch (Exception e) {
        }
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }
}
