package com.vlocker.setting.a.a;

import android.os.Handler.Callback;
import android.os.Message;

class d implements Callback {
    final /* synthetic */ c a;

    d(c cVar) {
        this.a = cVar;
    }

    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 241:
                if (this.a.b && this.a.d < 1.0f) {
                    this.a.i.sendEmptyMessageDelayed(241, (long) this.a.resetProgress());
                    break;
                }
        }
        return true;
    }
}
