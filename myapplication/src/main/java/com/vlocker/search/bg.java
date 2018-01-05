package com.vlocker.search;

import com.vlocker.locker.d.i;

class bg extends i {
    final /* synthetic */ ba a;

    bg(ba baVar) {
        this.a = baVar;
    }

    public void a(String str) {
        super.a(str);
        Thread bhVar = new bh(this, str);
        bhVar.setPriority(3);
        bhVar.start();
    }

    public void a(Throwable th, int i, String str) {
        super.a(th, i, str);
        if (this.a.b == null) {
            this.a.i.a("starry");
        }
    }

    public void c() {
        super.c();
    }
}
