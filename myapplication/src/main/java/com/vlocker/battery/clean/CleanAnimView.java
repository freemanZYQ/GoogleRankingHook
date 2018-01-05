package com.vlocker.battery.clean;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.Op;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.vlocker.locker.R;
import com.vlocker.m.l;

public class CleanAnimView extends View {
    private ValueAnimator A;
    private t B;
    private int a = 2;
    private float b;
    private float c;
    private float d;
    private float e;
    private float f;
    private float g;
    private float h;
    private float i;
    private float j;
    private float k;
    private float l = 1.0f;
    private float m;
    private float n;
    private float o;
    private Paint p;
    private Paint q;
    private boolean r;
    private ValueAnimator s;
    private ValueAnimator t;
    private ValueAnimator u;
    private ValueAnimator v;
    private ValueAnimator w;
    private ValueAnimator x;
    private ValueAnimator y;
    private ValueAnimator z;

    public CleanAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c();
        d();
        b();
    }

    private void a(Canvas canvas, Paint paint) {
        float f = this.m <= 1.0f ? (this.h + ((this.f - this.h) * this.m)) / 2.0f : this.m <= 2.0f ? (this.f - ((this.f - this.e) * (this.m - 1.0f))) / 2.0f : (this.e + ((this.g - this.e) * (this.m - 2.0f))) / 2.0f;
        canvas.drawCircle(this.b / 2.0f, (this.d / 4.0f) + (this.c / 2.0f), f, paint);
    }

    private void b() {
        this.s = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.s.setDuration(300);
        this.s.setInterpolator(new AccelerateDecelerateInterpolator());
        this.s.addUpdateListener(new b(this));
        this.s.addListener(new l(this));
        this.t = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.t.setDuration(350);
        this.t.setInterpolator(new AccelerateDecelerateInterpolator());
        this.t.addUpdateListener(new m(this));
        this.t.addListener(new n(this));
        this.u = ValueAnimator.ofFloat(new float[]{1.0f, 2.0f});
        this.u.setDuration(200);
        this.u.setInterpolator(new AccelerateDecelerateInterpolator());
        this.u.addUpdateListener(new o(this));
        this.u.addListener(new p(this));
        this.v = ValueAnimator.ofFloat(new float[]{2.0f, 3.0f});
        this.v.setDuration(150);
        this.v.setInterpolator(new AccelerateDecelerateInterpolator());
        this.v.addUpdateListener(new q(this));
        this.v.addListener(new r(this));
        this.w = ValueAnimator.ofFloat(new float[]{0.0f, 0.5f});
        this.w.setDuration(350);
        this.w.setInterpolator(new AccelerateInterpolator());
        this.w.addUpdateListener(new s(this));
        this.w.addListener(new c(this));
        this.x = ValueAnimator.ofFloat(new float[]{0.5f, 6.5f});
        this.x.setDuration(1000);
        this.x.setInterpolator(new LinearInterpolator());
        this.x.addUpdateListener(new d(this));
        this.x.addListener(new e(this));
        this.y = ValueAnimator.ofFloat(new float[]{6.5f, 7.0f});
        this.y.setDuration(150);
        this.y.setInterpolator(new LinearInterpolator());
        this.y.addUpdateListener(new f(this));
        this.y.addListener(new g(this));
        this.z = ValueAnimator.ofFloat(new float[]{7.0f, 8.5f});
        this.z.setDuration(450);
        this.z.setInterpolator(new DecelerateInterpolator());
        this.z.addUpdateListener(new h(this));
        this.z.addListener(new i(this));
        this.A = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        this.A.setDuration(300);
        this.A.setInterpolator(new DecelerateInterpolator());
        this.A.addUpdateListener(new j(this));
        this.A.addListener(new k(this));
    }

    private void b(Canvas canvas, Paint paint) {
        float f = this.o > 0.75f ? 270.0f + (90.0f * ((1.0f - this.o) / 0.25f)) : 360.0f * ((1.0f - this.o) - 0.25f);
        canvas.save();
        canvas.rotate(this.n * 360.0f, this.b / 2.0f, (this.d / 4.0f) + (this.c / 2.0f));
        canvas.drawArc(new RectF((this.b / 2.0f) - (this.g / 2.0f), ((this.d / 4.0f) + (this.c / 2.0f)) - (this.g / 2.0f), (this.b / 2.0f) + (this.g / 2.0f), ((this.d / 4.0f) + (this.c / 2.0f)) + (this.g / 2.0f)), f, 360.0f * this.o, false, paint);
        canvas.restore();
    }

    private void c() {
        this.p = new Paint();
        this.p.setColor(-1);
        this.p.setStyle(Style.STROKE);
        this.p.setAntiAlias(true);
        this.p.setStrokeWidth(getResources().getDimension(R.dimen.clean_view_stroke_width));
        this.q = new Paint();
        this.q.setColor(872415231);
        this.q.setStyle(Style.FILL);
        this.q.setAntiAlias(true);
    }

    @TargetApi(19)
    private void c(Canvas canvas, Paint paint) {
        Path path = new Path();
        float f = this.r ? this.g : this.e;
        path.addRoundRect(new RectF(((this.b - f) / 2.0f) * this.l, (this.d / 4.0f) + (((this.c - f) / 2.0f) * this.l), this.b - (((this.b - f) / 2.0f) * this.l), (this.c + (this.d / 4.0f)) - (((this.c - f) / 2.0f) * this.l)), this.i + ((this.j - this.i) * this.l), this.i + ((this.j - this.i) * this.l), Direction.CW);
        Path path2 = new Path();
        if (VERSION.SDK_INT <= 18) {
            path2.addRoundRect(new RectF((this.b / 2.0f) - ((this.d / 2.0f) * (1.0f - this.l)), ((((this.c - f) / 2.0f) * this.l) + (this.d / 4.0f)) - ((this.d / 4.0f) * (1.0f - this.l)), (this.b / 2.0f) + ((this.d / 2.0f) * (1.0f - this.l)), (((this.c - f) / 2.0f) * this.l) + (this.d / 4.0f)), this.k, this.k, Direction.CW);
            canvas.drawPath(path2, paint);
            canvas.drawPath(path, paint);
            return;
        }
        path2.addRoundRect(new RectF((this.b / 2.0f) - (this.d / 2.0f), this.l * f, (this.b / 2.0f) + (this.d / 2.0f), (f * this.l) + this.d), this.k, this.k, Direction.CW);
        path.op(path2, Op.UNION);
        canvas.drawPath(path, paint);
    }

    private void d() {
        this.i = getResources().getDimension(R.dimen.clean_view_corner_radius_min);
        this.j = getResources().getDimension(R.dimen.clean_view_corner_radius_max);
        this.k = getResources().getDimension(R.dimen.clean_view_corner_top_radius);
        this.d = getResources().getDimension(R.dimen.clean_view_top_rect_width);
        this.b = getResources().getDimension(R.dimen.clean_view_rect_max_width);
        this.c = getResources().getDimension(R.dimen.clean_view_rect_max_height);
        this.e = getResources().getDimension(R.dimen.clean_view_rect_min_radius);
        this.f = getResources().getDimension(R.dimen.clean_view_rect_max_radius);
        this.g = getResources().getDimension(R.dimen.clean_view_rect_mid_radius);
        this.h = getResources().getDimension(R.dimen.clean_view_rect_start_radius);
    }

    public void a() {
        this.t.start();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.translate((float) l.a(1.0f), (float) l.a(1.0f));
        switch (this.a) {
            case 1:
                c(canvas, this.p);
                c(canvas, this.q);
                break;
            case 2:
                a(canvas, this.p);
                a(canvas, this.q);
                break;
            case 3:
                b(canvas, this.p);
                a(canvas, this.q);
                break;
        }
        canvas.restore();
    }

    public void setCallBack(t tVar) {
        this.B = tVar;
    }
}
