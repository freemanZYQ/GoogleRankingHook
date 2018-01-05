package com.baidu.location.b;

import android.util.Log;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpProtocolParams;

class l extends Thread {
    final /* synthetic */ j a;

    l(j jVar) {
        this.a = jVar;
    }

    public void run() {
        int i;
        HttpEntity httpEntity;
        boolean z;
        Object obj;
        this.a.c = h.b();
        this.a.a();
        int i2 = this.a.d;
        this.a.b();
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
            try {
                httpPost = new HttpPost(this.a.c);
                try {
                    httpEntity = new UrlEncodedFormEntity(this.a.f, "utf-8");
                    httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
                    httpPost.setHeader("Accept-Charset", "UTF-8;");
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
                        this.a.e = execute.getEntity();
                        this.a.a(true);
                        break;
                    }
                    httpPost.abort();
                    i--;
                    obj = httpPost;
                } catch (Exception e) {
                }
            } catch (Exception e2) {
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
