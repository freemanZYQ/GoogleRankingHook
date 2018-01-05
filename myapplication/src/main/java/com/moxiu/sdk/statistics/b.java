package com.moxiu.sdk.statistics;

public class b {
    protected static String a = "moxiu.launcher.hiderecommand.preferences";
    protected static String b = "firstintolauncher";
    protected static String c = null;
    protected static boolean d = false;
    protected static boolean e = false;

    public static String a() {
        return c;
    }

    public static String a(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("http://cdv.imoxiu.com/collect/");
        stringBuilder.append("?imei=" + str);
        return stringBuilder.toString();
    }

    public static String a(boolean z) {
        StringBuilder stringBuilder = new StringBuilder();
        if (z) {
            stringBuilder.append("http://dsc.imoxiu.com/collect/v1/");
        } else {
            stringBuilder.append("http://alc.imoxiu.com/collect/");
        }
        stringBuilder.append("?app=" + c);
        stringBuilder.append("&key=" + com.moxiu.sdk.statistics.b.b.b());
        stringBuilder.append("&flag=1");
        return stringBuilder.toString();
    }

    public static boolean b() {
        return d;
    }

    public static String c() {
        return a(e);
    }

    public static String d() {
        return a;
    }

    public static String e() {
        return b;
    }
}
