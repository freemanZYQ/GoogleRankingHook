package com.vlocker.l;

import android.net.wifi.WifiManager;

class ao implements Runnable {
    final /* synthetic */ WifiManager a;
    final /* synthetic */ an b;

    ao(an anVar, WifiManager wifiManager) {
        this.b = anVar;
        this.a = wifiManager;
    }

    public void run() {
        this.a.setWifiEnabled(this.b.c);
    }
}
