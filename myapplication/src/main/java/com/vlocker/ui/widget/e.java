package com.vlocker.ui.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

class e implements AnimatorUpdateListener {
    final /* synthetic */ int a;
    final /* synthetic */ View b;
    final /* synthetic */ int c;
    final /* synthetic */ boolean d;
    final /* synthetic */ boolean e;
    final /* synthetic */ View f;
    final /* synthetic */ float g;
    final /* synthetic */ String h;
    final /* synthetic */ MsgListView i;

    e(MsgListView msgListView, int i, View view, int i2, boolean z, boolean z2, View view2, float f, String str) {
        this.i = msgListView;
        this.a = i;
        this.b = view;
        this.c = i2;
        this.d = z;
        this.e = z2;
        this.f = view2;
        this.g = f;
        this.h = str;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue;
        try {
            floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        } catch (Exception e) {
            floatValue = 0.0f;
        }
        this.b.scrollTo(((int) (((float) this.a) * floatValue)) + this.c, 0);
        if (!(this.d || this.i.u == null)) {
            this.i.u.a(floatValue, this.e);
        }
        this.f.setAlpha(this.g - ((1.0f - this.g) * floatValue));
        if (floatValue == 1.0f) {
            if (!this.d) {
                try {
                    if (this.i.u != null) {
                        this.i.u.b(this.h);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } else if (this.i.u != null) {
                this.i.u.a(this.h);
            }
            this.f.setAlpha(1.0f);
            this.b.scrollTo(0, 0);
        }
    }
}
