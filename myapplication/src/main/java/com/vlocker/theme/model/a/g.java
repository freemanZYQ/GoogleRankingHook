package com.vlocker.theme.model.a;

import com.vlocker.theme.model.i;
import java.util.HashMap;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
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
import org.apache.http.protocol.SyncBasicHttpContext;

public class g {
    private static int e = 10;
    private static int f = 10000;
    private static int g = 5;
    private static int h = 3;
    public boolean a = false;
    i b = null;
    private final String c = "Http";
    private long d = 0;
    private String i = "utf-8";
    private boolean j = false;
    private SyncBasicHttpContext k;
    private DefaultHttpClient l;
    private HashMap m;
    private HttpResponse n;
    private int o;

    public g() {
        a();
    }

    public static byte[] a(byte[] bArr, int i, byte[] bArr2, int i2) {
        int i3 = 0;
        byte[] bArr3 = new byte[(i + i2)];
        for (int i4 = 0; i4 < i; i4++) {
            bArr3[i4] = bArr[i4];
        }
        while (i3 < i2) {
            bArr3[i + i3] = bArr2[i3];
            i3++;
        }
        return bArr3;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long a(java.lang.String r21, java.lang.String r22, com.vlocker.theme.model.i r23, com.vlocker.theme.model.T_ThemeItemInfo r24) {
        /*
        r20 = this;
        if (r22 == 0) goto L_0x03e4;
    L_0x0002:
        r0 = r23;
        r1 = r20;
        r1.b = r0;
        r2 = 0;
        r0 = r20;
        r0.a = r2;
        r5 = 0;
        r2 = 0;
        r13 = new java.io.File;
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r0 = r21;
        r3 = r3.append(r0);
        r4 = ".tmp";
        r3 = r3.append(r4);
        r3 = r3.toString();
        r13.<init>(r3);
        r3 = r13.createNewFile();	 Catch:{ IOException -> 0x0105 }
        if (r3 == 0) goto L_0x00fe;
    L_0x0030:
        r2 = 0;
    L_0x0031:
        r3 = 1;
        r0 = r20;
        r4 = r0.l;
        r16 = r4.getHttpRequestRetryHandler();
        r4 = r2;
        r2 = r3;
    L_0x003c:
        if (r2 == 0) goto L_0x03e8;
    L_0x003e:
        r3 = 0;
        r2 = new org.apache.http.client.methods.HttpGet;	 Catch:{ UnknownHostException -> 0x01bf, IOException -> 0x0244, NullPointerException -> 0x02cb, Exception -> 0x0351, all -> 0x0417 }
        r0 = r22;
        r2.<init>(r0);	 Catch:{ UnknownHostException -> 0x01bf, IOException -> 0x0244, NullPointerException -> 0x02cb, Exception -> 0x0351, all -> 0x0417 }
        r6 = "Range";
        r7 = new java.lang.StringBuilder;	 Catch:{ UnknownHostException -> 0x01bf, IOException -> 0x0244, NullPointerException -> 0x02cb, Exception -> 0x0351, all -> 0x0417 }
        r7.<init>();	 Catch:{ UnknownHostException -> 0x01bf, IOException -> 0x0244, NullPointerException -> 0x02cb, Exception -> 0x0351, all -> 0x0417 }
        r8 = "bytes=";
        r7 = r7.append(r8);	 Catch:{ UnknownHostException -> 0x01bf, IOException -> 0x0244, NullPointerException -> 0x02cb, Exception -> 0x0351, all -> 0x0417 }
        r7 = r7.append(r4);	 Catch:{ UnknownHostException -> 0x01bf, IOException -> 0x0244, NullPointerException -> 0x02cb, Exception -> 0x0351, all -> 0x0417 }
        r8 = "-";
        r7 = r7.append(r8);	 Catch:{ UnknownHostException -> 0x01bf, IOException -> 0x0244, NullPointerException -> 0x02cb, Exception -> 0x0351, all -> 0x0417 }
        r7 = r7.toString();	 Catch:{ UnknownHostException -> 0x01bf, IOException -> 0x0244, NullPointerException -> 0x02cb, Exception -> 0x0351, all -> 0x0417 }
        r2.addHeader(r6, r7);	 Catch:{ UnknownHostException -> 0x01bf, IOException -> 0x0244, NullPointerException -> 0x02cb, Exception -> 0x0351, all -> 0x0417 }
        r0 = r20;
        r6 = r0.l;	 Catch:{ UnknownHostException -> 0x01bf, IOException -> 0x0244, NullPointerException -> 0x02cb, Exception -> 0x0351, all -> 0x0417 }
        r2 = r6.execute(r2);	 Catch:{ UnknownHostException -> 0x01bf, IOException -> 0x0244, NullPointerException -> 0x02cb, Exception -> 0x0351, all -> 0x0417 }
        r0 = r20;
        r0.n = r2;	 Catch:{ UnknownHostException -> 0x01bf, IOException -> 0x0244, NullPointerException -> 0x02cb, Exception -> 0x0351, all -> 0x0417 }
        r0 = r20;
        r2 = r0.n;	 Catch:{ UnknownHostException -> 0x01bf, IOException -> 0x0244, NullPointerException -> 0x02cb, Exception -> 0x0351, all -> 0x0417 }
        r6 = r2.getEntity();	 Catch:{ UnknownHostException -> 0x01bf, IOException -> 0x0244, NullPointerException -> 0x02cb, Exception -> 0x0351, all -> 0x0417 }
        r10 = r6.getContent();	 Catch:{ UnknownHostException -> 0x01bf, IOException -> 0x0244, NullPointerException -> 0x02cb, Exception -> 0x0351, all -> 0x0417 }
        r12 = new java.io.RandomAccessFile;	 Catch:{ UnknownHostException -> 0x0466, IOException -> 0x044f, NullPointerException -> 0x0438, Exception -> 0x0421, all -> 0x041b }
        r2 = "rwd";
        r12.<init>(r13, r2);	 Catch:{ UnknownHostException -> 0x0466, IOException -> 0x044f, NullPointerException -> 0x0438, Exception -> 0x0421, all -> 0x041b }
        r2 = (long) r4;
        r12.seek(r2);	 Catch:{ UnknownHostException -> 0x046d, IOException -> 0x0455, NullPointerException -> 0x043e, Exception -> 0x0427, all -> 0x041e }
        r2 = 0;
        r6 = r6.getContentLength();	 Catch:{ UnknownHostException -> 0x046d, IOException -> 0x0455, NullPointerException -> 0x043e, Exception -> 0x0427, all -> 0x041e }
        r0 = r20;
        r0.d = r6;	 Catch:{ UnknownHostException -> 0x046d, IOException -> 0x0455, NullPointerException -> 0x043e, Exception -> 0x0427, all -> 0x041e }
        r0 = r20;
        r5 = r0.n;	 Catch:{ UnknownHostException -> 0x046d, IOException -> 0x0455, NullPointerException -> 0x043e, Exception -> 0x0427, all -> 0x041e }
        r5 = r5.getStatusLine();	 Catch:{ UnknownHostException -> 0x046d, IOException -> 0x0455, NullPointerException -> 0x043e, Exception -> 0x0427, all -> 0x041e }
        r5 = r5.getStatusCode();	 Catch:{ UnknownHostException -> 0x046d, IOException -> 0x0455, NullPointerException -> 0x043e, Exception -> 0x0427, all -> 0x041e }
        switch(r5) {
            case 200: goto L_0x010b;
            case 206: goto L_0x015d;
            default: goto L_0x00a4;
        };	 Catch:{ UnknownHostException -> 0x046d, IOException -> 0x0455, NullPointerException -> 0x043e, Exception -> 0x0427, all -> 0x041e }
    L_0x00a4:
        r6 = 8;
        r6 = com.vlocker.b.j.a(r6);	 Catch:{ UnknownHostException -> 0x046d, IOException -> 0x0455, NullPointerException -> 0x043e, Exception -> 0x0427, all -> 0x041e }
        r7 = com.vlocker.theme.f.e.a;	 Catch:{ UnknownHostException -> 0x046d, IOException -> 0x0455, NullPointerException -> 0x043e, Exception -> 0x0427, all -> 0x041e }
        r8 = new java.lang.StringBuilder;	 Catch:{ UnknownHostException -> 0x046d, IOException -> 0x0455, NullPointerException -> 0x043e, Exception -> 0x0427, all -> 0x041e }
        r8.<init>();	 Catch:{ UnknownHostException -> 0x046d, IOException -> 0x0455, NullPointerException -> 0x043e, Exception -> 0x0427, all -> 0x041e }
        r5 = r8.append(r5);	 Catch:{ UnknownHostException -> 0x046d, IOException -> 0x0455, NullPointerException -> 0x043e, Exception -> 0x0427, all -> 0x041e }
        r0 = r22;
        r5 = r5.append(r0);	 Catch:{ UnknownHostException -> 0x046d, IOException -> 0x0455, NullPointerException -> 0x043e, Exception -> 0x0427, all -> 0x041e }
        r5 = r5.toString();	 Catch:{ UnknownHostException -> 0x046d, IOException -> 0x0455, NullPointerException -> 0x043e, Exception -> 0x0427, all -> 0x041e }
        r0 = r20;
        r1 = r24;
        r0.a(r1, r6, r7, r5);	 Catch:{ UnknownHostException -> 0x046d, IOException -> 0x0455, NullPointerException -> 0x043e, Exception -> 0x0427, all -> 0x041e }
    L_0x00c6:
        r0 = r20;
        r5 = r0.a;	 Catch:{ UnknownHostException -> 0x046d, IOException -> 0x0455, NullPointerException -> 0x043e, Exception -> 0x0427, all -> 0x041e }
        if (r5 != 0) goto L_0x01ae;
    L_0x00cc:
        r5 = new java.io.File;	 Catch:{ UnknownHostException -> 0x046d, IOException -> 0x0455, NullPointerException -> 0x043e, Exception -> 0x0427, all -> 0x041e }
        r6 = new java.lang.StringBuilder;	 Catch:{ UnknownHostException -> 0x046d, IOException -> 0x0455, NullPointerException -> 0x043e, Exception -> 0x0427, all -> 0x041e }
        r6.<init>();	 Catch:{ UnknownHostException -> 0x046d, IOException -> 0x0455, NullPointerException -> 0x043e, Exception -> 0x0427, all -> 0x041e }
        r0 = r21;
        r6 = r6.append(r0);	 Catch:{ UnknownHostException -> 0x046d, IOException -> 0x0455, NullPointerException -> 0x043e, Exception -> 0x0427, all -> 0x041e }
        r7 = ".mx";
        r6 = r6.append(r7);	 Catch:{ UnknownHostException -> 0x046d, IOException -> 0x0455, NullPointerException -> 0x043e, Exception -> 0x0427, all -> 0x041e }
        r6 = r6.toString();	 Catch:{ UnknownHostException -> 0x046d, IOException -> 0x0455, NullPointerException -> 0x043e, Exception -> 0x0427, all -> 0x041e }
        r5.<init>(r6);	 Catch:{ UnknownHostException -> 0x046d, IOException -> 0x0455, NullPointerException -> 0x043e, Exception -> 0x0427, all -> 0x041e }
        r6 = r5.exists();	 Catch:{ UnknownHostException -> 0x046d, IOException -> 0x0455, NullPointerException -> 0x043e, Exception -> 0x0427, all -> 0x041e }
        if (r6 == 0) goto L_0x00f0;
    L_0x00ed:
        r5.delete();	 Catch:{ UnknownHostException -> 0x046d, IOException -> 0x0455, NullPointerException -> 0x043e, Exception -> 0x0427, all -> 0x041e }
    L_0x00f0:
        r13.renameTo(r5);	 Catch:{ UnknownHostException -> 0x046d, IOException -> 0x0455, NullPointerException -> 0x043e, Exception -> 0x0427, all -> 0x041e }
        if (r10 == 0) goto L_0x00f8;
    L_0x00f5:
        r10.close();	 Catch:{ Exception -> 0x03ec }
    L_0x00f8:
        if (r12 == 0) goto L_0x00fd;
    L_0x00fa:
        r12.close();	 Catch:{ Exception -> 0x03ef }
    L_0x00fd:
        return r2;
    L_0x00fe:
        r2 = r13.length();	 Catch:{ IOException -> 0x0105 }
        r2 = (int) r2;
        goto L_0x0031;
    L_0x0105:
        r3 = move-exception;
        r3.printStackTrace();
        goto L_0x0031;
    L_0x010b:
        r5 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;
        r0 = new byte[r5];	 Catch:{ UnknownHostException -> 0x046d, IOException -> 0x0455, NullPointerException -> 0x043e, Exception -> 0x0427, all -> 0x041e }
        r17 = r0;
        r18 = r2;
        r3 = r4;
        r4 = r18;
    L_0x0116:
        r2 = -1;
        r0 = r17;
        r6 = r10.read(r0);	 Catch:{ UnknownHostException -> 0x0474, IOException -> 0x045b, NullPointerException -> 0x0444, Exception -> 0x042d, all -> 0x041e }
        if (r2 == r6) goto L_0x048c;
    L_0x011f:
        r2 = 0;
        r0 = r17;
        r12.write(r0, r2, r6);	 Catch:{ UnknownHostException -> 0x0474, IOException -> 0x045b, NullPointerException -> 0x0444, Exception -> 0x042d, all -> 0x041e }
        r11 = r3 + r6;
        r2 = (long) r11;
        r12.seek(r2);	 Catch:{ UnknownHostException -> 0x047a, IOException -> 0x0460, NullPointerException -> 0x0449, Exception -> 0x0432, all -> 0x041e }
        r2 = (long) r6;	 Catch:{ UnknownHostException -> 0x047a, IOException -> 0x0460, NullPointerException -> 0x0449, Exception -> 0x0432, all -> 0x041e }
        r14 = r4 + r2;
        r0 = r20;
        r3 = r0.b;	 Catch:{ UnknownHostException -> 0x047a, IOException -> 0x0460, NullPointerException -> 0x0449, Exception -> 0x0432, all -> 0x041e }
        r4 = (long) r11;	 Catch:{ UnknownHostException -> 0x047a, IOException -> 0x0460, NullPointerException -> 0x0449, Exception -> 0x0432, all -> 0x041e }
        r4 = r4 + r14;
        r0 = r20;
        r6 = r0.d;	 Catch:{ UnknownHostException -> 0x047a, IOException -> 0x0460, NullPointerException -> 0x0449, Exception -> 0x0432, all -> 0x041e }
        r8 = 0;
        r9 = r24;
        r3.a(r4, r6, r8, r9);	 Catch:{ UnknownHostException -> 0x047a, IOException -> 0x0460, NullPointerException -> 0x0449, Exception -> 0x0432, all -> 0x041e }
        r0 = r20;
        r2 = r0.a;	 Catch:{ UnknownHostException -> 0x047a, IOException -> 0x0460, NullPointerException -> 0x0449, Exception -> 0x0432, all -> 0x041e }
        if (r2 == 0) goto L_0x0488;
    L_0x0144:
        r4 = r14;
    L_0x0145:
        r0 = r20;
        r2 = r0.a;	 Catch:{ UnknownHostException -> 0x047a, IOException -> 0x0460, NullPointerException -> 0x0449, Exception -> 0x0432, all -> 0x041e }
        if (r2 != 0) goto L_0x0159;
    L_0x014b:
        r0 = r20;
        r3 = r0.b;	 Catch:{ UnknownHostException -> 0x047a, IOException -> 0x0460, NullPointerException -> 0x0449, Exception -> 0x0432, all -> 0x041e }
        r0 = r20;
        r6 = r0.d;	 Catch:{ UnknownHostException -> 0x047a, IOException -> 0x0460, NullPointerException -> 0x0449, Exception -> 0x0432, all -> 0x041e }
        r8 = 1;
        r9 = r24;
        r3.a(r4, r6, r8, r9);	 Catch:{ UnknownHostException -> 0x047a, IOException -> 0x0460, NullPointerException -> 0x0449, Exception -> 0x0432, all -> 0x041e }
    L_0x0159:
        r2 = r4;
        r4 = r11;
        goto L_0x00c6;
    L_0x015d:
        r5 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;
        r0 = new byte[r5];	 Catch:{ UnknownHostException -> 0x046d, IOException -> 0x0455, NullPointerException -> 0x043e, Exception -> 0x0427, all -> 0x041e }
        r17 = r0;
        r18 = r2;
        r3 = r4;
        r4 = r18;
    L_0x0168:
        r2 = -1;
        r0 = r17;
        r6 = r10.read(r0);	 Catch:{ UnknownHostException -> 0x0474, IOException -> 0x045b, NullPointerException -> 0x0444, Exception -> 0x042d, all -> 0x041e }
        if (r2 == r6) goto L_0x0485;
    L_0x0171:
        r2 = 0;
        r0 = r17;
        r12.write(r0, r2, r6);	 Catch:{ UnknownHostException -> 0x0474, IOException -> 0x045b, NullPointerException -> 0x0444, Exception -> 0x042d, all -> 0x041e }
        r11 = r3 + r6;
        r2 = (long) r11;
        r12.seek(r2);	 Catch:{ UnknownHostException -> 0x047a, IOException -> 0x0460, NullPointerException -> 0x0449, Exception -> 0x0432, all -> 0x041e }
        r2 = (long) r6;	 Catch:{ UnknownHostException -> 0x047a, IOException -> 0x0460, NullPointerException -> 0x0449, Exception -> 0x0432, all -> 0x041e }
        r14 = r4 + r2;
        r0 = r20;
        r3 = r0.b;	 Catch:{ UnknownHostException -> 0x047a, IOException -> 0x0460, NullPointerException -> 0x0449, Exception -> 0x0432, all -> 0x041e }
        r4 = (long) r11;	 Catch:{ UnknownHostException -> 0x047a, IOException -> 0x0460, NullPointerException -> 0x0449, Exception -> 0x0432, all -> 0x041e }
        r0 = r20;
        r6 = r0.d;	 Catch:{ UnknownHostException -> 0x047a, IOException -> 0x0460, NullPointerException -> 0x0449, Exception -> 0x0432, all -> 0x041e }
        r8 = 0;
        r9 = r24;
        r3.a(r4, r6, r8, r9);	 Catch:{ UnknownHostException -> 0x047a, IOException -> 0x0460, NullPointerException -> 0x0449, Exception -> 0x0432, all -> 0x041e }
        r0 = r20;
        r2 = r0.a;	 Catch:{ UnknownHostException -> 0x047a, IOException -> 0x0460, NullPointerException -> 0x0449, Exception -> 0x0432, all -> 0x041e }
        if (r2 == 0) goto L_0x0481;
    L_0x0195:
        r4 = r14;
    L_0x0196:
        r0 = r20;
        r2 = r0.a;	 Catch:{ UnknownHostException -> 0x047a, IOException -> 0x0460, NullPointerException -> 0x0449, Exception -> 0x0432, all -> 0x041e }
        if (r2 != 0) goto L_0x01aa;
    L_0x019c:
        r0 = r20;
        r3 = r0.b;	 Catch:{ UnknownHostException -> 0x047a, IOException -> 0x0460, NullPointerException -> 0x0449, Exception -> 0x0432, all -> 0x041e }
        r0 = r20;
        r6 = r0.d;	 Catch:{ UnknownHostException -> 0x047a, IOException -> 0x0460, NullPointerException -> 0x0449, Exception -> 0x0432, all -> 0x041e }
        r8 = 1;
        r9 = r24;
        r3.a(r4, r6, r8, r9);	 Catch:{ UnknownHostException -> 0x047a, IOException -> 0x0460, NullPointerException -> 0x0449, Exception -> 0x0432, all -> 0x041e }
    L_0x01aa:
        r2 = r4;
        r4 = r11;
        goto L_0x00c6;
    L_0x01ae:
        r2 = -2;
        if (r10 == 0) goto L_0x01b5;
    L_0x01b2:
        r10.close();	 Catch:{ Exception -> 0x03f2 }
    L_0x01b5:
        if (r12 == 0) goto L_0x00fd;
    L_0x01b7:
        r12.close();	 Catch:{ Exception -> 0x01bc }
        goto L_0x00fd;
    L_0x01bc:
        r4 = move-exception;
        goto L_0x00fd;
    L_0x01bf:
        r2 = move-exception;
        r6 = r3;
        r3 = r4;
        r4 = r5;
        r5 = r2;
    L_0x01c4:
        r2 = new java.io.IOException;	 Catch:{ all -> 0x03d7 }
        r7 = new java.lang.StringBuilder;	 Catch:{ all -> 0x03d7 }
        r7.<init>();	 Catch:{ all -> 0x03d7 }
        r8 = "NPE in HttpClient";
        r7 = r7.append(r8);	 Catch:{ all -> 0x03d7 }
        r8 = r5.getMessage();	 Catch:{ all -> 0x03d7 }
        r7 = r7.append(r8);	 Catch:{ all -> 0x03d7 }
        r7 = r7.toString();	 Catch:{ all -> 0x03d7 }
        r2.<init>(r7);	 Catch:{ all -> 0x03d7 }
        r0 = r20;
        r7 = r0.o;	 Catch:{ all -> 0x03d7 }
        r7 = r7 + 1;
        r0 = r20;
        r0.o = r7;	 Catch:{ all -> 0x03d7 }
        r0 = r20;
        r8 = r0.k;	 Catch:{ all -> 0x03d7 }
        r0 = r16;
        r2 = r0.retryRequest(r2, r7, r8);	 Catch:{ all -> 0x03d7 }
        if (r2 != 0) goto L_0x0236;
    L_0x01f7:
        r2 = 8;
        r2 = com.vlocker.b.j.a(r2);	 Catch:{ all -> 0x03d7 }
        r3 = com.vlocker.theme.f.e.a;	 Catch:{ all -> 0x03d7 }
        r7 = r5.toString();	 Catch:{ all -> 0x03d7 }
        r0 = r20;
        r1 = r24;
        r0.a(r1, r2, r3, r7);	 Catch:{ all -> 0x03d7 }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x03d7 }
        r2.<init>();	 Catch:{ all -> 0x03d7 }
        r3 = "======down=====";
        r2 = r2.append(r3);	 Catch:{ all -> 0x03d7 }
        r3 = r24.a();	 Catch:{ all -> 0x03d7 }
        r2 = r2.append(r3);	 Catch:{ all -> 0x03d7 }
        r2 = r2.toString();	 Catch:{ all -> 0x03d7 }
        com.vlocker.theme.d.b.a.a(r5, r2);	 Catch:{ all -> 0x03d7 }
        r2 = -4;
        if (r6 == 0) goto L_0x022c;
    L_0x0229:
        r6.close();	 Catch:{ Exception -> 0x03f5 }
    L_0x022c:
        if (r4 == 0) goto L_0x00fd;
    L_0x022e:
        r4.close();	 Catch:{ Exception -> 0x0233 }
        goto L_0x00fd;
    L_0x0233:
        r4 = move-exception;
        goto L_0x00fd;
    L_0x0236:
        if (r6 == 0) goto L_0x023b;
    L_0x0238:
        r6.close();	 Catch:{ Exception -> 0x03f8 }
    L_0x023b:
        if (r4 == 0) goto L_0x0240;
    L_0x023d:
        r4.close();	 Catch:{ Exception -> 0x03fb }
    L_0x0240:
        r5 = r4;
        r4 = r3;
        goto L_0x003c;
    L_0x0244:
        r2 = move-exception;
        r10 = r3;
        r3 = r4;
        r4 = r5;
        r5 = r2;
    L_0x0249:
        r0 = r20;
        r2 = r0.o;	 Catch:{ all -> 0x0415 }
        r2 = r2 + 1;
        r0 = r20;
        r0.o = r2;	 Catch:{ all -> 0x0415 }
        r0 = r20;
        r6 = r0.k;	 Catch:{ all -> 0x0415 }
        r0 = r16;
        r2 = r0.retryRequest(r5, r2, r6);	 Catch:{ all -> 0x0415 }
        if (r2 != 0) goto L_0x029e;
    L_0x025f:
        r2 = 8;
        r2 = com.vlocker.b.j.a(r2);	 Catch:{ all -> 0x0415 }
        r3 = com.vlocker.theme.f.e.a;	 Catch:{ all -> 0x0415 }
        r6 = r5.toString();	 Catch:{ all -> 0x0415 }
        r0 = r20;
        r1 = r24;
        r0.a(r1, r2, r3, r6);	 Catch:{ all -> 0x0415 }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0415 }
        r2.<init>();	 Catch:{ all -> 0x0415 }
        r3 = "======down=====";
        r2 = r2.append(r3);	 Catch:{ all -> 0x0415 }
        r3 = r24.a();	 Catch:{ all -> 0x0415 }
        r2 = r2.append(r3);	 Catch:{ all -> 0x0415 }
        r2 = r2.toString();	 Catch:{ all -> 0x0415 }
        com.vlocker.theme.d.b.a.a(r5, r2);	 Catch:{ all -> 0x0415 }
        r2 = -4;
        if (r10 == 0) goto L_0x0294;
    L_0x0291:
        r10.close();	 Catch:{ Exception -> 0x03fe }
    L_0x0294:
        if (r4 == 0) goto L_0x00fd;
    L_0x0296:
        r4.close();	 Catch:{ Exception -> 0x029b }
        goto L_0x00fd;
    L_0x029b:
        r4 = move-exception;
        goto L_0x00fd;
    L_0x029e:
        r5 = r5.toString();	 Catch:{ all -> 0x0415 }
        r6 = "java.io.IOException: write failed: ENOSPC (No space left on device)";
        r5 = r5.contains(r6);	 Catch:{ all -> 0x0415 }
        if (r5 == 0) goto L_0x02bc;
    L_0x02ab:
        r2 = -3;
        if (r10 == 0) goto L_0x02b2;
    L_0x02af:
        r10.close();	 Catch:{ Exception -> 0x0401 }
    L_0x02b2:
        if (r4 == 0) goto L_0x00fd;
    L_0x02b4:
        r4.close();	 Catch:{ Exception -> 0x02b9 }
        goto L_0x00fd;
    L_0x02b9:
        r4 = move-exception;
        goto L_0x00fd;
    L_0x02bc:
        if (r10 == 0) goto L_0x02c1;
    L_0x02be:
        r10.close();	 Catch:{ Exception -> 0x0404 }
    L_0x02c1:
        if (r4 == 0) goto L_0x0240;
    L_0x02c3:
        r4.close();	 Catch:{ Exception -> 0x02c8 }
        goto L_0x0240;
    L_0x02c8:
        r5 = move-exception;
        goto L_0x0240;
    L_0x02cb:
        r2 = move-exception;
        r10 = r3;
        r3 = r4;
        r4 = r5;
        r5 = r2;
    L_0x02d0:
        r2 = new java.io.IOException;	 Catch:{ all -> 0x0415 }
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0415 }
        r6.<init>();	 Catch:{ all -> 0x0415 }
        r7 = "NPE in HttpClient";
        r6 = r6.append(r7);	 Catch:{ all -> 0x0415 }
        r7 = r5.getMessage();	 Catch:{ all -> 0x0415 }
        r6 = r6.append(r7);	 Catch:{ all -> 0x0415 }
        r6 = r6.toString();	 Catch:{ all -> 0x0415 }
        r2.<init>(r6);	 Catch:{ all -> 0x0415 }
        r0 = r20;
        r6 = r0.o;	 Catch:{ all -> 0x0415 }
        r6 = r6 + 1;
        r0 = r20;
        r0.o = r6;	 Catch:{ all -> 0x0415 }
        r0 = r20;
        r7 = r0.k;	 Catch:{ all -> 0x0415 }
        r0 = r16;
        r2 = r0.retryRequest(r2, r6, r7);	 Catch:{ all -> 0x0415 }
        if (r2 != 0) goto L_0x0342;
    L_0x0303:
        r2 = 8;
        r2 = com.vlocker.b.j.a(r2);	 Catch:{ all -> 0x0415 }
        r3 = com.vlocker.theme.f.e.a;	 Catch:{ all -> 0x0415 }
        r6 = r5.toString();	 Catch:{ all -> 0x0415 }
        r0 = r20;
        r1 = r24;
        r0.a(r1, r2, r3, r6);	 Catch:{ all -> 0x0415 }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0415 }
        r2.<init>();	 Catch:{ all -> 0x0415 }
        r3 = "======down=====";
        r2 = r2.append(r3);	 Catch:{ all -> 0x0415 }
        r3 = r24.a();	 Catch:{ all -> 0x0415 }
        r2 = r2.append(r3);	 Catch:{ all -> 0x0415 }
        r2 = r2.toString();	 Catch:{ all -> 0x0415 }
        com.vlocker.theme.d.b.a.a(r5, r2);	 Catch:{ all -> 0x0415 }
        r2 = -4;
        if (r10 == 0) goto L_0x0338;
    L_0x0335:
        r10.close();	 Catch:{ Exception -> 0x0407 }
    L_0x0338:
        if (r4 == 0) goto L_0x00fd;
    L_0x033a:
        r4.close();	 Catch:{ Exception -> 0x033f }
        goto L_0x00fd;
    L_0x033f:
        r4 = move-exception;
        goto L_0x00fd;
    L_0x0342:
        if (r10 == 0) goto L_0x0347;
    L_0x0344:
        r10.close();	 Catch:{ Exception -> 0x040a }
    L_0x0347:
        if (r4 == 0) goto L_0x0240;
    L_0x0349:
        r4.close();	 Catch:{ Exception -> 0x034e }
        goto L_0x0240;
    L_0x034e:
        r5 = move-exception;
        goto L_0x0240;
    L_0x0351:
        r2 = move-exception;
        r10 = r3;
        r3 = r4;
        r4 = r5;
        r5 = r2;
    L_0x0356:
        r2 = new java.io.IOException;	 Catch:{ all -> 0x0415 }
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0415 }
        r6.<init>();	 Catch:{ all -> 0x0415 }
        r7 = "Exception";
        r6 = r6.append(r7);	 Catch:{ all -> 0x0415 }
        r7 = r5.getMessage();	 Catch:{ all -> 0x0415 }
        r6 = r6.append(r7);	 Catch:{ all -> 0x0415 }
        r6 = r6.toString();	 Catch:{ all -> 0x0415 }
        r2.<init>(r6);	 Catch:{ all -> 0x0415 }
        r0 = r20;
        r6 = r0.o;	 Catch:{ all -> 0x0415 }
        r6 = r6 + 1;
        r0 = r20;
        r0.o = r6;	 Catch:{ all -> 0x0415 }
        r0 = r20;
        r7 = r0.k;	 Catch:{ all -> 0x0415 }
        r0 = r16;
        r2 = r0.retryRequest(r2, r6, r7);	 Catch:{ all -> 0x0415 }
        if (r2 != 0) goto L_0x03c8;
    L_0x0389:
        r2 = 8;
        r2 = com.vlocker.b.j.a(r2);	 Catch:{ all -> 0x0415 }
        r3 = com.vlocker.theme.f.e.a;	 Catch:{ all -> 0x0415 }
        r6 = r5.toString();	 Catch:{ all -> 0x0415 }
        r0 = r20;
        r1 = r24;
        r0.a(r1, r2, r3, r6);	 Catch:{ all -> 0x0415 }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0415 }
        r2.<init>();	 Catch:{ all -> 0x0415 }
        r3 = "======down=====";
        r2 = r2.append(r3);	 Catch:{ all -> 0x0415 }
        r3 = r24.a();	 Catch:{ all -> 0x0415 }
        r2 = r2.append(r3);	 Catch:{ all -> 0x0415 }
        r2 = r2.toString();	 Catch:{ all -> 0x0415 }
        com.vlocker.theme.d.b.a.a(r5, r2);	 Catch:{ all -> 0x0415 }
        r2 = -4;
        if (r10 == 0) goto L_0x03be;
    L_0x03bb:
        r10.close();	 Catch:{ Exception -> 0x040d }
    L_0x03be:
        if (r4 == 0) goto L_0x00fd;
    L_0x03c0:
        r4.close();	 Catch:{ Exception -> 0x03c5 }
        goto L_0x00fd;
    L_0x03c5:
        r4 = move-exception;
        goto L_0x00fd;
    L_0x03c8:
        if (r10 == 0) goto L_0x03cd;
    L_0x03ca:
        r10.close();	 Catch:{ Exception -> 0x040f }
    L_0x03cd:
        if (r4 == 0) goto L_0x0240;
    L_0x03cf:
        r4.close();	 Catch:{ Exception -> 0x03d4 }
        goto L_0x0240;
    L_0x03d4:
        r5 = move-exception;
        goto L_0x0240;
    L_0x03d7:
        r2 = move-exception;
        r10 = r6;
    L_0x03d9:
        if (r10 == 0) goto L_0x03de;
    L_0x03db:
        r10.close();	 Catch:{ Exception -> 0x0411 }
    L_0x03de:
        if (r4 == 0) goto L_0x03e3;
    L_0x03e0:
        r4.close();	 Catch:{ Exception -> 0x0413 }
    L_0x03e3:
        throw r2;
    L_0x03e4:
        r2 = -1;
        goto L_0x00fd;
    L_0x03e8:
        r2 = -1;
        goto L_0x00fd;
    L_0x03ec:
        r4 = move-exception;
        goto L_0x00f8;
    L_0x03ef:
        r4 = move-exception;
        goto L_0x00fd;
    L_0x03f2:
        r4 = move-exception;
        goto L_0x01b5;
    L_0x03f5:
        r5 = move-exception;
        goto L_0x022c;
    L_0x03f8:
        r5 = move-exception;
        goto L_0x023b;
    L_0x03fb:
        r5 = move-exception;
        goto L_0x0240;
    L_0x03fe:
        r5 = move-exception;
        goto L_0x0294;
    L_0x0401:
        r5 = move-exception;
        goto L_0x02b2;
    L_0x0404:
        r5 = move-exception;
        goto L_0x02c1;
    L_0x0407:
        r5 = move-exception;
        goto L_0x0338;
    L_0x040a:
        r5 = move-exception;
        goto L_0x0347;
    L_0x040d:
        r5 = move-exception;
        goto L_0x03be;
    L_0x040f:
        r5 = move-exception;
        goto L_0x03cd;
    L_0x0411:
        r3 = move-exception;
        goto L_0x03de;
    L_0x0413:
        r3 = move-exception;
        goto L_0x03e3;
    L_0x0415:
        r2 = move-exception;
        goto L_0x03d9;
    L_0x0417:
        r2 = move-exception;
        r10 = r3;
        r4 = r5;
        goto L_0x03d9;
    L_0x041b:
        r2 = move-exception;
        r4 = r5;
        goto L_0x03d9;
    L_0x041e:
        r2 = move-exception;
        r4 = r12;
        goto L_0x03d9;
    L_0x0421:
        r2 = move-exception;
        r3 = r4;
        r4 = r5;
        r5 = r2;
        goto L_0x0356;
    L_0x0427:
        r2 = move-exception;
        r5 = r2;
        r3 = r4;
        r4 = r12;
        goto L_0x0356;
    L_0x042d:
        r2 = move-exception;
        r5 = r2;
        r4 = r12;
        goto L_0x0356;
    L_0x0432:
        r2 = move-exception;
        r5 = r2;
        r3 = r11;
        r4 = r12;
        goto L_0x0356;
    L_0x0438:
        r2 = move-exception;
        r3 = r4;
        r4 = r5;
        r5 = r2;
        goto L_0x02d0;
    L_0x043e:
        r2 = move-exception;
        r5 = r2;
        r3 = r4;
        r4 = r12;
        goto L_0x02d0;
    L_0x0444:
        r2 = move-exception;
        r5 = r2;
        r4 = r12;
        goto L_0x02d0;
    L_0x0449:
        r2 = move-exception;
        r5 = r2;
        r3 = r11;
        r4 = r12;
        goto L_0x02d0;
    L_0x044f:
        r2 = move-exception;
        r3 = r4;
        r4 = r5;
        r5 = r2;
        goto L_0x0249;
    L_0x0455:
        r2 = move-exception;
        r5 = r2;
        r3 = r4;
        r4 = r12;
        goto L_0x0249;
    L_0x045b:
        r2 = move-exception;
        r5 = r2;
        r4 = r12;
        goto L_0x0249;
    L_0x0460:
        r2 = move-exception;
        r5 = r2;
        r3 = r11;
        r4 = r12;
        goto L_0x0249;
    L_0x0466:
        r2 = move-exception;
        r6 = r10;
        r3 = r4;
        r4 = r5;
        r5 = r2;
        goto L_0x01c4;
    L_0x046d:
        r2 = move-exception;
        r5 = r2;
        r6 = r10;
        r3 = r4;
        r4 = r12;
        goto L_0x01c4;
    L_0x0474:
        r2 = move-exception;
        r5 = r2;
        r6 = r10;
        r4 = r12;
        goto L_0x01c4;
    L_0x047a:
        r2 = move-exception;
        r5 = r2;
        r6 = r10;
        r3 = r11;
        r4 = r12;
        goto L_0x01c4;
    L_0x0481:
        r4 = r14;
        r3 = r11;
        goto L_0x0168;
    L_0x0485:
        r11 = r3;
        goto L_0x0196;
    L_0x0488:
        r4 = r14;
        r3 = r11;
        goto L_0x0116;
    L_0x048c:
        r11 = r3;
        goto L_0x0145;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vlocker.theme.model.a.g.a(java.lang.String, java.lang.String, com.vlocker.theme.model.i, com.vlocker.theme.model.T_ThemeItemInfo):long");
    }

    public void a() {
        HttpParams basicHttpParams = new BasicHttpParams();
        ConnManagerParams.setTimeout(basicHttpParams, (long) f);
        ConnManagerParams.setMaxConnectionsPerRoute(basicHttpParams, new ConnPerRouteBean(e));
        ConnManagerParams.setMaxTotalConnections(basicHttpParams, 10);
        HttpConnectionParams.setSoTimeout(basicHttpParams, f);
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, f);
        HttpConnectionParams.setTcpNoDelay(basicHttpParams, true);
        HttpConnectionParams.setSocketBufferSize(basicHttpParams, 8192);
        HttpProtocolParams.setVersion(basicHttpParams, HttpVersion.HTTP_1_1);
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        ClientConnectionManager threadSafeClientConnManager = new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry);
        this.k = new SyncBasicHttpContext(new BasicHttpContext());
        this.l = new DefaultHttpClient(threadSafeClientConnManager, basicHttpParams);
        this.l.addRequestInterceptor(new h(this));
        this.l.addResponseInterceptor(new i(this));
        this.l.setHttpRequestRetryHandler(new a(3));
        this.m = new HashMap();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(com.vlocker.theme.model.T_ThemeItemInfo r17, java.lang.String r18, android.content.Context r19, java.lang.String r20) {
        /*
        r16 = this;
        monitor-enter(r16);
        r8 = com.vlocker.b.h.a(r18, r19);	 Catch:{ NullPointerException -> 0x01fe, Exception -> 0x01fb, all -> 0x01f2 }
        r9 = com.vlocker.b.j.b(r19);	 Catch:{ NullPointerException -> 0x01fe, Exception -> 0x01fb, all -> 0x01f2 }
        r2 = 0;
        if (r2 != 0) goto L_0x020a;
    L_0x000c:
        r2 = "phone";
        r0 = r19;
        r2 = r0.getSystemService(r2);	 Catch:{ NullPointerException -> 0x01fe, Exception -> 0x01fb, all -> 0x01f2 }
        r2 = (android.telephony.TelephonyManager) r2;	 Catch:{ NullPointerException -> 0x01fe, Exception -> 0x01fb, all -> 0x01f2 }
        r2 = r2.getDeviceId();	 Catch:{ NullPointerException -> 0x01fe, Exception -> 0x01fb, all -> 0x01f2 }
        r7 = r2;
    L_0x001c:
        r2 = 0;
        if (r2 != 0) goto L_0x0207;
    L_0x001f:
        r2 = "wifi";
        r0 = r19;
        r2 = r0.getSystemService(r2);	 Catch:{ NullPointerException -> 0x01fe, Exception -> 0x01fb, all -> 0x01f2 }
        r2 = (android.net.wifi.WifiManager) r2;	 Catch:{ NullPointerException -> 0x01fe, Exception -> 0x01fb, all -> 0x01f2 }
        r2 = r2.getConnectionInfo();	 Catch:{ NullPointerException -> 0x01fe, Exception -> 0x01fb, all -> 0x01f2 }
        r2 = r2.getMacAddress();	 Catch:{ NullPointerException -> 0x01fe, Exception -> 0x01fb, all -> 0x01f2 }
        r6 = r2;
    L_0x0033:
        r2 = java.lang.System.currentTimeMillis();	 Catch:{ NullPointerException -> 0x01fe, Exception -> 0x01fb, all -> 0x01f2 }
        r2 = java.lang.Long.valueOf(r2);	 Catch:{ NullPointerException -> 0x01fe, Exception -> 0x01fb, all -> 0x01f2 }
        r2 = r2.longValue();	 Catch:{ NullPointerException -> 0x01fe, Exception -> 0x01fb, all -> 0x01f2 }
        r4 = com.vlocker.c.a.a(r19);	 Catch:{ NullPointerException -> 0x01fe, Exception -> 0x01fb, all -> 0x01f2 }
        r4 = r4.ax();	 Catch:{ NullPointerException -> 0x01fe, Exception -> 0x01fb, all -> 0x01f2 }
        r2 = r2 - r4;
        java.lang.Long.valueOf(r2);	 Catch:{ NullPointerException -> 0x01fe, Exception -> 0x01fb, all -> 0x01f2 }
        r10 = new org.json.JSONObject;	 Catch:{ NullPointerException -> 0x01fe, Exception -> 0x01fb, all -> 0x01f2 }
        r10.<init>();	 Catch:{ NullPointerException -> 0x01fe, Exception -> 0x01fb, all -> 0x01f2 }
        r2 = "act";
        r3 = "theme_down";
        r10.put(r2, r3);	 Catch:{ NullPointerException -> 0x01fe, Exception -> 0x01fb, all -> 0x01f2 }
        r2 = "timestamp";
        r4 = java.lang.System.currentTimeMillis();	 Catch:{ NullPointerException -> 0x01fe, Exception -> 0x01fb, all -> 0x01f2 }
        r10.put(r2, r4);	 Catch:{ NullPointerException -> 0x01fe, Exception -> 0x01fb, all -> 0x01f2 }
        r2 = "type";
        r3 = "exc";
        r10.put(r2, r3);	 Catch:{ NullPointerException -> 0x01fe, Exception -> 0x01fb, all -> 0x01f2 }
        r11 = new org.json.JSONObject;	 Catch:{ NullPointerException -> 0x01fe, Exception -> 0x01fb, all -> 0x01f2 }
        r11.<init>();	 Catch:{ NullPointerException -> 0x01fe, Exception -> 0x01fb, all -> 0x01f2 }
        r2 = "exeption";
        r0 = r20;
        r11.put(r2, r0);	 Catch:{ NullPointerException -> 0x01fe, Exception -> 0x01fb, all -> 0x01f2 }
        r2 = "id";
        r3 = r17.a();	 Catch:{ NullPointerException -> 0x01fe, Exception -> 0x01fb, all -> 0x01f2 }
        r11.put(r2, r3);	 Catch:{ NullPointerException -> 0x01fe, Exception -> 0x01fb, all -> 0x01f2 }
        r2 = com.vlocker.b.o.noNetStatus;	 Catch:{ NullPointerException -> 0x01fe, Exception -> 0x01fb, all -> 0x01f2 }
        if (r9 != r2) goto L_0x0089;
    L_0x0087:
        monitor-exit(r16);
        return;
    L_0x0089:
        r2 = r19.getPackageManager();	 Catch:{ UnsupportedEncodingException -> 0x01c7, ClientProtocolException -> 0x01e3, IOException -> 0x01ec, Exception -> 0x01f5, NullPointerException -> 0x01cd, all -> 0x01f2 }
        r3 = 0;
        r4 = 0;
        r5 = r19.getPackageName();	 Catch:{ NameNotFoundException -> 0x01d0 }
        r12 = 0;
        r2 = r2.getPackageInfo(r5, r12);	 Catch:{ NameNotFoundException -> 0x01d0 }
        r3 = r2.versionCode;	 Catch:{ NameNotFoundException -> 0x01d0 }
        r2 = r2.versionName;	 Catch:{ NameNotFoundException -> 0x01d0 }
        r4 = r2;
        r5 = r3;
    L_0x009e:
        r12 = com.vlocker.m.l.a();	 Catch:{ UnsupportedEncodingException -> 0x01c7, ClientProtocolException -> 0x01e3, IOException -> 0x01ec, Exception -> 0x01f5, NullPointerException -> 0x01cd, all -> 0x01f2 }
        r13 = com.vlocker.m.l.b();	 Catch:{ UnsupportedEncodingException -> 0x01c7, ClientProtocolException -> 0x01e3, IOException -> 0x01ec, Exception -> 0x01f5, NullPointerException -> 0x01cd, all -> 0x01f2 }
        r2 = 0;
        r3 = r19.getResources();	 Catch:{ NullPointerException -> 0x0204, Exception -> 0x0201, UnsupportedEncodingException -> 0x01c7, ClientProtocolException -> 0x01e3, IOException -> 0x01ec, all -> 0x01f2 }
        r3 = r3.getConfiguration();	 Catch:{ NullPointerException -> 0x0204, Exception -> 0x0201, UnsupportedEncodingException -> 0x01c7, ClientProtocolException -> 0x01e3, IOException -> 0x01ec, all -> 0x01f2 }
        r3 = r3.locale;	 Catch:{ NullPointerException -> 0x0204, Exception -> 0x0201, UnsupportedEncodingException -> 0x01c7, ClientProtocolException -> 0x01e3, IOException -> 0x01ec, all -> 0x01f2 }
        r2 = r3.toString();	 Catch:{ NullPointerException -> 0x0204, Exception -> 0x0201, UnsupportedEncodingException -> 0x01c7, ClientProtocolException -> 0x01e3, IOException -> 0x01ec, all -> 0x01f2 }
    L_0x00b5:
        r3 = 2131296842; // 0x7f09024a float:1.8211612E38 double:1.0530005507E-314;
        r0 = r19;
        r3 = r0.getString(r3);	 Catch:{ NotFoundException -> 0x01d7, Exception -> 0x01dd, UnsupportedEncodingException -> 0x01c7, ClientProtocolException -> 0x01e3, IOException -> 0x01ec, NullPointerException -> 0x01cd, all -> 0x01f2 }
    L_0x00be:
        r14 = new org.json.JSONObject;	 Catch:{ UnsupportedEncodingException -> 0x01c7, ClientProtocolException -> 0x01e3, IOException -> 0x01ec, Exception -> 0x01f5, NullPointerException -> 0x01cd, all -> 0x01f2 }
        r14.<init>();	 Catch:{ UnsupportedEncodingException -> 0x01c7, ClientProtocolException -> 0x01e3, IOException -> 0x01ec, Exception -> 0x01f5, NullPointerException -> 0x01cd, all -> 0x01f2 }
        r15 = "imei";
        r14.put(r15, r7);	 Catch:{ UnsupportedEncodingException -> 0x01c7, ClientProtocolException -> 0x01e3, IOException -> 0x01ec, Exception -> 0x01f5, NullPointerException -> 0x01cd, all -> 0x01f2 }
        r7 = "model";
        r15 = android.os.Build.MODEL;	 Catch:{ UnsupportedEncodingException -> 0x01c7, ClientProtocolException -> 0x01e3, IOException -> 0x01ec, Exception -> 0x01f5, NullPointerException -> 0x01cd, all -> 0x01f2 }
        r14.put(r7, r15);	 Catch:{ UnsupportedEncodingException -> 0x01c7, ClientProtocolException -> 0x01e3, IOException -> 0x01ec, Exception -> 0x01f5, NullPointerException -> 0x01cd, all -> 0x01f2 }
        r7 = "manufacturer";
        r15 = android.os.Build.MANUFACTURER;	 Catch:{ UnsupportedEncodingException -> 0x01c7, ClientProtocolException -> 0x01e3, IOException -> 0x01ec, Exception -> 0x01f5, NullPointerException -> 0x01cd, all -> 0x01f2 }
        r14.put(r7, r15);	 Catch:{ UnsupportedEncodingException -> 0x01c7, ClientProtocolException -> 0x01e3, IOException -> 0x01ec, Exception -> 0x01f5, NullPointerException -> 0x01cd, all -> 0x01f2 }
        r7 = "androidsdk";
        r15 = android.os.Build.VERSION.SDK_INT;	 Catch:{ UnsupportedEncodingException -> 0x01c7, ClientProtocolException -> 0x01e3, IOException -> 0x01ec, Exception -> 0x01f5, NullPointerException -> 0x01cd, all -> 0x01f2 }
        r14.put(r7, r15);	 Catch:{ UnsupportedEncodingException -> 0x01c7, ClientProtocolException -> 0x01e3, IOException -> 0x01ec, Exception -> 0x01f5, NullPointerException -> 0x01cd, all -> 0x01f2 }
        r7 = "display";
        r15 = new java.lang.StringBuilder;	 Catch:{ UnsupportedEncodingException -> 0x01c7, ClientProtocolException -> 0x01e3, IOException -> 0x01ec, Exception -> 0x01f5, NullPointerException -> 0x01cd, all -> 0x01f2 }
        r15.<init>();	 Catch:{ UnsupportedEncodingException -> 0x01c7, ClientProtocolException -> 0x01e3, IOException -> 0x01ec, Exception -> 0x01f5, NullPointerException -> 0x01cd, all -> 0x01f2 }
        r12 = r15.append(r12);	 Catch:{ UnsupportedEncodingException -> 0x01c7, ClientProtocolException -> 0x01e3, IOException -> 0x01ec, Exception -> 0x01f5, NullPointerException -> 0x01cd, all -> 0x01f2 }
        r15 = "*";
        r12 = r12.append(r15);	 Catch:{ UnsupportedEncodingException -> 0x01c7, ClientProtocolException -> 0x01e3, IOException -> 0x01ec, Exception -> 0x01f5, NullPointerException -> 0x01cd, all -> 0x01f2 }
        r12 = r12.append(r13);	 Catch:{ UnsupportedEncodingException -> 0x01c7, ClientProtocolException -> 0x01e3, IOException -> 0x01ec, Exception -> 0x01f5, NullPointerException -> 0x01cd, all -> 0x01f2 }
        r12 = r12.toString();	 Catch:{ UnsupportedEncodingException -> 0x01c7, ClientProtocolException -> 0x01e3, IOException -> 0x01ec, Exception -> 0x01f5, NullPointerException -> 0x01cd, all -> 0x01f2 }
        r14.put(r7, r12);	 Catch:{ UnsupportedEncodingException -> 0x01c7, ClientProtocolException -> 0x01e3, IOException -> 0x01ec, Exception -> 0x01f5, NullPointerException -> 0x01cd, all -> 0x01f2 }
        r7 = "locale";
        r14.put(r7, r2);	 Catch:{ UnsupportedEncodingException -> 0x01c7, ClientProtocolException -> 0x01e3, IOException -> 0x01ec, Exception -> 0x01f5, NullPointerException -> 0x01cd, all -> 0x01f2 }
        r2 = "install";
        r7 = com.vlocker.c.a.a(r19);	 Catch:{ UnsupportedEncodingException -> 0x01c7, ClientProtocolException -> 0x01e3, IOException -> 0x01ec, Exception -> 0x01f5, NullPointerException -> 0x01cd, all -> 0x01f2 }
        r12 = r7.ax();	 Catch:{ UnsupportedEncodingException -> 0x01c7, ClientProtocolException -> 0x01e3, IOException -> 0x01ec, Exception -> 0x01f5, NullPointerException -> 0x01cd, all -> 0x01f2 }
        r14.put(r2, r12);	 Catch:{ UnsupportedEncodingException -> 0x01c7, ClientProtocolException -> 0x01e3, IOException -> 0x01ec, Exception -> 0x01f5, NullPointerException -> 0x01cd, all -> 0x01f2 }
        r2 = "child";
        r14.put(r2, r3);	 Catch:{ UnsupportedEncodingException -> 0x01c7, ClientProtocolException -> 0x01e3, IOException -> 0x01ec, Exception -> 0x01f5, NullPointerException -> 0x01cd, all -> 0x01f2 }
        r2 = "timestamp";
        r12 = java.lang.System.currentTimeMillis();	 Catch:{ UnsupportedEncodingException -> 0x01c7, ClientProtocolException -> 0x01e3, IOException -> 0x01ec, Exception -> 0x01f5, NullPointerException -> 0x01cd, all -> 0x01f2 }
        r14.put(r2, r12);	 Catch:{ UnsupportedEncodingException -> 0x01c7, ClientProtocolException -> 0x01e3, IOException -> 0x01ec, Exception -> 0x01f5, NullPointerException -> 0x01cd, all -> 0x01f2 }
        r2 = "net";
        r14.put(r2, r9);	 Catch:{ UnsupportedEncodingException -> 0x01c7, ClientProtocolException -> 0x01e3, IOException -> 0x01ec, Exception -> 0x01f5, NullPointerException -> 0x01cd, all -> 0x01f2 }
        r2 = "mac";
        r14.put(r2, r6);	 Catch:{ UnsupportedEncodingException -> 0x01c7, ClientProtocolException -> 0x01e3, IOException -> 0x01ec, Exception -> 0x01f5, NullPointerException -> 0x01cd, all -> 0x01f2 }
        r2 = "ipaddr";
        r3 = com.vlocker.b.j.f();	 Catch:{ UnsupportedEncodingException -> 0x01c7, ClientProtocolException -> 0x01e3, IOException -> 0x01ec, Exception -> 0x01f5, NullPointerException -> 0x01cd, all -> 0x01f2 }
        r14.put(r2, r3);	 Catch:{ UnsupportedEncodingException -> 0x01c7, ClientProtocolException -> 0x01e3, IOException -> 0x01ec, Exception -> 0x01f5, NullPointerException -> 0x01cd, all -> 0x01f2 }
        r2 = "ver";
        r14.put(r2, r4);	 Catch:{ UnsupportedEncodingException -> 0x01c7, ClientProtocolException -> 0x01e3, IOException -> 0x01ec, Exception -> 0x01f5, NullPointerException -> 0x01cd, all -> 0x01f2 }
        r2 = "vcode";
        r14.put(r2, r5);	 Catch:{ UnsupportedEncodingException -> 0x01c7, ClientProtocolException -> 0x01e3, IOException -> 0x01ec, Exception -> 0x01f5, NullPointerException -> 0x01cd, all -> 0x01f2 }
        r2 = "e";
        r10.put(r2, r11);	 Catch:{ UnsupportedEncodingException -> 0x01c7, ClientProtocolException -> 0x01e3, IOException -> 0x01ec, Exception -> 0x01f5, NullPointerException -> 0x01cd, all -> 0x01f2 }
        r2 = new org.json.JSONArray;	 Catch:{ UnsupportedEncodingException -> 0x01c7, ClientProtocolException -> 0x01e3, IOException -> 0x01ec, Exception -> 0x01f5, NullPointerException -> 0x01cd, all -> 0x01f2 }
        r2.<init>();	 Catch:{ UnsupportedEncodingException -> 0x01c7, ClientProtocolException -> 0x01e3, IOException -> 0x01ec, Exception -> 0x01f5, NullPointerException -> 0x01cd, all -> 0x01f2 }
        r2.put(r10);	 Catch:{ UnsupportedEncodingException -> 0x01c7, ClientProtocolException -> 0x01e3, IOException -> 0x01ec, Exception -> 0x01f5, NullPointerException -> 0x01cd, all -> 0x01f2 }
        r3 = new org.json.JSONObject;	 Catch:{ UnsupportedEncodingException -> 0x01c7, ClientProtocolException -> 0x01e3, IOException -> 0x01ec, Exception -> 0x01f5, NullPointerException -> 0x01cd, all -> 0x01f2 }
        r3.<init>();	 Catch:{ UnsupportedEncodingException -> 0x01c7, ClientProtocolException -> 0x01e3, IOException -> 0x01ec, Exception -> 0x01f5, NullPointerException -> 0x01cd, all -> 0x01f2 }
        r4 = "base";
        r3.put(r4, r14);	 Catch:{ UnsupportedEncodingException -> 0x01c7, ClientProtocolException -> 0x01e3, IOException -> 0x01ec, Exception -> 0x01f5, NullPointerException -> 0x01cd, all -> 0x01f2 }
        r4 = "content";
        r3.put(r4, r2);	 Catch:{ UnsupportedEncodingException -> 0x01c7, ClientProtocolException -> 0x01e3, IOException -> 0x01ec, Exception -> 0x01f5, NullPointerException -> 0x01cd, all -> 0x01f2 }
        r2 = java.lang.String.valueOf(r3);	 Catch:{ UnsupportedEncodingException -> 0x01c7, ClientProtocolException -> 0x01e3, IOException -> 0x01ec, Exception -> 0x01f5, NullPointerException -> 0x01cd, all -> 0x01f2 }
        r0 = r18;
        r2 = com.vlocker.b.g.a(r2, r0);	 Catch:{ UnsupportedEncodingException -> 0x01c7, ClientProtocolException -> 0x01e3, IOException -> 0x01ec, Exception -> 0x01f5, NullPointerException -> 0x01cd, all -> 0x01f2 }
        if (r2 == 0) goto L_0x0174;
    L_0x0170:
        r2 = com.vlocker.b.j.a(r2);	 Catch:{ UnsupportedEncodingException -> 0x01c7, ClientProtocolException -> 0x01e3, IOException -> 0x01ec, Exception -> 0x01f5, NullPointerException -> 0x01cd, all -> 0x01f2 }
    L_0x0174:
        r3 = r8.length;	 Catch:{ UnsupportedEncodingException -> 0x01c7, ClientProtocolException -> 0x01e3, IOException -> 0x01ec, Exception -> 0x01f5, NullPointerException -> 0x01cd, all -> 0x01f2 }
        r4 = r2.length;	 Catch:{ UnsupportedEncodingException -> 0x01c7, ClientProtocolException -> 0x01e3, IOException -> 0x01ec, Exception -> 0x01f5, NullPointerException -> 0x01cd, all -> 0x01f2 }
        r3 = a(r8, r3, r2, r4);	 Catch:{ UnsupportedEncodingException -> 0x01c7, ClientProtocolException -> 0x01e3, IOException -> 0x01ec, Exception -> 0x01f5, NullPointerException -> 0x01cd, all -> 0x01f2 }
        r2 = new java.net.URL;	 Catch:{ UnsupportedEncodingException -> 0x01c7, ClientProtocolException -> 0x01e3, IOException -> 0x01ec, Exception -> 0x01f5, NullPointerException -> 0x01cd, all -> 0x01f2 }
        r4 = "http://alc.imoxiu.com/collect/?app=556d0b43bb4d9b3c7a8b4567&key=557a53660183a2a37d66e390c3995424";
        r2.<init>(r4);	 Catch:{ UnsupportedEncodingException -> 0x01c7, ClientProtocolException -> 0x01e3, IOException -> 0x01ec, Exception -> 0x01f5, NullPointerException -> 0x01cd, all -> 0x01f2 }
        r2 = r2.openConnection();	 Catch:{ UnsupportedEncodingException -> 0x01c7, ClientProtocolException -> 0x01e3, IOException -> 0x01ec, Exception -> 0x01f5, NullPointerException -> 0x01cd, all -> 0x01f2 }
        r2 = (java.net.HttpURLConnection) r2;	 Catch:{ UnsupportedEncodingException -> 0x01c7, ClientProtocolException -> 0x01e3, IOException -> 0x01ec, Exception -> 0x01f5, NullPointerException -> 0x01cd, all -> 0x01f2 }
        r4 = 5000; // 0x1388 float:7.006E-42 double:2.4703E-320;
        r2.setConnectTimeout(r4);	 Catch:{ UnsupportedEncodingException -> 0x01c7, ClientProtocolException -> 0x01e3, IOException -> 0x01ec, Exception -> 0x01f5, NullPointerException -> 0x01cd, all -> 0x01f2 }
        r4 = "POST";
        r2.setRequestMethod(r4);	 Catch:{ UnsupportedEncodingException -> 0x01c7, ClientProtocolException -> 0x01e3, IOException -> 0x01ec, Exception -> 0x01f5, NullPointerException -> 0x01cd, all -> 0x01f2 }
        r4 = "Content-Type";
        r5 = "application/x-www-form-urlencoded";
        r2.setRequestProperty(r4, r5);	 Catch:{ UnsupportedEncodingException -> 0x01c7, ClientProtocolException -> 0x01e3, IOException -> 0x01ec, Exception -> 0x01f5, NullPointerException -> 0x01cd, all -> 0x01f2 }
        r4 = "Content-Length";
        r5 = new java.lang.StringBuilder;	 Catch:{ UnsupportedEncodingException -> 0x01c7, ClientProtocolException -> 0x01e3, IOException -> 0x01ec, Exception -> 0x01f5, NullPointerException -> 0x01cd, all -> 0x01f2 }
        r5.<init>();	 Catch:{ UnsupportedEncodingException -> 0x01c7, ClientProtocolException -> 0x01e3, IOException -> 0x01ec, Exception -> 0x01f5, NullPointerException -> 0x01cd, all -> 0x01f2 }
        r6 = r3.length;	 Catch:{ UnsupportedEncodingException -> 0x01c7, ClientProtocolException -> 0x01e3, IOException -> 0x01ec, Exception -> 0x01f5, NullPointerException -> 0x01cd, all -> 0x01f2 }
        r5 = r5.append(r6);	 Catch:{ UnsupportedEncodingException -> 0x01c7, ClientProtocolException -> 0x01e3, IOException -> 0x01ec, Exception -> 0x01f5, NullPointerException -> 0x01cd, all -> 0x01f2 }
        r6 = "";
        r5 = r5.append(r6);	 Catch:{ UnsupportedEncodingException -> 0x01c7, ClientProtocolException -> 0x01e3, IOException -> 0x01ec, Exception -> 0x01f5, NullPointerException -> 0x01cd, all -> 0x01f2 }
        r5 = r5.toString();	 Catch:{ UnsupportedEncodingException -> 0x01c7, ClientProtocolException -> 0x01e3, IOException -> 0x01ec, Exception -> 0x01f5, NullPointerException -> 0x01cd, all -> 0x01f2 }
        r2.setRequestProperty(r4, r5);	 Catch:{ UnsupportedEncodingException -> 0x01c7, ClientProtocolException -> 0x01e3, IOException -> 0x01ec, Exception -> 0x01f5, NullPointerException -> 0x01cd, all -> 0x01f2 }
        r4 = 1;
        r2.setDoOutput(r4);	 Catch:{ UnsupportedEncodingException -> 0x01c7, ClientProtocolException -> 0x01e3, IOException -> 0x01ec, Exception -> 0x01f5, NullPointerException -> 0x01cd, all -> 0x01f2 }
        r4 = r2.getOutputStream();	 Catch:{ UnsupportedEncodingException -> 0x01c7, ClientProtocolException -> 0x01e3, IOException -> 0x01ec, Exception -> 0x01f5, NullPointerException -> 0x01cd, all -> 0x01f2 }
        r4.write(r3);	 Catch:{ UnsupportedEncodingException -> 0x01c7, ClientProtocolException -> 0x01e3, IOException -> 0x01ec, Exception -> 0x01f5, NullPointerException -> 0x01cd, all -> 0x01f2 }
        r2.getResponseCode();	 Catch:{ UnsupportedEncodingException -> 0x01c7, ClientProtocolException -> 0x01e3, IOException -> 0x01ec, Exception -> 0x01f5, NullPointerException -> 0x01cd, all -> 0x01f2 }
        goto L_0x0087;
    L_0x01c7:
        r2 = move-exception;
        r2.printStackTrace();	 Catch:{ NullPointerException -> 0x01cd, Exception -> 0x01e9, all -> 0x01f2 }
        goto L_0x0087;
    L_0x01cd:
        r2 = move-exception;
        goto L_0x0087;
    L_0x01d0:
        r2 = move-exception;
        r2.printStackTrace();	 Catch:{ UnsupportedEncodingException -> 0x01c7, ClientProtocolException -> 0x01e3, IOException -> 0x01ec, Exception -> 0x01f5, NullPointerException -> 0x01cd, all -> 0x01f2 }
        r5 = r3;
        goto L_0x009e;
    L_0x01d7:
        r3 = move-exception;
        r3 = "new-moxiulauncher";
        goto L_0x00be;
    L_0x01dd:
        r3 = move-exception;
        r3 = "new-moxiulauncher";
        goto L_0x00be;
    L_0x01e3:
        r2 = move-exception;
        r2.printStackTrace();	 Catch:{ NullPointerException -> 0x01cd, Exception -> 0x01e9, all -> 0x01f2 }
        goto L_0x0087;
    L_0x01e9:
        r2 = move-exception;
        goto L_0x0087;
    L_0x01ec:
        r2 = move-exception;
        r2.printStackTrace();	 Catch:{ NullPointerException -> 0x01cd, Exception -> 0x01e9, all -> 0x01f2 }
        goto L_0x0087;
    L_0x01f2:
        r2 = move-exception;
        monitor-exit(r16);
        throw r2;
    L_0x01f5:
        r2 = move-exception;
        r2.printStackTrace();	 Catch:{ NullPointerException -> 0x01cd, Exception -> 0x01e9, all -> 0x01f2 }
        goto L_0x0087;
    L_0x01fb:
        r2 = move-exception;
        goto L_0x0087;
    L_0x01fe:
        r2 = move-exception;
        goto L_0x0087;
    L_0x0201:
        r3 = move-exception;
        goto L_0x00b5;
    L_0x0204:
        r3 = move-exception;
        goto L_0x00b5;
    L_0x0207:
        r6 = r2;
        goto L_0x0033;
    L_0x020a:
        r7 = r2;
        goto L_0x001c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vlocker.theme.model.a.g.a(com.vlocker.theme.model.T_ThemeItemInfo, java.lang.String, android.content.Context, java.lang.String):void");
    }
}
