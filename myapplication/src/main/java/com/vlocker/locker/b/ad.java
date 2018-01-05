package com.vlocker.locker.b;

import com.vlocker.m.r;

class ad implements Runnable {
    int a;
    final /* synthetic */ ac b;

    public ad(ac acVar, int i) {
        this.b = acVar;
        this.a = i;
    }

    public void run() {
        r.a().a(this.a, new ae(this));
    }
}
