package com.inveno.se.f;

public class o {
    private static String a;
    private static String b;
    private static String c;
    private static String d = null;
    private static long e = 0;

    static {
        a = b.e;
        b = b.f;
        c = b.g;
        a.b("init static host:" + a + " SECOND_HOST:" + b + " ZZ_HOST:" + c);
        a = b.e;
        b = b.f;
        c = b.g;
    }

    public static String a(String str) {
        return a + str;
    }

    public static void a() {
    }
}
