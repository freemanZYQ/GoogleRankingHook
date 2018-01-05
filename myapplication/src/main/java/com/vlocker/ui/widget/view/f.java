package com.vlocker.ui.widget.view;

class f implements Runnable {
    final /* synthetic */ LockNumberCoverView a;

    f(LockNumberCoverView lockNumberCoverView) {
        this.a = lockNumberCoverView;
    }

    public void run() {
        LockNumberCoverView.a = true;
        this.a.d();
        this.a.v();
        this.a.c(0);
        this.a.j.a();
        com.vlocker.ui.cover.f.g = false;
        com.vlocker.ui.cover.f.h = 5;
    }
}
