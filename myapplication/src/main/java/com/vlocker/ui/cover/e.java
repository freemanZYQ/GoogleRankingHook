package com.vlocker.ui.cover;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.Date;

class e extends BroadcastReceiver {
    final /* synthetic */ a a;

    e(a aVar) {
        this.a = aVar;
    }

    public void onReceive(Context context, Intent intent) {
        if ("com.android.alarmclock.ALARM_ALERT".equals(intent.getAction())) {
            this.a.i = true;
            this.a.j = new Date().getTime();
        } else if ("android.intent.action.ALARM_CHANGED".equals(intent.getAction()) && new Date().getTime() - this.a.j > 300) {
            this.a.i = false;
        }
    }
}
