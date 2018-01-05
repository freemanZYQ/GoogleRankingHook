package com.vlocker.new_theme.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.ScrollView;

public class T_TopScrollView extends ScrollView {
    public T_TopScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public T_TopScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected int computeScrollDeltaToGetChildRectOnScreen(Rect rect) {
        return 0;
    }
}
