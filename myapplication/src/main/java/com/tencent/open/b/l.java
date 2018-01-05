package com.tencent.open.b;

class l implements Runnable {
    final /* synthetic */ g a;

    l(g gVar) {
        this.a = gVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
        r18 = this;
        r0 = r18;
        r2 = r0.a;	 Catch:{ Exception -> 0x00ac }
        r14 = r2.d();	 Catch:{ Exception -> 0x00ac }
        if (r14 != 0) goto L_0x000b;
    L_0x000a:
        return;
    L_0x000b:
        r2 = "openSDK_LOG.ReportManager";
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00ac }
        r3.<init>();	 Catch:{ Exception -> 0x00ac }
        r4 = "-->doReportVia, params: ";
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x00ac }
        r4 = r14.toString();	 Catch:{ Exception -> 0x00ac }
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x00ac }
        r3 = r3.toString();	 Catch:{ Exception -> 0x00ac }
        com.tencent.open.a.j.a(r2, r3);	 Catch:{ Exception -> 0x00ac }
        r11 = com.tencent.open.b.e.a();	 Catch:{ Exception -> 0x00ac }
        r10 = 0;
        r3 = 0;
        r8 = android.os.SystemClock.elapsedRealtime();	 Catch:{ Exception -> 0x00ac }
        r6 = 0;
        r4 = 0;
        r2 = 0;
    L_0x0038:
        r10 = r10 + 1;
        r12 = com.tencent.open.d.e.a();	 Catch:{ ConnectTimeoutException -> 0x00bb, SocketTimeoutException -> 0x00cb, JSONException -> 0x00d6, l -> 0x00dd, i -> 0x00f2, IOException -> 0x0113, Exception -> 0x011e }
        r13 = "http://appsupport.qq.com/cgi-bin/appstage/mstats_batch_report";
        r15 = "POST";
        r15 = com.tencent.open.d.f.a(r12, r13, r15, r14);	 Catch:{ ConnectTimeoutException -> 0x00bb, SocketTimeoutException -> 0x00cb, JSONException -> 0x00d6, l -> 0x00dd, i -> 0x00f2, IOException -> 0x0113, Exception -> 0x011e }
        r12 = r15.a;	 Catch:{ ConnectTimeoutException -> 0x00bb, SocketTimeoutException -> 0x00cb, JSONException -> 0x00d6, l -> 0x00dd, i -> 0x00f2, IOException -> 0x0113, Exception -> 0x011e }
        r12 = com.tencent.open.d.u.c(r12);	 Catch:{ ConnectTimeoutException -> 0x00bb, SocketTimeoutException -> 0x00cb, JSONException -> 0x00d6, l -> 0x00dd, i -> 0x00f2, IOException -> 0x0113, Exception -> 0x011e }
        r13 = "ret";
        r12 = r12.getInt(r13);	 Catch:{ JSONException -> 0x00b8, ConnectTimeoutException -> 0x00bb, SocketTimeoutException -> 0x00cb, l -> 0x00dd, i -> 0x00f2, IOException -> 0x0113, Exception -> 0x011e }
    L_0x0055:
        if (r12 == 0) goto L_0x005f;
    L_0x0057:
        r12 = r15.a;	 Catch:{ ConnectTimeoutException -> 0x00bb, SocketTimeoutException -> 0x00cb, JSONException -> 0x00d6, l -> 0x00dd, i -> 0x00f2, IOException -> 0x0113, Exception -> 0x011e }
        r12 = android.text.TextUtils.isEmpty(r12);	 Catch:{ ConnectTimeoutException -> 0x00bb, SocketTimeoutException -> 0x00cb, JSONException -> 0x00d6, l -> 0x00dd, i -> 0x00f2, IOException -> 0x0113, Exception -> 0x011e }
        if (r12 != 0) goto L_0x0061;
    L_0x005f:
        r3 = 1;
        r10 = r11;
    L_0x0061:
        r12 = r15.b;	 Catch:{ ConnectTimeoutException -> 0x00bb, SocketTimeoutException -> 0x00cb, JSONException -> 0x00d6, l -> 0x00dd, i -> 0x00f2, IOException -> 0x0113, Exception -> 0x011e }
        r4 = r15.c;	 Catch:{ ConnectTimeoutException -> 0x00bb, SocketTimeoutException -> 0x00cb, JSONException -> 0x00d6, l -> 0x00dd, i -> 0x013b, IOException -> 0x0113, Exception -> 0x011e }
        r6 = r12;
    L_0x0066:
        if (r10 < r11) goto L_0x0038;
    L_0x0068:
        r10 = r2;
        r13 = r3;
        r16 = r8;
        r8 = r4;
        r4 = r16;
    L_0x006f:
        r0 = r18;
        r2 = r0.a;	 Catch:{ Exception -> 0x00ac }
        r3 = "mapp_apptrace_sdk";
        r11 = 0;
        r12 = 0;
        r2.a(r3, r4, r6, r8, r10, r11, r12);	 Catch:{ Exception -> 0x00ac }
        if (r13 == 0) goto L_0x0127;
    L_0x007d:
        r2 = com.tencent.open.b.f.a();	 Catch:{ Exception -> 0x00ac }
        r3 = "report_via";
        r2.b(r3);	 Catch:{ Exception -> 0x00ac }
    L_0x0087:
        r0 = r18;
        r2 = r0.a;	 Catch:{ Exception -> 0x00ac }
        r2 = r2.d;	 Catch:{ Exception -> 0x00ac }
        r2.clear();	 Catch:{ Exception -> 0x00ac }
        r2 = "openSDK_LOG.ReportManager";
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00ac }
        r3.<init>();	 Catch:{ Exception -> 0x00ac }
        r4 = "-->doReportVia, uploadSuccess: ";
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x00ac }
        r3 = r3.append(r13);	 Catch:{ Exception -> 0x00ac }
        r3 = r3.toString();	 Catch:{ Exception -> 0x00ac }
        com.tencent.open.a.j.b(r2, r3);	 Catch:{ Exception -> 0x00ac }
        goto L_0x000a;
    L_0x00ac:
        r2 = move-exception;
        r3 = "openSDK_LOG.ReportManager";
        r4 = "-->doReportVia, exception in serial executor.";
        com.tencent.open.a.j.a(r3, r4, r2);
        goto L_0x000a;
    L_0x00b8:
        r12 = move-exception;
        r12 = -4;
        goto L_0x0055;
    L_0x00bb:
        r2 = move-exception;
        r2 = r10;
        r8 = android.os.SystemClock.elapsedRealtime();	 Catch:{ Exception -> 0x00ac }
        r12 = 0;
        r6 = 0;
        r4 = -7;
        r10 = r2;
        r2 = r4;
        r4 = r6;
        r6 = r12;
        goto L_0x0066;
    L_0x00cb:
        r2 = move-exception;
        r8 = android.os.SystemClock.elapsedRealtime();	 Catch:{ Exception -> 0x00ac }
        r6 = 0;
        r4 = 0;
        r2 = -8;
        goto L_0x0066;
    L_0x00d6:
        r2 = move-exception;
        r6 = 0;
        r4 = 0;
        r2 = -4;
        goto L_0x0066;
    L_0x00dd:
        r2 = move-exception;
        r0 = r18;
        r2 = r0.a;	 Catch:{ Exception -> 0x00ac }
        r2 = r2.d;	 Catch:{ Exception -> 0x00ac }
        r2.clear();	 Catch:{ Exception -> 0x00ac }
        r2 = "openSDK_LOG.ReportManager";
        r3 = "doReportVia, NetworkUnavailableException.";
        com.tencent.open.a.j.b(r2, r3);	 Catch:{ Exception -> 0x00ac }
        goto L_0x000a;
    L_0x00f2:
        r10 = move-exception;
        r16 = r10;
        r10 = r3;
        r3 = r16;
    L_0x00f8:
        r3 = r3.getMessage();	 Catch:{ Exception -> 0x0139 }
        r11 = "http status code error:";
        r12 = "";
        r3 = r3.replace(r11, r12);	 Catch:{ Exception -> 0x0139 }
        r2 = java.lang.Integer.parseInt(r3);	 Catch:{ Exception -> 0x0139 }
    L_0x010a:
        r13 = r10;
        r10 = r2;
        r16 = r8;
        r8 = r4;
        r4 = r16;
        goto L_0x006f;
    L_0x0113:
        r2 = move-exception;
        r6 = 0;
        r4 = 0;
        r2 = com.tencent.open.d.f.a(r2);	 Catch:{ Exception -> 0x00ac }
        goto L_0x0066;
    L_0x011e:
        r2 = move-exception;
        r6 = 0;
        r4 = 0;
        r2 = -6;
        r10 = r11;
        goto L_0x0066;
    L_0x0127:
        r2 = com.tencent.open.b.f.a();	 Catch:{ Exception -> 0x00ac }
        r3 = "report_via";
        r0 = r18;
        r4 = r0.a;	 Catch:{ Exception -> 0x00ac }
        r4 = r4.d;	 Catch:{ Exception -> 0x00ac }
        r2.a(r3, r4);	 Catch:{ Exception -> 0x00ac }
        goto L_0x0087;
    L_0x0139:
        r3 = move-exception;
        goto L_0x010a;
    L_0x013b:
        r6 = move-exception;
        r10 = r3;
        r3 = r6;
        r6 = r12;
        goto L_0x00f8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.b.l.run():void");
    }
}
