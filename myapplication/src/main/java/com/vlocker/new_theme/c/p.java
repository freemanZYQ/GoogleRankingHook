package com.vlocker.new_theme.c;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

class p extends Handler {
    WeakReference a;
    final /* synthetic */ j b;

    p(j jVar, Activity activity) {
        this.b = jVar;
        this.a = new WeakReference(activity);
    }

    public void handleMessage(Message message) {
        if (((Activity) this.a.get()) != null) {
            switch (message.what) {
                case 275:
                    this.b.K();
                    return;
                default:
                    return;
            }
        }
    }
}
