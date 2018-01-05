package com.vlocker.search;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.moxiu.b.a.a;
import com.vlocker.b.j;
import com.vlocker.b.p;
import com.vlocker.locker.R;
import com.vlocker.msg.ao;
import com.vlocker.theme.f.e;
import com.vlocker.theme.imageloader.RecyclingImageView;
import com.vlocker.ui.cover.g;
import com.vlocker.weather.e.d;
import java.util.List;

public class b extends p {
    protected RecyclingImageView a;
    protected Context b;
    long c = 0;
    public String d = "";
    private float j;
    private List k;
    private a l;
    private LinearLayout m;
    private long n = 0;
    private int o = 0;
    private final long p = 3600000;

    public b(BaiduSearchActivity baiduSearchActivity, at atVar) {
        super(baiduSearchActivity, atVar);
        this.b = baiduSearchActivity;
    }

    private void b(boolean z) {
        if (z) {
            this.i.a("ade");
        }
        this.m.setVisibility(8);
    }

    private void d() {
        if (e.c(this.b)) {
            p.a(this.b, "Vlock_Click_AD_Search_PPC_TF", "ad_name", this.l.m());
            try {
                this.l.a(this.m);
                if (!"dianou".equals(this.l.C) || !"nothing".equals(this.l.s())) {
                    return;
                }
                if ("rc".equals(this.l.D) || "url".equals(this.l.D)) {
                    e();
                    return;
                }
                return;
            } catch (Throwable th) {
                th.printStackTrace();
                e();
                return;
            }
        }
        e.a(this.b, this.b.getString(R.string.M_bd_net_set), 0);
    }

    private void e() {
        Intent a = ao.a(this.b, this.l.i());
        a.putExtra("tag", "search_ad");
        a.addFlags(268435456);
        this.b.startActivity(a);
    }

    private void f() {
        new com.b.b.a(this.e).a(com.b.d.a.b(this.e, "search_banner"), 10, new c(this)).a();
    }

    private void g() {
        try {
            switch (this.l.e()) {
                case 8:
                    if (g.a) {
                        e.a(this.e, this.l.h() + " " + "下载完成,请解锁安装~", 0);
                        return;
                    } else {
                        e.a(this.e, this.l.h() + " " + "下载完成,可以安心使用了~", 0);
                        return;
                    }
                default:
                    return;
            }
        } catch (Exception e) {
        }
    }

    private void h() {
        try {
            this.a.setLayoutParams(new LayoutParams(-1, (int) this.j));
            this.a.a(this.l.d(), 2, 0);
            if (!this.l.J) {
                this.l.b(this.m);
            }
            p.a(this.b, "Vlock_Show_AD_Search_PPC_TF", new String[0]);
            this.m.setOnClickListener(new d(this));
            this.m.setVisibility(0);
        } catch (Exception e) {
            b(true);
        }
    }

    protected View a() {
        this.j = ((float) (this.e.getResources().getDisplayMetrics().widthPixels - 50)) / 2.0f;
        this.m = (LinearLayout) j.b(this.e, (int) R.layout.m_bd_search_news_item_ad);
        this.a = (RecyclingImageView) j.a(this.m, (int) R.id.img_poster_w);
        return this.m;
    }

    protected void a(ac acVar) {
        if (acVar != null) {
            a(false);
        }
    }

    public void a(boolean z) {
        b(false);
        try {
            if ("100C".equals(Build.MODEL)) {
                b(true);
            } else if (z || System.currentTimeMillis() - this.n > 3600000) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.c > 60000) {
                    f();
                    d.a(this.e, this.d);
                    this.c = currentTimeMillis;
                }
            } else {
                this.o++;
                if (this.o >= this.k.size()) {
                    this.o = 0;
                }
                this.l = (a) this.k.get(this.o);
                this.l.a(false);
                b();
            }
        } catch (Exception e) {
            b(true);
        }
    }

    public void b() {
        if (this.m != null) {
            if (this.l != null) {
                h();
            } else {
                b(true);
            }
        }
    }
}
