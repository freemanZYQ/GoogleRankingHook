package com.vlocker.new_theme.e;

import android.os.Handler;
import android.os.Message;

class c extends Handler {
    final /* synthetic */ b a;

    c(b bVar) {
        this.a = bVar;
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
