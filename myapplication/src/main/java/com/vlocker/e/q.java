package com.vlocker.e;

import android.os.Handler;
import android.os.Message;

class q extends Handler {
    final /* synthetic */ p a;

    q(p pVar) {
        this.a = pVar;
    }

    private void a(Message message) {
        switch (message.what) {
            case 272:
            case 274:
                p.c = false;
                this.a.a.cancel(this.a.g.n());
                return;
            case 1280:
                if (message.getData().getBoolean("isFinish")) {
                    this.a.a.cancel(this.a.g.n());
                    p.c = false;
                    this.a.a();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void handleMessage(Message message) {
        a(message);
        super.handleMessage(message);
    }
}
