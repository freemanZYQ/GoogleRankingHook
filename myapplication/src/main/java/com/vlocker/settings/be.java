package com.vlocker.settings;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import java.util.Date;

class be implements AnimationListener {
    final /* synthetic */ int a;
    final /* synthetic */ bd b;

    be(bd bdVar, int i) {
        this.b = bdVar;
        this.a = i;
    }

    public void onAnimationEnd(Animation animation) {
        if (this.a > 0) {
            this.b.a.j.sendEmptyMessageDelayed(1, 2000);
        } else {
            this.b.a.j.removeMessages(1);
        }
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
        this.b.a.j.removeMessages(1);
        if (LockerSettingsActivity.b >= 5) {
            this.b.a.o = new Date().getTime();
            this.b.a.j.removeCallbacks(this.b.a.e);
            this.b.a.j.postDelayed(this.b.a.e, this.b.a.l.getDuration());
        }
    }
}
