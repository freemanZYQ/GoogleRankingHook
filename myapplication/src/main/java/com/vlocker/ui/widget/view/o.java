package com.vlocker.ui.widget.view;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class o implements AnimationListener {
    final /* synthetic */ LockNumberPointView a;

    o(LockNumberPointView lockNumberPointView) {
        this.a = lockNumberPointView;
    }

    public void onAnimationEnd(Animation animation) {
        this.a.l.setSelected(false);
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }
}
