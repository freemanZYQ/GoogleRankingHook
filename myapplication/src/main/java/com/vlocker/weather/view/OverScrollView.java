package com.vlocker.weather.view;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.vlocker.b.j;
import com.vlocker.m.l;
import com.vlocker.theme.f.a;
import com.vlocker.weather.e.d;
import com.vlocker.weather.model.MXWeatherWidget;
import java.util.Calendar;

public class OverScrollView extends ScrollView {
    private l A;
    private RelativeLayout B;
    private boolean C;
    private float D;
    private int E;
    private int F;
    private j G;
    private boolean H;
    private TextView I;
    private float J;
    private float K;
    public float a = 0.0f;
    public float b = 8.0f;
    public int c = 0;
    Handler d = new g(this);
    public boolean e;
    Runnable f = new h(this);
    boolean g = true;
    boolean h;
    public boolean i = true;
    private float j;
    private int k = 120;
    private m l;
    private float m;
    private float n = 0.0f;
    private j o;
    private boolean p = false;
    private float q = 8.0f;
    private View r;
    private int s;
    private boolean t = true;
    private boolean u = true;
    private int v = 1;
    private int w = 1;
    private int x;
    private float y = 0.0f;
    private float z = 0.0f;

    public OverScrollView(Context context) {
        super(context);
        a(context);
    }

    public OverScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public OverScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private int a(int i) {
        LayoutParams layoutParams = (LayoutParams) this.B.getLayoutParams();
        float headerTopMargin = (float) (((double) getHeaderTopMargin()) + (((double) i) * 0.3d));
        if (i <= 0 || layoutParams.topMargin < this.F) {
            layoutParams.setMargins(0, (int) headerTopMargin, 0, 0);
            this.B.setLayoutParams(layoutParams);
            invalidate();
            return layoutParams.topMargin;
        }
        layoutParams.setMargins(0, layoutParams.topMargin, 0, 0);
        this.B.setLayoutParams(layoutParams);
        return 2;
    }

    private void a(Context context) {
        if (this.o == null) {
            this.o = new j(this, this.d, 1);
        } else {
            this.o.a();
        }
    }

    private void a(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -2);
        }
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(0, 0, layoutParams.width);
        int i = layoutParams.height;
        view.measure(childMeasureSpec, i > 0 ? MeasureSpec.makeMeasureSpec(i, 1073741824) : MeasureSpec.makeMeasureSpec(0, 0));
    }

    private void f() {
        Context context = getContext();
        String str = MXWeatherWidget.WEATHER_CONFIG;
        getContext();
        long j = context.getSharedPreferences(str, 0).getLong(MXWeatherWidget.WEATHER_CONFIG_GET_TIME, 0);
        Calendar.getInstance();
        j = System.currentTimeMillis() - j;
        int intValue = new Long(j / 86400000).intValue();
        int intValue2 = new Long(j / 3600000).intValue();
        int intValue3 = new Long(j / 60000).intValue();
        if (intValue > 0) {
            a.a("isrefreshnow", Boolean.valueOf(true), getContext());
            this.I.setText(intValue + "天前更新");
        } else if (intValue2 > 0) {
            a.a("isrefreshnow", Boolean.valueOf(true), getContext());
            this.I.setText(intValue2 + "小时前更新");
        } else if (intValue3 > 0) {
            a.a("isrefreshnow", Boolean.valueOf(false), getContext());
            this.I.setText(intValue3 + "分钟前更新");
        } else {
            a.a("isrefreshnow", Boolean.valueOf(false), getContext());
            this.I.setText("刚刚更新");
        }
    }

    private void g() {
        this.E = 1;
        this.o.a(5);
    }

    private int getHeaderTopMargin() {
        return ((LayoutParams) this.B.getLayoutParams()).topMargin;
    }

    private void h() {
        this.t = true;
        this.u = true;
    }

    private boolean i() {
        return getScrollY() == 0 || (this.r != null && this.r.getHeight() < getHeight() + getScrollY());
    }

    private void j() {
        this.H = true;
        if (this.l != null) {
            if (getHeaderTopMargin() > (-this.F)) {
            }
            if (!this.e) {
                if (this.C) {
                    d.a(getContext(), "Weather(V)_Refresh_PPC_YZY", new String[0]);
                    com.vlocker.weather.a.a(getContext());
                    this.I.setText("正在刷新");
                    this.e = true;
                    setHeaderTopMargin(0);
                    this.l.b(true);
                } else {
                    setHeaderTopMargin(-this.F);
                }
            }
            com.vlocker.n.a.a().postDelayed(new i(this), 1000);
        }
    }

    private void k() {
        if (j.f(getContext())) {
            this.g = true;
            if (!this.e) {
                f();
            }
        } else {
            this.g = false;
            this.I.setText("当前无网络");
        }
        this.o.a();
        if (this.G != null) {
            this.G.a();
        }
        this.s = 0;
        h();
    }

    public void a() {
        this.x = 0;
        this.v = 1;
        this.w = 1;
        this.E = 2;
        if (this.G == null) {
            this.G = new j(this, this.d, 2);
        } else {
            this.G.a();
        }
        this.G.a(10);
        this.C = false;
        this.e = false;
    }

    public void a(RelativeLayout relativeLayout, TextView textView) {
        if (relativeLayout != null) {
            this.B = relativeLayout;
            a(this.B);
            this.I = textView;
            this.F = this.B.getMeasuredHeight();
        }
    }

    public boolean b() {
        return getScrollY() + getHeight() == this.r.getHeight();
    }

    public void c() {
        int headerTopMargin = getHeaderTopMargin();
        this.e = false;
        if (headerTopMargin >= 0) {
            setHeaderTopMargin(-this.F);
        }
    }

    protected int computeScrollDeltaToGetChildRectOnScreen(Rect rect) {
        return 0;
    }

    public boolean d() {
        return getHeaderTopMargin() != (-this.F);
    }

    public boolean e() {
        return System.currentTimeMillis() - getContext().getSharedPreferences(MXWeatherWidget.WEATHER_CONFIG, 0).getLong(MXWeatherWidget.WEATHER_CONFIG_GET_TIME, 0) < 60000;
    }

    public m getOverScrollListener() {
        return this.l;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float f = 0.0f;
        if (!this.i) {
            return false;
        }
        float f2;
        switch (motionEvent.getAction()) {
            case 0:
                this.J = motionEvent.getX();
                this.K = motionEvent.getY();
                f2 = 0.0f;
                break;
            case 2:
                f2 = motionEvent.getX() - this.J;
                f = motionEvent.getY() - this.K;
                break;
            default:
                f2 = 0.0f;
                break;
        }
        return (getScrollY() != 0 || f <= f2 || f <= ((float) l.a(10.0f))) ? super.onInterceptTouchEvent(motionEvent) : true;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (getScrollY() == 0) {
            if (!this.p) {
                this.r = getChildAt(0);
                this.p = true;
            }
            if (this.r != null) {
                this.r.layout(0, (int) (this.a + this.n), this.r.getMeasuredWidth(), ((int) (this.a + this.n)) + this.r.getMeasuredHeight());
                return;
            }
            return;
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.onOverScrolled(i, i2, z, z2);
        if (this.h) {
            this.d.removeCallbacks(this.f);
            this.d.postDelayed(this.f, 50);
        }
    }

    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (Math.abs(this.z - this.y) > ((float) l.a(getContext(), 30.0f))) {
            com.vlocker.weather.a.a(getContext());
        }
        if (this.A != null) {
            this.A.a(i, i2, i3, i4);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.H = false;
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.m = motionEvent.getY();
                k();
                this.q = 8.0f;
                this.y = motionEvent.getY();
                this.z = motionEvent.getY();
                break;
            case 1:
                if (getHeaderTopMargin() > (-this.F)) {
                    g();
                }
                if (b()) {
                    this.l.p();
                }
                if (this.g && !e()) {
                    j();
                } else if (this.C) {
                    this.l.b(false);
                } else {
                    setHeaderTopMargin(-this.F);
                }
                this.h = true;
                this.m = 0.0f;
                break;
            case 2:
                this.h = false;
                com.vlocker.weather.a.c = true;
                this.z = motionEvent.getY();
                if (this.m == 0.0f) {
                    if (this.A != null) {
                        this.A.t();
                    }
                    this.q = 8.0f;
                    this.m = motionEvent.getY();
                    k();
                }
                if (!this.e) {
                    this.D = motionEvent.getY() - this.m;
                    if (this.D > 0.0f && getScrollY() == 0) {
                        if (this.s != 0) {
                            this.s = 0;
                        } else if (this.t && i()) {
                            this.a += this.D / this.q;
                            if (motionEvent.getY() - this.m < 0.0f) {
                                this.a += this.D;
                            }
                            if (this.a < 0.0f) {
                                this.a = 0.0f;
                                this.t = false;
                                this.u = true;
                            }
                            if (this.a > ((float) getMeasuredHeight())) {
                                this.a = (float) getMeasuredHeight();
                            }
                            this.j = this.a;
                        } else {
                            h();
                        }
                        this.m = motionEvent.getY();
                        requestLayout();
                        if (a((int) this.D) >= 0) {
                            this.C = true;
                            if (j.f(getContext()) && !e()) {
                                this.I.setText("释放可刷新");
                            }
                            this.l.q();
                            break;
                        }
                    }
                }
                break;
            case 3:
                if (getHeaderTopMargin() >= 0) {
                    setHeaderTopMargin(0);
                } else {
                    setHeaderTopMargin(-this.F);
                }
                this.m = 0.0f;
                break;
            case 5:
            case 6:
                this.s = -1;
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.G != null) {
            this.G.a();
        }
        if (this.B != null) {
            setHeaderTopMargin(-this.F);
        }
    }

    public void setHeaderTopMargin(int i) {
        LayoutParams layoutParams = (LayoutParams) this.B.getLayoutParams();
        layoutParams.topMargin = i;
        this.B.setLayoutParams(layoutParams);
        invalidate();
    }

    public void setOnScrollListener(l lVar) {
        this.A = lVar;
    }

    public void setOverScrollListener(m mVar) {
        this.l = mVar;
    }

    public void setOverScrollTrigger(int i) {
        if (i >= 30) {
            this.k = i;
        }
    }
}
