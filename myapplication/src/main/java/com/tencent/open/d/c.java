package com.tencent.open.d;

import android.graphics.Bitmap;
import android.os.Message;
import com.tencent.open.a.j;
import java.io.File;

class c implements Runnable {
    final /* synthetic */ a a;

    c(a aVar) {
        this.a = aVar;
    }

    public void run() {
        j.a("AsynLoadImg", "saveFileRunnable:");
        String str = "share_qq_" + u.d(this.a.a) + ".jpg";
        String str2 = a.c + str;
        File file = new File(str2);
        Message obtainMessage = this.a.e.obtainMessage();
        if (file.exists()) {
            obtainMessage.arg1 = 0;
            obtainMessage.obj = str2;
            j.a("AsynLoadImg", "file exists: time:" + (System.currentTimeMillis() - this.a.d));
        } else {
            boolean a;
            Bitmap a2 = a.a(this.a.a);
            if (a2 != null) {
                a = this.a.a(a2, str);
            } else {
                j.a("AsynLoadImg", "saveFileRunnable:get bmp fail---");
                a = false;
            }
            if (a) {
                obtainMessage.arg1 = 0;
                obtainMessage.obj = str2;
            } else {
                obtainMessage.arg1 = 1;
            }
            j.a("AsynLoadImg", "file not exists: download time:" + (System.currentTimeMillis() - this.a.d));
        }
        this.a.e.sendMessage(obtainMessage);
    }
}
