package com.vlocker.ui.view;

import com.vlocker.locker.R;

class e implements Runnable {
    final /* synthetic */ BatteryChargeView a;

    e(BatteryChargeView batteryChargeView) {
        this.a = batteryChargeView;
    }

    public void run() {
        this.a.a(this.a.I, false);
        this.a.a(this.a.findViewById(R.id.iv_battery_slow_des), false);
        this.a.a(this.a.findViewById(R.id.iv_battery_normal_des), false);
        this.a.a(this.a.findViewById(R.id.iv_battery_fast_des), false);
        this.a.a(this.a.B, true);
    }
}
