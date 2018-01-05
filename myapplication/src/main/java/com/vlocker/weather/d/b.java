package com.vlocker.weather.d;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

class b extends Handler {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        switch (message.what) {
            case 1:
                Log.e("liu---", "request success");
                String str = (String) message.obj;
                this.a.a(str);
                this.a.e.a(str);
                return;
            case 2:
                this.a.e.h();
                return;
            default:
                return;
        }
    }
}
