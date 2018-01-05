package com.vlocker.h;

import android.content.Context;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;

public abstract class a {
    private WakeLock a = null;

    protected void a(Context context) {
        try {
            if (this.a == null) {
                this.a = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "cpu_lck");
            }
            if (!this.a.isHeld()) {
                this.a.acquire();
            }
        } catch (Exception e) {
        }
    }

    public abstract boolean a();

    public abstract boolean a(b bVar);

    public abstract boolean b();

    protected void c() {
        try {
            if (this.a != null && this.a.isHeld()) {
                this.a.release();
            }
        } catch (Exception e) {
        }
    }
}
