package com.tencent.open.d;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.open.a.j;

class b extends Handler {
    final /* synthetic */ a a;

    b(a aVar, Looper looper) {
        this.a = aVar;
        super(looper);
    }

    public void handleMessage(Message message) {
        j.a("AsynLoadImg", "handleMessage:" + message.arg1);
        if (message.arg1 == 0) {
            this.a.b.a(message.arg1, (String) message.obj);
        } else {
            this.a.b.a(message.arg1, null);
        }
    }
}
