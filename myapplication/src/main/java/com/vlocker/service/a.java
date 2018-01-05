package com.vlocker.service;

import android.app.Notification;

class a implements Runnable {
    final /* synthetic */ Notification a;
    final /* synthetic */ String b;
    final /* synthetic */ NotificationListener c;

    a(NotificationListener notificationListener, Notification notification, String str) {
        this.c = notificationListener;
        this.a = notification;
        this.b = str;
    }

    public void run() {
        com.vlocker.k.a.a(this.c.getApplicationContext()).a(this.a, this.b);
    }
}
