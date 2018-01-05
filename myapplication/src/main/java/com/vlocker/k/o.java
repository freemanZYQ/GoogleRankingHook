package com.vlocker.k;

import android.content.Intent;

class o implements Runnable {
    final /* synthetic */ n a;

    o(n nVar) {
        this.a = nVar;
    }

    public void run() {
        this.a.a.b();
        if (this.a.a.g) {
            this.a.a.f.sendBroadcast(new Intent("action_stop_check"));
        }
    }
}
