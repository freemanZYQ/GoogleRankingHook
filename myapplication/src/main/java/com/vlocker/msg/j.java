package com.vlocker.msg;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Message;
import com.vlocker.locker.R;

class j implements Runnable {
    final /* synthetic */ ak a;
    final /* synthetic */ Context b;
    final /* synthetic */ McmPushWidget c;

    j(McmPushWidget mcmPushWidget, ak akVar, Context context) {
        this.c = mcmPushWidget;
        this.a = akVar;
        this.b = context;
    }

    public void run() {
        Bitmap bitmap = null;
        Bitmap bitmapFromURL = this.a.n != null ? McmPushWidget.getBitmapFromURL(this.a.n) : null;
        if (bitmapFromURL == null) {
            bitmapFromURL = this.a.C == 8 ? BitmapFactory.decodeResource(this.b.getResources(), R.drawable.main_icon) : BitmapFactory.decodeResource(this.b.getResources(), R.drawable.push_notify_icon);
        }
        if (this.a.C != 7 && this.a.k == null) {
            this.a.k = bitmapFromURL;
        }
        if (this.a.C == 4) {
            Bitmap[] bitmapArr;
            if (this.a.H == null || this.a.H.length <= 0) {
                bitmapArr = null;
            } else {
                Bitmap[] bitmapArr2 = new Bitmap[this.a.H.length];
                int length = this.a.H.length;
                if (length > 6) {
                    length = 6;
                }
                for (int i = 0; i < length; i++) {
                    bitmapArr2[i] = McmPushWidget.getBitmapFromURL(this.a.H[i]);
                    if (bitmapArr2[i] == null) {
                        bitmapArr2[i] = BitmapFactory.decodeResource(this.b.getResources(), R.drawable.push_small_icon);
                    }
                }
                bitmapArr = bitmapArr2;
            }
            this.a.G = bitmapArr;
        } else if (this.a.C == 3 || this.a.C == 2) {
            if (this.a.u != null) {
                bitmap = McmPushWidget.getBitmapFromURL(this.a.u);
            }
            if (this.a.t == null && bitmap == null) {
                this.a.C = 1;
            }
            if (bitmap != null) {
                this.a.t = bitmap;
            }
        } else if (this.a.C == 8) {
            if (this.a.u != null) {
                bitmap = McmPushWidget.getBitmapFromURL(this.a.u);
            }
            if (bitmap == null) {
                this.a.C = 1;
            }
            this.a.t = bitmap;
        }
        Message obtainMessage = this.c.handler.obtainMessage();
        obtainMessage.obj = this.a;
        obtainMessage.what = this.a.F;
        this.c.handler.sendMessage(obtainMessage);
    }
}
