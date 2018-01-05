package com.vlocker.ui.widget.b;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import com.vlocker.m.ba;
import com.vlocker.ui.widget.a.d;
import java.util.Date;

public class a extends c {
    Paint a = new Paint();
    String b;
    com.vlocker.ui.widget.a.a c;

    public a(Context context, d dVar) {
        super(context, dVar);
        this.c = (com.vlocker.ui.widget.a.a) dVar;
    }

    private void b(Canvas canvas) {
        float f = 1.0f;
        this.a.reset();
        this.a.setAntiAlias(true);
        this.a.setTextSize(((float) this.c.x) * com.vlocker.ui.widget.c.d.b);
        if (this.c.B != null) {
            this.a.setTypeface(ba.a(this.d, this.c.B, true));
        } else if (this.c.H == 1) {
            this.a.setTypeface(Typeface.create(Typeface.DEFAULT, 1));
        } else if (this.c.H == 2) {
            this.a.setTypeface(Typeface.create(Typeface.DEFAULT, 2));
        }
        int hours = new Date(System.currentTimeMillis()).getHours();
        this.b = "AM";
        if (hours > 12) {
            this.b = "PM";
        }
        float d = d();
        float e = e();
        float measureText = this.a.measureText(this.b);
        if (this.c.m == 0) {
            d -= measureText / 2.0f;
        } else if (this.c.m == 2) {
            d -= measureText;
        }
        Rect rect = new Rect();
        this.a.getTextBounds(this.b, 0, this.b.length(), rect);
        measureText = (float) rect.height();
        if (this.c.n == 0) {
            e += measureText / 2.0f;
        } else if (this.c.n == 2) {
            e += measureText;
        }
        int i = this.c.E;
        if (this.c.K == 1) {
            float f2 = this.d.getResources().getDisplayMetrics().density / 1.5f;
            if (f2 > 1.0f) {
                f = 1.0f * f2;
            }
            this.a.setShadowLayer(f, 0.0f, 0.0f, this.c.I);
        }
        this.a.setColor(i);
        this.a.setAlpha(this.c.P);
        if (this.c.Q != 0.0f) {
            f = d;
            for (hours = 0; hours < this.b.length(); hours++) {
                canvas.drawText(this.b.substring(hours, hours + 1), f, e, this.a);
                f += this.a.measureText(this.b.substring(hours, hours + 1)) + (this.c.Q * com.vlocker.ui.widget.c.d.b);
            }
            return;
        }
        canvas.drawText(this.b, d, e, this.a);
    }

    public void a() {
    }

    public void a(Canvas canvas) {
        b(canvas);
    }

    public int b() {
        return 0;
    }

    public float c() {
        return 0.0f;
    }
}
