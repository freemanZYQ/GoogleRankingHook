package com.vlocker.ui.widget.view;

import com.vlocker.ui.cover.f;

class i implements Runnable {
    final /* synthetic */ LockNumberCoverView a;

    i(LockNumberCoverView lockNumberCoverView) {
        this.a = lockNumberCoverView;
    }

    public void run() {
        this.a.i();
        long j = (!LockNumberCoverView.a || this.a.M <= 0 || this.a.N <= 0) ? (LockNumberCoverView.a || this.a.I - f.d >= 30000) ? (f.g && this.a.I - f.d < 300000 && LockNumberCoverView.a) ? 120001 : 30001 : 1 + (30000 - (this.a.I - f.d)) : this.a.N - (System.currentTimeMillis() - this.a.M);
        if (LockNumberCoverView.a && this.a.N == 0) {
            this.a.N = j;
            f.d = this.a.I;
        } else if (!f.i) {
            f.d = this.a.I;
        }
        this.a.h = new j(this, j, 1000).start();
    }
}
