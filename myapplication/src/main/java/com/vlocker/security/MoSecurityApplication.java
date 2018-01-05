package com.vlocker.security;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.moxiu.sdk.statistics.a;
import com.samsung.android.sdk.SsdkUnsupportedException;
import com.samsung.android.sdk.pass.Spass;
import com.vlocker.locker.R;
import com.vlocker.m.aj;
import com.vlocker.m.ay;
import com.vlocker.setting.a.b;
import com.vlocker.weather.c.d.c;
import com.xinmei365.fontsdk.FontCenter;
import java.io.File;
import java.util.ArrayList;
import java.util.Locale;

public class MoSecurityApplication extends Application {
    public static boolean a = false;
    public static boolean b = false;
    public static boolean c = false;
    public static boolean d = false;
    public static boolean e = false;
    private static MoSecurityApplication g;
    private ArrayList f = new ArrayList();
    private Locale h;

    public MoSecurityApplication() {
        g = this;
    }

    public static MoSecurityApplication a() {
        return g;
    }

    public static void d() {
        Object propertyByName = b.getPropertyByName("ro.build.product");
        boolean z = !TextUtils.isEmpty(propertyByName) && propertyByName.toLowerCase().startsWith("r9plus");
        d = z;
    }

    private void f() {
        a.a(false);
        a.b(false);
        a.a((Application) this, "556d0b43bb4d9b3c7a8b4567");
        a.a("launcher.preferences.newvlockerlock", "cm_first_install_time");
    }

    private void g() {
        try {
            if (com.vlocker.theme.f.b.a()) {
                com.vlocker.c.a a = com.vlocker.c.a.a((Context) this);
                Spass spass = new Spass();
                spass.initialize(this);
                if (spass.isFeatureEnabled(0)) {
                    a.aD(true);
                }
            }
        } catch (SsdkUnsupportedException e) {
            e.printStackTrace();
        } catch (Exception e2) {
        }
    }

    private void h() {
        b.checkFloatWindowAllowShow(this, new b(this));
    }

    private void i() {
        k.a();
        if (com.vlocker.c.a.a((Context) this).M() == 0) {
            com.vlocker.c.a.a((Context) this).h(System.currentTimeMillis());
            com.vlocker.c.a.a((Context) this).i(System.currentTimeMillis());
        }
    }

    private void j() {
        new Thread(new c(this)).start();
    }

    private void k() {
        try {
            mcm.sdk.a.a(getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }
        m();
        try {
            com.b.d.a.a(this, getResources().getString(R.string.t_market_theme_manager_child));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void l() {
        new Thread(new d(this)).start();
    }

    private void m() {
        com.alimama.ad.mobile.b.a aVar = new com.alimama.ad.mobile.b.a();
        aVar.a("login", 2);
        aVar.a("appKey", "23338961");
        aVar.a("appSecret", "e289f636376cae2e6e475aaa43b780f0");
        aVar.a("appContext", (Object) this);
        aVar.a("failedMode", "openH5");
        com.alimama.ad.mobile.a.a().a(aVar);
    }

    public void a(Activity activity) {
        synchronized (this.f) {
            this.f.add(activity);
        }
    }

    public File b() {
        File file = null;
        try {
            file = getExternalFilesDir(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return file;
    }

    public void b(Activity activity) {
        synchronized (this.f) {
            this.f.remove(activity);
        }
    }

    public Locale c() {
        if (this.h == null) {
            String str = ay.a;
            String str2 = ay.c;
            if (str.equalsIgnoreCase(ay.a)) {
                str = getResources().getConfiguration().locale.getLanguage();
            }
            if (str2.equalsIgnoreCase(ay.c)) {
                str2 = getResources().getConfiguration().locale.getCountry();
            }
            this.h = new Locale(str, str2);
        }
        return this.h;
    }

    public void e() {
        synchronized (this.f) {
            if (!this.f.isEmpty()) {
                for (int size = this.f.size() - 1; size >= 0; size--) {
                    Activity activity = (Activity) this.f.get(size);
                    if (activity != null) {
                        activity.finish();
                    }
                }
                this.f.clear();
            }
        }
    }

    public void onCreate() {
        boolean z = true;
        super.onCreate();
        e.b().a((Context) this);
        l();
        d();
        f();
        i();
        k();
        j();
        if (aj.c(this, getPackageName()) != 1) {
            z = false;
        }
        b = z;
        h();
        g();
        com.vlocker.weather.a.d = com.vlocker.c.a.a((Context) this).cX();
        if (com.vlocker.weather.a.d) {
            c.a().b().a();
        }
        FontCenter.init(this);
    }
}
