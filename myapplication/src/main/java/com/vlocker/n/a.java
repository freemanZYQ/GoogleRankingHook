package com.vlocker.n;

import android.os.Handler;
import android.os.HandlerThread;

public class a extends HandlerThread {
    private static a a;
    private static Handler b;

    public a() {
        super("BackgroundThread", 10);
    }

    public static Handler a() {
        Handler handler;
        synchronized (a.class) {
            b();
            handler = b;
        }
        return handler;
    }

    private static void b() {
        if (a == null) {
            a = new a();
            a.start();
            b = new Handler(a.getLooper());
        }
    }
}
