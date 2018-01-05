package com.vlocker.f;

import android.os.Handler.Callback;
import android.os.Message;

class aq implements Callback {
    final /* synthetic */ ao a;

    aq(ao aoVar) {
        this.a = aoVar;
    }

    public boolean handleMessage(Message message) {
        this.a.a.dismiss();
        return false;
    }
}
