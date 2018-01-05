package com.vlocker.locker.c;

import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

class af implements Runnable {
    final /* synthetic */ b a;

    af(b bVar) {
        this.a = bVar;
    }

    public void run() {
        Animation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(1000);
        alphaAnimation.setAnimationListener(new ag(this));
        alphaAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        this.a.q.startAnimation(alphaAnimation);
    }
}
