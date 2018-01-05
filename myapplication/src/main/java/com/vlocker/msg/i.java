package com.vlocker.msg;

import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.vlocker.theme.f.b;

class i implements Runnable {
    final /* synthetic */ h a;

    i(h hVar) {
        this.a = hVar;
    }

    public void run() {
        WakeLock newWakeLock = ((PowerManager) this.a.a.b.getSystemService("power")).newWakeLock(268435462, "MyPower");
        if (b.a()) {
            newWakeLock.acquire(10000);
        } else {
            newWakeLock.acquire(1);
        }
    }
}
