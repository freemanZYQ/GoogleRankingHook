package com.vlocker.setting.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class i implements AnimatorListener {
    final /* synthetic */ boolean a;
    final /* synthetic */ b b;

    i(b bVar, boolean z) {
        this.b = bVar;
        this.a = z;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
        if (!this.a) {
            try {
                this.b.m.post(new j(this));
            } catch (Exception e) {
            }
        }
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
    }
}
