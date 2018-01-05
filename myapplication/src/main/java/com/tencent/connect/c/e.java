package com.tencent.connect.c;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.open.d.d;

final class e extends Handler {
    final /* synthetic */ d a;

    e(Looper looper, d dVar) {
        this.a = dVar;
        super(looper);
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case 101:
                this.a.a(0, (String) message.obj);
                return;
            case 102:
                this.a.a(message.arg1, null);
                return;
            default:
                super.handleMessage(message);
                return;
        }
    }
}
