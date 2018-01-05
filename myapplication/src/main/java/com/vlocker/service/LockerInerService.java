package com.vlocker.service;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.vlocker.locker.R;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class LockerInerService extends Service {
    public static Notification a(Context context, int i) {
        try {
            Class cls = Class.forName("android.app.Notification$Builder");
            Constructor declaredConstructor = cls.getDeclaredConstructor(new Class[]{Context.class});
            declaredConstructor.setAccessible(true);
            Object newInstance = declaredConstructor.newInstance(new Object[]{context});
            Method declaredMethod = cls.getDeclaredMethod("setSmallIcon", new Class[]{Integer.TYPE});
            cls.getDeclaredMethod("setTicker", new Class[]{CharSequence.class});
            Method declaredMethod2 = cls.getDeclaredMethod("setAutoCancel", new Class[]{Boolean.TYPE});
            Method declaredMethod3 = cls.getDeclaredMethod("getNotification", new Class[0]);
            Method declaredMethod4 = cls.getDeclaredMethod("setPriority", new Class[]{Integer.TYPE});
            Method declaredMethod5 = cls.getDeclaredMethod("setWhen", new Class[]{Long.TYPE});
            declaredMethod.invoke(newInstance, new Object[]{Integer.valueOf(i)});
            declaredMethod2.invoke(newInstance, new Object[]{Boolean.valueOf(true)});
            declaredMethod4.invoke(newInstance, new Object[]{Integer.valueOf(-2)});
            declaredMethod5.invoke(newInstance, new Object[]{Integer.valueOf(0)});
            Notification notification = (Notification) declaredMethod3.invoke(newInstance, new Object[0]);
            notification.flags = 16;
            return notification;
        } catch (Exception e) {
            return null;
        }
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        startForeground(1220, a(this, R.drawable.l_notification_small_icon));
        stopSelf();
        return super.onStartCommand(intent, i, i2);
    }
}
