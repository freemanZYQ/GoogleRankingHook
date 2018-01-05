package com.vlocker.ui.view;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Movie;
import android.os.Handler;
import android.os.Message;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class m implements Runnable {
    Handler a;
    byte[] b;
    InputStream c;

    public m(Handler handler, InputStream inputStream) {
        this.b = null;
        this.c = inputStream;
        this.a = handler;
    }

    public m(Handler handler, byte[] bArr) {
        this.b = bArr;
        this.a = handler;
    }

    private void a(int i, Object obj) {
        Message obtainMessage = this.a.obtainMessage();
        obtainMessage.what = i;
        obtainMessage.obj = obj;
        this.a.sendMessage(obtainMessage);
    }

    private void b(InputStream inputStream) {
        String str = "";
        for (int i = 0; i < 6; i++) {
            str = str + ((char) c(inputStream));
        }
        if (str.startsWith("GIF")) {
            Movie decodeByteArray = Movie.decodeByteArray(this.b, 0, this.b.length);
            if (decodeByteArray != null) {
                a(818, decodeByteArray);
                return;
            }
            return;
        }
        Bitmap decodeByteArray2 = BitmapFactory.decodeByteArray(this.b, 0, this.b.length);
        if (decodeByteArray2 != null) {
            a(819, decodeByteArray2);
        }
    }

    private int c(InputStream inputStream) {
        int i = 0;
        try {
            i = inputStream.read();
        } catch (Exception e) {
        }
        return i;
    }

    public byte[] a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    public void run() {
        try {
            if (this.b == null) {
                if (this.c != null) {
                    this.b = a(this.c);
                } else {
                    return;
                }
            }
            b(new ByteArrayInputStream(this.b));
        } catch (Exception e) {
            e.printStackTrace();
            a(820, "decode data exception");
        } catch (Error e2) {
            e2.printStackTrace();
            a(820, "decode data error");
        }
    }
}
