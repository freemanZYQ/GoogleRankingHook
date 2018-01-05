package com.vlocker.locker.b;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.vlocker.ui.widget.CoverViewPager;

class j implements OnTouchListener {
    final /* synthetic */ i a;

    j(i iVar) {
        this.a = iVar;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            CoverViewPager.a = true;
        }
        return true;
    }
}
