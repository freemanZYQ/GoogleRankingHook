package com.vlocker.ui.cover;

import android.app.Notification;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.IBinder;
import android.os.PowerManager;
import android.text.TextUtils;
import android.view.WindowManager;
import com.baidu.location.LocationClientOption;
import com.samsung.android.sdk.pass.SpassFingerprint;
import com.vlocker.battery.clean.y;
import com.vlocker.battery.saver.BatteryReceiver;
import com.vlocker.battery.saver.b;
import com.vlocker.c.a;
import com.vlocker.f.ab;
import com.vlocker.f.j;
import com.vlocker.locker.R;
import com.vlocker.locker.b.ap;
import com.vlocker.locker.b.p;
import com.vlocker.m.al;
import com.vlocker.m.aw;
import com.vlocker.m.i;
import com.vlocker.m.t;
import com.vlocker.msg.an;
import com.vlocker.msg.as;
import com.vlocker.msg.f;
import com.vlocker.msg.v;
import com.vlocker.security.MoSecurityApplication;
import com.vlocker.security.e;
import com.vlocker.service.LockerInerService;
import com.vlocker.settings.SettingsActivity;
import com.vlocker.settings.SubSetingActivity;
import com.vlocker.theme.f.c;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class LockerService extends Service {
    public static String a = "vlocker_locker_change_theme_bg";
    public static String b = "moxiu.intent.action.SCREEN_ON";
    public static String c = "moxiu.intent.action.SCREEN_OFF";
    public static boolean f = true;
    private static String g = "com.moxiu.http.download.task.click";
    private static LockerService h = null;
    private static boolean s = false;
    long d;
    long e = 0;
    private a i;
    private am j;
    private a k;
    private aq l;
    private ArrayList m;
    private BatteryReceiver n;
    private f o;
    private Handler p;
    private j q;
    private boolean r;
    private boolean t = false;
    private p u;
    private BroadcastReceiver v = new y(this);
    private ai w = new ai(this);
    private WindowManager x = null;
    private boolean y = false;
    private BroadcastReceiver z = new ae(this);

    private void A() {
        if (this.i.ch()) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(SpassFingerprint.ACTION_FINGERPRINT_RESET);
            intentFilter.addAction(SpassFingerprint.ACTION_FINGERPRINT_REMOVED);
            intentFilter.addAction(SpassFingerprint.ACTION_FINGERPRINT_ADDED);
            getBaseContext().registerReceiver(this.z, intentFilter);
        }
    }

    private void B() {
        try {
            if (this.i.ch()) {
                getBaseContext().unregisterReceiver(this.z);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void C() {
        if (this.i.cT()) {
            this.i.aL(false);
        }
        this.i.r(System.currentTimeMillis());
        this.p.postDelayed(new w(this), 1000);
    }

    public static LockerService a() {
        return h;
    }

    public static void a(Context context) {
        context.startService(new Intent(context, LockerService.class));
    }

    private void b(int i) {
        Iterator it = this.m.iterator();
        while (it.hasNext()) {
            ((com.vlocker.i.a) it.next()).a_(i);
        }
        g.a = false;
    }

    public static void b(Context context) {
        a.a(context).ax(true);
        context.startService(new Intent(context, LockerService.class));
    }

    public static void c(Context context) {
        if (!s) {
            s = true;
            a.a(context).ax(true);
            context.startService(new Intent(context, LockerService.class));
        }
    }

    public static void d(Context context) {
        a.a(context).g(true);
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Intent intent = new Intent();
        if (a.a(context).r()) {
            intent.setClass(context, SubSetingActivity.class);
        } else {
            intent.setClass(context, SettingsActivity.class);
        }
        intent.setFlags(268435456);
        context.startActivity(intent);
        System.exit(0);
    }

    public static boolean e(Context context) {
        try {
            return ((PowerManager) context.getSystemService("power")).isScreenOn();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private void g() {
        ap.a((Context) this).a(new u(this));
        ap.a((Context) this).b();
    }

    private void h() {
        j();
        i.b();
        if (!this.t) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction(b);
            intentFilter.addAction(c);
            intentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
            intentFilter.addAction(a);
            intentFilter.addAction("com.vlocker.ACTION_WALLPAPER_UI_UPDATE");
            intentFilter.addAction("com.vlocker.service.ACTION_WEATHER_UPDATE");
            intentFilter.addAction("com.vlocker.service.ACTION_LOCATION_UPDATE");
            intentFilter.addAction("com.vlocker.locker.update.receiver");
            intentFilter.addAction("android.intent.action.DATE_CHANGED");
            intentFilter.addAction(g);
            intentFilter.setPriority(LocationClientOption.MIN_SCAN_SPAN);
            registerReceiver(this.v, intentFilter);
            this.n = new BatteryReceiver(this);
            intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
            intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
            intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
            intentFilter.addAction("android.intent.action.HEADSET_PLUG");
            registerReceiver(this.n, intentFilter);
            A();
            this.t = true;
        }
        if (this.j == null) {
            this.j = new am(getApplicationContext());
            this.j.a();
        }
        if (this.k == null) {
            this.k = new a(getApplicationContext());
            this.k.a();
        }
        if (this.l == null) {
            this.l = new aq(getApplicationContext());
        }
        x();
        y();
        this.x = (WindowManager) getSystemService("window");
        this.u = new p(getApplicationContext(), this.w);
        y.a().a(this.u);
        if (!k.a(this)) {
            k.a(this, false);
        }
        i();
        this.m = this.u.f();
        if (this.i.cb() || ((this.r || !this.i.p()) && this.i.q() && !this.i.r())) {
            this.r = false;
            this.i.ax(false);
            o();
            this.u.y();
        }
        this.i.f(false);
        this.i.e(false);
        if (VERSION.SDK_INT < 18) {
            this.o = f.a();
            this.o.b();
        }
        al.c();
        if (!(e((Context) this) || am.a((Context) this) || !this.i.O() || this.u == null)) {
            this.u.a();
        }
        this.q = j.a();
    }

    private void i() {
        if (com.vlocker.weather.e.j.d(getApplicationContext())) {
            com.vlocker.weather.e.j.i(getApplicationContext());
            new Thread(new x(this)).start();
        }
    }

    private void j() {
        if (VERSION.SDK_INT < 18) {
            super.startForeground(1220, new Notification());
            return;
        }
        startForeground(1220, LockerInerService.a(this, R.drawable.l_notification_small_icon));
        startService(new Intent(this, LockerInerService.class));
    }

    private void k() {
        if (this.d == 0 || System.currentTimeMillis() - this.d > 10000) {
            this.d = System.currentTimeMillis();
            e.b(this);
        }
    }

    private void l() {
        Iterator it = this.m.iterator();
        while (it.hasNext()) {
            ((com.vlocker.i.a) it.next()).g();
        }
        g.a = true;
        com.vlocker.setting.a.a.getInstance(getApplicationContext()).clear();
        com.vlocker.setting.a.a.getInstance(getApplicationContext()).init();
        this.p.postDelayed(new z(this), 700);
    }

    private void m() {
        int date = new Date().getDate();
        if (date != this.i.cP()) {
            this.i.ae(date);
            this.i.ad(0);
        }
        this.i.ad(this.i.cO() + 1);
    }

    private void n() {
        w();
        m();
        al.a(false);
        if (com.vlocker.update.i.b()) {
            com.vlocker.update.a.a((Context) this, new aa(this));
        } else if ((this.i.cT() || this.i.cU()) && System.currentTimeMillis() - this.i.cV() > 10800000) {
            C();
        }
        if (com.vlocker.battery.saver.a.b && com.vlocker.b.j.h(this).booleanValue()) {
            b.a((Context) this).d();
        }
        com.vlocker.e.j.a().a("2");
        if (!am.a((Context) this)) {
            if (this.u != null) {
                this.u.y();
            }
            Iterator it = this.m.iterator();
            while (it.hasNext()) {
                ((com.vlocker.i.a) it.next()).i();
            }
        }
        if (this.u != null) {
            this.u.z();
        }
        try {
            this.p.postDelayed(new ab(this), 500);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void o() {
        if (!am.a((Context) this)) {
            if (!(this.i.an() != 0 || !this.i.P() || this.i.q() || this.u == null || this.u.v())) {
                com.vlocker.m.ap.a((Context) this).a("lock1.ogg");
            }
            b.a(MoSecurityApplication.a()).a(false);
            y.a().b();
            al.c();
            if (this.u != null) {
                this.u.a();
            }
            Iterator it = this.m.iterator();
            while (it.hasNext()) {
                ((com.vlocker.i.a) it.next()).h();
            }
        }
        if (System.currentTimeMillis() - this.i.cD() > 7200000) {
            this.i.p(System.currentTimeMillis());
        }
        com.vlocker.b.p.b(this);
        com.vlocker.b.p.c(this);
        if (this.i.ch()) {
            try {
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        if (this.q != null && this.i.cg()) {
            this.q.c();
        }
    }

    private void p() {
        int bk = this.i.bk();
        int date = new Date().getDate();
        if (bk != date) {
            this.i.w(date);
            r();
            s();
            t();
            u();
            q();
        }
    }

    private void q() {
        if (j.a() != null) {
            com.vlocker.b.p.a(getBaseContext(), "Vlock_ClientSum_FP_PPC_TF", "manufacturer", Build.MANUFACTURER);
        } else if (ab.b(getBaseContext())) {
            com.vlocker.b.p.a(getBaseContext(), "Vlock_ClientSum_FP_PPC_TF", "manufacturer", "0");
        }
    }

    private void r() {
        Context baseContext = getBaseContext();
        String str = "Vlock_Sum_RootUser_PPC_TF";
        String[] strArr = new String[2];
        strArr[0] = "isROOT";
        strArr[1] = aw.a().b() ? "Yes" : "No";
        com.vlocker.b.p.a(baseContext, str, strArr);
        as.d(getApplicationContext());
    }

    private void s() {
        com.vlocker.b.p.a((Context) this, "Vlock_Sum_SysPassword_PPC_TF", "status", k.a(this) + "");
    }

    private void t() {
        if (an.c(this)) {
            com.vlocker.b.p.a((Context) this, "Vlocker_MsgServiceSum_PPC_TF", "status", "1");
            return;
        }
        com.vlocker.b.p.a((Context) this, "Vlocker_MsgServiceSum_PPC_TF", "status", "0");
    }

    private void u() {
        if (this.i.bv()) {
            com.vlocker.b.p.a((Context) this, "Vlocker_Status_Hongbao_Settings_PPC_TF", new String[0]);
        }
    }

    private void v() {
        int date = new Date().getDate();
        if (this.i.dh() != date) {
            this.i.ag(date);
            v.a((Context) this).c();
        }
    }

    private void w() {
        if (!k.a(this)) {
            k.b(this, false);
            k.a(this, false);
        }
    }

    private void x() {
        if (this.j != null) {
            this.j.a(new ac(this));
        }
    }

    private void y() {
        if (this.k != null) {
            this.k.a(new ad(this));
        }
    }

    private void z() {
        BufferedReader bufferedReader;
        Object stringBuffer;
        String str;
        a a;
        ApplicationInfo l;
        int f;
        String g;
        String str2;
        Throwable th;
        if ("V_theme".equals(com.vlocker.b.j.p(this))) {
            File file = new File(com.vlocker.b.i.m + "theme.flag");
            if (file.exists()) {
                try {
                    bufferedReader = new BufferedReader(new FileReader(file));
                    try {
                        char[] cArr = new char[4096];
                        StringBuffer stringBuffer2 = new StringBuffer();
                        while (true) {
                            int read = bufferedReader.read(cArr);
                            if (read == -1) {
                                break;
                            }
                            stringBuffer2.append(cArr, 0, read);
                        }
                        stringBuffer = stringBuffer2.toString();
                    } catch (OutOfMemoryError e) {
                        stringBuffer = null;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        if (TextUtils.isEmpty(stringBuffer)) {
                            str = com.vlocker.b.i.j + stringBuffer;
                            a = a.a((Context) this);
                            a.d(true);
                            a.i(1);
                            l = c.l(this, str);
                            f = c.f(this, str);
                            g = c.g(this, str);
                            str2 = l != null ? null : l.packageName;
                            com.vlocker.m.y.d = f;
                            com.vlocker.m.y.b = g;
                            com.vlocker.m.y.c = str;
                            com.vlocker.m.y.a = str2;
                            a = a.a((Context) this);
                            a.e(com.vlocker.m.y.a);
                            a.d(com.vlocker.m.y.c);
                            a.c(com.vlocker.m.y.b);
                            a.d(com.vlocker.m.y.d);
                            com.vlocker.m.y.e(this, str);
                            try {
                                com.vlocker.m.y.g(this, str);
                            } catch (IOException e3) {
                                e3.printStackTrace();
                                return;
                            }
                        }
                    } catch (Exception e4) {
                        stringBuffer = null;
                        try {
                            file.delete();
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e22) {
                                    e22.printStackTrace();
                                }
                            }
                            if (TextUtils.isEmpty(stringBuffer)) {
                                str = com.vlocker.b.i.j + stringBuffer;
                                a = a.a((Context) this);
                                a.d(true);
                                a.i(1);
                                l = c.l(this, str);
                                f = c.f(this, str);
                                g = c.g(this, str);
                                if (l != null) {
                                }
                                com.vlocker.m.y.d = f;
                                com.vlocker.m.y.b = g;
                                com.vlocker.m.y.c = str;
                                com.vlocker.m.y.a = str2;
                                a = a.a((Context) this);
                                a.e(com.vlocker.m.y.a);
                                a.d(com.vlocker.m.y.c);
                                a.c(com.vlocker.m.y.b);
                                a.d(com.vlocker.m.y.d);
                                com.vlocker.m.y.e(this, str);
                                com.vlocker.m.y.g(this, str);
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e5) {
                                    e5.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    }
                    try {
                        file.delete();
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e222) {
                                e222.printStackTrace();
                            }
                        }
                    } catch (OutOfMemoryError e6) {
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        if (TextUtils.isEmpty(stringBuffer)) {
                            str = com.vlocker.b.i.j + stringBuffer;
                            a = a.a((Context) this);
                            a.d(true);
                            a.i(1);
                            l = c.l(this, str);
                            f = c.f(this, str);
                            g = c.g(this, str);
                            if (l != null) {
                            }
                            com.vlocker.m.y.d = f;
                            com.vlocker.m.y.b = g;
                            com.vlocker.m.y.c = str;
                            com.vlocker.m.y.a = str2;
                            a = a.a((Context) this);
                            a.e(com.vlocker.m.y.a);
                            a.d(com.vlocker.m.y.c);
                            a.c(com.vlocker.m.y.b);
                            a.d(com.vlocker.m.y.d);
                            com.vlocker.m.y.e(this, str);
                            com.vlocker.m.y.g(this, str);
                        }
                    } catch (Exception e7) {
                        file.delete();
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        if (TextUtils.isEmpty(stringBuffer)) {
                            str = com.vlocker.b.i.j + stringBuffer;
                            a = a.a((Context) this);
                            a.d(true);
                            a.i(1);
                            l = c.l(this, str);
                            f = c.f(this, str);
                            g = c.g(this, str);
                            if (l != null) {
                            }
                            com.vlocker.m.y.d = f;
                            com.vlocker.m.y.b = g;
                            com.vlocker.m.y.c = str;
                            com.vlocker.m.y.a = str2;
                            a = a.a((Context) this);
                            a.e(com.vlocker.m.y.a);
                            a.d(com.vlocker.m.y.c);
                            a.c(com.vlocker.m.y.b);
                            a.d(com.vlocker.m.y.d);
                            com.vlocker.m.y.e(this, str);
                            com.vlocker.m.y.g(this, str);
                        }
                    }
                } catch (OutOfMemoryError e8) {
                    bufferedReader = null;
                    stringBuffer = null;
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    if (TextUtils.isEmpty(stringBuffer)) {
                        str = com.vlocker.b.i.j + stringBuffer;
                        a = a.a((Context) this);
                        a.d(true);
                        a.i(1);
                        l = c.l(this, str);
                        f = c.f(this, str);
                        g = c.g(this, str);
                        if (l != null) {
                        }
                        com.vlocker.m.y.d = f;
                        com.vlocker.m.y.b = g;
                        com.vlocker.m.y.c = str;
                        com.vlocker.m.y.a = str2;
                        a = a.a((Context) this);
                        a.e(com.vlocker.m.y.a);
                        a.d(com.vlocker.m.y.c);
                        a.c(com.vlocker.m.y.b);
                        a.d(com.vlocker.m.y.d);
                        com.vlocker.m.y.e(this, str);
                        com.vlocker.m.y.g(this, str);
                    }
                } catch (Exception e9) {
                    bufferedReader = null;
                    stringBuffer = null;
                    file.delete();
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    if (TextUtils.isEmpty(stringBuffer)) {
                        str = com.vlocker.b.i.j + stringBuffer;
                        a = a.a((Context) this);
                        a.d(true);
                        a.i(1);
                        l = c.l(this, str);
                        f = c.f(this, str);
                        g = c.g(this, str);
                        if (l != null) {
                        }
                        com.vlocker.m.y.d = f;
                        com.vlocker.m.y.b = g;
                        com.vlocker.m.y.c = str;
                        com.vlocker.m.y.a = str2;
                        a = a.a((Context) this);
                        a.e(com.vlocker.m.y.a);
                        a.d(com.vlocker.m.y.c);
                        a.c(com.vlocker.m.y.b);
                        a.d(com.vlocker.m.y.d);
                        com.vlocker.m.y.e(this, str);
                        com.vlocker.m.y.g(this, str);
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bufferedReader = null;
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    throw th;
                }
                if (TextUtils.isEmpty(stringBuffer)) {
                    str = com.vlocker.b.i.j + stringBuffer;
                    a = a.a((Context) this);
                    a.d(true);
                    a.i(1);
                    l = c.l(this, str);
                    f = c.f(this, str);
                    g = c.g(this, str);
                    if (l != null) {
                    }
                    com.vlocker.m.y.d = f;
                    com.vlocker.m.y.b = g;
                    com.vlocker.m.y.c = str;
                    com.vlocker.m.y.a = str2;
                    a = a.a((Context) this);
                    a.e(com.vlocker.m.y.a);
                    a.d(com.vlocker.m.y.c);
                    a.c(com.vlocker.m.y.b);
                    a.d(com.vlocker.m.y.d);
                    com.vlocker.m.y.e(this, str);
                    com.vlocker.m.y.g(this, str);
                }
            }
        }
    }

    public void a(int i) {
        if (this.u != null) {
            this.u.b(i);
        }
    }

    public void a(int i, int i2, t tVar) {
        if (this.u != null) {
            this.u.a(i, i2, tVar);
        }
    }

    public void a(int i, long j) {
        if (this.u != null) {
            this.u.a(i, j);
        }
    }

    public void a(Runnable runnable, int i) {
        if (this.u != null) {
            this.u.a(runnable, i);
        }
    }

    public void a(String str, boolean z) {
        if (this.u != null) {
            this.u.a(str, z);
        }
    }

    public void b() {
        if (this.u != null) {
            this.u.c();
            this.u.y();
        }
    }

    public boolean c() {
        return this.u != null ? this.u.v() : false;
    }

    public com.vlocker.locker.b.y d() {
        return this.u != null ? this.u.G() : null;
    }

    public void e() {
        if (this.u != null) {
            this.u.F();
        }
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        this.d = 0;
        h = this;
        this.i = a.a((Context) this);
        this.p = new Handler();
        z();
        if (this.i.p()) {
            b.a(MoSecurityApplication.a()).a(true);
            g();
            return;
        }
        ap.a((Context) this).c();
        h();
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.t) {
            this.t = false;
            unregisterReceiver(this.v);
            unregisterReceiver(this.n);
            B();
        }
        if (this.u != null) {
            this.u.r();
            this.u = null;
        }
        if (this.j != null) {
            this.j.b();
            this.j.a(null);
            this.j = null;
        }
        if (this.k != null) {
            this.k.b();
            this.k.a(null);
            this.k = null;
        }
        if (this.l != null) {
            this.l.a();
            this.l = null;
        }
        if (this.o != null) {
            this.o.c();
            this.o = null;
        }
        k.b(this, true);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        k();
        return 1;
    }
}
