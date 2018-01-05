package com.vlocker.k;

import com.vlocker.n.a;

class v implements Runnable {
    final /* synthetic */ p a;

    v(p pVar) {
        this.a = pVar;
    }

    public void run() {
        if (System.currentTimeMillis() - this.a.m <= 30000 && this.a.d()) {
            a.a().postDelayed(this.a.n, 100);
        }
    }
}
