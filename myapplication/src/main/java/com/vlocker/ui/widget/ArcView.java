package com.vlocker.ui.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

@TargetApi(11)
public class ArcView extends View {
    float a;
    float b;
    float c;
    float d;
    float e;
    float f;
    float g;
    float h;
    RectF i;
    RectF j;
    Paint k;
    int l;
    String m = "#000000";
    final float n = 0.2f;
    final float o = 0.5f;

    public ArcView(Context context) {
        super(context);
        g();
    }

    public ArcView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        g();
    }

    public ArcView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        g();
    }

    private void g() {
        try {
            this.b = (float) getContext().getResources().getDisplayMetrics().widthPixels;
            this.a = 0.0f;
            this.l = Color.parseColor(this.m);
            this.k = new Paint();
            this.k.setAntiAlias(true);
            this.k.setColor(this.l);
            this.k.setStyle(Style.FILL);
            if (VERSION.SDK_INT > 10) {
                setAlpha(0.2f);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Error e2) {
            e2.printStackTrace();
        }
    }

    public void a() {
        this.e = (((this.b * this.b) / 8.0f) / this.a) + (this.a / 2.0f);
    }

    public void a(float f) {
        setArcHeight(f);
    }

    public void b() {
        this.f = (((float) Math.asin((double) ((this.b / 2.0f) / this.e))) * 360.0f) / 3.142f;
        this.g = 90.0f - (this.f / 2.0f);
    }

    public void c() {
        this.c = this.b / 2.0f;
        this.d = this.a - this.e;
    }

    public void d() {
        this.i = new RectF(this.c - this.e, this.d - this.e, this.c + this.e, this.a);
        if (this.a - (this.b / 2.0f) > 0.0f) {
            f();
            this.j = new RectF(0.0f, 0.0f, this.b, (this.a - this.h) + 2.0f);
        }
    }

    public void e() {
        try {
            a();
            c();
            d();
            b();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void f() {
        this.h = (float) (((double) this.e) - Math.sqrt((double) ((this.e * this.e) - ((this.b * this.b) / 4.0f))));
    }

    protected void onDraw(Canvas canvas) {
        try {
            e();
            if (this.a - (this.b / 2.0f) > 0.0f) {
                canvas.drawRect(this.j, this.k);
            }
            canvas.drawArc(this.i, this.g, this.f, false, this.k);
            if (this.a < this.b / 2.0f) {
                float f = 0.2f + ((0.3f * this.a) / (this.b / 2.0f));
                if (VERSION.SDK_INT > 10) {
                    setAlpha(f);
                }
            } else if (VERSION.SDK_INT > 10) {
                setAlpha(0.5f);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.a != 0.0f;
    }

    public void setArcHeight(float f) {
        this.a = f;
        invalidate();
    }
}
