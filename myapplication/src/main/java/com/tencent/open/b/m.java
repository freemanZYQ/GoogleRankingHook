package com.tencent.open.b;

import android.os.Bundle;

class m implements Runnable {
    final /* synthetic */ Bundle a;
    final /* synthetic */ String b;
    final /* synthetic */ boolean c;
    final /* synthetic */ String d;
    final /* synthetic */ g e;

    m(g gVar, Bundle bundle, String str, boolean z, String str2) {
        this.e = gVar;
        this.a = bundle;
        this.b = str;
        this.c = z;
        this.d = str2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
        r10 = this;
        r2 = 1;
        r0 = 0;
        r1 = r10.a;	 Catch:{ Exception -> 0x00c4 }
        if (r1 != 0) goto L_0x0010;
    L_0x0006:
        r0 = "openSDK_LOG.ReportManager";
        r1 = "-->httpRequest, params is null!";
        com.tencent.open.a.j.e(r0, r1);	 Catch:{ Exception -> 0x00c4 }
    L_0x000f:
        return;
    L_0x0010:
        r1 = com.tencent.open.b.e.a();	 Catch:{ Exception -> 0x00c4 }
        if (r1 != 0) goto L_0x00d0;
    L_0x0016:
        r1 = 3;
        r4 = r1;
    L_0x0018:
        r1 = "openSDK_LOG.ReportManager";
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00c4 }
        r3.<init>();	 Catch:{ Exception -> 0x00c4 }
        r5 = "-->httpRequest, retryCount: ";
        r3 = r3.append(r5);	 Catch:{ Exception -> 0x00c4 }
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x00c4 }
        r3 = r3.toString();	 Catch:{ Exception -> 0x00c4 }
        com.tencent.open.a.j.b(r1, r3);	 Catch:{ Exception -> 0x00c4 }
        r1 = com.tencent.open.d.e.a();	 Catch:{ Exception -> 0x00c4 }
        r3 = 0;
        r5 = r10.b;	 Catch:{ Exception -> 0x00c4 }
        r5 = com.tencent.open.d.f.a(r1, r3, r5);	 Catch:{ Exception -> 0x00c4 }
        r1 = r10.a;	 Catch:{ Exception -> 0x00c4 }
        r1 = com.tencent.open.d.f.a(r1);	 Catch:{ Exception -> 0x00c4 }
        r3 = r10.c;	 Catch:{ Exception -> 0x00c4 }
        if (r3 == 0) goto L_0x0145;
    L_0x0047:
        r1 = java.net.URLEncoder.encode(r1);	 Catch:{ Exception -> 0x00c4 }
        r3 = r1;
    L_0x004c:
        r1 = r10.d;	 Catch:{ Exception -> 0x00c4 }
        r1 = r1.toUpperCase();	 Catch:{ Exception -> 0x00c4 }
        r6 = "GET";
        r1 = r1.equals(r6);	 Catch:{ Exception -> 0x00c4 }
        if (r1 == 0) goto L_0x00d3;
    L_0x005b:
        r6 = new java.lang.StringBuffer;	 Catch:{ Exception -> 0x00c4 }
        r1 = r10.b;	 Catch:{ Exception -> 0x00c4 }
        r6.<init>(r1);	 Catch:{ Exception -> 0x00c4 }
        r6.append(r3);	 Catch:{ Exception -> 0x00c4 }
        r1 = new org.apache.http.client.methods.HttpGet;	 Catch:{ Exception -> 0x00c4 }
        r3 = r6.toString();	 Catch:{ Exception -> 0x00c4 }
        r1.<init>(r3);	 Catch:{ Exception -> 0x00c4 }
        r3 = r1;
    L_0x006f:
        r1 = "Accept-Encoding";
        r6 = "gzip";
        r3.addHeader(r1, r6);	 Catch:{ Exception -> 0x00c4 }
        r1 = "Content-Type";
        r6 = "application/x-www-form-urlencoded";
        r3.addHeader(r1, r6);	 Catch:{ Exception -> 0x00c4 }
        r1 = r0;
    L_0x0082:
        r1 = r1 + 1;
        r6 = r5.execute(r3);	 Catch:{ ConnectTimeoutException -> 0x010e, SocketTimeoutException -> 0x011b, Exception -> 0x0126 }
        r6 = r6.getStatusLine();	 Catch:{ ConnectTimeoutException -> 0x010e, SocketTimeoutException -> 0x011b, Exception -> 0x0126 }
        r6 = r6.getStatusCode();	 Catch:{ ConnectTimeoutException -> 0x010e, SocketTimeoutException -> 0x011b, Exception -> 0x0126 }
        r7 = "openSDK_LOG.ReportManager";
        r8 = new java.lang.StringBuilder;	 Catch:{ ConnectTimeoutException -> 0x010e, SocketTimeoutException -> 0x011b, Exception -> 0x0126 }
        r8.<init>();	 Catch:{ ConnectTimeoutException -> 0x010e, SocketTimeoutException -> 0x011b, Exception -> 0x0126 }
        r9 = "-->httpRequest, statusCode: ";
        r8 = r8.append(r9);	 Catch:{ ConnectTimeoutException -> 0x010e, SocketTimeoutException -> 0x011b, Exception -> 0x0126 }
        r8 = r8.append(r6);	 Catch:{ ConnectTimeoutException -> 0x010e, SocketTimeoutException -> 0x011b, Exception -> 0x0126 }
        r8 = r8.toString();	 Catch:{ ConnectTimeoutException -> 0x010e, SocketTimeoutException -> 0x011b, Exception -> 0x0126 }
        com.tencent.open.a.j.b(r7, r8);	 Catch:{ ConnectTimeoutException -> 0x010e, SocketTimeoutException -> 0x011b, Exception -> 0x0126 }
        r7 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r6 == r7) goto L_0x0103;
    L_0x00ae:
        r6 = "openSDK_LOG.ReportManager";
        r7 = "-->ReportCenter httpRequest : HttpStatuscode != 200";
        com.tencent.open.a.j.b(r6, r7);	 Catch:{ ConnectTimeoutException -> 0x010e, SocketTimeoutException -> 0x011b, Exception -> 0x0126 }
    L_0x00b7:
        if (r0 != r2) goto L_0x0131;
    L_0x00b9:
        r0 = "openSDK_LOG.ReportManager";
        r1 = "-->ReportCenter httpRequest Thread request success";
        com.tencent.open.a.j.b(r0, r1);	 Catch:{ Exception -> 0x00c4 }
        goto L_0x000f;
    L_0x00c4:
        r0 = move-exception;
        r0 = "openSDK_LOG.ReportManager";
        r1 = "-->httpRequest, exception in serial executor.";
        com.tencent.open.a.j.b(r0, r1);
        goto L_0x000f;
    L_0x00d0:
        r4 = r1;
        goto L_0x0018;
    L_0x00d3:
        r1 = r10.d;	 Catch:{ Exception -> 0x00c4 }
        r1 = r1.toUpperCase();	 Catch:{ Exception -> 0x00c4 }
        r6 = "POST";
        r1 = r1.equals(r6);	 Catch:{ Exception -> 0x00c4 }
        if (r1 == 0) goto L_0x00f8;
    L_0x00e2:
        r1 = new org.apache.http.client.methods.HttpPost;	 Catch:{ Exception -> 0x00c4 }
        r6 = r10.b;	 Catch:{ Exception -> 0x00c4 }
        r1.<init>(r6);	 Catch:{ Exception -> 0x00c4 }
        r3 = com.tencent.open.d.u.g(r3);	 Catch:{ Exception -> 0x00c4 }
        r6 = new org.apache.http.entity.ByteArrayEntity;	 Catch:{ Exception -> 0x00c4 }
        r6.<init>(r3);	 Catch:{ Exception -> 0x00c4 }
        r1.setEntity(r6);	 Catch:{ Exception -> 0x00c4 }
        r3 = r1;
        goto L_0x006f;
    L_0x00f8:
        r0 = "openSDK_LOG.ReportManager";
        r1 = "-->httpRequest unkonw request method return.";
        com.tencent.open.a.j.e(r0, r1);	 Catch:{ Exception -> 0x00c4 }
        goto L_0x000f;
    L_0x0103:
        r0 = "openSDK_LOG.ReportManager";
        r6 = "-->ReportCenter httpRequest Thread success";
        com.tencent.open.a.j.b(r0, r6);	 Catch:{ ConnectTimeoutException -> 0x0142, SocketTimeoutException -> 0x013f, Exception -> 0x013c }
        r0 = r2;
        goto L_0x00b7;
    L_0x010e:
        r6 = move-exception;
    L_0x010f:
        r6 = "openSDK_LOG.ReportManager";
        r7 = "-->ReportCenter httpRequest ConnectTimeoutException";
        com.tencent.open.a.j.b(r6, r7);	 Catch:{ Exception -> 0x00c4 }
    L_0x0118:
        if (r1 < r4) goto L_0x0082;
    L_0x011a:
        goto L_0x00b7;
    L_0x011b:
        r6 = move-exception;
    L_0x011c:
        r6 = "openSDK_LOG.ReportManager";
        r7 = "-->ReportCenter httpRequest SocketTimeoutException";
        com.tencent.open.a.j.b(r6, r7);	 Catch:{ Exception -> 0x00c4 }
        goto L_0x0118;
    L_0x0126:
        r1 = move-exception;
    L_0x0127:
        r1 = "openSDK_LOG.ReportManager";
        r3 = "-->ReportCenter httpRequest Exception";
        com.tencent.open.a.j.b(r1, r3);	 Catch:{ Exception -> 0x00c4 }
        goto L_0x00b7;
    L_0x0131:
        r0 = "openSDK_LOG.ReportManager";
        r1 = "-->ReportCenter httpRequest Thread request failed";
        com.tencent.open.a.j.b(r0, r1);	 Catch:{ Exception -> 0x00c4 }
        goto L_0x000f;
    L_0x013c:
        r0 = move-exception;
        r0 = r2;
        goto L_0x0127;
    L_0x013f:
        r0 = move-exception;
        r0 = r2;
        goto L_0x011c;
    L_0x0142:
        r0 = move-exception;
        r0 = r2;
        goto L_0x010f;
    L_0x0145:
        r3 = r1;
        goto L_0x004c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.b.m.run():void");
    }
}
