package com.vlocker.battery.clean;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.vlocker.m.l;

public class CleanMaskButtonView extends View {
    private Paint a;
    private float b;
    private ValueAnimator c;
    private Path d;

    public CleanMaskButtonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c();
    }

    private void c() {
        this.a = new Paint();
        this.a.setColor(-1);
        this.a.setStyle(Style.FILL);
        this.a.setAntiAlias(true);
        this.c = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.c.setDuration(800);
        this.c.setStartDelay(900);
        this.c.setRepeatMode(1);
        this.c.setInterpolator(new LinearInterpolator());
        this.c.addUpdateListener(new ah(this));
        this.c.addListener(new ai(this));
        this.d = new Path();
    }

    public void a() {
        this.c.cancel();
        this.b = 0.0f;
        this.c.start();
    }

    public void b() {
        this.c.cancel();
        this.b = 0.0f;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.b >= 0.625f) {
            this.a.setAlpha((int) (46.0f * (1.0f - ((this.b - 0.625f) / 0.375f))));
        } else {
            this.a.setAlpha(46);
        }
        float height = (float) getHeight();
        float a = ((float) l.a(-27.0f)) + (((float) l.a(325.0f)) * this.b);
        float a2 = (((float) l.a(-27.0f)) + (((float) l.a(325.0f)) * this.b)) + ((float) l.a(23.0f));
        this.d.reset();
        this.d.moveTo(a2, 0.0f);
        this.d.lineTo(a2 - ((float) l.a(23.0f)), height);
        this.d.lineTo(a - ((float) l.a(23.0f)), height);
        this.d.lineTo(a, 0.0f);
        this.d.close();
        canvas.drawPath(this.d, this.a);
    }
}
