package com.vlocker.ui.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.vlocker.locker.R;
import com.vlocker.ui.cover.f;

class d implements AnimatorUpdateListener {
    final /* synthetic */ View a;
    final /* synthetic */ int b;
    final /* synthetic */ boolean c;
    final /* synthetic */ int d;
    final /* synthetic */ boolean e;
    final /* synthetic */ View f;
    final /* synthetic */ float g;
    final /* synthetic */ MsgListView h;

    d(MsgListView msgListView, View view, int i, boolean z, int i2, boolean z2, View view2, float f) {
        this.h = msgListView;
        this.a = view;
        this.b = i;
        this.c = z;
        this.d = i2;
        this.e = z2;
        this.f = view2;
        this.g = f;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue;
        try {
            floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        } catch (Exception e) {
            floatValue = 0.0f;
        }
        if (f.e) {
            this.a.scrollTo((int) (((float) this.b) - (((float) this.b) * floatValue)), 0);
        } else {
            this.a.scrollTo(((int) (!this.c ? ((float) this.d) * floatValue : ((float) (-this.b)) * floatValue)) + this.b, 0);
        }
        if (this.h.u != null) {
            this.h.u.a(floatValue, this.e);
        }
        if (this.f != null) {
            this.f.setAlpha(this.g + ((1.0f - this.g) * floatValue));
        }
        if (floatValue >= 1.0f && !this.c) {
            String str;
            try {
                str = (String) this.a.findViewById(R.id.l_msg_pkg).getTag();
            } catch (Exception e2) {
                str = null;
            }
            if (!str.startsWith(this.h.v.getPackageName() + "|" + 8 + "|")) {
                if (!f.e) {
                    this.h.a(this.a, true, false);
                }
                if (this.h.u != null) {
                    this.h.u.b(str);
                }
            }
        }
    }
}
