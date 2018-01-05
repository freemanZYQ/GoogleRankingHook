package com.b.c;

import android.os.Handler;
import android.os.Message;

class d extends Handler {
    final /* synthetic */ c a;

    d(c cVar) {
        this.a = cVar;
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == 1360) {
            this.a.a();
            this.a.c.removeMessages(1360);
        }
    }
}
