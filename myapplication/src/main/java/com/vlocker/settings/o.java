package com.vlocker.settings;

import android.view.ViewTreeObserver.OnPreDrawListener;

class o implements OnPreDrawListener {
    final /* synthetic */ CustomWallPaperActivity a;

    o(CustomWallPaperActivity customWallPaperActivity) {
        this.a = customWallPaperActivity;
    }

    public boolean onPreDraw() {
        if (this.a.a.getMeasuredHeight() > 0 && this.a.a.getMeasuredWidth() > 0) {
            this.a.c(this.a.d);
            this.a.b.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        return true;
    }
}
