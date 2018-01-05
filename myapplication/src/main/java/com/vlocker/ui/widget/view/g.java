package com.vlocker.ui.widget.view;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.vlocker.ui.cover.f;

class g implements AnimationListener {
    final /* synthetic */ Animation a;
    final /* synthetic */ LockNumberCoverView b;

    g(LockNumberCoverView lockNumberCoverView, Animation animation) {
        this.b = lockNumberCoverView;
        this.a = animation;
    }

    public void onAnimationEnd(Animation animation) {
        if (this.b.C) {
            this.b.v();
            this.b.c(0);
            this.b.C = false;
        }
        if (f.h > 0) {
            this.b.H.sendEmptyMessageDelayed(1, 2000);
        } else {
            this.b.H.removeMessages(1);
        }
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
        this.b.H.removeMessages(1);
        if (f.h == 0) {
            this.b.v.removeCallbacks(this.b.i);
            this.b.v.postDelayed(this.b.i, this.a.getDuration());
            if (LockNumberCoverView.a) {
                this.b.M = System.currentTimeMillis() + this.a.getDuration();
            }
        }
    }
}
