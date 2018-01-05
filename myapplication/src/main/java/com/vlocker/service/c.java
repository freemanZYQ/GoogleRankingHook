package com.vlocker.service;

import android.service.notification.StatusBarNotification;
import com.vlocker.msg.ab;

class c implements Runnable {
    final /* synthetic */ StatusBarNotification a;
    final /* synthetic */ String b;
    final /* synthetic */ NotificationListener c;

    c(NotificationListener notificationListener, StatusBarNotification statusBarNotification, String str) {
        this.c = notificationListener;
        this.a = statusBarNotification;
        this.b = str;
    }

    public void run() {
        try {
            ab.a().a(this.a.getPackageName(), this.a.getNotification(), this.a.getId());
            synchronized (this.c.e) {
                this.c.e.remove(this.b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
