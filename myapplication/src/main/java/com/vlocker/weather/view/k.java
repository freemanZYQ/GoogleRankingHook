package com.vlocker.weather.view;

import android.os.Handler;
import java.util.TimerTask;

class k extends TimerTask {
    final /* synthetic */ j a;
    private Handler b;

    public k(j jVar, Handler handler) {
        this.a = jVar;
        this.b = handler;
    }

    public void run() {
        this.b.obtainMessage().sendToTarget();
    }
}
