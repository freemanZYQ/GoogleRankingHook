package com.vlocker.weather.view;

class h implements Runnable {
    final /* synthetic */ OverScrollView a;

    h(OverScrollView overScrollView) {
        this.a = overScrollView;
    }

    public void run() {
        if (this.a.A != null) {
            this.a.A.u();
        }
    }
}
