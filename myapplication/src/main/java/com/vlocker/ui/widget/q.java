package com.vlocker.ui.widget;

import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.vlocker.m.l;

class q implements OnGlobalLayoutListener {
    final /* synthetic */ MyAlertController a;

    q(MyAlertController myAlertController) {
        this.a = myAlertController;
    }

    public void onGlobalLayout() {
        View childAt = this.a.H.getChildAt(0);
        if (childAt != null) {
            int height = childAt.getHeight();
            int a = (int) ((0.6f * ((float) l.a(this.a.c))) - ((float) l.a(this.a.c, 140.0f)));
            if (height <= a) {
                a = height;
            }
            l.a(this.a.H, -3, a);
        }
    }
}
