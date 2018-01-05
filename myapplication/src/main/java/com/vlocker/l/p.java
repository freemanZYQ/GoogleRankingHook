package com.vlocker.l;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class p implements OnTouchListener {
    boolean a;
    int b;
    int c;
    final /* synthetic */ j d;

    p(j jVar) {
        this.d = jVar;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z = true;
        int rawY = ((int) motionEvent.getRawY()) - this.d.l;
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.a = false;
                this.b = rawY;
                this.c = rawY;
                if (!this.d.b()) {
                    this.d.i();
                    this.d.e();
                    break;
                }
                break;
            case 1:
            case 3:
                if (!this.d.b(rawY) || this.a) {
                    z = false;
                }
                int a = this.d.a();
                if (a == 0) {
                    this.d.c.measure(Integer.MIN_VALUE, 0);
                    a = this.d.c.getMeasuredHeight();
                }
                if (rawY - this.c < this.d.m && this.d.b()) {
                    z = false;
                }
                this.d.a(z ? (float) (this.d.d.getHeight() - a) : (float) this.d.d.getHeight(), z);
                break;
            case 2:
                if (rawY <= this.b || Math.abs(rawY - this.b) <= this.d.m) {
                    z = false;
                }
                this.a = z;
                this.b = rawY;
                if (rawY < this.d.d.getHeight()) {
                    this.d.a(rawY - (this.d.e.getHeight() / 2));
                    break;
                }
                break;
        }
        return false;
    }
}
