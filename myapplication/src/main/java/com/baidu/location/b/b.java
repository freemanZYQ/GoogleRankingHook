package com.baidu.location.b;

import android.hardware.SensorManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import com.baidu.location.f;
import com.baidu.location.f.a.a;

public class b {
    public static String g = null;
    public static String h = null;
    public static String i = null;
    public static String j = null;
    private static b k = null;
    public String a = null;
    public String b = null;
    String c = null;
    SensorManager d = null;
    int e = -1;
    int f = -1;

    private b() {
        try {
            this.a = ((TelephonyManager) f.getServiceContext().getSystemService("phone")).getDeviceId();
        } catch (Exception e) {
            this.a = "NULL";
        }
        try {
            this.b = a.a(f.getServiceContext());
        } catch (Exception e2) {
            this.b = null;
        }
        try {
            g = f.getServiceContext().getPackageName();
        } catch (Exception e3) {
            g = null;
        }
    }

    public static b a() {
        if (k == null) {
            k = new b();
        }
        return k;
    }

    public String a(boolean z) {
        return a(z, null);
    }

    public String a(boolean z, String str) {
        StringBuffer stringBuffer = new StringBuffer(256);
        stringBuffer.append("&sdk=");
        stringBuffer.append(6.05f);
        if (z) {
            if (h.f.equals("all")) {
                stringBuffer.append("&addr=all");
            }
            if (h.g || h.i || h.j || h.h) {
                stringBuffer.append("&sema=");
                if (h.g) {
                    stringBuffer.append("aptag|");
                }
                if (h.h) {
                    stringBuffer.append("aptagd|");
                }
                if (h.i) {
                    stringBuffer.append("poiregion|");
                }
                if (h.j) {
                    stringBuffer.append("regular");
                }
            }
        }
        if (z) {
            if (str == null) {
                stringBuffer.append("&coor=gcj02");
            } else {
                stringBuffer.append("&coor=");
                stringBuffer.append(str);
            }
        }
        if (this.b == null) {
            stringBuffer.append("&im=");
            stringBuffer.append(this.a);
        } else {
            stringBuffer.append("&cu=");
            stringBuffer.append(this.b);
        }
        stringBuffer.append("&fw=");
        stringBuffer.append(f.getFrameVersion());
        stringBuffer.append("&lt=1");
        stringBuffer.append("&mb=");
        stringBuffer.append(Build.MODEL);
        stringBuffer.append("&resid=");
        stringBuffer.append("12");
        stringBuffer.append("&os=A");
        stringBuffer.append(VERSION.SDK);
        if (z) {
            stringBuffer.append("&sv=");
            String str2 = VERSION.RELEASE;
            if (str2 != null && str2.length() > 6) {
                str2 = str2.substring(0, 6);
            }
            stringBuffer.append(str2);
        }
        return stringBuffer.toString();
    }

    public void a(String str, String str2) {
        h = str;
        g = str2;
    }

    public String b() {
        return this.b != null ? "v6.05|" + this.b + "|" + Build.MODEL : "v6.05|" + this.a + "|" + Build.MODEL;
    }

    public String c() {
        return g != null ? b() + "|" + g : b();
    }

    public String d() {
        StringBuffer stringBuffer = new StringBuffer();
        if (this.b == null) {
            stringBuffer.append("&im=");
            stringBuffer.append(this.a);
        } else {
            stringBuffer.append("&cu=");
            stringBuffer.append(this.b);
        }
        stringBuffer.append("&mb=");
        stringBuffer.append(Build.MODEL);
        stringBuffer.append("&os=A");
        stringBuffer.append(VERSION.SDK);
        stringBuffer.append("&prod=");
        stringBuffer.append(h + ":" + g);
        stringBuffer.append("&resid=");
        stringBuffer.append("12");
        return stringBuffer.toString();
    }
}
