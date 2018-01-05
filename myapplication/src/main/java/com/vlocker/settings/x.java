package com.vlocker.settings;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class x implements OnTouchListener {
    final /* synthetic */ DismissActivity a;

    x(DismissActivity dismissActivity) {
        this.a = dismissActivity;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.a.finish();
        return true;
    }
}
