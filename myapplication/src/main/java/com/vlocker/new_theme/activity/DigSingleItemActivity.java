package com.vlocker.new_theme.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.vlocker.b.j;
import com.vlocker.b.p;
import com.vlocker.locker.R;
import com.vlocker.new_theme.d.c;
import com.vlocker.new_theme.e.a;
import com.vlocker.new_theme.e.b;
import com.vlocker.theme.f.e;
import com.vlocker.theme.model.d;
import java.util.concurrent.RejectedExecutionException;

public class DigSingleItemActivity extends FragmentActivity {
    private OnClickListener A = new j(this);
    private a B = new k(this);
    private d C = new d();
    public d m = new d();
    public d n = new d();
    protected boolean o;
    boolean p = false;
    private LinearLayout q;
    private ListView r;
    private TextView s;
    private int t = 0;
    private b u = null;
    private com.vlocker.new_theme.b.d v = null;
    private String w = "";
    private String x = "";
    private boolean y;
    private int z;

    private void a(String str, LinearLayout linearLayout) {
        if (str != null) {
            try {
                if (!str.equals("")) {
                    this.u.a(true);
                    this.u.b(true);
                    a(str, this.t);
                    return;
                }
            } catch (RejectedExecutionException e) {
                return;
            } catch (Exception e2) {
                return;
            }
        }
        e.a(e.a, (CharSequence) "没有更多了~", 0);
        this.u.a(false);
        this.u.b(false);
    }

    private void g() {
        this.s = (TextView) findViewById(R.id.moxiu_text_title);
        this.q = (LinearLayout) findViewById(R.id.allthemes_wait_layout);
        this.r = (ListView) findViewById(R.id.gridview);
        this.r.setDivider(null);
        ((RelativeLayout) findViewById(R.id.moxiu_title_back)).setOnClickListener(this.A);
        this.u = new b(this, this.B, (LinearLayout) findViewById(R.id.listwait_layout3));
        this.r.setOnScrollListener(this.u);
    }

    protected void a(String str, int i) {
        new com.vlocker.new_theme.a.d().a(str, new c(), new h(this));
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (intent != null) {
            try {
                String stringExtra = intent.getStringExtra("data");
                CharSequence stringExtra2 = intent.getStringExtra("title");
                if (!(stringExtra2 == null || stringExtra2.equals(""))) {
                    this.s.setText(stringExtra2);
                }
                this.y = true;
                this.q.setVisibility(0);
                this.n.clear();
                this.m.clear();
                this.v.a(this.m);
                a(stringExtra, this.z);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        extras.getInt("from");
        setContentView(R.layout.t_market_themelist_listview_commen);
        e.a(getApplicationContext());
        g();
        this.x = extras.getString("title");
        p.a((Context) this, "Vlocker_View_Sort_Theme_PPC_TF", "from", "Goods", "moxiu", j.a((Context) this));
        this.w = extras.getString("dataurl");
        try {
            this.s.setText(this.x);
        } catch (Exception e) {
            e.printStackTrace();
        }
        a(this.w, this.t);
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
        if (this.o) {
            this.o = false;
        }
        super.onResume();
        this.p = true;
    }
}
