package com.vlocker.l;

import android.app.KeyguardManager;
import android.app.KeyguardManager.KeyguardLock;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.vlocker.ui.cover.k;

public class aj {
    Handler a = new Handler(Looper.getMainLooper());
    String b;
    Context c;
    KeyguardLock d;
    Runnable e = new ak(this);

    public aj(Context context, String str) {
        this.b = str;
        this.c = context;
    }

    public void a() {
        if (k.b(this.c)) {
            this.d = ((KeyguardManager) this.c.getSystemService("keyguard")).newKeyguardLock("" + System.currentTimeMillis());
            this.d.disableKeyguard();
            this.a.postDelayed(this.e, 200);
        }
    }
}
