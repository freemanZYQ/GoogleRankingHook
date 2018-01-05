package com.vlocker.f;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.vlocker.locker.R;
import com.vlocker.m.l;
import com.vlocker.security.MoSecurityApplication;
import com.vlocker.setting.common.receiver.e;
import com.vlocker.setting.common.receiver.f;
import com.vlocker.ui.cover.k;

public class b implements f {
    public static boolean a = false;
    private static volatile b b;
    private Context c = MoSecurityApplication.a();
    private WindowManager d;
    private LinearLayout e;
    private View f;
    private LayoutParams g;
    private LayoutParams h;
    private TextView i;
    private TextView j;
    private TextView k;
    private TextView l;
    private TextView m;
    private e n;

    private b() {
        h();
        g();
    }

    public static b a() {
        if (b == null) {
            b = new b();
        }
        return b;
    }

    private void g() {
        this.i = (TextView) this.f.findViewById(R.id.fp_popwindow_guide_tv1);
        this.j = (TextView) this.f.findViewById(R.id.fp_popwindow_guide_tv2);
        this.k = (TextView) this.f.findViewById(R.id.fp_popwindow_guide_tv3);
        this.l = (TextView) this.f.findViewById(R.id.fp_popwindow_guide_title);
        this.m = (TextView) this.f.findViewById(R.id.fp_popwindow_guide_close);
        this.m.setOnClickListener(new c(this));
    }

    private void h() {
        this.g = new LayoutParams();
        this.d = (WindowManager) this.c.getSystemService("window");
        if (VERSION.SDK_INT <= 18) {
            this.g.type = 2002;
        } else {
            this.g.type = 2005;
        }
        this.g.format = 1;
        this.g.flags = 40;
        this.g.gravity = 53;
        this.g.x = 0;
        this.g.y = l.a(150.0f);
        this.g.width = -2;
        this.g.height = -2;
        this.h = new LayoutParams();
        if (VERSION.SDK_INT <= 18) {
            this.h.type = 2002;
        } else {
            this.h.type = 2005;
        }
        this.h.format = 1;
        this.h.flags = 1056;
        this.h.gravity = 17;
        this.h.x = 0;
        this.h.y = 0;
        this.h.width = -1;
        this.h.height = -1;
        this.e = (LinearLayout) View.inflate(this.c, R.layout.accesbility_guide_setting, null);
        this.e.setFocusableInTouchMode(true);
        this.e.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
        this.e.setOnTouchListener(new d(this));
        this.f = View.inflate(this.c, R.layout.fingerprint_floatingwindow_guide, null);
        this.f.setFocusableInTouchMode(true);
        this.f.setOnTouchListener(new e(this));
        this.f.setOnKeyListener(new f(this));
    }

    private void i() {
        try {
            if (this.f.getParent() != null) {
                this.d.removeViewImmediate(this.f);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void j() {
        try {
            if (this.e.getParent() != null) {
                this.d.removeViewImmediate(this.e);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void k() {
        if (i.d) {
            this.l.setText("关闭系统锁引导");
            this.i.setText(j.a().c.b[0]);
            this.j.setText(j.a().c.b[1]);
            this.k.setText(j.a().c.b[2]);
        } else if (i.c) {
            this.l.setText("指纹引导");
            if (k.a(this.c)) {
                this.i.setText(j.a().c.c[0]);
                this.j.setText(j.a().c.c[1]);
                this.k.setText(j.a().c.c[2]);
                return;
            }
            this.i.setText(j.a().c.d[0]);
            this.j.setText(j.a().c.d[1]);
            this.k.setText(j.a().c.d[2]);
        }
    }

    private void l() {
        if (this.n == null) {
            this.n = new e(this.c);
            this.n.a(this);
            this.n.a();
        }
    }

    private void m() {
        if (this.n != null) {
            try {
                this.n.b();
                this.n = null;
            } catch (Exception e) {
            }
        }
    }

    public void b() {
        i();
        l();
        try {
            if (this.e.getParent() == null) {
                this.d.addView(this.e, this.g);
                a = true;
            }
        } catch (Exception e) {
        }
    }

    public void c() {
        k();
        j();
        l();
        try {
            if (this.f.getParent() == null) {
                this.d.addView(this.f, this.h);
                a = true;
            }
        } catch (Exception e) {
        }
    }

    public void d() {
        j();
        i();
        m();
        a = false;
    }

    public void e() {
        d();
    }

    public void f() {
    }
}
