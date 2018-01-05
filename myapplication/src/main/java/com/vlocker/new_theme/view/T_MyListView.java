package com.vlocker.new_theme.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ListView;

public class T_MyListView extends ListView {
    private GestureDetector a;
    private Context b;
    private ViewPager c;

    public T_MyListView(Context context) {
        super(context);
        this.b = context;
    }

    public T_MyListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        try {
            this.b = context;
            this.a = new GestureDetector(new d(this));
            setFadingEdgeLength(0);
        } catch (Exception e) {
        }
    }

    public T_MyListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        super.onInterceptTouchEvent(motionEvent);
        return this.a.onTouchEvent(motionEvent);
    }

    public void setViewPager(ViewPager viewPager) {
        this.c = viewPager;
    }
}
