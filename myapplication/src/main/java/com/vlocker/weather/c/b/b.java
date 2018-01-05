package com.vlocker.weather.c.b;

import com.inveno.se.model.d;
import com.vlocker.weather.a;
import com.vlocker.weather.c.c.c;

public class b implements a {
    private boolean a;
    private com.vlocker.weather.c.c.b b;

    public void a() {
        if (!this.a && a.e) {
            this.a = true;
            com.inveno.a.a.a("0x010100");
        }
    }

    public void a(com.vlocker.weather.c.c.b bVar) {
        d a = ((c) bVar).a();
        com.inveno.a.a.a("0x010100", a.a(), a.e(), null, null);
    }

    public void b() {
        if (this.a) {
            this.a = false;
            com.inveno.a.a.b("0x010100");
        }
    }

    public void b(com.vlocker.weather.c.c.b bVar) {
        d a = ((c) bVar).a();
        com.inveno.a.a.a("0x010100", a.a(), a.e(), Long.valueOf(a.g()).longValue(), null, null);
    }

    public void c() {
        if (this.b != null) {
            d a = ((c) this.b).a();
            com.inveno.a.a.b("0x010100", a.a(), a.e(), "", "");
            this.b = null;
        }
    }

    public void c(com.vlocker.weather.c.c.b bVar) {
        if (this.b == null) {
            this.b = bVar;
            ((c) bVar).a();
            com.inveno.a.a.a("0x010100", ((c) bVar).a().a());
        }
    }
}
