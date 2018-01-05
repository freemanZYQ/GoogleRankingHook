package com.vlocker.locker.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class ah extends BroadcastReceiver {
    final /* synthetic */ b a;

    private ah(b bVar) {
        this.a = bVar;
    }

    public void onReceive(Context context, Intent intent) {
        if ("action_battery_tomini".equals(intent.getAction())) {
            this.a.b(true);
        } else if ("action_reset_unlock".equals(intent.getAction())) {
            this.a.H();
        }
    }
}
