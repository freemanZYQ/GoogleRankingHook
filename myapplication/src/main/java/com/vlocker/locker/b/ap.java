package com.vlocker.locker.b;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import com.vlocker.b.p;
import com.vlocker.c.a;
import com.vlocker.locker.R;
import com.vlocker.m.y;
import com.vlocker.security.MoSecurityApplication;
import com.vlocker.ui.cover.ah;
import com.vlocker.ui.widget.b.b;
import com.vlocker.ui.widget.b.c;
import com.vlocker.ui.widget.b.e;
import com.vlocker.ui.widget.b.f;
import com.vlocker.ui.widget.b.g;
import com.vlocker.ui.widget.b.h;
import com.vlocker.ui.widget.b.i;
import com.vlocker.ui.widget.b.j;
import com.vlocker.ui.widget.c.d;
import java.util.ArrayList;
import java.util.List;

public class ap {
    static boolean c = false;
    private static ap d;
    private static d f;
    private static boolean j = false;
    public boolean a;
    Handler b = new as(this);
    private Context e;
    private ArrayList g = new ArrayList();
    private a h;
    private ah i = null;

    public ap(Context context) {
        this.e = context;
        this.h = a.a(this.e);
    }

    public static synchronized ap a(Context context) {
        ap apVar;
        synchronized (ap.class) {
            if (d == null) {
                d = new ap(context);
            }
            apVar = d;
        }
        return apVar;
    }

    private c a(com.vlocker.ui.widget.a.d dVar) {
        return dVar.h == (byte) 3 ? new e(this.e, dVar) : dVar.h == (byte) 4 ? new g(this.e, dVar) : dVar.h == (byte) 1 ? new f(this.e, dVar) : dVar.h == (byte) 5 ? new com.vlocker.ui.widget.b.a(this.e, dVar) : dVar.h == (byte) 6 ? new j(this.e, dVar) : dVar.h == (byte) 7 ? new com.vlocker.ui.widget.b.d(this.e, dVar) : dVar.h == (byte) 8 ? new h(this.e, dVar) : dVar.h == (byte) 2 ? new i(this.e, dVar) : dVar.h == (byte) 12 ? new f(this.e, dVar) : dVar.h == (byte) 13 ? new b(this.e, dVar) : null;
    }

    public static d a() {
        return f;
    }

    private void a(boolean z) {
        if (this.i != null) {
            if (z) {
                this.i.a();
            } else {
                this.i.b();
            }
        }
        this.i = null;
    }

    private boolean a(String str) {
        return str == null || "null".equals(str) || IXAdSystemUtils.NT_NONE.equals(str);
    }

    private void g() {
        Toast.makeText(this.e, "锁屏需更新到最新版本才能应用个性的主题", 1).show();
    }

    private void h() {
        float f = (float) this.e.getResources().getDisplayMetrics().widthPixels;
        float f2 = (float) this.e.getResources().getDisplayMetrics().heightPixels;
        if (f <= f2) {
            if (a.a(MoSecurityApplication.a()).az() == 0) {
                a.a(MoSecurityApplication.a()).n(this.e.getResources().getDisplayMetrics().widthPixels);
            }
            float f3 = f2;
            f2 = f;
            f = f3;
        }
        if (f != null) {
            f2 /= (float) f.f();
            f /= (float) f.g();
            d.a = f2;
            d.c = f;
            if (f2 < f) {
                d.a = f;
            }
            d.b = d.a * a().r;
        }
    }

    private void i() {
        com.vlocker.m.c.a(new ar(this));
    }

    private ArrayList j() {
        List e = f.e();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < e.size(); i++) {
            c a = a((com.vlocker.ui.widget.a.d) e.get(i));
            if (a != null) {
                arrayList.add(a);
            }
        }
        return arrayList;
    }

    public synchronized void a(Context context, String str) {
        if (str != null) {
            try {
                if (!c) {
                    c = true;
                    new Thread(new at(this, context, str)).start();
                }
            } catch (Exception e) {
            }
        }
    }

    public void a(Bundle bundle) {
        String str = null;
        j = false;
        String str2 = y.a;
        if (bundle != null) {
            String string = bundle.getString("local");
            int i = bundle.getInt("isLockerWidget");
            y.a = bundle.getString("theme_package");
            y.b = bundle.getString("drawable_level");
            y.c = bundle.getString("current_theme_path");
            y.d = bundle.getInt("vlocker_color");
            int i2 = i;
            str = string;
            int i3 = i2;
        } else {
            boolean z = false;
        }
        if (str == null || !str.equals("local")) {
            this.h.D(false);
        } else {
            j = true;
        }
        if (y.a != null && ((a(str2) && !a(y.a)) || (!a(str2) && a(y.a)))) {
            if (y.a == null || IXAdSystemUtils.NT_NONE.equals(y.a) || "null".equals(y.a)) {
                p.a(this.e, "Vlocker_DefaultThemeSum_PPC_TF", new String[0]);
            } else {
                p.a(this.e, "Vlocker_MultiThemeSum_PPC_TF", new String[0]);
            }
        }
        this.h.f(!j);
        if (i3 != 0) {
            this.b.sendEmptyMessage(3);
            return;
        }
        this.b.sendEmptyMessage(1);
        this.h.h(0);
    }

    public void a(RelativeLayout relativeLayout, com.vlocker.ui.view.ap apVar) {
        if (relativeLayout != null && apVar.getParent() == null) {
            float b = (float) f.b();
            d dVar = f;
            int i = (int) (b * d.a);
            float c = (float) f.c();
            d dVar2 = f;
            LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, (int) (c * d.a));
            b = f.m;
            dVar = f;
            i = (int) (b * d.a);
            c = f.n;
            dVar2 = f;
            layoutParams.setMargins(i, (int) (c * d.a), 0, 0);
            relativeLayout.addView(apVar, layoutParams);
        }
    }

    public void a(ah ahVar) {
        this.i = ahVar;
    }

    public void b() {
        com.vlocker.m.c.a(new aq(this, a.a(this.e).o()));
    }

    public void c() {
        if (a() != null && a().w != null && !this.h.ba()) {
            this.h.Q(this.h.i());
            this.h.c(a().w.u == 0);
        } else if (!this.h.ba()) {
            this.h.c(this.h.aZ());
        }
    }

    public com.vlocker.ui.view.ap d() {
        com.vlocker.ui.view.ap apVar = new com.vlocker.ui.view.ap(this.e);
        apVar.setId(R.id.cover_widget_super_layout);
        apVar.setDrawVector(this.g);
        return apVar;
    }
}
