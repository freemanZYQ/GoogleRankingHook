package com.vlocker.f;

import android.app.Dialog;
import android.os.Handler.Callback;
import android.os.Message;

class ae implements Callback {
    final /* synthetic */ Dialog a;
    final /* synthetic */ ab b;

    ae(ab abVar, Dialog dialog) {
        this.b = abVar;
        this.a = dialog;
    }

    public boolean handleMessage(Message message) {
        this.a.dismiss();
        return false;
    }
}
