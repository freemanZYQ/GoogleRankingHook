package com.vlocker.ui.view;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class l implements AnimationListener {
    final /* synthetic */ BatteryProgressView a;

    l(BatteryProgressView batteryProgressView) {
        this.a = batteryProgressView;
    }

    public void onAnimationEnd(Animation animation) {
        if (this.a.j) {
            this.a.a();
        }
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }
}
