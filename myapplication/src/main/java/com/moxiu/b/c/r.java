package com.moxiu.b.c;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpVersion;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.SyncBasicHttpContext;

public class r {
    public static int a = 0;
    private static int b = 3;
    private static int c = 10000;
    private static int d = 2;
    private static final ThreadFactory i = new s();
    private static final Executor j = Executors.newFixedThreadPool(d, i);
    private final DefaultHttpClient e;
    private final HttpContext f;
    private String g = "utf-8";
    private final Map h;

    public r() {
        HttpParams basicHttpParams = new BasicHttpParams();
        ConnManagerParams.setTimeout(basicHttpParams, (long) c);
        ConnManagerParams.setMaxConnectionsPerRoute(basicHttpParams, new ConnPerRouteBean(b));
        ConnManagerParams.setMaxTotalConnections(basicHttpParams, 10);
        HttpConnectionParams.setSoTimeout(basicHttpParams, c);
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, c);
        HttpConnectionParams.setTcpNoDelay(basicHttpParams, true);
        HttpConnectionParams.setSocketBufferSize(basicHttpParams, 8192);
        HttpProtocolParams.setVersion(basicHttpParams, HttpVersion.HTTP_1_1);
        basicHttpParams.setParameter("http.protocol.allow-circular-redirects", Boolean.valueOf(true));
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        ClientConnectionManager threadSafeClientConnManager = new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry);
        this.f = new SyncBasicHttpContext(new BasicHttpContext());
        this.e = new DefaultHttpClient(threadSafeClientConnManager, basicHttpParams);
        this.e.addRequestInterceptor(new t(this));
        this.e.addResponseInterceptor(new u(this));
        this.e.setHttpRequestRetryHandler(new w(a));
        this.h = new HashMap();
    }

    public static String a(String str, m mVar) {
        if (mVar != null) {
            str = str + "?" + mVar.c();
        }
        return str.replaceAll(" ", "%20");
    }

    private HttpEntity a(m mVar) {
        return mVar != null ? mVar.a() : null;
    }

    private HttpEntityEnclosingRequestBase a(HttpEntityEnclosingRequestBase httpEntityEnclosingRequestBase, HttpEntity httpEntity) {
        if (httpEntity != null) {
            httpEntityEnclosingRequestBase.setEntity(httpEntity);
        }
        return httpEntityEnclosingRequestBase;
    }

    public void a(String str, m mVar, n nVar) {
        a(this.e, this.f, new HttpGet(a(str, mVar)), null, nVar);
    }

    public void a(String str, n nVar) {
        try {
            a(str, null, nVar);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(String str, HttpEntity httpEntity, String str2, n nVar) {
        a(this.e, this.f, a(new HttpPost(str), httpEntity), str2, nVar);
    }

    protected void a(DefaultHttpClient defaultHttpClient, HttpContext httpContext, HttpUriRequest httpUriRequest, String str, n nVar) {
        if (str != null) {
            httpUriRequest.addHeader("Content-Type", str);
        }
        if (x.a()) {
            new o(defaultHttpClient, httpContext, nVar, this.g).a(j, httpUriRequest);
            return;
        }
        new o(defaultHttpClient, httpContext, nVar, this.g).c(httpUriRequest);
    }

    public void b(String str, m mVar, n nVar) {
        a(str, a(mVar), null, nVar);
    }

    public void b(String str, n nVar) {
        b(str, null, nVar);
    }
}
