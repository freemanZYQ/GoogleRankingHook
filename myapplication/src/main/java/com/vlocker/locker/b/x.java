package com.vlocker.locker.b;

import android.os.Handler;
import android.os.Message;

class x extends Handler {
    final /* synthetic */ p a;

    private x(p pVar) {
        this.a = pVar;
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                this.a.K();
                return;
            default:
                return;
        }
    }
}
