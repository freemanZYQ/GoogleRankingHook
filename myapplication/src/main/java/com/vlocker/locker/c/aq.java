package com.vlocker.locker.c;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.vlocker.ui.cover.f;

class aq implements AnimationListener {
    final /* synthetic */ int a;
    final /* synthetic */ ao b;

    aq(ao aoVar, int i) {
        this.b = aoVar;
        this.a = i;
    }

    public void onAnimationEnd(Animation animation) {
        if (this.a > 0) {
            this.b.q.sendEmptyMessageDelayed(1, 2000);
        } else {
            this.b.q.removeMessages(1);
        }
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
        this.b.q.removeMessages(1);
        if (f.f >= 5) {
            this.b.r = System.currentTimeMillis() + this.b.m.getDuration();
            this.b.q.removeCallbacks(this.b.g);
            this.b.q.postDelayed(this.b.g, this.b.m.getDuration());
        }
    }
}
