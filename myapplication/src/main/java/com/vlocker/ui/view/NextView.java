package com.vlocker.ui.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import com.vlocker.locker.b;

public class NextView extends ImageView {
    Path a;
    Path b;
    Path c;
    ValueAnimator d;
    float e;
    private Paint f;
    private Paint g;
    private int h;
    private float i;
    private float j;
    private float k;
    private int l;
    private int m;
    private int n;
    private boolean o;
    private boolean p;

    public NextView(Context context) {
        this(context, null);
    }

    public NextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.h = 0;
        this.i = 0.0f;
        this.j = 0.0f;
        this.k = 10.0f;
        this.l = 20;
        this.m = 40;
        this.o = false;
        this.e = 0.0f;
        a(context, attributeSet, i);
    }

    public void a() {
        if (!this.o) {
            this.d.setInterpolator(new AccelerateDecelerateInterpolator());
            this.d.setDuration(650);
            this.d.start();
        }
    }

    protected void a(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.NextPlay);
        this.p = obtainStyledAttributes.getBoolean(0, true);
        this.n = obtainStyledAttributes.getColor(1, -16777216);
        obtainStyledAttributes.recycle();
        this.f = new Paint();
        this.f.setAntiAlias(true);
        this.f.setStyle(Style.FILL);
        this.f.setStrokeWidth(1.0f);
        this.f.setColor(this.n);
        this.g = new Paint();
        this.g.setAntiAlias(true);
        this.g.setStyle(Style.FILL);
        this.g.setStrokeWidth(1.0f);
        this.g.setColor(this.n);
        this.a = new Path();
        this.b = new Path();
        this.c = new Path();
        this.d = ValueAnimator.ofInt(new int[]{0, 130});
        this.d.addUpdateListener(new aj(this));
        this.d.addListener(new ak(this));
    }

    public boolean b() {
        return this.o;
    }

    protected void onDraw(Canvas canvas) {
        int i = 255;
        canvas.save();
        int i2 = (int) (((((float) (this.h - this.l)) * 1.0f) / ((float) this.m)) * 255.0f);
        if (i2 <= 255) {
            i = i2;
        }
        this.g.setAlpha(i);
        if (this.p) {
            this.a.reset();
            this.a.moveTo(this.j - this.k, this.k);
            this.a.lineTo(this.j - this.k, this.k + this.i);
            this.a.lineTo((this.j - this.k) + (this.i / 10.0f), this.k + this.i);
            this.a.lineTo((this.j - this.k) + (this.i / 10.0f), this.k);
            this.a.close();
            canvas.drawPath(this.a, this.f);
            if (this.h <= this.m) {
                this.b.reset();
                this.b.moveTo(this.k + ((this.i / ((float) this.m)) * ((float) this.h)), this.k);
                this.b.lineTo(this.k + ((this.i / ((float) this.m)) * ((float) this.h)), this.k + this.i);
                this.b.lineTo(this.j - this.k, (this.j / 2.0f) + (((this.i / 2.0f) / ((float) this.m)) * ((float) this.h)));
                this.b.lineTo(this.j - this.k, (this.j / 2.0f) - (((this.i / 2.0f) / ((float) this.m)) * ((float) this.h)));
                this.b.close();
                canvas.drawPath(this.b, this.f);
            }
            if (this.h >= this.l) {
                this.c.reset();
                this.c.moveTo((this.i / ((float) this.m)) * ((float) (this.h - this.l)), this.k);
                this.c.lineTo(((this.i / ((float) this.m)) * ((float) (this.h - this.l))) + this.i, this.j / 2.0f);
                this.c.lineTo((this.i / ((float) this.m)) * ((float) (this.h - this.l)), this.j - this.k);
                this.c.close();
                canvas.drawPath(this.c, this.g);
            }
        } else {
            this.a.reset();
            this.a.moveTo((this.i / 10.0f) + this.k, this.k);
            this.a.lineTo((this.i / 10.0f) + this.k, this.k + this.i);
            this.a.lineTo(this.k, this.k + this.i);
            this.a.lineTo(this.k, this.k);
            this.a.close();
            canvas.drawPath(this.a, this.f);
            if (this.h <= this.m) {
                this.b.reset();
                this.b.moveTo(this.k, (this.j / 2.0f) - (((this.i / 2.0f) / ((float) this.m)) * ((float) this.h)));
                this.b.lineTo(this.k, (this.j / 2.0f) + (((this.i / 2.0f) / ((float) this.m)) * ((float) this.h)));
                this.b.lineTo((this.j - this.k) - ((this.i / ((float) this.m)) * ((float) this.h)), this.j - this.k);
                this.b.lineTo((this.j - this.k) - ((this.i / ((float) this.m)) * ((float) this.h)), this.k);
                this.b.close();
                canvas.drawPath(this.b, this.f);
            }
            if (this.h >= this.l) {
                this.c.reset();
                this.c.moveTo(this.j - ((this.i / ((float) this.m)) * ((float) (this.h - this.l))), this.k);
                this.c.lineTo((this.j - ((this.i / ((float) this.m)) * ((float) (this.h - this.l)))) - this.i, this.j / 2.0f);
                this.c.lineTo(this.j - ((this.i / ((float) this.m)) * ((float) (this.h - this.l))), this.j - this.k);
                this.c.close();
                canvas.drawPath(this.c, this.g);
            }
        }
        canvas.restore();
    }

    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(getDefaultSize(0, i), getDefaultSize(0, i2));
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth > measuredHeight) {
            measuredWidth = measuredHeight;
        }
        measuredHeight = MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
        this.j = (float) measuredWidth;
        this.k = this.j / 3.0f;
        this.i = this.j - (2.0f * this.k);
        super.onMeasure(measuredHeight, measuredHeight);
    }

    public void setColor(int i) {
        this.f.setColor(i);
        this.g.setColor(i);
        invalidate();
    }
}
