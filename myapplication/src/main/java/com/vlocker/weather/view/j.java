package com.vlocker.weather.view;

import android.os.Handler;
import java.util.Timer;

class j {
    final /* synthetic */ OverScrollView a;
    private Handler b;
    private Timer c = new Timer();
    private k d;
    private int e;

    public j(OverScrollView overScrollView, Handler handler, int i) {
        this.a = overScrollView;
        this.b = handler;
        this.e = i;
    }

    public void a() {
        if (this.d != null) {
            this.d.cancel();
            this.d = null;
        }
    }

    public void a(long j) {
        if (this.d != null) {
            this.d.cancel();
            this.d = null;
        }
        this.d = new k(this, this.b);
        this.c.schedule(this.d, 0, j);
    }
}
