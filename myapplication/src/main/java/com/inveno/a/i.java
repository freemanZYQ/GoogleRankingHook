package com.inveno.a;

import a.a;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import java.util.Locale;
import java.util.Map;
import java.util.WeakHashMap;

public class i {
    static Context a;
    static WeakHashMap b = new WeakHashMap();

    public static Map a() {
        return l.a().B();
    }

    static void a(long j) {
        ag.a().a(j);
    }

    public static void a(Context context, String str, String str2, String str3, String str4, String str5, String str6, au auVar) {
        a = context;
        a.a(context);
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        l.a().a(str);
        l.a().b(str2);
        l.a().c(str3);
        l.a().l(str4);
        l.a().e("1.0.0");
        l.a().a(av.b(context));
        l.a().b(av.a(context));
        m.a = str5;
        m.b = str6;
        if (!a.c) {
            l.a().f(telephonyManager.getDeviceId());
        }
        l.a().g(Secure.getString(a.getContentResolver(), "android_id"));
        l.a().h(Build.BRAND);
        l.a().i(Build.MODEL);
        l.a().j(VERSION.RELEASE);
        String language = Locale.getDefault().getLanguage();
        l.a().k(language + "_" + Locale.getDefault().getCountry());
        language = ((TelephonyManager) a.getSystemService("phone")).getNetworkOperator();
        if (!TextUtils.isEmpty(language) && language.length() > 3) {
            l.a().n(language.substring(0, 3));
            l.a().m(language.substring(3));
        }
        WindowManager windowManager = (WindowManager) a.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            l.a().d(displayMetrics.widthPixels);
            l.a().c(displayMetrics.heightPixels);
        }
        WifiInfo connectionInfo = ((WifiManager) a.getSystemService(IXAdSystemUtils.NT_WIFI)).getConnectionInfo();
        if (!(connectionInfo == null || connectionInfo.getMacAddress() == null)) {
            l.a().o(connectionInfo.getMacAddress());
        }
        g.a().a(auVar);
        r.a().b();
        d.a().b();
        ah.a();
        if (an.a && !com.inveno.se.c.a.a(context).a()) {
            com.inveno.se.c.a.a(context).a(new j(), context);
        }
        b.a(context);
    }

    public static void a(String str) {
        l.a().d(str);
    }

    static void b() {
        ag.a().a(0);
        r.a().c();
        r.a().d();
        for (aj ajVar : b.keySet()) {
            if (ajVar != null) {
                ajVar.a();
            }
        }
        com.inveno.se.f.a.a("DataSDK", "reset触发上报");
        as.a().a(5);
    }

    public static void b(String str) {
        l.a().p(str);
    }
}
