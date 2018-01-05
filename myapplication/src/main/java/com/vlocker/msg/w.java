package com.vlocker.msg;

import android.animation.ValueAnimator;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.vlocker.locker.R;
import com.vlocker.m.l;
import com.vlocker.ui.cover.f;
import com.vlocker.ui.widget.CoverViewPager;

public class w implements aq {
    boolean a;
    private float b;
    private float c;
    private float d;
    private float e;
    private float f;
    private float g;
    private float h;
    private boolean i = false;
    private boolean j = false;
    private int k;
    private int l;
    private int m;
    private int n;
    private long o;
    private r p;
    private Context q;
    private final long r = 250;

    public w(Context context, r rVar) {
        this.p = rVar;
        this.q = context;
        a();
    }

    private void a() {
        this.p = this.p;
        this.k = (int) this.q.getResources().getDimension(R.dimen.l_msg_delete_img_parent_width);
        this.l = l.a(this.q, 30.0f);
        this.m = l.a(this.q, 500.0f);
        this.n = l.a();
        this.k = this.n / 3;
    }

    private void a(View view, float f, boolean z) {
        view.scrollBy((int) (-f), 0);
    }

    private void a(View view, boolean z, boolean z2) {
        if (view != null) {
            int scrollX = view.getScrollX();
            float alpha = view.getAlpha();
            int width = (view.getWidth() + scrollX) * -1;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            ofFloat.addUpdateListener(new x(this, view, scrollX, z, width, z2, alpha));
            long abs = (long) ((((float) Math.abs(scrollX)) / ((float) this.n)) * 500.0f);
            if (f.e) {
                abs = 300;
                if (z) {
                    abs = 100;
                }
            }
            ofFloat.setInterpolator(new LinearInterpolator());
            ofFloat.setDuration(abs);
            ofFloat.start();
        }
    }

    private void a(View view, boolean z, boolean z2, ar arVar) {
        if (view != null) {
            int scrollX = view.getScrollX();
            int width = view.getWidth();
            int dimension = ((int) this.q.getResources().getDimension(R.dimen.l_msg_item_height)) * 2;
            int dimension2 = (int) this.q.getResources().getDimension(R.dimen.l_battery_save_card_margin_left);
            if (dimension == 0) {
                dimension = width / 2;
            }
            dimension = ((dimension - scrollX) + dimension2) - l.a(14.0f);
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            ofFloat.addUpdateListener(new z(this, dimension, view, scrollX));
            ofFloat.setInterpolator(new LinearInterpolator());
            ofFloat.setDuration(250);
            ofFloat.start();
        }
    }

    public boolean a(View view, int i, int i2, MotionEvent motionEvent, int i3, ar arVar) {
        return false;
    }

    public boolean a(View view, MotionEvent motionEvent) {
        float f = 0.0f;
        CoverViewPager.a = true;
        switch (motionEvent.getAction()) {
            case 0:
                this.c = 0.0f;
                this.b = 0.0f;
                this.d = motionEvent.getRawX();
                this.e = motionEvent.getRawY();
                this.f = this.d;
                this.g = motionEvent.getRawX();
                this.h = motionEvent.getRawY();
                this.o = System.currentTimeMillis();
                if (view == null) {
                    this.j = false;
                    break;
                }
                this.j = true;
                break;
            case 2:
                this.g = motionEvent.getRawX();
                this.h = motionEvent.getRawY();
                this.f = this.g;
                break;
        }
        this.b = this.g > 0.0f ? Math.abs(this.g - this.d) : 0.0f;
        if (this.h > 0.0f) {
            f = Math.abs(this.h - this.e);
        }
        this.c = f;
        if (this.b <= this.c || !this.j || this.b < ((float) this.l) || view == null) {
            this.i = false;
        } else {
            this.i = true;
        }
        return this.i;
    }

    public boolean a(View view, MotionEvent motionEvent, ar arVar) {
        CoverViewPager.a = true;
        int action = motionEvent.getAction();
        this.g = motionEvent.getRawX();
        this.h = motionEvent.getRawY();
        float f;
        switch (action) {
            case 0:
                System.out.println("11111111111");
                break;
            case 1:
            case 3:
                if (view != null) {
                    f = this.g - this.d;
                    float abs = Math.abs(f);
                    long currentTimeMillis = System.currentTimeMillis() - this.o;
                    if (currentTimeMillis == 0) {
                        currentTimeMillis++;
                    }
                    currentTimeMillis = (long) ((1000.0f * abs) / ((float) currentTimeMillis));
                    if (abs >= ((float) this.k) || currentTimeMillis >= ((long) this.m)) {
                        if (f <= 0.0f) {
                            if (!this.a) {
                                a(view, true, currentTimeMillis >= ((long) this.m), arVar);
                                break;
                            }
                            a(view, true, false);
                            break;
                        }
                        a(view, false, currentTimeMillis >= ((long) this.m));
                        break;
                    }
                    a(view, true, false);
                    break;
                }
                break;
            case 2:
                if (view != null) {
                    f = this.g - this.d;
                    if (f.e && f > 0.0f && Math.abs(f) >= ((float) this.k)) {
                        this.p.a(this.g - this.f, null);
                        this.f = this.g;
                        break;
                    }
                    a(view, this.g - this.f, f > 0.0f);
                    this.f = this.g;
                    break;
                }
                break;
        }
        return (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) ? false : true;
    }
}
