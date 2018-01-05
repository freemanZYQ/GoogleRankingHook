package com.vlocker.ui.view;

import android.graphics.Bitmap;
import android.graphics.Movie;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class o extends Handler {
    final /* synthetic */ GifImageView a;

    o(GifImageView gifImageView, Looper looper) {
        this.a = gifImageView;
        super(looper);
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        switch (message.what) {
            case 817:
                this.a.m = (byte[]) message.obj;
                if (this.a.m != null) {
                    new Thread(new m(this.a.p, this.a.m)).start();
                    return;
                }
                return;
            case 818:
                this.a.setImageBitmap(null);
                if (this.a.l != null) {
                    this.a.l.recycle();
                    this.a.l = null;
                }
                this.a.k = (Movie) message.obj;
                this.a.requestLayout();
                if (this.a.o != null && this.a.k != null) {
                    this.a.o.a(this.a.k.width(), this.a.k.height());
                    return;
                }
                return;
            case 819:
                this.a.k = null;
                this.a.l = (Bitmap) message.obj;
                this.a.setImageBitmap((Bitmap) message.obj);
                this.a.requestLayout();
                if (this.a.o != null && this.a.l != null) {
                    this.a.o.a(this.a.l.getWidth(), this.a.l.getHeight());
                    return;
                }
                return;
            case 820:
                String str = (String) message.obj;
                if (this.a.o != null) {
                    this.a.o.a(str);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
