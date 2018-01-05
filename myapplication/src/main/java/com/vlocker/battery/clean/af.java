package com.vlocker.battery.clean;

import android.view.animation.LinearInterpolator;

class af implements t {
    final /* synthetic */ y a;

    af(y yVar) {
        this.a = yVar;
    }

    public void a() {
        this.a.F = false;
        this.a.t();
    }

    public void b() {
        this.a.z.animate().alpha(1.0f).setDuration(100).setInterpolator(new LinearInterpolator()).setListener(new ag(this)).start();
    }
}
