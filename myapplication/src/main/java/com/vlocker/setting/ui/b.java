package com.vlocker.setting.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.vlocker.b.p;
import com.vlocker.locker.R;
import com.vlocker.security.MoSecurityApplication;
import com.vlocker.setting.SettingService;
import com.vlocker.setting.common.receiver.e;
import com.vlocker.setting.common.receiver.f;

public class b implements f {
    private static b l = null;
    private Context a = MoSecurityApplication.a();
    private LayoutParams b = d();
    private LayoutParams c = g();
    private boolean d;
    private boolean e;
    private WindowManager f = ((WindowManager) this.a.getSystemService("window"));
    private View g;
    private View h = LayoutInflater.from(this.a).inflate(R.layout.accesbility_guide_detail, null);
    private View i;
    private e j;
    private int k = Math.min(this.f.getDefaultDisplay().getWidth(), this.f.getDefaultDisplay().getHeight());
    private Handler m = new Handler();

    public b() {
        this.h.setFocusableInTouchMode(true);
        this.i = this.h.findViewById(R.id.tip_detail_layout);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.i.getLayoutParams();
        layoutParams.width = this.k;
        this.i.setLayoutParams(layoutParams);
        this.g = LayoutInflater.from(this.a).inflate(R.layout.accesbility_guide_setting, null);
        this.g.setFocusableInTouchMode(true);
        this.g.setOnClickListener(new c(this));
        this.h.setOnKeyListener(new e(this));
        this.h.setOnClickListener(new g(this));
    }

    private int a(View view) {
        view.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
        return view.getMeasuredWidth();
    }

    public static b a() {
        if (l == null) {
            l = new b();
        }
        return l;
    }

    private void a(boolean z) {
        int a = a(this.g);
        if (z) {
            this.b.x = -a;
            try {
                if (this.g.getParent() != null) {
                    this.f.updateViewLayout(this.g, this.b);
                }
            } catch (Exception e) {
            }
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{0, 100});
        ofInt.setDuration(300);
        ofInt.setInterpolator(new DecelerateInterpolator());
        ofInt.addListener(new i(this, z));
        ofInt.addUpdateListener(new k(this, z, a));
        ofInt.start();
    }

    private void b(boolean z) {
        Animation animationSet = new AnimationSet(true);
        Animation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        Animation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
        if (z) {
            animationSet.addAnimation(alphaAnimation);
        } else {
            animationSet.addAnimation(alphaAnimation2);
        }
        animationSet.setFillAfter(true);
        animationSet.setInterpolator(new DecelerateInterpolator());
        animationSet.setDuration(300);
        animationSet.setAnimationListener(new l(this, z));
        this.i.startAnimation(animationSet);
    }

    public static boolean h() {
        Object propertyByName = com.vlocker.setting.a.b.getPropertyByName("ro.build.user");
        return !TextUtils.isEmpty(propertyByName) && "letv".equals(propertyByName.toLowerCase());
    }

    private void i() {
        if (!this.d) {
            try {
                if (this.g.getParent() == null) {
                    this.f.addView(this.g, this.b);
                }
                this.d = true;
                a(true);
                l();
            } catch (Exception e) {
            }
        }
    }

    private void j() {
        if (this.d) {
            try {
                a(false);
            } catch (Exception e) {
            }
        }
    }

    private void k() {
        if (this.e) {
            try {
                b(false);
                p.a(this.a, "Vlocker_Click_GuideBall_Accessibility_Rescue_PPC_TF", "status", "shrink");
            } catch (Exception e) {
            }
        }
    }

    private void l() {
        if (this.j == null) {
            this.j = new e(this.a);
            this.j.a(this);
            this.j.a();
        }
    }

    private void m() {
        if (this.j != null) {
            try {
                this.j.b();
                this.j = null;
            } catch (Exception e) {
            }
        }
    }

    public void b() {
        try {
            j();
            k();
            m();
        } catch (Exception e) {
        }
    }

    public void c() {
        if (!this.e) {
            try {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.i.getLayoutParams();
                int e = SettingService.e(this.a);
                if (SettingService.b()) {
                    layoutParams.addRule(10);
                    this.h.findViewById(R.id.tip_image).setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.accesbility_guide_original_img));
                } else {
                    if (e < 5) {
                        layoutParams.addRule(12);
                    } else {
                        layoutParams.addRule(10);
                    }
                    if (e < 6) {
                        this.h.findViewById(R.id.tip_image).setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.accesbility_guide_img));
                    } else {
                        this.h.findViewById(R.id.tip_image).setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.accesbility_guide_slide_img));
                    }
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.h.findViewById(R.id.tip_image).getLayoutParams();
                    layoutParams2.width = this.k;
                    if (h()) {
                        layoutParams2.height = (this.k * 23) / 36;
                    }
                    this.h.findViewById(R.id.tip_image).setLayoutParams(layoutParams2);
                }
                this.i.setLayoutParams(layoutParams);
                if (this.h.getParent() == null) {
                    this.f.addView(this.h, this.c);
                }
                this.e = true;
                b(true);
                l();
                p.a(this.a, "Vlocker_Click_GuideBall_Accessibility_Rescue_PPC_TF", "status", "expand");
            } catch (Exception e2) {
            }
        }
    }

    public LayoutParams d() {
        LayoutParams layoutParams = new LayoutParams();
        layoutParams.systemUiVisibility = 1;
        if (VERSION.SDK_INT <= 18) {
            layoutParams.type = 2002;
        } else {
            layoutParams.type = 2005;
        }
        layoutParams.gravity = 21;
        layoutParams.format = 1;
        layoutParams.flags = 1832;
        layoutParams.width = -2;
        layoutParams.height = -2;
        return layoutParams;
    }

    public void e() {
        b();
    }

    public void f() {
    }

    public LayoutParams g() {
        LayoutParams layoutParams = new LayoutParams();
        layoutParams.systemUiVisibility = 1;
        if (VERSION.SDK_INT <= 18) {
            layoutParams.type = 2002;
        } else {
            layoutParams.type = 2005;
        }
        layoutParams.gravity = 48;
        layoutParams.format = 1;
        layoutParams.flags = 1056;
        layoutParams.width = -1;
        layoutParams.height = -1;
        return layoutParams;
    }
}
