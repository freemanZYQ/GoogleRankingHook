package com.vlocker.theme.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

public class VerticalColorSeekBar extends View {
    protected a a;
    private int[] b;
    private float c;
    private float d;
    private float e;
    private float f;
    private float g;
    private float h;
    private float i;
    private float j;
    private float k;
    private float l;
    private float m;
    private LinearGradient n;
    private Paint o;
    private List p;
    private int q;
    private int r;
    private int s;
    private int t;
    private int u;

    public VerticalColorSeekBar(Context context) {
        this(context, null);
    }

    public VerticalColorSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = new int[]{-65536, -256, -16711936, -16711681, -16776961, -65281, -1, -6710887, -16777216};
        this.g = 100.0f;
        this.o = new Paint();
        this.p = new ArrayList();
        a();
    }

    private int a(float f) {
        float f2 = f / 100.0f;
        if (((double) f2) <= 0.0d) {
            return this.b[0];
        }
        if (f2 >= 1.0f) {
            return this.b[this.b.length - 1];
        }
        f2 *= (float) (this.b.length - 1);
        int i = (int) f2;
        f2 -= (float) i;
        this.q = this.b[i];
        this.r = this.b[i + 1];
        this.s = a(Color.red(this.q), Color.red(this.r), f2);
        this.t = a(Color.green(this.q), Color.green(this.r), f2);
        this.u = a(Color.blue(this.q), Color.blue(this.r), f2);
        return Color.rgb(this.s, this.t, this.u);
    }

    private int a(int i, int i2, float f) {
        return Math.round(((float) (i2 - i)) * f) + i;
    }

    private void a() {
        this.p.clear();
        for (int i = 0; ((float) i) <= this.g; i++) {
            this.p.add(Integer.valueOf(a((float) i)));
        }
    }

    private void a(Canvas canvas) {
        RectF rectF = new RectF(this.h, this.i, this.j, this.k);
        this.n = new LinearGradient(this.h, this.i, this.l, this.m, this.b, null, TileMode.MIRROR);
        this.o.setAntiAlias(true);
        this.o.setStyle(Style.FILL);
        this.o.setShader(this.n);
        canvas.drawRoundRect(rectF, this.l / 2.0f, this.l / 2.0f, this.o);
    }

    private void b(Canvas canvas) {
        Paint paint = new Paint();
        this.d = this.d < this.e ? this.e : this.d;
        this.d = this.d > this.m - this.e ? this.m - this.e : this.d;
        paint.setAntiAlias(true);
        paint.setStyle(Style.FILL);
        paint.setColor(getColor());
        canvas.drawCircle(this.c, this.d, this.e, paint);
    }

    private int getColor() {
        int i = (int) this.f;
        return i <= 0 ? ((Integer) this.p.get(0)).intValue() : i >= this.p.size() ? ((Integer) this.p.get(this.p.size() - 1)).intValue() : ((Integer) this.p.get(i)).intValue();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int measuredHeight = getMeasuredHeight();
        int measuredWidth = getMeasuredWidth();
        this.e = ((float) measuredWidth) / 4.0f;
        this.h = ((float) measuredWidth) * 0.375f;
        this.j = ((float) measuredWidth) * 0.625f;
        this.i = 0.0f;
        this.k = (float) measuredHeight;
        this.l = this.j - this.h;
        this.m = this.k - this.i;
        this.c = ((float) measuredWidth) / 2.0f;
        this.d = (this.f / 100.0f) * this.m;
        a(canvas);
        b(canvas);
        this.o.reset();
    }

    protected synchronized void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.d = motionEvent.getY();
        this.f = (this.d / this.m) * 100.0f;
        if (this.f < 0.0f) {
            this.f = 0.0f;
        }
        if (this.f > this.g) {
            this.f = this.g;
        }
        switch (motionEvent.getAction()) {
            case 1:
                if (this.a != null) {
                    this.a.b(this, this.f, getColor());
                    break;
                }
                break;
            case 2:
                if (this.a != null) {
                    this.a.a(this, this.f, getColor());
                }
                setProgress(this.f);
                invalidate();
                break;
        }
        return true;
    }

    public void setOnStateChangeListener(a aVar) {
        this.a = aVar;
    }

    public void setProgress(float f) {
        this.f = f;
        invalidate();
    }

    public void setProgressByColor(int i) {
        for (int i2 = 0; i2 < this.p.size(); i2++) {
            if (i == ((Integer) this.p.get(i2)).intValue()) {
                setProgress((float) i2);
                return;
            }
        }
        setProgress(100.0f);
    }
}
