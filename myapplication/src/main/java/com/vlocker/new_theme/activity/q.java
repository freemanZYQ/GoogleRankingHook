package com.vlocker.new_theme.activity;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

class q extends Handler {
    WeakReference a;
    final /* synthetic */ SearchActivity b;

    q(SearchActivity searchActivity, Activity activity) {
        this.b = searchActivity;
        this.a = new WeakReference(activity);
    }

    public void handleMessage(Message message) {
        if (((Activity) this.a.get()) != null) {
            switch (message.what) {
                case 281:
                    this.b.e = true;
                    try {
                        this.b.a();
                        return;
                    } catch (OutOfMemoryError e) {
                        e.printStackTrace();
                        return;
                    }
                default:
                    return;
            }
        }
    }
}
