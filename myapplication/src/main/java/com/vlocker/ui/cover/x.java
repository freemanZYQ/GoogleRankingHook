package com.vlocker.ui.cover;

import com.vlocker.weather.b.c;

class x implements Runnable {
    final /* synthetic */ LockerService a;

    x(LockerService lockerService) {
        this.a = lockerService;
    }

    public void run() {
        c.b(this.a.getApplicationContext());
    }
}
