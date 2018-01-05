package com.vlocker.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.vlocker.m.al;
import com.vlocker.ui.cover.g;

public class TouchFrameLayout extends FrameLayout {
    public TouchFrameLayout(Context context) {
        super(context);
    }

    public TouchFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (!g.a() && (action & 255) == 0) {
            al.a(true);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }
}
