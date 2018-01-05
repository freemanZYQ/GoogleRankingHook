package com.vlocker.ui.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;

public class ai implements AnimatorListener, AnimatorUpdateListener, aj {
    protected final Interpolator a = new DecelerateInterpolator();
    protected final float b;
    protected final float c;
    protected final ah d;
    final /* synthetic */ ag e;

    public ai(ag agVar, float f) {
        this.e = agVar;
        this.b = f;
        this.c = 2.0f * f;
        this.d = new ah();
    }

    protected Animator a() {
        float f = 0.0f;
        this.d.a(this.e.i);
        if (this.e.f == 0.0f || ((this.e.f < 0.0f && this.e.a.c) || (this.e.f > 0.0f && !this.e.a.c))) {
            return a(this.d.b);
        }
        float f2 = (-this.e.f) / this.b;
        if (f2 >= 0.0f) {
            f = f2;
        }
        f2 = (((-this.e.f) * this.e.f) / this.c) + this.d.b;
        ObjectAnimator a = a(this.e.i, (int) f, f2);
        ObjectAnimator a2 = a(f2);
        Animator animatorSet = new AnimatorSet();
        animatorSet.playSequentially(new Animator[]{a, a2});
        return animatorSet;
    }

    protected ObjectAnimator a(float f) {
        float abs = (Math.abs(f) / this.d.c) * 800.0f;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.e.i, this.d.a, new float[]{this.e.a.b});
        ofFloat.setDuration((long) Math.max((int) abs, 200));
        ofFloat.setInterpolator(this.a);
        ofFloat.addUpdateListener(this);
        return ofFloat;
    }

    protected ObjectAnimator a(View view, int i, float f) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, this.d.a, new float[]{f});
        ofFloat.setDuration((long) i);
        ofFloat.setInterpolator(this.a);
        ofFloat.addUpdateListener(this);
        return ofFloat;
    }

    public void a(aj ajVar) {
        Animator a = a();
        a.addListener(this);
        a.start();
    }

    public boolean a(MotionEvent motionEvent) {
        return true;
    }

    public boolean b(MotionEvent motionEvent) {
        return true;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
        this.e.a(this.e.b);
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
    }
}
