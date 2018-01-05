package com.vlocker.splash.a;

import com.moxiu.b.a.a;
import com.vlocker.b.p;

class b implements com.moxiu.b.b.b {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public void a() {
        this.a.b.sendEmptyMessage(40);
    }

    public void a(a aVar) {
        aVar.b(aVar.Q);
        p.b(this.a.f, aVar.m(), aVar.n());
        if (!(this.a.b() == null || this.a.b().getDrawable() == null)) {
            this.a.b().setVisibility(0);
        }
        this.a.d();
    }

    public void b(a aVar) {
        if (this.a.e != null) {
            p.a(this.a.f, "1012");
            this.a.e.a();
            return;
        }
        this.a.c();
    }

    public void c(a aVar) {
        try {
            aVar.a(aVar.Q);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        p.a(this.a.f, "", p.f);
    }
}
