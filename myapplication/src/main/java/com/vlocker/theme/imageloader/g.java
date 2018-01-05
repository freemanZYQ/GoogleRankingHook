package com.vlocker.theme.imageloader;

import android.os.Handler;
import android.os.Message;

class g extends Handler {
    private g() {
    }

    public void handleMessage(Message message) {
        f fVar = (f) message.obj;
        switch (message.what) {
            case 1:
                fVar.a.e(fVar.b[0]);
                return;
            case 2:
                fVar.a.b(fVar.b);
                return;
            default:
                return;
        }
    }
}
