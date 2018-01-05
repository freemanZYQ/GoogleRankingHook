package com.vlocker.security;

import android.os.Build.VERSION;
import android.text.TextUtils;
import java.lang.reflect.Field;
import java.util.concurrent.TimeoutException;

public class j {
    public static boolean a(Throwable th) {
        return th == null ? false : th instanceof OutOfMemoryError ? true : (th instanceof SecurityException) && th.getMessage() != null && th.getMessage().contains("Not allowed to start service Intent") && th.getMessage().contains("Service process is bad");
    }

    public static boolean b(Throwable th) {
        return (th instanceof TimeoutException) && VERSION.SDK_INT >= 17 && !TextUtils.isEmpty(th.getMessage()) && th.getMessage().contains("timed out after 10 seconds");
    }

    public static String c(Throwable th) {
        try {
            Class cls = Class.forName("java.lang.Daemons$FinalizerDaemon");
            Field declaredField = cls.getDeclaredField("INSTANCE");
            Field declaredField2 = cls.getDeclaredField("finalizingObject");
            Field declaredField3 = cls.getDeclaredField("finalizingStartedNanos");
            declaredField.setAccessible(true);
            declaredField2.setAccessible(true);
            declaredField3.setAccessible(true);
            for (int i = 0; i < 10; i++) {
                Object obj = declaredField.get(null);
                Object obj2 = declaredField2.get(obj);
                long j = declaredField3.getLong(obj);
                long nanoTime = System.nanoTime();
                long j2 = nanoTime - j;
                if (obj2 == null) {
                    return "For times:" + i + ", Current finalizingObject is null, " + "Pre_finalizingStartedNanos: " + j + ", curent nanos: " + nanoTime + ", sub nanos:" + j2;
                }
                if (i == 9) {
                    return "For times:" + i + ", Current finalizingObject is " + obj2.toString() + ", " + "Pre_finalizingStartedNanos: " + j + ", curent nanos: " + nanoTime + ", sub nanos:" + j2;
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
            }
            return null;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }
}
