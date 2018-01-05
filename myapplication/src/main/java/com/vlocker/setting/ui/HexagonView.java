package com.vlocker.setting.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.CornerPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.SweepGradient;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.vlocker.locker.R;
import com.vlocker.setting.h;
import java.util.ArrayList;
import java.util.List;

public class HexagonView extends View {
    private boolean A = true;
    private boolean B;
    private boolean C;
    private boolean D;
    private float E;
    private z F;
    private float G;
    private float a;
    private float b;
    private boolean c;
    private boolean d;
    private Paint e;
    private Matrix f;
    private SweepGradient g;
    private float h = 270.0f;
    private float i;
    private ValueAnimator j;
    private ValueAnimator k;
    private ValueAnimator l;
    private float m;
    private float n;
    private float o;
    private float p;
    private float q;
    private Paint r;
    private float s;
    private float t;
    private float u;
    private double v = 0.5235987755982988d;
    private Handler w = new Handler();
    private h x;
    private Path y;
    private List z = new ArrayList();

    public HexagonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        d();
        this.k = e();
        this.l = e();
        this.k.addUpdateListener(new aa(this));
        this.l.addUpdateListener(new ab(this));
        this.l.addListener(new ac(this));
        this.m = getResources().getDimension(R.dimen.hexagon_radius);
        this.n = getResources().getDimension(R.dimen.hexagon_radius_max);
        this.o = getResources().getDimension(R.dimen.hexagon_radius_finish);
        this.t = getResources().getDimension(R.dimen.hexagon_stroke_width_max);
        this.s = getResources().getDimension(R.dimen.hexagon_stroke_width_min);
        this.u = getResources().getDimension(R.dimen.hexagon_stroke_width_finish);
    }

    private Path a(float f) {
        float sin = (float) (((double) f) * Math.sin(this.v));
        float cos = (float) (((double) f) * Math.cos(this.v));
        Path path = new Path();
        path.moveTo(this.a, this.b - (2.0f * sin));
        path.lineTo(this.a + cos, this.b - sin);
        path.lineTo(this.a + cos, this.b + sin);
        path.lineTo(this.a, this.b + (2.0f * sin));
        path.lineTo(this.a - cos, this.b + sin);
        path.lineTo(this.a - cos, this.b - sin);
        path.close();
        return path;
    }

    private List a(float f, float f2) {
        List arrayList = new ArrayList();
        for (int i = 0; i < 6; i++) {
            float f3 = this.G + (0.2f * ((float) i));
            if (f3 <= f || f3 >= f2) {
                break;
            }
            arrayList.add(d(f3));
        }
        return arrayList;
    }

    private void a(Canvas canvas, float f, Paint paint) {
        float f2 = (this.n * f) + this.m;
        float f3 = f <= 0.3f ? (f / 0.3f) * 0.4f : this.B ? ((1.0f - ((f - 0.3f) / 0.7f)) * 0.2f) + 0.2f : (1.0f - ((f - 0.3f) / 0.7f)) * 0.4f;
        this.r.setAlpha((int) (f3 * 255.0f));
        this.r.setStrokeWidth(this.t - ((this.t - this.s) * f));
        c(canvas, f2, this.r);
    }

    private void a(Canvas canvas, Paint paint) {
        if (this.y == null) {
            this.z = b(this.m);
            this.y = a(this.m);
        }
        paint.setAlpha(255);
        paint.setStrokeWidth(this.t);
        canvas.drawPath(this.y, paint);
    }

    private List b(float f) {
        float sin = (float) (((double) f) * Math.sin(this.v));
        float cos = (float) (((double) f) * Math.cos(this.v));
        z zVar = new z(this.a, this.b - (2.0f * sin));
        z zVar2 = new z(this.a + cos, this.b - sin);
        z zVar3 = new z(this.a + cos, this.b + sin);
        z zVar4 = new z(this.a, this.b + (2.0f * sin));
        z zVar5 = new z(this.a - cos, this.b + sin);
        z zVar6 = new z(this.a - cos, this.b - sin);
        List arrayList = new ArrayList();
        arrayList.add(zVar);
        arrayList.add(zVar2);
        arrayList.add(zVar3);
        arrayList.add(zVar4);
        arrayList.add(zVar5);
        arrayList.add(zVar6);
        return arrayList;
    }

    private void b(Canvas canvas, float f, Paint paint) {
        float f2 = (this.o * f) + this.m;
        this.r.setAlpha((int) ((f <= 0.46153846f ? (f / 0.46153846f) * 0.4f : ((1.0f - ((f - 0.46153846f) / (1.0f - 0.46153846f))) * 0.1f) + 0.3f) * 255.0f));
        this.r.setStrokeWidth(this.t - ((this.t - this.u) * f));
        c(canvas, f2, this.r);
    }

    private void b(boolean z) {
        this.B = z;
        this.k.cancel();
        this.p = 0.0f;
        this.k.start();
        this.l.cancel();
        this.q = 0.0f;
        this.l.setStartDelay(350);
        this.l.setDuration(z ? 650 : 1000);
        this.l.start();
        if (z && this.x != null) {
            this.x.a();
        }
    }

    private float c(float f) {
        return f <= 0.2f ? 0.2f : f <= 0.4f ? 0.4f : f <= 0.6f ? 0.6f : f <= 0.8f ? 0.8f : f <= 1.0f ? 1.0f : 1.2f;
    }

    private void c() {
        this.d = true;
        this.e = new Paint();
        this.e.setAntiAlias(true);
        this.e.setStrokeWidth(this.t);
        this.e.setStyle(Style.STROKE);
        this.e.setColor(-1);
        this.e.setStrokeCap(Cap.ROUND);
        this.a = (float) (getWidth() / 2);
        this.b = (float) (getHeight() / 2);
        this.g = new SweepGradient(this.a, this.b, new int[]{0, -1}, null);
        this.f = new Matrix();
        this.f.setRotate(this.h, this.a, this.b);
        this.g.setLocalMatrix(this.f);
        PathEffect cornerPathEffect = new CornerPathEffect(5.0f);
        this.e.setPathEffect(cornerPathEffect);
        this.e.setShader(this.g);
        this.r = new Paint();
        this.r.setAntiAlias(true);
        this.r.setStrokeWidth(this.t);
        this.r.setStyle(Style.STROKE);
        this.r.setColor(-1);
        this.r.setPathEffect(cornerPathEffect);
        this.r.setStrokeCap(Cap.ROUND);
    }

    private void c(Canvas canvas, float f, Paint paint) {
        canvas.drawPath(a(f), paint);
    }

    private z d(float f) {
        z zVar;
        z zVar2;
        float f2;
        if (this.z.size() == 0) {
            this.z = b(this.m);
        }
        float f3 = f > 1.2f ? f - 1.2f : f;
        float f4;
        if (f3 <= 0.2f) {
            zVar = (z) this.z.get(1);
            f4 = f3;
            zVar2 = (z) this.z.get(0);
            f2 = f4;
        } else if (f3 <= 0.4f) {
            zVar = (z) this.z.get(2);
            f4 = f3 - 0.2f;
            zVar2 = (z) this.z.get(1);
            f2 = f4;
        } else if (f3 <= 0.6f) {
            zVar = (z) this.z.get(3);
            f4 = f3 - 0.4f;
            zVar2 = (z) this.z.get(2);
            f2 = f4;
        } else if (f3 <= 0.8f) {
            zVar = (z) this.z.get(4);
            f4 = f3 - 0.6f;
            zVar2 = (z) this.z.get(3);
            f2 = f4;
        } else if (f3 <= 1.0f) {
            zVar = (z) this.z.get(5);
            f4 = f3 - 0.8f;
            zVar2 = (z) this.z.get(4);
            f2 = f4;
        } else {
            zVar = (z) this.z.get(0);
            f4 = f3 - 1.0f;
            zVar2 = (z) this.z.get(5);
            f2 = f4;
        }
        f2 /= 0.2f;
        return new z(zVar2.a + ((zVar.a - zVar2.a) * f2), (f2 * (zVar.b - zVar2.b)) + zVar2.b);
    }

    private void d() {
        this.j = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.j.setDuration(2700);
        this.j.addUpdateListener(new ad(this));
        this.j.setRepeatCount(-1);
        this.j.addListener(new ae(this));
        this.j.setInterpolator(new LinearInterpolator());
    }

    private void d(Canvas canvas, float f, Paint paint) {
        if (this.F == null) {
            this.F = (z) this.z.get(0);
        }
        Path path = new Path();
        path.moveTo(this.F.a, this.F.b);
        for (z zVar : a(this.i, f)) {
            path.lineTo(zVar.a, zVar.b);
        }
        z zVar2 = d(this.E);
        path.lineTo(zVar2.a, zVar2.b);
        canvas.drawPath(path, paint);
    }

    private ValueAnimator e() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.setDuration(1000);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        return ofFloat;
    }

    public void a() {
        this.c = false;
        this.j.cancel();
        this.E = (this.i * 1.2f) - 0.01f;
        this.F = d(this.E);
        this.G = c(this.E);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.2f});
        ofFloat.setDuration(1700);
        ofFloat.addUpdateListener(new af(this));
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.addListener(new ag(this));
        ofFloat.start();
    }

    public void a(boolean z) {
        if (!this.c) {
            this.A = z;
            this.B = false;
            this.c = true;
            this.E = 0.0f;
            this.p = 0.0f;
            this.q = 0.0f;
            this.j.cancel();
            this.j.start();
        }
    }

    public void b() {
        this.c = false;
        this.B = true;
        this.p = 1.0f;
        this.q = 1.0f;
        this.E = (this.i * 1.2f) - 0.01f;
        this.G = c(this.E);
        this.E += 1.0f;
        postInvalidate();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.d) {
            c();
        }
        this.h = (360.0f * this.i) + 270.0f;
        if (this.h >= 630.0f) {
            this.h = 270.0f;
        }
        this.f.reset();
        this.f.setRotate(this.h, this.a, this.b);
        this.g.setLocalMatrix(this.f);
        a(canvas, this.A ? this.e : this.r);
        a(canvas, this.p, this.r);
        if (this.B) {
            b(canvas, this.q, this.r);
        } else {
            a(canvas, this.q, this.r);
        }
        if (this.E > 0.0f) {
            this.r.setStrokeWidth(this.t);
            this.r.setAlpha(255);
            d(canvas, this.E, this.r);
        }
    }

    public void setCallback(h hVar) {
        this.x = hVar;
    }
}
