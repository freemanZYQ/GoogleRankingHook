package com.vlocker.settings;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class cp implements OnTouchListener {
    final /* synthetic */ SubSetingActivity a;

    cp(SubSetingActivity subSetingActivity) {
        this.a = subSetingActivity;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.a.finish();
        return true;
    }
}
