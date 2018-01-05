package com.vlocker.weather.b;

import android.util.Log;

class f implements Runnable {
    final /* synthetic */ c a;

    f(c cVar) {
        this.a = cVar;
    }

    public void run() {
        Log.e("liu---", "finishLocate mbRunningUpdate=false");
        if (this.a.f != null && this.a.f.isStarted()) {
            this.a.f.stop();
        }
        this.a.c.removeCallbacks(this.a.d);
        this.a.d(this.a.e);
    }
}
