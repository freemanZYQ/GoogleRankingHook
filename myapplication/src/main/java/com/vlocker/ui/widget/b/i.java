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
import android.text.TextUtils;
import com.vlocker.c.a;
import com.vlocker.locker.R;
import com.vlocker.m.ay;
import com.vlocker.m.ba;
import com.vlocker.ui.widget.a.d;
import com.vlocker.ui.widget.a.q;
import java.util.Calendar;

public class i extends c {
    private static final String[] h = new String[]{"日", "一", "二", "三", "四", "五", "六"};
    private static final String[] i = new String[]{"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
    private static final String[] j = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    private static final String[] k = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    private static final String[] l = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    TextPaint a = new TextPaint();
    Paint b = new Paint();
    String c = ":";
    q g;
    private a m;

    public i(Context context, d dVar) {
        super(context, dVar);
        this.g = (q) dVar;
        this.m = a.a(context);
    }

    private String a(int i) {
        String str = "Sunny";
        switch (i) {
            case R.drawable.mx_weather_detail_kind_qing:
            case R.drawable.mx_weather_kind_detail_qingnight:
                return "Sunny";
            case R.drawable.mx_weather_detail_kind_shachenbao:
                return "Dust storm";
            case R.drawable.mx_weather_detail_kind_wu:
                return "Fog";
            case R.drawable.mx_weather_kind_detail_daxue:
                return "Heavy snow";
            case R.drawable.mx_weather_kind_detail_dayu:
                return "Heavy rain";
            case R.drawable.mx_weather_kind_detail_leizhenyu:
                return "Thunderstorm";
            case R.drawable.mx_weather_kind_detail_mai:
                return "Haze";
            case R.drawable.mx_weather_kind_detail_xiaoxue:
                return "Light snow";
            case R.drawable.mx_weather_kind_detail_xiaoyu:
                return "Light rain";
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
            case R.drawable.mx_weather_kind_detail_zhongxue:
                return "Moderate snow";
            case R.drawable.mx_weather_kind_detail_zhongyu:
                return "Moderate rain";
            default:
                return str;
        }
    }

    private String a(String str, String str2) {
        if (!(TextUtils.isEmpty(str) || TextUtils.isEmpty(str2))) {
            if ("year".equals(str)) {
                return b(str2);
            }
            if ("month".equals(str)) {
                return c(str2);
            }
            if ("day".equals(str)) {
                return d(str2);
            }
            if ("week".equals(str)) {
                return f(str2);
            }
            if ("temp".equals(str)) {
                return e(str2);
            }
        }
        return this.g.A;
    }

    private void a(Paint paint) {
        float f = 1.0f;
        paint.reset();
        paint.setAntiAlias(true);
        paint.setTextSize(((float) this.g.x) * com.vlocker.ui.widget.c.d.b);
        paint.setColor(this.g.E);
        paint.setAlpha(this.g.P);
        if (this.g.K == 1) {
            float f2 = this.d.getResources().getDisplayMetrics().density / 1.5f;
            if (f2 > 1.0f) {
                f = 1.0f * f2;
            }
            paint.setShadowLayer(f, 0.0f, 0.0f, this.g.I);
        }
        if (this.g.B != null) {
            paint.setTypeface(ba.a(this.d, this.g.B, true));
        } else if (this.g.H == 1) {
            paint.setTypeface(Typeface.create(Typeface.DEFAULT, 1));
        } else if (this.g.H == 2) {
            paint.setTypeface(Typeface.create(Typeface.DEFAULT, 2));
        }
    }

    private String b(String str) {
        int i = Calendar.getInstance().get(1);
        return "number".equals(str) ? i + "" : "chinese".equals(str) ? ay.a(i, 3) : "nongli".equals(str) ? ay.a() : i + "";
    }

    private void b(Canvas canvas) {
        float d = d();
        float e = e();
        float measureText = this.b.measureText(this.c);
        if (this.g.m == 0) {
            d -= measureText / 2.0f;
        } else if (this.g.m == 2) {
            d -= measureText;
        }
        Rect rect = new Rect();
        this.b.getTextBounds(this.c, 0, this.c.length(), rect);
        measureText = (float) rect.height();
        if (this.g.n == 0) {
            e += measureText / 2.0f;
        } else if (this.g.n == 2) {
            e += measureText;
        }
        if (this.g.Q != 0.0f) {
            float f = d;
            for (int i = 0; i < this.c.length(); i++) {
                canvas.drawText(this.c.substring(i, i + 1), f, e, this.b);
                f += this.b.measureText(this.c.substring(i, i + 1)) + (this.g.Q * com.vlocker.ui.widget.c.d.b);
            }
            return;
        }
        canvas.drawText(this.c, d, e, this.b);
    }

    private String c(String str) {
        int i = Calendar.getInstance().get(2) + 1;
        return "number".equals(str) ? i + "" : "Jan".equals(str) ? k[i - 1] : "JAN".equals(str) ? k[i - 1].toUpperCase() : "JANUARY".equals(str) ? l[i - 1].toUpperCase() : "January".equals(str) ? l[i - 1] : "chinese".equals(str) ? ay.a(i, 1) : "nongli".equals(str) ? ay.b() : i + "";
    }

    private void c(Canvas canvas) {
        float d = d();
        float e = e();
        FontMetrics fontMetrics = this.a.getFontMetrics();
        float length = (fontMetrics.descent - fontMetrics.ascent) * ((float) this.c.length());
        float f = this.g.n == 0 ? e - (length / 2.0f) : this.g.n == 2 ? e - length : e;
        StaticLayout staticLayout = new StaticLayout(this.c, this.a, (int) this.a.measureText(" "), Alignment.ALIGN_NORMAL, 1.0f, this.g.Q, true);
        canvas.save();
        canvas.translate(d, f);
        staticLayout.draw(canvas);
        canvas.restore();
    }

    private String d(String str) {
        int i = Calendar.getInstance().get(5);
        return "number".equals(str) ? i + "" : "chinese".equals(str) ? ay.a(i, 1) : "nongli".equals(str) ? ay.c() : i + "";
    }

    private String e(String str) {
        return "number".equals(str) ? this.m.F("-3") + "°" : "chinese".equals(str) ? this.m.H("晴") : "english".equals(str) ? a(this.m.L(-1)) : "";
    }

    private String f(String str) {
        int i = Calendar.getInstance().get(4);
        return "Sun".equals(str) ? i[i - 1] : "SUN".equals(str) ? i[i - 1].toUpperCase() : "Sunday".equals(str) ? j[i - 1] : "SUNDAY".equals(str) ? j[i - 1].toUpperCase() : "zhou".equals(str) ? "周" + h[i - 1] : "xingqi".equals(str) ? "星期" + h[i - 1] : "libai".equals(str) ? "礼拜" + h[i - 1] : i[i - 1];
    }

    public Rect a(boolean z) {
        this.b.setTextSize(z ? ((float) this.g.x) * com.vlocker.ui.widget.c.d.b : (float) this.g.x);
        if (this.g.B != null) {
            this.b.setTypeface(ba.a(this.d, this.g.B, true));
        } else if (this.g.H == 1) {
            this.b.setTypeface(Typeface.create(Typeface.DEFAULT, 1));
        } else if (this.g.H == 2) {
            this.b.setTypeface(Typeface.create(Typeface.DEFAULT, 2));
        }
        Rect rect = new Rect();
        this.b.getTextBounds(this.c, 0, this.c.length(), rect);
        return rect;
    }

    public void a() {
    }

    public void a(Canvas canvas) {
        this.c = a(this.g.N, this.g.M);
        if (!TextUtils.isEmpty(this.c)) {
            if (this.g.O) {
                a(this.a);
                c(canvas);
                return;
            }
            a(this.b);
            b(canvas);
        }
    }

    public int b() {
        float e = e();
        Rect rect = new Rect();
        this.b.getTextBounds(this.c, 0, this.c.length(), rect);
        float height = (float) rect.height();
        if (this.g.n == 0) {
            e += height / 2.0f;
        } else if (this.g.n == 2) {
            e += height;
        }
        return (int) (e + ((float) a(true).bottom));
    }

    public float c() {
        return this.g.g + ((float) a(false).top);
    }
}
