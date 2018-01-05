package com.vlocker.ui.widget;

import android.view.MotionEvent;

public class ak implements aj {
    final al a = new al();
    final /* synthetic */ ag b;

    public ak(ag agVar) {
        this.b = agVar;
    }

    public void a(aj ajVar) {
    }

    public boolean a(MotionEvent motionEvent) {
        if (!this.a.a(this.b.i, motionEvent)) {
            return false;
        }
        if ((!this.b.b() || !this.a.c) && (!this.b.c() || this.a.c)) {
            return false;
        }
        this.b.a.a = motionEvent.getPointerId(0);
        this.b.a.b = this.a.a;
        this.b.a.c = this.a.c;
        this.b.a(this.b.c);
        return this.b.c.a(motionEvent);
    }

    public boolean b(MotionEvent motionEvent) {
        return false;
    }
}
