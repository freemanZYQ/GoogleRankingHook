package com.vlocker.l;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build.VERSION;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import com.vlocker.c.a;
import com.vlocker.locker.R;
import com.vlocker.locker.b.ag;
import com.vlocker.m.aj;
import com.vlocker.m.h;
import com.vlocker.m.l;
import com.vlocker.settings.dc;
import com.vlocker.ui.widget.MyGridView;
import java.util.ArrayList;
import java.util.List;

public class j {
    private int A;
    private a B;
    private a C;
    private a D;
    private a E;
    private a F;
    private a G;
    private List H = new ArrayList();
    Runnable a = new l(this);
    private Context b;
    private View c;
    private ViewGroup d;
    private View e;
    private View f;
    private boolean g;
    private aa h;
    private ad i;
    private ad j;
    private ad k;
    private int l;
    private int m;
    private boolean n;
    private boolean o;
    private f p;
    private boolean q = false;
    private ag r;
    private z s;
    private Object t = new Object();
    private MyGridView u;
    private BaseAdapter v;
    private ArrayList w = new ArrayList();
    private int x;
    private OnTouchListener y = new p(this);
    private int z = 0;

    public j(Context context, ag agVar, View view) {
        this.b = context;
        this.l = c();
        this.n = false;
        this.o = true;
        this.m = l.a(this.b, 4.0f);
        this.z = l.a(this.b, 35.0f);
        this.d = (ViewGroup) view.getRootView();
        this.r = agVar;
        a(this.b);
        r();
        m();
    }

    private dc a(String str) {
        dc dcVar = new dc();
        dcVar.b = str;
        if ("vlocker_flashlight".equals(str)) {
            dcVar.d = this.b.getResources().getDrawable(R.drawable.l_toolbox_flashlight_off);
            dcVar.a = this.b.getString(R.string.toolbox_shortcut_flashlight);
        } else if ("vlocker_calculator".equals(str)) {
            dcVar.d = this.b.getResources().getDrawable(R.drawable.l_toolbox_calculator);
            dcVar.a = this.b.getString(R.string.toolbox_shortcut_calculator);
        } else if ("vlocker_alarm".equals(str)) {
            dcVar.d = this.b.getResources().getDrawable(R.drawable.l_toolbox_alarm);
            dcVar.a = this.b.getString(R.string.toolbox_shortcut_alarm);
        } else if ("vlocker_boost".equals(str)) {
            dcVar.d = this.b.getResources().getDrawable(R.drawable.l_toolbox_boost);
            dcVar.a = this.b.getString(R.string.toolbox_shortcut_setting);
        } else {
            PackageManager packageManager = this.b.getPackageManager();
            Intent intent = new Intent("android.intent.action.MAIN", null);
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setPackage(str);
            List queryIntentActivities = packageManager.queryIntentActivities(intent, 0);
            dcVar.c = ((ResolveInfo) queryIntentActivities.get(0)).activityInfo.name;
            dcVar.a = ((ResolveInfo) queryIntentActivities.get(0)).loadLabel(packageManager).toString().trim();
            dcVar.d = ((ResolveInfo) queryIntentActivities.get(0)).loadIcon(packageManager);
        }
        return dcVar;
    }

    private void a(float f, boolean z) {
        a(f, z, z ? null : this.a);
    }

    private void a(float f, boolean z, Runnable runnable) {
        ViewPropertyAnimator animate = this.c.animate();
        animate.setListener(null);
        animate.cancel();
        animate.setListener(new q(this, runnable, z));
        this.n = f != ((float) this.d.getHeight());
        b(z);
        animate.translationY(f).setDuration(200).setInterpolator(new DecelerateInterpolator(2.0f)).start();
    }

    public static void a(Context context) {
        a.a(context).bf();
        a.a(context).e("vlocker_flashlight", true);
        a.a(context).e("vlocker_calculator", true);
        a.a(context).e("vlocker_alarm", true);
        a.a(context).e("vlocker_boost", true);
    }

    private void b(float f) {
        if (this.s != null) {
            this.s.a(f);
        }
    }

    private void b(boolean z) {
        if (this.s != null) {
            this.s.a(z);
        }
    }

    private boolean b(int i) {
        return i < this.d.getHeight() - (this.c.getHeight() / 4);
    }

    public static boolean b(Context context) {
        return com.vlocker.b.j.b(context, "com.baidu.BaiduMap") || com.vlocker.b.j.b(context, "com.baidu.BaiduMap.samsung") || com.vlocker.b.j.b(context, "com.autonavi.minimap") || com.vlocker.b.j.b(context, "com.autonavi.minimap.custom") || com.vlocker.b.j.b(context, "com.autonavi.cmccmap") || com.vlocker.b.j.b(context, "com.tencent.map") || com.vlocker.b.j.b(context, "com.mapbar.android.mapbarmap") || com.vlocker.b.j.b(context, "com.sogou.map.android.maps") || com.vlocker.b.j.b(context, "com.tigerknows") || com.vlocker.b.j.b(context, "com.google.android.apps.maps");
    }

    private void h() {
        if (this.s != null) {
            this.s.a();
        }
    }

    private void i() {
        a(this.b);
        if (this.s != null) {
            this.s.c();
        }
    }

    private void j() {
        if (this.s != null) {
            this.s.b();
        }
    }

    private synchronized void k() {
        if (!this.q) {
            a(this.b);
            n();
            this.q = true;
            m();
            this.c.setVisibility(0);
            if (this.c != null && this.c.getParent() == null) {
                this.d.addView(this.c, new LayoutParams(-2, -2));
            }
            if (this.o) {
                this.c.getViewTreeObserver().addOnPreDrawListener(new k(this));
            } else {
                this.c.setY((float) this.d.getHeight());
                d();
            }
        }
    }

    private synchronized void l() {
        a((float) this.d.getHeight(), false, this.a);
    }

    private void m() {
        if (this.c == null && !this.g) {
            this.g = true;
            this.c = View.inflate(this.b, R.layout.l_cover_toolbox, null);
            this.e = this.c.findViewById(R.id.toolbox_title_container);
            this.e.setOnTouchListener(this.y);
            this.f = this.c.findViewById(R.id.toolbox_indicator);
            q();
            this.i = new w(this, null);
            this.h = new aa(this, null);
            this.j = new s(this, null);
            this.k = new u(this, null);
            s();
            t();
        }
        if (this.c != null && a.a(this.b).al()) {
        }
    }

    private void n() {
        this.w.clear();
        String[] split = a.a(this.b).be().split("\\|");
        int i = 0;
        while (i < split.length) {
            if (!(split[i] == null || "".equals(split[i]))) {
                if ("vlocker_map".equals(split[i])) {
                    if (b(this.b)) {
                        this.w.add(a(split[i]));
                    } else {
                        a.a(this.b).e("vlocker_map", false);
                    }
                } else if (split[i].contains("vlocker_")) {
                    this.w.add(a(split[i]));
                } else if (aj.c(this.b, split[i]) != -1) {
                    this.w.add(a(split[i]));
                } else {
                    a.a(this.b).e(split[i], false);
                }
            }
            i++;
        }
    }

    private void o() {
        this.x = (this.b.getResources().getDisplayMetrics().widthPixels - (this.b.getResources().getDimensionPixelSize(R.dimen.toolbox_margin_gridview) * 2)) / 4;
    }

    private void p() {
        this.v = new m(this);
    }

    private void q() {
        a(this.b);
        n();
        this.u = (MyGridView) this.c.findViewById(R.id.gv_cover_toolbox);
        this.u.setNumColumns(4);
        o();
        p();
        this.u.setAdapter(this.v);
        this.u.setOnItemClickListener(new n(this));
    }

    private void r() {
        if (VERSION.SDK_INT >= 19) {
            this.A = h.d(this.b);
        } else if (a.a(this.b).ai() == 0) {
            this.A = 0;
        } else {
            this.A = h.d(this.b);
        }
    }

    private void s() {
        this.B = new an(this.b, this.r);
        this.C = new c(this.b, this.r);
        this.D = new d(this.b, this.r);
        this.E = new h(this.b, this.r);
        this.F = new al(this.b, this.r);
        this.G = new am(this.b, this.r);
    }

    private void t() {
        ae aeVar = new ae(this, (ImageButton) this.c.findViewById(R.id.wifi_btn), this.B, R.drawable.l_toolbox_icon_wifi_normal, R.drawable.l_toolbox_icon_wifi_active);
        ae aeVar2 = new ae(this, (ImageButton) this.c.findViewById(R.id.auto_brightness_btn), (ImageView) this.c.findViewById(R.id.auto_brightness_clip), this.c.findViewById(R.id.auto_brightness_layout), this.c.findViewById(R.id.brightness_seekbar), (c) this.C, R.drawable.l_tools_auto_bridness_nomal, R.drawable.l_tools_auto_bridness_select);
        ae aeVar3 = new ae(this, (ImageButton) this.c.findViewById(R.id.data_btn), this.D, R.drawable.l_toolbox_icon_data_normal, R.drawable.l_toolbox_icon_data_active);
        ae aeVar4 = new ae(this, (ImageButton) this.c.findViewById(R.id.fly_btn), this.E, R.drawable.l_toolbox_icon_airplane_normal, R.drawable.l_toolbox_icon_airplane_active);
        ae aeVar5 = new ae(this, (ImageButton) this.c.findViewById(R.id.vibrate_btn), this.F, R.drawable.l_toolbox_icon_vibrator_normal, R.drawable.l_toolbox_icon_vibrator_active);
        ae aeVar6 = new ae(this, (ImageButton) this.c.findViewById(R.id.mute_btn), this.G, R.drawable.l_toolbox_icon_mute_normal, R.drawable.l_toolbox_icon_mute_active);
        aeVar4.a(new r(this, aeVar, aeVar3));
        this.H.add(aeVar);
        this.H.add(aeVar3);
        this.H.add(aeVar4);
        this.H.add(aeVar6);
        this.H.add(aeVar5);
        this.H.add(aeVar2);
    }

    public int a() {
        return this.c != null ? this.c.getHeight() : 1;
    }

    public void a(float f) {
        this.f.animate().rotationX(f).setDuration(120).start();
    }

    public synchronized void a(int i) {
        float f = 1.0f;
        synchronized (this) {
            int height = this.d.getHeight() - i;
            if (!this.r.a || height >= this.z) {
                float a = ((float) height) / ((float) a());
                if (a <= 1.0f) {
                    f = a;
                }
                if (this.c != null && height < a()) {
                    this.c.setY((float) i);
                }
                b(f);
            }
        }
    }

    public void a(View view, MotionEvent motionEvent) {
        this.y.onTouch(view, motionEvent);
    }

    public void a(z zVar) {
        this.s = zVar;
    }

    public synchronized void a(boolean z) {
        try {
            ViewPropertyAnimator animate = this.c.animate();
            animate.cancel();
            if (z) {
                animate.translationY((float) (this.d.getHeight() - this.z)).setInterpolator(new DecelerateInterpolator()).setDuration(200).start();
            } else {
                animate.translationY((float) this.d.getHeight()).setInterpolator(new AccelerateInterpolator()).setDuration(200).start();
            }
            animate.setListener(new o(this, z));
        } catch (Exception e) {
        }
    }

    public boolean b() {
        return this.n;
    }

    public int c() {
        int identifier = this.b.getResources().getIdentifier("status_bar_height", "dimen", "android");
        return identifier > 0 ? this.b.getResources().getDimensionPixelSize(identifier) : 0;
    }

    public void d() {
        for (ae a : this.H) {
            a.a();
        }
        this.v.notifyDataSetChanged();
    }

    public void e() {
        k();
    }

    public void f() {
        l();
    }

    public boolean g() {
        return this.c.getY() != 0.0f && this.c.getY() < ((float) this.d.getHeight());
    }
}
