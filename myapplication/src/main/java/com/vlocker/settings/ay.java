package com.vlocker.settings;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class ay implements AnimationListener {
    final /* synthetic */ boolean a;
    final /* synthetic */ LockNumberActivityNew b;

    ay(LockNumberActivityNew lockNumberActivityNew, boolean z) {
        this.b = lockNumberActivityNew;
        this.a = z;
    }

    public void onAnimationEnd(Animation animation) {
        this.b.e.postDelayed(new az(this), 1500);
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }
}
