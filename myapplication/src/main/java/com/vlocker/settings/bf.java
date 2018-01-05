package com.vlocker.settings;

import com.vlocker.ui.cover.l;

class bf implements Runnable {
    final /* synthetic */ LockerSettingsActivity a;

    bf(LockerSettingsActivity lockerSettingsActivity) {
        this.a = lockerSettingsActivity;
    }

    public void run() {
        long f = this.a.o - l.a < 30000 ? 1 + (30000 - (this.a.o - l.a)) : 30001;
        if (!this.a.p) {
            l.a = this.a.o;
        }
        this.a.i = new bg(this, f, 1000).start();
    }
}
