package com.vlocker.locker.c;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class aw implements AnimationListener {
    final /* synthetic */ int a;
    final /* synthetic */ int b;
    final /* synthetic */ ao c;

    aw(ao aoVar, int i, int i2) {
        this.c = aoVar;
        this.a = i;
        this.b = i2;
    }

    public void onAnimationEnd(Animation animation) {
        if (this.a >= 4) {
            this.c.q.removeMessages(1);
        } else if (this.b > 0) {
            this.c.q.sendEmptyMessageDelayed(1, 2000);
        } else {
            this.c.q.removeMessages(1);
        }
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
        this.c.q.removeMessages(1);
    }
}
