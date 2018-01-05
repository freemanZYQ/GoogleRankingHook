package com.vlocker.weather.b;

import android.util.Log;
import com.baidu.location.BDLocation;
import com.vlocker.c.a;
import com.vlocker.weather.e.j;

class g extends Thread {
    final /* synthetic */ BDLocation a;
    final /* synthetic */ int b;
    final /* synthetic */ c c;

    g(c cVar, BDLocation bDLocation, int i) {
        this.c = cVar;
        this.a = bDLocation;
        this.b = i;
    }

    public void run() {
        try {
            if (j.a(this.a, this.c.e)) {
                a.a(this.c.e).g(0);
                j.e(this.c.e);
                a.a(this.c.e).l(false);
                Log.e("liu---", "asyncLocateCity nFrom=" + this.b);
            }
        } catch (Exception e) {
        }
    }
}
