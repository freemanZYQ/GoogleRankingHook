package com.vlocker.locker.b;

import com.vlocker.ui.cover.g;

class z implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ y b;

    z(y yVar, int i) {
        this.b = yVar;
        this.a = i;
    }

    public void run() {
        if (g.c()) {
            this.b.a.e.a(this.a);
        } else if (g.d()) {
            this.b.a.f.a(this.a);
        }
    }
}
