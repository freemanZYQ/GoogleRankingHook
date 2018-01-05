package com.vlocker.locker.c;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.vlocker.g.b;

class u extends AnimatorListenerAdapter {
    final /* synthetic */ b a;

    u(b bVar) {
        this.a = bVar;
    }

    public void onAnimationEnd(Animator animator) {
        b.a().k();
    }
}
