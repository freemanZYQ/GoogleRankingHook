package com.vlocker.ui.widget.view;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.DrawFilter;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.vlocker.locker.R;
import com.vlocker.locker.b.ap;
import com.vlocker.m.ba;
import com.vlocker.m.l;
import com.vlocker.ui.widget.a.e;
import com.vlocker.ui.widget.a.f;
import com.vlocker.ui.widget.a.j;
import com.vlocker.ui.widget.a.m;
import com.vlocker.ui.widget.a.n;
import com.vlocker.ui.widget.c.d;
import java.util.List;

public class LockNumberPointView extends FrameLayout {
    public static final DrawFilter b = new PaintFlagsDrawFilter(0, 3);
    private static Integer[] q = new Integer[]{Integer.valueOf(Color.parseColor("#d9f1f3")), Integer.valueOf(Color.parseColor("#e8f1c4")), Integer.valueOf(Color.parseColor("#dce7f4")), Integer.valueOf(Color.parseColor("#f8d8e2")), Integer.valueOf(Color.parseColor("#fcf3d2")), Integer.valueOf(Color.parseColor("#fde0d7")), Integer.valueOf(Color.parseColor("#f5e6dd")), Integer.valueOf(Color.parseColor("#eee9ff")), Integer.valueOf(Color.parseColor("#e2fae6"))};
    private static int r = -1111;
    public String a;
    private u c;
    private m d;
    private j e;
    private n f;
    private Context g;
    private Paint h;
    private TextPaint i;
    private boolean j;
    private TextView k;
    private TextView l;
    private TextView m;
    private TextView n;
    private Animation o;
    private Animation p;
    private float s;
    private int t;
    private int u;
    private int v;
    private int w;
    private ObjectAnimator x;

    public LockNumberPointView(Context context) {
        this(context, null);
        this.g = context;
    }

    public LockNumberPointView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.h = new Paint();
        this.i = new TextPaint();
        this.j = false;
        this.s = 1.0f;
        this.t = 80;
        this.u = 10;
        this.v = 160;
        this.w = 160;
    }

    private static int a(int i) {
        return (i < 0 || i >= q.length) ? -1 : q[i].intValue();
    }

    private void a(boolean z) {
        if (this.d != null && this.d.E != this.d.r) {
            if (this.x != null && this.x.isRunning()) {
                this.x.cancel();
            }
            if (z) {
                this.x = ObjectAnimator.ofInt(this.k, "mTextColor", new int[]{this.d.E, this.d.r});
                this.x.setDuration(100);
            } else {
                this.x = ObjectAnimator.ofInt(this.k, "mTextColor", new int[]{this.d.r, this.d.E});
                this.x.setDuration(250);
            }
            this.x.addUpdateListener(new p(this));
            this.x.setInterpolator(new AccelerateDecelerateInterpolator());
            this.x.setEvaluator(new ArgbEvaluator());
            this.x.start();
        }
    }

    private void g() {
        this.n.animate().alpha(0.0f).setStartDelay(2000).setDuration(300).setInterpolator(new AccelerateDecelerateInterpolator()).setListener(new m(this));
    }

    private void h() {
        float c = (float) l.c((d.a == 0.0f ? 1.0f : d.a) * 42.0f);
        Typeface a = ba.a(getContext(), "fonts/timeB.ttf", false);
        this.k = new TextView(this.g);
        this.k.setTextColor(-1);
        this.k.setTextSize(c);
        this.k.setText(this.a);
        this.k.setTypeface(a);
        if (this.d != null) {
            if (this.d.J) {
                if (this.d.B != null) {
                    a = ba.a(getContext(), this.d.B, true);
                }
                if (this.d.E != -1) {
                    this.k.setTextColor(this.d.E);
                }
                if (this.d.L != null) {
                    c = a.a(getContext(), this.d.L);
                    if (c != 0.0f) {
                        this.k.setTextSize(c);
                    }
                }
                if (this.d.x != 42) {
                    c = ((float) this.d.x) * d.a;
                    if (c != 0.0f) {
                        this.k.setTextSize((float) l.c(c));
                    }
                }
                if (this.d.e != null) {
                    if (this.d.e.equals("null")) {
                        this.k.setText("");
                    } else {
                        this.k.setText(this.d.e);
                    }
                }
            } else {
                if (this.d.c != null) {
                    Drawable a2 = a.a(this.g, this.d.c + "" + this.a, ((float) this.d.k) * d.a, ((float) this.d.l) * d.a);
                    if (a2 != null) {
                        this.k.setBackgroundDrawable(a2);
                    }
                }
                this.k.setText("");
            }
            this.k.setTypeface(a);
        }
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.k.setLayoutParams(layoutParams);
        addView(this.k, 2);
    }

    private void i() {
        this.n = new TextView(this.g);
        this.n.setTextColor(-11130082);
        this.n.setTextSize(2, 26.0f);
        this.n.setText(this.a);
        this.n.setGravity(17);
        this.n.setVisibility(8);
        this.n.setAlpha(0.0f);
        this.n.setBackgroundResource(R.drawable.num_pwd_point_hint_bg);
        Object obj = "";
        if (ap.a() != null) {
            String str;
            List<com.vlocker.ui.widget.a.d> d = ap.a().d();
            for (com.vlocker.ui.widget.a.d dVar : d) {
                String str2 = (!(dVar instanceof e) || TextUtils.isEmpty(((e) dVar).B)) ? str : ((e) dVar).B;
                str = str2;
            }
            if (TextUtils.isEmpty(str)) {
                for (com.vlocker.ui.widget.a.d dVar2 : d) {
                    if ((dVar2 instanceof f) && !TextUtils.isEmpty(((f) dVar2).B)) {
                        CharSequence charSequence = ((f) dVar2).B;
                    }
                }
            }
        }
        if (!TextUtils.isEmpty(obj)) {
            this.n.setTypeface(ba.a(getContext(), obj, true));
        }
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.n.setLayoutParams(layoutParams);
        addView(this.n);
    }

    private void j() {
        Drawable drawable = null;
        if (this.d != null) {
            this.l = new TextView(this.g);
            this.m = new TextView(this.g);
            Drawable drawable2 = getContext().getResources().getDrawable(R.drawable.l_k_num_circle_translucent);
            float f = ((float) this.d.k) * d.a;
            float f2 = ((float) this.d.l) * d.a;
            Drawable a = this.d.a != null ? this.d.a.equals("null") ? drawable2 : a.a(this.g, this.d.a, f, f2) : null;
            Drawable a2 = this.d.b != null ? this.d.b.equals("null") ? drawable2 : a.a(this.g, this.d.b, f, f2) : null;
            if (a != null) {
                this.m.setBackgroundDrawable(a);
            }
            if (a2 != null) {
                this.l.setBackgroundDrawable(a.a(this.g, a2, (int) R.drawable.l_k_num_circle_translucent));
            }
            a = this.d.c != null ? a.a(this.g, this.d.c + "" + this.a, f, f2) : null;
            if (this.d.d != null) {
                drawable = a.a(this.g, this.d.d + "" + this.a, f, f2);
            }
            if (a != null) {
                this.m.setBackgroundDrawable(a);
            }
            if (drawable != null) {
                a = a.a(this.g, drawable, drawable2);
                if (a != null) {
                    this.l.setBackgroundDrawable(a);
                }
            }
        }
        LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (((float) this.d.k) * d.a), (int) (((float) this.d.l) * d.a));
        this.m.setLayoutParams(new FrameLayout.LayoutParams((int) (((float) this.d.k) * d.a), (int) (((float) this.d.l) * d.a)));
        this.l.setLayoutParams(layoutParams);
        addView(this.m, 0);
        addView(this.l, 1);
    }

    private void k() {
        Animation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration((long) this.w);
        alphaAnimation.setFillAfter(true);
        this.o = alphaAnimation;
        alphaAnimation = new ScaleAnimation(1.0f, this.s, 1.0f, this.s, 1, 0.5f, 1, 0.5f);
        alphaAnimation.setDuration((long) this.t);
        alphaAnimation.setFillAfter(true);
        Animation scaleAnimation = new ScaleAnimation(1.0f, 1.0f / this.s, 1.0f, 1.0f / this.s, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setStartOffset((long) this.t);
        scaleAnimation.setDuration((long) this.u);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setAnimationListener(new n(this));
        Animation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation2.setStartOffset((long) (this.t + this.u));
        alphaAnimation2.setDuration((long) this.v);
        alphaAnimation2.setFillAfter(true);
        Animation animationSet = new AnimationSet(true);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(alphaAnimation2);
        animationSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animationSet.setAnimationListener(new o(this));
        this.p = animationSet;
    }

    private void setPaintAttr(Paint paint) {
        float f = 1.0f;
        paint.reset();
        paint.setAntiAlias(true);
        paint.setTextSize(((float) this.d.x) * d.a);
        paint.setColor(this.d.E);
        paint.setAlpha(this.d.P);
        if (this.d.K == 1) {
            float f2 = this.g.getResources().getDisplayMetrics().density / 1.5f;
            if (f2 > 1.0f) {
                f = 1.0f * f2;
            }
            paint.setShadowLayer(f, 0.0f, 0.0f, this.d.I);
        }
        if (this.d.B != null) {
            paint.setTypeface(ba.a(this.g, this.d.B, true));
        } else if (this.d.H == 1) {
            paint.setTypeface(Typeface.create(Typeface.DEFAULT, 1));
        } else if (this.d.H == 2) {
            paint.setTypeface(Typeface.create(Typeface.DEFAULT, 2));
        }
    }

    public FrameLayout.LayoutParams a(float f, float f2) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (((float) this.d.k) * d.a), (int) (((float) this.d.l) * d.a));
        layoutParams.setMargins((int) (getPaintX() - (d.a * f)), (int) (getPaintY() - (d.c * f2)), 0, 0);
        return layoutParams;
    }

    public void a() {
        this.n.setVisibility(0);
        this.n.animate().setStartDelay(0).alpha(1.0f).setDuration(300).setInterpolator(new AccelerateDecelerateInterpolator()).setListener(new l(this));
    }

    public void b() {
        try {
            this.l.setSelected(true);
            if (this.d == null || this.d.b == null) {
                Drawable background = this.l.getBackground();
                if (background != null) {
                    background.setColorFilter(a(q.length), Mode.SRC_ATOP);
                }
            }
            r.a().a(this.l, this.m, true);
            a(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void c() {
        try {
            r.a().a(this.l, this.m, false);
            a(false);
        } catch (Exception e) {
        }
    }

    public void d() {
    }

    public void e() {
        r.a().c();
        if (this.l != null) {
            this.l.setBackgroundDrawable(null);
        }
        if (this.k != null) {
            this.k.setBackgroundDrawable(null);
        }
        if (this.m != null) {
            this.m.setBackgroundDrawable(null);
        }
        removeAllViews();
        this.l = null;
        this.m = null;
        this.k = null;
    }

    public float getH() {
        return this.d == null ? 0.0f : ((float) this.d.l) * d.a;
    }

    public float getPaintX() {
        return this.d == null ? 0.0f : this.d.f * d.a;
    }

    public float getPaintY() {
        return this.d == null ? 0.0f : this.d.g * d.c;
    }

    public float getW() {
        return this.d == null ? 0.0f : ((float) this.d.k) * d.a;
    }

    public FrameLayout.LayoutParams getmLayoutParams() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (((float) this.d.k) * d.a), (int) (((float) this.d.l) * d.a));
        layoutParams.setMargins((int) getPaintX(), (int) getPaintY(), 0, 0);
        return layoutParams;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.c.a(this, motionEvent);
    }

    public void setBankData(j jVar) {
        this.e = jVar;
    }

    public void setPointData(m mVar) {
        this.d = mVar;
        this.a = this.d.s;
        j();
        h();
        i();
        k();
    }

    public void setTipData(n nVar) {
        this.f = nVar;
    }

    public void setTouchListener(u uVar) {
        this.c = uVar;
    }
}
