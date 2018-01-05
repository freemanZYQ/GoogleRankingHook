package com.vlocker.g;

import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import com.vlocker.i.a;
import com.vlocker.locker.R;
import com.vlocker.locker.b.p;
import com.vlocker.m.aj;
import com.vlocker.m.be;
import com.vlocker.m.l;
import com.vlocker.security.MoSecurityApplication;
import com.vlocker.ui.cover.i;
import com.vlocker.ui.view.GifImageView;
import com.vlocker.ui.widget.AlwaysMarqueeTextView;
import java.util.Date;
import org.json.JSONObject;

public class b implements OnClickListener, OnLongClickListener, a {
    private static b t;
    public ViewGroup a;
    public j b;
    private p c;
    private Context d = MoSecurityApplication.a();
    private int e = l.a(this.d, 5.0f);
    private View f;
    private View g;
    private GifImageView h;
    private AlwaysMarqueeTextView i;
    private View j;
    private a k;
    private int l = -1;
    private com.vlocker.c.a m = com.vlocker.c.a.a(this.d);
    private Handler n = new Handler();
    private boolean o;
    private boolean p = true;
    private boolean q;
    private com.vlocker.ui.view.p r;
    private Runnable s = new c(this);
    private OnTouchListener u = new d(this);
    private boolean v = false;

    private b() {
    }

    public static b a() {
        if (t == null) {
            synchronized (b.class) {
                if (t == null) {
                    t = new b();
                }
            }
        }
        return t;
    }

    private void a(float f, boolean z) {
        if (!z) {
            a(false, false);
        }
        ViewPropertyAnimator animate = this.h.animate();
        animate.setListener(null);
        animate.cancel();
        animate.setListener(new f(this, z));
        animate.translationY(f).setDuration(800).setInterpolator(new DecelerateInterpolator(2.0f)).start();
    }

    private void a(boolean z, boolean z2) {
        if (z) {
            this.j.setAlpha(0.0f);
            if (z2) {
                this.i.setText("再见啦( ^_^ )/~~");
            } else {
                this.i.setText((CharSequence) this.k.a.get(this.l));
            }
        }
        ViewPropertyAnimator animate = this.j.animate();
        animate.setListener(null);
        animate.cancel();
        animate.setListener(new g(this, z));
        animate.alpha(z ? 1.0f : 0.0f).setDuration(500).setInterpolator(new DecelerateInterpolator(2.0f)).start();
    }

    private void l() {
        if (!this.m.cy().equals(this.k.t)) {
            be.a(this.d, this.k.s);
            com.vlocker.b.p.a(this.d, "Vlocker_Show_LockerIcon_PPC_RR", "name", this.k.t);
            this.m.K(this.k.t);
        }
        this.g.setVisibility(0);
        LayoutParams layoutParams = (LayoutParams) this.h.getLayoutParams();
        layoutParams.width = l.a((float) ((int) ((((float) this.k.r.getWidth()) / ((float) this.k.r.getHeight())) * 30.0f)));
        this.h.setLayoutParams(layoutParams);
        this.h.setScaleType(ScaleType.FIT_XY);
        this.h.a();
        if (this.k.d == null || this.k.d.getHeight() <= 0) {
            layoutParams = (LayoutParams) this.j.getLayoutParams();
            layoutParams.width = -2;
            this.j.setLayoutParams(layoutParams);
            this.j.setBackgroundDrawable(this.d.getResources().getDrawable(R.drawable.icon_tip_bg));
            this.j.setPadding(0, l.a(3.0f), 0, 0);
        } else {
            layoutParams = (LayoutParams) this.j.getLayoutParams();
            layoutParams.width = l.a((float) ((int) ((((float) this.k.d.getWidth()) / ((float) this.k.d.getHeight())) * 26.0f)));
            this.j.setLayoutParams(layoutParams);
            this.j.setBackgroundDrawable(new BitmapDrawable(this.d.getResources(), this.k.d));
            this.j.setPadding(0, l.a(3.0f), 0, 0);
        }
        if (this.k.a.size() > 0) {
            if (this.k.e) {
                this.l = 0;
                o();
            } else {
                this.j.setVisibility(8);
            }
        }
        this.i.setTextColor(Color.parseColor("#6a310e"));
        if (!TextUtils.isEmpty(this.k.b)) {
            try {
                this.i.setTextColor(Color.parseColor(this.k.b));
            } catch (Exception e) {
            }
        }
        this.h.setTranslationY(0.0f);
        if (this.c.m()) {
            b(false);
        }
    }

    private void m() {
        this.r = new e(this);
    }

    private void n() {
        if (d() && !this.o && this.k != null) {
            this.l++;
            if (this.l < 0 || this.l >= this.k.a.size()) {
                com.vlocker.b.p.a(this.d, "Vlocker_Click_LockerIcon_PPC_RR", "name", this.k.t);
                if ("AppDown".equals(this.k.f)) {
                    this.b = new j(this.k);
                    this.b.a();
                    return;
                }
                new l(this.k).a();
                return;
            }
            o();
        }
    }

    private void o() {
        if (this.l >= 0 && this.l < this.k.a.size()) {
            if (this.j.getVisibility() != 0) {
                this.j.setVisibility(0);
            }
            a(true, false);
            this.n.removeCallbacks(this.s);
            this.n.postDelayed(this.s, 3000);
        }
    }

    public void a(View view, View view2, p pVar) {
        this.c = pVar;
        this.c.a((a) this);
        this.f = view2;
        this.a = (ViewGroup) view.getRootView();
        this.g = this.f.findViewById(R.id.icon_layout);
        this.h = (GifImageView) this.f.findViewById(R.id.icon_img);
        this.i = (AlwaysMarqueeTextView) this.f.findViewById(R.id.icon_text);
        this.j = this.f.findViewById(R.id.icon_text_layout);
        this.g.setOnClickListener(this);
        this.g.setOnTouchListener(this.u);
        this.g.setOnLongClickListener(this);
    }

    public void a(a aVar) {
        this.k = aVar;
        if (this.k != null) {
            a(true);
        }
    }

    public void a(String str) {
        v.a(this.d, str);
        try {
            com.vlocker.b.p.a(this.d, "Vlocker_GetMsg_LockerIcon_PPC_RR", "name", new JSONObject(str).getJSONObject("train").getString("resid"));
        } catch (Exception e) {
        }
    }

    public void a(boolean z) {
        b();
        if (this.g != null && new Date().getDate() != this.m.cx()) {
            if (this.k == null) {
                if (System.currentTimeMillis() - this.m.cw() > 7200000 && v.b(this.d) != null) {
                    v.a(this.d);
                }
            } else if (c() || System.currentTimeMillis() < this.k.y || System.currentTimeMillis() >= this.k.z) {
                e();
            } else if (this.k.r == null) {
                this.k = null;
            } else {
                this.h.setGifUrl(this.k.q);
                m();
                this.h.setDataLoadListener(this.r);
            }
        }
    }

    public void a_(int i) {
    }

    public void b() {
        this.l = -1;
        if (this.j != null) {
            this.j.setVisibility(8);
        }
        if (this.g != null) {
            this.g.setVisibility(8);
        }
    }

    public void b(boolean z) {
        int i = 0;
        if (this.j != null) {
            View view = this.j;
            int i2 = (!z || this.k == null) ? 4 : 0;
            view.setVisibility(i2);
        }
        if (this.g != null) {
            View view2 = this.g;
            if (!z || this.k == null) {
                i = 4;
            }
            view2.setVisibility(i);
        }
    }

    public boolean c() {
        if ("AppDown".equals(this.k.f)) {
            if (aj.a(this.k.o)) {
                return true;
            }
        } else if (this.k.s == null && this.k.a.size() <= 0) {
            return true;
        }
        return "PullUp".equals(this.k.f) && this.k.s == null;
    }

    public boolean d() {
        return this.h.getY() != 0.0f && this.h.getY() < ((float) this.g.getHeight());
    }

    public void e() {
        if (this.j != null) {
            this.j.setVisibility(8);
        }
        if (this.g != null) {
            this.g.setVisibility(8);
        }
        if (this.k != null) {
            v.b(this.d, this.k.t);
        }
        a(null);
        if (v.b(this.d) != null) {
            v.a(this.d);
        }
    }

    public void f() {
        if (this.j != null) {
            this.j.setVisibility(8);
        }
        if (this.g != null) {
            this.g.setVisibility(8);
        }
        if (this.k != null) {
            v.b(this.d, this.k.t);
        }
        a(null);
        this.m.o(System.currentTimeMillis());
    }

    public void g() {
    }

    public void h() {
        b(false);
    }

    public void i() {
        a(false);
    }

    public void j() {
        if (this.b != null) {
            this.b.c();
            a().f();
        }
    }

    public void k() {
        if (this.h != null) {
            ViewPropertyAnimator animate = this.h.animate();
            if (animate != null && !this.v) {
                animate.cancel();
                Object iVar = new i();
                iVar.a(new AccelerateDecelerateInterpolator(), 200, false);
                iVar.a(new BounceInterpolator(), 500, true);
                animate.translationYBy((float) ((-this.h.getHeight()) / 4)).setInterpolator(iVar).setDuration(iVar.a());
                AnimatorListener hVar = new h(this, animate);
                this.v = true;
                animate.setListener(hVar);
                animate.start();
            }
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.icon_layout:
                if (!this.q) {
                    n();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public boolean onLongClick(View view) {
        if (!this.p || this.q || this.o) {
            return false;
        }
        if (!(this.g == null || this.k == null)) {
            if (this.j.getVisibility() != 0) {
                this.j.setVisibility(0);
            }
            this.i.setTextColor(Color.parseColor("#6a310e"));
            LayoutParams layoutParams = (LayoutParams) this.j.getLayoutParams();
            layoutParams.width = -2;
            this.j.setLayoutParams(layoutParams);
            this.j.setBackgroundDrawable(this.d.getResources().getDrawable(R.drawable.icon_tip_bg));
            this.j.setPadding(0, l.a(3.0f), 0, 0);
            a(true, true);
            this.q = true;
            this.n.removeCallbacks(this.s);
            this.n.postDelayed(new i(this), 1000);
        }
        return true;
    }
}
