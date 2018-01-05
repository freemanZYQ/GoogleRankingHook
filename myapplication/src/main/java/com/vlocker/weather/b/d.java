package com.vlocker.weather.b;

import android.util.Log;

class d implements Runnable {
    final /* synthetic */ c a;

    d(c cVar) {
        this.a = cVar;
    }

    public void run() {
        Log.i("cai========", "baidu location");
        this.a.c();
        this.a.f.start();
        this.a.f.requestLocation();
    }
}
