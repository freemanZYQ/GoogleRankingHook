package com.vlocker.f;

import android.os.Handler.Callback;
import android.os.Message;

class z implements Callback {
    final /* synthetic */ x a;

    z(x xVar) {
        this.a = xVar;
    }

    public boolean handleMessage(Message message) {
        this.a.b.dismiss();
        return true;
    }
}
