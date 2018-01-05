package com.baidu.location.b;

import android.util.Log;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpProtocolParams;

class m extends Thread {
    final /* synthetic */ j a;

    m(j jVar) {
        this.a = jVar;
    }

    public void run() {
        int i;
        HttpEntity httpEntity;
        boolean z;
        this.a.c = h.b();
        this.a.b();
        this.a.a();
        int i2 = this.a.d;
        if (j.b == e.d) {
            i = i2;
            httpEntity = null;
            z = true;
        } else {
            i = i2;
            httpEntity = null;
            z = false;
        }
        while (i > 0) {
            HttpPost httpPost;
            Object obj;
            try {
                httpPost = new HttpPost(this.a.c);
                try {
                    httpEntity = new UrlEncodedFormEntity(this.a.f, "utf-8");
                    httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
                    httpPost.setHeader("Accept-Charset", "UTF-8;");
                    httpPost.setHeader("Host", "loc.map.baidu.com");
                    httpPost.addHeader("Accept-Encoding", "gzip");
                    httpPost.setEntity(httpEntity);
                    HttpClient defaultHttpClient = new DefaultHttpClient();
                    defaultHttpClient.getParams().setParameter("http.connection.timeout", Integer.valueOf(e.b));
                    defaultHttpClient.getParams().setParameter("http.socket.timeout", Integer.valueOf(e.b));
                    HttpProtocolParams.setUseExpectContinue(defaultHttpClient.getParams(), false);
                    if (z) {
                        defaultHttpClient.getParams().setParameter("http.route.default-proxy", new HttpHost(j.k, j.l, "http"));
                    }
                    z = !z;
                    HttpResponse execute = defaultHttpClient.execute(httpPost);
                    if (execute.getStatusLine().getStatusCode() == 200) {
                        InputStream content = execute.getEntity().getContent();
                        Header firstHeader = execute.getFirstHeader("Content-Encoding");
                        InputStream gZIPInputStream = (firstHeader == null || !firstHeader.getValue().equalsIgnoreCase("gzip")) ? content : new GZIPInputStream(new BufferedInputStream(content));
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        while (true) {
                            int read = gZIPInputStream.read();
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(read);
                        }
                        String byteArrayOutputStream2 = byteArrayOutputStream.toString();
                        if (gZIPInputStream != null) {
                            try {
                                gZIPInputStream.close();
                            } catch (Exception e) {
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        this.a.e = new StringEntity(byteArrayOutputStream2, "UTF-8");
                        this.a.a(true);
                        break;
                    }
                    httpPost.abort();
                    i--;
                    obj = httpPost;
                } catch (Exception e2) {
                }
            } catch (Exception e3) {
                Object obj2 = httpEntity;
                httpPost.abort();
                Log.d(e.a, "NetworkCommunicationException!");
                i--;
                obj = httpPost;
            }
        }
        if (i <= 0) {
            j.j++;
            this.a.e = null;
            this.a.a(false);
        } else {
            j.j = 0;
        }
        this.a.a = false;
    }
}
