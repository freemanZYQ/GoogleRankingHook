package com.vlocker.weather.view;

import android.os.Message;

class t implements Runnable {
    final /* synthetic */ ShowGifView a;

    t(ShowGifView showGifView) {
        this.a = showGifView;
    }

    public void run() {
        try {
            this.a.o = this.a.c(this.a.p);
            if (this.a.o != null) {
                Message obtainMessage = this.a.r.obtainMessage();
                obtainMessage.what = 1;
                this.a.r.sendMessage(obtainMessage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
