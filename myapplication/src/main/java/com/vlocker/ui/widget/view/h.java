package com.vlocker.ui.widget.view;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.vlocker.ui.cover.f;

class h implements AnimationListener {
    final /* synthetic */ int a;
    final /* synthetic */ LockNumberCoverView b;

    h(LockNumberCoverView lockNumberCoverView, int i) {
        this.b = lockNumberCoverView;
        this.a = i;
    }

    public void onAnimationEnd(Animation animation) {
        if (this.b.C) {
            this.b.v();
            this.b.c(0);
            this.b.C = false;
        }
        if (f.h <= 0 || this.a >= 4) {
            this.b.H.removeMessages(1);
        } else {
            this.b.H.sendEmptyMessageDelayed(1, 2000);
        }
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
        this.b.H.removeMessages(1);
    }
}
