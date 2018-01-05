package com.vlocker.weather.c.d;

import com.vlocker.security.MoSecurityApplication;
import com.vlocker.weather.c.b.a;
import com.vlocker.weather.c.b.b;

public class c {
    private static int a = 1;
    private static c d;
    private a b;
    private a c;

    private c() {
        a(com.vlocker.c.a.a(MoSecurityApplication.a()).cQ());
    }

    public static c a() {
        if (d == null) {
            d = new c();
        }
        return d;
    }

    private void d() {
        switch (a) {
            case 1:
                this.b = new d();
                this.c = new b();
                return;
            case 2:
                this.b = new g();
                this.c = new com.vlocker.weather.c.b.c();
                return;
            default:
                return;
        }
    }

    public void a(String str) {
        if ("moxiu".equals(str)) {
            a = 2;
        } else if ("inveno".equals(str)) {
            a = 1;
        }
        d();
    }

    public a b() {
        return this.b;
    }

    public a c() {
        return this.c;
    }
}
