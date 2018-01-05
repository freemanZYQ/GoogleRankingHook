package com.vlocker.ui.widget.view;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import com.vlocker.c.a;
import com.vlocker.m.h;
import com.vlocker.ui.widget.c.d;

public class LockNumberTimeView extends RelativeLayout {
    private int a;

    public LockNumberTimeView(Context context) {
        this(context, null);
    }

    public LockNumberTimeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 130;
        a();
    }

    public LayoutParams a(int i) {
        int d = (VERSION.SDK_INT >= 19 || a.a(getContext()).ai() != 0) ? 0 : h.d(getContext());
        if (i > 0) {
            i = 0;
        }
        LayoutParams layoutParams = new LayoutParams(-1, -2);
        layoutParams.setMargins(0, (this.a + i) - d, 0, 0);
        layoutParams.gravity = 1;
        return layoutParams;
    }

    public void a() {
        if (((float) getContext().getResources().getDisplayMetrics().widthPixels) == 480.0f) {
            this.a = (int) (110.0f * d.a);
        } else {
            this.a = (int) (130.0f * d.a);
        }
    }
}
