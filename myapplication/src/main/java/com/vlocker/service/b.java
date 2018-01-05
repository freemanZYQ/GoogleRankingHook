package com.vlocker.service;

import android.app.Notification;
import com.vlocker.j.a;

class b implements Runnable {
    final /* synthetic */ Notification a;
    final /* synthetic */ String b;
    final /* synthetic */ int c;
    final /* synthetic */ long d;
    final /* synthetic */ String e;
    final /* synthetic */ NotificationListener f;

    b(NotificationListener notificationListener, Notification notification, String str, int i, long j, String str2) {
        this.f = notificationListener;
        this.a = notification;
        this.b = str;
        this.c = i;
        this.d = j;
        this.e = str2;
    }

    public void run() {
        try {
            a.a().a(this.a, this.b, this.c, this.d);
            synchronized (this.f.e) {
                this.f.e.remove(this.e);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
