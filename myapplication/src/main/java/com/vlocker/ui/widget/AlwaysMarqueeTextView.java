package com.vlocker.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
import android.widget.TextView.BufferType;

public class AlwaysMarqueeTextView extends TextView {
    public boolean a = false;
    private int b;
    private boolean c = false;

    public AlwaysMarqueeTextView(Context context) {
        super(context);
    }

    public AlwaysMarqueeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AlwaysMarqueeTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private void getTextWidth() {
        this.b = (int) getPaint().measureText(getText().toString());
    }

    public boolean isFocused() {
        return true;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.c) {
            getTextWidth();
            if (this.b > (getWidth() - getPaddingLeft()) - getPaddingRight()) {
                this.a = true;
            }
            this.c = true;
        }
    }

    public void setText(CharSequence charSequence, BufferType bufferType) {
        this.c = false;
        this.a = false;
        super.setText(charSequence, bufferType);
    }
}
