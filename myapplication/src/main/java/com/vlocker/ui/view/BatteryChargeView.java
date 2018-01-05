package com.vlocker.ui.view;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.location.LocationClientOption;
import com.vlocker.b.p;
import com.vlocker.c.a;
import com.vlocker.locker.R;
import com.vlocker.locker.c.b;
import com.vlocker.msg.aq;
import com.vlocker.ui.cover.LockerService;
import java.util.Date;

public class BatteryChargeView extends RelativeLayout {
    public static boolean b;
    public static boolean c;
    public static boolean h;
    private Bitmap A;
    private View B;
    private View C;
    private View D;
    private View E;
    private Handler F;
    private a G;
    private b H;
    private TextView I;
    private boolean J;
    private int K = 0;
    private Runnable L = new e(this);
    private int M;
    private boolean N = false;
    private BroadcastReceiver O = new h(this);
    aq a = new com.vlocker.msg.a(getContext());
    RelativeLayout d;
    LinearLayout e;
    OnClickListener f = new b(this);
    boolean g;
    private TextView i;
    private TextView j;
    private TextView k;
    private TextView l;
    private TextView m;
    private TextView n;
    private ImageView o;
    private ImageView p;
    private ImageView q;
    private ImageView r;
    private ImageView s;
    private ImageView t;
    private BatteryProgressView u;
    private Bitmap v;
    private Bitmap w;
    private Bitmap x;
    private Bitmap y;
    private Bitmap z;

    public BatteryChargeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void a(View view, boolean z) {
        view.animate().cancel();
        view.animate().alpha(z ? 1.0f : 0.0f).setDuration(500).setInterpolator(new AccelerateDecelerateInterpolator()).setListener(new d(this, z, view)).start();
    }

    private void a(ImageView imageView, boolean z) {
        if (z && LockerService.a().c()) {
            imageView.setVisibility(0);
            Animation rotateAnimation = new RotateAnimation(0.0f, 359.0f, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setInterpolator(new com.vlocker.anim.a());
            rotateAnimation.setDuration(1800);
            rotateAnimation.setRepeatCount(-1);
            imageView.startAnimation(rotateAnimation);
            return;
        }
        imageView.clearAnimation();
        imageView.setVisibility(8);
    }

    private void g() {
        this.I = (TextView) findViewById(R.id.tv_battery_des);
        this.j = (TextView) findViewById(R.id.tv_battery_time);
        this.i = (TextView) findViewById(R.id.tv_battery_time_des);
        this.l = (TextView) findViewById(R.id.tv_battery_fast);
        this.m = (TextView) findViewById(R.id.tv_battery_normal);
        this.n = (TextView) findViewById(R.id.tv_battery_slow);
        this.o = (ImageView) findViewById(R.id.iv_battery_fast);
        this.p = (ImageView) findViewById(R.id.iv_battery_normal);
        this.q = (ImageView) findViewById(R.id.iv_battery_slow);
        this.r = (ImageView) findViewById(R.id.iv_battery_fast_rotate);
        this.s = (ImageView) findViewById(R.id.iv_battery_normal_rotate);
        this.t = (ImageView) findViewById(R.id.iv_battery_slow_rotate);
        this.u = (BatteryProgressView) findViewById(R.id.layout_battery_wave);
        this.u.a(false);
        this.B = findViewById(R.id.layout_battery_time);
        this.C = findViewById(R.id.layout_battery_status_img);
        this.D = findViewById(R.id.layout_battery_des);
        this.d = (RelativeLayout) findViewById(R.id.layout_battery_bg);
        this.e = (LinearLayout) findViewById(R.id.battery_operation_bg);
        findViewById(R.id.tv_forbidern).setOnClickListener(this.f);
        findViewById(R.id.tv_delete).setOnClickListener(this.f);
        findViewById(R.id.layout_battery_fast).setOnClickListener(this.f);
        findViewById(R.id.layout_battery_normal).setOnClickListener(this.f);
        findViewById(R.id.layout_battery_slow).setOnClickListener(this.f);
        this.u.setOnClickListener(this.f);
        k();
    }

    private void h() {
        ((AlarmManager) getContext().getSystemService("alarm")).cancel(PendingIntent.getBroadcast(getContext(), 0, new Intent("battery_action_full_send"), 134217728));
    }

    private void i() {
        if (this.d != null) {
            this.d.setBackgroundDrawable(null);
        }
        scrollTo(0, 0);
        this.N = false;
        h();
        p.a(getContext(), "Vlocker_Close_Charge_Battery_PPC_TF", "source", "out_day");
        com.vlocker.battery.saver.b.a(getContext()).b("out_day");
        long currentTimeMillis = System.currentTimeMillis();
        Date date = new Date(currentTimeMillis);
        this.G.l(currentTimeMillis + ((long) (86400000 - ((date.getSeconds() * LocationClientOption.MIN_SCAN_SPAN) + ((((date.getHours() * 60) * 60) * LocationClientOption.MIN_SCAN_SPAN) + ((date.getMinutes() * 60) * LocationClientOption.MIN_SCAN_SPAN))))));
        com.vlocker.battery.saver.b.a(getContext()).c();
        if (this.H != null) {
            this.H.u();
        }
    }

    private void j() {
        if (this.d != null) {
            this.d.setBackgroundDrawable(null);
        }
        scrollTo(0, 0);
        this.N = false;
        h();
        p.a(getContext(), "Vlocker_Close_Charge_Battery_PPC_TF", "source", "out_all");
        com.vlocker.battery.saver.b.a(getContext()).b("out_all");
        com.vlocker.battery.saver.b.a(getContext()).c();
        this.G.av(false);
        if (this.H != null) {
            this.H.u();
        }
    }

    private void k() {
        if (this.d != null && this.e != null) {
            postDelayed(new f(this), 100);
        }
    }

    private void l() {
        this.j = (TextView) findViewById(R.id.tv_battery_time);
        this.i = (TextView) findViewById(R.id.tv_battery_time_des);
        this.k = (TextView) findViewById(R.id.tv_battery_temp);
        this.u = (BatteryProgressView) findViewById(R.id.layout_battery_wave);
        this.u.a(true);
        this.B = findViewById(R.id.layout_battery_time);
        this.E = findViewById(R.id.layout_battery_temp);
        findViewById(R.id.tv_little_delete).setOnClickListener(this.f);
        findViewById(R.id.tv_little_forbidern).setOnClickListener(this.f);
        this.u.setOnClickListener(this.f);
    }

    private void m() {
        this.v = BitmapFactory.decodeResource(getResources(), R.drawable.battery_slow);
        this.w = BitmapFactory.decodeResource(getResources(), R.drawable.battery_normal);
        this.y = BitmapFactory.decodeResource(getResources(), R.drawable.battery_slow_ing);
        this.x = BitmapFactory.decodeResource(getResources(), R.drawable.battery_fast_ing);
        this.z = BitmapFactory.decodeResource(getResources(), R.drawable.battery_normal_ing);
        this.A = BitmapFactory.decodeResource(getResources(), R.drawable.battery_complete);
    }

    private void n() {
        if (getVisibility() == 0 && !this.J && !this.N) {
            if (this.M < 80) {
                a(this.r, true);
                a(this.s, false);
                a(this.t, false);
            } else if (this.M < 100) {
                a(this.r, false);
                a(this.s, true);
                a(this.t, false);
            } else {
                a(this.r, false);
                a(this.s, false);
                a(this.t, true);
            }
        }
    }

    private void o() {
        this.i.setText(getContext().getString(R.string.battery_time_des_slow));
        this.j.setVisibility(8);
        if (this.K != 3) {
            this.K = 3;
            if (!this.J) {
                this.o.setImageBitmap(this.A);
                this.p.setImageBitmap(this.A);
                this.q.setImageBitmap(this.y);
                a(this.r, false);
                a(this.s, false);
                a(this.t, true);
                this.l.setTextColor(getResources().getColor(R.color.v2_setting_item_title_des));
                this.m.setTextColor(getResources().getColor(R.color.v2_setting_item_title_des));
                this.n.setTextColor(getResources().getColor(R.color.white));
            }
        }
    }

    private void p() {
        this.i.setText(getContext().getString(R.string.battery_time_des_full));
        this.j.setVisibility(8);
        if (this.K != 4) {
            this.K = 4;
            if (!this.J) {
                this.o.setImageBitmap(this.A);
                this.p.setImageBitmap(this.A);
                this.q.setImageBitmap(this.A);
                a(this.r, false);
                a(this.s, false);
                a(this.t, false);
                this.l.setTextColor(getResources().getColor(R.color.v2_setting_item_title_des));
                this.m.setTextColor(getResources().getColor(R.color.v2_setting_item_title_des));
                this.n.setTextColor(getResources().getColor(R.color.v2_setting_item_title_des));
            }
            this.u.b();
        }
    }

    private void setViewStatusUnder100(int i) {
        this.i.setText(getContext().getString(R.string.battery_time_des_normal));
        this.j.setVisibility(0);
        if (this.K != 2) {
            this.K = 2;
            if (!this.J) {
                this.o.setImageBitmap(this.A);
                this.p.setImageBitmap(this.z);
                this.q.setImageBitmap(this.v);
                a(this.r, false);
                a(this.s, true);
                a(this.t, false);
                this.l.setTextColor(getResources().getColor(R.color.v2_setting_item_title_des));
                this.m.setTextColor(getResources().getColor(R.color.white));
                this.n.setTextColor(getResources().getColor(R.color.v2_setting_item_title_des));
            }
        }
    }

    private void setViewStatusUnder80(int i) {
        this.i.setText(getContext().getString(R.string.battery_time_des_fast));
        this.j.setVisibility(0);
        if (this.K != 1) {
            this.K = 1;
            if (!this.J) {
                this.o.setImageBitmap(this.x);
                this.p.setImageBitmap(this.w);
                this.q.setImageBitmap(this.v);
                a(this.r, true);
                a(this.s, false);
                a(this.t, false);
                this.l.setTextColor(getResources().getColor(R.color.white));
                this.m.setTextColor(getResources().getColor(R.color.v2_setting_item_title_des));
                this.n.setTextColor(getResources().getColor(R.color.v2_setting_item_title_des));
            }
        }
    }

    public void a() {
        this.u.a();
    }

    public void a(int i, long j) {
        if (!this.N) {
            this.M = i;
            this.u.setProgress((float) i);
            if (i < 80) {
                setViewStatusUnder80(i);
            } else if (i < 100) {
                setViewStatusUnder100(i);
            } else {
                o();
            }
            long j2 = j / 60000;
            if (j2 <= 0 && i < 100) {
                this.i.setText(getResources().getString(R.string.battery_time_des_none));
                this.j.setVisibility(8);
            } else if (j2 > 60) {
                this.j.setText((j2 / 60) + "小时" + (j2 % 60) + "分钟");
            } else {
                this.j.setText(j2 + "分钟");
            }
            if (this.J) {
                this.k.setText(com.vlocker.battery.saver.a.d + "℃");
            }
        }
    }

    public void a(BatteryChargeView batteryChargeView) {
        if (!h) {
            h = true;
            BatteryProgressView batteryProgressView = (BatteryProgressView) batteryChargeView.findViewById(R.id.layout_battery_wave);
            int[] iArr = new int[2];
            batteryProgressView.getLocationOnScreen(iArr);
            int[] iArr2 = new int[2];
            this.u.getLocationOnScreen(iArr2);
            batteryProgressView.setPivotX(0.0f);
            batteryProgressView.setPivotY(0.0f);
            batteryProgressView.setTranslationX((float) (iArr2[0] - iArr[0]));
            batteryProgressView.setTranslationY((float) (iArr2[1] - iArr[1]));
            batteryProgressView.setScaleX(3.0f);
            batteryProgressView.setScaleY(2.3461537f);
            this.u.setPivotX(0.0f);
            this.u.setPivotY(0.0f);
            this.u.setTranslationX((float) (iArr[0] - iArr2[0]));
            this.u.setTranslationY((float) (iArr[1] - iArr2[1]));
            this.u.setScaleX(0.33333334f);
            this.u.setScaleY(0.4262295f);
            batteryProgressView.animate().translationX(0.0f).translationY(0.0f).scaleX(1.0f).scaleY(1.0f).setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(300).setListener(new i(this, (FrameLayout) batteryChargeView.getParent(), batteryProgressView)).start();
            batteryChargeView.d();
            batteryChargeView.setVisibility(0);
        }
    }

    public void a(boolean z, b bVar) {
        this.J = z;
        if (z) {
            l();
        } else {
            g();
            m();
        }
        this.H = bVar;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("battery_action_full_send");
        intentFilter.addAction("battery_action_full_cancel");
        getContext().registerReceiver(this.O, intentFilter);
        this.F = new Handler();
        this.G = a.a(getContext());
    }

    public void b() {
        n();
        if (!this.N) {
            this.u.a();
        }
    }

    public void b(BatteryChargeView batteryChargeView) {
        if (!h) {
            h = true;
            this.u.animate().translationX(0.0f).translationY(0.0f).scaleX(1.0f).scaleY(1.0f).setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(300).setListener(new k(this, batteryChargeView)).start();
            if (!(this.B == null || this.C == null || this.D == null)) {
                this.B.setAlpha(0.0f);
                this.C.setAlpha(0.0f);
                this.D.setAlpha(0.0f);
                this.F.postDelayed(new c(this), 150);
            }
            batteryChargeView.setVisibility(8);
        }
    }

    public void c() {
        if (this.u != null && this.r != null && this.s != null && this.t != null) {
            this.u.b();
            this.r.clearAnimation();
            this.s.clearAnimation();
            this.t.clearAnimation();
            this.r.setRotation(0.0f);
            this.s.setRotation(0.0f);
            this.t.setRotation(0.0f);
        }
    }

    public void d() {
        this.B.setAlpha(0.0f);
        this.E.setAlpha(0.0f);
        this.F.postDelayed(new j(this), 150);
    }

    public void e() {
        this.u.setTranslationX(0.0f);
        this.u.setTranslationY(0.0f);
        this.u.setScaleX(1.0f);
        this.u.setScaleY(1.0f);
    }

    public void f() {
        ((LayoutParams) getLayoutParams()).setMargins(0, 0, 0, 0);
        requestLayout();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        k();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i;
        boolean z = true;
        int i2 = R.id.tv_forbidern;
        int i3 = R.id.tv_delete;
        if (this.J) {
            i2 = R.id.tv_little_forbidern;
            i3 = R.id.tv_little_delete;
            i = 1;
        } else {
            i = 0;
        }
        boolean a = this.a.a(this, i2, i3, motionEvent, i, new g(this));
        if (a) {
            z = false;
        }
        b = z;
        return a;
    }

    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i == 0) {
            k();
        }
        n();
    }

    public void setMiniViewStatus(BatteryChargeView batteryChargeView) {
        int[] iArr = new int[2];
        ((BatteryProgressView) batteryChargeView.findViewById(R.id.layout_battery_wave)).getLocationOnScreen(iArr);
        int[] iArr2 = new int[2];
        this.u.getLocationOnScreen(iArr2);
        this.u.setPivotX(0.0f);
        this.u.setPivotY(0.0f);
        this.u.setTranslationX((float) (iArr[0] - iArr2[0]));
        this.u.setTranslationY((float) (iArr[1] - iArr2[1]));
        this.u.setScaleX(0.33333334f);
        this.u.setScaleY(0.4262295f);
    }

    public void setWaveMarginTop(int i) {
        ((LayoutParams) getLayoutParams()).setMargins(0, i, 0, 0);
        requestLayout();
    }
}
