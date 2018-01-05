package com.vlocker.ui.view;

import android.view.animation.AccelerateDecelerateInterpolator;

class j implements Runnable {
    final /* synthetic */ BatteryChargeView a;

    j(BatteryChargeView batteryChargeView) {
        this.a = batteryChargeView;
    }

    public void run() {
        this.a.B.animate().alpha(1.0f).setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(300).start();
        this.a.E.animate().alpha(1.0f).setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(300).start();
    }
}
