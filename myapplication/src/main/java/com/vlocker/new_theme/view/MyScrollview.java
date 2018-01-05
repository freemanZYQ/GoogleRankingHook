package com.vlocker.new_theme.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

public class MyScrollview extends ScrollView {
    protected a a = null;

    public MyScrollview(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @TargetApi(9)
    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        if (getScrollY() + getHeight() >= computeVerticalScrollRange()) {
            this.a.g();
        }
        super.onOverScrolled(i, i2, z, z2);
    }

    public void setOnScrollStateChanged(a aVar) {
        this.a = aVar;
    }
}
