package com.moxiu.sdk.statistics.b;

import android.text.TextUtils;

public class b {
    private static String a = null;
    private static String b = null;

    public static byte[] a() {
        if (TextUtils.isEmpty(a)) {
            c();
        }
        return a.getBytes();
    }

    public static String b() {
        if (TextUtils.isEmpty(b)) {
            c();
        }
        return b;
    }

    private static void c() {
        if ("549c6462ba4d9b4d098b4567".equals(com.moxiu.sdk.statistics.b.a())) {
            a = "tid00roe";
            b = "15367b9347f87abb746482957862ed14";
        } else if ("f68c0bc9326abe249e233d1b".equals(com.moxiu.sdk.statistics.b.a())) {
            a = "wyoa22za";
            b = "1a882a8cd3745354894cc15fd2c4a723";
        } else if ("52df3b4c0a74c701bf63e4c5".equals(com.moxiu.sdk.statistics.b.a()) || "baf5e2ee4ef31f24f3d0d8a9".equals(com.moxiu.sdk.statistics.b.a())) {
            a = "a424thvm";
            b = "f069879f812e0b28943bbe6be5dcfee9";
        } else if ("556d0b43bb4d9b3c7a8b4567".equals(com.moxiu.sdk.statistics.b.a())) {
            a = "wyoa22za";
            b = "1a882a8cd3745354894cc15fd2c4a723";
        } else {
            a = "tid00roe";
            b = "15367b9347f87abb746482957862ed14";
        }
    }
}
