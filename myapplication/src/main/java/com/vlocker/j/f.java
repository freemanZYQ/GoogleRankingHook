package com.vlocker.j;

import android.app.Notification;

class f implements Runnable {
    final /* synthetic */ Notification a;
    final /* synthetic */ a b;

    f(a aVar, Notification notification) {
        this.b = aVar;
        this.a = notification;
    }

    public void run() {
        this.b.u();
        this.b.a(this.a);
    }
}
