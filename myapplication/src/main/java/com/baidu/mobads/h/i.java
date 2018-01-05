package com.baidu.mobads.h;

import android.os.Handler;
import android.os.Looper;

class i extends Handler {
    final /* synthetic */ g a;

    i(g gVar, Looper looper) {
        this.a = gVar;
        super(looper);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handleMessage(android.os.Message r8) {
        /*
        r7 = this;
        r3 = 2;
        r6 = 1;
        r5 = 0;
        r0 = r8.getData();
        r1 = "CODE";
        r1 = r0.getString(r1);
        r0 = r8.getData();
        r2 = "APK_INFO";
        r0 = r0.getParcelable(r2);
        r0 = (com.baidu.mobads.h.e) r0;
        r2 = "OK";
        r2 = r2.equals(r1);
        if (r2 == 0) goto L_0x00a9;
    L_0x0024:
        r1 = new com.baidu.mobads.h.b;
        r2 = r0.e();
        r3 = r7.a;
        r3 = r3.k;
        r1.<init>(r2, r3, r0);
        r2 = r7.a;	 Catch:{ a -> 0x006c }
        r2 = r2.f;	 Catch:{ a -> 0x006c }
        r3 = com.baidu.mobads.h.g.e;	 Catch:{ a -> 0x006c }
        if (r2 != r3) goto L_0x0057;
    L_0x003b:
        r1.a();	 Catch:{ a -> 0x006c }
        r2 = r7.a;	 Catch:{ a -> 0x006c }
        r2 = r2.e();	 Catch:{ a -> 0x006c }
        r1.a(r2);	 Catch:{ a -> 0x006c }
        r2 = com.baidu.mobads.h.g.b;	 Catch:{ a -> 0x006c }
        if (r2 == 0) goto L_0x0053;
    L_0x004b:
        r2 = com.baidu.mobads.h.g.b;	 Catch:{ a -> 0x006c }
        r4 = r0.b();	 Catch:{ a -> 0x006c }
        r2.a = r4;	 Catch:{ a -> 0x006c }
    L_0x0053:
        r1.delete();
    L_0x0056:
        return;
    L_0x0057:
        r0 = r7.a;	 Catch:{ a -> 0x006c }
        r0.a(r1);	 Catch:{ a -> 0x006c }
        r0 = r7.a;	 Catch:{ a -> 0x006c }
        r0 = r0.e();	 Catch:{ a -> 0x006c }
        r1.a(r0);	 Catch:{ a -> 0x006c }
        r0 = r7.a;	 Catch:{ a -> 0x006c }
        r2 = 1;
        r0.a(r2);	 Catch:{ a -> 0x006c }
        goto L_0x0053;
    L_0x006c:
        r0 = move-exception;
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00a4 }
        r2.<init>();	 Catch:{ all -> 0x00a4 }
        r3 = "download apk file failed: ";
        r2 = r2.append(r3);	 Catch:{ all -> 0x00a4 }
        r0 = r0.toString();	 Catch:{ all -> 0x00a4 }
        r0 = r2.append(r0);	 Catch:{ all -> 0x00a4 }
        r0 = r0.toString();	 Catch:{ all -> 0x00a4 }
        r2 = r7.a;	 Catch:{ all -> 0x00a4 }
        r3 = 0;
        r2.a(r3);	 Catch:{ all -> 0x00a4 }
        r2 = r7.a;	 Catch:{ all -> 0x00a4 }
        r2 = r2.l;	 Catch:{ all -> 0x00a4 }
        r3 = 2;
        r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x00a4 }
        r4 = 0;
        r5 = "XAdApkLoader";
        r3[r4] = r5;	 Catch:{ all -> 0x00a4 }
        r4 = 1;
        r3[r4] = r0;	 Catch:{ all -> 0x00a4 }
        r2.e(r3);	 Catch:{ all -> 0x00a4 }
        r1.delete();
        goto L_0x0056;
    L_0x00a4:
        r0 = move-exception;
        r1.delete();
        throw r0;
    L_0x00a9:
        r0 = r7.a;
        r0 = r0.l;
        r2 = new java.lang.Object[r3];
        r3 = "XAdApkLoader";
        r2[r5] = r3;
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "mOnApkDownloadCompleted: download failed, code: ";
        r3 = r3.append(r4);
        r1 = r3.append(r1);
        r1 = r1.toString();
        r2[r6] = r1;
        r0.e(r2);
        r0 = r7.a;
        r0.a(r5);
        goto L_0x0056;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.h.i.handleMessage(android.os.Message):void");
    }
}
