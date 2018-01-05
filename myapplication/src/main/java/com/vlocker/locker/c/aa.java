package com.vlocker.locker.c;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.vlocker.msg.p;

class aa implements OnTouchListener {
    final /* synthetic */ b a;

    aa(b bVar) {
        this.a = bVar;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        p.a = true;
        return false;
    }
}
