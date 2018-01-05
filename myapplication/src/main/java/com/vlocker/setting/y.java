package com.vlocker.setting;

import android.os.Handler.Callback;
import android.os.Message;

class y implements Callback {
    final /* synthetic */ StartGuideActivity a;

    y(StartGuideActivity startGuideActivity) {
        this.a = startGuideActivity;
    }

    public boolean handleMessage(Message message) {
        if (message.what == 0) {
            this.a.a();
        }
        return false;
    }
}
