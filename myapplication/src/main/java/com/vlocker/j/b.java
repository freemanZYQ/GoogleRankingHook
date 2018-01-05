package com.vlocker.j;

import android.os.Handler;
import android.os.Message;

class b extends Handler {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                if (!a.a) {
                    a.a = true;
                    this.a.j();
                    return;
                }
                return;
            case 2:
                this.a.h();
                return;
            case 3:
                this.a.s();
                return;
            case 4:
                this.a.t();
                return;
            case 5:
                this.a.x();
                return;
            default:
                return;
        }
    }
}
