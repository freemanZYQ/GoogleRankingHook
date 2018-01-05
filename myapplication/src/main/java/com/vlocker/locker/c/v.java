package com.vlocker.locker.c;

import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import com.vlocker.ui.cover.h;

class v implements Runnable {
    final /* synthetic */ View a;
    final /* synthetic */ b b;

    v(b bVar, View view) {
        this.b = bVar;
        this.a = view;
    }

    public void run() {
        this.a.clearAnimation();
        ViewPropertyAnimator animate = this.a.animate();
        animate.cancel();
        animate.setListener(new w(this, animate));
        if (h.a == 1) {
            animate.setInterpolator(new DecelerateInterpolator()).translationX((float) this.b.aw).setDuration(200).start();
        } else if (h.a == 2) {
            animate.setInterpolator(new DecelerateInterpolator()).translationY((float) this.b.aw).setDuration(200).start();
        } else if (h.a == 3) {
            animate.setInterpolator(new DecelerateInterpolator()).translationY((float) (-this.b.aw)).setDuration(200).start();
        }
    }
}
