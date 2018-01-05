package com.vlocker.new_theme.view;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class g implements AnimationListener {
    final /* synthetic */ int a;
    final /* synthetic */ TabFragmentIndicator b;

    g(TabFragmentIndicator tabFragmentIndicator, int i) {
        this.b = tabFragmentIndicator;
        this.a = i;
    }

    public void onAnimationEnd(Animation animation) {
        this.b.f.clearAnimation();
        try {
            this.b.f.setTranslationX(((float) this.b.h) * this.b.m);
        } catch (NoSuchMethodError e) {
            e.printStackTrace();
        } catch (Exception e2) {
        }
        this.b.o = false;
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
        this.b.c.setCurrentItem(this.a);
    }
}
