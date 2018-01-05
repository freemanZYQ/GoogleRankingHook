package com.inveno.a;

public class ah {
    static ah a;
    static String b = "https://sandbox.inveno.com/gate/";
    static String d = "http://sandbox.inveno.com/gate/";
    static String t = d;
    String c = (b + "report");
    String e = "getuid";
    String f = "info/list";
    String g = "info/search";
    String h = "info/detail";
    String i = "info/relevant";
    String j = "gateweb/info/hotInfoTitle";
    String k = "gateweb/info/hotInfoList";
    String l = "gateweb/push/bindtoken";
    String m = (d + this.e);
    String n = (d + this.f);
    String o = (d + this.g);
    String p = (d + this.h);
    String q = (d + this.i);
    String r = (d + this.j);
    String s = (d + this.k);
    String u = (t + this.l);

    private ah() {
    }

    static synchronized ah a() {
        ah ahVar;
        synchronized (ah.class) {
            if (a == null) {
                a = new ah();
            }
            ahVar = a;
        }
        return ahVar;
    }

    public static void a(String str) {
        b = str;
    }

    public static void b(String str) {
        d = str;
    }
}
