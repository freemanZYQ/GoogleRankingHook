package com.vlocker.setting;

import android.os.Handler.Callback;
import android.os.Message;

class t implements Callback {
    final /* synthetic */ s a;

    t(s sVar) {
        this.a = sVar;
    }

    public boolean handleMessage(Message message) {
        return this.a.a(message);
    }
}
