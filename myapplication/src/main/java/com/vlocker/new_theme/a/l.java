package com.vlocker.new_theme.a;

public class l {
    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object a(org.apache.http.HttpEntity r13, com.vlocker.new_theme.a.a r14, java.lang.String r15) {
        /*
        r12 = this;
        r0 = 0;
        if (r13 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r7 = new java.io.ByteArrayOutputStream;
        r7.<init>();
        r8 = r13.getContent();
        r1 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;
        r9 = new byte[r1];	 Catch:{ Exception -> 0x002c, all -> 0x004e }
        r2 = r13.getContentLength();	 Catch:{ Exception -> 0x002c, all -> 0x004e }
        r4 = 0;
    L_0x0017:
        r1 = r8.read(r9);	 Catch:{ Exception -> 0x002c, all -> 0x004e }
        r6 = -1;
        if (r1 == r6) goto L_0x003a;
    L_0x001e:
        r6 = 0;
        r7.write(r9, r6, r1);	 Catch:{ Exception -> 0x002c, all -> 0x004e }
        r10 = (long) r1;	 Catch:{ Exception -> 0x002c, all -> 0x004e }
        r4 = r4 + r10;
        if (r14 == 0) goto L_0x0017;
    L_0x0026:
        r6 = 0;
        r1 = r14;
        r1.a(r2, r4, r6);	 Catch:{ Exception -> 0x002c, all -> 0x004e }
        goto L_0x0017;
    L_0x002c:
        r1 = move-exception;
        r7.close();	 Catch:{ Exception -> 0x0058 }
    L_0x0030:
        r8.close();	 Catch:{ Exception -> 0x005a }
    L_0x0033:
        r1 = new java.lang.String;
        r1.<init>(r0, r15);
        r0 = r1;
        goto L_0x0003;
    L_0x003a:
        if (r14 == 0) goto L_0x0041;
    L_0x003c:
        r6 = 1;
        r1 = r14;
        r1.a(r2, r4, r6);	 Catch:{ Exception -> 0x002c, all -> 0x004e }
    L_0x0041:
        r0 = r7.toByteArray();	 Catch:{ Exception -> 0x002c, all -> 0x004e }
        r7.close();	 Catch:{ Exception -> 0x0056 }
    L_0x0048:
        r8.close();	 Catch:{ Exception -> 0x004c }
        goto L_0x0033;
    L_0x004c:
        r1 = move-exception;
        goto L_0x0033;
    L_0x004e:
        r0 = move-exception;
        r7.close();	 Catch:{ Exception -> 0x005c }
    L_0x0052:
        r8.close();	 Catch:{ Exception -> 0x005e }
    L_0x0055:
        throw r0;
    L_0x0056:
        r1 = move-exception;
        goto L_0x0048;
    L_0x0058:
        r1 = move-exception;
        goto L_0x0030;
    L_0x005a:
        r1 = move-exception;
        goto L_0x0033;
    L_0x005c:
        r1 = move-exception;
        goto L_0x0052;
    L_0x005e:
        r1 = move-exception;
        goto L_0x0055;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vlocker.new_theme.a.l.a(org.apache.http.HttpEntity, com.vlocker.new_theme.a.a, java.lang.String):java.lang.Object");
    }
}
