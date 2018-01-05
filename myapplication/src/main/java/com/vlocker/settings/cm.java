package com.vlocker.settings;

import com.vlocker.f.j;
import com.vlocker.ui.cover.k;

class cm implements Runnable {
    final /* synthetic */ j a;
    final /* synthetic */ SettingsActivity b;

    cm(SettingsActivity settingsActivity, j jVar) {
        this.b = settingsActivity;
        this.a = jVar;
    }

    public void run() {
        if (!this.b.d.b()) {
            if (!this.b.d.bz() && !this.b.d.bI() && this.b.d.bS()) {
                this.b.h();
                this.b.d.a(true);
            } else if (!this.b.d.cZ() && this.a != null && !this.b.d.cg()) {
                this.a.b(this.b);
                this.b.d.aP(true);
                this.b.d.a(true);
            } else if (k.a(this.b)) {
                this.b.c();
                this.b.d.a(true);
            }
        }
    }
}
