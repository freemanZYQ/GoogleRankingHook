package com.vlocker.ui.view;

class f implements Runnable {
    final /* synthetic */ BatteryChargeView a;

    f(BatteryChargeView batteryChargeView) {
        this.a = batteryChargeView;
    }

    public void run() {
        int height = this.a.d.getHeight();
        if (this.a.e.getHeight() != height && height != 0) {
            this.a.e.getLayoutParams().height = height;
        }
    }
}
