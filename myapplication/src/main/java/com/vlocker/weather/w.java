package com.vlocker.weather;

class w implements Runnable {
    final /* synthetic */ Weather2Activity a;

    w(Weather2Activity weather2Activity) {
        this.a = weather2Activity;
    }

    public void run() {
        this.a.A = false;
        this.a.z.postDelayed(this.a.C, 1000);
    }
}
