package com.vlocker.setting;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class o implements OnTouchListener {
    final /* synthetic */ RecentShowActivity a;

    o(RecentShowActivity recentShowActivity) {
        this.a = recentShowActivity;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.a.finish();
        return true;
    }
}
