package com.inveno.se.d.a;

import com.inveno.se.d.p;
import com.inveno.se.f.a;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public class i implements k {
    protected final HttpClient a;

    public i(HttpClient httpClient) {
        this.a = httpClient;
    }

    private static void a(HttpEntityEnclosingRequestBase httpEntityEnclosingRequestBase, p pVar) {
        byte[] b = pVar.b();
        if (b != null) {
            httpEntityEnclosingRequestBase.setEntity(new ByteArrayEntity(b));
        }
    }

    private static void a(HttpUriRequest httpUriRequest, Map map) {
        for (String str : map.keySet()) {
            httpUriRequest.setHeader(str, (String) map.get(str));
        }
    }

    static HttpUriRequest b(p pVar, Map map) {
        a.b("request url:" + pVar.i());
        HttpEntityEnclosingRequestBase httpPost;
        switch (pVar.g()) {
            case -1:
                byte[] o = pVar.o();
                if (o == null) {
                    return new HttpGet(pVar.i());
                }
                HttpUriRequest httpPost2 = new HttpPost(pVar.i());
                httpPost2.addHeader("Content-Type", pVar.n());
                httpPost2.setEntity(new ByteArrayEntity(o));
                return httpPost2;
            case 0:
                return new HttpGet(pVar.i());
            case 1:
                httpPost = new HttpPost(pVar.i());
                httpPost.addHeader("Content-Type", pVar.e());
                a(httpPost, pVar);
                return httpPost;
            case 2:
                httpPost = new HttpPut(pVar.i());
                httpPost.addHeader("Content-Type", pVar.e());
                a(httpPost, pVar);
                return httpPost;
            case 3:
                return new HttpDelete(pVar.i());
            default:
                throw new IllegalStateException("Unknown request method.");
        }
    }

    public HttpResponse a(p pVar, Map map) {
        HttpUriRequest b = b(pVar, map);
        a(b, map);
        a(b, pVar.k());
        a(b);
        HttpParams params = b.getParams();
        int r = pVar.r();
        HttpConnectionParams.setConnectionTimeout(params, 5000);
        HttpConnectionParams.setSoTimeout(params, r);
        return this.a.execute(b);
    }

    protected void a(HttpUriRequest httpUriRequest) {
    }
}
