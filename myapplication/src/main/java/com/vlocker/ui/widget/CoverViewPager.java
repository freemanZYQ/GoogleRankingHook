package com.vlocker.ui.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.vlocker.c.a;
import com.vlocker.m.l;
import com.vlocker.msg.p;
import com.vlocker.search.as;
import com.vlocker.ui.cover.f;
import com.vlocker.ui.cover.g;
import com.vlocker.ui.cover.h;

public class CoverViewPager extends ViewPager {
    public static boolean a;
    public static boolean b;
    public static boolean c = true;
    private static boolean i;
    private c d;
    private as e;
    private a f;
    private float g;
    private float h;
    private boolean j;
    private boolean k;
    private boolean l;

    public CoverViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (motionEvent.getAction() == 1) {
            a = z;
            b = z;
            p.a = z;
            i = z;
            this.j = z;
            this.k = z;
            this.l = z;
        }
        try {
            z = super.dispatchTouchEvent(motionEvent);
        } catch (Exception e) {
        }
        return z;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.g = motionEvent.getRawX();
            this.h = motionEvent.getRawY();
            this.l = false;
        }
        if (!c) {
            return true;
        }
        if (f.e && getCurrentItem() == 0 && (h.h != 1 || h.a != 1)) {
            return false;
        }
        if (b) {
            return true;
        }
        if (a) {
            return false;
        }
        if ((h.c != 1 || (h.c == 1 && h.a != 1)) && f.e && getCurrentItem() == 1 && motionEvent.getRawX() - this.g > 0.0f) {
            return false;
        }
        try {
            return super.onInterceptTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!c) {
            return true;
        }
        if (f.e && getCurrentItem() == 0 && (h.h != 1 || h.a != 1)) {
            return false;
        }
        if (i) {
            return true;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.g = motionEvent.getRawX();
                this.h = motionEvent.getRawY();
                i = this.d.c();
                this.l = false;
                break;
            case 1:
                this.d.a(Math.abs(motionEvent.getRawX() - this.g) > 0.0f);
                this.e.x();
                break;
            case 2:
                float rawX = motionEvent.getRawX() - this.g;
                float rawY = motionEvent.getRawY() - this.h;
                float f = h.a == 1 ? rawX : h.a == 1 ? rawY : -rawY;
                this.f = a.a(getContext());
                try {
                    if (g.b()) {
                        if (Math.abs(rawY) < Math.abs(rawX) || Math.abs(rawX) > ((float) l.a(30.0f))) {
                            this.l = true;
                        }
                        if (!(this.e == null || this.l || !this.f.cJ())) {
                            this.e.a(rawY);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (h.c == 1) {
                    if (!this.k) {
                        if (!(f.e && getCurrentItem() == 1 && h.a != 1) && (f.e || getCurrentItem() != 0)) {
                            this.k = true;
                            this.j = false;
                        } else if (Math.abs(rawX) > ((float) l.a(10.0f)) || Math.abs(rawY) > ((float) l.a(10.0f))) {
                            this.k = true;
                            if (f > ((float) l.a(10.0f))) {
                                this.j = true;
                            } else {
                                this.j = false;
                            }
                        }
                    }
                    if (!this.k) {
                        return true;
                    }
                    if (this.k && this.j) {
                        if (f <= 0.0f) {
                            return true;
                        }
                        this.d.a(Math.abs((int) rawX), Math.abs((int) rawY));
                        return true;
                    }
                }
                if ((h.c != 1 || (h.c == 1 && h.a != 1)) && f.e && getCurrentItem() == 1 && motionEvent.getRawX() - this.g > 0.0f) {
                    return true;
                }
                break;
        }
        try {
            return super.onTouchEvent(motionEvent);
        } catch (Exception e2) {
            return false;
        }
    }

    public void setSearchCallback(as asVar) {
        this.e = asVar;
    }

    public void setUnlockCallback(c cVar) {
        this.d = cVar;
    }
}
