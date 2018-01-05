package com.vlocker.ui.widget;

import android.view.MotionEvent;

public class an implements aj {
    protected final float a;
    protected final float b;
    final al c = new al();
    int d;
    final /* synthetic */ ag e;

    public an(ag agVar, float f, float f2) {
        this.e = agVar;
        this.a = f;
        this.b = f2;
    }

    public void a(aj ajVar) {
        this.d = this.e.a.c ? this.e.g : this.e.h;
    }

    public boolean a(MotionEvent motionEvent) {
        if (this.e.a.a != motionEvent.getPointerId(0)) {
            this.e.a(this.e.d);
        } else if (this.c.a(this.e.i, motionEvent)) {
            float f = this.c.b / (this.c.c == this.e.a.c ? this.a : this.b);
            float f2 = this.c.a + f;
            if ((!this.e.a.c || this.c.c || f2 > this.e.a.b) && (this.e.a.c || !this.c.c || f2 < this.e.a.b)) {
                if (this.e.i.getParent() != null) {
                    this.e.i.getParent().requestDisallowInterceptTouchEvent(true);
                }
                long eventTime = motionEvent.getEventTime() - motionEvent.getHistoricalEventTime(0);
                if (eventTime > 0) {
                    this.e.f = f / ((float) eventTime);
                }
                this.e.a(this.e.i, f2);
            } else {
                this.e.a(this.e.i, this.e.a.b, motionEvent);
                this.e.a(this.e.b);
            }
        }
        return true;
    }

    public boolean b(MotionEvent motionEvent) {
        this.e.a(this.e.d);
        return true;
    }
}
