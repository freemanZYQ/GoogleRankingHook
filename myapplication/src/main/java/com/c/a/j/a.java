package com.c.a.j;

import android.content.Context;
import android.util.Log;
import com.c.a.k.b;
import com.c.a.k.d;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class a {
    public CharSequence a = "unkown";
    private CharSequence b = "http://wgo.mmstat.com/ire.2.1";
    private List c = new ArrayList(30);
    private CharSequence d;

    public a(Context context, CharSequence charSequence) {
        try {
            this.d = charSequence;
            this.a = b.a(context);
        } catch (Exception e) {
            Log.d("TBMiniUserTrack", e.getStackTrace().toString());
        }
    }

    private void a() {
        Throwable th;
        Throwable th2;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("logtype=2&wappkey=").append(this.d).append("&").append("packagename=").append(com.c.a.b.a.a(d.a())).append("&").append("os=").append("android").append("&").append("imei=").append(this.a).append("&t=").append(System.currentTimeMillis()).append("&type=");
        if (this.c.size() > 0) {
            stringBuffer.append((CharSequence) this.c.get(0));
        }
        this.c.clear();
        Log.d("TBMiniUserTrack flush content", stringBuffer.toString());
        HttpURLConnection httpURLConnection = null;
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(String.valueOf(this.b)).openConnection();
            try {
                httpURLConnection2.setRequestMethod("POST");
                httpURLConnection2.setDoOutput(true);
                httpURLConnection2.setDoInput(true);
                httpURLConnection2.setConnectTimeout(5000);
                httpURLConnection2.setReadTimeout(5000);
                OutputStream outputStream = httpURLConnection2.getOutputStream();
                outputStream.write(URLEncoder.encode(stringBuffer.toString(), "UTF-8").getBytes());
                outputStream.flush();
                outputStream.close();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection2.getInputStream()));
                String str = "";
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    str = str + "\n" + readLine;
                }
                Log.d("TBMiniUserTrack flush response", str);
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
            } catch (Throwable th3) {
                th = th3;
                httpURLConnection = httpURLConnection2;
                th2 = th;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th2;
            }
        } catch (Throwable th4) {
            th2 = th4;
            Log.d("TBMiniUserTrack flush exception", th2.getStackTrace().toString());
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }
    }

    public void a(CharSequence charSequence) {
        synchronized (this) {
            this.c.add(charSequence);
        }
    }

    public void b(CharSequence charSequence) {
        synchronized (this) {
            a(charSequence);
            try {
                new Thread(new b(this)).start();
            } catch (Exception e) {
                Log.d("TBMiniUserTrack flush exception", e.getStackTrace().toString());
            }
        }
    }
}
