package com.vlocker.new_theme.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.vlocker.b.j;
import com.vlocker.b.p;
import com.vlocker.locker.R;
import com.vlocker.new_theme.beans.T_CateInfo;
import com.vlocker.new_theme.c.q;
import com.vlocker.new_theme.view.TabFragmentIndicator;
import com.vlocker.theme.c.a;
import com.vlocker.theme.imageloader.aa;
import com.vlocker.theme.model.d;
import java.util.HashMap;
import java.util.Map;

public class CategoryItemActivity extends FragmentActivity {
    private Map A;
    private Bundle B;
    private T_CateInfo C;
    private TabFragmentIndicator D;
    public d m = new d();
    public d n = new d();
    public d o = new d();
    public d p = new d();
    boolean q = false;
    OnClickListener r = new g(this);
    private boolean s;
    private ViewPager t;
    private TextView u;
    private String v;
    private String w;
    private String x;
    private String y;
    private String z;

    private void g() {
        this.D = (TabFragmentIndicator) findViewById(R.id.tabFragmentIndicator);
        this.t = (ViewPager) findViewById(R.id.vPager);
        this.t.setOffscreenPageLimit(3);
        Fragment qVar = new q();
        Bundle bundle = new Bundle();
        bundle.putString("url", this.w);
        bundle.putString("tag", this.z);
        bundle.putString("type", "fenlei");
        bundle.putString("tab", getString(R.string.t_market_cate_popular));
        bundle.putString("title", this.v);
        qVar.b(bundle);
        Fragment qVar2 = new q();
        Bundle bundle2 = new Bundle();
        bundle2.putString("url", this.x);
        bundle2.putString("type", "fenlei");
        bundle2.putString("tag", this.z);
        bundle2.putString("tab", getString(R.string.t_market_cate_new));
        bundle2.putString("title", this.v);
        qVar2.b(bundle2);
        Fragment qVar3 = new q();
        Bundle bundle3 = new Bundle();
        bundle3.putString("url", this.y);
        bundle3.putString("type", "fenlei");
        bundle3.putString("tag", this.z);
        bundle3.putString("tab", getString(R.string.t_market_cate_hot));
        bundle3.putString("title", this.v);
        qVar3.b(bundle3);
        this.D.a(0, qVar);
        this.D.a(1, qVar2);
        this.D.a(2, qVar3);
        this.D.setTabContainerView(R.layout.layout_catel_tabindicator);
        if (aa.b()) {
            this.D.setTabSliderView(R.layout.layout_home_tab_slider);
        }
        this.D.setViewPager(this.t);
        this.t.setCurrentItem(1);
        this.D.d(1);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.t_market_hot);
    }

    public void onPause() {
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.q = true;
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && !this.s) {
            this.s = true;
            a b = a.b();
            Intent intent = getIntent();
            if (intent != null) {
                this.B = intent.getExtras();
                if (this.B != null) {
                    this.B.getInt("from");
                    try {
                        a b2 = a.b();
                        this.C = (T_CateInfo) b.a();
                        b2.a(this.C);
                        this.v = this.C.a();
                        this.w = this.C.d();
                        this.x = this.C.e();
                        this.y = this.C.f();
                        this.z = this.C.b();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            this.u = (TextView) findViewById(R.id.theme_fetch_loading);
            this.u.setText(getString(R.string.t_market_shop_givetheme_loading_dip));
            ((TextView) findViewById(R.id.moxiu_text_title)).setText(this.v);
            p.a((Context) this, "Vlocker_View_Sort_Theme_PPC_TF", "from", "Classify", "moxiu", j.a((Context) this));
            ((RelativeLayout) findViewById(R.id.moxiu_title_back)).setOnClickListener(this.r);
            g();
            this.A = new HashMap();
            this.A.put("catetongji", this.z);
        }
    }
}
