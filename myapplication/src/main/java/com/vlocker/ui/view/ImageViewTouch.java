package com.vlocker.ui.view;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import android.view.View;
import android.view.ViewConfiguration;

public class ImageViewTouch extends ImageViewTouchBase {
    protected ScaleGestureDetector a;
    protected GestureDetector b;
    protected int c;
    protected float d;
    protected int e;
    protected OnGestureListener f;
    protected OnScaleGestureListener g;
    protected boolean h = true;
    protected boolean i = true;
    protected boolean j = true;
    private t x;
    private u y;
    private s z;

    public ImageViewTouch(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public static void a(View view) {
        if (VERSION.SDK_INT >= 11) {
            try {
                if (((Boolean) View.class.getMethod("isHardwareAccelerated", new Class[0]).invoke(view, new Object[0])).booleanValue()) {
                    try {
                        View.class.getMethod("setLayerType", new Class[]{Integer.TYPE, Paint.class}).invoke(view, new Object[]{Integer.valueOf(1), null});
                    } catch (Exception e) {
                    }
                }
            } catch (Exception e2) {
            }
        }
    }

    protected float a(float f, float f2) {
        if (this.e != 1) {
            this.e = 1;
            return 1.0f;
        } else if ((this.d * 2.0f) + f <= f2) {
            return f + this.d;
        } else {
            this.e = -1;
            return f2;
        }
    }

    protected void a() {
        super.a();
        this.c = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.f = getGestureListener();
        this.g = getScaleListener();
        this.a = new ScaleGestureDetector(getContext(), this.g);
        this.b = new GestureDetector(getContext(), this.f, null, true);
        this.e = 1;
    }

    protected void a(float f) {
        if (f < getMinScale()) {
            c(getMinScale(), 50.0f);
        }
    }

    protected void a(Drawable drawable, Matrix matrix, float f, float f2) {
        super.a(drawable, matrix, f, f2);
        this.d = getMaxScale() / 3.0f;
    }

    public boolean a(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (!this.j || motionEvent == null || motionEvent2 == null || motionEvent.getPointerCount() > 1 || motionEvent2.getPointerCount() > 1 || this.a.isInProgress() || getScale() == 1.0f) {
            return false;
        }
        this.p = true;
        d(-f, -f2);
        invalidate();
        return true;
    }

    public boolean b(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (!this.j || motionEvent.getPointerCount() > 1 || motionEvent2.getPointerCount() > 1 || this.a.isInProgress() || getScale() == 1.0f) {
            return false;
        }
        float x = motionEvent2.getX() - motionEvent.getX();
        float y = motionEvent2.getY() - motionEvent.getY();
        if (Math.abs(f) <= 800.0f && Math.abs(f2) <= 800.0f) {
            return false;
        }
        this.p = true;
        a(x / 2.0f, y / 2.0f, 300.0d);
        invalidate();
        return true;
    }

    public boolean getDoubleTapEnabled() {
        return this.h;
    }

    protected OnGestureListener getGestureListener() {
        return new r(this);
    }

    protected OnScaleGestureListener getScaleListener() {
        return new v(this);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        a((View) this);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.a.onTouchEvent(motionEvent);
        if (!this.a.isInProgress()) {
            this.b.onTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction() & 255) {
            case 1:
                if (getScale() < getMinScale()) {
                    c(getMinScale(), 50.0f);
                    break;
                }
                break;
        }
        return true;
    }

    public void setDoubleTapEnabled(boolean z) {
        this.h = z;
    }

    public void setDoubleTapListener(t tVar) {
        this.x = tVar;
    }

    public void setScaleEnabled(boolean z) {
        this.i = z;
    }

    public void setScrollEnabled(boolean z) {
        this.j = z;
    }

    public void setScrollListener(s sVar) {
        this.z = sVar;
    }

    public void setSingleTapListener(u uVar) {
        this.y = uVar;
    }
}
