package com.baidu.location.e;

import android.location.Location;

class l implements Runnable {
    final /* synthetic */ Location a;
    final /* synthetic */ k b;

    l(k kVar, Location location) {
        this.b = kVar;
        this.a = location;
    }

    public void run() {
        this.b.b(this.a);
    }
}
