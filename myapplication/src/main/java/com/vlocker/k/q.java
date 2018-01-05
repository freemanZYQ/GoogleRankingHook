package com.vlocker.k;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.vlocker.n.a;

class q implements OnTouchListener {
    float a;
    float b;
    final /* synthetic */ p c;

    q(p pVar) {
        this.c = pVar;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.a = motionEvent.getX();
                this.b = 0.0f;
                break;
            case 1:
                if (Math.abs(this.b) <= ((float) (this.c.i / 20))) {
                    if (this.c.g != null) {
                        try {
                            this.c.g.send();
                            a.a(this.c.j).b = System.currentTimeMillis();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        this.c.h.removeMessages(0);
                        this.c.b();
                        a.a().removeCallbacks(this.c.n);
                        this.c.m = System.currentTimeMillis() + 2000;
                        a.a().postDelayed(this.c.n, 2000);
                        break;
                    }
                }
                this.c.a(this.b);
                break;
                break;
            case 2:
                this.b = motionEvent.getX() - this.a;
                this.c.b.setX(this.b);
                this.c.b.setAlpha(1.0f - (Math.abs(this.b) / ((float) this.c.i)));
                break;
        }
        return false;
    }
}
