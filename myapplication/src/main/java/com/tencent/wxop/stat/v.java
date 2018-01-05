package com.tencent.wxop.stat;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.baidu.location.LocationClientOption;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import com.tencent.a.a.a.a.g;
import com.tencent.wxop.stat.b.b;
import com.tencent.wxop.stat.b.l;
import com.tencent.wxop.stat.b.q;
import com.tencent.wxop.stat.b.r;
import java.net.URI;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public final class v {
    private static int A = 1;
    private static String B = null;
    private static String C;
    private static String D;
    private static String E = "mta_channel";
    private static int F = 180;
    private static int G = IXAdIOUtils.BUFFER_SIZE;
    private static long H = 0;
    private static long I = 300000;
    private static volatile String J = "http://pingma.qq.com:80/mstat/report";
    private static int K = 0;
    private static volatile int L = 0;
    private static int M = 20;
    private static int N = 0;
    private static boolean O = false;
    private static int P = 4096;
    private static boolean Q = false;
    private static String R = null;
    private static boolean S = false;
    private static j T = null;
    static i a = new i(2);
    static i b = new i(1);
    static String c = "__HIBERNATE__";
    static String d = "__HIBERNATE__TIME";
    static String e = "__MTA_KILL__";
    static String f = "";
    static boolean g = false;
    static int h = 100;
    static long i = 10000;
    static boolean j = true;
    public static boolean k = true;
    static volatile String l = "pingma.qq.com:80";
    static boolean m = true;
    static int n = 0;
    static long o = 10000;
    static int p = 512;
    private static b q = l.c();
    private static w r = w.APP_LAUNCH;
    private static boolean s = false;
    private static boolean t = true;
    private static int u = 30000;
    private static int v = 100000;
    private static int w = 30;
    private static int x = 10;
    private static int y = 100;
    private static int z = 30;

    public static w a() {
        return r;
    }

    public static synchronized String a(Context context) {
        String str;
        synchronized (v.class) {
            if (C != null) {
                str = C;
            } else {
                if (context != null) {
                    if (C == null) {
                        C = l.f(context);
                    }
                }
                if (C == null || C.trim().length() == 0) {
                    q.d("AppKey can not be null or empty, please read Developer's Guide first!");
                }
                str = C;
            }
        }
        return str;
    }

    static String a(String str) {
        try {
            String string = b.b.getString(str);
            if (string != null) {
                return string;
            }
        } catch (Throwable th) {
            q.c("can't find custom key:" + str);
        }
        return null;
    }

    private static void a(long j) {
        q.a(l.a(), c, j);
        a(false);
        q.b((Object) "MTA is disable for current SDK version");
    }

    static void a(Context context, i iVar) {
        if (iVar.a == b.a) {
            b = iVar;
            a(iVar.b);
            if (!b.b.isNull("iplist")) {
                z.a(context).a(b.b.getString("iplist"));
            }
        } else if (iVar.a == a.a) {
            a = iVar;
        }
    }

    private static void a(Context context, i iVar, JSONObject jSONObject) {
        try {
            String str;
            Object obj;
            Iterator keys = jSONObject.keys();
            Object obj2 = null;
            while (keys.hasNext()) {
                str = (String) keys.next();
                if (str.equalsIgnoreCase(IXAdRequestInfo.V)) {
                    int i = jSONObject.getInt(str);
                    obj = iVar.d != i ? 1 : obj2;
                    iVar.d = i;
                    obj2 = obj;
                } else if (str.equalsIgnoreCase("c")) {
                    str = jSONObject.getString("c");
                    if (str.length() > 0) {
                        iVar.b = new JSONObject(str);
                    }
                } else {
                    try {
                        if (str.equalsIgnoreCase("m")) {
                            iVar.c = jSONObject.getString("m");
                        }
                    } catch (JSONException e) {
                        q.g("__HIBERNATE__ not found.");
                    } catch (Throwable th) {
                        q.b(th);
                    }
                }
            }
            if (obj2 == 1) {
                am a = am.a(l.a());
                if (a != null) {
                    a.a(iVar);
                }
                if (iVar.a == b.a) {
                    a(iVar.b);
                    JSONObject jSONObject2 = iVar.b;
                    if (!(jSONObject2 == null || jSONObject2.length() == 0)) {
                        Context a2 = l.a();
                        try {
                            str = jSONObject2.optString(e);
                            if (l.c(str)) {
                                JSONObject jSONObject3 = new JSONObject(str);
                                if (jSONObject3.length() != 0) {
                                    if (!jSONObject3.isNull("sm")) {
                                        obj = jSONObject3.get("sm");
                                        int intValue = obj instanceof Integer ? ((Integer) obj).intValue() : obj instanceof String ? Integer.valueOf((String) obj).intValue() : 0;
                                        if (intValue > 0) {
                                            if (s) {
                                                q.a("match sleepTime:" + intValue + " minutes");
                                            }
                                            q.a(a2, d, System.currentTimeMillis() + ((long) ((intValue * 60) * LocationClientOption.MIN_SCAN_SPAN)));
                                            a(false);
                                            q.b((Object) "MTA is disable for current SDK version");
                                        }
                                    }
                                    if (a(jSONObject3, "sv", "2.0.3")) {
                                        q.a((Object) "match sdk version:2.0.3");
                                        obj = 1;
                                    } else {
                                        obj = null;
                                    }
                                    if (a(jSONObject3, IXAdRequestInfo.TEST_MODE, Build.MODEL)) {
                                        q.a("match MODEL:" + Build.MODEL);
                                        obj = 1;
                                    }
                                    if (a(jSONObject3, "av", l.j(a2))) {
                                        q.a("match app version:" + l.j(a2));
                                        obj = 1;
                                    }
                                    if (a(jSONObject3, "mf", Build.MANUFACTURER)) {
                                        q.a("match MANUFACTURER:" + Build.MANUFACTURER);
                                        obj = 1;
                                    }
                                    if (a(jSONObject3, IXAdRequestInfo.OSV, VERSION.SDK_INT)) {
                                        q.a("match android SDK version:" + VERSION.SDK_INT);
                                        obj = 1;
                                    }
                                    if (a(jSONObject3, "ov", VERSION.SDK_INT)) {
                                        q.a("match android SDK version:" + VERSION.SDK_INT);
                                        obj = 1;
                                    }
                                    if (a(jSONObject3, "ui", am.a(a2).b(a2).a())) {
                                        q.a("match imei:" + am.a(a2).b(a2).a());
                                        obj = 1;
                                    }
                                    if (a(jSONObject3, "mid", e(a2))) {
                                        q.a("match mid:" + e(a2));
                                        obj = 1;
                                    }
                                    if (obj != null) {
                                        a(l.b("2.0.3"));
                                    }
                                }
                            }
                        } catch (Throwable th2) {
                            q.b(th2);
                        }
                        str = jSONObject2.getString(c);
                        if (s) {
                            q.g("hibernateVer:" + str + ", current version:2.0.3");
                        }
                        long b = l.b(str);
                        if (l.b("2.0.3") <= b) {
                            a(b);
                        }
                    }
                }
            }
            a(context, iVar);
        } catch (Throwable th22) {
            q.b(th22);
        } catch (Throwable th222) {
            q.b(th222);
        }
    }

    public static void a(Context context, String str) {
        if (context == null) {
            q.d("ctx in StatConfig.setAppKey() is null");
        } else if (str == null || str.length() > 256) {
            q.d("appkey in StatConfig.setAppKey() is null or exceed 256 bytes");
        } else {
            if (C == null) {
                C = r.a(q.a(context, "_mta_ky_tag_", null));
            }
            if ((d(str) | d(l.f(context))) != 0) {
                String str2 = C;
                if (str2 != null) {
                    q.b(context, "_mta_ky_tag_", r.b(str2));
                }
            }
        }
    }

    static void a(Context context, JSONObject jSONObject) {
        try {
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                if (str.equalsIgnoreCase(Integer.toString(b.a))) {
                    a(context, b, jSONObject.getJSONObject(str));
                } else if (str.equalsIgnoreCase(Integer.toString(a.a))) {
                    a(context, a, jSONObject.getJSONObject(str));
                } else if (str.equalsIgnoreCase("rs")) {
                    w a = w.a(jSONObject.getInt(str));
                    if (a != null) {
                        r = a;
                        if (s) {
                            q.g("Change to ReportStrategy:" + a.name());
                        }
                    }
                } else {
                    return;
                }
            }
        } catch (Throwable e) {
            q.b(e);
        }
    }

    public static void a(w wVar) {
        r = wVar;
        if (wVar != w.PERIOD) {
            x.c = 0;
        }
        if (s) {
            q.g("Change to statSendStrategy: " + wVar);
        }
    }

    private static void a(JSONObject jSONObject) {
        try {
            w a = w.a(jSONObject.getInt("rs"));
            if (a != null) {
                a(a);
            }
        } catch (JSONException e) {
            if (s) {
                q.a((Object) "rs not found.");
            }
        }
    }

    public static void a(boolean z) {
        t = z;
        if (!z) {
            q.b((Object) "!!!!!!MTA StatService has been disabled!!!!!!");
        }
    }

    private static boolean a(JSONObject jSONObject, String str, String str2) {
        if (!jSONObject.isNull(str)) {
            String optString = jSONObject.optString(str);
            if (l.c(str2) && l.c(optString) && str2.equalsIgnoreCase(optString)) {
                return true;
            }
        }
        return false;
    }

    public static synchronized String b(Context context) {
        String str;
        synchronized (v.class) {
            if (D != null) {
                str = D;
            } else {
                str = q.a(context, E, "");
                D = str;
                if (str == null || D.trim().length() == 0) {
                    D = l.g(context);
                }
                if (D == null || D.trim().length() == 0) {
                    q.c("installChannel can not be null or empty, please read Developer's Guide first!");
                }
                str = D;
            }
        }
        return str;
    }

    public static void b(Context context, String str) {
        if (str.length() > 128) {
            q.d("the length of installChannel can not exceed the range of 128 bytes.");
            return;
        }
        D = str;
        q.b(context, E, str);
    }

    public static void b(String str) {
        if (str.length() > 128) {
            q.d("the length of installChannel can not exceed the range of 128 bytes.");
        } else {
            D = str;
        }
    }

    public static boolean b() {
        return s;
    }

    public static String c(Context context) {
        return q.a(context, "mta.acc.qq", f);
    }

    public static void c(String str) {
        if (str == null || str.length() == 0) {
            q.d("statReportUrl cannot be null or empty.");
            return;
        }
        J = str;
        try {
            l = new URI(J).getHost();
        } catch (Exception e) {
            q.c(e);
        }
        if (s) {
            q.a("url:" + J + ", domain:" + l);
        }
    }

    public static boolean c() {
        return t;
    }

    public static int d() {
        return u;
    }

    public static String d(Context context) {
        if (context == null) {
            q.d("Context for getCustomUid is null.");
            return null;
        }
        if (R == null) {
            R = q.a(context, "MTA_CUSTOM_UID", "");
        }
        return R;
    }

    private static boolean d(String str) {
        if (str == null) {
            return false;
        }
        if (C == null) {
            C = str;
            return true;
        } else if (C.contains(str)) {
            return false;
        } else {
            C += "|" + str;
            return true;
        }
    }

    public static int e() {
        return y;
    }

    public static String e(Context context) {
        return context != null ? g.a(context).a().a() : "0";
    }

    public static int f() {
        return z;
    }

    public static int g() {
        return x;
    }

    public static int h() {
        return A;
    }

    static int i() {
        return w;
    }

    public static int j() {
        return v;
    }

    public static void k() {
        F = 60;
    }

    public static int l() {
        return F;
    }

    public static int m() {
        return G;
    }

    public static void n() {
        j = true;
    }

    public static boolean o() {
        return k;
    }

    public static String p() {
        return J;
    }

    static synchronized void q() {
        synchronized (v.class) {
            L = 0;
        }
    }

    public static int r() {
        return M;
    }

    static void s() {
        N++;
    }

    static void t() {
        N = 0;
    }

    static int u() {
        return N;
    }

    public static boolean v() {
        return Q;
    }

    public static j w() {
        return T;
    }
}
