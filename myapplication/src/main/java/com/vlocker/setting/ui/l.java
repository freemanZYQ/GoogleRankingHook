package com.vlocker.setting.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class l implements AnimationListener {
    final /* synthetic */ boolean a;
    final /* synthetic */ b b;

    l(b bVar, boolean z) {
        this.b = bVar;
        this.a = z;
    }

    public void onAnimationEnd(Animation animation) {
        if (!this.a) {
            try {
                this.b.m.post(new m(this));
            } catch (Exception e) {
            }
        }
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }
}
