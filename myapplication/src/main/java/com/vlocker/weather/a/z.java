package com.vlocker.weather.a;

import android.os.Handler;
import android.os.Message;

class z extends Handler {
    final /* synthetic */ y a;

    z(y yVar) {
        this.a = yVar;
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == 1010) {
            this.a.k();
        }
    }
}
