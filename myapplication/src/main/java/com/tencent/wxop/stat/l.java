package com.tencent.wxop.stat;

import android.content.Context;
import com.qq.e.comm.constants.Constants.KEYS;
import com.tencent.a.a.a.a.h;
import com.tencent.wxop.stat.a.d;
import com.tencent.wxop.stat.b.b;
import com.tencent.wxop.stat.b.f;
import com.tencent.wxop.stat.b.g;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.GZIPOutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

class l {
    private static b d = com.tencent.wxop.stat.b.l.c();
    private static l e = null;
    private static Context f = null;
    DefaultHttpClient a = null;
    f b = null;
    StringBuilder c = new StringBuilder(4096);
    private long g = 0;

    private l(Context context) {
        try {
            f = context.getApplicationContext();
            this.g = System.currentTimeMillis() / 1000;
            this.b = new f();
            if (v.b()) {
                try {
                    Logger.getLogger("org.apache.http.wire").setLevel(Level.FINER);
                    Logger.getLogger("org.apache.http.headers").setLevel(Level.FINER);
                    System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.SimpleLog");
                    System.setProperty("org.apache.commons.logging.simplelog.showdatetime", "true");
                    System.setProperty("org.apache.commons.logging.simplelog.log.httpclient.wire", "debug");
                    System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.http", "debug");
                    System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.http.headers", "debug");
                } catch (Throwable th) {
                }
            }
            HttpParams basicHttpParams = new BasicHttpParams();
            HttpConnectionParams.setStaleCheckingEnabled(basicHttpParams, false);
            HttpConnectionParams.setConnectionTimeout(basicHttpParams, 10000);
            HttpConnectionParams.setSoTimeout(basicHttpParams, 10000);
            this.a = new DefaultHttpClient(basicHttpParams);
            this.a.setKeepAliveStrategy(new m(this));
        } catch (Throwable th2) {
            d.b(th2);
        }
    }

    static Context a() {
        return f;
    }

    static void a(Context context) {
        f = context.getApplicationContext();
    }

    static l b(Context context) {
        if (e == null) {
            synchronized (l.class) {
                if (e == null) {
                    e = new l(context);
                }
            }
        }
        return e;
    }

    final void a(d dVar, k kVar) {
        b(Arrays.asList(new String[]{dVar.g()}), kVar);
    }

    final void a(List list, k kVar) {
        Throwable th;
        int i = 0;
        if (list != null && !list.isEmpty()) {
            int size = list.size();
            list.get(0);
            try {
                int i2;
                String str;
                this.c.delete(0, this.c.length());
                this.c.append("[");
                String str2 = "rc4";
                for (i2 = 0; i2 < size; i2++) {
                    this.c.append(list.get(i2).toString());
                    if (i2 != size - 1) {
                        this.c.append(",");
                    }
                }
                this.c.append("]");
                String stringBuilder = this.c.toString();
                size = stringBuilder.length();
                String str3 = v.p() + "/?index=" + this.g;
                this.g++;
                if (v.b()) {
                    d.a("[" + str3 + "]Send request(" + size + "bytes), content:" + stringBuilder);
                }
                HttpPost httpPost = new HttpPost(str3);
                httpPost.addHeader("Accept-Encoding", "gzip");
                httpPost.setHeader("Connection", "Keep-Alive");
                httpPost.removeHeaders("Cache-Control");
                HttpHost a = z.a(f).a();
                httpPost.addHeader("Content-Encoding", str2);
                if (a == null) {
                    this.a.getParams().removeParameter("http.route.default-proxy");
                } else {
                    if (v.b()) {
                        d.g("proxy:" + a.toHostString());
                    }
                    httpPost.addHeader("X-Content-Encoding", str2);
                    this.a.getParams().setParameter("http.route.default-proxy", a);
                    httpPost.addHeader("X-Online-Host", v.l);
                    httpPost.addHeader("Accept", "*/*");
                    httpPost.addHeader("Content-Type", "json");
                }
                OutputStream byteArrayOutputStream = new ByteArrayOutputStream(size);
                byte[] bytes = stringBuilder.getBytes("UTF-8");
                int length = bytes.length;
                if (size > v.p) {
                    i = 1;
                }
                if (i != 0) {
                    httpPost.removeHeaders("Content-Encoding");
                    str = str2 + ",gzip";
                    httpPost.addHeader("Content-Encoding", str);
                    if (a != null) {
                        httpPost.removeHeaders("X-Content-Encoding");
                        httpPost.addHeader("X-Content-Encoding", str);
                    }
                    byteArrayOutputStream.write(new byte[4]);
                    GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                    gZIPOutputStream.write(bytes);
                    gZIPOutputStream.close();
                    bytes = byteArrayOutputStream.toByteArray();
                    ByteBuffer.wrap(bytes, 0, 4).putInt(length);
                    if (v.b()) {
                        d.g("before Gzip:" + length + " bytes, after Gzip:" + bytes.length + " bytes");
                    }
                }
                httpPost.setEntity(new ByteArrayEntity(g.a(bytes)));
                HttpResponse execute = this.a.execute(httpPost);
                HttpEntity entity = execute.getEntity();
                size = execute.getStatusLine().getStatusCode();
                long contentLength = entity.getContentLength();
                if (v.b()) {
                    d.a("http recv response status code:" + size + ", content length:" + contentLength);
                }
                if (contentLength <= 0) {
                    d.e("Server response no data.");
                    if (kVar != null) {
                        kVar.b();
                    }
                    EntityUtils.toString(entity);
                    return;
                }
                if (contentLength > 0) {
                    InputStream content = entity.getContent();
                    DataInputStream dataInputStream = new DataInputStream(content);
                    bytes = new byte[((int) entity.getContentLength())];
                    dataInputStream.readFully(bytes);
                    content.close();
                    dataInputStream.close();
                    Header firstHeader = execute.getFirstHeader("Content-Encoding");
                    if (firstHeader != null) {
                        if (firstHeader.getValue().equalsIgnoreCase("gzip,rc4")) {
                            bytes = g.b(com.tencent.wxop.stat.b.l.a(bytes));
                        } else if (firstHeader.getValue().equalsIgnoreCase("rc4,gzip")) {
                            bytes = com.tencent.wxop.stat.b.l.a(g.b(bytes));
                        } else if (firstHeader.getValue().equalsIgnoreCase("gzip")) {
                            bytes = com.tencent.wxop.stat.b.l.a(bytes);
                        } else if (firstHeader.getValue().equalsIgnoreCase("rc4")) {
                            bytes = g.b(bytes);
                        }
                    }
                    str = new String(bytes, "UTF-8");
                    if (v.b()) {
                        d.a("http get response data:" + str);
                    }
                    JSONObject jSONObject = new JSONObject(str);
                    if (size == 200) {
                        try {
                            stringBuilder = jSONObject.optString("mid");
                            if (h.b(stringBuilder)) {
                                if (v.b()) {
                                    d.a("update mid:" + stringBuilder);
                                }
                                com.tencent.a.a.a.a.g.a(f).a(stringBuilder);
                            }
                            if (!jSONObject.isNull("cfg")) {
                                v.a(f, jSONObject.getJSONObject("cfg"));
                            }
                            if (!jSONObject.isNull("ncts")) {
                                i2 = jSONObject.getInt("ncts");
                                i = (int) (((long) i2) - (System.currentTimeMillis() / 1000));
                                if (v.b()) {
                                    d.a("server time:" + i2 + ", diff time:" + i);
                                }
                                com.tencent.wxop.stat.b.l.w(f);
                                com.tencent.wxop.stat.b.l.a(f, i);
                            }
                        } catch (Throwable th2) {
                            d.c(th2);
                        }
                        if (kVar != null) {
                            if (jSONObject.optInt(KEYS.RET) == 0) {
                                kVar.a();
                            } else {
                                d.d("response error data.");
                                kVar.b();
                            }
                        }
                    } else {
                        d.d("Server response error code:" + size + ", error:" + new String(bytes, "UTF-8"));
                        if (kVar != null) {
                            kVar.b();
                        }
                    }
                    content.close();
                } else {
                    EntityUtils.toString(entity);
                }
                byteArrayOutputStream.close();
                th2 = null;
                if (th2 != null) {
                    d.a(th2);
                    if (kVar != null) {
                        try {
                            kVar.b();
                        } catch (Throwable th3) {
                            d.b(th3);
                        }
                    }
                    if (th2 instanceof OutOfMemoryError) {
                        System.gc();
                        this.c = null;
                        this.c = new StringBuilder(2048);
                    }
                    z.a(f).d();
                }
            } catch (Throwable th4) {
            }
        }
    }

    final void b(List list, k kVar) {
        if (this.b != null) {
            this.b.a(new n(this, list, kVar));
        }
    }
}
