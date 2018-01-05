package com.inveno.se.f;

public class h {
    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] a(byte[] r5) {
        /*
        r0 = 0;
        r0 = new byte[r0];
        r1 = new java.util.zip.Inflater;
        r1.<init>();
        r1.reset();
        r1.setInput(r5);
        r2 = new java.io.ByteArrayOutputStream;
        r0 = r5.length;
        r2.<init>(r0);
        r0 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r0 = new byte[r0];	 Catch:{ Exception -> 0x0027 }
    L_0x0018:
        r3 = r1.finished();	 Catch:{ Exception -> 0x0027 }
        if (r3 != 0) goto L_0x0032;
    L_0x001e:
        r3 = r1.inflate(r0);	 Catch:{ Exception -> 0x0027 }
        r4 = 0;
        r2.write(r0, r4, r3);	 Catch:{ Exception -> 0x0027 }
        goto L_0x0018;
    L_0x0027:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ all -> 0x0044 }
        r2.close();	 Catch:{ IOException -> 0x003f }
    L_0x002e:
        r1.end();
        return r5;
    L_0x0032:
        r5 = r2.toByteArray();	 Catch:{ Exception -> 0x0027 }
        r2.close();	 Catch:{ IOException -> 0x003a }
        goto L_0x002e;
    L_0x003a:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x002e;
    L_0x003f:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x002e;
    L_0x0044:
        r0 = move-exception;
        r2.close();	 Catch:{ IOException -> 0x0049 }
    L_0x0048:
        throw r0;
    L_0x0049:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x0048;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inveno.se.f.h.a(byte[]):byte[]");
    }
}
