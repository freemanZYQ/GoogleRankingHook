package com.baidu.location.e;

import android.location.Location;
import com.baidu.location.h.i;

public class a {
    private static long a;
    private static i b;
    private static Location c;
    private static String d;

    public static String a() {
        return d;
    }

    public static void a(long j) {
        a = j;
    }

    public static void a(Location location) {
        c = location;
    }

    public static void a(i iVar) {
        b = iVar;
    }

    public static void a(String str) {
        d = str;
    }

    public static long b() {
        return a;
    }

    public static i c() {
        return b;
    }

    public static Location d() {
        return c;
    }
}
