package com.vlocker.weather.view;

import android.content.Context;
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
import java.util.ArrayList;
import java.util.List;

public class MXWeatherTempLineView extends View {
    private int a;
    private int b;
    private int c;
    private int d;
    private int e;
    private List f;
    private List g;
    private int h;
    private float i;
    private float j;
    private Paint k;
    private Paint l;
    private Paint m;
    private Paint n;
    private boolean o;
    private float p;
    private float q;
    private float r;
    private float s;
    private int t;
    private int u;
    private boolean v = false;
    private int w = -1;

    public MXWeatherTempLineView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (VERSION.SDK_INT >= 14) {
            setLayerType(1, null);
        }
        this.k = new Paint();
        this.l = new Paint();
        this.n = new Paint();
        this.m = new Paint();
        a();
    }

    private void a() {
        this.k.setStyle(Style.STROKE);
        this.k.setStrokeWidth((float) getResources().getDimensionPixelSize(R.dimen.weather_templine_linewidth));
        this.k.setAntiAlias(true);
        this.k.setColor(-1);
        this.k.setStrokeJoin(Join.ROUND);
        this.m.setStyle(Style.STROKE);
        this.m.setStrokeWidth((float) getResources().getDimensionPixelSize(R.dimen.weather_templine_linewidth));
        this.m.setAntiAlias(true);
        this.m.setColor(1409286143);
        this.m.setStrokeJoin(Join.ROUND);
        this.l.setStyle(Style.FILL);
        this.l.setAntiAlias(true);
        this.l.setStrokeWidth((float) getResources().getDimensionPixelSize(R.dimen.weather_templine_circler));
        this.l.setColor(-1);
        this.n.setAntiAlias(true);
        this.n.setColor(-2080374785);
        this.n.setTextSize((float) getResources().getDimensionPixelSize(R.dimen.t_market_lowest_textsize));
        this.n.setTypeface(Typeface.SANS_SERIF);
        this.p = (float) getResources().getDimensionPixelSize(R.dimen.weather_templine_textup);
        this.q = (float) getResources().getDimensionPixelSize(R.dimen.weather_templine_textdown);
        this.r = (float) getResources().getDimensionPixelSize(R.dimen.weather_templine_textriglef);
        this.s = (float) getResources().getDimensionPixelSize(R.dimen.weather_templine_circler);
        this.t = getResources().getDimensionPixelSize(R.dimen.weather_templine_paddingleftright);
        this.u = getResources().getDimensionPixelSize(R.dimen.weather_templine_paadingupdown);
        setPadding(0, this.u, 0, this.u);
        this.o = false;
        this.f = new ArrayList();
        this.g = new ArrayList();
    }

    private void a(Canvas canvas, int i) {
        Paint paint = new Paint();
        paint.setColor(-1);
        paint.setTextSize((float) getResources().getDimensionPixelSize(R.dimen.t_market_big_textsize));
        paint.setTypeface(Typeface.SANS_SERIF);
        canvas.drawText("暂无数据", (float) ((this.a + (this.d / 2)) - getResources().getDimensionPixelSize(R.dimen.weather_templineworry_pianyi)), (float) (((double) this.b) - (0.5d * ((double) this.e))), paint);
    }

    private void b(Canvas canvas, int i) {
        canvas.drawCircle((float) (this.a + (this.d / 2)), (float) (((double) this.b) - (0.75d * ((double) this.e))), this.s, this.l);
        canvas.drawCircle((float) (this.a + (this.d / 2)), (float) (((double) this.b) - (0.25d * ((double) this.e))), this.s, this.l);
    }

    private void c(Canvas canvas, int i) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.setLength(0);
        stringBuffer.append(Math.round(((Float) this.f.get(0)).floatValue())).append("℃");
        canvas.drawText(stringBuffer.toString(), ((float) (this.a + (this.d / 2))) - this.r, ((float) (((double) this.b) - (0.75d * ((double) this.e)))) - this.p, this.n);
        stringBuffer.setLength(0);
        stringBuffer.append(Math.round(((Float) this.g.get(0)).floatValue())).append("℃");
        canvas.drawText(stringBuffer.toString(), ((float) (this.a + (this.d / 2))) - this.r, ((float) (((double) this.b) - (0.25d * ((double) this.e)))) + this.q, this.n);
    }

    private void d(Canvas canvas, int i) {
        int i2 = 0;
        while (i2 < i) {
            if (this.v && this.w == 0 && i2 == 0) {
                this.l.setColor(1409286143);
            }
            canvas.drawCircle((float) (this.a + (this.c * i2)), ((float) this.b) - (((((Float) this.f.get(i2)).floatValue() - this.i) * ((float) this.e)) / this.j), this.s, this.l);
            canvas.drawCircle((float) (this.a + (this.c * i2)), ((float) this.b) - (((((Float) this.g.get(i2)).floatValue() - this.i) * ((float) this.e)) / this.j), this.s, this.l);
            this.l.setColor(-1);
            i2++;
        }
    }

    private void e(Canvas canvas, int i) {
        StringBuffer stringBuffer = new StringBuffer();
        int i2 = 0;
        while (i2 < i) {
            if (this.v && this.w == 0 && i2 == 0) {
                this.n.setColor(1409286143);
            }
            stringBuffer.setLength(0);
            stringBuffer.append(Math.round(((Float) this.f.get(i2)).floatValue())).append("℃");
            canvas.drawText(stringBuffer.toString(), ((float) (this.a + (this.c * i2))) - this.r, (((float) this.b) - (((((Float) this.f.get(i2)).floatValue() - this.i) * ((float) this.e)) / this.j)) - this.p, this.n);
            stringBuffer.setLength(0);
            stringBuffer.append(Math.round(((Float) this.g.get(i2)).floatValue())).append("℃");
            canvas.drawText(stringBuffer.toString(), ((float) (this.a + (this.c * i2))) - this.r, (((float) this.b) - (((((Float) this.g.get(i2)).floatValue() - this.i) * ((float) this.e)) / this.j)) + this.q, this.n);
            this.n.setColor(-2080374785);
            i2++;
        }
    }

    private void f(Canvas canvas, int i) {
        int i2 = 0;
        Path path = new Path();
        Path path2 = new Path();
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        arrayList.add(new f(this, (float) (this.a - this.c), ((float) this.b) - (((((Float) this.f.get(0)).floatValue() - this.i) * ((float) this.e)) / this.j)));
        arrayList2.add(new f(this, (float) (this.a - this.c), ((float) this.b) - (((((Float) this.g.get(0)).floatValue() - this.i) * ((float) this.e)) / this.j)));
        while (i2 < i) {
            arrayList.add(new f(this, (float) (this.a + (this.c * i2)), ((float) this.b) - (((((Float) this.f.get(i2)).floatValue() - this.i) * ((float) this.e)) / this.j)));
            arrayList2.add(new f(this, (float) (this.a + (this.c * i2)), ((float) this.b) - (((((Float) this.g.get(i2)).floatValue() - this.i) * ((float) this.e)) / this.j)));
            i2++;
        }
        arrayList.add(new f(this, (float) (this.a + ((i - 1) * this.c)), ((float) this.b) - (((((Float) this.f.get(i - 1)).floatValue() - this.i) * ((float) this.e)) / this.j)));
        arrayList2.add(new f(this, (float) (this.a + ((i - 1) * this.c)), ((float) this.b) - (((((Float) this.g.get(i - 1)).floatValue() - this.i) * ((float) this.e)) / this.j)));
        a(arrayList, 50, path);
        a(arrayList2, 50, path2);
        canvas.drawPath(path, this.k);
        canvas.drawPath(path2, this.k);
        if (this.v && this.w == 0) {
            Path path3 = new Path();
            Path path4 = new Path();
            a(arrayList, 50, path3, 2);
            a(arrayList2, 50, path4, 2);
            canvas.drawPath(path3, this.m);
            canvas.drawPath(path4, this.m);
        }
    }

    public void a(List list, int i, Path path) {
        int size = list.size();
        if (size >= 4) {
            path.reset();
            path.moveTo(((f) list.get(1)).a, ((f) list.get(1)).b);
            if (this.v && this.w == 0) {
                path.moveTo(((f) list.get(2)).a, ((f) list.get(2)).b);
            }
            int i2 = 1;
            while (i2 < size - 2) {
                if (!this.v || this.w != 0 || i2 != 1) {
                    f fVar = (f) list.get(i2 - 1);
                    f fVar2 = (f) list.get(i2);
                    f fVar3 = (f) list.get(i2 + 1);
                    f fVar4 = (f) list.get(i2 + 2);
                    for (int i3 = 1; i3 <= i; i3++) {
                        float f = ((float) i3) * (1.0f / ((float) i));
                        float f2 = f * f;
                        float f3 = f2 * f;
                        f fVar5 = new f(this);
                        fVar5.a = (((((((-f3) + (2.0f * f2)) - f) * fVar.a) + ((((3.0f * f3) - (5.0f * f2)) + 2.0f) * fVar2.a)) + ((((-3.0f * f3) + (4.0f * f2)) + f) * fVar3.a)) + ((f3 - f2) * fVar4.a)) / 2.0f;
                        fVar5.b = ((((f + ((-3.0f * f3) + (4.0f * f2))) * fVar3.b) + (((((-f3) + (2.0f * f2)) - f) * fVar.b) + ((((3.0f * f3) - (5.0f * f2)) + 2.0f) * fVar2.b))) + ((f3 - f2) * fVar4.b)) / 2.0f;
                        path.lineTo(fVar5.a, fVar5.b);
                    }
                }
                i2++;
            }
            Path path2 = path;
            path2.lineTo(((f) list.get(list.size() - 1)).a, ((f) list.get(list.size() - 1)).b);
        }
    }

    public void a(List list, int i, Path path, int i2) {
        if (list.size() >= 4) {
            path.reset();
            path.moveTo(((f) list.get(1)).a, ((f) list.get(1)).b);
            for (int i3 = 1; i3 < i2; i3++) {
                f fVar = (f) list.get(i3 - 1);
                f fVar2 = (f) list.get(i3);
                f fVar3 = (f) list.get(i3 + 1);
                f fVar4 = (f) list.get(i3 + 2);
                for (int i4 = 1; i4 <= i; i4++) {
                    float f = ((float) i4) * (1.0f / ((float) i));
                    float f2 = f * f;
                    float f3 = f2 * f;
                    f fVar5 = new f(this);
                    fVar5.a = (((((((-f3) + (2.0f * f2)) - f) * fVar.a) + ((((3.0f * f3) - (5.0f * f2)) + 2.0f) * fVar2.a)) + ((((-3.0f * f3) + (4.0f * f2)) + f) * fVar3.a)) + ((f3 - f2) * fVar4.a)) / 2.0f;
                    fVar5.b = ((((f + ((-3.0f * f3) + (4.0f * f2))) * fVar3.b) + (((((-f3) + (2.0f * f2)) - f) * fVar.b) + ((((3.0f * f3) - (5.0f * f2)) + 2.0f) * fVar2.b))) + ((f3 - f2) * fVar4.b)) / 2.0f;
                    path.lineTo(fVar5.a, fVar5.b);
                }
            }
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.o) {
            this.e = (getHeight() - getPaddingTop()) - getPaddingBottom();
            this.d = (getWidth() - getPaddingLeft()) - getPaddingRight();
            this.a = getPaddingLeft();
            this.b = this.e + getPaddingTop();
            int size = this.f.size();
            if (size >= 0) {
                if (this.h <= size) {
                    size = this.h;
                }
                if (size == 0) {
                    a(canvas, size);
                }
                if (size > 1) {
                    this.c = this.d / size;
                    this.a += this.c / 2;
                    this.d -= this.c;
                }
                if (size > 1) {
                    e(canvas, size);
                    d(canvas, size);
                    f(canvas, size);
                }
                if (size == 1) {
                    c(canvas, size);
                    b(canvas, size);
                }
            }
        }
    }

    public void setDataNumber(int i) {
        this.h = i;
    }

    public void setDay(int i) {
        this.w = i;
    }

    public void setDrawLine(boolean z) {
        this.o = z;
    }

    public void setLineColor(int i) {
        this.k.setColor(i);
    }

    public void setLinewidth(float f) {
        this.k.setStrokeWidth(f);
    }

    public void setOldLineColor(int i) {
        this.m.setColor(i);
    }

    public void setPointColor(int i) {
        this.l.setColor(i);
    }

    public void setTextColor(int i) {
        this.n.setColor(i);
    }

    public void setYestoday(boolean z) {
        this.v = z;
    }
}
