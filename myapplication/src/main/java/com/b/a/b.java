package com.b.a;

import android.os.Build.VERSION;
import com.moxiu.b.d.c;
import java.net.HttpURLConnection;
import java.net.URL;

class b extends Thread {
    final /* synthetic */ String a;
    final /* synthetic */ a b;

    b(a aVar, String str) {
        this.b = aVar;
        this.a = str;
    }

    public void run() {
        Throwable th;
        HttpURLConnection httpURLConnection = null;
        HttpURLConnection httpURLConnection2;
        try {
            httpURLConnection2 = (HttpURLConnection) new URL(this.a.toString()).openConnection();
            try {
                if (this.b.X != null) {
                    httpURLConnection2.setRequestProperty("user-agent", c.l(this.b.X));
                }
                httpURLConnection2.setRequestMethod("GET");
                if ("post".equals(this.b.A)) {
                    httpURLConnection2.setDoOutput(true);
                }
                httpURLConnection2.setDoInput(true);
                httpURLConnection2.setUseCaches(false);
                if (Integer.parseInt(VERSION.SDK) < 8) {
                    System.setProperty("http.keepAlive", "false");
                }
                if (httpURLConnection2.getResponseCode() == 200) {
                    httpURLConnection2.getInputStream();
                }
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
            } catch (Exception e) {
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
            } catch (Throwable th2) {
                Throwable th3 = th2;
                httpURLConnection = httpURLConnection2;
                th = th3;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        } catch (Exception e2) {
            httpURLConnection2 = null;
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
        } catch (Throwable th4) {
            th = th4;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }
}
