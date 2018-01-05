package com.vlocker.weather.model;

import com.vlocker.b.i;

class e implements Runnable {
    final /* synthetic */ c a;

    e(c cVar) {
        this.a = cVar;
    }

    public void run() {
        this.a.b.isfreshsuccess = true;
        i.e = i.c[1];
        this.a.a.a();
        this.a.b.readSavedWeatherDataOfToday(false);
    }
}
