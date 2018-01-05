package com.vlocker.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.service.notification.StatusBarNotification;
import com.vlocker.j.a;
import com.vlocker.j.p;

class d extends BroadcastReceiver {
    final /* synthetic */ NotificationListener a;

    d(NotificationListener notificationListener) {
        this.a = notificationListener;
    }

    public void onReceive(Context context, Intent intent) {
        try {
            String action = intent.getAction();
            if ("android.intent.action.SCREEN_ON".equals(action)) {
                for (StatusBarNotification statusBarNotification : this.a.getActiveNotifications()) {
                    String packageName = statusBarNotification.getPackageName();
                    if (this.a.c.a(packageName) && this.a.b.ap() && p.a(statusBarNotification.getNotification(), packageName)) {
                        a.a().a(statusBarNotification.getNotification(), packageName, statusBarNotification.getId(), statusBarNotification.getPostTime());
                    }
                }
            } else if ("com.vlocker.locker.cleanNotification".equals(action)) {
                action = intent.getStringExtra("pakName");
                if (intent != null && action != null) {
                    this.a.a(action);
                }
            }
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
        } catch (Exception e2) {
        }
    }
}
