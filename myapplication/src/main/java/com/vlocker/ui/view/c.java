package com.vlocker.ui.view;

import android.view.animation.AccelerateDecelerateInterpolator;

class c implements Runnable {
    final /* synthetic */ BatteryChargeView a;

    c(BatteryChargeView batteryChargeView) {
        this.a = batteryChargeView;
    }

    public void run() {
        this.a.B.animate().alpha(1.0f).setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(300).start();
        this.a.C.animate().alpha(1.0f).setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(300).start();
        this.a.D.animate().alpha(1.0f).setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(300).start();
    }
}
