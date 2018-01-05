package com.vlocker.ui.widget.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.format.DateFormat;
import com.vlocker.m.ay;
import com.vlocker.m.ba;
import com.vlocker.ui.widget.a.d;
import com.vlocker.ui.widget.a.f;
import java.util.Date;

public class e extends c {
    public f a;
    int b = 0;
    int c = -1;
    int g;
    int h = -1;
    Bitmap i;
    Bitmap j;
    Bitmap k;
    Bitmap l;
    Bitmap m;
    Paint n = new Paint();
    String o = "06";
    TextPaint p = new TextPaint();

    public e(Context context, d dVar) {
        super(context, dVar);
        this.a = (f) dVar;
        f();
    }

    private String a(int i, int i2) {
        return ("chinese".equals(this.a.M) || this.a.b == 5) ? i2 == 1 ? ay.a(i, i2) + "时" : ay.a(i, i2) + "分" : i < 10 ? "0" + i : i + "";
    }

    public static boolean a(Context context) {
        return DateFormat.is24HourFormat(context);
    }

    private void b(Canvas canvas) {
        float f = 1.0f;
        this.n.reset();
        this.n.setAntiAlias(true);
        this.n.setTextSize(((float) this.a.x) * com.vlocker.ui.widget.c.d.b);
        if (this.a.B != null) {
            this.n.setTypeface(ba.a(this.d, this.a.B, true));
        } else if (this.a.H == 1) {
            this.n.setTypeface(Typeface.create(Typeface.DEFAULT, 1));
        } else if (this.a.H == 2) {
            this.n.setTypeface(Typeface.create(Typeface.DEFAULT, 2));
        }
        float d = d();
        float e = e();
        float measureText = this.n.measureText(this.o);
        if (this.a.m == 0) {
            d -= measureText / 2.0f;
        } else if (this.a.m == 2) {
            d -= measureText;
        }
        Rect rect = new Rect();
        this.n.getTextBounds(this.o, 0, this.o.length(), rect);
        measureText = (float) rect.height();
        if (this.a.n == 0) {
            e += measureText / 2.0f;
        } else if (this.a.n == 2) {
            e += measureText;
        }
        int i = this.a.E;
        if (this.a.K == 1) {
            float f2 = this.d.getResources().getDisplayMetrics().density / 1.5f;
            if (f2 > 1.0f) {
                f = 1.0f * f2;
            }
            this.p.setShadowLayer(f, 0.0f, 0.0f, this.a.I);
        }
        this.n.setColor(i);
        this.n.setAlpha(this.a.P);
        if (this.a.Q != 0.0f) {
            f = d;
            for (int i2 = 0; i2 < this.o.length(); i2++) {
                canvas.drawText(this.o.substring(i2, i2 + 1), f, e, this.n);
                f += this.n.measureText(this.o.substring(i2, i2 + 1)) + (this.a.Q * com.vlocker.ui.widget.c.d.b);
            }
            return;
        }
        canvas.drawText(this.o, d, e, this.n);
    }

    private void c(Canvas canvas) {
        this.p.reset();
        this.p.setAntiAlias(true);
        this.p.setTextSize(((float) this.a.x) * com.vlocker.ui.widget.c.d.b);
        if (this.a.B != null) {
            this.p.setTypeface(ba.a(this.d, this.a.B, true));
        } else if (this.a.H == 1) {
            this.p.setTypeface(Typeface.create(Typeface.DEFAULT, 1));
        } else if (this.a.H == 2) {
            this.p.setTypeface(Typeface.create(Typeface.DEFAULT, 2));
        }
        float d = d();
        float e = e();
        this.p.setColor(this.a.E);
        this.p.setAlpha(this.a.P);
        FontMetrics fontMetrics = this.p.getFontMetrics();
        float length = (fontMetrics.descent - fontMetrics.ascent) * ((float) this.o.length());
        float f = this.a.n == 0 ? e - (length / 2.0f) : this.a.n == 2 ? e - length : e;
        StaticLayout staticLayout = new StaticLayout(this.o, this.p, (int) this.p.measureText(" "), Alignment.ALIGN_NORMAL, 1.0f, this.a.Q, true);
        canvas.save();
        canvas.translate(d, f);
        staticLayout.draw(canvas);
        canvas.restore();
    }

    public Rect a(boolean z) {
        this.n.setTextSize(z ? ((float) this.a.x) * com.vlocker.ui.widget.c.d.b : (float) this.a.x);
        if (this.a.B != null) {
            this.n.setTypeface(ba.a(this.d, this.a.B, true));
        } else if (this.a.H == 1) {
            this.n.setTypeface(Typeface.create(Typeface.DEFAULT, 1));
        } else if (this.a.H == 2) {
            this.n.setTypeface(Typeface.create(Typeface.DEFAULT, 2));
        }
        Rect rect = new Rect();
        this.n.getTextBounds(this.o, 0, this.o.length(), rect);
        return rect;
    }

    public void a() {
        Date date = new Date(System.currentTimeMillis());
        this.b = date.getHours();
        if (!a(this.d)) {
            this.b = this.b > 12 ? this.b - 12 : this.b;
            if (this.b == 0) {
                this.b = 12;
            }
        }
        this.g = date.getMinutes();
        String str = "" + this.g;
        if (this.g < 10) {
            str = "0" + this.g;
        }
        if (this.a.b <= 0) {
            this.o = this.b + ":" + str;
        } else if (this.a.b == 3) {
            this.o = a(this.b, 1);
        } else if (this.a.b == 4) {
            this.b = this.b > 12 ? this.b - 12 : this.b;
            this.o = "" + this.b;
            if (this.b < 10) {
                if (!a(this.d) && this.b == 0) {
                    this.b = 12;
                }
                this.o = "0" + this.b;
            }
        } else if (this.a.b == 2) {
            this.o = a(this.g, 2);
        } else if (this.a.b == 5) {
            this.o = a(this.b, 1) + a(this.g, 2);
        }
        if (this.c != this.b) {
            this.c = this.b;
            if (!(this.a == null || this.a.J || this.a.b > 1)) {
                g();
            }
        }
        if (this.h != this.g) {
            this.h = this.g;
            if (this.a != null && !this.a.J) {
                if (this.a.b == 1 || this.a.b == 2) {
                    h();
                }
            }
        }
    }

    public void a(Canvas canvas) {
        if (this.a == null) {
            return;
        }
        if (!this.a.J) {
            float d = d();
            float e = e();
            float f = ((float) this.a.a) * com.vlocker.ui.widget.c.d.b;
            if (this.a.n == 0) {
                if (this.a.b == 2 && this.l != null) {
                    e -= (float) (this.l.getHeight() / 2);
                } else if (this.i != null) {
                    e -= (float) (this.i.getHeight() / 2);
                }
            } else if (this.a.n == 2) {
                if (this.a.b == 2 && this.l != null) {
                    e -= (float) this.l.getHeight();
                } else if (this.i != null) {
                    e -= (float) this.i.getHeight();
                }
            }
            if (this.a.b == 2) {
                if (this.l != null) {
                    canvas.drawBitmap(this.l, d, e, null);
                    d += f + ((float) this.l.getWidth());
                }
                if (this.m != null) {
                    canvas.drawBitmap(this.m, d, e, null);
                }
            } else if (this.i != null) {
                canvas.drawBitmap(this.i, d, e, null);
                d += ((float) this.i.getWidth()) + f;
                if (this.j != null) {
                    canvas.drawBitmap(this.j, d, e, null);
                    d += ((float) this.j.getWidth()) + f;
                }
                if (this.a.b == 1) {
                    if (this.k != null) {
                        canvas.drawBitmap(this.k, d, e, null);
                        d += ((float) this.k.getWidth()) + f;
                    }
                    if (this.l != null) {
                        canvas.drawBitmap(this.l, d, e, null);
                        d += f + ((float) this.l.getWidth());
                    }
                    if (this.m != null) {
                        canvas.drawBitmap(this.m, d, e, null);
                    }
                }
            }
        } else if (this.a.O) {
            c(canvas);
        } else {
            b(canvas);
        }
    }

    public int b() {
        if (this.a.J) {
            Rect a = a(true);
            float f;
            if (this.a.O) {
                FontMetrics fontMetrics = this.n.getFontMetrics();
                f = ("chinese".equals(this.a.M) || this.a.b == 5) ? (fontMetrics.descent - fontMetrics.ascent) * 7.0f : (fontMetrics.descent - fontMetrics.ascent) * 5.0f;
                if (this.a.n != 0) {
                    return this.a.n == 2 ? (int) e() : (int) (f + e());
                } else {
                    return (int) ((f / 2.0f) + e());
                }
            }
            float e = e();
            Rect rect = new Rect();
            String str = "";
            str = ("chinese".equals(this.a.M) || this.a.b == 5) ? "零一二三四五六七八九时分" : "0123456789";
            this.n.getTextBounds(str, 0, str.length(), rect);
            f = (float) rect.height();
            f = this.a.n == 0 ? (f / 2.0f) + e : this.a.n == 2 ? f + e : e;
            return (int) (f + ((float) a.bottom));
        }
        if (this.a.n == 0) {
            if (this.a.b == 2 && this.l != null) {
                return (int) (e() + ((float) (this.l.getHeight() / 2)));
            }
            if (this.i != null) {
                return (int) (e() + ((float) (this.i.getHeight() / 2)));
            }
        } else if (this.a.n == 2) {
            return (int) e();
        } else {
            if (this.i != null) {
                return (int) (e() + ((float) this.i.getHeight()));
            }
            if (this.l != null) {
                return (int) (e() + ((float) this.l.getHeight()));
            }
        }
        return 0;
    }

    public float c() {
        float f;
        int i = 5;
        if (this.a.J) {
            Rect a = a(false);
            float f2;
            if (this.a.O) {
                f2 = this.a.g;
                FontMetrics fontMetrics = this.n.getFontMetrics();
                float f3 = fontMetrics.descent - fontMetrics.ascent;
                if ("chinese".equals(this.a.M) || this.a.b == 5) {
                    i = 7;
                }
                f = ((float) i) * f3;
                f = this.a.n == 0 ? f2 - (f / 2.0f) : this.a.n == 2 ? f2 - f : f2;
            } else {
                f = this.a.g + ((float) a.top);
                a = new Rect();
                this.n.getTextBounds(this.o, 0, this.o.length(), a);
                f2 = (float) a.height();
                if (this.a.n == 0) {
                    f += f2 / 2.0f;
                } else if (this.a.n == 2) {
                    f += f2;
                }
            }
        } else {
            f = this.a.g;
            if (this.a.n == 0) {
                if (this.a.b == 2 && this.l != null) {
                    f -= (((float) this.l.getHeight()) / com.vlocker.ui.widget.c.d.b) / 2.0f;
                } else if (this.i != null) {
                    f -= (((float) this.i.getHeight()) / com.vlocker.ui.widget.c.d.b) / 2.0f;
                }
            } else if (this.a.n == 2) {
                if (this.a.b == 2 && this.l != null) {
                    f -= ((float) this.l.getHeight()) / com.vlocker.ui.widget.c.d.b;
                } else if (this.i != null) {
                    f -= ((float) this.i.getHeight()) / com.vlocker.ui.widget.c.d.b;
                }
            }
        }
        return f > 0.0f ? f : 0.0f;
    }

    public void f() {
        a();
    }

    public void g() {
        if (this.a.j != null) {
            int i = this.b % 10;
            this.i = a(this.e.j + (this.b / 10));
            this.j = a(this.e.j + i);
        }
    }

    public void h() {
        if (this.a.j != null) {
            int i = this.g % 10;
            this.l = a(this.e.j + (this.g / 10));
            this.m = a(this.e.j + i);
            if (this.k == null) {
                this.k = a(this.e.j + "dot");
            }
        }
    }
}
