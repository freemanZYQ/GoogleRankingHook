package com.vlocker.m;

import android.os.Handler;
import android.os.Looper;

class v extends Thread {
    final /* synthetic */ r a;
    private Handler b;

    private v(r rVar) {
        this.a = rVar;
    }

    public void a() {
        if (this.b != null) {
            this.b.removeMessages(0);
            this.b = null;
        }
    }

    public void run() {
        Looper.prepare();
        this.b = new w(this);
        this.b.sendEmptyMessage(0);
        Looper.loop();
    }
}
