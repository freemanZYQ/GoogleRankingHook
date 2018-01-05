package com.vlocker.g;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.vlocker.b.p;
import java.util.Date;

class f implements AnimatorListener {
    final /* synthetic */ boolean a;
    final /* synthetic */ b b;

    f(b bVar, boolean z) {
        this.b = bVar;
        this.a = z;
    }

    public void onAnimationCancel(Animator animator) {
        this.b.o = false;
    }

    public void onAnimationEnd(Animator animator) {
        if (!this.a) {
            if (this.b.k != null) {
                p.a(this.b.d, "Vlocker_Close_LockerIcon_PPC_RR", "name", this.b.k.t);
            }
            this.b.f();
            this.b.m.W(new Date().getDate());
        }
        this.b.o = false;
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
        this.b.o = true;
    }
}
