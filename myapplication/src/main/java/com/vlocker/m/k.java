package com.vlocker.m;

import android.os.Build;

public class k {
    private static final String a = Build.MODEL.toLowerCase();
    private static final String b = Build.MANUFACTURER.toLowerCase();

    public static boolean a() {
        return a.equalsIgnoreCase("gt-p1000");
    }

    public static boolean b() {
        return b.equals("zte") && a.contains("zte u985");
    }

    public static boolean c() {
        return a.equalsIgnoreCase("gt-s5830i");
    }
}
