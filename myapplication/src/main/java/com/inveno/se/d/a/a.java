package com.inveno.se.d.a;

import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import com.inveno.se.d.aa;
import com.inveno.se.d.ab;
import com.inveno.se.d.c;
import com.inveno.se.d.j;
import com.inveno.se.d.p;
import com.inveno.se.d.x;
import com.inveno.se.d.y;
import com.inveno.se.f.o;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.impl.cookie.DateUtils;

public class a implements j {
    private static int c = 3000;
    private static int d = 4096;
    protected final k a;
    protected final c b;
    private b e;

    public a(k kVar) {
        this(kVar, new c(d));
    }

    public a(k kVar, c cVar) {
        this.a = kVar;
        this.b = cVar;
    }

    private static Map a(Header[] headerArr) {
        Map hashMap = new HashMap();
        for (int i = 0; i < headerArr.length; i++) {
            hashMap.put(headerArr[i].getName(), headerArr[i].getValue());
        }
        return hashMap;
    }

    private void a(long j, p pVar, byte[] bArr, StatusLine statusLine) {
        String str = "HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]";
        Object[] objArr = new Object[5];
        objArr[0] = pVar;
        objArr[1] = Long.valueOf(j);
        objArr[2] = bArr != null ? Integer.valueOf(bArr.length) : "null";
        objArr[3] = Integer.valueOf(statusLine.getStatusCode());
        objArr[4] = Integer.valueOf(pVar.s().b());
        ab.b(str, objArr);
    }

    private void a(p pVar, long j) {
        if (!(pVar instanceof p)) {
            com.inveno.se.f.a.b("请求失败 了，需记录请求信息待上传：" + pVar);
            o.a();
        }
    }

    private static void a(String str, p pVar, aa aaVar) {
        x s = pVar.s();
        int r = pVar.r();
        try {
            s.a(aaVar);
            pVar.v();
            pVar.a(String.format("%s-retry [timeout=%s]", new Object[]{str, Integer.valueOf(r)}));
        } catch (aa e) {
            pVar.a(String.format("%s-timeout-giveup [timeout=%s]", new Object[]{str, Integer.valueOf(r)}));
            throw e;
        }
    }

    private void a(Map map, c cVar) {
        if (cVar != null) {
            if (cVar.b != null) {
                map.put("If-None-Match", cVar.b);
            }
            if (cVar.c > 0) {
                map.put("If-Modified-Since", DateUtils.formatDate(new Date(cVar.c)));
            }
        }
    }

    private byte[] a(HttpEntity httpEntity, p pVar) {
        r rVar = new r(this.b, (int) httpEntity.getContentLength());
        byte[] bArr = null;
        try {
            InputStream content = httpEntity.getContent();
            if (content == null) {
                throw new y();
            }
            bArr = this.b.a((int) IXAdIOUtils.BUFFER_SIZE);
            long j = 0;
            while (true) {
                int read = content.read(bArr);
                if (read == -1) {
                    break;
                }
                rVar.write(bArr, 0, read);
                j += (long) read;
                a(httpEntity.getContentLength(), j);
                if (this.e != null) {
                    j += (long) read;
                    this.e.a(httpEntity.getContentLength(), j);
                }
            }
            byte[] toByteArray = rVar.toByteArray();
            return toByteArray;
        } finally {
            try {
                httpEntity.consumeContent();
            } catch (IOException e) {
                ab.a("Error occured when calling consumingContent", new Object[0]);
            }
            this.b.a(bArr);
            rVar.close();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.inveno.se.d.m a(com.inveno.se.d.p r13) {
        /*
        r12 = this;
        r10 = android.os.SystemClock.elapsedRealtime();
    L_0x0004:
        r2 = 0;
        r5 = 0;
        r1 = new java.util.HashMap;
        r1.<init>();
        r0 = new java.util.HashMap;	 Catch:{ SocketTimeoutException -> 0x007b, ConnectTimeoutException -> 0x00ae, MalformedURLException -> 0x00da, InterruptedIOException -> 0x0117, IOException -> 0x0140 }
        r0.<init>();	 Catch:{ SocketTimeoutException -> 0x007b, ConnectTimeoutException -> 0x00ae, MalformedURLException -> 0x00da, InterruptedIOException -> 0x0117, IOException -> 0x0140 }
        r3 = r13.d();	 Catch:{ SocketTimeoutException -> 0x007b, ConnectTimeoutException -> 0x00ae, MalformedURLException -> 0x00da, InterruptedIOException -> 0x0117, IOException -> 0x0140 }
        r12.a(r0, r3);	 Catch:{ SocketTimeoutException -> 0x007b, ConnectTimeoutException -> 0x00ae, MalformedURLException -> 0x00da, InterruptedIOException -> 0x0117, IOException -> 0x0140 }
        r3 = r12.a;	 Catch:{ SocketTimeoutException -> 0x007b, ConnectTimeoutException -> 0x00ae, MalformedURLException -> 0x00da, InterruptedIOException -> 0x0117, IOException -> 0x0140 }
        r8 = r3.a(r13, r0);	 Catch:{ SocketTimeoutException -> 0x007b, ConnectTimeoutException -> 0x00ae, MalformedURLException -> 0x00da, InterruptedIOException -> 0x0117, IOException -> 0x0140 }
        r6 = r8.getStatusLine();	 Catch:{ SocketTimeoutException -> 0x007b, ConnectTimeoutException -> 0x00ae, MalformedURLException -> 0x00da, InterruptedIOException -> 0x0117, IOException -> 0x01b0 }
        r9 = r6.getStatusCode();	 Catch:{ SocketTimeoutException -> 0x007b, ConnectTimeoutException -> 0x00ae, MalformedURLException -> 0x00da, InterruptedIOException -> 0x0117, IOException -> 0x01b0 }
        r0 = new java.lang.StringBuilder;	 Catch:{ SocketTimeoutException -> 0x007b, ConnectTimeoutException -> 0x00ae, MalformedURLException -> 0x00da, InterruptedIOException -> 0x0117, IOException -> 0x01b0 }
        r0.<init>();	 Catch:{ SocketTimeoutException -> 0x007b, ConnectTimeoutException -> 0x00ae, MalformedURLException -> 0x00da, InterruptedIOException -> 0x0117, IOException -> 0x01b0 }
        r2 = "-------statusCode:";
        r0 = r0.append(r2);	 Catch:{ SocketTimeoutException -> 0x007b, ConnectTimeoutException -> 0x00ae, MalformedURLException -> 0x00da, InterruptedIOException -> 0x0117, IOException -> 0x01b0 }
        r0 = r0.append(r9);	 Catch:{ SocketTimeoutException -> 0x007b, ConnectTimeoutException -> 0x00ae, MalformedURLException -> 0x00da, InterruptedIOException -> 0x0117, IOException -> 0x01b0 }
        r0 = r0.toString();	 Catch:{ SocketTimeoutException -> 0x007b, ConnectTimeoutException -> 0x00ae, MalformedURLException -> 0x00da, InterruptedIOException -> 0x0117, IOException -> 0x01b0 }
        com.inveno.se.f.a.b(r0);	 Catch:{ SocketTimeoutException -> 0x007b, ConnectTimeoutException -> 0x00ae, MalformedURLException -> 0x00da, InterruptedIOException -> 0x0117, IOException -> 0x01b0 }
        r0 = r8.getAllHeaders();	 Catch:{ SocketTimeoutException -> 0x007b, ConnectTimeoutException -> 0x00ae, MalformedURLException -> 0x00da, InterruptedIOException -> 0x0117, IOException -> 0x01b0 }
        r7 = a(r0);	 Catch:{ SocketTimeoutException -> 0x007b, ConnectTimeoutException -> 0x00ae, MalformedURLException -> 0x00da, InterruptedIOException -> 0x0117, IOException -> 0x01b0 }
        r0 = 304; // 0x130 float:4.26E-43 double:1.5E-321;
        if (r9 != r0) goto L_0x0057;
    L_0x0048:
        r0 = new com.inveno.se.d.m;	 Catch:{ SocketTimeoutException -> 0x007b, ConnectTimeoutException -> 0x00ae, MalformedURLException -> 0x00da, InterruptedIOException -> 0x0117, IOException -> 0x01b3 }
        r1 = 304; // 0x130 float:4.26E-43 double:1.5E-321;
        r2 = r13.d();	 Catch:{ SocketTimeoutException -> 0x007b, ConnectTimeoutException -> 0x00ae, MalformedURLException -> 0x00da, InterruptedIOException -> 0x0117, IOException -> 0x01b3 }
        r2 = r2.a;	 Catch:{ SocketTimeoutException -> 0x007b, ConnectTimeoutException -> 0x00ae, MalformedURLException -> 0x00da, InterruptedIOException -> 0x0117, IOException -> 0x01b3 }
        r3 = 1;
        r0.<init>(r1, r2, r7, r3);	 Catch:{ SocketTimeoutException -> 0x007b, ConnectTimeoutException -> 0x00ae, MalformedURLException -> 0x00da, InterruptedIOException -> 0x0117, IOException -> 0x01b3 }
    L_0x0056:
        return r0;
    L_0x0057:
        r0 = r8.getEntity();	 Catch:{ SocketTimeoutException -> 0x007b, ConnectTimeoutException -> 0x00ae, MalformedURLException -> 0x00da, InterruptedIOException -> 0x0117, IOException -> 0x01b3 }
        r5 = r12.a(r0, r13);	 Catch:{ SocketTimeoutException -> 0x007b, ConnectTimeoutException -> 0x00ae, MalformedURLException -> 0x00da, InterruptedIOException -> 0x0117, IOException -> 0x01b3 }
        r0 = android.os.SystemClock.elapsedRealtime();	 Catch:{ SocketTimeoutException -> 0x007b, ConnectTimeoutException -> 0x00ae, MalformedURLException -> 0x00da, InterruptedIOException -> 0x0117, IOException -> 0x01b3 }
        r2 = r0 - r10;
        r1 = r12;
        r4 = r13;
        r1.a(r2, r4, r5, r6);	 Catch:{ SocketTimeoutException -> 0x007b, ConnectTimeoutException -> 0x00ae, MalformedURLException -> 0x00da, InterruptedIOException -> 0x0117, IOException -> 0x01b3 }
        r0 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r9 == r0) goto L_0x00a7;
    L_0x006e:
        r0 = 204; // 0xcc float:2.86E-43 double:1.01E-321;
        if (r9 == r0) goto L_0x00a7;
    L_0x0072:
        r12.a(r13, r10);	 Catch:{ SocketTimeoutException -> 0x007b, ConnectTimeoutException -> 0x00ae, MalformedURLException -> 0x00da, InterruptedIOException -> 0x0117, IOException -> 0x01b3 }
        r0 = new java.io.IOException;	 Catch:{ SocketTimeoutException -> 0x007b, ConnectTimeoutException -> 0x00ae, MalformedURLException -> 0x00da, InterruptedIOException -> 0x0117, IOException -> 0x01b3 }
        r0.<init>();	 Catch:{ SocketTimeoutException -> 0x007b, ConnectTimeoutException -> 0x00ae, MalformedURLException -> 0x00da, InterruptedIOException -> 0x0117, IOException -> 0x01b3 }
        throw r0;	 Catch:{ SocketTimeoutException -> 0x007b, ConnectTimeoutException -> 0x00ae, MalformedURLException -> 0x00da, InterruptedIOException -> 0x0117, IOException -> 0x01b3 }
    L_0x007b:
        r0 = move-exception;
        r12.a(r13, r10);
        r1 = "socket";
        r2 = new com.inveno.se.d.z;
        r2.<init>();
        a(r1, r13, r2);
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "-------SocketTimeoutException:";
        r1 = r1.append(r2);
        r0 = r0.getMessage();
        r0 = r1.append(r0);
        r0 = r0.toString();
        com.inveno.se.f.a.b(r0);
        goto L_0x0004;
    L_0x00a7:
        r0 = new com.inveno.se.d.m;	 Catch:{ SocketTimeoutException -> 0x007b, ConnectTimeoutException -> 0x00ae, MalformedURLException -> 0x00da, InterruptedIOException -> 0x0117, IOException -> 0x01b3 }
        r1 = 0;
        r0.<init>(r9, r5, r7, r1);	 Catch:{ SocketTimeoutException -> 0x007b, ConnectTimeoutException -> 0x00ae, MalformedURLException -> 0x00da, InterruptedIOException -> 0x0117, IOException -> 0x01b3 }
        goto L_0x0056;
    L_0x00ae:
        r0 = move-exception;
        r12.a(r13, r10);
        r1 = "connection";
        r2 = new com.inveno.se.d.z;
        r2.<init>();
        a(r1, r13, r2);
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "-------ConnectTimeoutException:";
        r1 = r1.append(r2);
        r0 = r0.getMessage();
        r0 = r1.append(r0);
        r0 = r0.toString();
        com.inveno.se.f.a.b(r0);
        goto L_0x0004;
    L_0x00da:
        r0 = move-exception;
        r12.a(r13, r10);
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "-------MalformedURLException:";
        r1 = r1.append(r2);
        r2 = r0.getMessage();
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.inveno.se.f.a.b(r1);
        r1 = new java.lang.RuntimeException;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "Bad URL ";
        r2 = r2.append(r3);
        r3 = r13.i();
        r2 = r2.append(r3);
        r2 = r2.toString();
        r1.<init>(r2, r0);
        throw r1;
    L_0x0117:
        r0 = move-exception;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "-------InterruptedIOException:";
        r1 = r1.append(r2);
        r0 = r0.getMessage();
        r0 = r1.append(r0);
        r0 = r0.toString();
        com.inveno.se.f.a.b(r0);
        r0 = "connection";
        r1 = new com.inveno.se.d.z;
        r1.<init>();
        a(r0, r13, r1);
        goto L_0x0004;
    L_0x0140:
        r0 = move-exception;
    L_0x0141:
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "-------IOException:";
        r3 = r3.append(r4);
        r4 = r0.getMessage();
        r3 = r3.append(r4);
        r3 = r3.toString();
        com.inveno.se.f.a.b(r3);
        r12.a(r13, r10);
        r3 = 0;
        if (r2 == 0) goto L_0x019e;
    L_0x0162:
        r0 = r2.getStatusLine();
        r0 = r0.getStatusCode();
        r2 = "Unexpected response code %d for %s";
        r4 = 2;
        r4 = new java.lang.Object[r4];
        r6 = 0;
        r7 = java.lang.Integer.valueOf(r0);
        r4[r6] = r7;
        r6 = 1;
        r7 = r13.i();
        r4[r6] = r7;
        com.inveno.se.d.ab.c(r2, r4);
        if (r5 == 0) goto L_0x01aa;
    L_0x0183:
        r2 = new com.inveno.se.d.m;
        r3 = 0;
        r2.<init>(r0, r5, r1, r3);
        r1 = 401; // 0x191 float:5.62E-43 double:1.98E-321;
        if (r0 == r1) goto L_0x0191;
    L_0x018d:
        r1 = 403; // 0x193 float:5.65E-43 double:1.99E-321;
        if (r0 != r1) goto L_0x01a4;
    L_0x0191:
        r0 = "auth";
        r1 = new com.inveno.se.d.a;
        r1.<init>(r2);
        a(r0, r13, r1);
        goto L_0x0004;
    L_0x019e:
        r1 = new com.inveno.se.d.n;
        r1.<init>(r0);
        throw r1;
    L_0x01a4:
        r0 = new com.inveno.se.d.y;
        r0.<init>(r2);
        throw r0;
    L_0x01aa:
        r0 = new com.inveno.se.d.l;
        r0.<init>(r3);
        throw r0;
    L_0x01b0:
        r0 = move-exception;
        r2 = r8;
        goto L_0x0141;
    L_0x01b3:
        r0 = move-exception;
        r1 = r7;
        r2 = r8;
        goto L_0x0141;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inveno.se.d.a.a.a(com.inveno.se.d.p):com.inveno.se.d.m");
    }

    public void a(long j, long j2) {
        if (this.e != null) {
            this.e.a(j, j2);
        }
    }
}
