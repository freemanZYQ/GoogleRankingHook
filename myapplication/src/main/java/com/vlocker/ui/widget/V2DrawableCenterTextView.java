package com.vlocker.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;

public class V2DrawableCenterTextView extends TextView {
    public V2DrawableCenterTextView(Context context) {
        super(context);
    }

    public V2DrawableCenterTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public V2DrawableCenterTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected void onDraw(Canvas canvas) {
        Drawable[] compoundDrawables = getCompoundDrawables();
        if (compoundDrawables != null) {
            Drawable drawable = compoundDrawables[0];
            if (drawable != null) {
                canvas.translate((((float) getWidth()) - ((((float) drawable.getIntrinsicWidth()) + getPaint().measureText(getText().toString())) + ((float) getCompoundDrawablePadding()))) / 2.0f, 0.0f);
            }
        }
        super.onDraw(canvas);
    }
}
