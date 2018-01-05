package com.vlocker.j;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.vlocker.ui.cover.LockerService;

class g extends BroadcastReceiver {
    final /* synthetic */ a a;

    g(a aVar) {
        this.a = aVar;
    }

    public void onReceive(Context context, Intent intent) {
        if (this.a.l && this.a.q.ap() && LockerService.a().c() && !TextUtils.isEmpty(this.a.o)) {
            String action = intent.getAction();
            if ("android.intent.action.SCREEN_ON".equals(action)) {
                this.a.i();
            } else if ("android.intent.action.SCREEN_OFF".equals(action)) {
                this.a.v();
            }
        }
    }
}
