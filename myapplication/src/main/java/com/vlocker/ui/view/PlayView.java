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

public class PlayView extends ImageView {
    private Paint a;
    private Path b;
    private Path c;
    private int d;
    private int e;
    private float f;
    private float g;
    private float h;
    private boolean i;
    private boolean j;
    private int k;
    private int l;
    private int m;
    private int n;
    private float o;
    private long p;
    private ValueAnimator q;

    public PlayView(Context context) {
        this(context, null);
    }

    public PlayView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = 0;
        this.f = 0.0f;
        this.g = 0.0f;
        this.h = 0.0f;
        this.i = true;
        this.j = false;
        this.k = 33;
        this.l = 17;
        this.m = 33;
        this.n = 50;
        this.o = 0.0f;
        this.p = 1000;
        a(context, attributeSet);
    }

    private final void b() {
        this.q = ValueAnimator.ofInt(new int[]{0, this.n * 2});
        this.q.addListener(new am(this));
        this.q.addUpdateListener(new an(this));
    }

    private final void c() {
        this.b.reset();
        this.b.moveTo(this.h, this.h);
        if (this.e <= this.l) {
            this.b.lineTo(this.h, this.g / 2.0f);
            this.b.lineTo(this.g - this.h, this.g / 2.0f);
        } else {
            this.b.lineTo(this.h, (float) (((double) (this.g / 2.0f)) - (((((double) (this.f / 2.0f)) * 0.33999999999999997d) / ((double) this.m)) * ((double) (this.e - this.l)))));
            this.b.lineTo(this.g - this.h, (float) (((double) (this.g / 2.0f)) - (((((double) (this.f / 2.0f)) * 0.33999999999999997d) / ((double) this.m)) * ((double) (this.e - this.l)))));
        }
        if (this.e <= this.k) {
            this.b.lineTo(this.g - this.h, (this.g / 2.0f) - (((this.f / 2.0f) / ((float) this.m)) * ((float) this.e)));
        } else {
            this.b.lineTo(this.g - this.h, this.h);
        }
        this.b.close();
    }

    private final void d() {
        this.c.reset();
        this.c.moveTo(this.h, this.g - this.h);
        if (this.e <= this.l) {
            this.c.lineTo(this.h, (this.g / 2.0f) - (this.f / 3.0f));
            this.c.lineTo(this.g - this.h, this.g / 2.0f);
        } else {
            this.c.lineTo(this.h, (float) (((double) (this.g / 2.0f)) + (((((double) (this.f / 2.0f)) * 0.33999999999999997d) / ((double) this.m)) * ((double) (this.e - this.l)))));
            this.c.lineTo(this.g - this.h, (float) (((double) (this.g / 2.0f)) + (((((double) (this.f / 2.0f)) * 0.33999999999999997d) / ((double) this.m)) * ((double) (this.e - this.l)))));
        }
        if (this.e <= this.k) {
            this.c.lineTo(this.g - this.h, (this.g / 2.0f) + (((this.f / 2.0f) / ((float) this.m)) * ((float) this.e)));
        } else {
            this.c.lineTo(this.g - this.h, this.g - this.h);
        }
        this.c.close();
    }

    protected void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.NextPlay);
        this.d = obtainStyledAttributes.getColor(1, -16777216);
        obtainStyledAttributes.recycle();
        this.a = new Paint();
        this.a.setAntiAlias(true);
        this.a.setStyle(Style.FILL);
        this.a.setStrokeWidth(1.0f);
        this.a.setColor(this.d);
        this.b = new Path();
        this.c = new Path();
        b();
    }

    public void a(boolean z) {
        if (!this.j && this.i != z) {
            this.i = z;
            this.q.setInterpolator(new AccelerateDecelerateInterpolator());
            this.q.setDuration(this.p);
            this.q.start();
        }
    }

    public boolean a() {
        return this.j;
    }

    protected void onDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(this.g / 2.0f, this.g / 2.0f);
        canvas.rotate(this.o);
        canvas.translate((-this.g) / 2.0f, (-this.g) / 2.0f);
        c();
        d();
        canvas.drawPath(this.b, this.a);
        canvas.drawPath(this.c, this.a);
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
        this.g = (float) measuredWidth;
        this.h = this.g / 3.0f;
        this.f = this.g - (2.0f * this.h);
        super.onMeasure(measuredHeight, measuredHeight);
    }

    public void setColor(int i) {
        this.a.setColor(i);
        invalidate();
    }
}
