package com.vlocker.ui.widget.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

class t extends AnimatorListenerAdapter {
    final /* synthetic */ boolean a;
    final /* synthetic */ View b;
    final /* synthetic */ View c;
    final /* synthetic */ r d;

    t(r rVar, boolean z, View view, View view2) {
        this.d = rVar;
        this.a = z;
        this.b = view;
        this.c = view2;
    }

    public void onAnimationCancel(Animator animator) {
        if (!(this.a || this.b == null)) {
            this.b.setSelected(false);
        }
        super.onAnimationCancel(animator);
    }

    public void onAnimationEnd(Animator animator) {
        if (!this.a) {
            if (this.b != null) {
                this.b.setAlpha(0.0f);
                this.b.setSelected(false);
            }
            if (this.c != null) {
                this.c.setAlpha(1.0f);
            }
            this.d.b();
        }
        if (LockNumberPointView.r == 3) {
            if (this.b != null) {
                this.b.setAlpha(0.0f);
                this.b.setSelected(false);
            }
            if (this.c != null) {
                this.c.setAlpha(1.0f);
            }
        }
    }

    public void onAnimationStart(Animator animator) {
        if (this.a) {
            if (this.b != null) {
                this.b.setSelected(true);
                this.b.setAlpha(this.d.a);
            }
            if (this.c != null) {
                this.c.setAlpha(this.d.b);
            }
        }
    }
}
