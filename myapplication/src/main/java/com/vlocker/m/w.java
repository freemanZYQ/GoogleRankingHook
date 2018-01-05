package com.vlocker.m;

import android.os.Handler;
import android.os.Message;
import com.qq.e.comm.constants.ErrorCode.InitError;
import com.vlocker.ui.cover.g;

class w extends Handler {
    boolean a;
    int b = 0;
    final /* synthetic */ v c;

    w(v vVar) {
        this.c = vVar;
    }

    public void handleMessage(Message message) {
        if (g.a) {
            x.a((byte) 3);
            this.c.a.d.sendEmptyMessage(3);
            return;
        }
        if (!this.a) {
            this.b++;
            if (this.b > InitError.INIT_AD_ERROR) {
                this.a = true;
            }
            if (this.c.a.d()) {
                this.a = true;
            } else if (this.c.b != null) {
                this.c.b.sendEmptyMessageDelayed(0, 10);
            } else {
                this.c.a.d.sendEmptyMessage(3);
            }
        }
        if (!this.a) {
            return;
        }
        if (!this.c.a.d() || this.c.b == null) {
            this.c.a.d.sendEmptyMessage(3);
        } else {
            this.c.b.sendEmptyMessageDelayed(0, 100);
        }
    }
}
