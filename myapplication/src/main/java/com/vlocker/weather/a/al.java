package com.vlocker.weather.a;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.text.TextUtils;

class al implements AnimatorListener {
    final /* synthetic */ ak a;

    al(ak akVar) {
        this.a = akVar;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
        if (this.a.a.n && ah.j != null) {
            if (TextUtils.isEmpty(ah.j.c())) {
                this.a.a.d.a();
            } else {
                this.a.a.i();
            }
        }
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
    }
}
