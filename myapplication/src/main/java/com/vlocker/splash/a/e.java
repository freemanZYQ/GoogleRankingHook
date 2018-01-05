package com.vlocker.splash.a;

import com.vlocker.ui.view.p;

class e implements p {
    final /* synthetic */ c a;

    e(c cVar) {
        this.a = cVar;
    }

    public void a(int i, int i2) {
        this.a.c();
        this.a.b.b(this.a.a);
        this.a.d();
        com.vlocker.b.p.b(this.a.f, com.vlocker.b.p.a("url", this.a.b.d(), this.a.b.i()), com.vlocker.b.p.e);
        if (this.a.a != null) {
            this.a.a.setDataLoadListener(null);
        }
        if (this.a.b() != null && this.a.b().getDrawable() != null) {
            this.a.b().setVisibility(0);
        }
    }

    public void a(String str) {
        if (this.a.e != null) {
            com.vlocker.b.p.a(this.a.f, "1012");
            this.a.e.a();
            return;
        }
        this.a.c();
    }
}
