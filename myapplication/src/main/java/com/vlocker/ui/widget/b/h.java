package com.vlocker.ui.widget.b;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import com.vlocker.c.a;
import com.vlocker.locker.R;
import com.vlocker.m.ba;
import com.vlocker.ui.widget.a.d;
import com.vlocker.ui.widget.a.p;

public class h extends c {
    public static int c = -3;
    public static String g = "晴";
    public static int h = 0;
    Paint a = new Paint();
    String b = "-3°";
    int i = -1;
    p j;
    private a k;

    public h(Context context, d dVar) {
        super(context, dVar);
        this.k = a.a(context);
        this.j = (p) dVar;
        a();
    }

    private void b(Canvas canvas) {
        float f = 1.0f;
        this.a.reset();
        this.a.setAntiAlias(true);
        this.a.setTextSize(((float) this.j.x) * com.vlocker.ui.widget.c.d.b);
        if (this.j.B != null) {
            this.a.setTypeface(ba.a(this.d, this.j.B, true));
        } else if (this.j.H == 1) {
            this.a.setTypeface(Typeface.create(Typeface.DEFAULT, 1));
        } else if (this.j.H == 2) {
            this.a.setTypeface(Typeface.create(Typeface.DEFAULT, 2));
        }
        float d = d();
        float e = e();
        float measureText = this.a.measureText(this.b);
        if (this.j.m == 0) {
            d -= measureText / 2.0f;
        } else if (this.j.m == 2) {
            d -= measureText;
        }
        Rect rect = new Rect();
        this.a.getTextBounds(this.b, 0, this.b.length(), rect);
        measureText = (float) rect.height();
        if (this.j.n == 0) {
            e += measureText / 2.0f;
        } else if (this.j.n == 2) {
            e += measureText;
        }
        this.a.setColor(this.j.E);
        this.a.setAlpha(this.j.P);
        if (this.j.K == 1) {
            measureText = this.d.getResources().getDisplayMetrics().density / 1.5f;
            if (measureText > 1.0f) {
                f = 1.0f * measureText;
            }
            this.a.setShadowLayer(f, 0.0f, 0.0f, this.j.I);
        }
        if (this.j.Q != 0.0f) {
            f = d;
            for (int i = 0; i < this.b.length(); i++) {
                canvas.drawText(this.b.substring(i, i + 1), f, e, this.a);
                f += this.a.measureText(this.b.substring(i, i + 1)) + (this.j.Q * com.vlocker.ui.widget.c.d.b);
            }
            return;
        }
        canvas.drawText(this.b, d, e, this.a);
    }

    private void f() {
        if ("chinese".equals(this.j.a)) {
            if (this.k.H(g) != null) {
                this.b = this.k.H(g);
            } else {
                this.b = g;
            }
        } else if ("english".equals(this.j.a)) {
            this.b = a(this.k.L(-1));
        } else if (this.k.F(c + "") != null) {
            this.b = this.k.F(c + "") + "°";
        } else {
            this.b = c + "°";
        }
    }

    public String a(int i) {
        String str = "Sunny";
        switch (i) {
            case R.drawable.mx_weather_detail_kind_qing:
            case R.drawable.mx_weather_kind_detail_qingnight:
                return "Sunny";
            case R.drawable.mx_weather_detail_kind_shachenbao:
                return "Sandstorm";
            case R.drawable.mx_weather_detail_kind_wu:
                return "Fog";
            case R.drawable.mx_weather_kind_detail_daxue:
            case R.drawable.mx_weather_kind_detail_xiaoxue:
            case R.drawable.mx_weather_kind_detail_zhongxue:
                return "Snow";
            case R.drawable.mx_weather_kind_detail_dayu:
            case R.drawable.mx_weather_kind_detail_leizhenyu:
            case R.drawable.mx_weather_kind_detail_xiaoyu:
            case R.drawable.mx_weather_kind_detail_zhongyu:
                return "Rain";
            case R.drawable.mx_weather_kind_detail_mai:
                return "Haze";
            case R.drawable.mx_weather_kind_detail_yin:
                return "Overcast";
            case R.drawable.mx_weather_kind_detail_yujiaxue:
                return "Sleet";
            case R.drawable.mx_weather_kind_detail_yun:
            case R.drawable.mx_weather_kind_detail_yunnight:
                return "Cloudy";
            case R.drawable.mx_weather_kind_detail_zhenyu:
            case R.drawable.mx_weather_kind_detail_zhenyunight:
                return "Showers";
            default:
                return str;
        }
    }

    public void a() {
    }

    public void a(Canvas canvas) {
        if (this.k != null && this.k.W()) {
            f();
            b(canvas);
        }
    }

    public int b() {
        return 0;
    }

    public float c() {
        return 0.0f;
    }
}
