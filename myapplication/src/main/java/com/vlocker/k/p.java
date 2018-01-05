package com.vlocker.k;

import android.animation.ValueAnimator;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.widget.TextView;
import com.tencent.mm.sdk.constants.ConstantsAPI.WXApp;
import com.vlocker.c.a;
import com.vlocker.locker.R;
import com.vlocker.m.bb;
import com.vlocker.m.h;
import com.vlocker.m.l;
import com.vlocker.security.MoSecurityApplication;
import com.vlocker.theme.f.b;
import java.util.List;

public class p {
    private static p a;
    private View b = View.inflate(this.j, R.layout.l_redpocket_unlocker_float_title, null);
    private LayoutParams c;
    private volatile boolean d;
    private WindowManager e = ((WindowManager) this.j.getSystemService("window"));
    private TextView f = ((TextView) this.b.findViewById(R.id.red_pocket_from));
    private PendingIntent g;
    private Handler h;
    private int i;
    private Context j = MoSecurityApplication.a();
    private ActivityManager k = ((ActivityManager) this.j.getSystemService("activity"));
    private a l = a.a(this.j);
    private long m;
    private Runnable n = new v(this);

    private p() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.e.getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.widthPixels;
        if (this.l.ay() != i) {
            this.l.m(i);
        }
        this.i = i;
        this.c = new LayoutParams();
        this.c.systemUiVisibility = 1;
        if (b.d()) {
            this.c.type = 2005;
            this.c.y = h.d(this.j);
        } else {
            this.c.type = 2010;
        }
        this.c.width = -1;
        this.c.height = l.a(62.0f) + h.d(this.j);
        this.c.format = 1;
        this.c.gravity = 48;
        this.c.flags = 1320;
        this.b.setFocusableInTouchMode(true);
        this.b.setOnTouchListener(new q(this));
        this.h = new r(this);
    }

    public static p a() {
        if (a == null) {
            a = new p();
        }
        return a;
    }

    private String a(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                int indexOf = str.indexOf(":");
                if (indexOf > 0 && indexOf < str.length()) {
                    return str.substring(0, indexOf);
                }
            }
        } catch (Exception e) {
        }
        return null;
    }

    private void a(float f) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.addUpdateListener(new s(this, f));
        float abs = 1.0f - (Math.abs(f) / ((float) this.i));
        if (abs <= 0.1f) {
            abs = 0.1f;
        }
        ofFloat.setDuration((long) (abs * 500.0f));
        ofFloat.setInterpolator(new AccelerateInterpolator());
        ofFloat.start();
    }

    public void a(Notification notification) {
        if (!this.d) {
            if (!(notification == null || notification.tickerText == null)) {
                String a = a(notification.tickerText.toString());
                this.g = notification.contentIntent;
                if (!(this.f == null || TextUtils.isEmpty(a))) {
                    if (a.length() > 10) {
                        a = a.substring(0, 10) + "···";
                    }
                    this.f.setText(a + "发来了一个红包");
                }
            }
            try {
                this.e.addView(this.b, this.c);
                this.d = true;
                this.h.sendEmptyMessageDelayed(0, 5000);
            } catch (Exception e) {
            }
        }
    }

    public void b() {
        if (this.d) {
            this.e.removeViewImmediate(this.b);
            this.d = false;
            this.b.setX(0.0f);
            this.b.setAlpha(1.0f);
        }
    }

    public void b(Notification notification) {
        if (this.d) {
            this.g = notification.contentIntent;
        }
    }

    public boolean c() {
        String b = bb.b(this.j);
        if (b.toLowerCase().contains("cooperation.qwallet.plugin.qwalletpluginproxyactivity")) {
            this.l.E(this.l.bD() + 1);
            return false;
        } else if (!b.toLowerCase().contains(WXApp.WXAPP_PACKAGE_NAME) && !b.toLowerCase().contains("com.tencent.mobileqq") && !b.toLowerCase().contains("com.vlocker.ui.cover.dismissactivity") && !b.toLowerCase().contains("com.vlocker.ui.cover.cameraactivity")) {
            return false;
        } else {
            if (!b.toLowerCase().contains("com.tencent.mm.plugin.luckymoney.ui.luckymoneydetailui")) {
                return true;
            }
            this.l.D(this.l.bC() + 1);
            this.h.post(new t(this, System.currentTimeMillis() - a.a(this.j).b));
            return false;
        }
    }

    public boolean d() {
        Exception exception;
        boolean z;
        boolean z2 = true;
        if (VERSION.SDK_INT >= 20 && bb.a(this.j)) {
            return c();
        }
        try {
            List runningTasks = this.k.getRunningTasks(1);
            if (runningTasks == null || runningTasks.size() <= 0) {
                return false;
            }
            if (!((RunningTaskInfo) runningTasks.get(0)).topActivity.getClassName().toLowerCase().contains(WXApp.WXAPP_PACKAGE_NAME) && !((RunningTaskInfo) runningTasks.get(0)).topActivity.getClassName().toLowerCase().contains("com.tencent.mobileqq") && !((RunningTaskInfo) runningTasks.get(0)).topActivity.getClassName().toLowerCase().contains("com.vlocker.ui.cover.dismissactivity") && !((RunningTaskInfo) runningTasks.get(0)).topActivity.getClassName().toLowerCase().contains("com.vlocker.ui.cover.cameraactivity")) {
                z2 = false;
            } else if (((RunningTaskInfo) runningTasks.get(0)).topActivity.getClassName().toLowerCase().contains("com.tencent.mm.plugin.luckymoney.ui.luckymoneydetailui")) {
                this.l.D(this.l.bC() + 1);
                this.h.post(new u(this, System.currentTimeMillis() - a.a(this.j).b));
                z2 = false;
            }
            try {
                if (!((RunningTaskInfo) runningTasks.get(0)).topActivity.getClassName().toLowerCase().contains("cooperation.qwallet.plugin.qwalletpluginproxyactivity")) {
                    return z2;
                }
                this.l.E(this.l.bD() + 1);
                return false;
            } catch (Exception e) {
                exception = e;
                z = z2;
                exception.printStackTrace();
                return z;
            }
        } catch (Exception e2) {
            Exception exception2 = e2;
            z = false;
            exception = exception2;
            exception.printStackTrace();
            return z;
        }
    }
}
