package com.vlocker.settings;

import android.os.Handler;
import android.os.Message;
import com.vlocker.model.g;

class bt extends Handler {
    final /* synthetic */ NotifyLightAppsSelectActivity a;

    bt(NotifyLightAppsSelectActivity notifyLightAppsSelectActivity) {
        this.a = notifyLightAppsSelectActivity;
    }

    public void handleMessage(Message message) {
        if (message.what == 1) {
            this.a.c.setVisibility(8);
            this.a.b.setVisibility(8);
            this.a.a.setVisibility(0);
            this.a.e = new g(this.a, this.a.f, true);
            this.a.e.a(false);
            this.a.a.setAdapter(this.a.e);
            if (this.a.e.b() != 0) {
                this.a.a.requestFocus();
                this.a.a.setSelection(0);
            }
            this.a.c();
            this.a.h.setOnClickListener(new bu(this));
            this.a.i.setOnClickListener(new bv(this));
        }
        super.handleMessage(message);
    }
}
