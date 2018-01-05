package com.vlocker.g;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class d implements OnTouchListener {
    float a;
    float b;
    float c;
    float d;
    boolean e;
    boolean f;
    final /* synthetic */ b g;

    d(b bVar) {
        this.g = bVar;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        this.c = motionEvent.getX();
        this.d = motionEvent.getY();
        switch (action & 255) {
            case 0:
                this.a = this.c;
                this.b = this.d;
                this.e = false;
                this.f = false;
                this.g.p = true;
                break;
            case 1:
                boolean z = this.d > this.b && Math.abs(this.d - this.b) > ((float) this.g.e);
                if (this.e && !this.f && this.g.d() && z) {
                    this.g.a((float) this.g.g.getHeight(), false);
                    this.g.p = false;
                    return true;
                }
                break;
            case 2:
                if (!this.e && (Math.abs(this.c - this.a) > ((float) this.g.e) || Math.abs(this.d - this.b) > ((float) this.g.e))) {
                    this.f = Math.abs(this.c - this.a) >= Math.abs(this.d - this.b);
                    this.e = true;
                    break;
                }
        }
        return false;
    }
}
