package com.vlocker.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;

public class ImageScrollView extends HorizontalScrollView {
    private q a = null;

    public ImageScrollView(Context context) {
        super(context);
    }

    public ImageScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ImageScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.a != null) {
            this.a.a(this, i, i2, i3, i4);
        }
    }

    public void setOnScrollChangedListener(q qVar) {
        this.a = qVar;
    }
}
