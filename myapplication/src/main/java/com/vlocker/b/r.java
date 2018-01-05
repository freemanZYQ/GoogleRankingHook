package com.vlocker.b;

import com.vlocker.security.MoSecurityApplication;
import com.vlocker.weather.a;
import com.vlocker.weather.a.ah;
import com.vlocker.weather.e.d;

final class r implements Runnable {
    r() {
    }

    public void run() {
        if (p.h == null) {
            return;
        }
        if (p.h.a == 1) {
            if (a.b) {
                d.a(MoSecurityApplication.a());
                ah.a(MoSecurityApplication.a());
                a.b = false;
            }
        } else if (!p.g) {
            p.g = true;
            p.a(MoSecurityApplication.a(), p.h.b, p.h.c, p.h.d, p.h.e, p.h.f, p.h.g, p.h.h, p.h.i);
        }
    }
}
