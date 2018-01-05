package com.xinmei365.fontsdk.a;

import android.content.Context;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.xinmei365.fontsdk.a;
import java.util.HashMap;
import java.util.Map;

public class e {
    private static Context context;

    private static void a(Map map) {
        if (map != null) {
            map.put("appkey", a.e);
        }
    }

    public static void c(Context context) {
        context = context;
        new b().p();
    }

    private static void e(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put(str, str2);
        hashMap.put("k", a.e);
        hashMap.put(IXAdRequestInfo.V, String.valueOf(20));
        hashMap.put("vn", String.valueOf("2.2.5"));
        hashMap.put("p", context.getPackageName());
    }

    public static void q() {
        r("i");
    }

    public static void r() {
        r("rd");
    }

    private static void r(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(str, "");
        hashMap.put("k", a.e);
        hashMap.put(IXAdRequestInfo.V, String.valueOf(20));
        hashMap.put("vn", String.valueOf("2.2.5"));
        hashMap.put("p", context.getPackageName());
    }

    public static void s() {
        r("rds");
    }

    public static void s(String str) {
        e("df", str);
    }

    public static void t() {
        r("ucd");
    }

    public static void t(String str) {
        e("dfs", str);
        Map hashMap = new HashMap();
        hashMap.put("event", "dowload");
        hashMap.put("fontIdNo", str);
        a(hashMap);
    }

    public static void u() {
        r("fc");
    }

    public static void u(String str) {
        e("rc", str);
    }

    public static void v() {
        r("kc");
    }

    public static void v(String str) {
        e("rcs", str);
        Map hashMap = new HashMap();
        hashMap.put("event", "clouddownload");
        hashMap.put("fontIdNo", str);
        a(hashMap);
    }

    public static void w() {
        Map hashMap = new HashMap();
        hashMap.put("event", "list");
        a(hashMap);
    }

    public static void w(String str) {
        e("ucf", str);
    }
}
