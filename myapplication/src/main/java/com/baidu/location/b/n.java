package com.baidu.location.b;

import android.util.Log;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;

class n extends Thread {
    final /* synthetic */ j a;

    n(j jVar) {
        this.a = jVar;
    }

    public void run() {
        int i;
        HttpEntity httpEntity;
        boolean z;
        HttpPost httpPost;
        Object obj;
        this.a.c = h.c();
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
            try {
                httpPost = new HttpPost(this.a.c);
                try {
                    httpEntity = new StringEntity(this.a.i, "UTF-8");
                    httpPost.setHeader("Content-Type", "text/xml");
                    httpPost.setEntity(httpEntity);
                    HttpParams basicHttpParams = new BasicHttpParams();
                    HttpConnectionParams.setConnectionTimeout(basicHttpParams, e.b);
                    HttpConnectionParams.setSoTimeout(basicHttpParams, e.b);
                    HttpClient a = j.a(basicHttpParams);
                    HttpProtocolParams.setUseExpectContinue(a.getParams(), false);
                    if (z) {
                        a.getParams().setParameter("http.route.default-proxy", new HttpHost(j.k, j.l, "http"));
                    }
                    z = !z;
                    HttpResponse execute = a.execute(httpPost);
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
