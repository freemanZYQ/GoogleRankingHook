package com.vlocker.battery.saver;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import com.moxiu.b.a.a;
import com.vlocker.b.j;
import com.vlocker.msg.ak;
import com.vlocker.msg.p;
import com.vlocker.theme.f.e;
import com.vlocker.ui.cover.LockerService;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class b {
    static long f = 3000;
    private static b j = null;
    Context a;
    public String b;
    boolean c;
    boolean d;
    long e;
    e g;
    boolean h = false;
    boolean i = false;
    private List k;
    private a l;

    private b(Context context) {
        this.a = context;
        this.g = new e(this);
    }

    public static synchronized b a(Context context) {
        b bVar;
        synchronized (b.class) {
            if (j == null) {
                j = new b(context);
            }
            bVar = j;
        }
        return bVar;
    }

    private void a(long j) {
        this.g.postDelayed(new c(this), j);
    }

    private void a(ak akVar) {
        this.h = false;
        this.i = false;
        p.a().a(akVar);
        this.b = akVar.b;
        a(this.a).a(akVar, "ad_show");
        g();
    }

    private void f() {
        if (this.l != null) {
            ak akVar = new ak();
            akVar.C = 9;
            if ("baidu".equals(this.l.C)) {
                if (this.l.f()) {
                    akVar.z = true;
                } else {
                    akVar.y = true;
                }
            } else if (!this.l.f()) {
                akVar.A = true;
            }
            akVar.F = 12;
            akVar.u = this.l.d();
            akVar.b = "mx_ad";
            akVar.n = this.l.b();
            akVar.c = this.l.h();
            akVar.e = this.l.c();
            akVar.g = System.currentTimeMillis();
            akVar.E = true;
            akVar.B = this.l.w();
            if ("1".equals(this.l.E)) {
                if (!TextUtils.isEmpty(this.l.r())) {
                    String r = this.l.r();
                    try {
                        if (this.l.r().length() > 4) {
                            r = new BigDecimal((double) (((float) Integer.parseInt(this.l.r())) / 10000.0f)).setScale(1, RoundingMode.HALF_UP).toString() + "W";
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    akVar.v = "月销" + r + "件";
                }
                if (!TextUtils.isEmpty(this.l.q())) {
                    akVar.w = "￥" + this.l.q();
                }
                if (!TextUtils.isEmpty(this.l.p())) {
                    akVar.x = "￥" + this.l.p();
                }
            }
            a(akVar);
        }
    }

    private void g() {
        if (this.l != null) {
            com.vlocker.a.a.a.c(this.a, com.vlocker.a.a.a.e(this.a) + 1);
        }
    }

    private void h() {
        new com.b.b.a(this.a).a(com.b.d.a.b(this.a, "battery_saver"), 5, new d(this)).a();
    }

    private void i() {
        try {
            switch (this.l.e()) {
                case 8:
                    if (LockerService.a().c()) {
                        e.a(this.a, this.l.h() + " " + "下载完成,请解锁安装~", 0);
                        return;
                    } else {
                        e.a(this.a, this.l.h() + " " + "下载完成,可以安心使用了~", 0);
                        return;
                    }
                default:
                    return;
            }
        } catch (Exception e) {
        }
    }

    public synchronized void a() {
        if (!b()) {
            if (!this.d && j.i(this.a)) {
                long currentTimeMillis = System.currentTimeMillis();
                if (this.e == 0 || currentTimeMillis - this.e >= f) {
                    this.e = currentTimeMillis;
                    e();
                } else {
                    a(f - (currentTimeMillis - this.e));
                }
            }
        }
    }

    public void a(View view) {
        if (this.l != null) {
            com.vlocker.a.a.a.e(this.a);
            com.vlocker.b.a.a(this.a, this.l, view, "", null, false, null);
        }
    }

    public void a(View view, boolean z) {
        try {
            if (this.l == null) {
                return;
            }
            if (!z) {
                this.l.b(view);
            } else if ("baidu".equals(this.l.C)) {
                if (LockerService.e(this.a)) {
                    this.h = true;
                    this.l.b(view);
                }
            } else if (!"baidu".equals(this.l.C)) {
                this.h = true;
                this.l.b(view);
            } else if (LockerService.e(this.a)) {
                this.h = true;
                this.l.b(view);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(ak akVar, String str) {
        if (this.l != null) {
            com.vlocker.b.p.f(this.a, str, this.l.m(), this.l.n());
        }
    }

    public void a(String str) {
        if (this.l != null) {
            com.vlocker.b.p.a(this.a, str, "referer", this.l.n(), "name", this.l.m());
        }
    }

    public void a(boolean z) {
        this.c = z;
    }

    public void b(String str) {
    }

    public void b(boolean z) {
        this.d = z;
    }

    public boolean b() {
        return this.c;
    }

    public void c() {
        a(false);
        if (this.b != null) {
            p.a().a(this.b);
        }
        this.b = null;
    }

    public void d() {
        com.vlocker.a.a.a.a(this.a, com.vlocker.a.a.a.c(this.a) + 1);
        if (!this.i) {
            View l = p.a().l();
            if (l != null) {
                a(this.a).a(l, false);
                this.i = true;
            }
        }
    }

    public void e() {
        try {
            if (!"100C".equals(Build.MODEL)) {
                h();
                com.vlocker.b.p.a(this.a);
            }
        } catch (Exception e) {
        }
    }
}
