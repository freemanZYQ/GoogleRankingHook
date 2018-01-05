package com.vlocker.weather;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.vlocker.locker.R;
import com.vlocker.locker.c.ax;
import com.vlocker.search.x;
import com.vlocker.ui.cover.g;
import com.vlocker.ui.view.SearchShimmerTextView;
import com.vlocker.weather.a.ad;
import com.vlocker.weather.a.ah;
import com.vlocker.weather.a.ar;
import com.vlocker.weather.a.at;
import com.vlocker.weather.a.aw;
import com.vlocker.weather.a.f;
import com.vlocker.weather.a.h;
import com.vlocker.weather.a.j;
import com.vlocker.weather.a.q;
import com.vlocker.weather.a.v;
import com.vlocker.weather.a.y;
import com.vlocker.weather.bean.MXWeatherBean;
import com.vlocker.weather.c.d.c;
import com.vlocker.weather.model.MXWeatherWidget;
import com.vlocker.weather.view.OverScrollView;
import com.vlocker.weather.view.d;
import com.vlocker.weather.view.l;
import com.vlocker.weather.view.m;
import java.util.ArrayList;
import java.util.Calendar;
import org.json.JSONObject;

public class a implements d, l, m {
    public static boolean b = true;
    public static boolean c = false;
    public static boolean d;
    public static boolean e;
    private ah A;
    private y B;
    private View C;
    private com.vlocker.weather.a.m D;
    private q E;
    private ad F;
    private Long G;
    private OverScrollView H;
    private int I;
    private Handler J = new Handler();
    private m K;
    private boolean L = true;
    public TextView a;
    SearchShimmerTextView f;
    String g;
    private Context h;
    private View i;
    private com.vlocker.weather.d.a j;
    private ax k;
    private LinearLayout l;
    private RelativeLayout m;
    private RelativeLayout n;
    private RelativeLayout o;
    private TextView p;
    private int q;
    private r r;
    private f s;
    private aw t;
    private com.vlocker.weather.a.a u;
    private j v;
    private h w;
    private ar x;
    private at y;
    private v z;

    public a(Context context, ax axVar, View view) {
        this.i = view;
        this.h = context;
        this.k = axVar;
        this.j = new com.vlocker.weather.d.a(this.h, this);
        this.r = new r(context);
        if (d) {
            this.K = new m();
            this.h.registerReceiver(this.K, new IntentFilter("action_weather_open_news_post"));
        }
        a();
    }

    private void C() {
        this.l = (LinearLayout) this.i.findViewById(R.id.weatherlayout);
        D();
        this.p = (TextView) this.i.findViewById(R.id.pull_to_refresh_text);
        this.o = (RelativeLayout) this.i.findViewById(R.id.pull_to_refresh_header);
        this.a = (TextView) this.i.findViewById(R.id.weather_currentcity);
        this.m = (RelativeLayout) this.i.findViewById(R.id.weatherallbg);
        this.n = (RelativeLayout) this.i.findViewById(R.id.weathercontent);
        this.C = this.i.findViewById(R.id.switch_baidusb_view);
        this.f = (SearchShimmerTextView) this.i.findViewById(R.id.switch_baidusb_et);
        if (VERSION.SDK_INT >= 19) {
            this.n.setPadding(0, com.vlocker.m.h.d(this.h), 0, 0);
        } else if (com.vlocker.c.a.a(this.h).ai() != 0) {
            this.n.setPadding(0, com.vlocker.m.h.d(this.h), 0, 0);
        }
        if (VERSION.SDK_INT == 19) {
            this.m.setFitsSystemWindows(true);
        }
        this.H = (OverScrollView) this.i.findViewById(R.id.scrollview);
        this.H.setOnScrollListener(this);
        try {
            this.H.setOverScrollMode(2);
        } catch (Exception e) {
        } catch (NoSuchMethodError e2) {
        }
        this.H.setOverScrollListener(this);
        this.H.a(this.o, this.p);
        this.o.setVisibility(0);
        this.I = (int) this.h.getResources().getDimension(R.dimen.t_market_slidingmenu_offset);
        LayoutParams layoutParams = (LayoutParams) this.o.getLayoutParams();
        layoutParams.topMargin = -this.I;
        this.o.setLayoutParams(layoutParams);
    }

    private void D() {
        this.v = new j(this.h, this.i);
        this.B = new y(this.h, this);
        this.A = new ah(this.h, this, this.i);
        this.u = new com.vlocker.weather.a.a(this.h, this, this.i);
        this.z = new v(this.h, this, this.v.a());
        this.w = new h(this.h, this.v.a());
        this.s = new f(this.h, this.i);
        this.x = new ar(this.h, this.v.a());
        this.F = new ad(this.h, this, this.i);
        this.D = new com.vlocker.weather.a.m(this.h, this, this.v.a());
        if (d) {
            this.E = new q(this.h, this, this.i);
            return;
        }
        this.y = new at(this.h, this, this.i);
        this.t = new aw(this.h, this, this.i);
    }

    private void E() {
        this.H.e = false;
        this.p.setText("刷新失败");
        this.H.a();
    }

    private void F() {
        l();
        this.C.setOnClickListener(new d(this));
        this.C.findViewById(R.id.switch_baidusb_button).setOnClickListener(new e(this));
        this.s.b().setOnClickListener(new f(this));
        this.s.a().setOnClickListener(new g(this));
        this.a.setOnClickListener(new h(this));
    }

    private void G() {
        if (this.w.c() != null && this.C != null) {
            int[] iArr = new int[2];
            this.C.getLocationOnScreen(iArr);
            int height = (iArr[1] + this.C.getHeight()) + this.C.getPaddingBottom();
            int[] iArr2 = new int[2];
            this.w.c().getLocationOnScreen(iArr2);
            int i = iArr2[1];
            if (i > height) {
                c(i - height);
            }
        }
    }

    private void H() {
        if (!d || !this.H.b() || !this.E.d || this.E.a() == null || this.E.a().getVisibility() != 0 || !this.H.i) {
            return;
        }
        if (this.E.e) {
            q.b = true;
            this.E.j();
            this.H.i = false;
            return;
        }
        this.E.d();
    }

    private void I() {
        boolean z = true;
        if (this.E != null && d) {
            int[] iArr = new int[2];
            this.E.a().getLocationOnScreen(iArr);
            if (iArr[1] >= this.h.getResources().getDisplayMetrics().heightPixels) {
                z = false;
            }
            e = z;
        }
    }

    public static synchronized void a(Context context) {
        synchronized (a.class) {
            if (context != null) {
                if (b) {
                    b = false;
                    com.vlocker.weather.e.d.a(context);
                    ah.a(context);
                }
            }
        }
    }

    private void c(int i) {
        int scrollY = this.H.getScrollY();
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i});
        ofInt.addUpdateListener(new l(this, scrollY));
        ofInt.setInterpolator(new q());
        ofInt.setDuration(1000);
        ofInt.start();
    }

    private void c(String str) {
        try {
            this.J.postDelayed(new b(this), 700);
            b();
            try {
                this.B.a(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
            d();
            this.n.setVisibility(0);
            if (d && System.currentTimeMillis() - this.E.f > 10800000) {
                this.E.a(false);
            }
        } catch (Exception e2) {
        }
    }

    public void A() {
        if (this.E != null && d) {
            this.E.p();
        }
    }

    public void B() {
        if (this.E != null && d) {
            this.E.a(true);
        }
    }

    protected void a() {
        C();
        o();
        b();
        F();
    }

    public void a(int i) {
        if (this.r != null) {
            this.r.a(this, i);
        }
    }

    public void a(int i, int i2, int i3, int i4) {
        H();
        I();
        try {
            this.J.removeMessages(1010);
            if (!y.c && c) {
                y.c = this.B.e();
            }
            if (d) {
                if (e && g.a()) {
                    c.a().c().a();
                }
                if (!q.b && c) {
                    q.b = this.E.f();
                }
                if (!q.b) {
                    this.E.o();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(int i, Runnable runnable) {
        this.k.a(i, runnable);
    }

    public void a(Intent intent) {
        this.j.a(this.h, intent);
    }

    public void a(View view, boolean z) {
        try {
            ViewGroup.LayoutParams layoutParams = new LayoutParams(-1, -2);
            layoutParams.topMargin = com.vlocker.m.l.a(this.h, 10.0f);
            if (z) {
                layoutParams.bottomMargin = com.vlocker.m.l.a(this.h, 10.0f);
            }
            this.l.addView(view, layoutParams);
        } catch (Exception e) {
        }
    }

    public void a(String str) {
        c(str);
    }

    public void a(boolean z) {
        this.B.a(z);
        this.F.a();
    }

    public void a(boolean z, boolean z2) {
        if (z2) {
            this.A.a(z);
        } else {
            this.A.b(z);
        }
        if (!d) {
            if (z) {
                this.y.b();
            } else {
                this.y.c();
            }
        }
    }

    public void b() {
        Log.e("liu---", "reflesh");
        if (com.vlocker.weather.e.j.d(this.h) && !com.vlocker.c.a.a(this.h).H()) {
            j();
            this.G = com.vlocker.theme.f.a.b("weathercurrenttime", this.h);
            Calendar instance = Calendar.getInstance();
            instance.setTimeInMillis(this.G.longValue());
            int i = instance.get(6);
            if (i == Calendar.getInstance().get(6)) {
                try {
                    com.vlocker.theme.f.a.a("isrefreshbotton", Boolean.valueOf(true), this.h);
                } catch (Exception e) {
                    return;
                }
            }
            JSONObject jSONObject = new JSONObject(com.vlocker.theme.f.a.a("tempdata", this.h));
            ArrayList arrayList = new ArrayList();
            MXWeatherBean mXWeatherBean = new MXWeatherBean();
            this.j.a(jSONObject, arrayList, mXWeatherBean);
            this.a.setText(jSONObject.getString("city_name"));
            this.s.a(jSONObject, i);
            this.u.a(jSONObject, i);
            this.z.a(mXWeatherBean.a);
            this.x.a(arrayList);
            if (!d) {
                this.y.a(jSONObject, i);
                this.t.a(jSONObject, i);
            }
            this.w.a(jSONObject, i);
            this.A.b();
            this.v.b();
            this.k.a();
            Editor edit = this.h.getSharedPreferences(MXWeatherWidget.WEATHER_CONFIG, 0).edit();
            edit.putLong(MXWeatherWidget.WEATHER_CONFIG_GET_TIME, System.currentTimeMillis());
            edit.commit();
            if (com.vlocker.m.h.f()) {
                this.D.b();
            }
        }
    }

    public void b(int i) {
        if (this.E != null && g.a()) {
            this.E.h();
        }
        l();
        if (this.D != null) {
            this.D.a(false);
        }
    }

    public void b(String str) {
        if (!TextUtils.isEmpty(str) && com.vlocker.weather.e.j.d(this.h) && g.a) {
            this.k.e();
            try {
                this.u.a(new JSONObject(str).optString("id"));
            } catch (Exception e) {
            }
        }
    }

    public void b(boolean z) {
        int i = Calendar.getInstance().get(11);
        this.E.a(false);
        if (z) {
            this.H.setHeaderTopMargin(0);
            Boolean c = com.vlocker.theme.f.a.c("isrefreshnow", this.h);
            boolean b = com.vlocker.weather.e.j.b(this.h);
            if ((c.booleanValue() || b) && com.vlocker.b.j.i(this.h)) {
                c();
                return;
            }
            this.J.postDelayed(new j(this), 1800);
            if (this.q != i) {
                this.q = i;
                m();
                return;
            }
            return;
        }
        this.H.setHeaderTopMargin(0);
        if (this.q != i) {
            this.q = i;
            m();
        }
        this.J.postDelayed(new k(this), 600);
    }

    public void c() {
        this.j.a(this.h);
    }

    public void d() {
        if (this.F != null) {
            this.F.b();
        }
    }

    public void e() {
        this.B.g();
    }

    public void f() {
        this.F.d();
    }

    public void g() {
        try {
            this.l.removeAllViews();
            this.l = null;
            this.j.b();
            this.j = null;
            if (d) {
                this.h.unregisterReceiver(this.K);
            } else {
                this.y.c();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void h() {
        E();
    }

    public void i() {
        this.A.c();
        this.B.c();
        this.F.c();
        if (!d) {
            this.y.d();
        }
    }

    public void j() {
        try {
            this.l.removeAllViews();
            a(this.u.a(), false);
            a(this.v.a(), false);
            a(this.D.a(), false);
            this.B.a("1030_2");
            a(this.B.a(), false);
            if (d) {
                a(this.E.a(), false);
                return;
            }
            a(this.y.a(), false);
            a(this.t.a(), true);
        } catch (Exception e) {
        }
    }

    public long k() {
        return (!d || this.E == null) ? 0 : this.E.f;
    }

    public void l() {
        if (this.r != null) {
            com.moxiu.b.a.a a = x.a(this.h).a("from_search_edit");
            if (a != null) {
                this.g = a.c();
                if (!TextUtils.isEmpty(this.g) && this.C != null) {
                    ((TextView) this.C.findViewById(R.id.switch_baidusb_et)).setText(this.g);
                    a.b(this.C);
                }
            }
        }
    }

    public void m() {
        if (com.vlocker.theme.f.a.c("isrefreshnow", this.h).booleanValue()) {
            b();
        }
        if (!com.vlocker.m.h.f()) {
            this.D.b();
        }
        if (VERSION.SDK_INT < 19 && this.n != null && com.vlocker.c.a.a(this.h).ai() != 0) {
            this.n.setPadding(0, com.vlocker.m.h.d(this.h), 0, 0);
        }
    }

    public void n() {
        this.A.d();
    }

    public void o() {
        long j = this.h.getSharedPreferences(MXWeatherWidget.WEATHER_CONFIG, 0).getLong(MXWeatherWidget.WEATHER_CONFIG_GET_TIME, 0);
        long currentTimeMillis = System.currentTimeMillis() - j;
        int intValue = new Long(currentTimeMillis / 86400000).intValue();
        int intValue2 = new Long(currentTimeMillis / 3600000).intValue();
        int intValue3 = new Long(currentTimeMillis / 60000).intValue();
        if (j <= 0) {
            this.p.setText("");
        } else if (intValue > 0) {
            com.vlocker.theme.f.a.a("isrefreshnow", Boolean.valueOf(true), this.h);
            this.p.setText(intValue + "天前更新");
        } else if (intValue2 > 0) {
            com.vlocker.theme.f.a.a("isrefreshnow", Boolean.valueOf(true), this.h);
            this.p.setText(intValue2 + "小时前更新");
        } else if (intValue3 > 0) {
            com.vlocker.theme.f.a.a("isrefreshnow", Boolean.valueOf(false), this.h);
            this.p.setText(intValue3 + "分钟前更新");
        } else {
            com.vlocker.theme.f.a.a("isrefreshnow", Boolean.valueOf(false), this.h);
            this.p.setText("刚刚更新");
        }
    }

    public void p() {
        H();
    }

    public void q() {
    }

    public void r() {
        try {
            if (this.H != null) {
                this.H.post(new c(this));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void s() {
        if (this.L) {
            y yVar = this.B;
            y.b = false;
            boolean booleanValue = com.vlocker.theme.f.a.c("isrefreshbotton", this.h).booleanValue();
            this.G = com.vlocker.theme.f.a.b("weathercurrenttime", this.h);
            Calendar instance = Calendar.getInstance();
            instance.setTimeInMillis(this.G.longValue());
            int i = instance.get(6);
            if (!booleanValue) {
                try {
                    com.vlocker.theme.f.a.a("isrefreshbotton", Boolean.valueOf(true), this.h);
                    JSONObject jSONObject = new JSONObject(com.vlocker.theme.f.a.a("tempdata", this.h));
                    if (!d) {
                        this.y.a(jSONObject, i);
                        this.t.a(jSONObject, i);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            this.A.b();
            this.B.d();
            this.r.b();
            I();
            if (d) {
                this.E.g();
            }
            if (this.D != null) {
                this.D.a(true);
            }
        }
    }

    public void t() {
    }

    public void u() {
        if (this.D != null) {
            this.D.c();
        }
    }

    public void v() {
        this.H.c = 0;
    }

    public int w() {
        return this.H.c;
    }

    public void x() {
        if (d) {
            I();
            this.E.h();
        }
    }

    public boolean y() {
        return this.E != null && d && this.E.i();
    }

    public void z() {
        this.H.i = true;
    }
}
