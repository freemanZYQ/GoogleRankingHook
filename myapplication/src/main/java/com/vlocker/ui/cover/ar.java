package com.vlocker.ui.cover;

import android.os.Handler;
import android.os.Message;

class ar extends Handler {
    final /* synthetic */ aq a;

    ar(aq aqVar) {
        this.a = aqVar;
    }

    public void handleMessage(Message message) {
        if (this.a.b != null && this.a.a) {
            if (this.a.b.getMode() == 3 || this.a.b.getMode() == 2) {
                LockerService.a().a(10);
            }
        }
    }
}
