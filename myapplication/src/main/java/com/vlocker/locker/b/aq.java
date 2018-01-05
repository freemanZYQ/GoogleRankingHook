package com.vlocker.locker.b;

import com.vlocker.locker.a.a;
import com.vlocker.m.o;
import com.vlocker.security.MoSecurityApplication;
import com.vlocker.ui.widget.c.d;
import com.vlocker.ui.widget.c.f;

class aq extends a {
    final /* synthetic */ String a;
    final /* synthetic */ ap b;

    aq(ap apVar, String str) {
        this.b = apVar;
        this.a = str;
    }

    public void a(d dVar) {
        if (dVar == null) {
            return;
        }
        if (dVar.a() > o.b(MoSecurityApplication.a())) {
            this.b.g();
            this.b.a = true;
            this.b.a(false);
            return;
        }
        ap.f = dVar;
        this.b.h();
        this.b.c();
        this.b.i();
    }

    public /* synthetic */ Object b() {
        return d();
    }

    public void c() {
        this.b.a(false);
    }

    public d d() {
        try {
            return new f().a(this.b.e, this.a);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
