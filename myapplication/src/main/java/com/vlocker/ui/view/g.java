package com.vlocker.ui.view;

import com.vlocker.locker.R;
import com.vlocker.msg.ar;

class g implements ar {
    final /* synthetic */ BatteryChargeView a;

    g(BatteryChargeView batteryChargeView) {
        this.a = batteryChargeView;
    }

    public void a() {
        if (this.a.d != null && !this.a.g) {
            this.a.g = true;
            this.a.d.setBackgroundResource(R.drawable.card_delete_bg);
        }
    }

    public void b() {
        BatteryChargeView.b = false;
    }

    public void c() {
        BatteryChargeView.b = false;
        if (this.a.d != null) {
            this.a.g = false;
            this.a.d.setBackgroundDrawable(null);
        }
    }
}
