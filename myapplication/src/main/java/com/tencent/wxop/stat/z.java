package com.tencent.wxop.stat;

import android.content.Context;
import android.content.IntentFilter;
import com.tencent.wxop.stat.b.b;
import com.tencent.wxop.stat.b.f;
import com.tencent.wxop.stat.b.l;
import com.tencent.wxop.stat.b.r;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import org.apache.http.HttpHost;
import org.json.JSONObject;

public class z {
    private static z g = null;
    private List a = null;
    private volatile int b = 2;
    private volatile String c = "";
    private volatile HttpHost d = null;
    private f e = null;
    private int f = 0;
    private Context h = null;
    private b i = null;

    private z(Context context) {
        this.h = context.getApplicationContext();
        this.e = new f();
        l.a(context);
        this.i = l.c();
        j();
        this.a = new ArrayList(10);
        this.a.add("117.135.169.101");
        this.a.add("140.207.54.125");
        this.a.add("180.153.8.53");
        this.a.add("120.198.203.175");
        this.a.add("14.17.43.18");
        this.a.add("163.177.71.186");
        this.a.add("111.30.131.31");
        this.a.add("123.126.121.167");
        this.a.add("123.151.152.111");
        this.a.add("113.142.45.79");
        this.a.add("123.138.162.90");
        this.a.add("103.7.30.94");
        g();
    }

    public static z a(Context context) {
        if (g == null) {
            synchronized (z.class) {
                if (g == null) {
                    g = new z(context);
                }
            }
        }
        return g;
    }

    private static boolean b(String str) {
        return Pattern.compile("(2[5][0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})").matcher(str).matches();
    }

    private String i() {
        try {
            String str = "pingma.qq.com";
            if (!b(str)) {
                return InetAddress.getByName(str).getHostAddress();
            }
        } catch (Throwable e) {
            this.i.b(e);
        }
        return "";
    }

    private void j() {
        this.b = 0;
        this.d = null;
        this.c = null;
    }

    public final HttpHost a() {
        return this.d;
    }

    public final void a(String str) {
        if (v.b()) {
            this.i.a("updateIpList " + str);
        }
        try {
            if (l.c(str)) {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.length() > 0) {
                    Iterator keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String string = jSONObject.getString((String) keys.next());
                        if (l.c(string)) {
                            for (String str2 : string.split(";")) {
                                String str22;
                                if (l.c(str22)) {
                                    String[] split = str22.split(":");
                                    if (split.length > 1) {
                                        str22 = split[0];
                                        if (b(str22) && !this.a.contains(str22)) {
                                            if (v.b()) {
                                                this.i.a("add new ip:" + str22);
                                            }
                                            this.a.add(str22);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Throwable e) {
            this.i.b(e);
        }
        this.f = new Random().nextInt(this.a.size());
    }

    public final String b() {
        return this.c;
    }

    public final int c() {
        return this.b;
    }

    public final void d() {
        this.f = (this.f + 1) % this.a.size();
    }

    public final boolean e() {
        return this.b == 1;
    }

    public final boolean f() {
        return this.b != 0;
    }

    final void g() {
        if (r.e(this.h)) {
            if (v.g) {
                String i = i();
                if (v.b()) {
                    this.i.a("remoteIp ip is " + i);
                }
                if (l.c(i)) {
                    String str;
                    if (this.a.contains(i)) {
                        str = i;
                    } else {
                        str = (String) this.a.get(this.f);
                        if (v.b()) {
                            this.i.c(i + " not in ip list, change to:" + str);
                        }
                    }
                    v.c("http://" + str + ":80/mstat/report");
                }
            }
            this.c = l.k(this.h);
            if (v.b()) {
                this.i.a("NETWORK name:" + this.c);
            }
            if (l.c(this.c)) {
                if ("WIFI".equalsIgnoreCase(this.c)) {
                    this.b = 1;
                } else {
                    this.b = 2;
                }
                this.d = l.a(this.h);
            }
            if (x.a()) {
                x.c(this.h);
                return;
            }
            return;
        }
        if (v.b()) {
            this.i.a((Object) "NETWORK TYPE: network is close.");
        }
        j();
    }

    public final void h() {
        this.h.getApplicationContext().registerReceiver(new as(this), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }
}
