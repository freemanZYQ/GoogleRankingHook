package com.vlocker.ui.widget.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

class s implements AnimatorUpdateListener {
    final /* synthetic */ View a;
    final /* synthetic */ View b;
    final /* synthetic */ r c;

    s(r rVar, View view, View view2) {
        this.c = rVar;
        this.a = view;
        this.b = view2;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.c.a = ((Float) valueAnimator.getAnimatedValue("alpha")).floatValue();
        this.c.b = 1.0f - this.c.a;
        if (this.a != null) {
            this.a.setAlpha(this.c.a);
        }
        if (this.b != null) {
            this.b.setAlpha(this.c.b);
        }
    }
}
