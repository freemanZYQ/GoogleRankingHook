package com.vlocker.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.GridView;

public class MoreGradView extends GridView {
    public MoreGradView(Context context) {
        super(context);
    }

    public MoreGradView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MoreGradView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }
}
