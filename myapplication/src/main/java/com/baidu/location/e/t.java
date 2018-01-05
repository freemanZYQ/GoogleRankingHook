package com.baidu.location.e;

import android.os.HandlerThread;

public class t {
    private static HandlerThread a = null;

    public static HandlerThread a() {
        if (a == null) {
            a = new HandlerThread("ServiceStartArguments", 10);
            a.start();
        }
        return a;
    }
}
