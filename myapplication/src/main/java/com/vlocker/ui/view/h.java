package com.vlocker.ui.view;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class h extends BroadcastReceiver {
    final /* synthetic */ BatteryChargeView a;

    h(BatteryChargeView batteryChargeView) {
        this.a = batteryChargeView;
    }

    public void onReceive(Context context, Intent intent) {
        if ("battery_action_full_send".equals(intent.getAction())) {
            if (!this.a.N && this.a.G.bX()) {
                this.a.N = true;
                this.a.p();
            }
        } else if ("battery_action_full_cancel".equals(intent.getAction())) {
            this.a.N = false;
        }
    }
}
