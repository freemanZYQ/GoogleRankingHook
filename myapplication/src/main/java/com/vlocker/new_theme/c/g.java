package com.vlocker.new_theme.c;

import android.os.Message;
import com.vlocker.theme.f.e;

class g implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ f b;

    g(f fVar, int i) {
        this.b = fVar;
        this.a = i;
    }

    public void run() {
        this.b.aa = e.a(this.b.c(), this.a);
        Message message = new Message();
        if (this.b.aa == null || this.b.aa.size() <= 0) {
            message.what = 264;
            this.b.ag.sendMessage(message);
            return;
        }
        message.what = 265;
        this.b.ag.sendMessage(message);
    }
}
