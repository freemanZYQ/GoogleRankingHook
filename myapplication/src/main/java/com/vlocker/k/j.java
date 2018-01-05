package com.vlocker.k;

import android.app.Notification;

class j implements Runnable {
    public int a;
    public Notification b;
    final /* synthetic */ e c;

    j(e eVar) {
        this.c = eVar;
    }

    public void run() {
        this.c.b(this.b, this.a);
    }
}
