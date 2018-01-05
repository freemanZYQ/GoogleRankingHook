package com.vlocker.settings;

import com.vlocker.b.j;

class cj extends Thread {
    final /* synthetic */ SettingsActivity a;

    cj(SettingsActivity settingsActivity) {
        this.a = settingsActivity;
    }

    public void run() {
        j.a(this.a, j.a(8), "active");
    }
}
