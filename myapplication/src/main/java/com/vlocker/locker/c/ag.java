package com.vlocker.locker.c;

import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class ag implements AnimationListener {
    final /* synthetic */ af a;

    ag(af afVar) {
        this.a = afVar;
    }

    public void onAnimationEnd(Animation animation) {
        if (this.a.a.q != null && this.a.a.q.getParent() != null) {
            ((ViewGroup) this.a.a.b).removeView(this.a.a.q);
        }
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }
}
