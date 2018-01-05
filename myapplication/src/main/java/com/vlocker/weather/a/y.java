package com.vlocker.weather.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.moxiu.b.a.a;
import com.vlocker.b.j;
import com.vlocker.b.p;
import com.vlocker.locker.R;
import com.vlocker.m.h;
import com.vlocker.m.l;
import com.vlocker.theme.f.e;
import com.vlocker.theme.imageloader.RecyclingImageView;
import com.vlocker.ui.cover.g;
import com.vlocker.ui.view.AdTagView;
import com.vlocker.weather.e.d;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class y extends ag implements OnClickListener {
    public static String A = "close_time";
    public static String B = "isShowAD";
    public static String C = "MAD_MARK";
    public static boolean b;
    public static boolean c;
    public static String z = "closeAD";
    private Context D;
    private List E;
    private a F;
    private LinearLayout G;
    private long H = 0;
    private int I = 0;
    private final long J = 60000;
    private com.vlocker.weather.a K;
    private Handler L = new z(this);
    public float a;
    int d;
    public String e = "";
    LinearLayout f;
    RelativeLayout g;
    RelativeLayout h;
    RelativeLayout i;
    RecyclingImageView j;
    RecyclingImageView k;
    TextView l;
    LinearLayout m;
    AdTagView n;
    RelativeLayout o;
    TextView p;
    TextView q;
    TextView r;
    TextView s;
    TextView t;
    RecyclingImageView u;
    RecyclingImageView v;
    TextView w;
    TextView x;
    long y = 0;

    public y(Context context, com.vlocker.weather.a aVar) {
        this.D = context;
        this.K = aVar;
        a(null);
        b();
        if (h.e()) {
            f();
        }
    }

    public static int a(Date date, Date date2) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        Calendar instance2 = Calendar.getInstance();
        instance2.setTime(date2);
        instance2.set(11, 0);
        instance2.set(12, 0);
        instance2.set(13, 0);
        instance2.set(14, 0);
        return (int) ((instance2.getTime().getTime() - instance.getTime().getTime()) / 86400000);
    }

    private void a(BitmapDrawable bitmapDrawable) {
        DisplayMetrics displayMetrics = this.D.getResources().getDisplayMetrics();
        this.d = displayMetrics.heightPixels;
        int i = displayMetrics.widthPixels;
        float f = 1.9f;
        if (!(this.k == null || bitmapDrawable == null)) {
            f = ((float) bitmapDrawable.getBitmap().getWidth()) / ((float) bitmapDrawable.getBitmap().getHeight());
        }
        this.a = ((float) (i - l.a(40.0f))) / f;
        if (this.k != null) {
            LayoutParams layoutParams = (LayoutParams) this.k.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = (int) this.a;
            this.k.setLayoutParams(layoutParams);
        }
    }

    private void a(RecyclingImageView recyclingImageView) {
        if (recyclingImageView != null && recyclingImageView.getVisibility() == 0 && !TextUtils.isEmpty(recyclingImageView.getImageUrl()) && recyclingImageView.getDrawable() == null) {
            recyclingImageView.c(recyclingImageView.getImageUrl(), 2, 0);
        }
    }

    private void b(boolean z) {
        int i = 0;
        this.h.setVisibility(z ? 0 : 8);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.i.getLayoutParams();
        if (!z) {
            i = l.a(10.0f);
        }
        layoutParams.topMargin = i;
        this.i.setLayoutParams(layoutParams);
    }

    private void h() {
        new com.b.b.a(this.D).a(com.b.d.a.b(this.D, "vweather_detail"), 10, new ab(this)).a();
    }

    private void i() {
        try {
            if (j.i(this.D)) {
                String r;
                this.G.setVisibility(0);
                this.G.setOnClickListener(this);
                if ("1".equals(this.F.E)) {
                    this.f.setVisibility(0);
                    this.g.setVisibility(8);
                    b(true);
                    this.o.setVisibility(0);
                    this.l.setVisibility(0);
                    this.m.setVisibility(8);
                    this.n.setVisibility(0);
                    if (TextUtils.isEmpty(this.F.r())) {
                        this.n.setVisibility(8);
                    } else {
                        r = this.F.r();
                        try {
                            if (this.F.r().length() > 4) {
                                r = new BigDecimal((double) (((float) Integer.parseInt(this.F.r())) / 10000.0f)).setScale(1, RoundingMode.HALF_UP).toString() + "W";
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        this.n.setText("月销" + r + "件");
                    }
                    if (!TextUtils.isEmpty(this.F.q())) {
                        this.q.setText("￥" + this.F.q());
                    }
                    if (!TextUtils.isEmpty(this.F.p())) {
                        this.s.setText("￥" + this.F.p());
                        this.r.setText("原价:");
                    }
                    if (TextUtils.isEmpty(this.F.h())) {
                        b(false);
                    } else {
                        this.p.setText(this.F.h());
                    }
                    this.t.setText(this.F.c());
                    if (TextUtils.isEmpty(this.F.h())) {
                        b(false);
                    } else {
                        this.j.c(this.F.b(), 2, 0);
                        this.j.setIsCircle(true);
                    }
                    this.k.c(this.F.d(), 2, 0);
                }
                if ("0".equals(this.F.E)) {
                    if (e.b(this.D).booleanValue()) {
                        this.f.setVisibility(0);
                        this.g.setVisibility(8);
                        this.o.setVisibility(8);
                        this.n.setVisibility(8);
                        if (!this.F.f() || TextUtils.isEmpty(this.F.b()) || TextUtils.isEmpty(this.F.h())) {
                            b(false);
                        } else {
                            b(true);
                            this.l.setVisibility(8);
                            this.m.setVisibility(0);
                        }
                        this.p.setText(this.F.h());
                        this.t.setText(this.F.c());
                        this.j.c(this.F.b(), 2, 0);
                        this.j.setIsCircle(true);
                        this.k.c(this.F.d(), 2, 0);
                    } else {
                        this.f.setVisibility(8);
                        this.g.setVisibility(0);
                        this.n.setVisibility(8);
                        this.w.setText(this.F.h());
                        this.x.setText(this.F.c());
                        r = this.F.b();
                        if (TextUtils.isEmpty(this.F.b())) {
                            r = this.F.d();
                        }
                        this.v.c(r, 2, 0);
                        this.v.setIsCircle(true);
                    }
                }
                if (TextUtils.isEmpty(this.F.w())) {
                    this.u.setVisibility(8);
                } else {
                    this.u.a(this.F.w(), 2, 0);
                    this.u.setVisibility(0);
                }
                this.G.setVisibility(0);
                return;
            }
            this.G.setVisibility(8);
        } catch (Exception e2) {
            e2.printStackTrace();
            this.G.setVisibility(8);
        }
    }

    private void j() {
        try {
            switch (this.F.e()) {
                case 8:
                    if (g.a) {
                        e.a(this.D, this.F.h() + " " + "下载完成,请解锁安装~", 0);
                        return;
                    } else {
                        e.a(this.D, this.F.h() + " " + "下载完成,可以安心使用了~", 0);
                        return;
                    }
                default:
                    return;
            }
        } catch (Exception e) {
        }
    }

    private void k() {
        try {
            if (!c) {
                c = e();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public View a() {
        return this.G;
    }

    public void a(String str) {
        this.e = str;
    }

    public void a(boolean z) {
        try {
            if ("100C".equals(Build.MODEL) || !h.e()) {
                this.G.setVisibility(8);
            } else if (z || System.currentTimeMillis() - this.H > 60000) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.y > 60000) {
                    h();
                    d.a(this.D, this.e);
                    this.y = currentTimeMillis;
                }
            } else {
                this.I++;
                if (this.I >= this.E.size()) {
                    this.I = 0;
                }
                this.F = (a) this.E.get(this.I);
                this.F.a(false);
            }
        } catch (Exception e) {
            this.G.setVisibility(8);
        }
    }

    public void b() {
        this.G = (LinearLayout) LayoutInflater.from(this.D).inflate(R.layout.weather_ad_card_poster, null);
        this.G.setVisibility(8);
        this.f = (LinearLayout) this.G.findViewById(R.id.ad_container_wifi);
        this.g = (RelativeLayout) this.G.findViewById(R.id.ad_container_net);
        this.i = (RelativeLayout) this.G.findViewById(R.id.large_ad_img_layout);
        this.h = (RelativeLayout) this.G.findViewById(R.id.large_ad_title_layout);
        this.i = (RelativeLayout) this.G.findViewById(R.id.large_ad_img_layout);
        this.j = (RecyclingImageView) this.G.findViewById(R.id.large_ad_icon);
        this.k = (RecyclingImageView) this.G.findViewById(R.id.large_ad_img);
        this.l = (TextView) this.G.findViewById(R.id.ds_btn_desc);
        this.m = (LinearLayout) this.G.findViewById(R.id.app_btn_desc);
        this.n = (AdTagView) this.G.findViewById(R.id.large_poster_sell_tag);
        this.o = (RelativeLayout) this.G.findViewById(R.id.large_poster_shadow);
        this.p = (TextView) this.G.findViewById(R.id.large_ad_title);
        this.q = (TextView) this.G.findViewById(R.id.large_poster_price);
        this.r = (TextView) this.G.findViewById(R.id.large_poster_strike_desc_title);
        this.s = (TextView) this.G.findViewById(R.id.large_poster_strike_desc);
        this.t = (TextView) this.G.findViewById(R.id.large_ad_desc);
        this.u = (RecyclingImageView) this.G.findViewById(R.id.large_ad_label);
        this.v = (RecyclingImageView) this.G.findViewById(R.id.small_ad_icon);
        this.x = (TextView) this.G.findViewById(R.id.small_ad_desc);
        this.w = (TextView) this.G.findViewById(R.id.small_ad_title);
        this.s.getPaint().setFlags(16);
        this.k.setiImageResult(new aa(this));
    }

    public void c() {
        a(this.j);
        if (this.j != null) {
            this.j.setIsCircle(true);
        }
        a(this.k);
        a(this.v);
        if (this.v != null) {
            this.v.setIsCircle(true);
        }
    }

    public void d() {
        if (this.G != null) {
            if (this.F != null) {
                i();
            } else {
                this.G.setVisibility(8);
            }
        }
    }

    public synchronized boolean e() {
        boolean z = false;
        synchronized (this) {
            try {
                if (this.G != null) {
                    if (!(this.G.getWidth() == 0 || this.G.getHeight() == 0)) {
                        int height = this.K.a != null ? this.K.a.getHeight() : 0;
                        int[] iArr = new int[2];
                        int[] iArr2 = new int[2];
                        int[] iArr3 = new int[2];
                        this.G.getLocationOnScreen(iArr3);
                        if (iArr3[1] != 0) {
                            iArr[1] = iArr3[1];
                            iArr2[1] = (iArr3[1] + this.G.getHeight()) - height;
                            if (((iArr3[1] > 0 && iArr[1] - this.d < 0) || (iArr3[1] < height && iArr2[1] > 0)) && this.G.getVisibility() == 0) {
                                if (!(TextUtils.isEmpty(this.e) || TextUtils.isEmpty(this.F.m()) || TextUtils.isEmpty(this.F.n()))) {
                                    d.c(this.D, this.e, this.F.m(), this.F.n());
                                }
                                this.F.b(this.G);
                                p.a(this.D, "Weather(V)_Hdw_Adshow_LYM", "referer", this.F.n(), "name", this.F.m(), "id", this.F.B);
                                z = true;
                            }
                        }
                    }
                }
            } catch (Exception e) {
            }
        }
        return z;
    }

    public void f() {
        SharedPreferences sharedPreferences = this.D.getSharedPreferences(z, 0);
        if (sharedPreferences.getBoolean(B, true)) {
            a(true);
            return;
        }
        if (a(new Date(Long.valueOf(sharedPreferences.getLong(A, 0)).longValue()), new Date(System.currentTimeMillis())) > 2) {
            Editor edit = sharedPreferences.edit();
            edit.putBoolean(B, true);
            edit.commit();
            a(true);
        }
    }

    public void g() {
        this.L.sendEmptyMessageDelayed(1010, 1000);
    }

    public void onClick(View view) {
        try {
            com.vlocker.b.a.a(this.D, this.F, this.G, "weather", this.K, true, new ac(this));
            if (!(b || TextUtils.isEmpty(this.e))) {
                d.b(this.D, this.e, this.F.m(), this.F.n());
                b = true;
            }
            p.a(this.D, "Weather(V)_Hdw_Adclick_LYM", "referer", this.F.n(), "name", this.F.m(), "id", this.F.B);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
