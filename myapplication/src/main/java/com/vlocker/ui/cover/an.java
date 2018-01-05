package com.vlocker.ui.cover;

import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.vlocker.theme.f.b;

class an implements Runnable {
    final /* synthetic */ am a;

    an(am amVar) {
        this.a = amVar;
    }

    public void run() {
        try {
            Thread.sleep(1500);
            PowerManager powerManager = (PowerManager) this.a.a.getSystemService("power");
            if (!powerManager.isScreenOn()) {
                WakeLock newWakeLock = powerManager.newWakeLock(268435466, "MyPower");
                if (b.a()) {
                    newWakeLock.acquire(10000);
                } else {
                    newWakeLock.acquire(1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
