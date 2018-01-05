package com.baidu.mobads.h;

import android.os.Handler;
import com.baidu.mobads.h.g.c;

class n implements Runnable {
    final /* synthetic */ c a;
    final /* synthetic */ Handler b;
    final /* synthetic */ g c;

    n(g gVar, c cVar, Handler handler) {
        this.c = gVar;
        this.a = cVar;
        this.b = handler;
    }

    public void run() {
        /* JADX: method processing error */
/*
Error: java.util.NoSuchElementException
	at java.util.HashMap$HashIterator.nextNode(HashMap.java:1431)
	at java.util.HashMap$KeyIterator.next(HashMap.java:1453)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.applyRemove(BlockFinallyExtract.java:535)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.extractFinally(BlockFinallyExtract.java:175)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.processExceptionHandler(BlockFinallyExtract.java:79)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:51)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r6 = this;
        r5 = 9;
        r1 = com.baidu.mobads.h.g.class;	 Catch:{ Throwable -> 0x0030 }
        monitor-enter(r1);	 Catch:{ Throwable -> 0x0030 }
        r0 = r6.c;	 Catch:{ Throwable -> 0x0030 }
        r2 = r6.a;	 Catch:{ Throwable -> 0x0030 }
        r3 = r6.b;	 Catch:{ Throwable -> 0x0030 }
        r0.b(r2, r3);	 Catch:{ Throwable -> 0x0030 }
        monitor-exit(r1);	 Catch:{ Throwable -> 0x0030 }
        r0 = r6.c;
        r0 = r0.j();
        r0 = r0.edit();
        r1 = "previousProxyVersion";
        r2 = r6.c;
        r2 = r2.a();
        r0.putString(r1, r2);
        r1 = android.os.Build.VERSION.SDK_INT;
        if (r1 < r5) goto L_0x0082;
    L_0x0029:
        r0.apply();
    L_0x002c:
        return;
    L_0x002d:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ Throwable -> 0x0030 }
        throw r0;	 Catch:{ Throwable -> 0x0030 }
    L_0x0030:
        r0 = move-exception;
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x008a }
        r1.<init>();	 Catch:{ all -> 0x008a }
        r2 = "Load APK Failed: ";	 Catch:{ all -> 0x008a }
        r1 = r1.append(r2);	 Catch:{ all -> 0x008a }
        r0 = r0.toString();	 Catch:{ all -> 0x008a }
        r0 = r1.append(r0);	 Catch:{ all -> 0x008a }
        r0 = r0.toString();	 Catch:{ all -> 0x008a }
        r1 = r6.c;	 Catch:{ all -> 0x008a }
        r1 = r1.l;	 Catch:{ all -> 0x008a }
        r2 = 2;	 Catch:{ all -> 0x008a }
        r2 = new java.lang.Object[r2];	 Catch:{ all -> 0x008a }
        r3 = 0;	 Catch:{ all -> 0x008a }
        r4 = "XAdApkLoader";	 Catch:{ all -> 0x008a }
        r2[r3] = r4;	 Catch:{ all -> 0x008a }
        r3 = 1;	 Catch:{ all -> 0x008a }
        r2[r3] = r0;	 Catch:{ all -> 0x008a }
        r1.e(r2);	 Catch:{ all -> 0x008a }
        r0 = r6.c;	 Catch:{ all -> 0x008a }
        r1 = 0;	 Catch:{ all -> 0x008a }
        r0.b(r1);	 Catch:{ all -> 0x008a }
        r0 = r6.c;
        r0 = r0.j();
        r0 = r0.edit();
        r1 = "previousProxyVersion";
        r2 = r6.c;
        r2 = r2.a();
        r0.putString(r1, r2);
        r1 = android.os.Build.VERSION.SDK_INT;
        if (r1 < r5) goto L_0x0086;
    L_0x007e:
        r0.apply();
        goto L_0x002c;
    L_0x0082:
        r0.commit();
        goto L_0x002c;
    L_0x0086:
        r0.commit();
        goto L_0x002c;
    L_0x008a:
        r0 = move-exception;
        r1 = r6.c;
        r1 = r1.j();
        r1 = r1.edit();
        r2 = "previousProxyVersion";
        r3 = r6.c;
        r3 = r3.a();
        r1.putString(r2, r3);
        r2 = android.os.Build.VERSION.SDK_INT;
        if (r2 < r5) goto L_0x00a9;
    L_0x00a5:
        r1.apply();
    L_0x00a8:
        throw r0;
    L_0x00a9:
        r1.commit();
        goto L_0x00a8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.h.n.run():void");
    }
}
