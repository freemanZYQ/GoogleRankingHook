package com.vlocker.l;

class r implements Runnable {
    final /* synthetic */ ae a;
    final /* synthetic */ ae b;
    final /* synthetic */ j c;

    r(j jVar, ae aeVar, ae aeVar2) {
        this.c = jVar;
        this.a = aeVar;
        this.b = aeVar2;
    }

    public void run() {
        this.a.a();
        this.b.a();
    }
}
