package com.vlocker.ui.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public abstract class ImageViewTouchBase extends ImageView {
    private float a;
    private float b;
    private boolean c;
    private boolean d;
    private int e;
    private int f;
    private PointF g;
    private boolean h;
    private boolean i;
    private aa j;
    protected Matrix k;
    protected Matrix l;
    protected Matrix m;
    protected Handler n;
    protected Runnable o;
    protected boolean p;
    protected final Matrix q;
    protected final float[] r;
    protected z s;
    protected final int t;
    protected RectF u;
    protected RectF v;
    protected RectF w;
    private ab x;

    public ImageViewTouchBase(Context context) {
        super(context);
        this.k = new Matrix();
        this.l = new Matrix();
        this.n = new Handler();
        this.o = null;
        this.p = false;
        this.a = -1.0f;
        this.b = -1.0f;
        this.q = new Matrix();
        this.r = new float[9];
        this.e = -1;
        this.f = -1;
        this.g = new PointF();
        this.s = z.NONE;
        this.t = 200;
        this.u = new RectF();
        this.v = new RectF();
        this.w = new RectF();
        a();
    }

    public ImageViewTouchBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.k = new Matrix();
        this.l = new Matrix();
        this.n = new Handler();
        this.o = null;
        this.p = false;
        this.a = -1.0f;
        this.b = -1.0f;
        this.q = new Matrix();
        this.r = new float[9];
        this.e = -1;
        this.f = -1;
        this.g = new PointF();
        this.s = z.NONE;
        this.t = 200;
        this.u = new RectF();
        this.v = new RectF();
        this.w = new RectF();
        a();
    }

    public double a(double d, double d2, double d3, double d4) {
        double d5 = (d / d4) - 1.0d;
        return (((d5 * (d5 * d5)) + 1.0d) * d3) + d2;
    }

    protected float a(Matrix matrix, int i) {
        matrix.getValues(this.r);
        return this.r[i];
    }

    protected float a(z zVar) {
        return 1.0f / c(this.k);
    }

    public Matrix a(Matrix matrix) {
        this.q.set(this.k);
        this.q.postConcat(matrix);
        return this.q;
    }

    protected RectF a(Matrix matrix, boolean z, boolean z2) {
        if (getDrawable() == null) {
            return new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        }
        float f;
        int i;
        this.v.set(0.0f, 0.0f, 0.0f, 0.0f);
        RectF b = b(matrix);
        float height = b.height();
        float width = b.width();
        if (z2) {
            int i2 = this.f;
            if (height < ((float) i2)) {
                f = ((((float) i2) - height) / 2.0f) - b.top;
            } else if (b.top > 0.0f) {
                f = -b.top;
            } else if (b.bottom < ((float) i2)) {
                f = ((float) this.f) - b.bottom;
            }
            if (z) {
                i = this.e;
                if (width < ((float) i)) {
                    height = ((((float) i) - width) / 2.0f) - b.left;
                } else if (b.left > 0.0f) {
                    height = -b.left;
                } else if (b.right < ((float) i)) {
                    height = ((float) i) - b.right;
                }
                this.v.set(height, f, 0.0f, 0.0f);
                return this.v;
            }
            height = 0.0f;
            this.v.set(height, f, 0.0f, 0.0f);
            return this.v;
        }
        f = 0.0f;
        if (z) {
            i = this.e;
            if (width < ((float) i)) {
                height = ((((float) i) - width) / 2.0f) - b.left;
            } else if (b.left > 0.0f) {
                height = -b.left;
            } else if (b.right < ((float) i)) {
                height = ((float) i) - b.right;
            }
            this.v.set(height, f, 0.0f, 0.0f);
            return this.v;
        }
        height = 0.0f;
        this.v.set(height, f, 0.0f, 0.0f);
        return this.v;
    }

    protected void a() {
        setScaleType(ScaleType.MATRIX);
    }

    protected void a(double d, double d2) {
        RectF bitmapRect = getBitmapRect();
        this.w.set((float) d, (float) d2, 0.0f, 0.0f);
        a(bitmapRect, this.w);
        b(this.w.left, this.w.top);
        a(true, true);
    }

    protected void a(float f) {
    }

    protected void a(float f, float f2, double d) {
        double d2 = (double) f;
        double d3 = (double) f2;
        this.n.post(new x(this, d, System.currentTimeMillis(), d2, d3));
    }

    protected void a(float f, float f2, float f3) {
        this.l.postScale(f, f, f2, f3);
        setImageMatrix(getImageViewMatrix());
    }

    protected void a(float f, float f2, float f3, float f4) {
        if (f > getMaxScale()) {
            f = getMaxScale();
        }
        long currentTimeMillis = System.currentTimeMillis();
        float scale = getScale();
        float f5 = f - scale;
        Matrix matrix = new Matrix(this.l);
        matrix.postScale(f, f, f2, f3);
        RectF a = a(matrix, true, true);
        this.n.post(new y(this, f4, currentTimeMillis, f5, scale, f2 + (a.left * f), f3 + (a.top * f)));
    }

    protected void a(int i, int i2, int i3, int i4) {
        if (this.x != null) {
            this.x.a(true, i, i2, i3, i4);
        }
    }

    public void a(Bitmap bitmap, Matrix matrix, float f, float f2) {
        if (bitmap != null) {
            b(new BitmapDrawable(getResources(), bitmap), matrix, f, f2);
        } else {
            b(null, matrix, f, f2);
        }
    }

    protected void a(RectF rectF, RectF rectF2) {
        if (rectF != null) {
            if (rectF.top >= 0.0f && rectF.bottom <= ((float) this.f)) {
                rectF2.top = 0.0f;
            }
            if (rectF.left >= 0.0f && rectF.right <= ((float) this.e)) {
                rectF2.left = 0.0f;
            }
            if (rectF.top + rectF2.top >= 0.0f && rectF.bottom > ((float) this.f)) {
                rectF2.top = (float) ((int) (0.0f - rectF.top));
            }
            if (rectF.bottom + rectF2.top <= ((float) (this.f + 0)) && rectF.top < 0.0f) {
                rectF2.top = (float) ((int) (((float) (this.f + 0)) - rectF.bottom));
            }
            if (rectF.left + rectF2.left >= 0.0f) {
                rectF2.left = (float) ((int) (0.0f - rectF.left));
            }
            if (rectF.right + rectF2.left <= ((float) (this.e + 0))) {
                rectF2.left = (float) ((int) (((float) (this.e + 0)) - rectF.right));
            }
        }
    }

    protected void a(Drawable drawable) {
        b(drawable);
    }

    protected void a(Drawable drawable, Matrix matrix) {
        float f = (float) this.e;
        float f2 = (float) this.f;
        float intrinsicWidth = (float) drawable.getIntrinsicWidth();
        float intrinsicHeight = (float) drawable.getIntrinsicHeight();
        matrix.reset();
        if (intrinsicWidth > f || intrinsicHeight > f2) {
            float min = Math.min(f / intrinsicWidth, f2 / intrinsicHeight);
            matrix.postScale(min, min);
            matrix.postTranslate((f - (intrinsicWidth * min)) / 2.0f, (f2 - (intrinsicHeight * min)) / 2.0f);
            return;
        }
        min = Math.min(f / intrinsicWidth, f2 / intrinsicHeight);
        matrix.postScale(min, min);
        matrix.postTranslate((f - (intrinsicWidth * min)) / 2.0f, (f2 - (intrinsicHeight * min)) / 2.0f);
    }

    protected void a(Drawable drawable, Matrix matrix, float f, float f2) {
        if (drawable != null) {
            super.setImageDrawable(drawable);
        } else {
            this.k.reset();
            super.setImageDrawable(null);
        }
        if (f == -1.0f || f2 == -1.0f) {
            this.b = -1.0f;
            this.a = -1.0f;
            this.d = false;
            this.c = false;
        } else {
            float min = Math.min(f, f2);
            float max = Math.max(min, f2);
            this.b = min;
            this.a = max;
            this.d = true;
            this.c = true;
            if (this.s == z.FIT_TO_SCREEN || this.s == z.FIT_IF_BIGGER) {
                if (this.b >= 1.0f) {
                    this.d = false;
                    this.b = -1.0f;
                }
                if (this.a <= 1.0f) {
                    this.c = true;
                    this.a = -1.0f;
                }
            }
        }
        if (matrix != null) {
            this.m = new Matrix(matrix);
        }
        this.i = true;
        requestLayout();
    }

    protected void a(boolean z, boolean z2) {
        if (getDrawable() != null) {
            RectF a = a(this.l, z, z2);
            if (a.left != 0.0f || a.top != 0.0f) {
                b(a.left, a.top);
            }
        }
    }

    public double b(double d, double d2, double d3, double d4) {
        double d5 = d / (d4 / 2.0d);
        if (d5 < 1.0d) {
            return (d5 * (((d3 / 2.0d) * d5) * d5)) + d2;
        }
        d5 -= 2.0d;
        return (((d5 * (d5 * d5)) + 2.0d) * (d3 / 2.0d)) + d2;
    }

    protected float b() {
        return c() * 5.0f;
    }

    protected RectF b(Matrix matrix) {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return null;
        }
        Matrix a = a(matrix);
        this.u.set(0.0f, 0.0f, (float) drawable.getIntrinsicWidth(), (float) drawable.getIntrinsicHeight());
        a.mapRect(this.u);
        return this.u;
    }

    protected void b(float f) {
        if (f < getMinScale()) {
            f = getMinScale();
        }
        if (f > getMaxScale()) {
            f = getMaxScale();
        }
        PointF center = getCenter();
        b(f, center.x, center.y);
    }

    protected void b(float f, float f2) {
        if (f != 0.0f || f2 != 0.0f) {
            this.l.postTranslate(f, f2);
            setImageMatrix(getImageViewMatrix());
        }
    }

    protected void b(float f, float f2, float f3) {
        if (f > getMaxScale()) {
            f = getMaxScale();
        }
        a(f / getScale(), f2, f3);
        a(true, true);
    }

    protected void b(int i, int i2, int i3, int i4) {
        a(i, i2, i3, i4);
    }

    protected void b(Drawable drawable) {
        if (this.j != null) {
            this.j.a(drawable);
        }
    }

    public void b(Drawable drawable, Matrix matrix, float f, float f2) {
        if (getWidth() <= 0) {
            this.o = new w(this, drawable, matrix, f, f2);
        } else {
            a(drawable, matrix, f, f2);
        }
    }

    protected float c() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return 1.0f;
        }
        float c = c(this.k);
        int intrinsicHeight = (int) (((float) drawable.getIntrinsicHeight()) * c);
        int intrinsicWidth = (int) (((float) drawable.getIntrinsicWidth()) * c);
        int measuredHeight = getMeasuredHeight();
        int measuredWidth = getMeasuredWidth();
        return (measuredHeight > intrinsicHeight || measuredWidth > intrinsicWidth) ? Math.max(((float) measuredWidth) / ((float) intrinsicWidth), ((float) measuredHeight) / ((float) intrinsicHeight)) : Math.min(1.05f, 1.0f / c);
    }

    protected float c(Matrix matrix) {
        return a(matrix, 0);
    }

    public void c(float f, float f2) {
        PointF center = getCenter();
        a(f, center.x, center.y, f2);
    }

    protected void d() {
    }

    public void d(float f, float f2) {
        a((double) f, (double) f2);
    }

    protected RectF getBitmapRect() {
        return b(this.l);
    }

    protected PointF getCenter() {
        return this.g;
    }

    public Matrix getDisplayMatrix() {
        return new Matrix(this.l);
    }

    public z getDisplayType() {
        return this.s;
    }

    public Matrix getImageViewMatrix() {
        return a(this.l);
    }

    public float getMaxScale() {
        if (this.a == -1.0f) {
            this.a = b();
        }
        return this.a;
    }

    public float getMinScale() {
        if (this.b == -1.0f) {
            this.b = c();
        }
        return this.b;
    }

    @SuppressLint({"Override"})
    public float getRotation() {
        return 0.0f;
    }

    public float getScale() {
        return c(this.l);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        int i5 = 0;
        int i6 = 0;
        if (z) {
            i6 = this.e;
            int i7 = this.f;
            this.e = i3 - i;
            this.f = i4 - i2;
            i5 = this.e - i6;
            i6 = this.f - i7;
            this.g.x = ((float) this.e) / 2.0f;
            this.g.y = ((float) this.f) / 2.0f;
        }
        Runnable runnable = this.o;
        if (runnable != null) {
            this.o = null;
            runnable.run();
        }
        Drawable drawable = getDrawable();
        if (drawable == null) {
            if (this.i) {
                a(drawable);
            }
            if (z || this.i || this.h) {
                b(i, i2, i3, i4);
            }
            if (this.i) {
                this.i = false;
            }
            if (this.h) {
                this.h = false;
            }
        } else if (z || this.h || this.i) {
            float scale;
            a(this.s);
            float c = c(this.k);
            float scale2 = getScale();
            float min = Math.min(1.0f, 1.0f / c);
            a(drawable, this.k);
            float c2 = c(this.k);
            if (this.i || this.h) {
                if (this.m != null) {
                    this.l.set(this.m);
                    this.m = null;
                    scale = getScale();
                } else {
                    this.l.reset();
                    scale = a(this.s);
                }
                setImageMatrix(getImageViewMatrix());
                if (scale != getScale()) {
                    b(scale);
                }
            } else if (z) {
                if (!this.d) {
                    this.b = -1.0f;
                }
                if (!this.c) {
                    this.a = -1.0f;
                }
                setImageMatrix(getImageViewMatrix());
                b((float) (-i5), (float) (-i6));
                if (this.p) {
                    scale = ((double) Math.abs(scale2 - min)) > 0.001d ? (c / c2) * scale2 : 1.0f;
                    b(scale);
                } else {
                    scale = a(this.s);
                    b(scale);
                }
            } else {
                scale = 1.0f;
            }
            this.p = false;
            if (scale > getMaxScale() || scale < getMinScale()) {
                b(scale);
            }
            a(true, true);
            if (this.i) {
                a(drawable);
            }
            if (z || this.i || this.h) {
                b(i, i2, i3, i4);
            }
            if (this.h) {
                this.h = false;
            }
            if (this.i) {
                this.i = false;
            }
        }
    }

    public void setDisplayType(z zVar) {
        if (zVar != this.s) {
            this.p = false;
            this.s = zVar;
            this.h = true;
            requestLayout();
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        a(bitmap, null, -1.0f, -1.0f);
    }

    public void setImageDrawable(Drawable drawable) {
        b(drawable, null, -1.0f, -1.0f);
    }

    public void setImageMatrix(Matrix matrix) {
        Matrix imageMatrix = getImageMatrix();
        Object obj = null;
        if ((matrix == null && !imageMatrix.isIdentity()) || !(matrix == null || imageMatrix.equals(matrix))) {
            obj = 1;
        }
        super.setImageMatrix(matrix);
        if (obj != null) {
            d();
        }
    }

    public void setImageResource(int i) {
        setImageDrawable(getContext().getResources().getDrawable(i));
    }

    protected void setMaxScale(float f) {
        this.a = f;
    }

    protected void setMinScale(float f) {
        this.b = f;
    }

    public void setOnDrawableChangedListener(aa aaVar) {
        this.j = aaVar;
    }

    public void setOnLayoutChangeListener(ab abVar) {
        this.x = abVar;
    }

    public void setScaleType(ScaleType scaleType) {
        if (scaleType == ScaleType.MATRIX) {
            super.setScaleType(scaleType);
        } else {
            Log.w("wufeng", "Unsupported scaletype. Only MATRIX can be used");
        }
    }
}
