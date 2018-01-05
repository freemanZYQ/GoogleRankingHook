package com.vlocker.weather.c.d;

import com.inveno.se.a;
import com.vlocker.security.MoSecurityApplication;
import com.vlocker.weather.c.c.b;
import com.vlocker.weather.c.c.c;

public class d extends a {
    private static final int[] d = new int[]{1};
    private static final int[] e = new int[]{2};
    private static final int[] f = new int[]{1, 2};
    private boolean g;

    public d() {
        this.a = 1;
    }

    public b a(com.inveno.se.model.d dVar, boolean z) {
        return new c(dVar, z);
    }

    public void a() {
        try {
            a.a().a(MoSecurityApplication.a());
            com.inveno.se.b.a("zh_CN");
            com.inveno.se.b.a(MoSecurityApplication.a());
            this.g = true;
        } catch (Exception e) {
            this.g = false;
        }
    }

    public void b() {
        com.inveno.se.b.a(MoSecurityApplication.a(), "0x010100", 12, d, e, f, new e(this));
    }

    public void c() {
        com.inveno.se.b.b(MoSecurityApplication.a(), "0x010100", 12, d, e, f, new f(this));
    }

    public boolean d() {
        return this.g;
    }

    public void e() {
    }
}
