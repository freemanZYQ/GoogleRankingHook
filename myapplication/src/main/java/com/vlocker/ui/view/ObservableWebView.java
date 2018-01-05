package com.vlocker.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;

public class ObservableWebView extends WebView {
    private al a;
    private boolean b = true;

    public ObservableWebView(Context context) {
        super(context);
    }

    public ObservableWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ObservableWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void computeScroll() {
        if (this.b) {
            super.computeScroll();
        }
    }

    public al getOnScrollChangedCallback() {
        return this.a;
    }

    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.a != null) {
            this.a.a(i - i3, i2 - i4);
        }
    }

    protected boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        return !this.b ? false : super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
    }

    public void scrollTo(int i, int i2) {
        if (this.b) {
            super.scrollTo(i, i2);
        }
    }

    public void setCanScroll(boolean z) {
        this.b = z;
    }

    public void setOnScrollChangedCallback(al alVar) {
        this.a = alVar;
    }
}
