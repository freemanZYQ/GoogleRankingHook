package com.vlocker.locker.c;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class t extends AnimatorListenerAdapter {
    final /* synthetic */ b a;

    t(b bVar) {
        this.a = bVar;
    }

    public void onAnimationEnd(Animator animator) {
        if (this.a.c != null) {
            this.a.c.e();
        }
        this.a.m();
    }
}
