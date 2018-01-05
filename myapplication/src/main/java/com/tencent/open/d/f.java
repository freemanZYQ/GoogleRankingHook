package com.tencent.open.d;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.connect.a.a;
import com.tencent.connect.b.c;
import com.tencent.open.a.j;
import java.io.ByteArrayOutputStream;
import java.io.CharConversionException;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidClassException;
import java.io.InvalidObjectException;
import java.io.NotActiveException;
import java.io.NotSerializableException;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;
import java.io.SyncFailedException;
import java.io.UTFDataFormatException;
import java.io.UnsupportedEncodingException;
import java.io.WriteAbortedException;
import java.net.BindException;
import java.net.ConnectException;
import java.net.HttpRetryException;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.FileLockInterruptionException;
import java.nio.charset.MalformedInputException;
import java.nio.charset.UnmappableCharacterException;
import java.security.KeyStore;
import java.util.InvalidPropertiesFormatException;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLKeyException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import org.apache.http.ConnectionClosedException;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.MalformedChunkCodingException;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;

public class f {
    public static int a(IOException iOException) {
        return iOException instanceof CharConversionException ? -20 : iOException instanceof MalformedInputException ? -21 : iOException instanceof UnmappableCharacterException ? -22 : iOException instanceof HttpResponseException ? -23 : iOException instanceof ClosedChannelException ? -24 : iOException instanceof ConnectionClosedException ? -25 : iOException instanceof EOFException ? -26 : iOException instanceof FileLockInterruptionException ? -27 : iOException instanceof FileNotFoundException ? -28 : iOException instanceof HttpRetryException ? -29 : iOException instanceof ConnectTimeoutException ? -7 : iOException instanceof SocketTimeoutException ? -8 : iOException instanceof InvalidPropertiesFormatException ? -30 : iOException instanceof MalformedChunkCodingException ? -31 : iOException instanceof MalformedURLException ? -3 : iOException instanceof NoHttpResponseException ? -32 : iOException instanceof InvalidClassException ? -33 : iOException instanceof InvalidObjectException ? -34 : iOException instanceof NotActiveException ? -35 : iOException instanceof NotSerializableException ? -36 : iOException instanceof OptionalDataException ? -37 : iOException instanceof StreamCorruptedException ? -38 : iOException instanceof WriteAbortedException ? -39 : iOException instanceof ProtocolException ? -40 : iOException instanceof SSLHandshakeException ? -41 : iOException instanceof SSLKeyException ? -42 : iOException instanceof SSLPeerUnverifiedException ? -43 : iOException instanceof SSLProtocolException ? -44 : iOException instanceof BindException ? -45 : iOException instanceof ConnectException ? -46 : iOException instanceof NoRouteToHostException ? -47 : iOException instanceof PortUnreachableException ? -48 : iOException instanceof SyncFailedException ? -49 : iOException instanceof UTFDataFormatException ? -50 : iOException instanceof UnknownHostException ? -51 : iOException instanceof UnknownServiceException ? -52 : iOException instanceof UnsupportedEncodingException ? -53 : iOException instanceof ZipException ? -54 : -2;
    }

    public static k a(Context context) {
        if (context == null) {
            return null;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return null;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return null;
        }
        if (activeNetworkInfo.getType() == 0) {
            Object c = c(context);
            int b = b(context);
            if (!TextUtils.isEmpty(c) && b >= 0) {
                return new k(c, b);
            }
        }
        return null;
    }

    public static v a(Context context, String str, String str2, Bundle bundle) {
        HttpUriRequest httpUriRequest;
        int i;
        int size;
        if (context != null) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
                    throw new l("network unavailable");
                }
            }
        }
        Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
        String str3 = "";
        str3 = bundle2.getString("appid_for_getting_config");
        bundle2.remove("appid_for_getting_config");
        HttpClient a = a(context, str3, str);
        int length;
        if (str2.equals("GET")) {
            String a2 = a(bundle2);
            length = 0 + a2.length();
            j.a("openSDK_LOG.HttpUtils", "-->openUrl2 before url =" + str);
            str3 = str.indexOf("?") == -1 ? str + "?" : str + "&";
            j.a("openSDK_LOG.HttpUtils", "-->openUrl2 encodedParam =" + a2 + " -- url = " + str3);
            HttpUriRequest httpGet = new HttpGet(str3 + a2);
            httpGet.addHeader("Accept-Encoding", "gzip");
            int i2 = length;
            httpUriRequest = httpGet;
            i = i2;
        } else if (str2.equals("POST")) {
            Object obj;
            HttpPost httpPost = new HttpPost(str);
            httpPost.addHeader("Accept-Encoding", "gzip");
            Bundle bundle3 = new Bundle();
            for (String str32 : bundle2.keySet()) {
                obj = bundle2.get(str32);
                if (obj instanceof byte[]) {
                    bundle3.putByteArray(str32, (byte[]) obj);
                }
            }
            if (!bundle2.containsKey("method")) {
                bundle2.putString("method", str2);
            }
            httpPost.setHeader("Content-Type", "multipart/form-data; boundary=3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f");
            httpPost.setHeader("Connection", "Keep-Alive");
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(u.g("--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f\r\n"));
            byteArrayOutputStream.write(u.g(a(bundle2, "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f")));
            if (!bundle3.isEmpty()) {
                size = bundle3.size();
                byteArrayOutputStream.write(u.g("\r\n--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f\r\n"));
                length = -1;
                for (String str322 : bundle3.keySet()) {
                    length++;
                    byteArrayOutputStream.write(u.g("Content-Disposition: form-data; name=\"" + str322 + "\"; filename=\"" + str322 + "\"" + "\r\n"));
                    byteArrayOutputStream.write(u.g("Content-Type: content/unknown\r\n\r\n"));
                    byte[] byteArray = bundle3.getByteArray(str322);
                    if (byteArray != null) {
                        byteArrayOutputStream.write(byteArray);
                    }
                    if (length < size - 1) {
                        byteArrayOutputStream.write(u.g("\r\n--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f\r\n"));
                    }
                }
            }
            byteArrayOutputStream.write(u.g("\r\n--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f--\r\n"));
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            i = toByteArray.length + 0;
            byteArrayOutputStream.close();
            httpPost.setEntity(new ByteArrayEntity(toByteArray));
            obj = httpPost;
        } else {
            httpUriRequest = null;
            i = 0;
        }
        HttpResponse execute = a.execute(httpUriRequest);
        size = execute.getStatusLine().getStatusCode();
        if (size == 200) {
            return new v(a(execute), i);
        }
        throw new i("http status code error:" + size);
    }

    public static String a(Bundle bundle) {
        if (bundle == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        Object obj = 1;
        for (String str : bundle.keySet()) {
            Object obj2 = bundle.get(str);
            if ((obj2 instanceof String) || (obj2 instanceof String[])) {
                Object obj3;
                if (obj2 instanceof String[]) {
                    if (obj != null) {
                        obj = null;
                    } else {
                        stringBuilder.append("&");
                    }
                    stringBuilder.append(URLEncoder.encode(str) + "=");
                    String[] stringArray = bundle.getStringArray(str);
                    if (stringArray != null) {
                        for (int i = 0; i < stringArray.length; i++) {
                            if (i == 0) {
                                stringBuilder.append(URLEncoder.encode(stringArray[i]));
                            } else {
                                stringBuilder.append(URLEncoder.encode("," + stringArray[i]));
                            }
                        }
                        obj3 = obj;
                    }
                } else {
                    if (obj != null) {
                        obj = null;
                    } else {
                        stringBuilder.append("&");
                    }
                    stringBuilder.append(URLEncoder.encode(str) + "=" + URLEncoder.encode(bundle.getString(str)));
                    obj3 = obj;
                }
                obj = obj3;
            }
        }
        return stringBuilder.toString();
    }

    public static String a(Bundle bundle, String str) {
        if (bundle == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        int size = bundle.size();
        int i = -1;
        for (String str2 : bundle.keySet()) {
            int i2 = i + 1;
            Object obj = bundle.get(str2);
            if (obj instanceof String) {
                stringBuilder.append("Content-Disposition: form-data; name=\"" + str2 + "\"" + "\r\n" + "\r\n" + ((String) obj));
                if (i2 < size - 1) {
                    stringBuilder.append("\r\n--" + str + "\r\n");
                }
                i = i2;
            } else {
                i = i2;
            }
        }
        return stringBuilder.toString();
    }

    private static String a(HttpResponse httpResponse) {
        String str = "";
        InputStream content = httpResponse.getEntity().getContent();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Header firstHeader = httpResponse.getFirstHeader("Content-Encoding");
        InputStream gZIPInputStream = (firstHeader == null || firstHeader.getValue().toLowerCase().indexOf("gzip") <= -1) ? content : new GZIPInputStream(content);
        byte[] bArr = new byte[512];
        while (true) {
            int read = gZIPInputStream.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                String str2 = new String(byteArrayOutputStream.toByteArray(), "UTF-8");
                gZIPInputStream.close();
                return str2;
            }
        }
    }

    public static HttpClient a(Context context, String str, String str2) {
        int a;
        int i = 0;
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        if (VERSION.SDK_INT < 16) {
            try {
                KeyStore instance = KeyStore.getInstance(KeyStore.getDefaultType());
                instance.load(null, null);
                SocketFactory hVar = new h(instance);
                hVar.setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
                schemeRegistry.register(new Scheme("https", hVar, 443));
            } catch (Exception e) {
                schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
            }
        } else {
            schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        }
        HttpParams basicHttpParams = new BasicHttpParams();
        m a2 = context != null ? m.a(context, str) : null;
        if (a2 != null) {
            a = a2.a("Common_HttpConnectionTimeout");
            i = a2.a("Common_SocketConnectionTimeout");
        } else {
            a = 0;
        }
        if (a == 0) {
            a = 15000;
        }
        if (i == 0) {
            i = 30000;
        }
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, a);
        HttpConnectionParams.setSoTimeout(basicHttpParams, i);
        HttpProtocolParams.setVersion(basicHttpParams, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setContentCharset(basicHttpParams, "UTF-8");
        HttpProtocolParams.setUserAgent(basicHttpParams, "AndroidSDK_" + VERSION.SDK + "_" + Build.DEVICE + "_" + VERSION.RELEASE);
        HttpClient defaultHttpClient = new DefaultHttpClient(new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry), basicHttpParams);
        k a3 = a(context);
        if (a3 != null) {
            defaultHttpClient.getParams().setParameter("http.route.default-proxy", new HttpHost(a3.a, a3.b));
        }
        return defaultHttpClient;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.json.JSONObject a(com.tencent.connect.b.c r20, android.content.Context r21, java.lang.String r22, android.os.Bundle r23, java.lang.String r24) {
        /*
        r4 = "openSDK_LOG.HttpUtils";
        r5 = "OpenApi request";
        com.tencent.open.a.j.a(r4, r5);
        r4 = r22.toLowerCase();
        r5 = "http";
        r4 = r4.startsWith(r5);
        if (r4 != 0) goto L_0x01d2;
    L_0x0016:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = com.tencent.open.d.o.a();
        r6 = "https://openmobile.qq.com/";
        r0 = r21;
        r5 = r5.a(r0, r6);
        r4 = r4.append(r5);
        r0 = r22;
        r4 = r4.append(r0);
        r4 = r4.toString();
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = com.tencent.open.d.o.a();
        r7 = "https://openmobile.qq.com/";
        r0 = r21;
        r6 = r6.a(r0, r7);
        r5 = r5.append(r6);
        r0 = r22;
        r5 = r5.append(r0);
        r5 = r5.toString();
    L_0x0056:
        r0 = r21;
        r1 = r20;
        r2 = r22;
        a(r0, r1, r2);
        r10 = 0;
        r8 = android.os.SystemClock.elapsedRealtime();
        r7 = 0;
        r6 = r20.b();
        r0 = r21;
        r6 = com.tencent.open.d.m.a(r0, r6);
        r11 = "Common_HttpRetryCount";
        r6 = r6.a(r11);
        r11 = "OpenConfig_test";
        r12 = new java.lang.StringBuilder;
        r12.<init>();
        r13 = "config 1:Common_HttpRetryCount            config_value:";
        r12 = r12.append(r13);
        r12 = r12.append(r6);
        r13 = "   appid:";
        r12 = r12.append(r13);
        r13 = r20.b();
        r12 = r12.append(r13);
        r13 = "     url:";
        r12 = r12.append(r13);
        r12 = r12.append(r5);
        r12 = r12.toString();
        com.tencent.open.a.j.a(r11, r12);
        if (r6 != 0) goto L_0x010e;
    L_0x00ac:
        r6 = 3;
        r13 = r6;
    L_0x00ae:
        r6 = "OpenConfig_test";
        r11 = new java.lang.StringBuilder;
        r11.<init>();
        r12 = "config 1:Common_HttpRetryCount            result_value:";
        r11 = r11.append(r12);
        r11 = r11.append(r13);
        r12 = "   appid:";
        r11 = r11.append(r12);
        r12 = r20.b();
        r11 = r11.append(r12);
        r12 = "     url:";
        r11 = r11.append(r12);
        r11 = r11.append(r5);
        r11 = r11.toString();
        com.tencent.open.a.j.a(r6, r11);
        r18 = r7;
        r6 = r8;
        r8 = r18;
        r9 = r10;
    L_0x00e8:
        r14 = r8 + 1;
        r0 = r21;
        r1 = r24;
        r2 = r23;
        r10 = a(r0, r4, r1, r2);	 Catch:{ ConnectTimeoutException -> 0x01c8, SocketTimeoutException -> 0x01c2, i -> 0x015a, l -> 0x0184, MalformedURLException -> 0x0189, IOException -> 0x019b, JSONException -> 0x01b0 }
        r8 = r10.a;	 Catch:{ ConnectTimeoutException -> 0x01c8, SocketTimeoutException -> 0x01c2, i -> 0x015a, l -> 0x0184, MalformedURLException -> 0x0189, IOException -> 0x019b, JSONException -> 0x01b0 }
        r15 = com.tencent.open.d.u.c(r8);	 Catch:{ ConnectTimeoutException -> 0x01c8, SocketTimeoutException -> 0x01c2, i -> 0x015a, l -> 0x0184, MalformedURLException -> 0x0189, IOException -> 0x019b, JSONException -> 0x01b0 }
        r8 = "ret";
        r12 = r15.getInt(r8);	 Catch:{ JSONException -> 0x0110, ConnectTimeoutException -> 0x0113, SocketTimeoutException -> 0x0139, i -> 0x015a, l -> 0x0184, MalformedURLException -> 0x0189, IOException -> 0x019b }
    L_0x0101:
        r8 = r10.b;	 Catch:{ ConnectTimeoutException -> 0x0113, SocketTimeoutException -> 0x0139, i -> 0x015a, l -> 0x0184, MalformedURLException -> 0x0189, IOException -> 0x019b, JSONException -> 0x01b0 }
        r10 = r10.c;	 Catch:{ ConnectTimeoutException -> 0x0113, SocketTimeoutException -> 0x0139, i -> 0x015a, l -> 0x0184, MalformedURLException -> 0x0189, IOException -> 0x019b, JSONException -> 0x01b0 }
        r13 = r15;
    L_0x0106:
        r4 = com.tencent.open.b.g.a();
        r4.a(r5, r6, r8, r10, r12);
        return r13;
    L_0x010e:
        r13 = r6;
        goto L_0x00ae;
    L_0x0110:
        r8 = move-exception;
        r12 = -4;
        goto L_0x0101;
    L_0x0113:
        r8 = move-exception;
        r16 = r15;
        r15 = r8;
    L_0x0117:
        r15.printStackTrace();
        r12 = -7;
        r8 = 0;
        r10 = 0;
        if (r14 >= r13) goto L_0x0131;
    L_0x0121:
        r6 = android.os.SystemClock.elapsedRealtime();
        r18 = r8;
        r8 = r16;
        r16 = r18;
    L_0x012b:
        if (r14 < r13) goto L_0x01ce;
    L_0x012d:
        r13 = r8;
        r8 = r16;
        goto L_0x0106;
    L_0x0131:
        r4 = com.tencent.open.b.g.a();
        r4.a(r5, r6, r8, r10, r12);
        throw r15;
    L_0x0139:
        r8 = move-exception;
        r16 = r15;
        r15 = r8;
    L_0x013d:
        r15.printStackTrace();
        r12 = -8;
        r8 = 0;
        r10 = 0;
        if (r14 >= r13) goto L_0x0152;
    L_0x0147:
        r6 = android.os.SystemClock.elapsedRealtime();
        r18 = r8;
        r8 = r16;
        r16 = r18;
        goto L_0x012b;
    L_0x0152:
        r4 = com.tencent.open.b.g.a();
        r4.a(r5, r6, r8, r10, r12);
        throw r15;
    L_0x015a:
        r4 = move-exception;
        r13 = r4;
        r13.printStackTrace();
        r4 = r13.getMessage();
        r8 = "http status code error:";
        r9 = "";
        r4 = r4.replace(r8, r9);	 Catch:{ Exception -> 0x017d }
        r12 = java.lang.Integer.parseInt(r4);	 Catch:{ Exception -> 0x017d }
    L_0x0171:
        r8 = 0;
        r10 = 0;
        r4 = com.tencent.open.b.g.a();
        r4.a(r5, r6, r8, r10, r12);
        throw r13;
    L_0x017d:
        r4 = move-exception;
        r4.printStackTrace();
        r12 = -9;
        goto L_0x0171;
    L_0x0184:
        r4 = move-exception;
        r4.printStackTrace();
        throw r4;
    L_0x0189:
        r4 = move-exception;
        r13 = r4;
        r13.printStackTrace();
        r12 = -3;
        r8 = 0;
        r10 = 0;
        r4 = com.tencent.open.b.g.a();
        r4.a(r5, r6, r8, r10, r12);
        throw r13;
    L_0x019b:
        r4 = move-exception;
        r13 = r4;
        r13.printStackTrace();
        r12 = a(r13);
        r8 = 0;
        r10 = 0;
        r4 = com.tencent.open.b.g.a();
        r4.a(r5, r6, r8, r10, r12);
        throw r13;
    L_0x01b0:
        r4 = move-exception;
        r13 = r4;
        r13.printStackTrace();
        r12 = -4;
        r8 = 0;
        r10 = 0;
        r4 = com.tencent.open.b.g.a();
        r4.a(r5, r6, r8, r10, r12);
        throw r13;
    L_0x01c2:
        r8 = move-exception;
        r15 = r8;
        r16 = r9;
        goto L_0x013d;
    L_0x01c8:
        r8 = move-exception;
        r15 = r8;
        r16 = r9;
        goto L_0x0117;
    L_0x01ce:
        r9 = r8;
        r8 = r14;
        goto L_0x00e8;
    L_0x01d2:
        r5 = r22;
        r4 = r22;
        goto L_0x0056;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.d.f.a(com.tencent.connect.b.c, android.content.Context, java.lang.String, android.os.Bundle, java.lang.String):org.json.JSONObject");
    }

    private static void a(Context context, c cVar, String str) {
        if (str.indexOf("add_share") > -1 || str.indexOf("upload_pic") > -1 || str.indexOf("add_topic") > -1 || str.indexOf("set_user_face") > -1 || str.indexOf("add_t") > -1 || str.indexOf("add_pic_t") > -1 || str.indexOf("add_pic_url") > -1 || str.indexOf("add_video") > -1) {
            a.a(context, cVar, "requireApi", str);
        }
    }

    private static int b(Context context) {
        int i = -1;
        if (VERSION.SDK_INT >= 11) {
            Object property = System.getProperty("http.proxyPort");
            if (TextUtils.isEmpty(property)) {
                return i;
            }
            try {
                return Integer.parseInt(property);
            } catch (NumberFormatException e) {
                return i;
            }
        } else if (context == null) {
            return Proxy.getDefaultPort();
        } else {
            i = Proxy.getPort(context);
            return i < 0 ? Proxy.getDefaultPort() : i;
        }
    }

    private static String c(Context context) {
        if (VERSION.SDK_INT >= 11) {
            return System.getProperty("http.proxyHost");
        }
        if (context == null) {
            return Proxy.getDefaultHost();
        }
        Object host = Proxy.getHost(context);
        return TextUtils.isEmpty(host) ? Proxy.getDefaultHost() : host;
    }
}
