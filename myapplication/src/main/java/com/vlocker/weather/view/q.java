package com.vlocker.weather.view;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class q extends Handler {
    final /* synthetic */ ShowGifView a;

    q(ShowGifView showGifView, Looper looper) {
        this.a = showGifView;
        super(looper);
    }

    public void handleMessage(Message message) {
        if (message.what == 0) {
            this.a.invalidate();
        } else if (message.what == 1) {
            this.a.setGifImage(this.a.o);
        }
    }
}
