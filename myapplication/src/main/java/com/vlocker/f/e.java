package com.vlocker.f;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class e implements OnTouchListener {
    final /* synthetic */ b a;

    e(b bVar) {
        this.a = bVar;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.a.b();
        return false;
    }
}
