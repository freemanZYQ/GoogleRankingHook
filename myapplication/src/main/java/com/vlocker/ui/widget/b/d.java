package com.vlocker.ui.widget.b;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import com.vlocker.c.a;
import com.vlocker.m.ay;
import com.vlocker.m.ba;
import com.vlocker.security.MoSecurityApplication;
import com.vlocker.ui.widget.a.e;
import java.util.ArrayList;
import java.util.Date;

public class d extends c {
    TextPaint a = new TextPaint();
    Paint b = new Paint();
    TextPaint c = new TextPaint();
    Paint g = new Paint();
    TextPaint h = new TextPaint();
    Paint i = new Paint();
    String j;
    e k;
    String[] l = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    ArrayList m = new ArrayList();
    ArrayList n = new ArrayList();

    public d(Context context, com.vlocker.ui.widget.a.d dVar) {
        super(context, dVar);
        this.k = (e) dVar;
        a a = a.a(MoSecurityApplication.a());
        if (!a.do()) {
            a.aV(true);
            a.aj(this.k.E);
        }
    }

    private String a(int i) {
        return (i == 1 || i == 21 || i == 31) ? "st" : (i == 2 || i == 22) ? "nd" : (i == 3 || i == 23) ? "rd" : "th";
    }

    private String a(int i, int i2) {
        return "chinese".equals(this.k.M) ? ay.a(i, i2) : i + "";
    }

    private void a(Paint paint) {
        float f = 1.0f;
        paint.reset();
        paint.setAntiAlias(true);
        paint.setTextSize(((float) this.k.x) * com.vlocker.ui.widget.c.d.b);
        paint.setColor(this.k.E);
        paint.setAlpha(this.k.P);
        if (this.k.K == 1) {
            float f2 = this.d.getResources().getDisplayMetrics().density / 1.5f;
            if (f2 > 1.0f) {
                f = 1.0f * f2;
            }
            paint.setShadowLayer(f, 0.0f, 0.0f, this.k.I);
        }
        if (this.k.B != null) {
            paint.setTypeface(ba.a(this.d, this.k.B, true));
        } else if (this.k.H == 1) {
            paint.setTypeface(Typeface.create(Typeface.DEFAULT, 1));
        } else if (this.k.H == 2) {
            paint.setTypeface(Typeface.create(Typeface.DEFAULT, 2));
        }
    }

    private void b(Canvas canvas) {
        int i;
        float d = d();
        float e = e();
        float f = 0.0f;
        for (i = 0; i < this.m.size(); i++) {
            f += this.i.measureText((String) this.m.get(i));
        }
        for (i = 0; i < this.n.size(); i++) {
            f += this.g.measureText((String) this.n.get(i));
        }
        f = this.k.m == 0 ? d - (f / 2.0f) : this.k.m == 2 ? d - f : d;
        Rect rect = new Rect();
        if (this.i.getTextSize() >= this.g.getTextSize()) {
            this.i.getTextBounds((String) this.m.get(0), 0, ((String) this.m.get(0)).length(), rect);
        } else {
            this.g.getTextBounds((String) this.n.get(0), 0, ((String) this.n.get(0)).length(), rect);
        }
        float height = (float) rect.height();
        float f2 = this.k.n == 0 ? (height / 2.0f) + e : this.k.n == 2 ? height + e : e;
        int i2 = 0;
        while (i2 < 3) {
            int i3;
            if (this.m.size() <= i2) {
                d = f;
            } else if (this.k.Q != 0.0f) {
                d = f;
                for (i3 = 0; i3 < ((String) this.m.get(i2)).length(); i3++) {
                    canvas.drawText(((String) this.m.get(i2)).substring(i2, i2 + 1), d, f2, this.i);
                    d += this.i.measureText(((String) this.m.get(i2)).substring(i3, i3 + 1)) + (this.k.Q * com.vlocker.ui.widget.c.d.b);
                }
            } else {
                canvas.drawText((String) this.m.get(i2), f, f2, this.i);
                d = f + this.i.measureText((String) this.m.get(i2));
            }
            if (this.n.size() > i2) {
                if (this.k.Q != 0.0f) {
                    for (i3 = 0; i3 < ((String) this.n.get(i2)).length(); i3++) {
                        canvas.drawText(((String) this.n.get(i2)).substring(i3, i3 + 1), d, f2, this.g);
                        d += this.g.measureText(((String) this.m.get(i2)).substring(i3, i3 + 1)) + (this.k.Q * com.vlocker.ui.widget.c.d.b);
                    }
                } else {
                    canvas.drawText((String) this.n.get(i2), d, f2, this.g);
                    d += this.g.measureText((String) this.n.get(i2));
                }
            }
            i2++;
            f = d;
        }
    }

    private void b(Paint paint) {
        paint.reset();
        paint.setAntiAlias(true);
        paint.setTextSize(((float) (this.k.y != -1 ? this.k.y : this.k.x)) * com.vlocker.ui.widget.c.d.b);
        paint.setColor(this.k.F != 0 ? this.k.F : this.k.E);
        paint.setAlpha(this.k.P);
        if (this.k.K == 1) {
            float f = this.d.getResources().getDisplayMetrics().density / 1.5f;
            paint.setShadowLayer(f > 1.0f ? f * 1.0f : 1.0f, 0.0f, 0.0f, this.k.I);
        }
        if (this.k.B == null && this.k.C == null) {
            if (this.k.H == 1) {
                paint.setTypeface(Typeface.create(Typeface.DEFAULT, 1));
            } else if (this.k.H == 2) {
                paint.setTypeface(Typeface.create(Typeface.DEFAULT, 2));
            }
        } else if (!TextUtils.isEmpty(this.k.C)) {
            paint.setTypeface(ba.a(this.d, this.k.C, true));
        } else if (!TextUtils.isEmpty(this.k.B)) {
            paint.setTypeface(ba.a(this.d, this.k.B, true));
        }
    }

    private void c(Canvas canvas) {
        float d = d();
        float e = e();
        this.a.setColor(this.k.E);
        FontMetrics fontMetrics = this.a.getFontMetrics();
        float length = (fontMetrics.descent - fontMetrics.ascent) * ((float) this.j.length());
        float f = this.k.n == 0 ? e - (length / 2.0f) : this.k.n == 2 ? e - length : e;
        StaticLayout staticLayout = new StaticLayout(this.j, this.a, (int) this.a.measureText(" "), Alignment.ALIGN_CENTER, 1.0f, this.k.Q, true);
        canvas.save();
        canvas.translate(d, f);
        staticLayout.draw(canvas);
        canvas.restore();
    }

    private void c(Paint paint) {
        paint.reset();
        paint.setAntiAlias(true);
        paint.setTextSize(((float) (this.k.z != -1 ? this.k.z : this.k.x)) * com.vlocker.ui.widget.c.d.b);
        paint.setColor(this.k.G != 0 ? this.k.G : this.k.E);
        paint.setAlpha(this.k.P);
        if (this.k.K == 1) {
            float f = this.d.getResources().getDisplayMetrics().density / 1.5f;
            paint.setShadowLayer(f > 1.0f ? f * 1.0f : 1.0f, 0.0f, 0.0f, this.k.I);
        }
        if (this.k.B == null && this.k.D == null) {
            if (this.k.H == 1) {
                paint.setTypeface(Typeface.create(Typeface.DEFAULT, 1));
            } else if (this.k.H == 2) {
                paint.setTypeface(Typeface.create(Typeface.DEFAULT, 2));
            }
        } else if (!TextUtils.isEmpty(this.k.D)) {
            paint.setTypeface(ba.a(this.d, this.k.D, true));
        } else if (!TextUtils.isEmpty(this.k.B)) {
            paint.setTypeface(ba.a(this.d, this.k.B, true));
        }
    }

    private void d(Canvas canvas) {
        float d = d();
        float e = e();
        float measureText = this.b.measureText(this.j);
        if (this.k.m == 0) {
            d -= measureText / 2.0f;
        } else if (this.k.m == 2) {
            d -= measureText;
        }
        Rect rect = new Rect();
        this.b.getTextBounds(this.j, 0, this.j.length(), rect);
        measureText = (float) rect.height();
        if (this.k.n == 0) {
            e += measureText / 2.0f;
        } else if (this.k.n == 2) {
            e += measureText;
        }
        if (this.k.Q != 0.0f) {
            float f = d;
            for (int i = 0; i < this.j.length(); i++) {
                canvas.drawText(this.j.substring(i, i + 1), f, e, this.b);
                f += this.b.measureText(this.j.substring(i, i + 1)) + (this.k.Q * com.vlocker.ui.widget.c.d.b);
            }
            return;
        }
        canvas.drawText(this.j, d, e, this.b);
    }

    private void e(Canvas canvas) {
        int i;
        float d = d();
        float e = e();
        this.h.setTextAlign(Align.CENTER);
        this.c.setTextAlign(Align.CENTER);
        FontMetrics fontMetrics = this.h.getFontMetrics();
        FontMetrics fontMetrics2 = this.c.getFontMetrics();
        float f = 0.0f;
        for (i = 0; i < this.m.size(); i++) {
            f += ((float) ((String) this.m.get(i)).length()) * (fontMetrics.descent - fontMetrics.ascent);
        }
        for (i = 0; i < this.n.size(); i++) {
            f += ((float) ((String) this.n.get(i)).length()) * (fontMetrics2.descent - fontMetrics2.ascent);
        }
        float f2 = this.k.n == 0 ? e - (f / 2.0f) : this.k.n == 2 ? e - f : e;
        float f3 = f2;
        for (int i2 = 0; i2 < 3; i2++) {
            if (this.m.size() > i2) {
                StaticLayout staticLayout = new StaticLayout((CharSequence) this.m.get(i2), this.h, (int) this.h.measureText(" "), Alignment.ALIGN_NORMAL, 1.0f, this.k.Q, true);
                canvas.save();
                canvas.translate(d, f3);
                staticLayout.draw(canvas);
                canvas.restore();
                f3 = "number".equals(this.k.M) ? (fontMetrics.descent - fontMetrics.ascent) + f3 : (((float) ((String) this.m.get(i2)).length()) * (fontMetrics.descent - fontMetrics.ascent)) + f3;
            }
            if (this.n.size() > i2) {
                staticLayout = new StaticLayout((CharSequence) this.n.get(i2), this.c, (int) this.c.measureText(" "), Alignment.ALIGN_NORMAL, 1.0f, this.k.Q, true);
                canvas.save();
                canvas.translate(d, f3);
                staticLayout.draw(canvas);
                canvas.restore();
                f3 += ((float) ((String) this.n.get(i2)).length()) * (fontMetrics2.descent - fontMetrics2.ascent);
            }
        }
    }

    private void f() {
        Date date = new Date();
        int month = date.getMonth() + 1;
        int date2 = date.getDate();
        int year = date.getYear() + 1900;
        String a = a(month, 1);
        String a2 = a(date2, 1);
        String a3 = a(year, 3);
        if (this.k.a == 1) {
            this.j = a + "/" + a2;
        } else if (this.k.a == 2) {
            this.j = this.l[date.getMonth()].toUpperCase() + "." + date2 + a(date2);
        } else if (this.k.a == 3) {
            this.j = this.l[date.getMonth()] + " " + date2 + a(date2);
        } else if (this.k.a == 4) {
            this.j = this.l[date.getMonth()] + "," + date2;
        } else if (this.k.a == 5) {
            this.j = this.l[date.getMonth()] + "." + date2;
        } else if (this.k.a == 6) {
            this.j = this.l[date.getMonth()] + "." + date2 + a(date2);
        } else if (this.k.a == 7) {
            this.j = a + "月" + a2 + "日";
        } else if (this.k.a == 8) {
            this.j = a + "." + a2;
        } else if (this.k.a == 9) {
            this.j = a3 + "年" + a + "月" + a2 + "日";
        } else if (this.k.a == 10) {
            this.j = a + "月" + a2 + "日" + a3 + "年";
        } else if (this.k.a == 11) {
            this.j = a2 + "日" + a + "月" + a3 + "年";
        } else if (this.k.a == 12) {
            this.j = ay.a();
        } else if (this.k.a == 13) {
            this.j = ay.d();
        } else if (this.k.a == 14) {
            this.j = this.l[date.getMonth()].toUpperCase() + "." + date2;
        } else if (this.k.a == 15) {
            this.j = a + "/" + a2;
        } else if (this.k.a == 16) {
            this.j = a3 + "." + a + "." + a2;
        } else if (this.k.a == 17) {
            this.j = a3 + "-" + a + "-" + a2;
        } else if (this.k.a == 18) {
            this.j = a3 + "/" + a + "/" + a2;
        } else {
            this.j = a + "-" + a2;
        }
    }

    private void g() {
        this.m.clear();
        this.n.clear();
        Date date = new Date();
        int month = date.getMonth() + 1;
        int date2 = date.getDate();
        int year = date.getYear() + 1900;
        String a = a(month, 1);
        String a2 = a(date2, 1);
        String a3 = a(year, 3);
        if (this.k.a == 1) {
            this.m.add(a);
            this.m.add(a2);
            this.n.add("/");
        } else if (this.k.a == 2) {
            this.m.add(this.l[date.getMonth()].toUpperCase());
            this.m.add(date2 + "");
            this.n.add(".");
            this.n.add("th");
        } else if (this.k.a == 3) {
            this.m.add(this.l[date.getMonth()]);
            this.m.add(date2 + "");
            this.n.add(" ");
            this.n.add("th");
        } else if (this.k.a == 4) {
            this.m.add(this.l[date.getMonth()]);
            this.m.add(date2 + "");
            this.n.add(",");
        } else if (this.k.a == 5) {
            this.m.add(this.l[date.getMonth()]);
            this.m.add(date2 + "");
            this.n.add(".");
        } else if (this.k.a == 6) {
            this.m.add(this.l[date.getMonth()].toLowerCase());
            this.m.add(date2 + "");
            this.n.add(".");
            this.n.add("th");
        } else if (this.k.a == 7) {
            this.m.add(a);
            this.m.add(a2);
            this.n.add("月");
            this.n.add("日");
        } else if (this.k.a == 8) {
            this.m.add(a);
            this.m.add(a2);
            this.n.add(".");
        } else if (this.k.a == 9) {
            this.m.add(a3);
            this.m.add(a);
            this.m.add(a2);
            this.n.add("年");
            this.n.add("月");
            this.n.add("日");
        } else if (this.k.a == 10) {
            this.m.add(a);
            this.m.add(a2);
            this.m.add(a3);
            this.n.add("月");
            this.n.add("日");
            this.n.add("年");
        } else if (this.k.a == 11) {
            this.m.add(a2);
            this.m.add(a);
            this.m.add(a3);
            this.n.add("日");
            this.n.add("月");
            this.n.add("年");
        } else if (this.k.a == 12) {
            this.j = ay.a();
        } else if (this.k.a == 13) {
            this.j = ay.d();
        } else if (this.k.a == 14) {
            this.m.add(this.l[date.getMonth()].toUpperCase());
            this.m.add(date2 + "");
            this.n.add(".");
        } else if (this.k.a == 15) {
            this.m.add(a);
            this.m.add(a2);
            this.n.add("/");
        } else if (this.k.a == 16) {
            this.m.add(a3);
            this.m.add(a);
            this.m.add(a2);
            this.n.add(".");
            this.n.add(".");
        } else if (this.k.a == 17) {
            this.m.add(a3);
            this.m.add(a);
            this.m.add(a2);
            this.n.add("-");
            this.n.add("-");
        } else if (this.k.a == 18) {
            this.m.add(a3);
            this.m.add(a);
            this.m.add(a2);
            this.n.add("/");
            this.n.add("/");
        } else {
            this.m.add(a);
            this.m.add(a2);
            this.n.add("-");
        }
    }

    public void a() {
    }

    public void a(Canvas canvas) {
        if (this.k.a()) {
            g();
            if (this.k.O) {
                b(this.h);
                c(this.c);
                e(canvas);
                return;
            }
            b(this.i);
            c(this.g);
            b(canvas);
            return;
        }
        f();
        if (this.k.O) {
            a(this.a);
            c(canvas);
            return;
        }
        a(this.b);
        d(canvas);
    }

    public int b() {
        return 0;
    }

    public float c() {
        return 0.0f;
    }
}
