package com.vlocker.locker.b;

class s implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ boolean b;
    final /* synthetic */ p c;

    s(p pVar, String str, boolean z) {
        this.c = pVar;
        this.a = str;
        this.b = z;
    }

    public void run() {
        this.c.b(this.a, this.b);
    }
}
