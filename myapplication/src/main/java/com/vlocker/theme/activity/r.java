package com.vlocker.theme.activity;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.TypedValue;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class r implements OnGlobalLayoutListener {
    final /* synthetic */ UnlockTextEditActivity a;
    private final int b = 100;
    private final int c;
    private final Rect d;

    r(UnlockTextEditActivity unlockTextEditActivity) {
        this.a = unlockTextEditActivity;
        this.c = (VERSION.SDK_INT >= 21 ? 48 : 0) + 100;
        this.d = new Rect();
    }

    public void onGlobalLayout() {
        this.a.n = (int) TypedValue.applyDimension(1, (float) this.c, this.a.d.getResources().getDisplayMetrics());
        this.a.d.getWindowVisibleDisplayFrame(this.d);
        boolean z = this.a.d.getRootView().getHeight() - (this.d.bottom - this.d.top) >= this.a.n;
        if (z != this.a.w) {
            this.a.w = z;
            if (z) {
                int[] iArr = new int[2];
                this.a.e.getLocationInWindow(iArr);
                this.a.a((iArr[1] + this.a.e.getHeight()) - this.d.bottom);
                return;
            }
            this.a.h();
        }
    }
}
