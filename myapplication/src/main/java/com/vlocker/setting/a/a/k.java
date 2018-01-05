package com.vlocker.setting.a.a;

import android.os.Handler.Callback;
import android.os.Message;

class k implements Callback {
    final /* synthetic */ j a;

    k(j jVar) {
        this.a = jVar;
    }

    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 241:
                if (this.a.a && this.a.c < 1.0f) {
                    this.a.h.sendEmptyMessageDelayed(241, (long) this.a.resetProgress());
                    break;
                }
        }
        return true;
    }
}
