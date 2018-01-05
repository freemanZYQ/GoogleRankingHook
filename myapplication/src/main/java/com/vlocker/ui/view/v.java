package com.vlocker.ui.view;

import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener;

public class v extends SimpleOnScaleGestureListener {
    protected boolean a = false;
    final /* synthetic */ ImageViewTouch b;

    public v(ImageViewTouch imageViewTouch) {
        this.b = imageViewTouch;
    }

    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        float currentSpan = scaleGestureDetector.getCurrentSpan() - scaleGestureDetector.getPreviousSpan();
        float scale = this.b.getScale() * scaleGestureDetector.getScaleFactor();
        if (this.b.i) {
            if (this.a && currentSpan != 0.0f) {
                this.b.p = true;
                this.b.b(Math.min(this.b.getMaxScale(), Math.max(scale, this.b.getMinScale() - 0.1f)), scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
                this.b.e = 1;
                this.b.invalidate();
            } else if (!this.a) {
                this.a = true;
            }
        }
        return true;
    }
}
