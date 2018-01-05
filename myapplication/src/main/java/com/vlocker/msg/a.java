package com.vlocker.msg;

import android.animation.ValueAnimator;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import com.vlocker.locker.R;
import com.vlocker.m.l;
import com.vlocker.ui.widget.CoverViewPager;

public class a implements aq {
    boolean a;
    private Context b;
    private float c;
    private float d;
    private float e = 1.0f;
    private float f;
    private int g;
    private int h;

    public a(Context context) {
        this.b = context;
        this.g = l.a();
    }

    private void a(View view, float f, boolean z) {
        view.scrollBy((int) (-f), 0);
    }

    private void a(View view, int i, int i2, ar arVar) {
        if (view != null) {
            int scrollX = view.getScrollX();
            if (scrollX == 0) {
                return;
            }
            if (this.a) {
                a(view, arVar);
                return;
            }
            int width = view.findViewById(i).getWidth();
            if (this.h != 0) {
                width *= 2;
            }
            int dimension = (int) this.b.getResources().getDimension(R.dimen.l_battery_save_card_margin_left);
            int i3 = width == 0 ? this.g / 2 : width;
            int i4 = (i3 - scrollX) + dimension;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            ofFloat.addUpdateListener(new b(this, scrollX, i3, i4, view, arVar));
            ofFloat.setInterpolator(new DecelerateInterpolator());
            ofFloat.setDuration(300);
            ofFloat.start();
        }
    }

    private void a(View view, ar arVar) {
        if (this.a) {
            int scrollX = view.getScrollX();
            if (scrollX != 0) {
                ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
                ofFloat.addUpdateListener(new d(this, arVar, scrollX, view));
                ofFloat.setInterpolator(new DecelerateInterpolator());
                ofFloat.setDuration(300);
                ofFloat.start();
            }
        }
    }

    public boolean a(View view, int i, int i2, MotionEvent motionEvent, int i3, ar arVar) {
        try {
            this.h = i3;
            switch (motionEvent.getAction()) {
                case 0:
                    CoverViewPager.a = true;
                    this.c = 0.0f;
                    this.d = motionEvent.getRawX();
                    float rawX = motionEvent.getRawX();
                    this.e = rawX;
                    this.f = rawX;
                    break;
                case 1:
                case 3:
                    this.e = motionEvent.getRawX();
                    a(view, i, i2, arVar);
                    break;
                case 2:
                    this.e = motionEvent.getRawX();
                    this.c = this.e - this.d;
                    if (this.c >= 0.0f && view.getScrollX() <= 0) {
                        if (this.c > 0.0f || view.getScrollX() < 0) {
                            CoverViewPager.b = true;
                            CoverViewPager.a = false;
                            break;
                        }
                    }
                    CoverViewPager.a = true;
                    CoverViewPager.b = false;
                    if (view.getScrollX() > 10) {
                        arVar.a();
                    }
                    a(view, this.e - this.f, true);
                    this.f = this.e;
                    break;
                    break;
            }
            if (Math.abs(this.e - this.d) > 0.0f && view.getScrollX() <= 0 && this.e > this.d) {
                arVar.c();
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (motionEvent.getAction() != 1 && motionEvent.getAction() != 3) {
            return true;
        }
        if (this.c >= 0.0f) {
            arVar.c();
        }
        arVar.b();
        return false;
    }
}
