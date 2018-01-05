package com.vlocker.new_theme.view;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

class d extends SimpleOnGestureListener {
    final /* synthetic */ T_MyListView a;

    d(T_MyListView t_MyListView) {
        this.a = t_MyListView;
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return Math.abs(f2) >= Math.abs(f);
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return super.onSingleTapUp(motionEvent);
    }
}
