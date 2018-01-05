package com.vlocker.m;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;

class s extends Handler {
    final /* synthetic */ r a;

    s(r rVar) {
        this.a = rVar;
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                if (this.a.e != null && !this.a.e.isAlive()) {
                    this.a.e.start();
                    return;
                }
                return;
            case 2:
                if (this.a.b != null) {
                    this.a.b.a((String) message.obj);
                    return;
                }
                return;
            case 3:
                if (this.a.b != null) {
                    this.a.b.a();
                }
                this.a.b();
                return;
            case 4:
                if (this.a.b != null) {
                    this.a.b.a((Intent) message.obj);
                }
                this.a.b();
                return;
            default:
                return;
        }
    }
}
