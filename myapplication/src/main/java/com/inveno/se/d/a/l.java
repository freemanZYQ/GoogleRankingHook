package com.inveno.se.d.a;

import com.inveno.se.d.p;
import com.inveno.se.f.a;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicStatusLine;

public class l implements k {
    private o a;
    private n b;
    private final m c;
    private final SSLSocketFactory d;

    public l() {
        this(null);
    }

    public l(m mVar) {
        this(mVar, null);
    }

    public l(m mVar, SSLSocketFactory sSLSocketFactory) {
        this.a = new o(this);
        this.b = new n(this);
        this.c = mVar;
        this.d = sSLSocketFactory;
    }

    private HttpURLConnection a(URL url, p pVar) {
        HttpURLConnection a = a(url);
        int r = pVar.r();
        a.setConnectTimeout(r);
        a.setReadTimeout(r);
        a.setUseCaches(false);
        a.setDoInput(true);
        if ("https".equals(url.getProtocol()) && this.d != null) {
            ((HttpsURLConnection) a).setSSLSocketFactory(this.d);
        }
        return a;
    }

    private static HttpEntity a(HttpURLConnection httpURLConnection) {
        InputStream inputStream;
        HttpEntity basicHttpEntity = new BasicHttpEntity();
        try {
            inputStream = httpURLConnection.getInputStream();
        } catch (IOException e) {
            inputStream = httpURLConnection.getErrorStream();
        }
        basicHttpEntity.setContent(inputStream);
        basicHttpEntity.setContentLength((long) httpURLConnection.getContentLength());
        basicHttpEntity.setContentEncoding(httpURLConnection.getContentEncoding());
        basicHttpEntity.setContentType(httpURLConnection.getContentType());
        return basicHttpEntity;
    }

    static void a(HttpURLConnection httpURLConnection, p pVar) {
        switch (pVar.g()) {
            case -1:
                byte[] o = pVar.o();
                if (o != null) {
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.addRequestProperty("Content-Type", pVar.n());
                    DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                    dataOutputStream.write(o);
                    dataOutputStream.close();
                    return;
                }
                return;
            case 0:
                httpURLConnection.setRequestMethod("GET");
                return;
            case 1:
                httpURLConnection.setRequestMethod("POST");
                b(httpURLConnection, pVar);
                return;
            case 2:
                httpURLConnection.setRequestMethod("PUT");
                b(httpURLConnection, pVar);
                return;
            case 3:
                httpURLConnection.setRequestMethod("DELETE");
                return;
            default:
                throw new IllegalStateException("Unknown method type.");
        }
    }

    private HttpsURLConnection b(URL url, p pVar) {
        SSLContext sSLContext = null;
        try {
            sSLContext = SSLContext.getInstance("SSL");
            sSLContext.init(null, new X509TrustManager[]{this.a}, new SecureRandom());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e2) {
            e2.printStackTrace();
        }
        if (sSLContext != null) {
            HttpsURLConnection.setDefaultSSLSocketFactory(new s(sSLContext.getSocketFactory()));
        }
        HttpsURLConnection.setDefaultHostnameVerifier(this.b);
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
        int r = pVar.r();
        httpsURLConnection.setConnectTimeout(r);
        httpsURLConnection.setReadTimeout(r);
        httpsURLConnection.setUseCaches(false);
        httpsURLConnection.setDoInput(true);
        if ("https".equals(url.getProtocol()) && this.d != null) {
            httpsURLConnection.setSSLSocketFactory(this.d);
        }
        return httpsURLConnection;
    }

    private static void b(HttpURLConnection httpURLConnection, p pVar) {
        Object b = pVar.b();
        a.b("请求   去111 body:" + b);
        if (b != null) {
            httpURLConnection.setDoOutput(true);
            httpURLConnection.addRequestProperty("Content-Type", pVar.e());
            a.b("addBodyIfExists contentType:" + pVar.e());
            httpURLConnection.addRequestProperty("Accept-Encoding", "invdeflate");
            httpURLConnection.addRequestProperty("Content-length", String.valueOf(b.length));
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            dataOutputStream.write(b);
            dataOutputStream.close();
        }
    }

    protected HttpURLConnection a(URL url) {
        return (HttpURLConnection) url.openConnection();
    }

    public HttpResponse a(p pVar, Map map) {
        String a;
        String i = pVar.i();
        HashMap hashMap = new HashMap();
        hashMap.putAll(pVar.k());
        hashMap.putAll(map);
        if (this.c != null) {
            a = this.c.a(i);
            if (a == null) {
                throw new IOException("URL blocked by rewriter: " + i);
            }
        }
        a = i;
        URL url = new URL(a);
        a.b("parsedUrl.getProtocol():" + url.getProtocol());
        HttpURLConnection b = "https".equals(url.getProtocol()) ? b(url, pVar) : a(url, pVar);
        a.b("parsedUrl.getProtocol() map size:" + hashMap.size());
        for (String a2 : hashMap.keySet()) {
            a.b("headerName:" + a2);
            b.addRequestProperty(a2, (String) hashMap.get(a2));
        }
        a(b, pVar);
        ProtocolVersion protocolVersion = new ProtocolVersion("HTTP", 1, 1);
        if (b.getResponseCode() == -1) {
            throw new IOException("Could not retrieve response code from HttpUrlConnection.");
        }
        HttpResponse basicHttpResponse = new BasicHttpResponse(new BasicStatusLine(protocolVersion, b.getResponseCode(), b.getResponseMessage()));
        basicHttpResponse.setEntity(a(b));
        for (Entry entry : b.getHeaderFields().entrySet()) {
            if (entry.getKey() != null) {
                basicHttpResponse.addHeader(new BasicHeader((String) entry.getKey(), (String) ((List) entry.getValue()).get(0)));
            }
        }
        return basicHttpResponse;
    }
}
