package com.vlocker.weather;

import com.vlocker.settings.CitySelectActivity;

class i implements Runnable {
    final /* synthetic */ h a;

    i(h hVar) {
        this.a = hVar;
    }

    public void run() {
        CitySelectActivity.b(this.a.a.h, true);
    }
}
