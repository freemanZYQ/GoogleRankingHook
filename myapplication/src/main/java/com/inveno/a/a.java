package com.inveno.a;

public class a {
    public static void a(String str) {
        com.inveno.se.f.a.a("DataSDK", "进入列表：scenario = " + str);
        ae.a(str, System.currentTimeMillis());
    }

    public static void a(String str, String str2) {
        com.inveno.se.f.a.a("DataSDK", "进入详情 scenario = " + str + " contentId = " + str2);
        ae.a(str, str2, System.currentTimeMillis(), 1);
    }

    public static void a(String str, String str2, String str3, long j, String str4, String str5) {
        ae.a(str, str2, str3, j, str4, str5, System.currentTimeMillis());
    }

    public static void a(String str, String str2, String str3, String str4, String str5) {
        ae.a(str, str2, str3, true, str4, str5, System.currentTimeMillis());
    }

    public static void b(String str) {
        com.inveno.se.f.a.a("DataSDK", "退出列表：scenario = " + str);
        ae.b(str, System.currentTimeMillis());
    }

    public static void b(String str, String str2, String str3, String str4, String str5) {
        com.inveno.se.f.a.a("DataSDK", "退出详情 scenario = " + str + " contentId = " + str2);
        ae.a(str, str2, str3, str4, str5, System.currentTimeMillis());
    }
}
