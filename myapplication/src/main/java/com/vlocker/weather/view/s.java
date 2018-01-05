package com.vlocker.weather.view;

import android.os.Message;
import android.os.SystemClock;
import com.vlocker.weather.e.c;

class s extends Thread {
    final /* synthetic */ ShowGifView a;

    private s(ShowGifView showGifView) {
        this.a = showGifView;
    }

    public void run() {
        try {
            if (this.a.a != null) {
                while (this.a.c) {
                    if (this.a.e) {
                        SystemClock.sleep(10);
                    } else {
                        c d = this.a.a.d();
                        if (d == null) {
                            SystemClock.sleep(50);
                        } else {
                            this.a.b = d.a;
                            long j = (long) d.b;
                            if (this.a.r != null) {
                                Message obtainMessage = this.a.r.obtainMessage();
                                obtainMessage.what = 0;
                                this.a.r.sendMessage(obtainMessage);
                                SystemClock.sleep(j);
                            } else {
                                return;
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
