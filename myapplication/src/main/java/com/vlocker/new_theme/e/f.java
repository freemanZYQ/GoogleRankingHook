package com.vlocker.new_theme.e;

import android.os.Handler;
import android.os.Message;

class f extends Handler {
    final /* synthetic */ e a;

    f(e eVar) {
        this.a = eVar;
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                if (this.a.e != null) {
                    break;
                }
                break;
        }
        super.handleMessage(message);
    }
}
