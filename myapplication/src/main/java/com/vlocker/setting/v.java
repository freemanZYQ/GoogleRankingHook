package com.vlocker.setting;

import android.os.Message;

class v implements Runnable {
    final /* synthetic */ Message a;
    final /* synthetic */ s b;

    v(s sVar, Message message) {
        this.b = sVar;
        this.a = message;
    }

    public void run() {
        this.b.n.sendMessage(this.a);
    }
}
