package com.vlocker.battery.saver;

import android.os.Handler;
import android.os.Message;
import com.vlocker.msg.ak;
import com.vlocker.msg.p;

class e extends Handler {
    final /* synthetic */ b a;

    e(b bVar) {
        this.a = bVar;
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        p.a().a((ak) message.obj);
    }
}
