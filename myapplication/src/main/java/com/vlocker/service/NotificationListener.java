package com.vlocker.service;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.IBinder;
import android.os.SystemClock;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import android.util.Log;
import com.vlocker.c.a;
import com.vlocker.j.p;
import com.vlocker.msg.ab;
import com.vlocker.msg.am;
import com.vlocker.msg.an;
import com.vlocker.security.MoSecurityApplication;
import com.vlocker.theme.f.b;
import com.vlocker.ui.cover.LockerService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@SuppressLint({"Override", "NewApi"})
public class NotificationListener extends NotificationListenerService {
    public static List a = new ArrayList();
    a b;
    private am c = null;
    private Handler d = new Handler();
    private HashMap e = new HashMap();
    private BroadcastReceiver f = new d(this);

    private void a() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("com.vlocker.locker.cleanNotification");
        registerReceiver(this.f, intentFilter);
    }

    private void a(String str) {
        try {
            for (StatusBarNotification statusBarNotification : getActiveNotifications()) {
                if (str.equals(statusBarNotification.getPackageName())) {
                    cancelNotification(statusBarNotification.getPackageName(), statusBarNotification.getTag(), statusBarNotification.getId());
                }
            }
        } catch (OutOfMemoryError e) {
        }
    }

    private void b() {
        if (this.f != null) {
            unregisterReceiver(this.f);
            this.f = null;
        }
    }

    private void c() {
        try {
            Object activeNotifications = getActiveNotifications();
            if (a.size() == 0) {
                a.add(null);
            }
            a.set(0, activeNotifications);
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public IBinder onBind(Intent intent) {
        Log.e("liu---", "NotificationListener onBind");
        an.a(true);
        if ("android.service.notification.NotificationListenerService".equals(intent.getAction())) {
            com.vlocker.j.a.a().m();
            if (VERSION.SDK_INT >= 18 && a.a((Context) this).ap()) {
                com.vlocker.j.a.a().n();
            }
        }
        return super.onBind(intent);
    }

    public void onCreate() {
        Log.e("liu---", "NotificationListener onCreate");
        try {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (a.a((Context) this).O()) {
                if (elapsedRealtime < 240000) {
                    LockerService.c((Context) this);
                } else {
                    LockerService.a((Context) this);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.c = am.a();
        a();
        this.b = a.a((Context) this);
        this.b.F(false);
        super.onCreate();
    }

    public void onDestroy() {
        an.a(false);
        b();
        super.onDestroy();
    }

    public void onNotificationPosted(StatusBarNotification statusBarNotification) {
        Log.e("liu---", "onNotificationPosted sbn=" + statusBarNotification);
        if (this.b.O()) {
            c();
            if (statusBarNotification != null && this.b.bv()) {
                String packageName = statusBarNotification.getPackageName();
                this.d.post(new a(this, statusBarNotification.getNotification(), packageName));
            }
            if (statusBarNotification != null) {
                String packageName2 = statusBarNotification.getPackageName();
                String str = statusBarNotification.getPackageName() + statusBarNotification.getId();
                if (!"com.baidu.appsearch".equals(packageName2) && !"com.android.systemui".equals(packageName2) && !"com.dragon.android.pandaspace".equals(packageName2)) {
                    synchronized (this.e) {
                        if (this.e.containsKey(str)) {
                            this.d.removeCallbacks((Runnable) this.e.get(str));
                            this.e.remove(str);
                        }
                    }
                    Notification notification = statusBarNotification.getNotification();
                    int id = statusBarNotification.getId();
                    long postTime = statusBarNotification.getPostTime();
                    if (this.b.ap() && this.c.a(packageName2)) {
                        if (p.a(notification, packageName2)) {
                            Runnable bVar = new b(this, notification, packageName2, id, postTime, str);
                            this.e.put(str, bVar);
                            if ("cn.kuwo.player".equals(packageName2) || "com.ting.mp3.android".equals(packageName2)) {
                                this.d.postDelayed(bVar, 500);
                            } else {
                                this.d.post(bVar);
                            }
                        }
                    } else if (this.b.aB() && !packageName2.equals(getPackageName())) {
                        if (!this.c.a(packageName2) || !p.a(notification, packageName2)) {
                            ab.a().a(statusBarNotification.getNotification(), packageName2, null, statusBarNotification.getPostTime());
                        }
                    }
                }
            }
        }
    }

    public void onNotificationRemoved(StatusBarNotification statusBarNotification) {
        if (this.b.O()) {
            String packageName = statusBarNotification.getPackageName();
            if (!packageName.startsWith(MoSecurityApplication.a().getPackageName())) {
                if (!"com.baidu.appsearch".equals(packageName) && !"com.android.systemui".equals(packageName) && !"com.dragon.android.pandaspace".equals(packageName) && !TextUtils.isEmpty(statusBarNotification.getPackageName()) && statusBarNotification.getNotification() != null && !"com.miui.player".equals(packageName)) {
                    if (this.c.a(packageName) && p.a(statusBarNotification.getNotification(), packageName)) {
                        com.vlocker.j.a.a().a(statusBarNotification.getNotification(), packageName, statusBarNotification.getId());
                        return;
                    }
                    try {
                        StatusBarNotification[] activeNotifications = getActiveNotifications();
                        int length = activeNotifications.length;
                        int i = 0;
                        while (i < length) {
                            if (!packageName.equals(activeNotifications[i].getPackageName())) {
                                i++;
                            } else {
                                return;
                            }
                        }
                    } catch (OutOfMemoryError e) {
                    }
                    if (statusBarNotification.getPackageName().equals("com.tencent.mobileqq") && statusBarNotification.getId() == 2130838536) {
                        return;
                    }
                }
                return;
            }
            packageName = statusBarNotification.getPackageName() + statusBarNotification.getId();
            Runnable cVar = new c(this, statusBarNotification, packageName);
            synchronized (this.e) {
                if (this.e.containsKey(packageName)) {
                    this.d.removeCallbacks((Runnable) this.e.get(packageName));
                    this.e.remove(packageName);
                }
                this.e.put(packageName, cVar);
                if (b.z()) {
                    this.d.post(cVar);
                } else {
                    this.d.postDelayed(cVar, 500);
                }
            }
        }
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        return 1;
    }

    public boolean onUnbind(Intent intent) {
        if ("android.service.notification.NotificationListenerService".equals(intent.getAction())) {
            com.vlocker.j.a.a().o();
        }
        return super.onUnbind(intent);
    }
}
