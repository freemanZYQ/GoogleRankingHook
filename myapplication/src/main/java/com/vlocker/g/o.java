package com.vlocker.g;

import com.vlocker.m.r;

class o implements Runnable {
    int a;
    final /* synthetic */ l b;

    public o(l lVar, int i) {
        this.b = lVar;
        this.a = i;
    }

    public void run() {
        r.a().a(this.a, new p(this));
    }
}
