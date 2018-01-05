package com.baidu.mobads.openad.e;

import android.os.Build.VERSION;
import com.baidu.mobads.j.m;
import com.baidu.mobads.openad.d.d;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

class b extends Thread {
    final /* synthetic */ d a;
    final /* synthetic */ double b;
    final /* synthetic */ a c;

    b(a aVar, d dVar, double d) {
        this.c = aVar;
        this.a = dVar;
        this.b = d;
    }

    public void run() {
        InputStream inputStream = null;
        try {
            String str = "";
            if (this.a.c > 0) {
                Thread.sleep(this.a.c);
            }
            this.c.e.set(true);
            this.c.g = (HttpURLConnection) new URL(this.a.a).openConnection();
            this.c.g.setConnectTimeout((int) this.b);
            this.c.g.setUseCaches(false);
            if (this.a.b != null && this.a.b.length() > 0) {
                this.c.g.setRequestProperty("User-Agent", this.a.b);
            }
            this.c.g.setRequestProperty("Content-type", this.a.d);
            this.c.g.setRequestProperty("Connection", "keep-alive");
            this.c.g.setRequestProperty("Cache-Control", "no-cache");
            if (Integer.parseInt(VERSION.SDK) < 8) {
                System.setProperty("http.keepAlive", "false");
            }
            if (a.b != null) {
                str = "";
                if (this.c.d != null) {
                    str = this.c.d;
                }
                String a = a.b.a(this.a.a);
                if (a != null) {
                    str = str + "," + a;
                }
                if (str.length() > 0) {
                    this.c.g.setRequestProperty("Cookie", str);
                }
            }
            if (this.a.e == 1) {
                this.c.g.setRequestMethod("GET");
                this.c.g.connect();
                inputStream = this.c.g.getInputStream();
                Map headerFields = this.c.g.getHeaderFields();
                if (headerFields.containsKey("Set-Cookie")) {
                    List<String> list = (List) headerFields.get("Set-Cookie");
                    if (list != null) {
                        for (String str2 : list) {
                            a.b.a(this.a.a, str2);
                        }
                    }
                }
                if (!this.c.f.booleanValue()) {
                    this.c.dispatchEvent(new d("URLLoader.Load.Complete", a.b(inputStream), this.a.a()));
                }
            } else if (this.a.e == 0) {
                this.c.g.setRequestMethod("POST");
                this.c.g.setDoInput(true);
                this.c.g.setDoOutput(true);
                if (this.a.b() != null) {
                    str2 = this.a.b().build().getEncodedQuery();
                    OutputStream outputStream = this.c.g.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                    bufferedWriter.write(str2);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    outputStream.close();
                }
                this.c.g.connect();
                this.c.g.getResponseCode();
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    m.a().f().e("OAdURLLoader", e.getMessage());
                }
                try {
                    this.c.g.disconnect();
                } catch (Exception e2) {
                }
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e3) {
                    m.a().f().e("OAdURLLoader", e3.getMessage());
                }
                try {
                    this.c.g.disconnect();
                } catch (Exception e4) {
                }
            }
        }
    }
}
