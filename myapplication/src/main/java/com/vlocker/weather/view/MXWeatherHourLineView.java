package com.vlocker.weather.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import com.vlocker.locker.R;
import com.vlocker.m.l;
import java.util.ArrayList;
import java.util.List;

public class MXWeatherHourLineView extends View {
    private float a;
    private float b;
    private float c;
    private float d;
    private float e;
    private List f;
    private float g;
    private float h;
    private Paint i;
    private Paint j;
    private Paint k;
    private Paint l;
    private Paint m;
    private Paint n;
    private boolean o;
    private float p;
    private float q;
    private float r;
    private int s;
    private int t;
    private int u;
    private int v;
    private List w;
    private MXWeatherHoursShow x;

    public MXWeatherHourLineView(Context context) {
        this(context, null);
    }

    public MXWeatherHourLineView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.t = 0;
        this.u = -1;
        this.v = -1;
        if (VERSION.SDK_INT >= 14) {
            setLayerType(1, null);
        }
        this.i = new Paint();
        this.l = new Paint();
        this.m = new Paint();
        this.n = new Paint();
        this.j = new Paint();
        this.k = new Paint();
        b();
    }

    private void a(Canvas canvas) {
        canvas.drawLine(0.0f, (float) getHeight(), (float) getWidth(), (float) getHeight(), this.j);
    }

    private void a(Canvas canvas, int i) {
        Paint paint = new Paint();
        paint.setColor(-1);
        paint.setTextSize((float) getResources().getDimensionPixelSize(R.dimen.t_market_big_textsize));
        paint.setTypeface(Typeface.SANS_SERIF);
        canvas.drawText("暂无数据", (this.a + (this.d / 2.0f)) - ((float) getResources().getDimensionPixelSize(R.dimen.weather_templineworry_pianyi)), (float) (((double) this.b) - (0.5d * ((double) this.e))), paint);
    }

    private void b() {
        this.i.setStyle(Style.STROKE);
        this.i.setStrokeWidth((float) getResources().getDimensionPixelSize(R.dimen.weather_templine_linewidth));
        this.i.setAntiAlias(true);
        this.i.setColor(-1);
        this.i.setStrokeJoin(Join.ROUND);
        this.j.setStyle(Style.STROKE);
        this.j.setStrokeWidth((float) getResources().getDimensionPixelSize(R.dimen.weather_templine_linewidth));
        this.j.setAntiAlias(true);
        this.j.setColor(1291845631);
        this.j.setStrokeJoin(Join.ROUND);
        this.k.setStyle(Style.STROKE);
        this.k.setStrokeWidth((float) getResources().getDimensionPixelSize(R.dimen.weather_templine_linewidth));
        this.k.setAntiAlias(true);
        this.k.setColor(436207615);
        this.k.setStrokeJoin(Join.ROUND);
        this.l.setStyle(Style.FILL);
        this.l.setAntiAlias(true);
        this.l.setStrokeWidth((float) getResources().getDimensionPixelSize(R.dimen.weather_templine_circler));
        this.l.setColor(-1);
        this.m.setAntiAlias(true);
        this.m.setColor(-1);
        this.m.setTextSize((float) getResources().getDimensionPixelSize(R.dimen.t_market_low_textsize));
        this.m.setTypeface(Typeface.SANS_SERIF);
        this.n.setAntiAlias(true);
        this.n.setColor(-1);
        this.n.setTextSize((float) getResources().getDimensionPixelSize(R.dimen.t_market_lowest_textsize));
        this.n.setTypeface(Typeface.SANS_SERIF);
        this.p = (float) getResources().getDimensionPixelSize(R.dimen.weather_templine_textup);
        this.q = (float) getResources().getDimensionPixelSize(R.dimen.weather_templine_textriglef);
        this.r = (float) getResources().getDimensionPixelSize(R.dimen.weather_templine_circler);
        this.s = getResources().getDimensionPixelSize(R.dimen.weather_templine_paadingupdown);
        setPadding(0, 0, 0, 0);
        this.o = false;
        this.f = new ArrayList();
    }

    private void b(Canvas canvas, int i) {
        canvas.drawCircle(this.a + (this.d / 2.0f), (float) (((double) this.b) - (0.75d * ((double) this.e))), this.r, this.l);
        canvas.drawCircle(this.a + (this.d / 2.0f), (float) (((double) this.b) - (0.25d * ((double) this.e))), this.r, this.l);
    }

    private void c(Canvas canvas, int i) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.setLength(0);
        stringBuffer.append(Math.round(((Float) this.f.get(0)).floatValue())).append("°");
        canvas.drawText(stringBuffer.toString(), (this.a + (this.d / 2.0f)) - this.q, ((float) (((double) this.b) - (0.75d * ((double) this.e)))) - this.p, this.m);
    }

    private void d(Canvas canvas, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 < this.t) {
                this.l.setColor(1291845631);
            }
            canvas.drawCircle((((float) i2) * this.c) + this.a, this.b - (((((Float) this.f.get(i2)).floatValue() - this.g) * this.e) / this.h), this.r, this.l);
            this.l.setColor(-1);
        }
    }

    private void e(Canvas canvas, int i) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 < this.t) {
                this.m.setColor(1409286143);
            }
            stringBuffer.setLength(0);
            stringBuffer.append(Math.round(((Float) this.f.get(i2)).floatValue())).append("°");
            canvas.drawText(stringBuffer.toString(), (this.a + (((float) i2) * this.c)) - this.q, (this.b - (((((Float) this.f.get(i2)).floatValue() - this.g) * this.e) / this.h)) - this.p, this.m);
            this.m.setColor(-1);
        }
    }

    private void f(Canvas canvas, int i) {
        Canvas canvas2;
        int i2 = 0;
        int i3 = -1;
        while (i2 < i - 1) {
            int i4;
            if (((Integer) this.w.get(i2)).intValue() != i3 || i2 == this.t) {
                Bitmap decodeResource;
                int i5;
                if (i2 < this.t) {
                    this.n.setColor(1409286143);
                }
                int i6 = i - 1;
                int i7 = i2 + 1;
                while (i7 < i) {
                    if (i7 == this.t || ((Integer) this.w.get(i7)).intValue() != ((Integer) this.w.get(i2)).intValue()) {
                        i4 = i7;
                        break;
                    }
                    i7++;
                }
                i4 = i6;
                float f = (((float) (i4 - i2)) * this.c) / 2.0f;
                int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.weather_temppic_width);
                int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.weather_temppic_height);
                if (i2 == this.u) {
                    decodeResource = BitmapFactory.decodeResource(getResources(), R.drawable.weather_sunrize_detail);
                    i5 = i3;
                } else if (i2 == this.v) {
                    decodeResource = BitmapFactory.decodeResource(getResources(), R.drawable.weather_sunset_detail);
                    i5 = i3;
                } else {
                    Bitmap decodeResource2 = BitmapFactory.decodeResource(getResources(), ((Integer) this.w.get(i2)).intValue());
                    decodeResource = decodeResource2;
                    i5 = ((Integer) this.w.get(i2)).intValue();
                }
                if (decodeResource != null) {
                    canvas.drawBitmap(Bitmap.createScaledBitmap(decodeResource, dimensionPixelSize, dimensionPixelSize2, true), ((this.a + (((float) i2) * this.c)) + f) - ((float) (dimensionPixelSize / 2)), (((float) getHeight()) - this.p) - ((float) dimensionPixelSize2), this.n);
                    if (i2 < this.t) {
                        canvas2 = canvas;
                        canvas2.drawLine((((float) i2) * this.c) + this.a, this.b - (((((Float) this.f.get(i2)).floatValue() - this.g) * this.e) / this.h), (((float) i2) * this.c) + this.a, (float) getHeight(), this.k);
                    } else {
                        canvas2 = canvas;
                        canvas2.drawLine((((float) i2) * this.c) + this.a, this.b - (((((Float) this.f.get(i2)).floatValue() - this.g) * this.e) / this.h), (((float) i2) * this.c) + this.a, (float) getHeight(), this.j);
                    }
                }
                this.n.setColor(-1);
                i4 = i5;
            } else {
                i4 = i3;
            }
            i2++;
            i3 = i4;
        }
        canvas2 = canvas;
        canvas2.drawLine((((float) (i - 1)) * this.c) + this.a, this.b - (((((Float) this.f.get(i - 1)).floatValue() - this.g) * this.e) / this.h), (((float) (i - 1)) * this.c) + this.a, (float) getHeight(), this.j);
    }

    private void g(Canvas canvas, int i) {
        Path path = new Path();
        Path path2 = new Path();
        List arrayList = new ArrayList();
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(new e(this, (((float) i2) * this.c) + this.a, this.b - (((((Float) this.f.get(i2)).floatValue() - this.g) * this.e) / this.h)));
        }
        b(arrayList, path);
        canvas.drawPath(path, this.j);
        a(arrayList, path2);
        canvas.drawPath(path2, this.i);
    }

    public void a() {
        invalidate();
    }

    public void a(List list, Path path) {
        int size = list.size();
        if (size >= 2) {
            path.reset();
            path.moveTo(((e) list.get(this.t)).a, ((e) list.get(this.t)).b);
            for (int i = this.t + 1; i < size; i++) {
                e eVar = (e) list.get(i);
                path.lineTo(eVar.a, eVar.b);
            }
        }
    }

    public void b(List list, Path path) {
        if (list.size() >= 2) {
            path.reset();
            path.moveTo(((e) list.get(0)).a, ((e) list.get(0)).b);
            for (int i = 1; i <= this.t; i++) {
                e eVar = (e) list.get(i);
                path.lineTo(eVar.a, eVar.b);
            }
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.o) {
            int size = this.f.size();
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.weather_temppic_height);
            int b = l.b(12.0f);
            this.e = ((float) (((((getHeight() - getPaddingTop()) - getPaddingBottom()) - b) - dimensionPixelSize) - (l.a(4.0f) * 2))) - (3.0f * this.p);
            this.d = (float) ((getWidth() - getPaddingLeft()) - getPaddingRight());
            this.a = (float) getPaddingLeft();
            this.b = ((this.e + ((float) getPaddingTop())) + ((float) b)) + this.p;
            if (size == 0) {
                a(canvas, size);
            }
            if (size == 1) {
                c(canvas, size);
                b(canvas, size);
            }
            if (size > 1) {
                this.c = this.d / ((float) size);
                this.a += this.c / 2.0f;
                this.d -= this.c;
                g(canvas, size);
                e(canvas, size);
                f(canvas, size);
                d(canvas, size);
                if (this.x != null) {
                    this.x.a();
                }
            }
            a(canvas);
        }
    }

    public void setDrawLine(boolean z) {
        this.o = z;
    }

    public void setImgColor(int i) {
        this.n.setColor(i);
    }

    public void setLineColor(int i) {
        this.i.setColor(i);
    }

    public void setLinewidth(float f) {
        this.i.setStrokeWidth(f);
    }

    public void setNowIndex(int i) {
        this.t = i;
    }

    public void setOldLineColor(int i) {
        this.j.setColor(i);
    }

    public void setPointColor(int i) {
        this.l.setColor(i);
    }

    public void setRiseIndex(int i) {
        this.u = i;
    }

    public void setRootView(MXWeatherHoursShow mXWeatherHoursShow) {
        this.x = mXWeatherHoursShow;
    }

    public void setSetIndex(int i) {
        this.v = i;
    }

    public void setTemps(List list) {
        this.f = list;
        int size = list.size();
        if (size != 0) {
            float floatValue = ((Float) list.get(0)).floatValue();
            this.g = ((Float) list.get(0)).floatValue();
            float f = floatValue;
            for (int i = 1; i < size; i++) {
                f = Math.max(f, ((Float) list.get(i)).floatValue());
                this.g = Math.min(this.g, ((Float) list.get(i)).floatValue());
            }
            this.h = f - this.g;
        }
    }

    public void setTextColor(int i) {
        this.m.setColor(i);
    }

    public void setimages(List list) {
        this.w = list;
    }
}
