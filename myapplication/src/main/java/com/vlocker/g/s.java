package com.vlocker.g;

import android.graphics.Bitmap;
import android.os.Message;

class s implements Runnable {
    final /* synthetic */ a a;
    final /* synthetic */ q b;

    s(q qVar, a aVar) {
        this.b = qVar;
        this.a = aVar;
    }

    public void run() {
        Bitmap bitmap = null;
        if (this.a.q != null) {
            bitmap = w.a(this.a.q);
        }
        if (bitmap != null) {
            this.a.r = bitmap;
        }
        if (this.a.h != null) {
            bitmap = w.a(this.a.h);
        }
        if (bitmap != null) {
            this.a.j = bitmap;
        }
        if (this.a.i != null) {
            bitmap = w.a(this.a.i);
        }
        if (bitmap != null) {
            this.a.k = bitmap;
        }
        if (this.a.c != null) {
            bitmap = w.a(this.a.c);
        }
        if (bitmap != null) {
            this.a.d = bitmap;
        }
        Message obtainMessage = this.b.c.obtainMessage();
        obtainMessage.obj = this.a;
        this.b.c.sendMessage(obtainMessage);
    }
}
