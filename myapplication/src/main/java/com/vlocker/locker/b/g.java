package com.vlocker.locker.b;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class g implements AnimationListener {
    final /* synthetic */ a a;

    g(a aVar) {
        this.a = aVar;
    }

    public void onAnimationEnd(Animation animation) {
        this.a.g.setVisibility(8);
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
        this.a.h();
    }
}
