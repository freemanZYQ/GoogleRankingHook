package com.vlocker.locker.c;

import android.content.Context;
import android.graphics.Typeface;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.qq.e.comm.constants.ErrorCode.AdError;
import com.vlocker.b.j;
import com.vlocker.c.a;
import com.vlocker.locker.R;
import com.vlocker.locker.b.p;
import com.vlocker.m.aa;
import com.vlocker.settings.QuestionActivity;
import com.vlocker.ui.cover.LockPatternView;
import com.vlocker.ui.cover.ag;
import com.vlocker.ui.cover.f;
import com.vlocker.ui.cover.g;
import com.vlocker.ui.cover.h;
import com.vlocker.ui.cover.l;
import com.vlocker.ui.cover.r;
import java.util.List;

public class ao extends a implements ag {
    r e = new ap(this);
    OnClickListener f = new as(this);
    Runnable g = new au(this);
    private LockPatternView h;
    private TextView i;
    private ImageView j;
    private TextView k;
    private TextView l;
    private Animation m;
    private a n;
    private boolean o;
    private Runnable p = new ar(this);
    private Handler q = new at(this);
    private long r;
    private CountDownTimer s = null;

    public ao(Context context, p pVar) {
        this.a = context;
        this.c = pVar;
        this.n = a.a(context);
        this.d = "pattern_page";
    }

    private void a(List list) {
        if (l.b(list, this.a)) {
            m();
            return;
        }
        if ("moxiu-launcher".equals(j.p(this.a))) {
            com.vlocker.b.p.a(this.a, "Vlocker_Wrong_Pattern_Password_PPC_TF", new String[0]);
        }
        this.h.setDisplayMode(2);
        if (list.size() >= 4) {
            f.f++;
            int i = 5 - f.f;
            if (a.a(this.a).v() && f.f >= 2) {
                k();
            }
            if (i >= 0) {
                if (i == 0) {
                    this.m = AnimationUtils.loadAnimation(this.a, R.anim.l_shake_x);
                    this.h.b();
                    this.h.setEnabled(false);
                    this.k.setText(this.a.getString(R.string.gesture_password_gesturepwd_unlock_failed_tip));
                } else {
                    this.m = AnimationUtils.loadAnimation(this.a, R.anim.l_shake_x);
                    this.k.setText(this.a.getString(R.string.gesture_password_unlock_failed_tip) + i + this.a.getString(R.string.gesture_password_unlock_failed_tip_num));
                }
                this.k.setTextColor(-4452850);
                this.m.setAnimationListener(new aq(this, i));
                this.k.startAnimation(this.m);
                if (((AudioManager) this.a.getSystemService("audio")).getRingerMode() != 0 && a.a(this.a).au()) {
                    aa.a(this.a);
                }
            }
        } else {
            this.k.setTextColor(this.n.j());
            this.k.setText(R.string.lockpattern_recording_incorrect_too_short);
        }
        if (f.f < 5) {
            this.h.post(this.p);
        }
    }

    private void m() {
        p();
        f.f = 0;
        this.h.e();
        this.h.b();
        f.c = 3;
        f.a = 0;
        f.b = 0;
        com.vlocker.b.p.b("101000", "101003");
        this.c.f((int) AdError.PLACEMENT_ERROR);
        if ("moxiu-launcher".equals(j.p(this.a))) {
            com.vlocker.b.p.a(this.a, "Vlocker_Times_Unlock_PPC_TF", new String[0]);
        }
        com.vlocker.b.p.a(this.a, "v_unlock_success", "101000", "101003");
    }

    private void n() {
        if (this.o) {
            QuestionActivity.b(this.a);
        } else if (h.h == 1 && h.a == 1) {
            this.c.a("main_page", true);
        } else {
            this.c.b(false);
        }
    }

    private void o() {
        if (this.o) {
            QuestionActivity.b(this.a);
        } else {
            this.c.a("main_page", true);
        }
    }

    private void p() {
        e();
        j();
    }

    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.b == null) {
            this.b = layoutInflater.inflate(R.layout.l_gesturepassword_unlock, null);
        }
        this.h = (LockPatternView) this.b.findViewById(R.id.gesturepwd_unlock_lockview);
        this.h.setOnPatternListener(this.e);
        this.h.setTactileFeedbackEnabled(false);
        this.k = (TextView) this.b.findViewById(R.id.gesturepwd_unlock_text);
        this.i = (TextView) this.b.findViewById(R.id.gesturepwd_unlock_cancel);
        this.j = (ImageView) this.b.findViewById(R.id.l_more_pattern_img);
        this.i.setOnClickListener(this.f);
        this.i.setTextColor(this.n.j());
        this.k.setTextColor(this.n.j());
        this.j.setOnClickListener(this.f);
        this.m = AnimationUtils.loadAnimation(this.a, R.anim.l_shake_x);
        this.l = (TextView) this.b.findViewById(R.id.lk_pattern_date_time_tv);
        this.l.setTypeface(Typeface.createFromAsset(this.a.getAssets(), "fonts/time.ttf"));
        if (this.n.ao()) {
            this.l.setVisibility(0);
        }
        return this.b;
    }

    public void a() {
        try {
            m();
        } catch (Exception e) {
            if (this.c != null) {
                this.c.e((int) AdError.PLACEMENT_ERROR);
            }
        }
    }

    public void a(int i) {
        this.h.setDisplayMode(2);
        int i2 = 5 - f.f;
        if (i2 >= 0) {
            this.m = AnimationUtils.loadAnimation(this.a, R.anim.l_shake_x);
            if (i >= 4) {
                a((CharSequence) "");
            } else {
                if (i2 > 0) {
                    this.k.setText("指纹验证失败，请重试");
                }
                this.k.setTextColor(-4452850);
            }
            this.m.setAnimationListener(new aw(this, i, i2));
            if (i < 4) {
                this.k.startAnimation(this.m);
                if (((AudioManager) this.a.getSystemService("audio")).getRingerMode() != 0 && a.a(this.a).au()) {
                    aa.a(this.a);
                }
            }
        }
        if (f.f < 5) {
            this.h.post(this.p);
        }
    }

    public void a(CharSequence charSequence) {
        this.k.setTextColor(this.n.j());
        this.k.setText("指纹错误过多，请输入密码");
        this.q.removeMessages(1);
    }

    public void a(String str) {
        if (a.a(this.a).Q() && this.k != null && this.h.isEnabled()) {
            if (!TextUtils.isEmpty(str)) {
                this.k.setText(str);
            }
            this.k.setTextColor(this.n.j());
        }
    }

    public void a(String str, String str2) {
        if (this.l == null) {
            return;
        }
        if (this.n.ao()) {
            this.l.setVisibility(0);
            this.l.setText(str);
            return;
        }
        this.l.setVisibility(8);
    }

    public void b() {
    }

    public void c() {
    }

    public void d() {
        if (g.b() && g.f()) {
            e();
        }
    }

    public void e() {
        if (a.a(this.a).Q() && this.k != null && this.h.isEnabled()) {
            this.k.setText(this.a.getResources().getString(R.string.gesture_password_guide_draw_btn));
            this.k.setTextColor(this.n.j());
        }
    }

    public void f() {
        if (a.a(this.a).Q() && this.k != null && this.h.isEnabled()) {
            this.k.setText(this.a.getResources().getString(R.string.lk_number_password_ui_from_tool_tip));
            this.k.setTextColor(this.n.j());
        }
    }

    public void h() {
        if (this.b != null) {
            this.b.setAlpha(1.0f);
        }
    }

    public void j() {
        if (this.i != null) {
            this.i.setText(R.string.cancel);
        }
        this.o = false;
        if (a.a(this.a).ao()) {
            if (this.i != null) {
                this.i.setVisibility(8);
            }
            if (this.j != null) {
                this.j.setVisibility(0);
            }
        }
    }

    public void k() {
        if (this.i != null) {
            this.i.setVisibility(0);
            this.i.setText(R.string.forget_password);
        }
        if (this.j != null) {
            this.j.setVisibility(8);
        }
        this.o = true;
    }

    public void l() {
        this.r = 0;
        this.k.setText(R.string.gesture_password_guide_draw_btn);
        this.k.setTextColor(this.n.j());
        this.h.setEnabled(true);
        f.f = 0;
        j();
    }
}
