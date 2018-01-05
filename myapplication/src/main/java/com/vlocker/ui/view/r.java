package com.vlocker.ui.view;

import android.util.Log;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

public class r extends SimpleOnGestureListener {
    final /* synthetic */ ImageViewTouch a;

    public r(ImageViewTouch imageViewTouch) {
        this.a = imageViewTouch;
    }

    public boolean onDoubleTap(MotionEvent motionEvent) {
        Log.i("wufeng", "onDoubleTap. double tap enabled? " + this.a.h);
        if (this.a.h) {
            this.a.p = true;
            this.a.a(Math.min(this.a.getMaxScale(), Math.max(this.a.a(this.a.getScale(), this.a.getMaxScale()), this.a.getMinScale())), motionEvent.getX(), motionEvent.getY(), 200.0f);
            this.a.invalidate();
        }
        if (this.a.x != null) {
            this.a.x.a();
        }
        return super.onDoubleTap(motionEvent);
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return this.a.b(motionEvent, motionEvent2, f, f2);
    }

    public void onLongPress(MotionEvent motionEvent) {
        if (this.a.isLongClickable() && !this.a.a.isInProgress()) {
            this.a.setPressed(true);
            this.a.performLongClick();
        }
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (this.a.z != null) {
            this.a.z.a();
        }
        return this.a.a(motionEvent, motionEvent2, f, f2);
    }

    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        if (this.a.y != null) {
            this.a.y.a();
        }
        return super.onSingleTapConfirmed(motionEvent);
    }
}
