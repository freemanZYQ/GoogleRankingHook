package com.vlocker.weather;

class x implements Runnable {
    final /* synthetic */ Weather2Activity a;

    x(Weather2Activity weather2Activity) {
        this.a = weather2Activity;
    }

    public void run() {
        if (!this.a.A) {
            if (this.a.j()) {
                this.a.z.postDelayed(this.a.C, 10);
                return;
            }
            this.a.A = false;
            this.a.o();
            this.a.finish();
        }
    }
}
