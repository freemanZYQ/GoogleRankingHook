package com.vlocker.new_theme.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.vlocker.locker.R;
import com.vlocker.new_theme.b.x;
import com.vlocker.new_theme.beans.T_AlbumThemeInfo;
import com.vlocker.new_theme.e.a;
import com.vlocker.new_theme.e.b;
import com.vlocker.new_theme.view.T_MyGridView;
import com.vlocker.theme.f.e;
import com.vlocker.theme.model.T_ThemeListPageInfo;
import com.vlocker.theme.model.d;
import java.util.concurrent.RejectedExecutionException;

public class CateSingleItemActivity extends FragmentActivity {
    private String A = "";
    private Boolean B = Boolean.valueOf(true);
    private T_AlbumThemeInfo C = null;
    private OnItemClickListener D = new c(this);
    private OnItemLongClickListener E = new d(this);
    private OnClickListener F = new e(this);
    private a G = new f(this);
    public d m = new d();
    public d n = new d();
    boolean o = false;
    private LinearLayout p;
    private RelativeLayout q;
    private GridView r;
    private T_MyGridView s;
    private TextView t;
    private int u = 0;
    private b v = null;
    private x w = null;
    private T_ThemeListPageInfo x = null;
    private int y = 0;
    private String z = "";

    private void a(String str, LinearLayout linearLayout) {
        if (str != null) {
            try {
                if (!str.equals("")) {
                    this.v.a(true);
                    this.v.b(true);
                    a(str, this.u);
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
        e.a(e.a, getString(R.string.theme_list_atbottom), 0);
        this.v.a(false);
        this.v.b(false);
    }

    private void g() {
        this.t = (TextView) findViewById(R.id.moxiu_text_title);
        this.p = (LinearLayout) findViewById(R.id.allthemes_wait_layout);
        this.q = (RelativeLayout) findViewById(R.id.moxiu_title_back);
        this.q.setOnClickListener(this.F);
    }

    private void h() {
        this.w = new x(this, this);
        this.v = new b(this, this.G, (LinearLayout) findViewById(R.id.listwait_layout3));
        if (this.y == 3) {
            this.s = (T_MyGridView) findViewById(R.id.t_gridview);
            this.s.setAdapter(this.w);
            this.s.setOnItemClickListener(this.D);
            this.s.setOnItemLongClickListener(this.E);
            return;
        }
        this.r = (GridView) findViewById(R.id.gridview);
        this.r.setAdapter(this.w);
        this.r.setOnItemClickListener(this.D);
        this.r.setOnItemLongClickListener(this.E);
        this.r.setOnScrollListener(this.v);
    }

    private void i() {
        this.v.a(false);
        this.v.b(false);
        if (this.B.booleanValue()) {
            this.B = Boolean.valueOf(false);
        } else if (this.y == 3) {
            this.s.setSelection(this.s.getFirstVisiblePosition() + 6);
        } else {
            this.r.setSelection(this.r.getFirstVisiblePosition() + 6);
        }
    }

    protected void a(String str, int i) {
        new com.vlocker.new_theme.a.d().a(str, new com.vlocker.new_theme.d.d(), new a(this));
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        this.y = extras.getInt("from");
        e.a(getApplicationContext());
        switch (this.y) {
            case 1:
                setContentView(R.layout.t_market_themelist_gridview_commen);
                g();
                this.A = extras.getString("title");
                this.z = extras.getString("dataurl");
                this.u = extras.getInt("position") + 12289;
                break;
            case 3:
                setContentView(R.layout.t_market_push_gridview_commen);
                g();
                e.a(getApplicationContext());
                int i = extras.getInt("pushSpecialId");
                this.A = extras.getString("pushSpecialTitle");
                this.z = extras.getString("specialPushJsonUrl");
                this.u = i + 20481;
                this.t.setText(this.A);
                break;
            case 4:
                setContentView(R.layout.t_market_themelist_gridview_commen);
                g();
                try {
                    this.C = (T_AlbumThemeInfo) com.vlocker.theme.c.a.b().c(String.valueOf(8208)).a().get(extras.getInt("position"));
                    this.A = this.C.b();
                    this.z = this.C.c();
                    this.u = Integer.valueOf(this.C.a()).intValue() + 24577;
                    break;
                } catch (Exception e) {
                    break;
                }
            case 5:
                setContentView(R.layout.t_market_themelist_gridview_commen);
                g();
                try {
                    this.C = (T_AlbumThemeInfo) com.vlocker.theme.c.a.b().c(String.valueOf(8209)).a().get(extras.getInt("position"));
                    this.A = this.C.b();
                    this.z = this.C.c();
                    this.u = Integer.valueOf(this.C.a()).intValue() + 28673;
                    break;
                } catch (Exception e2) {
                    break;
                }
            case 7:
                setContentView(R.layout.t_market_themelist_gridview_commen);
                g();
                try {
                    this.A = extras.getString("tagtitle");
                    this.z = extras.getString("tagtitleUrl");
                    this.u = 32769;
                    break;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    break;
                }
            case 8:
                setContentView(R.layout.t_market_themelist_gridview_commen);
                g();
                try {
                    this.A = extras.getString("tagtitle");
                    this.z = extras.getString("tagtitleUrl");
                    this.u = 32769;
                    break;
                } catch (Exception e4) {
                    break;
                }
            case 10:
                setContentView(R.layout.t_market_themelist_gridview_commen);
                e.a(getApplicationContext());
                g();
                this.A = extras.getString("title");
                this.z = extras.getString("dataurl");
                break;
            case 11:
                setContentView(R.layout.t_market_themelist_gridview_commen);
                g();
                try {
                    this.A = extras.getString("title");
                    this.z = extras.getString("dataurl");
                    break;
                } catch (Exception e5) {
                    break;
                }
        }
        try {
            this.t.setText(this.A);
        } catch (Exception e32) {
            e32.printStackTrace();
        }
        h();
        a(this.z, this.u);
        e.d = true;
    }

    protected void onDestroy() {
        super.onDestroy();
        this.r.setAdapter(null);
        e.a((Context) this, "moxiu", "catesingleitemactivity");
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onResume() {
        super.onResume();
        this.o = true;
    }
}
