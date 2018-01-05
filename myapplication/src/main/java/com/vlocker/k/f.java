package com.vlocker.k;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.vlocker.n.a;

class f implements OnTouchListener {
    final /* synthetic */ e a;

    f(e eVar) {
        this.a = eVar;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        a.a().removeCallbacks(this.a.j);
        return false;
    }
}
