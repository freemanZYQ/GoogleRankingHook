package com.vlocker.new_theme.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.qq.e.comm.constants.ErrorCode.NetWorkError;
import com.vlocker.b.j;
import com.vlocker.b.p;
import com.vlocker.locker.R;
import com.vlocker.new_theme.b.x;
import com.vlocker.new_theme.beans.T_SpecialThemeInfo;
import com.vlocker.new_theme.e.d;
import com.vlocker.new_theme.e.e;
import com.vlocker.new_theme.view.MyScrollview;
import com.vlocker.new_theme.view.T_MyGridView;
import com.vlocker.new_theme.view.a;
import com.vlocker.theme.activity.LocationThemeActivity;
import com.vlocker.theme.imageloader.RecyclingImageView;
import com.vlocker.theme.model.T_ThemeListPageInfo;

public class SpecialSingleItemActivity extends FragmentActivity implements a {
    private TextView A;
    private TextView B;
    private LinearLayout C;
    private ImageView D;
    private OnItemClickListener E = new ab(this);
    private OnClickListener F = new ac(this);
    private d G = new ad(this);
    private RecyclingImageView H;
    private RelativeLayout I;
    private MyScrollview J;
    private String K;
    private String L;
    private RelativeLayout M;
    public com.vlocker.theme.model.d m = new com.vlocker.theme.model.d();
    int n = 0;
    protected PopupWindow o;
    protected boolean p = false;
    private LinearLayout q;
    private T_MyGridView r;
    private e s = null;
    private x t = null;
    private T_ThemeListPageInfo u = null;
    private String v;
    private String w = "";
    private String x = "";
    private String y = "";
    private String z = "";

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(com.vlocker.theme.model.T_ThemeListPageInfo r6, android.widget.RelativeLayout r7, java.lang.Boolean r8) {
        /*
        r5 = this;
        r0 = r8.booleanValue();	 Catch:{ RejectedExecutionException -> 0x00a2, Exception -> 0x00c9 }
        if (r0 != 0) goto L_0x009c;
    L_0x0006:
        r0 = 1;
        r5.p = r0;	 Catch:{ RejectedExecutionException -> 0x00a2, Exception -> 0x00c9 }
        r0 = r5.n;	 Catch:{ RejectedExecutionException -> 0x00a2, Exception -> 0x00c9 }
        r0 = r0 + 1;
        r5.n = r0;	 Catch:{ RejectedExecutionException -> 0x00a2, Exception -> 0x00c9 }
        r0 = com.vlocker.theme.c.a.b();	 Catch:{ RejectedExecutionException -> 0x00a2, Exception -> 0x00c9 }
        r1 = 8201; // 0x2009 float:1.1492E-41 double:4.052E-320;
        r1 = java.lang.String.valueOf(r1);	 Catch:{ RejectedExecutionException -> 0x00a2, Exception -> 0x00c9 }
        r0 = r0.b(r1);	 Catch:{ RejectedExecutionException -> 0x00a2, Exception -> 0x00c9 }
        r1 = r5.s;	 Catch:{ RejectedExecutionException -> 0x00a2, Exception -> 0x00c9 }
        r2 = r5.p;	 Catch:{ RejectedExecutionException -> 0x00a2, Exception -> 0x00c9 }
        r1.a(r2);	 Catch:{ RejectedExecutionException -> 0x00a2, Exception -> 0x00c9 }
        r1 = r5.s;	 Catch:{ RejectedExecutionException -> 0x00a2, Exception -> 0x00c9 }
        r2 = r5.p;	 Catch:{ RejectedExecutionException -> 0x00a2, Exception -> 0x00c9 }
        r1.b(r2);	 Catch:{ RejectedExecutionException -> 0x00a2, Exception -> 0x00c9 }
        if (r0 == 0) goto L_0x00a7;
    L_0x002d:
        r1 = r0.a();	 Catch:{ RejectedExecutionException -> 0x00a2, Exception -> 0x00c9 }
        if (r1 == 0) goto L_0x00a7;
    L_0x0033:
        r1 = r0.a();	 Catch:{ RejectedExecutionException -> 0x00a2, Exception -> 0x00c9 }
        if (r1 == 0) goto L_0x00a7;
    L_0x0039:
        r1 = r0.a();	 Catch:{ RejectedExecutionException -> 0x00a2, Exception -> 0x00c9 }
        r1 = r1.size();	 Catch:{ RejectedExecutionException -> 0x00a2, Exception -> 0x00c9 }
        r2 = r5.n;	 Catch:{ RejectedExecutionException -> 0x00a2, Exception -> 0x00c9 }
        if (r1 > r2) goto L_0x0051;
    L_0x0045:
        r1 = r0.a();	 Catch:{ RejectedExecutionException -> 0x00a2, Exception -> 0x00c9 }
        r1 = r1.size();	 Catch:{ RejectedExecutionException -> 0x00a2, Exception -> 0x00c9 }
        r2 = r5.n;	 Catch:{ RejectedExecutionException -> 0x00a2, Exception -> 0x00c9 }
        if (r1 != r2) goto L_0x00a7;
    L_0x0051:
        r0 = r0.a();	 Catch:{ Exception -> 0x009d, RejectedExecutionException -> 0x00a2 }
        r1 = r5.n;	 Catch:{ Exception -> 0x009d, RejectedExecutionException -> 0x00a2 }
        r1 = r1 + -1;
        r0 = r0.get(r1);	 Catch:{ Exception -> 0x009d, RejectedExecutionException -> 0x00a2 }
        r0 = (com.vlocker.new_theme.beans.T_SpecialThemeInfo) r0;	 Catch:{ Exception -> 0x009d, RejectedExecutionException -> 0x00a2 }
        r1 = r0.c();	 Catch:{ Exception -> 0x009d, RejectedExecutionException -> 0x00a2 }
        r5.y = r1;	 Catch:{ Exception -> 0x009d, RejectedExecutionException -> 0x00a2 }
        r1 = r0.f();	 Catch:{ Exception -> 0x009d, RejectedExecutionException -> 0x00a2 }
        r5.x = r1;	 Catch:{ Exception -> 0x009d, RejectedExecutionException -> 0x00a2 }
        r0 = r0.a();	 Catch:{ Exception -> 0x009d, RejectedExecutionException -> 0x00a2 }
        r1 = r5.A;	 Catch:{ Exception -> 0x009d, RejectedExecutionException -> 0x00a2 }
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x009d, RejectedExecutionException -> 0x00a2 }
        r2.<init>();	 Catch:{ Exception -> 0x009d, RejectedExecutionException -> 0x00a2 }
        r3 = r5.getResources();	 Catch:{ Exception -> 0x009d, RejectedExecutionException -> 0x00a2 }
        r4 = 2131296632; // 0x7f090178 float:1.8211186E38 double:1.053000447E-314;
        r3 = r3.getString(r4);	 Catch:{ Exception -> 0x009d, RejectedExecutionException -> 0x00a2 }
        r2 = r2.append(r3);	 Catch:{ Exception -> 0x009d, RejectedExecutionException -> 0x00a2 }
        r3 = r5.y;	 Catch:{ Exception -> 0x009d, RejectedExecutionException -> 0x00a2 }
        r2 = r2.append(r3);	 Catch:{ Exception -> 0x009d, RejectedExecutionException -> 0x00a2 }
        r2 = r2.toString();	 Catch:{ Exception -> 0x009d, RejectedExecutionException -> 0x00a2 }
        r1.setText(r2);	 Catch:{ Exception -> 0x009d, RejectedExecutionException -> 0x00a2 }
        r1 = r5.A;	 Catch:{ Exception -> 0x009d, RejectedExecutionException -> 0x00a2 }
        r2 = new com.vlocker.new_theme.activity.ae;	 Catch:{ Exception -> 0x009d, RejectedExecutionException -> 0x00a2 }
        r2.<init>(r5, r0);	 Catch:{ Exception -> 0x009d, RejectedExecutionException -> 0x00a2 }
        r1.setOnClickListener(r2);	 Catch:{ Exception -> 0x009d, RejectedExecutionException -> 0x00a2 }
    L_0x009c:
        return;
    L_0x009d:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ RejectedExecutionException -> 0x00a2, Exception -> 0x00c9 }
        goto L_0x009c;
    L_0x00a2:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x009c;
    L_0x00a7:
        r0 = r5.A;	 Catch:{ RejectedExecutionException -> 0x00a2, Exception -> 0x00c9 }
        r1 = r5.getResources();	 Catch:{ RejectedExecutionException -> 0x00a2, Exception -> 0x00c9 }
        r2 = 2131296631; // 0x7f090177 float:1.8211184E38 double:1.0530004465E-314;
        r1 = r1.getString(r2);	 Catch:{ RejectedExecutionException -> 0x00a2, Exception -> 0x00c9 }
        r0.setText(r1);	 Catch:{ RejectedExecutionException -> 0x00a2, Exception -> 0x00c9 }
        r0 = r5.A;	 Catch:{ RejectedExecutionException -> 0x00a2, Exception -> 0x00c9 }
        r1 = 1098907648; // 0x41800000 float:16.0 double:5.42932517E-315;
        r0.setTextSize(r1);	 Catch:{ RejectedExecutionException -> 0x00a2, Exception -> 0x00c9 }
        r0 = r5.A;	 Catch:{ RejectedExecutionException -> 0x00a2, Exception -> 0x00c9 }
        r1 = new com.vlocker.new_theme.activity.af;	 Catch:{ RejectedExecutionException -> 0x00a2, Exception -> 0x00c9 }
        r1.<init>(r5);	 Catch:{ RejectedExecutionException -> 0x00a2, Exception -> 0x00c9 }
        r0.setOnClickListener(r1);	 Catch:{ RejectedExecutionException -> 0x00a2, Exception -> 0x00c9 }
        goto L_0x009c;
    L_0x00c9:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x009c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vlocker.new_theme.activity.SpecialSingleItemActivity.a(com.vlocker.theme.model.T_ThemeListPageInfo, android.widget.RelativeLayout, java.lang.Boolean):void");
    }

    private void i() {
        Intent intent = new Intent();
        intent.setClass(this, ThemeMainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.l_activity_slide_left_in, R.anim.l_activity_slide_right_out);
    }

    private void j() {
        this.M = (RelativeLayout) findViewById(R.id.topview);
        this.H = (RecyclingImageView) findViewById(R.id.market_recommenditem_similar);
        this.B = (TextView) findViewById(R.id.market_recommenditem_titleinfo);
        this.J = (MyScrollview) findViewById(R.id.allsrollview);
        this.J.setOnScrollStateChanged(this);
        this.J.setVisibility(8);
        this.r = (T_MyGridView) findViewById(R.id.gridview);
        this.q = (LinearLayout) findViewById(R.id.allthemes_wait_layout);
        this.C = (LinearLayout) findViewById(R.id.autoLinear);
        this.A = (TextView) findViewById(R.id.nextspecialthemelist);
        this.D = (ImageView) findViewById(R.id.zhuanti_back);
        this.D.setOnClickListener(this.F);
        this.H.setOnClickListener(new z(this));
    }

    private void k() {
        this.q.setVisibility(0);
        this.t = new x(this);
        this.r.setAdapter(this.t);
        this.r.setOnItemClickListener(this.E);
        this.I = (RelativeLayout) findViewById(R.id.listwait_layout3);
        this.s = new e(this, this.G, this.I);
        this.r.setOnScrollListener(this.s);
        this.J.setOnTouchListener(new aa(this));
    }

    private void l() {
        T_ThemeListPageInfo a = com.vlocker.theme.c.a.b().a(this.w);
        if (!(a == null || a.h() == null || a.h().size() <= 0)) {
            a.h().removeAll(a.a);
        }
        this.t = null;
    }

    protected void a(String str) {
        new com.vlocker.new_theme.a.d().a(str, new com.vlocker.new_theme.d.a(), new x(this));
    }

    public void g() {
        a(this.u, this.I, Boolean.valueOf(this.p));
    }

    public void h() {
        this.J.setVisibility(0);
        TextView textView = (TextView) this.q.findViewById(R.id.theme_fetch_loading);
        ImageView imageView = (ImageView) this.q.findViewById(R.id.theme_fetch_loading_imageView1);
        imageView.setVisibility(0);
        if (!com.vlocker.theme.f.e.c((Context) this)) {
            textView.setText(R.string.t_market_listloading_fail);
        } else if ("home".equals(this.z)) {
            if (this.u != null && this.u.u == NetWorkError.HTTP_STATUS_ERROR) {
                textView.setText(R.string.t_market_listloading_specialtheme_cancel);
            } else if (this.u != null && this.u.a == null) {
                textView.setText(R.string.t_market_listloading_specialtheme_notheme);
            }
        } else if (this.t == null || this.t.a() == null || this.t.a().size() != 0) {
            textView.setText(R.string.t_market_listloading_fail);
        } else {
            textView.setText(R.string.t_market_listloading_fail);
        }
        this.q.setOnClickListener(new ag(this, imageView, textView));
        this.s.a(false);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView(R.layout.t_market_themelist_special_gridview);
            j();
            Bundle extras = getIntent().getExtras();
            this.z = extras.getString("from", "");
            if ("banner".equals(this.z)) {
                this.v = extras.getString("title");
                this.y = extras.getString("title");
                this.x = extras.getString("dataurl");
                this.w = String.valueOf(extras.getInt("position")) + 12289;
            } else if ("home".equals(this.z)) {
                this.v = extras.getString("special_title");
                this.n = extras.getInt("position");
                try {
                    T_SpecialThemeInfo t_SpecialThemeInfo = (T_SpecialThemeInfo) com.vlocker.theme.c.a.b().b(String.valueOf(8201)).a().get(this.n - 1);
                    this.y = t_SpecialThemeInfo.c();
                    this.x = t_SpecialThemeInfo.f();
                    String a = t_SpecialThemeInfo.a();
                    if (this.n == 1) {
                        com.vlocker.theme.f.a.a("specialidone", a, getApplicationContext());
                    }
                    if (this.n == 2) {
                        com.vlocker.theme.f.a.a("specialidtwo", a, getApplicationContext());
                    }
                    this.K = a;
                    this.w = a + 16385;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if ("mcm".equals(this.z)) {
                if (com.vlocker.theme.f.e.c((Context) this)) {
                    com.vlocker.theme.f.e.a(getApplicationContext());
                    this.y = extras.getString("pushSpecialTitle");
                    this.x = extras.getString("specialPushJsonUrl");
                    this.w = this.x + 20481;
                } else {
                    LocationThemeActivity.a((Context) this);
                    Toast.makeText(this, R.string.t_market_vlocker_give_net_dip, 0).show();
                    finish();
                    return;
                }
            }
            p.a((Context) this, "Vlocker_View_Sort_Theme_PPC_TF", "from", "Special", "moxiu", j.a((Context) this));
            k();
            try {
                if (this.K == null) {
                    int lastIndexOf = this.x.lastIndexOf("tid=") + 4;
                    int lastIndexOf2 = this.x.lastIndexOf("&");
                    if (lastIndexOf < lastIndexOf2) {
                        this.K = this.x.substring(lastIndexOf, lastIndexOf2);
                    } else {
                        this.K = this.x.substring(lastIndexOf);
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (com.vlocker.theme.f.e.c((Context) this)) {
                a(this.x);
            } else {
                h();
            }
        } catch (OutOfMemoryError e3) {
            e3.printStackTrace();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.o != null && this.o.isShowing()) {
            this.o.dismiss();
            this.o = null;
        }
        l();
        this.r.setAdapter(null);
        com.vlocker.theme.f.e.a((Context) this, "moxiu", "catesingleitemactivity");
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        if ("banner".equals(this.z) || "mcm".equals(this.z)) {
            i();
        }
        finish();
        return true;
    }
}
