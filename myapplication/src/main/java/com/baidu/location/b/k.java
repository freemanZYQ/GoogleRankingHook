package com.baidu.location.b;

import android.util.Log;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpProtocolParams;

class k extends Thread {
    final /* synthetic */ j a;

    k(j jVar) {
        this.a = jVar;
    }

    public void run() {
        int i;
        boolean z;
        this.a.c = h.b();
        this.a.a();
        int i2 = this.a.d;
        this.a.b();
        if (j.b == e.d) {
            i = i2;
            z = true;
        } else {
            i = i2;
            z = false;
        }
        while (i > 0) {
            try {
                Object httpGet = new HttpGet(this.a.c);
                httpGet.setHeader("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
                httpGet.setHeader("Accept-Charset", "UTF-8;");
                HttpClient defaultHttpClient = new DefaultHttpClient();
                defaultHttpClient.getParams().setParameter("http.connection.timeout", Integer.valueOf(e.b));
                defaultHttpClient.getParams().setParameter("http.socket.timeout", Integer.valueOf(e.b));
                HttpProtocolParams.setUseExpectContinue(defaultHttpClient.getParams(), false);
                if (z) {
                    defaultHttpClient.getParams().setParameter("http.route.default-proxy", new HttpHost(j.k, j.l, "http"));
                }
                z = !z;
                HttpResponse execute = defaultHttpClient.execute(httpGet);
                if (execute.getStatusLine().getStatusCode() == 200) {
                    this.a.e = execute.getEntity();
                    this.a.a(true);
                    break;
                }
                httpGet.abort();
                i--;
            } catch (Exception e) {
                Log.d(e.a, "NetworkCommunicationException!");
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
