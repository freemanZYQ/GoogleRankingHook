package com.vlocker.ui.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.ImageView;

public class GifImageView extends ImageView {
    private int a = -1;
    private long b;
    private int c;
    private float d;
    private float e;
    private float f;
    private int g;
    private int h;
    private volatile boolean i = false;
    private boolean j = true;
    private Movie k;
    private Bitmap l;
    private byte[] m;
    private String n;
    private p o;
    private Handler p = new o(this, getContext().getMainLooper());

    public GifImageView(Context context) {
        super(context);
        c();
    }

    public GifImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c();
    }

    public GifImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        c();
    }

    private void a(Canvas canvas) {
        this.k.setTime(this.c);
        canvas.save(1);
        canvas.scale(this.f, this.f);
        this.k.draw(canvas, this.d / this.f, this.e / this.f);
        canvas.restore();
    }

    @SuppressLint({"NewApi"})
    private void c() {
        if (VERSION.SDK_INT >= 11) {
            setLayerType(1, null);
        }
    }

    @SuppressLint({"NewApi"})
    private void d() {
        if (!this.j) {
            return;
        }
        if (VERSION.SDK_INT >= 16) {
            postInvalidateOnAnimation();
        } else {
            postInvalidate();
        }
    }

    private void e() {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (this.b == 0) {
            this.b = uptimeMillis;
        }
        int duration = this.k.duration();
        if (duration == 0) {
            duration = 1;
        }
        this.c = (int) ((uptimeMillis - this.b) % ((long) duration));
    }

    public void a() {
        if (this.i) {
            this.i = false;
            this.b = SystemClock.uptimeMillis() - ((long) this.c);
            invalidate();
        }
    }

    public void b() {
        if (!this.i) {
            this.i = true;
            this.c = 0;
            invalidate();
        }
    }

    public int getGifResource() {
        return this.a;
    }

    protected void onDraw(Canvas canvas) {
        if (this.k == null) {
            super.onDraw(canvas);
        } else if (this.i) {
            a(canvas);
        } else {
            e();
            a(canvas);
            d();
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.k != null) {
            this.d = ((float) (getWidth() - this.g)) / 2.0f;
            this.e = ((float) (getHeight() - this.h)) / 2.0f;
            this.j = getVisibility() == 0;
        }
    }

    protected void onMeasure(int i, int i2) {
        int i3 = 0;
        if (this.k == null && this.l == null) {
            setMeasuredDimension(getSuggestedMinimumWidth(), getSuggestedMinimumHeight());
            return;
        }
        int width;
        if (this.k != null) {
            width = this.k.width();
            i3 = this.k.height();
        } else if (this.l != null) {
            super.onMeasure(i, i2);
            return;
        } else {
            width = 0;
        }
        this.f = 1.0f / Math.max(MeasureSpec.getMode(i) != 0 ? ((float) width) / ((float) MeasureSpec.getSize(i)) : 1.0f, MeasureSpec.getMode(i2) != 0 ? ((float) i3) / ((float) MeasureSpec.getSize(i2)) : 1.0f);
        this.g = (int) (((float) width) * this.f);
        this.h = (int) (((float) i3) * this.f);
        setMeasuredDimension(this.g, this.h);
    }

    @SuppressLint({"NewApi"})
    public void onScreenStateChanged(int i) {
        boolean z = true;
        super.onScreenStateChanged(i);
        if (i != 1) {
            z = false;
        }
        this.j = z;
        d();
    }

    @SuppressLint({"NewApi"})
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        this.j = i == 0;
        d();
    }

    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.j = i == 0;
        d();
    }

    public void setDataLoadListener(p pVar) {
        this.o = pVar;
    }

    public void setDefaultPath(String str) {
        this.n = str;
    }

    public void setGifData(byte[] bArr) {
        this.m = bArr;
        new Thread(new m(this.p, bArr)).start();
    }

    public void setGifResource(int i) {
        this.a = i;
        new Thread(new m(this.p, getResources().openRawResource(this.a))).start();
    }

    public void setGifUrl(String str) {
        new Thread(new n(getContext(), this.p, str)).start();
    }
}
