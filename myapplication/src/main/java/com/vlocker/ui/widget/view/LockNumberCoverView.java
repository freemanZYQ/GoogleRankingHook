package com.vlocker.ui.widget.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.CountDownTimer;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.vlocker.c.a;
import com.vlocker.locker.R;
import com.vlocker.locker.b.ap;
import com.vlocker.ui.cover.f;
import com.vlocker.ui.widget.a.j;
import com.vlocker.ui.widget.a.k;
import com.vlocker.ui.widget.a.l;
import com.vlocker.ui.widget.a.m;
import com.vlocker.ui.widget.a.n;
import com.vlocker.ui.widget.a.o;
import com.vlocker.ui.widget.c.b;
import com.vlocker.ui.widget.c.d;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class LockNumberCoverView extends FrameLayout {
    private static Integer[] K = new Integer[]{Integer.valueOf(Color.parseColor("#d9f1f3")), Integer.valueOf(Color.parseColor("#e8f1c4")), Integer.valueOf(Color.parseColor("#dce7f4")), Integer.valueOf(Color.parseColor("#f8d8e2")), Integer.valueOf(Color.parseColor("#fcf3d2")), Integer.valueOf(Color.parseColor("#fde0d7")), Integer.valueOf(Color.parseColor("#f5e6dd")), Integer.valueOf(Color.parseColor("#eee9ff")), Integer.valueOf(Color.parseColor("#e2fae6"))};
    public static boolean a = true;
    public static int d = 0;
    private String A;
    private boolean B = false;
    private boolean C = false;
    private boolean D = false;
    private boolean E = false;
    private int F = 0;
    private a G;
    private Handler H;
    private long I;
    private boolean J = false;
    private int L = 0;
    private long M;
    private long N;
    boolean b;
    boolean c = false;
    u e = new d(this);
    OnClickListener f = new e(this);
    boolean g = true;
    CountDownTimer h;
    Runnable i = new i(this);
    k j;
    private boolean k = false;
    private Context l;
    private LockNumberMainView m;
    private o n;
    private ArrayList o = new ArrayList();
    private ArrayList p;
    private ArrayList q = new ArrayList();
    private ArrayList r;
    private j s;
    private LockNumberBankView t;
    private n u;
    private LockNumberTipView v;
    private k w;
    private LockNumberDelView x;
    private LockNumberTimeView y;
    private String[] z;

    public LockNumberCoverView(Context context) {
        super(context);
    }

    public LockNumberCoverView(Context context, AttributeSet attributeSet) {
        boolean z = true;
        super(context, attributeSet);
        this.l = context;
        this.G = a.a(this.l);
        this.k = this.G.w();
        d a = ap.a();
        if (a == null || a.A == null) {
            a = new d();
            b.a(this.l, a);
            this.J = true;
        }
        if (this.G.cA() == -1) {
            this.G.X(0);
            if (this.G.cE() == 1) {
                this.G.aG(true);
            } else if (this.G.cE() == 0) {
                this.G.aG(false);
            } else if (this.G.cE() == -1) {
                a aVar = this.G;
                if (this.J) {
                    z = false;
                }
                aVar.aG(z);
            }
        }
        if (a != null) {
            this.o.addAll(a.x);
            this.q.addAll(a.y);
            this.s = a.z;
            this.u = a.A;
            this.w = a.B;
            this.n = a.w;
            a.a(context, a, this.k);
        }
        d = a.b(this.l);
    }

    private void a(int i, int i2, int i3) {
        int i4 = i - i2;
        this.m.setLayoutParams(this.m.a(i4));
        this.y.setLayoutParams(this.y.a(i4));
    }

    private static int b(int i) {
        return (i < 0 || i >= 9) ? -1 : K[i].intValue();
    }

    private synchronized void c(int i) {
        int i2 = 0;
        synchronized (this) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.l, R.anim.l_number_pwd_circle_scale);
            int i3 = (this.s == null || this.s.b == null) ? 0 : 1;
            if (i == 0) {
                this.D = false;
                if (!this.G.ao() || !a) {
                    this.x.setType(0);
                    if (!this.b) {
                        this.x.setText(R.string.cancel);
                    }
                } else if (!this.b) {
                    this.x.setType(1);
                }
                this.t.b();
                this.t.a(0);
            } else {
                if (i == 1) {
                    this.D = true;
                    this.x.setType(0);
                    this.x.setText(R.string.operation_delete);
                }
                while (i2 < i) {
                    this.t.a(i2, true);
                    i2++;
                }
                if (this.E) {
                    this.t.a(i - 1, false);
                    this.t.a(i);
                } else {
                    if (i3 == 0) {
                        Drawable c = this.t.c(i - 1);
                        if (c != null) {
                            c.setColorFilter(b(this.F), Mode.SRC_ATOP);
                        }
                    }
                    this.t.a(i - 1, loadAnimation);
                }
            }
        }
    }

    private void l() {
        this.z = new String[10];
        this.A = this.G.U();
        m();
        o();
        q();
        n();
        p();
        r();
        c();
    }

    private void m() {
        this.y = (LockNumberTimeView) findViewById(R.id.relativeLayout1);
        this.m = (LockNumberMainView) findViewById(R.id.custom_locknum);
        this.m.setData(this.n);
        this.m.setLayoutParams(this.m.a(0));
        this.y.setLayoutParams(this.y.a(0));
        if (ap.a() != null && ap.a().f != null) {
            Drawable bitmapDrawable = new BitmapDrawable(this.l.getResources(), a.a(this.l, ap.a().f, 320));
            if (bitmapDrawable != null) {
                setBackgroundDrawable(bitmapDrawable);
            }
        }
    }

    private void n() {
        if (!"nothing".equals(this.A)) {
            this.t = new LockNumberBankView(this.l);
            this.t.a(this.s, this.A.length(), this.J);
            this.m.addView(this.t, this.t.a(this.J));
            this.t.a();
        }
    }

    private void o() {
        this.r = new ArrayList();
        for (int i = 0; i < this.q.size(); i++) {
            View lockNumberImageView = new LockNumberImageView(this.l);
            lockNumberImageView.setImageData((l) this.q.get(i));
            this.m.addView(lockNumberImageView, lockNumberImageView.getmLayoutParams());
            this.r.add(lockNumberImageView);
        }
    }

    private void p() {
        this.p = new ArrayList();
        for (int i = 0; i < this.o.size(); i++) {
            View lockNumberPointView = new LockNumberPointView(this.l);
            lockNumberPointView.setPointData((m) this.o.get(i));
            lockNumberPointView.setTouchListener(this.e);
            this.m.addView(lockNumberPointView, lockNumberPointView.getmLayoutParams());
            this.p.add(lockNumberPointView);
        }
    }

    private void q() {
        this.v = new LockNumberTipView(this.l);
        this.v.setTipData(this.u);
        this.m.addView(this.v, this.v.getmLayoutParams());
    }

    private void r() {
        this.x = new LockNumberDelView(this.l);
        this.x.setDelData(this.w);
        this.m.addView(this.x, this.x.a(0));
        this.x.setOnClickListener(this.f);
    }

    private void s() {
        this.H = new b(this);
    }

    private void setNumEnable(boolean z) {
        this.g = z;
    }

    private void setTextColor(TextView textView) {
        this.v.a();
    }

    private synchronized void setValue(String str) {
        int i = 1;
        synchronized (this) {
            while (i <= this.A.length()) {
                if (TextUtils.isEmpty(this.z[i - 1])) {
                    if (i == this.A.length()) {
                        this.B = true;
                    }
                    this.z[i - 1] = str;
                    c(i);
                } else {
                    i++;
                }
            }
        }
    }

    private void t() {
        if (this.g) {
            this.v.setText(this.l.getString(R.string.input_password_txt));
            setTextColor(this.v);
        }
    }

    private void u() {
        this.N = 0;
        this.M = 0;
        f.h = 5;
        i();
        d();
        f.i = false;
        f.g = true;
        setNumEnable(true);
    }

    private void v() {
        this.z = new String[10];
        this.t.b();
    }

    public void a() {
        this.v.setText("当前密码样式");
        this.H.postDelayed(new c(this), 2500);
    }

    public void a(int i) {
        this.C = true;
        Animation loadAnimation = AnimationUtils.loadAnimation(this.l, R.anim.l_shake_x);
        this.v.setTextColor(-65536);
        if (f.h > 0) {
            if (i >= 4) {
                f();
            } else {
                this.v.setTextColor(-65536);
                this.v.setText("指纹验证失败，请重试");
            }
        }
        if (this.C) {
            v();
            c(0);
            this.C = false;
        }
        loadAnimation.setAnimationListener(new h(this, i));
        if (i < 4) {
            if (((AudioManager) this.l.getSystemService("audio")).getRingerMode() != 0 && a.a(this.l).au()) {
                com.vlocker.m.ap.b(this.l);
            }
            this.t.startAnimation(loadAnimation);
        }
    }

    public void a(View view) {
        boolean z = true;
        this.E = true;
        int length = this.z.length;
        while (length > 0) {
            if (TextUtils.isEmpty(this.z[length - 1])) {
                length--;
            } else {
                this.z[length - 1] = null;
                c(length);
                if (1 == length) {
                    d();
                }
                if (!z) {
                    if (this.b) {
                        this.j.b();
                    } else {
                        this.j.c();
                    }
                }
                this.E = false;
            }
        }
        z = false;
        if (z) {
            if (this.b) {
                this.j.b();
            } else {
                this.j.c();
            }
        }
        this.E = false;
    }

    public void b() {
        if (ap.a() != null && ap.a().w != null && ap.a().w.J && ap.a().w.t != -1) {
            this.L = ap.a().w.t;
        }
    }

    public void c() {
        b();
        this.x.a();
        this.v.a();
    }

    public void d() {
        this.b = false;
        this.x.setType(0);
        this.x.setText(R.string.cancel);
    }

    public void e() {
        this.C = true;
        String str = "";
        for (int i = 0; i < this.z.length; i++) {
            if (this.z[i] != null) {
                str = str + this.z[i];
            }
        }
        if (TextUtils.isEmpty(str) || str.length() < 2 || str.length() > 10) {
            this.C = false;
        } else if (str.equals(this.G.U())) {
            new Handler().postDelayed(new f(this), 30);
        } else {
            Animation loadAnimation;
            if (this.G.bW()) {
                this.j.d();
                if (a && f.h == 0) {
                    f.h = 5;
                }
                f.h--;
                if (this.G.v() && a && f.h <= 3) {
                    this.b = true;
                    this.x.setType(0);
                    this.x.setText(R.string.forget_password);
                }
                this.I = new Date().getTime();
            }
            this.v.setTextColor(-65536);
            if (f.h > 0) {
                setNumEnable(true);
                this.v.setText(this.l.getString(R.string.gesture_password_unlock_failed_tip) + f.h + this.l.getString(R.string.gesture_password_unlock_failed_tip_num));
                loadAnimation = AnimationUtils.loadAnimation(this.l, R.anim.l_shake_x);
            } else {
                setNumEnable(false);
                this.v.setText(this.l.getString(R.string.gesture_password_gesturepwd_unlock_failed_tip));
                loadAnimation = AnimationUtils.loadAnimation(this.l, R.anim.l_shake_x);
            }
            if (this.C) {
                v();
                c(0);
                this.C = false;
            }
            if (((AudioManager) this.l.getSystemService("audio")).getRingerMode() != 0 && a.a(this.l).au()) {
                com.vlocker.m.ap.b(this.l);
            }
            loadAnimation.setAnimationListener(new g(this, loadAnimation));
            this.t.startAnimation(loadAnimation);
        }
    }

    public void f() {
        this.H.removeMessages(1);
        setTextColor(this.v);
        this.v.setText("指纹错误过多，请输入密码");
    }

    public void g() {
        try {
            c(this.z.length);
        } catch (Exception e) {
        }
    }

    public void h() {
        this.I = new Date().getTime();
        if (a || this.I - f.d >= 30000) {
            setNumEnable(true);
            return;
        }
        f.i = true;
        setNumEnable(false);
        this.v.removeCallbacks(this.i);
        this.v.post(this.i);
    }

    public void i() {
        v();
        c(0);
        this.C = false;
    }

    public void j() {
        Iterator it = this.p.iterator();
        while (it.hasNext()) {
            ((LockNumberPointView) it.next()).a();
        }
    }

    public void k() {
        int i = 0;
        setBackgroundDrawable(null);
        if (this.p != null && this.p.size() > 0) {
            for (int i2 = 0; i2 < this.p.size(); i2++) {
                ((LockNumberPointView) this.p.get(i2)).e();
            }
            this.p.clear();
        }
        if (this.o != null) {
            this.o.clear();
        }
        if (this.r != null && this.r.size() > 0) {
            while (i < this.r.size()) {
                ((LockNumberImageView) this.r.get(i)).a();
                i++;
            }
            this.r.clear();
        }
        if (this.q != null) {
            this.q.clear();
        }
        if (this.t != null) {
            this.t.c();
        }
        if (this.v != null) {
            this.v.setBackgroundDrawable(null);
        }
        if (this.x != null) {
            this.x.setBackgroundDrawable(null);
        }
        this.m.removeAllViews();
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        l();
        s();
    }

    public void onScreenStateChanged(int i) {
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i3 != 0 && com.vlocker.theme.f.b.v() && i2 > i && i4 > i3 && d <= 0 && this.k) {
            a(i2, i4, d);
        }
    }

    public void setDelType(int i) {
        this.x.setType(i);
        if (i == 0) {
            this.x.setText(this.l.getResources().getString(R.string.cancel));
        }
    }

    public void setOnLockNumListener(k kVar) {
        this.j = kVar;
    }

    public void setTip(String str) {
        if (this.v != null && str != null && this.g) {
            this.v.setText(str);
            setTextColor(this.v);
        }
    }
}
