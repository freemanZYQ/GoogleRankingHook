package com.vlocker.setting.common.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class j extends BroadcastReceiver {
    final /* synthetic */ h a;

    j(h hVar) {
        this.a = hVar;
    }

    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.SCREEN_OFF")) {
            ((i) this.a.b).j();
        }
    }
}
