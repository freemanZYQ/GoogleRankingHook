package com.vlocker.e;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

class c extends BroadcastReceiver {
    final /* synthetic */ a a;

    private c(a aVar) {
        this.a = aVar;
    }

    public void onReceive(Context context, Intent intent) {
        Bundle extras = intent.getExtras();
        try {
            if ("com.vlocker.service.stopupdate".equals(intent.getAction()) && extras.getInt("noticeId") == this.a.j.n()) {
                a.c = false;
                this.a.l.a();
                this.a.a.cancel(this.a.j.n());
            }
        } catch (Exception e) {
        }
    }
}
