package com.vlocker.weather.a;

import android.content.Context;
import android.os.Handler;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import android.widget.TextView;
import com.vlocker.b.j;
import com.vlocker.locker.R;
import com.vlocker.m.h;
import com.vlocker.msg.ak;
import com.vlocker.msg.p;
import com.vlocker.ui.cover.g;
import com.vlocker.ui.widget.ag;
import com.vlocker.weather.c.a.a;
import com.vlocker.weather.c.a.e;
import com.vlocker.weather.c.d.b;
import com.vlocker.weather.c.d.c;
import com.vlocker.weather.e.d;
import com.vlocker.weather.e.f;
import com.vlocker.weather.view.v;
import java.util.ArrayList;
import java.util.Collection;

public class q extends ag implements e, b {
    public static boolean b = false;
    private long A;
    public v a;
    public ViewGroup c;
    public boolean d;
    public boolean e;
    public long f;
    private View g;
    private a h;
    private Context i;
    private ArrayList j = new ArrayList();
    private ArrayList k = new ArrayList();
    private ListView l;
    private com.vlocker.weather.c.d.a m;
    private com.vlocker.weather.a n;
    private f o;
    private int p;
    private com.vlocker.c.a q;
    private View r;
    private TextView s;
    private long t;
    private Handler u;
    private boolean v;
    private boolean w;
    private SpannableString x;
    private OnScrollListener y = new u(this);
    private boolean z;

    public q(Context context, com.vlocker.weather.a aVar, View view) {
        this.i = context;
        this.n = aVar;
        this.c = (ViewGroup) view;
        this.u = new Handler();
        this.q = com.vlocker.c.a.a(this.i);
        this.p = this.i.getResources().getDisplayMetrics().heightPixels - h.d(this.i);
        this.g = View.inflate(this.i, R.layout.weather_news_card_layout, null);
        r();
        t();
        s();
        v();
    }

    private void A() {
        com.vlocker.weather.c.c.b bVar = (com.vlocker.weather.c.c.b) this.k.get(0);
        ak akVar = new ak();
        akVar.C = 12;
        akVar.b = "weather_news";
        if (bVar.e() != null && bVar.e().size() > 0) {
            akVar.o = true;
            akVar.n = (String) bVar.e().get(0);
        }
        akVar.c = bVar.c();
        akVar.e = "轻触一下，查看新闻详情";
        akVar.I = System.currentTimeMillis();
        p.a().a(akVar);
    }

    private void a(com.vlocker.weather.c.c.b bVar, View view) {
        if (g.a() && !bVar.i()) {
            c.a().c().b(bVar);
            bVar.a(true);
        }
        if (bVar.i()) {
            com.moxiu.b.a.a a = ((com.vlocker.weather.c.c.a) bVar).a();
            if (a != null) {
                a.b(view);
                d.c(this.i, "1040", a.m(), a.n());
                bVar.a(true);
            }
        }
    }

    private void r() {
        this.u = new r(this);
    }

    private void s() {
        this.o = new f(this.i, com.b.d.a.b(this.i, "vweather_flow"), 2);
        this.o.a("3:6:1");
        this.o.a(new s(this));
    }

    private void t() {
        this.l = (ListView) this.g.findViewById(R.id.lv_weather_news_card);
        this.r = View.inflate(this.i, R.layout.layout_weather_news_list_loading, null);
        this.s = (TextView) this.r.findViewById(R.id.footer_textview);
        this.r.setOnClickListener(new t(this));
        this.l.addFooterView(this.r);
        ag agVar = new ag(this.l);
        this.h = new a(this.i, this);
        this.l.setOnScrollListener(this.y);
        this.l.setAdapter(this.h);
        u();
    }

    private void u() {
        String string = this.i.getString(R.string.news_click_refresh);
        this.x = new SpannableString(string);
        this.x.setSpan(new UnderlineSpan(), string.indexOf("点"), string.indexOf("试") + 1, 17);
    }

    private void v() {
        this.m = c.a().b();
        this.m.a(this);
    }

    private void w() {
        int i = 0;
        for (int i2 = 0; i2 < this.h.getCount(); i2++) {
            View view = this.h.getView(i2, null, this.l);
            view.setLayoutParams(new LayoutParams(-1, -2));
            view.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
            i += view.getMeasuredHeight();
        }
        if (i > this.p) {
            this.e = true;
        } else {
            this.e = false;
        }
        LayoutParams layoutParams = this.l.getLayoutParams();
        if (this.e) {
            i = this.p;
        }
        layoutParams.height = i;
        this.l.setLayoutParams(layoutParams);
        this.d = true;
    }

    private void x() {
        this.j.clear();
        this.k.clear();
    }

    private void y() {
        if (this.o != null) {
            this.j = this.o.a(this.k);
            this.u.sendEmptyMessage(1);
        }
    }

    private void z() {
        if (this.t > 0) {
            int currentTimeMillis = (int) ((System.currentTimeMillis() - this.t) / 1000);
            this.t = 0;
        }
    }

    public View a() {
        return this.g;
    }

    public void a(View view, com.vlocker.weather.c.c.b bVar) {
        switch (bVar.h()) {
            case 1:
            case 2:
                if ((this.a == null || !this.a.a) && !this.v) {
                    this.v = true;
                    c.a().c().a(bVar);
                    c.a().c().b();
                    this.a = new v(this.c);
                    this.a.a(bVar);
                    com.vlocker.b.p.a(this.i, "LockerService_Click_News_Counts_PPC_RR", "from", "InfoFlow");
                    this.v = false;
                    return;
                }
                return;
            case 3:
            case 4:
                com.moxiu.b.a.a a = ((com.vlocker.weather.c.c.a) bVar).a();
                com.vlocker.b.a.a(this.i, a, view, "weather_flow", this.n, false, null);
                d.b(this.i, "1040", a.m(), a.n());
                return;
            default:
                return;
        }
    }

    public void a(ArrayList arrayList, boolean z) {
        Object arrayList2;
        if (z) {
            x();
        }
        if (arrayList.size() > 12) {
            arrayList2 = new ArrayList(arrayList.subList(0, 12));
        }
        this.k.clear();
        this.k.addAll(0, arrayList2);
        this.o.a();
        this.o.a(arrayList2.size());
        if (this.w) {
            this.w = false;
            A();
        }
    }

    public synchronized void a(boolean z) {
        if (j.f(this.i)) {
            if (this.m.d()) {
                this.f = System.currentTimeMillis();
                this.s.setText(this.i.getString(R.string.news_refreshing));
                this.w = z;
                if (z) {
                    this.m.e();
                }
                this.e = false;
                this.m.b();
            } else {
                this.m.a();
            }
        }
    }

    public void b() {
        if (this.a != null) {
            this.a.a();
            this.a = null;
        }
    }

    public void b(ArrayList arrayList, boolean z) {
        Collection arrayList2;
        if (arrayList.size() > 12) {
            arrayList2 = new ArrayList(arrayList.subList(0, 12));
        }
        this.k.addAll(arrayList2);
        this.o.a(this.k.size());
    }

    public int c() {
        View childAt = this.l.getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        return (this.l.getFirstVisiblePosition() * childAt.getHeight()) + (-childAt.getTop());
    }

    public synchronized void d() {
        if (!(this.j.size() == 0 || this.z)) {
            this.s.setText(this.i.getString(R.string.news_refreshing));
            com.vlocker.b.p.a(this.i, "LockerService_Load_Times_InfoFlow_PPC_RR", new String[0]);
            this.z = true;
            this.m.c();
        }
    }

    public void e() {
        this.l.setSelection(0);
        if (this.a != null && this.a.a) {
            this.a.a();
        }
        z();
    }

    public boolean f() {
        try {
            if (this.l == null) {
                return false;
            }
            int[] iArr = new int[2];
            this.l.getLocationOnScreen(iArr);
            return iArr[1] - h.d(this.i) == 0 && this.l.getVisibility() == 0;
        } catch (Exception e) {
            return false;
        }
    }

    public void g() {
        if (System.currentTimeMillis() - this.f > 10800000 || this.j.size() == 0) {
            this.m.e();
            a(false);
        } else {
            y();
        }
        c.a().c().a();
    }

    public void h() {
        b = false;
        if (this.a != null && this.a.a) {
            this.a.a();
        }
        this.a = null;
        if (this.k.size() > 12) {
            this.k.subList(0, this.k.size() - 12).clear();
        }
        this.o.b();
        if (this.j.size() > 0) {
            c.a().c().c();
            c.a().c().b();
        }
    }

    public boolean i() {
        if (this.a == null || !this.a.a) {
            return false;
        }
        this.a.b();
        return true;
    }

    public void j() {
        if (this.j != null && this.j.size() > 0) {
            com.vlocker.b.p.a(this.i, "LockerService_Slide_MoreInformation_PPC_RR", new String[0]);
            this.t = System.currentTimeMillis();
        }
    }

    public void k() {
        this.u.sendEmptyMessage(3);
        a(false);
    }

    public void l() {
        this.u.sendEmptyMessage(4);
    }

    public void m() {
        this.w = false;
        if (this.j.size() == 0) {
            this.u.sendEmptyMessage(4);
        }
    }

    public void n() {
        this.u.sendEmptyMessage(2);
        this.u.sendEmptyMessage(6);
        this.z = false;
    }

    public synchronized void o() {
        if (this.j.size() != 0 && System.currentTimeMillis() - this.A >= 100) {
            this.A = System.currentTimeMillis();
            int i = this.i.getResources().getDisplayMetrics().heightPixels;
            for (int i2 = 0; i2 < this.j.size(); i2++) {
                com.vlocker.weather.c.c.b bVar = (com.vlocker.weather.c.c.b) this.j.get(i2);
                View view = null;
                try {
                    view = this.l.getChildAt(i2);
                } catch (Exception e) {
                }
                if (!(bVar.g() || view == null)) {
                    int[] iArr = new int[2];
                    view.getLocationOnScreen(iArr);
                    if (iArr[1] <= i) {
                        a(bVar, view);
                    }
                }
            }
        }
    }

    public void p() {
        if (this.a == null || !this.a.a) {
            c.a().c().a();
        } else {
            c.a().c().c(this.a.b);
        }
    }

    public void q() {
        if ((this.a == null || !this.a.a) && !this.v) {
            com.vlocker.weather.c.c.b bVar = (com.vlocker.weather.c.c.b) this.k.get(0);
            c.a().c().b(bVar);
            c.a().c().a(bVar);
            this.a = new v(this.c);
            this.a.a(bVar);
            c.a().c().b();
            com.vlocker.b.p.a(this.i, "LockerService_Click_News_Counts_PPC_RR", "from", "InfoFlow");
        }
    }
}
