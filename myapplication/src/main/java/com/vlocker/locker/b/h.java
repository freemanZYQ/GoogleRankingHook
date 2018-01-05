package com.vlocker.locker.b;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class h implements AnimationListener {
    final /* synthetic */ a a;

    h(a aVar) {
        this.a = aVar;
    }

    public void onAnimationEnd(Animation animation) {
        this.a.h.setVisibility(8);
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }
}
