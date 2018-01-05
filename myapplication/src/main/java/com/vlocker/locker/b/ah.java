package com.vlocker.locker.b;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.vlocker.b.j;
import com.vlocker.b.p;

class ah implements OnTouchListener {
    float a;
    float b;
    float c;
    float d;
    boolean e;
    boolean f;
    boolean g;
    long h;
    final /* synthetic */ ag i;

    ah(ag agVar) {
        this.i = agVar;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        this.c = motionEvent.getX();
        this.d = motionEvent.getY();
        switch (action & 255) {
            case 0:
                this.i.c.o();
                this.a = this.c;
                this.b = this.d;
                this.e = false;
                this.i.i = false;
                this.f = false;
                this.g = false;
                this.h = System.currentTimeMillis();
                this.i.h.e();
                this.i.c.C();
                break;
            case 1:
                this.i.a(false);
                if (System.currentTimeMillis() - this.h < 200 && !this.e) {
                    if ("moxiu-launcher".equals(j.p(this.i.d))) {
                        p.a(this.i.d, "Vlocker_Click_Toolbox_PPC_TF", new String[0]);
                    }
                    this.i.p.d();
                }
                this.i.c.B();
                if (this.i.a) {
                    this.i.a = false;
                    this.i.h.a(false);
                    break;
                }
                break;
            case 2:
                if (!this.e && (Math.abs(this.c - this.a) > ((float) this.i.k) || Math.abs(this.d - this.b) > ((float) this.i.k))) {
                    this.f = Math.abs(this.c - this.a) >= Math.abs(this.d - this.b);
                    this.e = true;
                    this.i.i = true;
                    break;
                }
        }
        if (this.e) {
            if (!this.g) {
                this.g = true;
                motionEvent.setAction(0);
            }
            if (!this.f) {
                this.i.h.a(view, motionEvent);
            }
        }
        return false;
    }
}
