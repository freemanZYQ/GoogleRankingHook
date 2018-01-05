package com.vlocker.weather.a;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class ay implements OnTouchListener {
    final /* synthetic */ aw a;

    ay(aw awVar) {
        this.a = awVar;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        return motionEvent.getAction() == 2;
    }
}
