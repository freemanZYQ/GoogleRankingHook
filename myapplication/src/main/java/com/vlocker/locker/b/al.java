package com.vlocker.locker.b;

import android.content.Intent;
import com.vlocker.m.t;

class al implements t {
    final /* synthetic */ Runnable a;
    final /* synthetic */ ag b;

    al(ag agVar, Runnable runnable) {
        this.b = agVar;
        this.a = runnable;
    }

    public void a() {
        this.b.c.c();
        this.b.c.z();
    }

    public void a(Intent intent) {
    }

    public void a(String str) {
    }

    public void b() {
        this.a.run();
    }
}
