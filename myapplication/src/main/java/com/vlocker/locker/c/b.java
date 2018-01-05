package com.vlocker.locker.c;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import com.vlocker.battery.clean.y;
import com.vlocker.c.a;
import com.vlocker.locker.R;
import com.vlocker.locker.b.i;
import com.vlocker.locker.b.p;
import com.vlocker.m.ba;
import com.vlocker.m.e;
import com.vlocker.m.l;
import com.vlocker.search.as;
import com.vlocker.share.ShareUtil;
import com.vlocker.ui.cover.f;
import com.vlocker.ui.cover.g;
import com.vlocker.ui.cover.h;
import com.vlocker.ui.view.BatteryChargeView;
import com.vlocker.ui.view.MaskImageView;
import com.vlocker.ui.view.MaskTextView;
import com.vlocker.ui.view.WidgetHourView;
import com.vlocker.ui.view.ap;
import com.vlocker.ui.widget.ArcText;
import com.vlocker.ui.widget.CoverViewPager;
import com.vlocker.ui.widget.MsgListView;
import com.vlocker.ui.widget.MusicLrcView;
import com.vlocker.ui.widget.NotifyRootLayout;
import com.vlocker.ui.widget.c;
import com.vlocker.ui.widget.c.d;
import com.vlocker.weather.view.CoverTipsLayout;
import com.vlocker.weather.view.CoverWeatherLayout;
import com.xinmei365.fontsdk.FontCenter;

public class b extends a implements as {
    public static boolean e;
    public static boolean f;
    private int A;
    private CoverViewPager B;
    private i C;
    private a D;
    private CoverWeatherLayout E;
    private com.vlocker.locker.b.a F;
    private Handler G;
    private WidgetHourView H;
    private View I;
    private FrameLayout J;
    private View K;
    private View L;
    private View M;
    private View N;
    private boolean O;
    private boolean P;
    private ah Q;
    private ArcText R;
    private Runnable S = new ac(this);
    private Runnable T = new af(this);
    private boolean U;
    private float V;
    private float W;
    private float X;
    private float Y;
    private long Z;
    private OnTouchListener aa = new g(this);
    private Runnable ab = new h(this);
    private int ac;
    private boolean ad;
    private boolean ae;
    private int af;
    private long ag;
    private int ah;
    private boolean ai;
    private boolean aj;
    private int ak = -1;
    private MusicLrcView al;
    private com.vlocker.j.a am;
    private boolean an;
    private BatteryChargeView ao;
    private BatteryChargeView ap;
    private boolean aq = true;
    private int ar;
    private int as;
    private boolean at;
    private float au = 0.0f;
    private boolean av;
    private int aw;
    private boolean ax;
    public float g = 0.0f;
    public int h;
    long i = 800;
    long j = 800;
    long k = 1000;
    long l = 1200;
    long m = 1200;
    boolean n = false;
    private TextView o;
    private TextView p;
    private TextView q;
    private boolean r;
    private FrameLayout s;
    private MaskImageView t;
    private MaskTextView u;
    private ImageView v;
    private NotifyRootLayout w;
    private c x;
    private ap y;
    private int z;

    public b(Context context, p pVar) {
        this.a = context;
        this.c = pVar;
        this.d = "main_page";
        this.G = new Handler();
        this.D = a.a(context);
        this.B = pVar.k();
        this.F = new com.vlocker.locker.b.a();
        K();
        this.B.setUnlockCallback(this.x);
        this.B.setSearchCallback(this);
        int i = context.getResources().getDisplayMetrics().widthPixels;
        int i2 = context.getResources().getDisplayMetrics().heightPixels;
        this.A = i > i2 ? i : i2;
        if (i >= i2) {
            i = i2;
        }
        this.z = i;
        this.af = l.a(context, 10.0f);
        this.aw = l.a(context, 40.0f);
        this.Q = new ah();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("action_battery_tomini");
        intentFilter.addAction("action_reset_unlock");
        context.registerReceiver(this.Q, intentFilter);
    }

    private void A() {
        this.N.clearAnimation();
        this.N.setVisibility(0);
        this.N.animate().alpha(0.0f).setDuration(200).setInterpolator(new LinearInterpolator()).setListener(new ad(this)).start();
    }

    private void B() {
        this.q = new TextView(this.a);
        this.q.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.share_btn_bg));
        this.q.setTextColor(-13421773);
        this.q.setGravity(16);
        this.q.setPadding(l.a(40.0f), 0, 0, 0);
        this.q.setText(this.D.bV() ? "分享一下" : "喜欢吗？");
        this.D.as(!this.D.bV());
        if (this.P) {
            this.P = false;
            this.O = true;
            if (!(!ShareUtil.getInstance().isShareAppExist() || TextUtils.isEmpty(this.D.o()) || this.D.o().equals(IXAdSystemUtils.NT_NONE))) {
                LayoutParams layoutParams = new RelativeLayout.LayoutParams(l.a(110.0f), -2);
                layoutParams.addRule(11, -1);
                layoutParams.addRule(15, -1);
                ((ViewGroup) this.b).addView(this.q, layoutParams);
                this.G.postDelayed(this.T, 10000);
            }
        }
        this.q.setOnClickListener(new ae(this));
    }

    private void C() {
        if (ShareUtil.getInstance().isShareThemeShowing) {
            ShareUtil.getInstance().hideShareTheme();
        }
        if (!(this.q == null || this.q.getParent() == null)) {
            ((ViewGroup) this.b).removeView(this.q);
        }
        if (this.G != null) {
            this.G.removeCallbacks(this.T);
        }
    }

    private void D() {
        int j = this.D.j();
        this.p.setTextColor(j);
        this.o.setTextColor(j);
        if (!this.U) {
            this.u.a();
        }
        if (!this.D.p()) {
            this.E.a();
        }
    }

    private void E() {
        float k = ((float) this.D.k()) / 255.0f;
        this.p.setAlpha(k);
        this.o.setAlpha(k);
        this.E.setAlpha(k);
    }

    private void F() {
        this.C = new i(this.a, (RelativeLayout) this.b);
        this.C.a(new e(this));
    }

    private void G() {
        if (com.vlocker.locker.b.ap.a() != null && com.vlocker.locker.b.ap.a().u != null && this.D.p()) {
            this.H = (WidgetHourView) this.b.findViewById(R.id.cover_widget_hour_view);
            this.H.a();
            this.y = com.vlocker.locker.b.ap.a(this.a).d();
            com.vlocker.locker.b.ap.a(this.a).a((RelativeLayout) this.b, this.y);
            ((RelativeLayout.LayoutParams) this.w.getLayoutParams()).addRule(3, R.id.cover_widget_super_layout);
            this.w.requestLayout();
            I();
            this.p.setVisibility(8);
            this.o.setVisibility(8);
            if (h.c == 2 || (h.c == 1 && h.a != 1)) {
                this.s.setOnTouchListener(this.aa);
            }
            if (com.vlocker.locker.b.ap.a().v != null) {
                if (com.vlocker.locker.b.ap.a().v.a != null) {
                    ((ImageView) this.b.findViewById(R.id.tool_box_img)).setImageBitmap(com.vlocker.ui.widget.b.c.a(this.a, com.vlocker.locker.b.ap.a().v.a, 320));
                }
                if (com.vlocker.locker.b.ap.a().v.b != null) {
                    ((ImageView) this.b.findViewById(R.id.camera_icon)).setImageBitmap(com.vlocker.ui.widget.b.c.a(this.a, com.vlocker.locker.b.ap.a().v.b, 320));
                }
            }
        }
    }

    private void H() {
        this.v.setVisibility(8);
        this.t.setVisibility(8);
        this.u.setVisibility(0);
        this.u.setText(this.D.dm());
        this.u.a();
        String dp = this.D.dp();
        if (TextUtils.isEmpty(dp)) {
            this.u.setTypeface(null);
        } else {
            FontCenter.getInstance().getCloudTypeface(dp, this.D.dm(), new f(this));
        }
        n();
        m();
    }

    private void I() {
        if (!this.D.dl() && com.vlocker.locker.b.ap.a().u != null) {
            if (com.vlocker.locker.b.ap.a().u.i != null) {
                Bitmap a = com.vlocker.ui.widget.b.c.a(this.a, com.vlocker.locker.b.ap.a().u.i, 320);
                if (a != null) {
                    this.t.setVisibility(0);
                    this.t.setBitmap(a);
                    this.u.setVisibility(8);
                    if (com.vlocker.locker.b.ap.a().u.u != null) {
                        this.v.setVisibility(0);
                        this.v.setImageBitmap(com.vlocker.ui.widget.b.c.a(this.a, com.vlocker.locker.b.ap.a().u.u, 320));
                        return;
                    }
                    return;
                }
                this.t.setVisibility(8);
                this.u.setVisibility(4);
            } else if (com.vlocker.locker.b.ap.a().u.A != null) {
                this.U = true;
                this.u.setVisibility(0);
                this.u.setText(com.vlocker.locker.b.ap.a().u.A);
                this.u.setCompoundDrawables(null, null, null, null);
                if (com.vlocker.locker.b.ap.a().u.J) {
                    float a2;
                    if (com.vlocker.locker.b.ap.a().u.E != -1) {
                        this.u.setTextColor(com.vlocker.locker.b.ap.a().u.E);
                    }
                    if (com.vlocker.locker.b.ap.a().u.B != null) {
                        Typeface a3 = ba.a(this.a, com.vlocker.locker.b.ap.a().u.B, true);
                        if (a3 != null) {
                            this.u.setTypeface(a3);
                        }
                    }
                    if (com.vlocker.locker.b.ap.a().u.L != null) {
                        a2 = com.vlocker.ui.widget.b.c.a(this.a, com.vlocker.locker.b.ap.a().u.L);
                        if (a2 != 0.0f) {
                            this.u.setTextSize(a2);
                        }
                    }
                    if (com.vlocker.locker.b.ap.a().u.x != 24) {
                        a2 = ((float) com.vlocker.locker.b.ap.a().u.x) * d.a;
                        if (a2 != 0.0f) {
                            this.u.setTextSize((float) l.c(a2));
                        }
                    }
                }
            }
        }
    }

    private int J() {
        int i = this.ac - this.ah;
        if (i <= 0) {
            return 280;
        }
        int currentTimeMillis = (int) (((float) (this.ah <= 0 ? System.currentTimeMillis() - this.ag : 1000)) * (((h.a == 1 ? (float) this.z : (float) this.A) / ((float) i)) - 1.0f));
        if (currentTimeMillis > 280) {
            currentTimeMillis = 280;
        }
        return currentTimeMillis;
    }

    private void K() {
        this.x = new i(this);
    }

    private void L() {
        if (h.h == 1 && h.a == 1) {
            this.c.a(g.g(), true);
        } else {
            this.c.b(true);
        }
        this.G.postDelayed(new j(this), 150);
    }

    private void M() {
        if (!this.aj && !this.at && com.vlocker.locker.b.ap.a() != null && this.y != null && this.s != null && this.w != null && this.y.getVisibility() == 0) {
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            this.w.getLocationOnScreen(iArr);
            this.s.getLocationOnScreen(iArr2);
            int a = l.a(144.40001f);
            if (iArr[1] > 0 && iArr2[1] > 0 && iArr2[1] - iArr[1] < a) {
                this.aj = true;
                com.vlocker.b.p.a(this.a, "Vlocker_Change_TimeWidget_PPC_RR", new String[0]);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.y.getLayoutParams();
                this.ak = layoutParams.topMargin;
                layoutParams.topMargin = this.ak - (l.a(147.40001f) - (iArr2[1] - iArr[1]));
                this.y.requestLayout();
                this.b.requestLayout();
            }
        }
    }

    private void N() {
        if (!this.at && this.y != null && this.ak >= 0) {
            ((RelativeLayout.LayoutParams) this.y.getLayoutParams()).topMargin = this.ak;
            this.y.requestLayout();
            this.b.requestLayout();
            this.aj = false;
        }
    }

    private void O() {
        this.al = (MusicLrcView) View.inflate(this.a, R.layout.l_muisic_item, null);
        this.al.a(this.c);
        this.am = com.vlocker.j.a.a();
        if (this.am != null) {
            this.am.a(this.al, this.w);
            this.am.a(new k(this));
        }
    }

    private boolean P() {
        if (this.s == null) {
            return false;
        }
        if (this.s.getVisibility() == 8) {
            return true;
        }
        if (this.ar == 0) {
            Q();
        }
        return this.ar > 0;
    }

    private void Q() {
        if (this.s != null) {
            int[] iArr = new int[2];
            this.s.getLocationOnScreen(iArr);
            this.ar = iArr[1];
        }
    }

    private void R() {
        if (this.w != null) {
            int[] iArr = new int[2];
            this.w.getLocationOnScreen(iArr);
            this.as = iArr[1] + T();
        }
    }

    private void S() {
        if (this.ao != null) {
            int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
            int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(0, 0);
            this.ao.measure(makeMeasureSpec, makeMeasureSpec2);
            this.au = (float) (this.ao.getMeasuredHeight() + l.a(80.4f));
            this.ap.measure(makeMeasureSpec, makeMeasureSpec2);
            this.g = (float) (this.ao.getMeasuredHeight() - this.ap.getMeasuredHeight());
        }
    }

    private int T() {
        View findViewById = this.b.findViewById(R.id.cover_weather_layout);
        if (findViewById.getVisibility() != 8 || this.D.p()) {
            return 0;
        }
        findViewById.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
        return findViewById.getMeasuredHeight();
    }

    private void U() {
        if (BatteryChargeView.c) {
            if (this.ar == 0) {
                Q();
            }
            if (this.as == 0) {
                R();
            }
            if (this.ar <= 0 || this.as <= 0) {
                this.av = true;
            } else if (((float) (this.ar - this.as)) > this.au) {
                this.h = (int) (((float) (this.ar - this.as)) - this.au);
                this.g += (float) this.h;
                this.ao.setWaveMarginTop(this.h);
            }
        }
    }

    private void V() {
        this.g -= (float) this.h;
        this.h = 0;
        this.ao.f();
    }

    private void W() {
        if (!this.at && com.vlocker.locker.b.ap.a() != null && BatteryChargeView.c) {
            if (this.au == 0.0f) {
                S();
            }
            if (this.ar == 0) {
                Q();
            }
            float f = this.au;
            int[] iArr = new int[2];
            this.H.getLocationOnScreen(iArr);
            if (iArr[1] <= 0 || this.ar <= 0 || f <= 0.0f) {
                this.an = true;
                return;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.y.getLayoutParams();
            int i = this.ar - (layoutParams.height + layoutParams.topMargin);
            int i2 = this.ar - (iArr[1] + this.H.getLayoutParams().height);
            int i3 = (int) f;
            this.at = true;
            com.vlocker.b.p.a(this.a, "Vlocker_Change_TimeWidget_PPC_RR", new String[0]);
            if (this.aq) {
                if (!(com.vlocker.locker.b.ap.a() == null || i >= i3 || this.w == null)) {
                    layoutParams = (RelativeLayout.LayoutParams) this.y.getLayoutParams();
                    this.ak = layoutParams.topMargin;
                    layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin - ((i3 - i) + l.a(25.0f)), 0, 0);
                    this.y.requestLayout();
                    this.b.requestLayout();
                }
                ((RelativeLayout.LayoutParams) this.w.getLayoutParams()).addRule(3, R.id.cover_widget_super_layout);
                this.w.requestLayout();
                return;
            }
            if (!(com.vlocker.locker.b.ap.a() == null || i2 >= i3 || this.w == null)) {
                layoutParams = (RelativeLayout.LayoutParams) this.H.getLayoutParams();
                layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin - (i3 - i2), 0, 0);
                this.H.requestLayout();
            }
            ((RelativeLayout.LayoutParams) this.w.getLayoutParams()).addRule(3, R.id.cover_widget_hour_view);
            this.w.requestLayout();
        }
    }

    private void X() {
        if (!this.at && com.vlocker.locker.b.ap.a() != null) {
            this.at = true;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.H.getLayoutParams();
            layoutParams.setMargins(layoutParams.leftMargin, l.a(10.0f), 0, 0);
            this.H.requestLayout();
            ((RelativeLayout.LayoutParams) this.w.getLayoutParams()).addRule(3, R.id.cover_widget_hour_view);
            this.w.requestLayout();
        }
    }

    private void Y() {
        if (!this.aj && this.at && this.w != null) {
            this.at = false;
            if (!this.aq || this.ak < 0) {
                this.H.d();
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.w.getLayoutParams();
                layoutParams.addRule(3, R.id.cover_widget_super_layout);
                this.w.setLayoutParams(layoutParams);
                return;
            }
            ((RelativeLayout.LayoutParams) this.y.getLayoutParams()).topMargin = this.ak;
            this.y.requestLayout();
            this.b.requestLayout();
        }
    }

    private void Z() {
        if (VERSION.SDK_INT >= 19) {
            this.b.setPadding(0, com.vlocker.m.h.d(this.a), 0, 0);
        } else if (this.D.ai() == 0) {
            this.b.setPadding(0, 0, 0, 0);
        } else {
            this.b.setPadding(0, com.vlocker.m.h.d(this.a), 0, 0);
        }
    }

    private void a(long j) {
        if (this.c != null) {
            this.c.d();
        }
        a(this.o, this.j, 4, 0);
        a(this.s, this.l, 1, 0);
        a(this.y, this.l, 1, 0);
        a(this.p, this.i, 4, j / 5);
        if (!com.vlocker.theme.f.b.l()) {
            a(this.L, this.m, 2, j / 5);
        }
        if (this.K != null) {
            ViewPropertyAnimator animate = this.K.animate();
            animate.cancel();
            animate.setInterpolator(new OvershootInterpolator(1.0f)).translationX(0.0f).setDuration(this.k).setStartDelay(j / 5).start();
            animate.setListener(new t(this));
        }
    }

    private void a(View view, long j, int i, long j2) {
        if (view != null) {
            ViewPropertyAnimator animate = view.animate();
            animate.cancel();
            if (i == 0) {
                animate.setInterpolator(new DecelerateInterpolator()).translationX(0.0f).translationY(0.0f).alpha(1.0f).setDuration(j).setStartDelay(j2).start();
            } else if (i == 1) {
                animate.setInterpolator(new OvershootInterpolator(1.0f)).translationX(0.0f).translationY(0.0f).alpha(1.0f).setDuration(j).setStartDelay(j2).start();
            } else if (i == 2) {
                animate.setInterpolator(new OvershootInterpolator(1.0f)).translationY(0.0f).alpha(1.0f).setDuration(j).setStartDelay(j2).start();
            } else if (i == 3) {
                animate.setInterpolator(new DecelerateInterpolator()).translationY(0.0f).alpha(1.0f).setDuration(j).setStartDelay(j2).start();
            } else if (i == 4) {
                animate.setInterpolator(new OvershootInterpolator(1.0f)).translationX(0.0f).translationY(0.0f).setDuration(j).setStartDelay(j2).start();
            }
            animate.setListener(new u(this));
        }
    }

    private void aa() {
        if (!this.ax) {
            View view = this.B;
            if (view != null) {
                this.G.post(new v(this, view));
            }
        }
    }

    private void b(float f) {
        if (!com.vlocker.battery.saver.a.b || !this.D.bX() || System.currentTimeMillis() <= this.D.bZ()) {
            if (this.o != null) {
                if (h.e == 1) {
                    this.o.setX(f);
                } else if (h.e == 2) {
                    this.o.setY((float) this.A);
                } else {
                    this.o.setY((float) (-this.o.getHeight()));
                }
            }
            if (this.p != null) {
                if (h.e == 1) {
                    this.p.setX(f);
                } else if (h.e == 2) {
                    this.p.setY((float) this.A);
                } else {
                    this.p.setY((float) (-this.p.getHeight()));
                }
            }
            if (this.K != null) {
                if (h.e == 1) {
                    this.K.setX(f);
                } else if (h.e == 2) {
                    this.K.setY((float) this.A);
                } else {
                    this.K.setY((float) (-this.p.getHeight()));
                }
            }
            if (this.s != null) {
                if (h.e == 1) {
                    this.s.setX(f);
                } else if (h.e == 2) {
                    this.s.setY((float) this.A);
                } else {
                    this.s.setY((float) (-this.s.getHeight()));
                }
            }
            if (this.y != null) {
                if (h.e == 1) {
                    this.y.setX(f);
                } else if (h.e == 2) {
                    this.y.setTranslationY((float) this.y.getHeight());
                    this.y.setAlpha(0.0f);
                } else {
                    this.y.setTranslationY((float) (-this.y.getHeight()));
                    this.y.setAlpha(0.0f);
                }
            }
            if (!com.vlocker.theme.f.b.l() && this.L != null) {
                this.L.setY((float) this.a.getResources().getDisplayMetrics().heightPixels);
            }
        }
    }

    private void c(float f) {
        if (this.o != null) {
            this.o.setTranslationX(f);
        }
        if (this.p != null) {
            this.p.setTranslationX(f);
        }
        if (this.K != null) {
            this.K.setTranslationX(f);
        }
        if (this.s != null) {
            this.s.setTranslationX(f);
        }
        if (this.y != null) {
            this.y.setTranslationX(f);
            this.y.setTranslationY(0.0f);
            this.y.setAlpha(1.0f);
        }
        if (!com.vlocker.theme.f.b.l() && this.L != null) {
            if (f == 0.0f) {
                this.L.setTranslationY(0.0f);
            } else {
                this.L.setTranslationY((float) this.a.getResources().getDisplayMetrics().heightPixels);
            }
        }
    }

    private void c(boolean z) {
        this.I.setVisibility(z ? 0 : 8);
    }

    private void y() {
        this.b = LayoutInflater.from(this.a).inflate(R.layout.fragment_lock, null);
        this.o = (TextView) this.b.findViewById(R.id.time_textview);
        this.p = (TextView) this.b.findViewById(R.id.date_textview);
        this.M = this.b.findViewById(R.id.search_tips);
        this.R = (ArcText) this.b.findViewById(R.id.arctext);
        this.K = this.b.findViewById(R.id.cover_weather_super_layout);
        this.L = this.b.findViewById(R.id.buttombar);
        Z();
        this.s = (FrameLayout) this.b.findViewById(R.id.slide_unlock_layout);
        this.s.setOnLongClickListener(new c(this));
        this.s.setOnClickListener(new n(this));
        if (h.g != 1) {
            this.s.setClipChildren(false);
            this.s.setClipToPadding(false);
            this.s.setPadding(this.z / 20, this.z / 20, this.z / 20, this.z / 20);
        }
        this.u = (MaskTextView) this.b.findViewById(R.id.slide_text);
        this.t = (MaskImageView) this.b.findViewById(R.id.slide_press);
        this.v = (ImageView) this.b.findViewById(R.id.slide_bg);
        if (this.D.dl()) {
            H();
        }
        this.w = (NotifyRootLayout) this.b.findViewById(R.id.cover_notification_show_layout);
        this.w.setCallback(new z(this));
        this.o.setTypeface(Typeface.createFromAsset(this.a.getAssets(), "fonts/time.ttf"));
        CoverTipsLayout coverTipsLayout = (CoverTipsLayout) this.b.findViewById(R.id.cover_tips_layout);
        this.E = (CoverWeatherLayout) this.b.findViewById(R.id.cover_weather_layout);
        this.c.a(this.E, coverTipsLayout);
        this.c.a(this.w);
        this.c.b(this.b);
        this.c.c(this.b);
        G();
        a();
        this.J = (FrameLayout) View.inflate(this.a, R.layout.battery_base_layout, null);
        this.ao = (BatteryChargeView) this.J.findViewById(R.id.layout_battery);
        this.ap = (BatteryChargeView) this.J.findViewById(R.id.layout_battery_little);
        this.ao.a(false, this);
        this.ap.a(true, this);
        this.I = this.b.findViewById(R.id.msg_shadow_bottom);
        this.I.setOnTouchListener(new aa(this));
        D();
        E();
        this.o.setOnLongClickListener(new ab(this));
        B();
        this.N = this.b.findViewById(R.id.unlock_edit_hint_view);
    }

    private void z() {
        if (!this.D.dr()) {
            this.N.setVisibility(0);
            this.N.clearAnimation();
            this.N.animate().alpha(1.0f).setDuration(200).setInterpolator(new LinearInterpolator()).setListener(null).start();
            this.G.removeCallbacks(this.S);
            this.G.postDelayed(this.S, 2000);
        }
    }

    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.b == null) {
            y();
            F();
            O();
            this.F.a(this.a, this.c, this.c.t(), this.c.u(), (ViewGroup) this.b.findViewById(R.id.camera_btn), (TextView) this.b.findViewById(R.id.camera_guide_desc_tv));
            this.r = true;
        }
        return this.b;
    }

    public void a() {
        this.c.d(this.o);
        this.c.d(this.p);
        if (this.y != null) {
            this.c.d(this.y);
        }
        if (this.H != null) {
            this.c.d(this.H);
        }
    }

    public void a(float f) {
        if (!(this.M == null || this.M.getVisibility() == 8)) {
            this.n = true;
            this.M.setAlpha(1.0f - (f / 200.0f));
            if (((double) this.M.getAlpha()) < 0.1d) {
                this.M.setVisibility(8);
            }
        }
        if (this.R != null) {
            this.R.a(f - 50.0f);
        }
    }

    public void a(String str, String str2) {
        if (this.r) {
            q();
            if (com.vlocker.locker.b.ap.a() == null || this.y == null) {
                this.o.setText(str);
                this.p.setText(str2);
                return;
            }
            this.y.a();
            if (this.H != null) {
                this.H.c();
            }
        }
    }

    public void a(boolean z) {
        this.P = z;
    }

    public void a_(int i) {
        if (i == 2) {
            this.O = false;
            this.am.k();
        } else if (i == 10) {
            c(0.0f);
        }
        n();
        if (this.w != null) {
            this.w.setAlpha(1.0f);
        }
        if (this.s != null) {
            this.s.setTranslationX(0.0f);
            this.s.setTranslationY(0.0f);
        }
        if (this.b != null) {
            this.b.setAlpha(1.0f);
        }
        C();
        if (BatteryChargeView.c && v() != null) {
            v().c();
        }
    }

    public void b() {
        this.a.unregisterReceiver(this.Q);
    }

    public void b(int i) {
        if (MusicLrcView.a && BatteryChargeView.c) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.al.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.topMargin = i;
                this.al.requestLayout();
                return;
            }
            return;
        }
        MsgListView msgListView = (MsgListView) this.w.findViewById(R.id.msg_list);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) msgListView.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.topMargin = i;
            msgListView.requestLayout();
        }
    }

    public boolean b(boolean z) {
        if (!s()) {
            return false;
        }
        if (!z) {
            if (f) {
                f = false;
                MsgListView.a = true;
                this.ao.b(this.ap);
            }
            return true;
        } else if (f || !com.vlocker.msg.p.a().h()) {
            return false;
        } else {
            f = true;
            MsgListView.a = false;
            this.ao.a(this.ap);
            return true;
        }
    }

    public void c() {
        if (g.b()) {
            f();
        }
    }

    public void c(int i) {
        MsgListView msgListView = (MsgListView) this.w.findViewById(R.id.msg_list);
        LayoutParams layoutParams = (MusicLrcView.a && BatteryChargeView.c) ? this.al.getLayoutParams() : msgListView.getLayoutParams();
        if (((LinearLayout.LayoutParams) layoutParams) != null) {
            ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{0, i - ((LinearLayout.LayoutParams) layoutParams).topMargin});
            ofInt.setDuration(300);
            ofInt.setInterpolator(new AccelerateDecelerateInterpolator());
            ofInt.addUpdateListener(new o(this, msgListView));
            ofInt.addListener(new p(this));
            ofInt.start();
        }
    }

    public void d(int i) {
        if (this.s != null) {
            this.s.setVisibility(i);
        }
    }

    public View e() {
        return this.F.b();
    }

    public void f() {
        y.a().b();
        if (this.C != null) {
            this.C.b();
        }
        this.c.n();
    }

    public void g() {
        if (BatteryChargeView.c && v() != null) {
            v().b();
        }
        this.a.sendBroadcast(new Intent("action_finish_unlock_edit_activity"));
    }

    public void h() {
        this.O = false;
        if (this.R != null) {
            this.R.a();
        }
        if (this.r) {
            n();
            this.F.c();
            C();
            l().setTranslationX(0.0f);
            l().setTranslationY(0.0f);
            l().setAlpha(1.0f);
            if (this.y != null) {
                this.K.setAlpha(1.0f);
            }
            this.b.setAlpha(1.0f);
            b((float) this.a.getResources().getDisplayMetrics().widthPixels);
            if (BatteryChargeView.c && v() != null) {
                v().c();
            }
        }
    }

    public void i() {
        boolean z;
        if (!y.a().d() || com.vlocker.msg.p.a().a(10)) {
            z = false;
        } else {
            y.a().a(2);
            y.a().b(false);
            z = true;
        }
        if (!(!y.a().e() || com.vlocker.msg.p.a().a(10) || r0)) {
            y.a().a(3);
            y.a().b(false);
        }
        if (BatteryChargeView.c && v() != null) {
            v().b();
            if (com.vlocker.msg.p.a().i() && !f && s()) {
                this.G.postDelayed(new d(this), 500);
            }
        }
        if (this.al != null && MusicLrcView.a) {
            this.al.c();
        }
        if (this.D.cH() == -1) {
            this.D.ab(0);
        } else if (this.D.cH() == 0) {
            if (!(this.D.cG() || this.M == null || !this.D.cJ())) {
                this.M.setVisibility(0);
                com.vlocker.b.p.a(this.a, "Vlock_PullDown_Guide_Search_PPC_TF", new String[0]);
            }
            this.D.ab(1);
        } else if (this.D.cH() == 1) {
            if (!(this.D.cG() || this.M == null || !this.D.cJ())) {
                this.M.setVisibility(0);
            }
            this.D.ab(2);
        } else if (this.D.cH() == 2) {
        }
        if (this.M != null && this.M.getVisibility() != 8 && this.R != null) {
            this.R.setIsGuide(true);
        } else if (this.R != null) {
            this.R.setIsGuide(false);
        }
        if (this.N != null && com.vlocker.m.h.e() && this.D.dq() < 2) {
            this.D.ak(this.D.dq() + 1);
            z();
        }
    }

    public void j() {
        if (this.C != null) {
            this.C.b();
        }
    }

    public boolean k() {
        return this.C != null ? this.C.d() : false;
    }

    public View l() {
        return h.b == 1 ? this.B : h.b == 2 ? this.s : (com.vlocker.locker.b.ap.a() == null || com.vlocker.locker.b.ap.a().u == null || com.vlocker.locker.b.ap.a().u.i == null) ? this.u : this.t;
    }

    public void m() {
        if (this.u != null && this.u.getVisibility() == 0) {
            this.u.b();
        }
        if (this.t != null && this.t.getVisibility() == 0) {
            this.t.a(h.g, h.a);
        }
    }

    public void n() {
        if (this.u != null && this.u.getVisibility() == 0) {
            this.u.c();
        }
        if (this.t != null && this.t.getVisibility() == 0) {
            this.t.a();
        }
    }

    public void o() {
        this.ai = true;
        if (BatteryChargeView.c) {
            c(true);
        }
        if (BatteryChargeView.c && f && !com.vlocker.msg.p.a().h()) {
            b(false);
        }
        if (!this.at) {
            M();
        }
    }

    public void p() {
        this.ai = false;
        c(false);
        if (BatteryChargeView.c && f) {
            b(false);
        }
        if (!this.am.l() && !this.at) {
            N();
        }
    }

    public void q() {
        if (v() == null || !this.D.bX() || System.currentTimeMillis() <= this.D.bZ()) {
            if (v() != null && BatteryChargeView.c) {
                u();
            }
            BatteryChargeView.c = false;
        } else if (com.vlocker.locker.b.ap.a() != null && !P()) {
            this.an = true;
            if (v() != null && BatteryChargeView.c) {
                u();
            }
            BatteryChargeView.c = false;
        } else if (com.vlocker.battery.saver.a.b) {
            r();
            this.ap.a(com.vlocker.battery.saver.a.a, e.a(com.vlocker.battery.saver.a.c, com.vlocker.battery.saver.a.a));
            this.ao.a(com.vlocker.battery.saver.a.a, e.a(com.vlocker.battery.saver.a.c, com.vlocker.battery.saver.a.a));
        } else if (BatteryChargeView.c) {
            u();
        }
    }

    public void r() {
        if (!this.O && !BatteryChargeView.c) {
            if (System.currentTimeMillis() - this.D.ca() > 86400000) {
                this.D.m(System.currentTimeMillis());
                com.vlocker.b.p.a(this.a, "Vlocker_Sum_Charge_Battery_PPC_TF", new String[0]);
            }
            if (!(com.vlocker.locker.b.ap.a() == null || this.aq)) {
                this.y.setVisibility(4);
                this.H.setVisibility(0);
            }
            S();
            if (this.w != null) {
                LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                this.w.removeView(this.J);
                this.w.addView(this.J, 0, layoutParams);
            }
            BatteryChargeView.c = true;
            if (!(g.c() || g.d()) || this.D.i()) {
                this.c.a(0.0f, false, 500);
                this.c.a(1.0f, true, 500);
            }
            c(true);
            if (this.aj) {
                N();
            }
            if (!v().equals(this.ao) || com.vlocker.msg.p.a().h()) {
                this.ap.setVisibility(0);
                this.ap.a();
                if (MusicLrcView.a && this.al != null) {
                    this.al.b(true);
                }
                com.vlocker.msg.p.a().k();
                if (com.vlocker.msg.p.a().h()) {
                    f = true;
                    W();
                    this.G.postDelayed(new m(this), 50);
                    this.ao.setMiniViewStatus(this.ap);
                    return;
                }
                X();
                return;
            }
            W();
            MsgListView.a = true;
            this.G.postDelayed(new l(this), 50);
        }
    }

    public boolean s() {
        return this.ao != null ? this.ao.equals(v()) : false;
    }

    public void t() {
        if (MusicLrcView.a) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.al.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.topMargin = 0;
                this.al.requestLayout();
            }
        }
        MsgListView msgListView = (MsgListView) this.w.findViewById(R.id.msg_list);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) msgListView.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.topMargin = 0;
            msgListView.requestLayout();
        }
    }

    public void u() {
        if ((g.b() && (this.c == null || !this.c.m())) || ((g.c() || g.d()) && !this.D.i())) {
            this.c.a(0.0f, true, 500);
            c(false);
        }
        if (f.e && ((g.c() || g.d()) && !this.D.i())) {
            this.c.a(1.0f, false, 500);
        }
        f = false;
        BatteryChargeView.c = false;
        MsgListView.a = false;
        this.ao.e();
        this.ao.setVisibility(8);
        this.ap.setVisibility(8);
        if (this.w != null) {
            this.w.removeView(this.J);
            System.gc();
        }
        V();
        if (MusicLrcView.a && this.al != null) {
            this.al.b(false);
        }
        if (com.vlocker.locker.b.ap.a() != null) {
            if (MusicLrcView.a || this.ai) {
                this.y.setVisibility(0);
                this.H.setVisibility(4);
                this.y.setAlpha(0.0f);
                Y();
                this.G.postDelayed(new q(this), 1);
            } else {
                this.y.setVisibility(0);
                this.H.setVisibility(4);
                Y();
            }
        }
        com.vlocker.msg.p.a().k();
    }

    public BatteryChargeView v() {
        if (com.vlocker.locker.b.ap.a() == null) {
            return this.ao;
        }
        if (this.au == 0.0f) {
            S();
        }
        if (this.ar == 0) {
            Q();
        }
        if (this.ar <= 0 || this.au <= 0.0f || this.H == null || this.y == null) {
            this.an = true;
            return null;
        }
        int a = this.H.getLayoutParams().height + l.a(25.0f);
        if (((float) (this.ar - (this.y.getLayoutParams().height + l.a(25.0f)))) >= this.au) {
            this.aq = true;
            return this.ao;
        } else if (((float) (this.ar - a)) >= this.au) {
            this.aq = false;
            return this.ao;
        } else {
            f = true;
            this.aq = false;
            return this.ap;
        }
    }

    public void w() {
        a(1000);
        if (this.an && this.D.bX()) {
            this.an = false;
            this.G.postDelayed(new r(this), 150);
        }
        if (this.av && this.D.bX()) {
            this.G.postDelayed(new s(this), 200);
        }
    }

    public void x() {
        this.G.postDelayed(new y(this), 500);
    }
}
