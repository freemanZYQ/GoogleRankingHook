package com.vlocker.new_theme.activity;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class aa implements OnTouchListener {
    final /* synthetic */ SpecialSingleItemActivity a;
    private int b = 0;

    aa(SpecialSingleItemActivity specialSingleItemActivity) {
        this.a = specialSingleItemActivity;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.b = this.a.J.getScrollY();
            if (this.b == this.a.C.getHeight() - this.a.J.getHeight() && this.a.I.getVisibility() == 8) {
                this.a.a(this.a.u, this.a.I, Boolean.valueOf(this.a.p));
            }
        }
        return false;
    }
}
