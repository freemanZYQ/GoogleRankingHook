package com.vlocker.new_theme.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.vlocker.b.i;
import com.vlocker.b.p;
import com.vlocker.locker.R;
import com.vlocker.new_theme.b.y;
import com.vlocker.new_theme.e.a;
import com.vlocker.new_theme.e.b;
import com.vlocker.theme.activity.LocationThemeActivity;
import com.vlocker.theme.f.e;
import com.vlocker.theme.model.T_SearchOrderInfo;
import com.vlocker.theme.model.T_ThemeListPageInfo;
import com.vlocker.theme.model.d;
import java.util.Timer;
import java.util.concurrent.RejectedExecutionException;

public class SearchResultActivity extends FragmentActivity {
    private boolean A = false;
    private boolean B = true;
    private y C;
    private b D;
    private String E = "";
    private String F = "";
    private String G;
    private int H = 0;
    private LinearLayout I;
    private LinearLayout J;
    private final OnClickListener K = new t(this);
    private final a L = new w(this);
    private boolean M = false;
    private T_ThemeListPageInfo N;
    private int O;
    public d m = new d();
    d n = new d();
    boolean o = false;
    OnClickListener p = new u(this);
    protected boolean q;
    boolean r = true;
    private TextView s;
    private ImageView t;
    private TextView u;
    private AutoCompleteTextView v;
    private ListView w;
    private LinearLayout x;
    private String y = "";
    private final boolean z = false;

    private void a(Context context, View view) {
        ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    private void a(String str, int i) {
        this.x = (LinearLayout) findViewById(R.id.wait_layout);
        this.u = (TextView) findViewById(R.id.theme_fetch_loading);
        this.u.setTextSize(15.0f);
        this.x.setVisibility(0);
        this.x.setOnClickListener(this.p);
        T_ThemeListPageInfo a = com.vlocker.theme.c.a.b().a(8200 + this.y + i);
        if (!(a == null || a.h() == null || a.h().size() <= 0)) {
            a.h().removeAll(a.a);
            a.b(null);
        }
        this.q = false;
        b(str);
    }

    private void a(String str, LinearLayout linearLayout) {
        if (str != null) {
            try {
                if (!str.equals("")) {
                    this.D.a(true);
                    this.D.b(true);
                    a(str);
                    return;
                }
            } catch (RejectedExecutionException e) {
                e.printStackTrace();
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        this.D.a(false);
        this.D.b(false);
    }

    private void b(String str) {
        l();
        a(str);
    }

    private void g() {
        this.I = (LinearLayout) findViewById(R.id.t_allListlayout);
        this.s = (TextView) findViewById(R.id.tv_search);
        this.J = (LinearLayout) findViewById(R.id.not_seach_make_theme);
        this.t = (ImageView) findViewById(R.id.themetab_searchdetail_back);
        this.v = (AutoCompleteTextView) findViewById(R.id.auto_search);
        this.v.setOnEditorActionListener(new r(this));
        this.w = (ListView) findViewById(R.id.grid_view);
        this.t.setOnClickListener(this.K);
        this.s.setOnClickListener(this.K);
    }

    private void h() {
        new Timer().schedule(new s(this), 5);
    }

    private void i() {
        if ("mcm".equals(this.F)) {
            Intent intent = new Intent(this, SearchActivity.class);
            intent.putExtra("from", "mcm");
            startActivity(intent);
        }
        finish();
    }

    private void j() {
        p.a((Context) this, "Vlocker_Search_Theme_PPC_TF", new String[0]);
        this.y = this.v.getText().toString().trim();
        if (this.y == null || this.y.length() == 0) {
            e.a((Context) this, getString(R.string.t_market_moxiu_search_no_input), 0);
            return;
        }
        this.y = e.b(this.y);
        if (this.y == null || this.y.length() == 0) {
            e.a((Context) this, getString(R.string.t_market_moxiu_search_input_error), 0);
        } else if (e.c((Context) this)) {
            this.x = (LinearLayout) findViewById(R.id.wait_layout);
            this.u = (TextView) findViewById(R.id.theme_fetch_loading);
            this.u.setTextSize(15.0f);
            if (!this.y.equals(this.E)) {
                this.o = true;
                if (!(this.C == null || this.n == null)) {
                    this.n.clear();
                    this.C.notifyDataSetChanged();
                }
                this.x.setVisibility(0);
                this.y = e.b(this.y);
                this.E = this.y;
                System.currentTimeMillis();
                this.x.setOnClickListener(this.p);
                T_ThemeListPageInfo a = com.vlocker.theme.c.a.b().a(8200 + this.y + this.H);
                if (!(a == null || a.h() == null || a.h().size() <= 0)) {
                    a.h().removeAll(a.a);
                    a.b(null);
                }
                this.q = false;
                this.B = true;
                k();
            }
        } else {
            e.a((Context) this, getString(R.string.t_market_net_set), 0);
        }
    }

    private void k() {
        l();
        a((i.a() + "json.php?do=Theme.Search&sort=downnumweek&app=vlocker" + ThemeMainActivity.m + "&q=" + e.b(this.y)).replaceAll(" ", "%20"));
    }

    private void l() {
        this.D = new b(this, this.L, (LinearLayout) findViewById(R.id.listwait_layout3));
        this.w.setOnScrollListener(this.D);
    }

    protected void a(String str) {
        try {
            if ("".equals(this.F)) {
                ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 2);
            }
            com.vlocker.new_theme.a.d dVar = new com.vlocker.new_theme.a.d();
            this.u.setText(getString(R.string.t_market_shop_givetheme_loading_dip));
            this.A = true;
            dVar.a(str, new com.vlocker.new_theme.d.d(), new v(this));
        } catch (RejectedExecutionException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            this.r = true;
            switch (i) {
                case 5:
                    this.M = true;
                    try {
                        this.O = intent.getExtras().getInt("position");
                        a(((T_SearchOrderInfo) com.vlocker.theme.c.a.b().a(8200 + this.y + this.H).g().get(this.O)).a(), this.O);
                        return;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return;
                    }
                default:
                    return;
            }
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.t_market_search);
        g();
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.F = extras.getString("from", "");
        } else {
            this.F = getIntent().getStringExtra("from");
        }
        if (this.F == null || this.F.equals("")) {
            finish();
        }
        if ("listkeytag".equals(this.F)) {
            this.G = extras.getString("keyword");
            this.v.setText(this.G);
            this.v.setSelection(this.G.length());
            a((Context) this, this.v);
            j();
        } else if ("enterbtn".equals(this.F)) {
            this.G = extras.getString("keyword");
            this.v.setText(this.G);
            this.v.setSelection(this.G.length());
            a((Context) this, this.v);
            j();
        } else if ("integrate_search".equals(this.F)) {
            this.G = extras.getString("keyword");
            this.v.setText(this.G);
            this.v.setSelection(this.G.length());
            a((Context) this, this.v);
            e.a = this;
            j();
        } else if (!"mcm".equals(this.F)) {
            h();
        } else if (e.c((Context) this)) {
            this.G = extras.getString("keyword");
            this.v.setText(this.G);
            this.v.setSelection(this.G.length());
            a((Context) this, this.v);
            e.a = this;
            j();
        } else {
            LocationThemeActivity.a((Context) this);
            Toast.makeText(this, R.string.t_market_vlocker_give_net_dip, 0).show();
            finish();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        try {
            this.w.setAdapter(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        i();
        return true;
    }
}
