package com.vlocker.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

public class ToolsLayout extends LinearLayout {
    public ToolsLayout(Context context) {
        super(context);
    }

    public ToolsLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        CoverViewPager.a = true;
        return super.dispatchTouchEvent(motionEvent);
    }
}
