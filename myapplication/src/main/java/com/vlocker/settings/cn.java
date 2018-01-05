package com.vlocker.settings;

class cn implements Runnable {
    final /* synthetic */ SettingsActivity a;

    cn(SettingsActivity settingsActivity) {
        this.a = settingsActivity;
    }

    public void run() {
        this.a.m = 500;
        this.a.i.a();
    }
}
