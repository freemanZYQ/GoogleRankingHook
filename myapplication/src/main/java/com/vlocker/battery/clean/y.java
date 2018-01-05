package com.vlocker.battery.clean;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.moxiu.b.d.c;
import com.vlocker.c.a;
import com.vlocker.e.j;
import com.vlocker.locker.R;
import com.vlocker.locker.b.p;
import com.vlocker.m.l;
import com.vlocker.msg.ao;
import com.vlocker.security.MoSecurityApplication;
import com.vlocker.theme.f.e;
import com.vlocker.theme.imageloader.RecyclingImageView;
import com.vlocker.ui.view.BatteryChargeView;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

public class y implements OnClickListener, OnTouchListener {
    private static y E;
    private View A;
    private View B;
    private p C;
    private a D;
    private boolean F;
    private int G;
    private a H = a.a(MoSecurityApplication.a());
    private Handler I = new Handler();
    private int J;
    private int K;
    private Runnable L = new aa(this);
    private t M = new af(this);
    private List a = new ArrayList();
    private RelativeLayout b;
    private TextView c;
    private TextView d;
    private TextView e;
    private ImageView f;
    private LinearLayout g;
    private LinearLayout h;
    private RelativeLayout i;
    private RecyclingImageView j;
    private RecyclingImageView k;
    private TextView l;
    private TextView m;
    private CleanAnimView n;
    private View o;
    private View p;
    private View q;
    private View r;
    private TextView s;
    private View t;
    private LinearLayout u;
    private LinearLayout v;
    private RelativeLayout w;
    private TextView x;
    private CleanMaskButtonView y;
    private CleanIconAnimView z;

    private y() {
        l();
        n();
    }

    public static y a() {
        if (E == null) {
            E = new y();
        }
        return E;
    }

    private void c(int i) {
        if (this.v != null) {
            LayoutParams layoutParams = (LayoutParams) this.v.getLayoutParams();
            layoutParams.topMargin = i;
            this.v.setLayoutParams(layoutParams);
        }
    }

    private void l() {
        this.b = (RelativeLayout) LayoutInflater.from(MoSecurityApplication.a()).inflate(R.layout.battery_clean_msg_item, null);
        this.c = (TextView) this.b.findViewById(R.id.tv_battery_clean_msg_title);
        this.d = (TextView) this.b.findViewById(R.id.tv_battery_clean_msg_des_num);
        this.e = (TextView) this.b.findViewById(R.id.tv_battery_clean_msg_des_text);
        this.f = (ImageView) this.b.findViewById(R.id.iv_battery_clean_msg_icon);
        this.g = (LinearLayout) this.b.findViewById(R.id.layout_view_app_icon);
        this.h = (LinearLayout) this.b.findViewById(R.id.layout_view_des);
        this.d.setTypeface(Typeface.createFromAsset(MoSecurityApplication.a().getAssets(), "fonts/setting_font.otf"));
    }

    private void m() {
        if (!(this.v == null || this.v.getParent() == null)) {
            this.u.removeView(this.v);
        }
        if (r()) {
            this.v = (LinearLayout) View.inflate(MoSecurityApplication.a(), R.layout.battery_clean_ad_large, null);
            this.k = (RecyclingImageView) this.v.findViewById(R.id.iv_battery_clean_ad_img);
        } else {
            this.v = (LinearLayout) View.inflate(MoSecurityApplication.a(), R.layout.battery_clean_ad_small, null);
        }
        this.u.addView(this.v);
        this.j = (RecyclingImageView) this.v.findViewById(R.id.iv_battery_clean_ad_icon);
        this.l = (TextView) this.v.findViewById(R.id.tv_battery_clean_ad_title);
        this.m = (TextView) this.v.findViewById(R.id.tv_battery_clean_ad_des);
        this.w = (RelativeLayout) this.v.findViewById(R.id.btn_battery_clean_ad);
        this.w.setOnClickListener(this);
        this.x = (TextView) this.v.findViewById(R.id.tv_btn_battery_clean_ad);
        this.y = (CleanMaskButtonView) this.v.findViewById(R.id.mask_btn_battery_clean_ad);
        this.v.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
        this.G = this.v.getMeasuredHeight();
        c(-this.G);
    }

    private void n() {
        this.i = (RelativeLayout) LayoutInflater.from(MoSecurityApplication.a()).inflate(R.layout.battery_clean_main_layout, null);
        this.i.setOnTouchListener(this);
        this.B = this.i.findViewById(R.id.btn_clean_close);
        this.B.setOnClickListener(this);
        this.t = this.i.findViewById(R.id.iv_battery_clean_complete_bg);
        this.s = (TextView) this.i.findViewById(R.id.tv_battery_clean_save_time);
        this.u = (LinearLayout) this.i.findViewById(R.id.layout_battery_clean_ad);
        this.z = (CleanIconAnimView) this.i.findViewById(R.id.clean_icon_anim_view);
        this.p = this.i.findViewById(R.id.clean_anim_star_left_01_view);
        this.q = this.i.findViewById(R.id.clean_anim_star_left_02_view);
        this.r = this.i.findViewById(R.id.clean_anim_star_right_view);
        this.o = this.i.findViewById(R.id.clean_anim_laugh_view);
        this.n = (CleanAnimView) this.i.findViewById(R.id.clean_anim_view);
        this.n.setCallBack(this.M);
        this.s.setTypeface(Typeface.createFromAsset(MoSecurityApplication.a().getAssets(), "fonts/setting_font.otf"));
        this.A = this.i.findViewById(R.id.view_battery_clean_main_bg);
    }

    private void o() {
        q();
        this.H.S(this.H.cr() + 1);
    }

    private void p() {
        q();
        this.H.T(this.H.cs() + 1);
    }

    private void q() {
        int date = new Date().getDate();
        if (date != this.H.ct()) {
            this.H.U(date);
            this.H.S(0);
            this.H.T(0);
        }
    }

    private boolean r() {
        if (this.D == null || this.D.i.size() <= 0) {
            return false;
        }
        this.J = (int) (Math.random() * ((double) this.D.i.size()));
        return true;
    }

    private void s() {
        this.t.setAlpha(0.0f);
        this.s.setAlpha(0.0f);
        this.A.setAlpha(0.0f);
        this.n.setTranslationX(0.0f);
        this.n.setScaleX(1.0f);
        this.n.setScaleY(1.0f);
        this.B.setAlpha(0.0f);
        this.B.setVisibility(8);
        this.o.setTranslationX(0.0f);
        this.o.setAlpha(0.0f);
        this.o.setScaleX(1.53f);
        this.o.setScaleY(1.53f);
        this.p.setVisibility(8);
        this.q.setVisibility(8);
        this.r.setVisibility(8);
        this.z.a();
        this.z.setAlpha(0.0f);
        c(-this.G);
        this.n.setVisibility(0);
        this.u.setVisibility(4);
        this.i.setAlpha(1.0f);
    }

    private void t() {
        this.t.animate().alpha(1.0f).setInterpolator(new AccelerateInterpolator()).setDuration(400).setStartDelay(100).start();
        this.s.animate().alpha(1.0f).setInterpolator(new AccelerateInterpolator()).setDuration(400).setStartDelay(100).start();
        this.n.animate().translationX((float) l.a(-100.0f)).scaleX(0.65f).scaleY(0.65f).setDuration(400).setInterpolator(new AccelerateDecelerateInterpolator()).start();
        this.o.animate().translationX((float) l.a(-100.0f)).scaleX(1.0f).scaleY(1.0f).alpha(1.0f).setDuration(400).setInterpolator(new AccelerateDecelerateInterpolator()).start();
        u();
        if (v()) {
            g();
            this.B.setVisibility(0);
            this.B.animate().alpha(1.0f).setInterpolator(new AccelerateInterpolator()).setDuration(400).setStartDelay(100).start();
            this.u.setVisibility(0);
            x();
            com.vlocker.b.p.a(MoSecurityApplication.a(), "Vlocker_Show_Ad_SavePower_PPC_RR", "from", h(), "times", this.H.cs() + "");
            return;
        }
        this.u.setVisibility(8);
        this.I.postDelayed(new ab(this), 3150);
    }

    private void u() {
        Animation loadAnimation = AnimationUtils.loadAnimation(MoSecurityApplication.a(), R.anim.battery_clean_star_left_anim);
        loadAnimation.setStartOffset(500);
        this.p.startAnimation(loadAnimation);
        this.p.setVisibility(0);
        loadAnimation = AnimationUtils.loadAnimation(MoSecurityApplication.a(), R.anim.battery_clean_star_left_anim);
        loadAnimation.setStartOffset(400);
        this.q.startAnimation(loadAnimation);
        this.q.setVisibility(0);
        this.r.startAnimation(AnimationUtils.loadAnimation(MoSecurityApplication.a(), R.anim.battery_clean_star_right_anim));
        this.r.setVisibility(0);
    }

    private boolean v() {
        int cr = this.H.cr();
        this.D = a(false);
        if (this.D == null) {
            return false;
        }
        int i = this.D.n + 1;
        return (this.D.m <= 0 || this.D.o <= 0 || i < 1) ? false : cr == this.D.m || (cr > this.D.m && i > 0 && (cr - this.D.m) % i == 0 && (cr - this.D.m) / i <= this.D.o - 1);
    }

    private void w() {
        new Thread(new ac(this)).start();
    }

    private void x() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.setDuration(350);
        ofFloat.setStartDelay(1750);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.addUpdateListener(new ad(this));
        ofFloat.addListener(new ae(this));
        ofFloat.start();
    }

    private void y() {
        int i = 0;
        this.g.removeAllViews();
        int size = this.a.size() > 6 ? 6 : this.a.size();
        while (i < size) {
            View imageView = new ImageView(MoSecurityApplication.a());
            imageView.setAlpha(0.85f);
            try {
                PackageManager packageManager = MoSecurityApplication.a().getPackageManager();
                imageView.setImageDrawable(packageManager.getPackageInfo((String) this.a.get(i), 0).applicationInfo.loadIcon(packageManager));
            } catch (Exception e) {
            }
            ViewGroup.LayoutParams layoutParams = new LayoutParams(l.a(18.0f), l.a(18.0f));
            layoutParams.gravity = 17;
            if (i > 0) {
                layoutParams.leftMargin = l.a(4.0f);
            }
            this.g.addView(imageView, layoutParams);
            i++;
        }
    }

    public a a(boolean z) {
        Object co = a.a(MoSecurityApplication.a()).co();
        if (TextUtils.isEmpty(co)) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(co);
            if (jSONArray == null || jSONArray.length() <= 0) {
                return null;
            }
            for (int i = 0; i < jSONArray.length(); i++) {
                a aVar = new a(jSONArray.optJSONObject(i));
                if (aVar != null && z) {
                    return aVar;
                }
                if (aVar != null && aVar.a()) {
                    return aVar;
                }
            }
            return null;
        } catch (JSONException e) {
            return null;
        }
    }

    public void a(int i) {
        this.K = i;
        this.a.clear();
        this.a.addAll(aj.a());
        this.s.setText((((int) (Math.random() * 40.0d)) + 20) + "");
        this.z.a(this.a);
        b(i);
    }

    public void a(p pVar) {
        this.C = pVar;
    }

    public void b() {
        if (!this.F && this.i.getParent() != null) {
            if (this.y != null) {
                this.y.b();
            }
            this.i.animate().alpha(0.0f).setInterpolator(new LinearInterpolator()).setDuration(150).setListener(new z(this)).start();
        }
    }

    public void b(int i) {
        CharSequence charSequence = "";
        switch (i) {
            case 1:
                charSequence = MoSecurityApplication.a().getString(R.string.battery_clean_msg_title, new Object[]{Integer.valueOf(this.a.size())});
                this.h.setVisibility(8);
                this.g.setVisibility(0);
                this.f.setImageResource(R.drawable.battery_clean_msg_top_icon);
                y();
                break;
            case 2:
                this.h.setVisibility(0);
                this.g.setVisibility(8);
                this.f.setImageResource(R.drawable.battery_clean_msg_top_icon);
                charSequence = MoSecurityApplication.a().getString(R.string.battery_clean_msg_low_power_title);
                this.e.setText(MoSecurityApplication.a().getString(R.string.battery_clean_msg_low_power_des));
                this.d.setText(com.vlocker.battery.saver.a.a + "%");
                break;
            case 3:
                this.h.setVisibility(0);
                this.g.setVisibility(8);
                this.f.setImageResource(R.drawable.battery_clean_msg_top_icon_memory);
                charSequence = MoSecurityApplication.a().getString(R.string.battery_clean_msg_high_memory_title);
                this.e.setText(MoSecurityApplication.a().getString(R.string.battery_clean_msg_high_memory_des));
                this.d.setText(ak.a((double) ak.a(MoSecurityApplication.a()), (double) ak.a()) + "%");
                break;
        }
        this.c.setText(charSequence);
    }

    public void b(boolean z) {
        int i = z ? 1 : 0;
        if (this.D != null && this.a.size() > i) {
            this.I.removeCallbacks(this.L);
            this.I.postDelayed(this.L, z ? 600 : 0);
            p();
            com.vlocker.b.p.a(MoSecurityApplication.a(), "Vlocker_Show_SavePower_PPC_RR", "from", h(), "times", this.H.cs() + "");
        }
    }

    public void c() {
        int date = new Date().getDate();
        if (date != this.H.cq()) {
            this.H.R(date);
            this.H.Q(0);
        }
        this.H.Q(this.H.cp() + 1);
    }

    public boolean d() {
        this.D = a(true);
        if (this.D == null) {
            return false;
        }
        int date = new Date().getDate();
        if (date == this.H.cB() || com.vlocker.battery.saver.a.a >= 35) {
            return false;
        }
        this.H.Y(date);
        return true;
    }

    public boolean e() {
        this.D = a(true);
        if (this.D == null) {
            return false;
        }
        int date = new Date().getDate();
        if (date == this.H.cC() || ak.a((double) ak.a(MoSecurityApplication.a()), (double) ak.a()) <= 70) {
            return false;
        }
        this.H.Z(date);
        return true;
    }

    public boolean f() {
        int cp = this.H.cp();
        this.D = a(true);
        if (this.D == null) {
            return false;
        }
        int i = this.D.k + 1;
        return (this.D.j <= 0 || this.D.l <= 0 || i < 1) ? false : cp == this.D.j || (cp > this.D.j && i > 0 && (cp - this.D.j) % i == 0 && (cp - this.D.j) / i <= this.D.l - 1);
    }

    public void g() {
        m();
        if (this.D != null) {
            this.l.setText(this.D.a);
            this.m.setText(this.D.b);
            this.j.a(this.D.g, 2, 13);
            this.x.setText(this.D.c);
            ArrayList arrayList = this.D.i;
            if (arrayList != null && arrayList.size() > 0 && this.k != null) {
                this.k.a((String) arrayList.get(this.J), 2, 13);
            }
        }
    }

    public String h() {
        switch (this.K) {
            case 1:
                return "EndCharging";
            case 2:
                return "LowPower";
            case 3:
                return "HighRAM";
            default:
                return "EndCharging";
        }
    }

    public View i() {
        if (BatteryChargeView.c) {
            this.c.setTextColor(e.a.getResources().getColor(R.color.msg_title_light));
            this.e.setTextColor(e.a.getResources().getColor(R.color.msg_title_light));
            this.d.setTextColor(e.a.getResources().getColor(R.color.msg_title_light));
            this.b.findViewById(R.id.msg_outer_layout).setBackgroundDrawable(e.a.getResources().getDrawable(R.drawable.l_msg_bg_blur));
        } else {
            this.c.setTextColor(e.a.getResources().getColor(R.color.msg_title_dark));
            this.e.setTextColor(e.a.getResources().getColor(R.color.msg_title_dark));
            this.d.setTextColor(e.a.getResources().getColor(R.color.msg_title_dark));
            this.b.findViewById(R.id.msg_outer_layout).setBackgroundDrawable(e.a.getResources().getDrawable(R.drawable.l_msg_bg));
        }
        return this.b;
    }

    public void j() {
        com.vlocker.msg.p.a().a("mx_clean");
    }

    public void k() {
        if (this.i.getParent() == null) {
            o();
            this.F = true;
            this.C.a(this.i, new FrameLayout.LayoutParams(-1, -1));
            w();
            this.A.animate().alpha(1.0f).setDuration(400).start();
            this.n.a();
            com.vlocker.b.p.a(MoSecurityApplication.a(), "Vlocker_Click_SavePower_PPC_RR", "from", h(), "times", this.H.cs() + "");
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_battery_clean_ad:
                b();
                if (c.c(MoSecurityApplication.a(), this.D.d)) {
                    Intent intent = new Intent();
                    if (TextUtils.isEmpty(this.D.f)) {
                        intent = MoSecurityApplication.a().getPackageManager().getLaunchIntentForPackage(this.D.d);
                    } else {
                        intent.setPackage(this.D.d);
                        intent.setData(Uri.parse(this.D.f));
                        intent.setFlags(268435456);
                    }
                    MoSecurityApplication.a().startActivity(intent);
                    com.vlocker.b.p.a(MoSecurityApplication.a(), "Vlocker_Click_Ad_SavePower_PPC_RR", "type", "open", "from", h(), "times", this.H.cs() + "");
                } else {
                    if (j.a().b("2")) {
                        j.a().c("2");
                    }
                    ao.b(MoSecurityApplication.a(), this.D.e, this.D.d, this.D.d + "_" + this.D.h);
                }
                this.C.a(null, 2);
                return;
            case R.id.btn_clean_close:
                b();
                return;
            default:
                return;
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (view.getId()) {
            case R.id.layout_battery_clean_root:
                return true;
            default:
                return false;
        }
    }
}
