package com.vlocker.setting.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import com.vlocker.locker.R;
import com.vlocker.m.l;

public class HexagonContentView extends View {
    private ValueAnimator A;
    private ValueAnimator B;
    private ValueAnimator C;
    private ValueAnimator D;
    private ValueAnimator E;
    private ValueAnimator F;
    private ValueAnimator G;
    private float H;
    private float I;
    private float J = -1.0f;
    private float K = -1.0f;
    private float L;
    private float M;
    private float N;
    private float O;
    private float P = 1.0f;
    private y Q;
    private boolean R;
    private boolean S;
    private boolean T;
    private boolean U;
    private boolean V;
    private boolean W;
    boolean a;
    private boolean aa;
    private boolean ab;
    private float ac = ((float) l.a(35.0f));
    private float ad = ((float) l.a(105.0f));
    private float ae = ((float) l.a(71.0f));
    private float af = ((float) l.a(142.0f));
    private float ag = ((float) l.a(147.0f));
    private float ah = ((float) l.a(66.0f));
    private Bitmap b;
    private Bitmap c;
    private Bitmap d;
    private Bitmap e;
    private Bitmap f;
    private Paint g;
    private Path h;
    private float i;
    private float j;
    private float k;
    private float l;
    private float m;
    private float n;
    private float o;
    private float p;
    private float q;
    private float r;
    private float s;
    private float t;
    private float u;
    private float v;
    private float w;
    private float x;
    private float y;
    private Matrix z;

    public HexagonContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        e();
        g();
    }

    private void a(float f) {
        this.i = (float) (getWidth() / 2);
        this.j = (float) (getHeight() / 2);
        float sin = (float) (((double) f) * Math.sin(0.5235987755982988d));
        float cos = (float) (Math.cos(0.5235987755982988d) * ((double) f));
        this.h = new Path();
        this.h.moveTo(this.i, this.j - (2.0f * sin));
        this.h.lineTo(this.i + cos, this.j - sin);
        this.h.lineTo(this.i + cos, this.j + sin);
        this.h.lineTo(this.i, this.j + (2.0f * sin));
        this.h.lineTo(this.i - cos, this.j + sin);
        this.h.lineTo(this.i - cos, this.j - sin);
        this.h.close();
    }

    private void a(Canvas canvas) {
        Path path = new Path();
        path.moveTo(this.ac, this.ad);
        if (this.O <= 0.325f) {
            path.lineTo(this.ac + ((this.O / 0.325f) * (this.ae - this.ac)), this.ad + ((this.O / 0.325f) * (this.af - this.ad)));
        } else {
            path.lineTo(this.ae, this.af);
            path.lineTo(this.ae + (((this.O - 0.325f) / 0.675f) * (this.ag - this.ae)), this.af + (((this.O - 0.325f) / 0.675f) * (this.ah - this.af)));
        }
        this.g.setStrokeCap(Cap.BUTT);
        this.g.setStrokeWidth((float) l.a(8.0f));
        this.g.setAlpha((int) (255.0f * this.P));
        canvas.drawPath(path, this.g);
    }

    private void b(Canvas canvas) {
        if (this.O > 0.0f) {
            Bitmap createBitmap = Bitmap.createBitmap(this.f, 0, 0, this.f.getWidth(), (int) (((float) this.f.getHeight()) * this.O));
            this.g.setAlpha((int) (255.0f * this.P));
            canvas.drawBitmap(createBitmap, this.i - ((float) (this.f.getWidth() / 2)), this.j - ((float) (this.f.getHeight() / 2)), this.g);
        }
    }

    private void c(Canvas canvas) {
        int saveLayer = canvas.saveLayer(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight(), null, 31);
        this.g.setAlpha(76);
        canvas.drawBitmap(this.b, 0.0f, 0.0f, this.g);
        this.g.setAlpha(255);
        canvas.drawBitmap(this.e, 0.0f, this.M + (this.L * (this.N - this.M)), this.g);
        this.g.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
        canvas.drawBitmap(this.b, 0.0f, 0.0f, this.g);
        this.g.setXfermode(null);
        canvas.restoreToCount(saveLayer);
    }

    private void d(Canvas canvas) {
        float f;
        float f2;
        float f3;
        float f4;
        float height;
        if (this.J >= 0.0f) {
            height = this.l + (this.J * (((float) getHeight()) - this.l));
            f = this.n;
            f2 = this.m;
            f3 = height;
        } else if (this.K >= 0.0f) {
            height = (((1.0f - this.H) * this.y) + this.l) - (this.K * (((float) this.d.getHeight()) + (((((1.0f - this.H) * this.y) + this.l) + ((float) l.a(4.0f))) + this.n)));
            f = this.ab ? this.n - (this.I * (this.n - this.m)) : this.m + (this.I * (this.n - this.m));
            f2 = this.ab ? this.m + (this.I * (this.n - this.m)) : this.n - (this.I * (this.n - this.m));
            f3 = height;
        } else {
            f = this.ab ? this.l + (this.H * this.y) : this.l + ((1.0f - this.H) * this.y);
            f2 = this.ab ? this.m + (this.I * (this.n - this.m)) : this.n - (this.I * (this.n - this.m));
            f3 = f;
            f = this.ab ? this.n - (this.I * (this.n - this.m)) : this.m + (this.I * (this.n - this.m));
        }
        this.z.reset();
        if (this.J >= 0.0f) {
            f4 = 0.7f + ((1.0f - this.J) * 0.3f);
            this.z.setScale(f4, 1.0f);
        } else if (this.K >= 0.0f) {
            f4 = 1.0f - (this.K * 0.3f);
            this.z.setScale(f4, 1.0f);
        } else {
            f4 = 1.0f;
        }
        this.z.postTranslate(this.i - ((f4 * ((float) this.d.getWidth())) / 2.0f), f3);
        canvas.drawBitmap(this.d, this.z, this.g);
        float height2 = (float) (this.d.getHeight() + l.a(4.0f));
        this.g.setStrokeWidth((float) l.a(5.0f));
        this.g.setStrokeCap(Cap.ROUND);
        canvas.drawLine(this.i, height2 + f3, this.i, (f + height2) + f3, this.g);
        canvas.drawLine(this.i - 25.0f, height2 + f3, this.i - 25.0f, (height2 + f2) + f3, this.g);
        canvas.drawLine(this.i + 25.0f, height2 + f3, this.i + 25.0f, (height2 + f2) + f3, this.g);
    }

    private void e() {
        this.g = new Paint();
        this.g.setStyle(Style.STROKE);
        this.g.setColor(-1);
        this.g.setAntiAlias(true);
        this.z = new Matrix();
        this.b = BitmapFactory.decodeResource(getResources(), R.drawable.setting_dianlu);
        this.c = BitmapFactory.decodeResource(getResources(), R.drawable.setting_cloud);
        this.d = BitmapFactory.decodeResource(getResources(), R.drawable.setting_rocket);
        this.e = BitmapFactory.decodeResource(getResources(), R.drawable.setting_zhezhao);
        this.f = BitmapFactory.decodeResource(getResources(), R.drawable.setting_exclamation_mark);
        this.k = getResources().getDimension(R.dimen.hexagon_radius) * 0.98f;
        this.l = getResources().getDimension(R.dimen.rocket_height);
        this.m = getResources().getDimension(R.dimen.rocket_line_min_height);
        this.n = getResources().getDimension(R.dimen.rocket_line_max_height);
        this.o = getResources().getDimension(R.dimen.cloud_one_x);
        this.p = getResources().getDimension(R.dimen.cloud_one_y);
        this.q = getResources().getDimension(R.dimen.cloud_two_x);
        this.r = getResources().getDimension(R.dimen.cloud_two_y);
        this.s = getResources().getDimension(R.dimen.cloud_three_x);
        this.t = getResources().getDimension(R.dimen.cloud_three_y);
        this.u = getResources().getDimension(R.dimen.cloud_four_x);
        this.v = getResources().getDimension(R.dimen.cloud_four_y);
        this.w = getResources().getDimension(R.dimen.cloud_min_y);
        this.x = getResources().getDimension(R.dimen.cloud_max_y);
        this.y = getResources().getDimension(R.dimen.rocket_move_distance);
        this.M = getResources().getDimension(R.dimen.scan_min_y);
        this.N = getResources().getDimension(R.dimen.scan_max_y);
    }

    private void e(Canvas canvas) {
        canvas.drawBitmap(this.c, 0.0f, 0.0f, this.g);
    }

    private void f() {
        if (!this.U) {
            this.U = true;
            this.P = 1.0f;
            this.O = 0.0f;
            this.D.start();
        }
    }

    private void g() {
        this.A = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.A.setDuration(700);
        this.A.setInterpolator(new AccelerateDecelerateInterpolator());
        this.A.setRepeatCount(-1);
        this.A.addUpdateListener(new n(this));
        this.A.addListener(new q(this));
        this.B = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.B.setDuration(500);
        this.B.setStartDelay(100);
        this.B.setInterpolator(new AccelerateDecelerateInterpolator());
        this.B.addUpdateListener(new r(this));
        this.C = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.C.setDuration(1350);
        this.C.setRepeatCount(-1);
        this.C.setInterpolator(new AccelerateInterpolator());
        this.C.addUpdateListener(new s(this));
        this.D = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.D.setDuration(400);
        this.D.setInterpolator(new DecelerateInterpolator());
        this.D.addUpdateListener(new t(this));
        this.D.addListener(new u(this));
        this.E = ValueAnimator.ofFloat(new float[]{1.0f, 0.2f});
        this.E.setDuration(300);
        this.E.setStartDelay(400);
        this.E.setInterpolator(new DecelerateInterpolator());
        this.E.addUpdateListener(new v(this));
        this.F = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        this.F.setDuration(500);
        this.F.setInterpolator(new DecelerateInterpolator());
        this.F.addUpdateListener(new w(this));
        this.F.addListener(new x(this));
        this.G = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.G.setDuration(400);
        this.G.setInterpolator(new AccelerateInterpolator());
        this.G.addUpdateListener(new o(this));
        this.G.addListener(new p(this));
    }

    public void a() {
        this.R = true;
        this.b.recycle();
        this.c.recycle();
        this.d.recycle();
        this.e.recycle();
        this.f.recycle();
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
    }

    public void a(boolean z) {
        if (this.T) {
            this.W = false;
            this.V = z;
            this.H = 0.0f;
            this.I = 0.0f;
            if (this.ab) {
                this.aa = true;
                return;
            }
            this.B.cancel();
            this.A.cancel();
            this.G.start();
        }
    }

    public void b() {
        if (this.S) {
            this.W = true;
            this.V = false;
            this.C.cancel();
            this.L = 0.0f;
            this.S = false;
            f();
        }
    }

    public void c() {
        if (!this.S) {
            this.S = true;
            this.C.start();
        }
    }

    public void d() {
        if (!this.T) {
            this.U = false;
            this.T = true;
            this.F.start();
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.R) {
            if (!this.a) {
                this.a = true;
                a(this.k);
            }
            this.g.setAlpha(255);
            canvas.clipPath(this.h);
            try {
                if (this.S) {
                    c(canvas);
                }
                if (this.T) {
                    d(canvas);
                    e(canvas);
                }
                if (!this.U) {
                    return;
                }
                if (this.V) {
                    a(canvas);
                } else {
                    b(canvas);
                }
            } catch (Exception e) {
            }
        }
    }

    public void setCallback(y yVar) {
        this.Q = yVar;
    }

    public void setFinishViewStatus(boolean z) {
        this.V = z;
        this.U = true;
        this.P = 0.2f;
        this.O = 1.0f;
        postInvalidate();
    }
}
