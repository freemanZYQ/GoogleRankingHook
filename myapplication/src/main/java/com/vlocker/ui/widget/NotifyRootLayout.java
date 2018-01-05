package com.vlocker.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import com.vlocker.m.l;
import com.vlocker.msg.p;
import com.vlocker.ui.view.BatteryChargeView;

public class NotifyRootLayout extends LinearLayout {
    public static boolean a;
    private float b;
    private float c;
    private int d;
    private float e;
    private float f;
    private af g;
    private boolean h;

    public NotifyRootLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float x;
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.d = motionEvent.getPointerId(0);
                if (this.d == -1) {
                    this.d = 0;
                }
                a = false;
                this.h = false;
                x = motionEvent.getX(motionEvent.findPointerIndex(this.d));
                this.b = x;
                this.e = x;
                x = motionEvent.getY(motionEvent.findPointerIndex(this.d));
                this.c = x;
                this.f = x;
                break;
            case 2:
                try {
                    this.e = motionEvent.getX(motionEvent.findPointerIndex(this.d));
                    this.f = motionEvent.getY(motionEvent.findPointerIndex(this.d));
                    break;
                } catch (Exception e) {
                    break;
                }
        }
        x = this.e - this.b;
        float abs = Math.abs(this.f - this.c);
        if (!this.h) {
            if (Math.abs(abs) > Math.abs(x) && BatteryChargeView.c && this.f - this.c < -10.0f) {
                this.h = true;
                a = this.g.a();
            } else if (Math.abs(abs) > Math.abs(x) && BatteryChargeView.c && this.f - this.c > 10.0f && p.a().j()) {
                this.h = true;
                a = this.g.b();
            } else if (Math.abs(abs) > 10.0f || Math.abs(x) > ((float) l.a(getContext(), 30.0f))) {
                this.h = true;
            }
        }
        return a;
    }

    public void setCallback(af afVar) {
        this.g = afVar;
    }
}
