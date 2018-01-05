package com.vlocker.weather.a;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class b implements OnTouchListener {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.a.c = 0.0f;
                this.a.d = motionEvent.getRawX();
                this.a.f = System.currentTimeMillis();
                break;
            case 2:
                this.a.e = motionEvent.getRawX();
                this.a.c = Math.abs(this.a.e - this.a.d);
                this.a.g = System.currentTimeMillis();
                if (this.a.c >= ((float) this.a.h) && this.a.g - this.a.f > 0) {
                    break;
                }
        }
        return false;
    }
}
