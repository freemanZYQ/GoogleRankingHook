package com.vlocker.locker.c;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.qq.e.comm.constants.ErrorCode.AdError;
import com.vlocker.c.a;
import com.vlocker.locker.R;
import com.vlocker.locker.b.p;
import com.vlocker.ui.cover.ag;
import com.vlocker.ui.cover.f;
import com.vlocker.ui.cover.g;
import com.vlocker.ui.widget.view.LockNumberCoverView;
import com.vlocker.ui.widget.view.k;

public class ai extends a implements ag {
    public static boolean e = false;
    public static boolean f = false;
    public static boolean g = false;
    public static boolean h = false;
    public ImageView i;
    protected k j = new al(this);
    private LockNumberCoverView k;
    private TextView l;
    private a m;
    private boolean n;
    private Handler o = new aj(this);

    public ai(Context context, p pVar) {
        this.a = context;
        this.c = pVar;
        this.m = a.a(context);
        this.d = "pwd_page";
    }

    private void n() {
        this.m.i(false);
        this.b = LayoutInflater.from(this.a).inflate(R.layout.l_locker_number_custom, null);
        this.i = (ImageView) this.b.findViewById(R.id.pwd_prompt_btn);
        this.i.setOnClickListener(new ak(this));
        this.l = (TextView) this.b.findViewById(R.id.lk_num_date_time_tv);
        this.l.setTypeface(Typeface.createFromAsset(this.a.getAssets(), "fonts/time.ttf"));
        this.k = (LockNumberCoverView) this.b.findViewById(R.id.locknummain);
        this.k.setOnLockNumListener(this.j);
        if (this.m.ao()) {
            this.l.setVisibility(0);
        }
        this.n = true;
    }

    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.b == null) {
            n();
        }
        if (this.m.dd() && this.k != null) {
            this.k.setTip("重启后第一次请输入密码解锁");
        }
        return this.b;
    }

    public void a() {
        try {
            if (this.k != null) {
                this.k.g();
            }
            new Handler().postDelayed(new an(this), 200);
        } catch (Exception e) {
            if (this.c != null) {
                this.c.e((int) AdError.PLACEMENT_ERROR);
            }
        }
    }

    public void a(int i) {
        if (this.k != null) {
            this.k.a(i);
        }
    }

    public void a(CharSequence charSequence) {
        if (this.k != null) {
            this.k.f();
        }
    }

    public void a(String str) {
        if (this.k != null && !TextUtils.isEmpty(str)) {
            this.k.setTip(str);
        }
    }

    public void a(String str, String str2) {
        if (this.l == null) {
            return;
        }
        if (this.m.ao()) {
            this.l.setVisibility(0);
            this.l.setText(str);
            return;
        }
        this.l.setVisibility(8);
    }

    public void b() {
        if (this.k != null) {
            this.k.k();
            this.k.removeAllViews();
        }
        this.b = null;
    }

    public void c() {
    }

    public void d() {
        if (g.b() && g.e() && this.n) {
            e();
            f();
        }
    }

    public void e() {
        this.k.i();
    }

    public void f() {
        this.k.setTip(this.a.getResources().getString(R.string.input_password_txt));
        LockNumberCoverView.a = true;
    }

    public void h() {
        if (this.b != null) {
            this.b.setAlpha(1.0f);
        }
        k();
        h = true;
    }

    public void i() {
        if (this.m.cz() && f.e && this.m.cA() == 0) {
            this.m.X(1);
        } else if (this.m.cz() && f.e && this.m.cA() == 1) {
            this.m.X(2);
        } else if (this.m.cz() && f.e && this.m.cA() == 2) {
            this.m.X(3);
        }
    }

    public void j() {
        if (!g && !h) {
            if (this.i != null) {
                this.i.setVisibility(0);
            }
            g = true;
        }
    }

    public void k() {
        if (g) {
            if (this.i != null) {
                this.i.setVisibility(8);
            }
            g = false;
        }
    }

    public void l() {
        if (this.k != null) {
            this.k.setTip(this.a.getResources().getString(R.string.lk_number_password_ui_from_tool_tip));
        }
    }

    public void m() {
        if (this.k != null) {
            this.k.j();
        }
        if (this.m.cA() == 0 && !f) {
            this.k.a();
            f = true;
        }
    }
}
