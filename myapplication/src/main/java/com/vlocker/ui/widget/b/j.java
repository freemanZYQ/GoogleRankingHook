package com.vlocker.ui.widget.b;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import com.vlocker.m.ba;
import com.vlocker.ui.widget.a.d;
import com.vlocker.ui.widget.a.s;
import java.util.Calendar;

public class j extends c {
    String[] a = new String[]{"日", "一", "二", "三", "四", "五", "六"};
    String[] b = new String[]{"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
    String[] c = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    TextPaint g = new TextPaint();
    Paint h = new Paint();
    String i;
    s j;

    public j(Context context, d dVar) {
        super(context, dVar);
        this.j = (s) dVar;
    }

    private void a(Paint paint) {
        float f = 1.0f;
        paint.reset();
        paint.setAntiAlias(true);
        paint.setTextSize(((float) this.j.x) * com.vlocker.ui.widget.c.d.b);
        paint.setColor(this.j.E);
        paint.setAlpha(this.j.P);
        if (this.j.K == 1) {
            float f2 = this.d.getResources().getDisplayMetrics().density / 1.5f;
            if (f2 > 1.0f) {
                f = 1.0f * f2;
            }
            paint.setShadowLayer(f, 0.0f, 0.0f, this.j.I);
        }
        if (this.j.B != null) {
            paint.setTypeface(ba.a(this.d, this.j.B, true));
        } else if (this.j.H == 1) {
            paint.setTypeface(Typeface.create(Typeface.DEFAULT, 1));
        } else if (this.j.H == 2) {
            paint.setTypeface(Typeface.create(Typeface.DEFAULT, 2));
        }
    }

    private void b(Canvas canvas) {
        float d = d();
        float e = e();
        float measureText = this.h.measureText(this.i);
        if (this.j.m == 0) {
            d -= measureText / 2.0f;
        } else if (this.j.m == 2) {
            d -= measureText;
        }
        Rect rect = new Rect();
        this.h.getTextBounds(this.i, 0, this.i.length(), rect);
        measureText = (float) rect.height();
        if (this.j.n == 0) {
            e += measureText / 2.0f;
        } else if (this.j.n == 2) {
            e += measureText;
        }
        if (this.j.Q != 0.0f) {
            float f = d;
            for (int i = 0; i < this.i.length(); i++) {
                canvas.drawText(this.i.substring(i, i + 1), f, e, this.h);
                f += this.h.measureText(this.i.substring(i, i + 1)) + (this.j.Q * com.vlocker.ui.widget.c.d.b);
            }
            return;
        }
        canvas.drawText(this.i, d, e, this.h);
    }

    private void c(Canvas canvas) {
        float d = d();
        float e = e();
        FontMetrics fontMetrics = this.g.getFontMetrics();
        float length = (fontMetrics.descent - fontMetrics.ascent) * ((float) this.i.length());
        float f = this.j.n == 0 ? e - (length / 2.0f) : this.j.n == 2 ? e - length : e;
        StaticLayout staticLayout = new StaticLayout(this.i, this.g, (int) this.g.measureText(" "), Alignment.ALIGN_CENTER, 1.0f, this.j.Q, true);
        canvas.save();
        canvas.translate(d, f);
        staticLayout.draw(canvas);
        canvas.restore();
    }

    private void f() {
        int i = Calendar.getInstance().get(7);
        if (i >= 0 && i <= 7) {
            if (this.j.a == 1) {
                this.i = this.b[i - 1].toUpperCase();
            } else if (this.j.a == 2) {
                this.i = this.c[i - 1].toUpperCase();
            } else if (this.j.a == 3) {
                this.i = "周" + this.a[i - 1];
            } else if (this.j.a == 6) {
                this.i = this.b[i - 1].toLowerCase();
            } else if (this.j.a == 7) {
                this.i = "星期" + this.a[i - 1];
            } else if (this.j.a == 8) {
                this.i = "礼拜" + this.a[i - 1];
            } else if (this.j.a == 4) {
                this.i = this.c[i - 1];
            } else if (this.j.a == 5) {
                this.i = this.b[i - 1];
            } else {
                this.i = this.b[i - 1];
            }
        }
    }

    public void a() {
    }

    public void a(Canvas canvas) {
        f();
        if (this.j.O) {
            a(this.g);
            c(canvas);
            return;
        }
        a(this.h);
        b(canvas);
    }

    public int b() {
        return 0;
    }

    public float c() {
        return 0.0f;
    }
}
