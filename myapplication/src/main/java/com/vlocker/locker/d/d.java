package com.vlocker.locker.d;

import com.vlocker.b.j;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import org.apache.http.HttpVersion;
import org.apache.http.client.methods.HttpGet;
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

public class d {
    public static int a = 0;
    private static int b = 3;
    private static int c = 10000;
    private static int d = 2;
    private static final ThreadFactory i = new e();
    private static final Executor j = Executors.newFixedThreadPool(d, i);
    private final DefaultHttpClient e;
    private final HttpContext f;
    private String g = "utf-8";
    private final Map h;

    public d() {
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
        this.e.addRequestInterceptor(new f(this));
        this.e.addResponseInterceptor(new g(this));
        this.e.setHttpRequestRetryHandler(new k(a));
        this.h = new HashMap();
    }

    public static String a(String str, c cVar) {
        if (cVar != null) {
            str = str + "?" + cVar.b();
        }
        return str.replaceAll(" ", "%20");
    }

    public void a(String str, c cVar, i iVar) {
        a(this.e, this.f, new HttpGet(a(str, cVar)), null, iVar);
    }

    public void a(String str, i iVar) {
        try {
            a(str, null, iVar);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void a(DefaultHttpClient defaultHttpClient, HttpContext httpContext, HttpUriRequest httpUriRequest, String str, i iVar) {
        if (str != null) {
            httpUriRequest.addHeader("Content-Type", str);
        }
        if (j.h()) {
            new j(defaultHttpClient, httpContext, iVar, this.g).a(j, httpUriRequest);
            return;
        }
        new j(defaultHttpClient, httpContext, iVar, this.g).c(httpUriRequest);
    }
}
