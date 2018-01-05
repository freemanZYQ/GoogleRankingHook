package com.vlocker.ui.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import com.qq.e.comm.constants.ErrorCode.InitError;
import com.vlocker.m.l;

public class WaveAnimView extends View {
    private int a;
    private int b;
    private float c;
    private float d;
    private boolean e;
    private Paint f;
    private Handler g = new aq(this);
    private float h = ((float) l.a(102.0f));
    private float i = ((float) l.a(32.0f));
    private boolean j;
    private ValueAnimator k = d();
    private ValueAnimator l = d();

    public WaveAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.k.addUpdateListener(new ar(this));
        this.l.addUpdateListener(new as(this));
    }

    private void a(Canvas canvas, int i) {
        if (i > 0) {
            float f = (this.i * (((float) i) / 1600.0f)) + this.h;
            this.f.setAlpha((int) ((i <= InitError.INIT_AD_ERROR ? (((float) i) / 300.0f) * 0.3f : (1.0f - (((float) (i - 300)) / 1300.0f)) * 0.3f) * 255.0f));
            canvas.drawCircle(this.c, this.d, f / 2.0f, this.f);
        }
    }

    private void c() {
        this.j = true;
        this.f = new Paint();
        this.f.setAntiAlias(true);
        this.f.setStrokeWidth((float) l.a(1.5f));
        this.f.setStyle(Style.STROKE);
        this.f.setColor(-12753545);
        this.c = (float) (getWidth() / 2);
        this.d = (float) (getHeight() / 2);
    }

    private ValueAnimator d() {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{0, 1600});
        ofInt.setDuration(1600);
        ofInt.addListener(new at(this));
        ofInt.setInterpolator(new DecelerateInterpolator());
        return ofInt;
    }

    public void a() {
        if (!this.e) {
            this.e = true;
            this.k.cancel();
            this.k.start();
            this.g.removeMessages(1);
            this.g.sendEmptyMessageDelayed(1, 400);
        }
    }

    public void b() {
        if (this.e) {
            this.e = false;
            this.k.cancel();
            this.l.cancel();
            this.g.removeMessages(1);
            this.a = 0;
            this.b = 0;
            postInvalidate();
        }
    }

    protected void onDraw(Canvas canvas) {
        if (!this.j) {
            c();
        }
        super.onDraw(canvas);
        a(canvas, this.a);
        a(canvas, this.b);
    }
}
