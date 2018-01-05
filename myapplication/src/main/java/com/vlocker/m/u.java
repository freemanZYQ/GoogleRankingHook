package com.vlocker.m;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Message;

class u extends BroadcastReceiver {
    final /* synthetic */ r a;

    private u(r rVar) {
        this.a = rVar;
    }

    public void onReceive(Context context, Intent intent) {
        if (intent != null && "action_stop_check".equals(intent.getAction()) && this.a.e != null) {
            this.a.e.a();
            this.a.e = null;
            Message message = new Message();
            message.what = 4;
            message.obj = intent;
            this.a.d.sendMessage(message);
        }
    }
}
