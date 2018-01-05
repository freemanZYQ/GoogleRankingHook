package com.vlocker.weather.a;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.text.TextUtils.TruncateAt;

class an implements AnimatorListener {
    final /* synthetic */ am a;

    an(am amVar) {
        this.a = amVar;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
        if (this.a.a.n && ah.j != null) {
            this.a.a.d.a();
            this.a.a.g.setEllipsize(TruncateAt.MARQUEE);
            this.a.a.k();
        }
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
    }
}
