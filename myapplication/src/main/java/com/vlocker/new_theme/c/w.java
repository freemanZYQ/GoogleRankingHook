package com.vlocker.new_theme.c;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

class w extends Handler {
    WeakReference a;
    final /* synthetic */ q b;

    w(q qVar, Activity activity) {
        this.b = qVar;
        this.a = new WeakReference(activity);
    }

    public void handleMessage(Message message) {
        if (((Activity) this.a.get()) != null) {
            switch (message.what) {
                case 3:
                    this.b.a((String) message.obj, 0);
                    return;
                case 277:
                    this.b.K();
                    return;
                default:
                    return;
            }
        }
    }
}
