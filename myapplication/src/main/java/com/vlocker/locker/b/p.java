package com.vlocker.locker.b;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout.LayoutParams;
import com.vlocker.i.a;
import com.vlocker.locker.R;
import com.vlocker.locker.c.ai;
import com.vlocker.locker.c.ao;
import com.vlocker.locker.c.ax;
import com.vlocker.locker.c.az;
import com.vlocker.locker.c.b;
import com.vlocker.m.al;
import com.vlocker.m.ay;
import com.vlocker.m.bc;
import com.vlocker.m.g;
import com.vlocker.m.l;
import com.vlocker.m.r;
import com.vlocker.m.t;
import com.vlocker.msg.ab;
import com.vlocker.security.MoSecurityApplication;
import com.vlocker.theme.imageloader.y;
import com.vlocker.ui.cover.LockerService;
import com.vlocker.ui.cover.af;
import com.vlocker.ui.cover.f;
import com.vlocker.ui.cover.h;
import com.vlocker.ui.view.BatteryChargeView;
import com.vlocker.ui.widget.CoverViewPager;
import com.vlocker.ui.widget.c.d;
import com.vlocker.weather.c.d.c;
import com.vlocker.weather.e.j;
import com.vlocker.weather.view.CoverTipsLayout;
import com.vlocker.weather.view.CoverWeatherLayout;
import com.vlocker.weather.z;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class p implements a {
    public int a;
    private CoverViewPager b;
    private ArrayList c;
    private aa d;
    private ai e;
    private ao f;
    private ax g;
    private b h;
    private Context i;
    private View j;
    private af k = null;
    private am l = null;
    private ac m;
    private ag n;
    private af o;
    private z p;
    private Handler q;
    private com.vlocker.c.a r;
    private ArrayList s = new ArrayList();
    private boolean t;
    private boolean u = true;
    private Runnable v;

    public p(Context context, af afVar) {
        this.i = context;
        this.k = afVar;
        I();
    }

    private void H() {
        this.n.a();
        this.o.a((ViewGroup) this.j.findViewById(R.id.cover_layout));
        if (b() || q()) {
            this.b.setAdapter(null);
            this.d.c();
            this.b.setAdapter(this.d);
        }
        CoverViewPager coverViewPager = this.b;
        int i = (!f.e || this.r.ao()) ? 0 : 1;
        coverViewPager.setCurrentItem(i);
    }

    private void I() {
        this.u = LockerService.e(this.i);
        if (ap.a() == null || ap.a().u.a <= 0) {
            h.i = l.a(100.0f);
        } else {
            h.i = (int) (((float) ap.a().u.a) * d.a);
        }
        this.r = com.vlocker.c.a.a(this.i);
        this.q = new x();
        al.a();
        g.a(this.i);
        this.j = LayoutInflater.from(this.i).inflate(R.layout.l_float_cover, null);
        this.b = (CoverViewPager) this.j.findViewById(R.id.main_vp);
        this.b.setOffscreenPageLimit(2);
        D();
        this.l = am.a();
        this.l.a(this.j);
        s();
        this.m = new ac(this.i, this);
        this.n = new ag(this.i, this);
        this.o = new af(this.i);
        this.p = new z(this.i, this);
        a(this.i);
        this.q.sendEmptyMessage(1);
        a((a) this);
        a(ab.a());
        if (VERSION.SDK_INT >= 18) {
            ab.a().b();
        }
        if (this.r.q() && this.h != null) {
            this.h.a(true);
        }
        J();
    }

    private void J() {
        if (this.i.getResources().getDisplayMetrics().widthPixels > 480) {
            try {
                Field declaredField = ViewPager.class.getDeclaredField("O");
                declaredField.setAccessible(true);
                declaredField.set(this.b, Integer.valueOf(l.a(30.0f)));
                declaredField = ViewPager.class.getDeclaredField("M");
                declaredField.setAccessible(true);
                declaredField.set(this.b, Integer.valueOf(l.a(1000.0f)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void K() {
        this.o.b();
        String a = ay.a(this.i);
        String b = ay.b(this.i);
        for (int i = 0; i < this.c.size(); i++) {
            if (this.c.get(i) != null) {
                ((com.vlocker.locker.c.a) this.c.get(i)).a(a, b);
            }
        }
        if (MoSecurityApplication.d) {
            L();
            this.q.sendEmptyMessageDelayed(1, 500);
            return;
        }
        this.q.sendEmptyMessageDelayed(1, 1000);
    }

    private void L() {
        if (this.u != LockerService.e(this.i)) {
            Intent intent;
            if (this.u) {
                intent = new Intent();
                intent.setAction(LockerService.c);
                this.i.sendBroadcast(intent);
            } else {
                intent = new Intent();
                intent.setAction(LockerService.b);
                this.i.sendBroadcast(intent);
            }
            this.u = LockerService.e(this.i);
        }
    }

    private void M() {
        if (this.r.S() && this.e != null) {
            this.e.l();
        } else if (this.f != null) {
            this.f.f();
        }
    }

    private void a(Context context) {
        int i = 1;
        this.c = new ArrayList();
        if (this.r.Q() || this.r.S()) {
            f.e = true;
        }
        if (this.r.Q()) {
            this.f = new ao(context, this);
        }
        if (this.r.S()) {
            this.e = new ai(context, this);
        }
        this.h = new b(context, this);
        if (f.e) {
            if (this.r.Q()) {
                this.c.add(this.f);
            } else {
                this.c.add(this.e);
            }
        }
        this.c.add(this.h);
        if (j.d(this.i) && !com.vlocker.c.a.a(this.i).H()) {
            if (this.g == null) {
                this.g = new ax(context, this);
            }
            this.c.add(this.g);
        }
        this.d = new aa();
        this.b.setAdapter(this.d);
        this.b.a(new q(this));
        CoverViewPager coverViewPager = this.b;
        if (!f.e || this.r.ao()) {
            i = 0;
        }
        coverViewPager.setCurrentItem(i);
    }

    private void a(String str) {
        if (this.r.S() && this.e != null) {
            this.e.a(str);
        } else if (this.f != null) {
            this.f.a(str);
        }
    }

    private void b(String str, boolean z) {
        for (int i = 0; i < this.c.size(); i++) {
            if (((com.vlocker.locker.c.a) this.c.get(i)).d.equals(str)) {
                this.b.a(i, z);
                return;
            }
        }
    }

    public void A() {
        for (int i = 0; i < this.c.size(); i++) {
            ((com.vlocker.locker.c.a) this.c.get(i)).c();
        }
        com.vlocker.g.b.a().j();
    }

    public void B() {
        this.h.m();
    }

    public void C() {
        this.h.n();
    }

    public void D() {
        this.b.setPadding(0, 0, 0, 0);
        this.j.findViewById(R.id.cover_back_camera_layout).setPadding(0, 0, 0, 0);
    }

    public void E() {
        this.o.a();
    }

    public void F() {
        if (this.g != null) {
            this.g.f();
        }
    }

    public y G() {
        return new y(this);
    }

    public void a() {
        this.v = null;
        H();
        c();
    }

    public void a(float f) {
        this.m.a(f);
    }

    public void a(float f, long j) {
        this.m.a(f, j);
    }

    public void a(float f, boolean z) {
        this.l.a(f, z);
    }

    public void a(float f, boolean z, long j) {
        this.l.a(f, z, j);
    }

    public void a(int i, int i2, t tVar) {
        b(i);
        r.a().a(i2, tVar);
    }

    public void a(int i, long j) {
        if (this.g != null) {
            this.g.a(i, j);
        } else {
            this.q.postDelayed(new az(i), j);
        }
    }

    public void a(Intent intent) {
        if (this.g != null) {
            this.g.a(intent);
            return;
        }
        if (q()) {
            this.b.setAdapter(null);
            this.d.c();
            this.b.setAdapter(this.d);
        }
        if (this.g != null) {
            this.g.a(intent);
        }
    }

    public void a(View view) {
        this.m.a(view);
    }

    public void a(View view, LayoutParams layoutParams) {
        ((ViewGroup) this.j).addView(view, layoutParams);
    }

    public void a(WindowManager windowManager, float f) {
        if (this.j != null) {
            ViewGroup.LayoutParams a = bc.a(this.i, windowManager);
            if (f < 0.0f) {
                a.screenBrightness = -1.0f;
            } else {
                a.screenBrightness = f / 255.0f;
            }
            windowManager.updateViewLayout(this.j, a);
        }
    }

    public void a(a aVar) {
        this.s.add(aVar);
    }

    public void a(CoverWeatherLayout coverWeatherLayout, CoverTipsLayout coverTipsLayout) {
        this.p.a(coverWeatherLayout, coverTipsLayout);
    }

    public void a(Runnable runnable, int i) {
        this.v = runnable;
        if (f.e) {
            M();
            if (h.h == 1 && h.a == 1) {
                a(com.vlocker.ui.cover.g.g(), true);
                return;
            } else {
                b(true);
                return;
            }
        }
        b(i);
    }

    public void a(Runnable runnable, int i, String str) {
        this.v = runnable;
        if (f.e) {
            a(str);
            if (h.h == 1 && h.a == 1) {
                a(com.vlocker.ui.cover.g.g(), true);
                return;
            } else {
                b(true);
                return;
            }
        }
        b(i);
    }

    public void a(String str, boolean z) {
        if (p()) {
            n();
            o();
            this.q.postDelayed(new s(this, str, z), 250);
            return;
        }
        b(str, z);
    }

    public void a(boolean z) {
        this.l.a(z);
    }

    public void a_(int i) {
        if (i == 2) {
            y.a().b(2);
        }
        if (this.c != null && this.c.size() > 0) {
            for (int i2 = 0; i2 < this.c.size(); i2++) {
                ((com.vlocker.locker.c.a) this.c.get(i2)).a_(i);
            }
        }
    }

    public void b(int i) {
        this.t = false;
        n();
        o();
        this.k.a(this.j, i);
        this.h.n();
        if (this.v != null) {
            this.v.run();
            this.v = null;
        }
        if (i == 2) {
            com.vlocker.battery.clean.y.a().j();
        } else if (com.vlocker.ui.cover.g.a() && com.vlocker.weather.a.d) {
            c.a().c().c();
            c.a().c().b();
        }
    }

    public void b(View view) {
        this.n.a(this.j, view);
    }

    public void b(boolean z) {
        if (this.r.Q()) {
            this.f.a(z ? 1.0f : 0.0f, 150, z ? 150 : 0, z ? null : new ab(this, z));
        }
        if (this.r.S()) {
            this.e.a(z ? 1.0f : 0.0f, 150, z ? 150 : 0, z ? null : new ab(this, z));
        }
        if (!BatteryChargeView.c) {
            a(z ? 1.0f : 0.0f, this.r.i(), 300);
        } else if (!this.r.i()) {
            a(z ? 0.0f : 1.0f, true, 300);
            a(z ? 1.0f : 0.0f, false, 300);
        }
        this.h.a(z ? 0.0f : 1.0f, 150, z ? 0 : 150, z ? new ab(this, z) : null);
    }

    public boolean b() {
        boolean z;
        if (!this.r.Q()) {
            if (this.c.contains(this.f)) {
                this.c.remove(this.f);
                z = true;
            }
            z = false;
        } else if (f.j) {
            if (this.c.contains(this.f)) {
                this.c.remove(this.f);
            }
            this.f = new ao(this.i, this);
            this.c.add(0, this.f);
            z = true;
        } else {
            if (this.f == null) {
                this.f = new ao(this.i, this);
            }
            if (!this.c.contains(this.f)) {
                if (this.c.contains(this.e)) {
                    this.c.remove(this.e);
                    this.e.b();
                }
                this.c.add(0, this.f);
                z = true;
            }
            z = false;
        }
        if (this.r.S()) {
            if (f.j) {
                if (this.c.contains(this.e)) {
                    this.c.remove(this.e);
                }
                this.e = new ai(this.i, this);
                this.c.add(0, this.e);
                z = true;
            } else {
                if (this.e == null) {
                    this.e = new ai(this.i, this);
                }
                if (!this.c.contains(this.e)) {
                    if (this.c.contains(this.f)) {
                        this.c.remove(this.f);
                    }
                    this.c.add(0, this.e);
                    z = true;
                }
            }
        } else if (this.c.contains(this.e)) {
            this.c.remove(this.e);
            this.e.b();
            z = true;
        }
        f.j = false;
        if (this.r.Q() || this.r.S()) {
            f.e = true;
        } else {
            f.e = false;
        }
        return z;
    }

    public void c() {
        this.t = true;
        this.k.a(this.j);
        if (this.r.dd() && f.e && this.r.cg() && com.vlocker.ui.cover.g.a) {
            b(com.vlocker.ui.cover.g.g(), true);
        }
    }

    public void c(int i) {
        this.m.a(i);
    }

    public void c(View view) {
        com.vlocker.g.b.a().a(this.j, view, this);
    }

    public void d() {
        this.l.e();
    }

    public void d(int i) {
        this.h.d(i);
    }

    public void d(View view) {
        view.setOnClickListener(this.p.c());
    }

    public void e() {
        this.l.f();
    }

    public void e(int i) {
        float translationX = this.b.getTranslationX();
        float translationY = this.b.getTranslationY();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.setDuration((long) i);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.addListener(new u(this));
        ofFloat.addUpdateListener(new v(this, translationX, translationY));
        ofFloat.start();
    }

    public void e(View view) {
        ((ViewGroup) this.j).removeView(view);
    }

    public ArrayList f() {
        return this.s;
    }

    public void f(int i) {
        ViewPropertyAnimator animate = u().animate();
        animate.setListener(new w(this));
        animate.alpha(0.0f).setDuration((long) i).setInterpolator(new LinearInterpolator()).start();
        if (h.a == 1) {
            this.b.animate().setInterpolator(new LinearInterpolator()).setDuration((long) i).alpha(0.0f).start();
        } else if (h.a == 2) {
            this.b.animate().setInterpolator(new LinearInterpolator()).setDuration((long) i).alpha(0.0f).start();
        } else {
            this.b.animate().setInterpolator(new LinearInterpolator()).setDuration((long) i).alpha(0.0f).start();
        }
    }

    public void g() {
        if (this.c != null && this.c.size() > 0) {
            for (int i = 0; i < this.c.size(); i++) {
                ((com.vlocker.locker.c.a) this.c.get(i)).g();
            }
        }
    }

    public void h() {
        this.v = null;
        if (this.c != null && this.c.size() > 0) {
            for (int i = 0; i < this.c.size(); i++) {
                ((com.vlocker.locker.c.a) this.c.get(i)).h();
            }
        }
    }

    public void i() {
        this.q.postDelayed(new t(this), 1420);
        if (this.c != null && this.c.size() > 0) {
            for (int i = 0; i < this.c.size(); i++) {
                ((com.vlocker.locker.c.a) this.c.get(i)).i();
            }
        }
    }

    public View j() {
        return this.h.e();
    }

    public CoverViewPager k() {
        return this.b;
    }

    public z l() {
        return this.p;
    }

    public boolean m() {
        return this.n.c();
    }

    public void n() {
        if (this.n.c()) {
            this.n.d();
        }
    }

    public void o() {
        this.h.j();
    }

    public boolean p() {
        return this.n.c() || this.h.k();
    }

    public boolean q() {
        boolean z = true;
        if (!j.d(this.i) || com.vlocker.c.a.a(this.i).H()) {
            if (this.c.contains(this.g)) {
                this.c.remove(this.g);
                if (this.g != null) {
                    this.g.b();
                    this.g = null;
                }
            } else {
                z = false;
            }
            this.p.a(8);
            com.vlocker.ui.cover.g.d = false;
            return z;
        }
        boolean z2;
        if (this.c.contains(this.g)) {
            z2 = false;
        } else {
            if (this.g == null) {
                this.g = new ax(this.i, this);
            }
            this.c.add(this.g);
            z2 = true;
        }
        this.p.a(0);
        com.vlocker.ui.cover.g.d = true;
        return z2;
    }

    public void r() {
        for (int i = 0; i < this.c.size(); i++) {
            ((com.vlocker.locker.c.a) this.c.get(i)).b();
        }
        if (this.m != null) {
            this.m.c();
        }
    }

    public void s() {
        if (this.l != null) {
            this.l.d();
        }
    }

    public ViewGroup t() {
        return this.j != null ? (ViewGroup) this.j.findViewById(R.id.cover_back_camera_layout) : null;
    }

    public ViewGroup u() {
        return this.j != null ? (ViewGroup) this.j.findViewById(R.id.cover_layout) : null;
    }

    public boolean v() {
        return this.t;
    }

    public void w() {
        this.h.o();
    }

    public void x() {
        this.h.p();
    }

    public void y() {
        this.h.w();
    }

    public void z() {
        if (!LockerService.e(this.i)) {
            return;
        }
        if (com.vlocker.ui.cover.g.b()) {
            com.vlocker.b.p.a("101000", "101001");
        } else if (com.vlocker.ui.cover.g.c()) {
            com.vlocker.b.p.a("101000", "101003");
        } else if (com.vlocker.ui.cover.g.d()) {
            com.vlocker.b.p.a("101000", "101003");
        }
    }
}
