package com.vlocker.k;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.vlocker.locker.R;
import com.vlocker.m.h;
import com.vlocker.m.l;
import com.vlocker.n.a;
import com.vlocker.security.MoSecurityApplication;
import com.vlocker.theme.f.b;

public class e {
    private static e a;
    private View b;
    private LayoutParams c;
    private volatile boolean d;
    private WindowManager e;
    private LinearLayout f = null;
    private LinearLayout g = null;
    private Handler h;
    private boolean i;
    private j j = new j(this);

    private e() {
        Context a = MoSecurityApplication.a();
        this.e = (WindowManager) a.getSystemService("window");
        this.b = View.inflate(a, R.layout.l_redpocket_float_title, null);
        ((TextView) this.b.findViewById(R.id.red_pocket_from)).setText(Html.fromHtml(a.getString(R.string.red_pocket_title_content)));
        this.c = new LayoutParams();
        this.c.systemUiVisibility = 1;
        if (b.d()) {
            this.c.type = 2005;
            this.c.y = h.d(a);
        } else {
            this.c.type = 2010;
        }
        this.c.width = -1;
        this.c.height = l.a(75.0f);
        this.c.format = 1;
        this.c.gravity = 48;
        this.c.flags = 1832;
        d();
        e();
        this.h = new Handler();
    }

    private LayoutParams a(int i) {
        LayoutParams layoutParams = new LayoutParams();
        layoutParams.systemUiVisibility = 1;
        if (b.d()) {
            layoutParams.type = 2005;
        } else {
            layoutParams.type = 2010;
        }
        layoutParams.gravity = 3;
        layoutParams.format = 1;
        layoutParams.flags = 1312;
        layoutParams.height = -1;
        if (i == 14) {
            layoutParams.width = l.a(1.0f);
        } else {
            layoutParams.width = l.a(72.0f);
        }
        return layoutParams;
    }

    public static e a() {
        if (a == null) {
            a = new e();
        }
        return a;
    }

    private LayoutParams b(int i) {
        LayoutParams layoutParams = new LayoutParams();
        layoutParams.systemUiVisibility = 1;
        if (b.d()) {
            layoutParams.type = 2005;
        } else {
            layoutParams.type = 2010;
        }
        layoutParams.gravity = 80;
        layoutParams.format = 1;
        layoutParams.flags = 263944;
        layoutParams.width = -1;
        if (i == 14) {
            layoutParams.height = l.a(1.0f);
        } else {
            layoutParams.height = l.a(72.0f);
        }
        return layoutParams;
    }

    private void b(Notification notification, int i) {
        Context a = MoSecurityApplication.a();
        this.h.postDelayed(new h(this, a, notification, i), 500);
        a.sendBroadcast(new Intent("action_stop_check"));
    }

    private void d() {
        this.g = new LinearLayout(MoSecurityApplication.a());
        this.g.setLayoutParams(new LinearLayout.LayoutParams(-1, l.a(72.0f)));
        this.g.setOnTouchListener(new f(this));
    }

    private void e() {
        this.f = new LinearLayout(MoSecurityApplication.a());
        this.f.setLayoutParams(new LinearLayout.LayoutParams(l.a(72.0f), -1));
        this.f.setFocusableInTouchMode(true);
        this.f.setOnKeyListener(new g(this));
    }

    private void f() {
        a.a().postDelayed(new i(this), 2000);
    }

    public void a(Notification notification, int i) {
        if (!this.d) {
            this.e.addView(this.b, this.c);
            this.e.addView(this.f, a(i));
            this.e.addView(this.g, b(i));
            this.d = true;
            a.a().removeCallbacks(this.j);
            this.j.a = i;
            this.j.b = notification;
            a.a().postDelayed(this.j, 9500);
            if (this.i) {
                this.i = false;
                f();
            }
        }
    }

    public void a(boolean z) {
        MoSecurityApplication.a().sendBroadcast(new Intent("action_stop_check"));
    }

    public void b() {
        if (this.d) {
            this.e.removeViewImmediate(this.b);
            this.e.removeViewImmediate(this.f);
            this.e.removeViewImmediate(this.g);
            this.d = false;
            a.a().removeCallbacks(this.j);
        }
    }

    public void b(boolean z) {
        this.i = z;
    }

    public void c() {
        if (this.i) {
            this.i = false;
            f();
        }
    }
}
