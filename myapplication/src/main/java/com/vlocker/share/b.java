package com.vlocker.share;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

class b implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ ShareActivity b;

    b(ShareActivity shareActivity, String str) {
        this.b = shareActivity;
        this.a = str;
    }

    public void run() {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.a).openConnection();
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();
            InputStream inputStream = httpURLConnection.getInputStream();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[100];
            while (true) {
                int read = inputStream.read(bArr, 0, 100);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    this.b.i = byteArrayOutputStream.toByteArray();
                    return;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
