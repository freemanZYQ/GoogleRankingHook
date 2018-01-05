package com.inveno.se.f;

import android.content.Context;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.lang.reflect.Constructor;

public class e {
    public static String a;
    public static String b;
    public static String c = "WIFI";
    public static String d;
    public static String e;
    public static String f;
    public static int g;
    public static float h;
    public static String i;
    public static int j = 0;
    public static int k = 0;
    public static String l;
    public static String m;
    public static int n;
    private static int o;
    private static int p;

    public static int a() {
        return o;
    }

    public static void a(Context context) {
        if (o == 0 || p == 0) {
            a.b("手机分辨率w：" + o + "  h:" + p);
            b(context);
        }
    }

    public static int b() {
        return p;
    }

    public static void b(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        h = displayMetrics.density;
        o = displayMetrics.widthPixels;
        p = displayMetrics.heightPixels;
        a.b("reinstallScreenSize 手机分辨率w：" + o + "  h:" + p);
    }

    public static void c(Context context) {
        if (k.a(a)) {
            a = l.a(context);
        }
        if (k.a(b)) {
            b = l.b(context);
        }
        if (k.a(d)) {
            d = l.c(context);
        }
        if (k.a(e)) {
            e = Secure.getString(context.getContentResolver(), "android_id");
        }
        if (k.a(l)) {
            g(context);
        }
        if (k.a(c)) {
            switch (i.a(context)) {
                case 2:
                    c = "2G";
                    break;
                case 3:
                    c = "3G";
                    break;
                case 4:
                    c = "WIFI";
                    break;
            }
            a.b("获取网络：" + c);
        }
        try {
            n = i.b(context);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (k.a(i)) {
            i = f(context);
            a.b("获取user-agent：" + i);
        }
        if (g == 0) {
            g = d(context);
        }
        if (k.a(f)) {
            f = e(context);
            a.a("deviceinfo", "country:" + f);
        }
    }

    public static int d(Context context) {
        int i = 0;
        try {
            Class cls = Class.forName("com.android.internal.R$dimen");
            i = context.getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    public static String e(Context context) {
        return context.getResources().getConfiguration().locale.toString();
    }

    public static String f(Context context) {
        if (VERSION.SDK_INT >= 17) {
            return f.a(context);
        }
        Constructor declaredConstructor;
        try {
            declaredConstructor = WebSettings.class.getDeclaredConstructor(new Class[]{Context.class, WebView.class});
            declaredConstructor.setAccessible(true);
            String userAgentString = ((WebSettings) declaredConstructor.newInstance(new Object[]{context, null})).getUserAgentString();
            declaredConstructor.setAccessible(false);
            return userAgentString;
        } catch (Exception e) {
            return System.getProperty("http.agent");
        } catch (Throwable th) {
            declaredConstructor.setAccessible(false);
        }
    }

    private static void g(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        String networkOperator = telephonyManager.getNetworkOperator();
        try {
            m = networkOperator.substring(0, 3);
            CellLocation cellLocation = telephonyManager.getCellLocation();
            if (cellLocation instanceof GsmCellLocation) {
                k = ((GsmCellLocation) cellLocation).getCid();
                j = ((GsmCellLocation) cellLocation).getLac();
                l = networkOperator.substring(3);
            } else if (cellLocation instanceof CdmaCellLocation) {
                j = ((CdmaCellLocation) cellLocation).getNetworkId();
                l = String.valueOf(((CdmaCellLocation) cellLocation).getSystemId());
                k = ((CdmaCellLocation) cellLocation).getBaseStationId();
            }
        } catch (Exception e) {
            Log.e("inveno", "getGsmLocation error:" + e.getMessage());
        }
    }
}
