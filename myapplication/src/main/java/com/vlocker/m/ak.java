package com.vlocker.m;

import android.content.Context;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.vlocker.theme.f.b;
import com.vlocker.ui.cover.LockerService;

public class ak {
    public static void a(Context context) {
        WakeLock newWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(268435466, "MyPower");
        if (b.a()) {
            newWakeLock.acquire(10000);
        } else {
            newWakeLock.acquire(1);
        }
        LockerService.f = false;
    }

    public static boolean b(Context context) {
        try {
            return ((PowerManager) context.getSystemService("power")).isScreenOn();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
