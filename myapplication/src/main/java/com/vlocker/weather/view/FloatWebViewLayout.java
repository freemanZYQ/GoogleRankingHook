package com.vlocker.weather.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.vlocker.ui.widget.CoverViewPager;

public class FloatWebViewLayout extends RelativeLayout {
    public FloatWebViewLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        CoverViewPager.a = true;
        return super.dispatchTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }
}
