package com.tencent.wxop.stat;

import android.content.Context;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.tencent.wxop.stat.a.i;
import com.tencent.wxop.stat.b.b;
import com.tencent.wxop.stat.b.f;
import com.tencent.wxop.stat.b.l;
import com.tencent.wxop.stat.b.q;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public class x {
    static volatile int a = 0;
    static volatile long b = 0;
    static volatile long c = 0;
    private static f d;
    private static volatile Map e = new ConcurrentHashMap();
    private static volatile Map f = new ConcurrentHashMap();
    private static volatile Map g = new ConcurrentHashMap(10);
    private static volatile long h = 0;
    private static volatile long i = 0;
    private static volatile long j = 0;
    private static String k = "";
    private static volatile int l = 0;
    private static volatile String m = "";
    private static volatile String n = "";
    private static Map o = new ConcurrentHashMap();
    private static Map p = new ConcurrentHashMap();
    private static b q = l.c();
    private static UncaughtExceptionHandler r = null;
    private static volatile boolean s = true;
    private static Context t = null;

    static int a(Context context, boolean z, y yVar) {
        boolean z2 = true;
        long currentTimeMillis = System.currentTimeMillis();
        boolean z3 = z && currentTimeMillis - i >= ((long) v.d());
        i = currentTimeMillis;
        if (j == 0) {
            j = l.d();
        }
        if (currentTimeMillis >= j) {
            j = l.d();
            if (am.a(context).b(context).d() != 1) {
                am.a(context).b(context).c();
            }
            v.t();
            a = 0;
            k = l.e();
            z3 = true;
        }
        Object obj = k;
        if (l.a(yVar)) {
            obj = yVar.c() + k;
        }
        if (p.containsKey(obj)) {
            z2 = z3;
        }
        if (z2) {
            if (l.a(yVar)) {
                a(context, yVar);
            } else if (v.u() < v.r()) {
                l.u(context);
                a(context, null);
            } else {
                q.e("Exceed StatConfig.getMaxDaySessionNumbers().");
            }
            p.put(obj, Long.valueOf(1));
        }
        if (s) {
            if (v.c()) {
                Context g = g(context);
                if (g == null) {
                    q.d("The Context of StatService.testSpeed() can not be null!");
                } else if (i(g) != null) {
                    d.a(new ab(g));
                }
            }
            s = false;
        }
        return l;
    }

    public static Properties a(String str) {
        return (Properties) f.get(str);
    }

    public static void a(Context context) {
        if (v.c() && i(context) != null) {
            d.a(new ae(context));
        }
    }

    private static void a(Context context, y yVar) {
        if (i(context) != null) {
            if (v.b()) {
                q.g("start new session.");
            }
            if (yVar == null || l == 0) {
                l = l.a();
            }
            v.q();
            v.s();
            new ai(new i(context, l, l(), yVar)).a();
        }
    }

    public static void a(Context context, String str) {
        if (v.c()) {
            Context g = g(context);
            if (g == null) {
                q.d("The Context of StatService.trackCustomEvent() can not be null!");
                return;
            }
            Object obj = (str == null || str.length() == 0) ? 1 : null;
            if (obj != null) {
                q.d("The event_id of StatService.trackCustomEvent() can not be null or empty.");
                return;
            }
            com.tencent.wxop.stat.a.b bVar = new com.tencent.wxop.stat.a.b(str);
            if (i(g) != null) {
                d.a(new s(g, bVar));
            }
        }
    }

    public static void a(Context context, String str, y yVar) {
        if (v.c()) {
            Context g = g(context);
            if (g == null || str == null || str.length() == 0) {
                q.d("The Context or pageName of StatService.trackBeginPage() can not be null or empty!");
                return;
            }
            String str2 = new String(str);
            if (i(g) != null) {
                d.a(new t(str2, g, yVar));
            }
        }
    }

    static void a(Context context, Throwable th) {
        if (v.c()) {
            Context g = g(context);
            if (g == null) {
                q.d("The Context of StatService.reportSdkSelfException() can not be null!");
            } else if (i(g) != null) {
                d.a(new q(g, th));
            }
        }
    }

    static boolean a() {
        if (a < 2) {
            return false;
        }
        b = System.currentTimeMillis();
        return true;
    }

    public static boolean a(Context context, String str, String str2) {
        try {
            if (v.c()) {
                String str3 = "2.0.3";
                if (v.b()) {
                    q.g("MTA SDK version, current: " + str3 + " ,required: " + str2);
                }
                if (context == null || str2 == null) {
                    q.d("Context or mtaSdkVersion in StatService.startStatService() is null, please check it!");
                    v.a(false);
                    return false;
                } else if (l.b(str3) < l.b(str2)) {
                    q.d(("MTA SDK version conflicted, current: " + str3 + ",required: " + str2) + ". please delete the current SDK and download the latest one. official website: http://mta.qq.com/ or http://mta.oa.com/");
                    v.a(false);
                    return false;
                } else {
                    str3 = v.b(context);
                    if (str3 == null || str3.length() == 0) {
                        v.b("-");
                    }
                    if (str != null) {
                        v.a(context, str);
                    }
                    if (i(context) != null) {
                        d.a(new af(context));
                    }
                    return true;
                }
            }
            q.d("MTA StatService is disable.");
            return false;
        } catch (Throwable th) {
            q.b(th);
            return false;
        }
    }

    static void b() {
        a = 0;
        b = 0;
    }

    public static void b(Context context) {
        if (v.c() && i(context) != null) {
            d.a(new p(context));
        }
    }

    public static void b(Context context, String str, y yVar) {
        if (v.c()) {
            Context g = g(context);
            if (g == null || str == null || str.length() == 0) {
                q.d("The Context or pageName of StatService.trackEndPage() can not be null or empty!");
                return;
            }
            String str2 = new String(str);
            if (i(g) != null) {
                d.a(new ad(g, str2, yVar));
            }
        }
    }

    static void c() {
        a++;
        b = System.currentTimeMillis();
        e(t);
    }

    static void c(Context context) {
        if (v.c()) {
            Context g = g(context);
            if (g == null) {
                q.d("The Context of StatService.sendNetworkDetector() can not be null!");
                return;
            }
            try {
                l.b(g).a(new com.tencent.wxop.stat.a.f(g), new r());
            } catch (Throwable th) {
                q.b(th);
            }
        }
    }

    public static void d(Context context) {
        if (v.c()) {
            if (v.b()) {
                q.a((Object) "commitEvents, maxNumber=-1");
            }
            Context g = g(context);
            if (g == null) {
                q.d("The Context of StatService.commitEvents() can not be null!");
            } else if (z.a(t).f() && i(g) != null) {
                d.a(new aa(g));
            }
        }
    }

    public static void e(Context context) {
        if (v.c() && v.n > 0) {
            Context g = g(context);
            if (g == null) {
                q.d("The Context of StatService.testSpeed() can not be null!");
            } else {
                am.a(g).c();
            }
        }
    }

    static void f(Context context) {
        c = System.currentTimeMillis() + ((long) (60000 * v.l()));
        q.a(context, "last_period_ts", c);
        d(context);
    }

    private static Context g(Context context) {
        return context != null ? context : t;
    }

    private static synchronized void h(Context context) {
        boolean z = false;
        synchronized (x.class) {
            if (context != null) {
                if (d == null) {
                    long a = q.a(context, v.c);
                    long b = l.b("2.0.3");
                    boolean z2 = true;
                    if (b <= a) {
                        q.d("MTA is disable for current version:" + b + ",wakeup version:" + a);
                        z2 = false;
                    }
                    a = q.a(context, v.d);
                    if (a > System.currentTimeMillis()) {
                        q.d("MTA is disable for current time:" + System.currentTimeMillis() + ",wakeup time:" + a);
                    } else {
                        z = z2;
                    }
                    v.a(z);
                    if (z) {
                        Context applicationContext = context.getApplicationContext();
                        t = applicationContext;
                        d = new f();
                        k = l.e();
                        h = System.currentTimeMillis() + v.i;
                        d.a(new o(applicationContext));
                    }
                }
            }
        }
    }

    private static f i(Context context) {
        if (d == null) {
            synchronized (x.class) {
                if (d == null) {
                    try {
                        h(context);
                    } catch (Throwable th) {
                        q.a(th);
                        v.a(false);
                    }
                }
            }
        }
        return d;
    }

    private static JSONObject l() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (v.b.d != 0) {
                jSONObject2.put(IXAdRequestInfo.V, v.b.d);
            }
            jSONObject.put(Integer.toString(v.b.a), jSONObject2);
            jSONObject2 = new JSONObject();
            if (v.a.d != 0) {
                jSONObject2.put(IXAdRequestInfo.V, v.a.d);
            }
            jSONObject.put(Integer.toString(v.a.a), jSONObject2);
        } catch (Throwable e) {
            q.b(e);
        }
        return jSONObject;
    }
}
