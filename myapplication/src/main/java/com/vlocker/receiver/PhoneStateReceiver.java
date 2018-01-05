package com.vlocker.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class PhoneStateReceiver extends BroadcastReceiver {
    private a a;

    public void a(a aVar) {
        this.a = aVar;
    }

    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            if ((action.equals("android.intent.action.PHONE_STATE") || !action.equals("android.intent.action.NEW_OUTGOING_CALL")) && this.a != null) {
                this.a.a();
            }
        }
    }
}
