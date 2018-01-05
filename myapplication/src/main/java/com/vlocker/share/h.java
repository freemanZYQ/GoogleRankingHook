package com.vlocker.share;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import com.tencent.connect.c.a;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import com.tencent.tauth.b;
import com.tencent.tauth.c;
import com.vlocker.locker.R;
import com.vlocker.security.MoSecurityApplication;
import com.vlocker.ui.cover.LockerService;

public class h {
    public volatile boolean a;
    private View b = View.inflate(this.e, R.layout.l_activity_share, null);
    private LayoutParams c;
    private WindowManager d = ((WindowManager) this.e.getSystemService("window"));
    private Context e = MoSecurityApplication.a();
    private Activity f;
    private Intent g;
    private IWXAPI h;
    private c i;
    private String j;
    private String k;
    private String l;
    private String m;
    private a n;
    private boolean o = false;
    private Bitmap p;
    private GridView q;
    private OnClickListener r = new k(this);
    private b s = new o(this);
    private IWXAPIEventHandler t = new p(this);
    private OnItemClickListener u = new q(this);

    public h() {
        this.d.getDefaultDisplay().getMetrics(new DisplayMetrics());
        this.c = new LayoutParams();
        this.c.systemUiVisibility = 1;
        if (com.vlocker.c.a.a(this.e).aj() != 0 && com.vlocker.c.a.a(this.e).ai() != 0) {
            this.c.type = 2010;
        } else if (VERSION.SDK_INT <= 18) {
            this.c.type = 2002;
        } else {
            this.c.type = 2005;
        }
        this.c.width = -1;
        this.c.height = -2;
        this.c.format = 1;
        this.c.gravity = 80;
        this.c.flags = 1280;
        this.b.setFocusableInTouchMode(true);
        this.b.setOnKeyListener(new i(this));
        c();
        this.h = WXAPIFactory.createWXAPI(this.e, "wx450101efd07b59f1", true);
        this.h.registerApp("wx450101efd07b59f1");
        this.i = c.a("1103478279", MoSecurityApplication.a());
        this.n = new a(this.e, this.i.b());
    }

    private Bitmap a(Bitmap bitmap) {
        Matrix matrix = new Matrix();
        matrix.postScale(150.0f / ((float) bitmap.getHeight()), 150.0f / ((float) bitmap.getHeight()));
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    private void a(int i) {
        LockerService.a().a(new l(this, i), 2);
    }

    private void a(String str) {
        new Thread(new j(this)).start();
    }

    private void b() {
        this.j = this.g.getStringExtra("title");
        this.m = this.g.getStringExtra("url");
        this.l = this.g.getStringExtra("content");
        this.k = this.g.getStringExtra("bmp");
        if (!TextUtils.isEmpty(this.k)) {
            a(this.k);
        }
    }

    private void b(int i) {
        LockerService.a().a(new m(this, i), 2);
    }

    private void c() {
        this.q = (GridView) this.b.findViewById(R.id.mx_share_gridview);
        this.q.setAdapter(new d(this.e, 2));
        this.q.setOnItemClickListener(this.u);
        this.b.findViewById(R.id.mx_share_outside).setOnClickListener(this.r);
    }

    private void d() {
        LockerService.a().a(new n(this), 2);
    }

    public void a() {
        if (this.a) {
            this.d.removeViewImmediate(this.b);
            this.a = false;
            System.gc();
        }
    }

    public void a(Activity activity, Intent intent) {
        if (!this.a) {
            this.f = activity;
            this.g = intent;
            this.h.handleIntent(activity.getIntent(), this.t);
            b();
            try {
                this.d.addView(this.b, this.c);
                this.a = true;
            } catch (Exception e) {
            }
        }
    }
}
