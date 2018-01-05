package com.tencent.open.b;

class k implements Runnable {
    final /* synthetic */ g a;

    k(g gVar) {
        this.a = gVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
        r8 = this;
        r1 = 0;
        r0 = r8.a;	 Catch:{ Exception -> 0x00bf }
        r4 = r0.c();	 Catch:{ Exception -> 0x00bf }
        if (r4 != 0) goto L_0x000a;
    L_0x0009:
        return;
    L_0x000a:
        r0 = com.tencent.open.d.e.a();	 Catch:{ Exception -> 0x00bf }
        r2 = 0;
        r0 = com.tencent.open.d.m.a(r0, r2);	 Catch:{ Exception -> 0x00bf }
        r2 = "Common_HttpRetryCount";
        r0 = r0.a(r2);	 Catch:{ Exception -> 0x00bf }
        if (r0 != 0) goto L_0x00cb;
    L_0x001c:
        r0 = 3;
        r3 = r0;
    L_0x001e:
        r0 = "openSDK_LOG.ReportManager";
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00bf }
        r2.<init>();	 Catch:{ Exception -> 0x00bf }
        r5 = "-->doReportCgi, retryCount: ";
        r2 = r2.append(r5);	 Catch:{ Exception -> 0x00bf }
        r2 = r2.append(r3);	 Catch:{ Exception -> 0x00bf }
        r2 = r2.toString();	 Catch:{ Exception -> 0x00bf }
        com.tencent.open.a.j.b(r0, r2);	 Catch:{ Exception -> 0x00bf }
        r0 = r1;
    L_0x0039:
        r0 = r0 + 1;
        r2 = com.tencent.open.d.e.a();	 Catch:{ ConnectTimeoutException -> 0x00ce, SocketTimeoutException -> 0x00db, Exception -> 0x00e6 }
        r5 = 0;
        r6 = "http://wspeed.qq.com/w.cgi";
        r2 = com.tencent.open.d.f.a(r2, r5, r6);	 Catch:{ ConnectTimeoutException -> 0x00ce, SocketTimeoutException -> 0x00db, Exception -> 0x00e6 }
        r5 = new org.apache.http.client.methods.HttpPost;	 Catch:{ ConnectTimeoutException -> 0x00ce, SocketTimeoutException -> 0x00db, Exception -> 0x00e6 }
        r6 = "http://wspeed.qq.com/w.cgi";
        r5.<init>(r6);	 Catch:{ ConnectTimeoutException -> 0x00ce, SocketTimeoutException -> 0x00db, Exception -> 0x00e6 }
        r6 = "Accept-Encoding";
        r7 = "gzip";
        r5.addHeader(r6, r7);	 Catch:{ ConnectTimeoutException -> 0x00ce, SocketTimeoutException -> 0x00db, Exception -> 0x00e6 }
        r6 = "Content-Type";
        r7 = "application/x-www-form-urlencoded";
        r5.setHeader(r6, r7);	 Catch:{ ConnectTimeoutException -> 0x00ce, SocketTimeoutException -> 0x00db, Exception -> 0x00e6 }
        r6 = com.tencent.open.d.f.a(r4);	 Catch:{ ConnectTimeoutException -> 0x00ce, SocketTimeoutException -> 0x00db, Exception -> 0x00e6 }
        r6 = com.tencent.open.d.u.g(r6);	 Catch:{ ConnectTimeoutException -> 0x00ce, SocketTimeoutException -> 0x00db, Exception -> 0x00e6 }
        r7 = new org.apache.http.entity.ByteArrayEntity;	 Catch:{ ConnectTimeoutException -> 0x00ce, SocketTimeoutException -> 0x00db, Exception -> 0x00e6 }
        r7.<init>(r6);	 Catch:{ ConnectTimeoutException -> 0x00ce, SocketTimeoutException -> 0x00db, Exception -> 0x00e6 }
        r5.setEntity(r7);	 Catch:{ ConnectTimeoutException -> 0x00ce, SocketTimeoutException -> 0x00db, Exception -> 0x00e6 }
        r2 = r2.execute(r5);	 Catch:{ ConnectTimeoutException -> 0x00ce, SocketTimeoutException -> 0x00db, Exception -> 0x00e6 }
        r2 = r2.getStatusLine();	 Catch:{ ConnectTimeoutException -> 0x00ce, SocketTimeoutException -> 0x00db, Exception -> 0x00e6 }
        r2 = r2.getStatusCode();	 Catch:{ ConnectTimeoutException -> 0x00ce, SocketTimeoutException -> 0x00db, Exception -> 0x00e6 }
        r5 = "openSDK_LOG.ReportManager";
        r6 = new java.lang.StringBuilder;	 Catch:{ ConnectTimeoutException -> 0x00ce, SocketTimeoutException -> 0x00db, Exception -> 0x00e6 }
        r6.<init>();	 Catch:{ ConnectTimeoutException -> 0x00ce, SocketTimeoutException -> 0x00db, Exception -> 0x00e6 }
        r7 = "-->doReportCgi, statusCode: ";
        r6 = r6.append(r7);	 Catch:{ ConnectTimeoutException -> 0x00ce, SocketTimeoutException -> 0x00db, Exception -> 0x00e6 }
        r6 = r6.append(r2);	 Catch:{ ConnectTimeoutException -> 0x00ce, SocketTimeoutException -> 0x00db, Exception -> 0x00e6 }
        r6 = r6.toString();	 Catch:{ ConnectTimeoutException -> 0x00ce, SocketTimeoutException -> 0x00db, Exception -> 0x00e6 }
        com.tencent.open.a.j.b(r5, r6);	 Catch:{ ConnectTimeoutException -> 0x00ce, SocketTimeoutException -> 0x00db, Exception -> 0x00e6 }
        r5 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r2 != r5) goto L_0x00a6;
    L_0x009b:
        r2 = com.tencent.open.b.f.a();	 Catch:{ ConnectTimeoutException -> 0x00ce, SocketTimeoutException -> 0x00db, Exception -> 0x00e6 }
        r5 = "report_cgi";
        r2.b(r5);	 Catch:{ ConnectTimeoutException -> 0x00ce, SocketTimeoutException -> 0x00db, Exception -> 0x00e6 }
        r1 = 1;
    L_0x00a6:
        if (r1 != 0) goto L_0x00b6;
    L_0x00a8:
        r0 = com.tencent.open.b.f.a();	 Catch:{ Exception -> 0x00bf }
        r1 = "report_cgi";
        r2 = r8.a;	 Catch:{ Exception -> 0x00bf }
        r2 = r2.c;	 Catch:{ Exception -> 0x00bf }
        r0.a(r1, r2);	 Catch:{ Exception -> 0x00bf }
    L_0x00b6:
        r0 = r8.a;	 Catch:{ Exception -> 0x00bf }
        r0 = r0.c;	 Catch:{ Exception -> 0x00bf }
        r0.clear();	 Catch:{ Exception -> 0x00bf }
        goto L_0x0009;
    L_0x00bf:
        r0 = move-exception;
        r1 = "openSDK_LOG.ReportManager";
        r2 = "-->doReportCgi, doupload exception out.";
        com.tencent.open.a.j.a(r1, r2, r0);
        goto L_0x0009;
    L_0x00cb:
        r3 = r0;
        goto L_0x001e;
    L_0x00ce:
        r2 = move-exception;
        r5 = "openSDK_LOG.ReportManager";
        r6 = "-->doReportCgi, doupload exception";
        com.tencent.open.a.j.a(r5, r6, r2);	 Catch:{ Exception -> 0x00bf }
    L_0x00d8:
        if (r0 < r3) goto L_0x0039;
    L_0x00da:
        goto L_0x00a6;
    L_0x00db:
        r2 = move-exception;
        r5 = "openSDK_LOG.ReportManager";
        r6 = "-->doReportCgi, doupload exception";
        com.tencent.open.a.j.a(r5, r6, r2);	 Catch:{ Exception -> 0x00bf }
        goto L_0x00d8;
    L_0x00e6:
        r0 = move-exception;
        r2 = "openSDK_LOG.ReportManager";
        r3 = "-->doReportCgi, doupload exception";
        com.tencent.open.a.j.a(r2, r3, r0);	 Catch:{ Exception -> 0x00bf }
        goto L_0x00a6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.b.k.run():void");
    }
}
