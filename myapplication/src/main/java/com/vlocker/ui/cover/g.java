package com.vlocker.ui.cover;

import com.vlocker.c.a;
import com.vlocker.security.MoSecurityApplication;

public class g {
    public static boolean a = false;
    public static String b = "main_page";
    public static String c = "main_page";
    public static boolean d = false;

    public static void a(String str) {
        c = b;
        b = str;
    }

    public static boolean a() {
        return b.equals("weather_page");
    }

    public static boolean b() {
        return b.equals("main_page");
    }

    public static boolean c() {
        return b.equals("pwd_page");
    }

    public static boolean d() {
        return b.equals("pattern_page");
    }

    public static boolean e() {
        return c.equals("pwd_page");
    }

    public static boolean f() {
        return c.equals("pattern_page");
    }

    public static String g() {
        return a.a(MoSecurityApplication.a()).Q() ? "pattern_page" : "pwd_page";
    }
}
