package com.mx.http;

import java.net.URLConnection;
import java.util.Map;
import java.util.Map.Entry;
import javax.net.ssl.SSLSocketFactory;

public class d implements c {
    private final SSLSocketFactory a;
    private final e b;

    public d() {
        this(null);
    }

    public d(e eVar) {
        this(eVar, null);
    }

    public d(e eVar, SSLSocketFactory sSLSocketFactory) {
        this.b = eVar;
        this.a = sSLSocketFactory;
    }

    private static String a(Map map) {
        StringBuffer stringBuffer = new StringBuffer();
        if (map == null || "".equals(map)) {
            return "";
        }
        for (String str : map.keySet()) {
            String str2 = (String) map.get(str);
            if (stringBuffer.length() < 1) {
                stringBuffer.append(str).append("=").append(str2);
            } else {
                stringBuffer.append("&").append(str).append("=").append(str2);
            }
        }
        return stringBuffer.toString().trim();
    }

    private void a(URLConnection uRLConnection) {
        uRLConnection.setRequestProperty("Content-Type", a.n);
        uRLConnection.setRequestProperty("Connection", "Keep-Alive");
        Map map = a.o;
        if (map != null && map.size() > 0) {
            for (Entry entry : map.entrySet()) {
                String str = (String) entry.getValue();
                if (!(str == null || "".equals(str))) {
                    uRLConnection.setRequestProperty((String) entry.getKey(), str);
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void c(com.mx.http.j r10, com.mx.http.g r11) {
        /*
        r9 = this;
        r3 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        r2 = 0;
        r0 = r10.e();
        r1 = 0;
        r4 = new java.net.URL;	 Catch:{ Exception -> 0x0131, all -> 0x00fa }
        r4.<init>(r0);	 Catch:{ Exception -> 0x0131, all -> 0x00fa }
        r0 = r4.openConnection();	 Catch:{ Exception -> 0x0131, all -> 0x00fa }
        r0 = (java.net.HttpURLConnection) r0;	 Catch:{ Exception -> 0x0131, all -> 0x00fa }
        r4 = "POST";
        r0.setRequestMethod(r4);	 Catch:{ Exception -> 0x0136, all -> 0x011a }
        r4 = com.mx.http.a.d;	 Catch:{ Exception -> 0x0136, all -> 0x011a }
        r0.setReadTimeout(r4);	 Catch:{ Exception -> 0x0136, all -> 0x011a }
        r4 = com.mx.http.a.d;	 Catch:{ Exception -> 0x0136, all -> 0x011a }
        r0.setConnectTimeout(r4);	 Catch:{ Exception -> 0x0136, all -> 0x011a }
        r9.a(r0);	 Catch:{ Exception -> 0x0136, all -> 0x011a }
        r0.connect();	 Catch:{ Exception -> 0x0136, all -> 0x011a }
        r4 = r10.f();	 Catch:{ Exception -> 0x0136, all -> 0x011a }
        if (r4 == 0) goto L_0x0059;
    L_0x002f:
        r4 = r10.f();	 Catch:{ Exception -> 0x0136, all -> 0x011a }
        r4 = r4.size();	 Catch:{ Exception -> 0x0136, all -> 0x011a }
        if (r4 <= 0) goto L_0x0059;
    L_0x0039:
        r4 = r10.f();	 Catch:{ Exception -> 0x0136, all -> 0x011a }
        r4 = a(r4);	 Catch:{ Exception -> 0x0136, all -> 0x011a }
        r5 = android.text.TextUtils.isEmpty(r4);	 Catch:{ Exception -> 0x0136, all -> 0x011a }
        if (r5 != 0) goto L_0x0059;
    L_0x0047:
        r5 = new java.io.PrintWriter;	 Catch:{ Exception -> 0x0136, all -> 0x011a }
        r6 = r0.getOutputStream();	 Catch:{ Exception -> 0x0136, all -> 0x011a }
        r5.<init>(r6);	 Catch:{ Exception -> 0x0136, all -> 0x011a }
        r5.write(r4);	 Catch:{ Exception -> 0x0136, all -> 0x011a }
        r5.flush();	 Catch:{ Exception -> 0x0136, all -> 0x011a }
        r5.close();	 Catch:{ Exception -> 0x0136, all -> 0x011a }
    L_0x0059:
        r4 = r0.getInputStream();	 Catch:{ Exception -> 0x0136, all -> 0x011a }
        r5 = r0.getResponseCode();	 Catch:{ Exception -> 0x013c, all -> 0x0120 }
        if (r5 != r3) goto L_0x00c1;
    L_0x0063:
        r3 = new java.io.ByteArrayOutputStream;	 Catch:{ Exception -> 0x0144, all -> 0x0120 }
        r3.<init>();	 Catch:{ Exception -> 0x0144, all -> 0x0120 }
        r1 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r1 = new byte[r1];	 Catch:{ Exception -> 0x00a0, all -> 0x0125 }
    L_0x006c:
        r2 = r4.read(r1);	 Catch:{ Exception -> 0x00a0, all -> 0x0125 }
        r6 = -1;
        if (r2 != r6) goto L_0x009b;
    L_0x0073:
        r1 = r3.toByteArray();	 Catch:{ Exception -> 0x00a0, all -> 0x0125 }
        r2 = "ZGP";
        r6 = "请求处理成功 ~";
        android.util.Log.e(r2, r6);	 Catch:{ Exception -> 0x00a0, all -> 0x0125 }
        r2 = new com.mx.http.i;	 Catch:{ Exception -> 0x00a0, all -> 0x0125 }
        r2.<init>(r1);	 Catch:{ Exception -> 0x00a0, all -> 0x0125 }
        r10.a(r2);	 Catch:{ Exception -> 0x00a0, all -> 0x0125 }
        if (r0 == 0) goto L_0x008d;
    L_0x008a:
        r0.disconnect();	 Catch:{ IOException -> 0x0115 }
    L_0x008d:
        if (r3 == 0) goto L_0x0095;
    L_0x008f:
        r3.flush();	 Catch:{ IOException -> 0x0115 }
        r3.close();	 Catch:{ IOException -> 0x0115 }
    L_0x0095:
        if (r4 == 0) goto L_0x009a;
    L_0x0097:
        r4.close();	 Catch:{ IOException -> 0x0115 }
    L_0x009a:
        return;
    L_0x009b:
        r6 = 0;
        r3.write(r1, r6, r2);	 Catch:{ Exception -> 0x00a0, all -> 0x0125 }
        goto L_0x006c;
    L_0x00a0:
        r1 = move-exception;
        r2 = r4;
        r4 = r0;
        r0 = r1;
        r1 = r3;
        r3 = r5;
    L_0x00a6:
        r11.a(r3, r0);	 Catch:{ all -> 0x012b }
        if (r4 == 0) goto L_0x00ae;
    L_0x00ab:
        r4.disconnect();	 Catch:{ IOException -> 0x00bc }
    L_0x00ae:
        if (r1 == 0) goto L_0x00b6;
    L_0x00b0:
        r1.flush();	 Catch:{ IOException -> 0x00bc }
        r1.close();	 Catch:{ IOException -> 0x00bc }
    L_0x00b6:
        if (r2 == 0) goto L_0x009a;
    L_0x00b8:
        r2.close();	 Catch:{ IOException -> 0x00bc }
        goto L_0x009a;
    L_0x00bc:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x009a;
    L_0x00c1:
        r3 = "ZGP";
        r6 = "请求处理失败 ~";
        android.util.Log.e(r3, r6);	 Catch:{ Exception -> 0x0144, all -> 0x0120 }
        r3 = new java.lang.Exception;	 Catch:{ Exception -> 0x0144, all -> 0x0120 }
        r6 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0144, all -> 0x0120 }
        r7 = "请求失败:";
        r6.<init>(r7);	 Catch:{ Exception -> 0x0144, all -> 0x0120 }
        r6 = r6.append(r5);	 Catch:{ Exception -> 0x0144, all -> 0x0120 }
        r6 = r6.toString();	 Catch:{ Exception -> 0x0144, all -> 0x0120 }
        r3.<init>(r6);	 Catch:{ Exception -> 0x0144, all -> 0x0120 }
        r11.a(r5, r3);	 Catch:{ Exception -> 0x0144, all -> 0x0120 }
        if (r0 == 0) goto L_0x00e7;
    L_0x00e4:
        r0.disconnect();	 Catch:{ IOException -> 0x00f5 }
    L_0x00e7:
        if (r2 == 0) goto L_0x00ef;
    L_0x00e9:
        r1.flush();	 Catch:{ IOException -> 0x00f5 }
        r1.close();	 Catch:{ IOException -> 0x00f5 }
    L_0x00ef:
        if (r4 == 0) goto L_0x009a;
    L_0x00f1:
        r4.close();	 Catch:{ IOException -> 0x00f5 }
        goto L_0x009a;
    L_0x00f5:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x009a;
    L_0x00fa:
        r0 = move-exception;
        r4 = r2;
        r1 = r2;
    L_0x00fd:
        if (r1 == 0) goto L_0x0102;
    L_0x00ff:
        r1.disconnect();	 Catch:{ IOException -> 0x0110 }
    L_0x0102:
        if (r2 == 0) goto L_0x010a;
    L_0x0104:
        r2.flush();	 Catch:{ IOException -> 0x0110 }
        r2.close();	 Catch:{ IOException -> 0x0110 }
    L_0x010a:
        if (r4 == 0) goto L_0x010f;
    L_0x010c:
        r4.close();	 Catch:{ IOException -> 0x0110 }
    L_0x010f:
        throw r0;
    L_0x0110:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x010f;
    L_0x0115:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x009a;
    L_0x011a:
        r1 = move-exception;
        r4 = r2;
        r8 = r1;
        r1 = r0;
        r0 = r8;
        goto L_0x00fd;
    L_0x0120:
        r1 = move-exception;
        r8 = r1;
        r1 = r0;
        r0 = r8;
        goto L_0x00fd;
    L_0x0125:
        r1 = move-exception;
        r2 = r3;
        r8 = r1;
        r1 = r0;
        r0 = r8;
        goto L_0x00fd;
    L_0x012b:
        r0 = move-exception;
        r8 = r1;
        r1 = r4;
        r4 = r2;
        r2 = r8;
        goto L_0x00fd;
    L_0x0131:
        r0 = move-exception;
        r1 = r2;
        r4 = r2;
        goto L_0x00a6;
    L_0x0136:
        r1 = move-exception;
        r4 = r0;
        r0 = r1;
        r1 = r2;
        goto L_0x00a6;
    L_0x013c:
        r1 = move-exception;
        r8 = r1;
        r1 = r2;
        r2 = r4;
        r4 = r0;
        r0 = r8;
        goto L_0x00a6;
    L_0x0144:
        r1 = move-exception;
        r3 = r5;
        r8 = r2;
        r2 = r4;
        r4 = r0;
        r0 = r1;
        r1 = r8;
        goto L_0x00a6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mx.http.d.c(com.mx.http.j, com.mx.http.g):void");
    }

    public void a(j jVar, g gVar) {
        switch (jVar.g()) {
            case 0:
                b(jVar, gVar);
                return;
            case 1:
                c(jVar, gVar);
                return;
            default:
                return;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(com.mx.http.j r10, com.mx.http.g r11) {
        /*
        r9 = this;
        r3 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        r2 = 0;
        r0 = r10.e();
        r1 = 0;
        r4 = new java.net.URL;	 Catch:{ Exception -> 0x0131, all -> 0x00fa }
        r4.<init>(r0);	 Catch:{ Exception -> 0x0131, all -> 0x00fa }
        r0 = r4.openConnection();	 Catch:{ Exception -> 0x0131, all -> 0x00fa }
        r0 = (java.net.HttpURLConnection) r0;	 Catch:{ Exception -> 0x0131, all -> 0x00fa }
        r4 = "GET";
        r0.setRequestMethod(r4);	 Catch:{ Exception -> 0x0136, all -> 0x011a }
        r4 = com.mx.http.a.d;	 Catch:{ Exception -> 0x0136, all -> 0x011a }
        r0.setReadTimeout(r4);	 Catch:{ Exception -> 0x0136, all -> 0x011a }
        r4 = com.mx.http.a.d;	 Catch:{ Exception -> 0x0136, all -> 0x011a }
        r0.setConnectTimeout(r4);	 Catch:{ Exception -> 0x0136, all -> 0x011a }
        r9.a(r0);	 Catch:{ Exception -> 0x0136, all -> 0x011a }
        r0.connect();	 Catch:{ Exception -> 0x0136, all -> 0x011a }
        r4 = r10.f();	 Catch:{ Exception -> 0x0136, all -> 0x011a }
        if (r4 == 0) goto L_0x0059;
    L_0x002f:
        r4 = r10.f();	 Catch:{ Exception -> 0x0136, all -> 0x011a }
        r4 = r4.size();	 Catch:{ Exception -> 0x0136, all -> 0x011a }
        if (r4 <= 0) goto L_0x0059;
    L_0x0039:
        r4 = r10.f();	 Catch:{ Exception -> 0x0136, all -> 0x011a }
        r4 = a(r4);	 Catch:{ Exception -> 0x0136, all -> 0x011a }
        r5 = android.text.TextUtils.isEmpty(r4);	 Catch:{ Exception -> 0x0136, all -> 0x011a }
        if (r5 != 0) goto L_0x0059;
    L_0x0047:
        r5 = new java.io.PrintWriter;	 Catch:{ Exception -> 0x0136, all -> 0x011a }
        r6 = r0.getOutputStream();	 Catch:{ Exception -> 0x0136, all -> 0x011a }
        r5.<init>(r6);	 Catch:{ Exception -> 0x0136, all -> 0x011a }
        r5.write(r4);	 Catch:{ Exception -> 0x0136, all -> 0x011a }
        r5.flush();	 Catch:{ Exception -> 0x0136, all -> 0x011a }
        r5.close();	 Catch:{ Exception -> 0x0136, all -> 0x011a }
    L_0x0059:
        r4 = r0.getInputStream();	 Catch:{ Exception -> 0x0136, all -> 0x011a }
        r5 = r0.getResponseCode();	 Catch:{ Exception -> 0x013c, all -> 0x0120 }
        if (r5 != r3) goto L_0x00c1;
    L_0x0063:
        r3 = new java.io.ByteArrayOutputStream;	 Catch:{ Exception -> 0x0144, all -> 0x0120 }
        r3.<init>();	 Catch:{ Exception -> 0x0144, all -> 0x0120 }
        r1 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r1 = new byte[r1];	 Catch:{ Exception -> 0x00a0, all -> 0x0125 }
    L_0x006c:
        r2 = r4.read(r1);	 Catch:{ Exception -> 0x00a0, all -> 0x0125 }
        r6 = -1;
        if (r2 != r6) goto L_0x009b;
    L_0x0073:
        r1 = r3.toByteArray();	 Catch:{ Exception -> 0x00a0, all -> 0x0125 }
        r2 = "ZGP";
        r6 = "请求处理成功 ~";
        android.util.Log.e(r2, r6);	 Catch:{ Exception -> 0x00a0, all -> 0x0125 }
        r2 = new com.mx.http.i;	 Catch:{ Exception -> 0x00a0, all -> 0x0125 }
        r2.<init>(r1);	 Catch:{ Exception -> 0x00a0, all -> 0x0125 }
        r10.a(r2);	 Catch:{ Exception -> 0x00a0, all -> 0x0125 }
        if (r0 == 0) goto L_0x008d;
    L_0x008a:
        r0.disconnect();	 Catch:{ IOException -> 0x0115 }
    L_0x008d:
        if (r3 == 0) goto L_0x0095;
    L_0x008f:
        r3.flush();	 Catch:{ IOException -> 0x0115 }
        r3.close();	 Catch:{ IOException -> 0x0115 }
    L_0x0095:
        if (r4 == 0) goto L_0x009a;
    L_0x0097:
        r4.close();	 Catch:{ IOException -> 0x0115 }
    L_0x009a:
        return;
    L_0x009b:
        r6 = 0;
        r3.write(r1, r6, r2);	 Catch:{ Exception -> 0x00a0, all -> 0x0125 }
        goto L_0x006c;
    L_0x00a0:
        r1 = move-exception;
        r2 = r4;
        r4 = r0;
        r0 = r1;
        r1 = r3;
        r3 = r5;
    L_0x00a6:
        r11.a(r3, r0);	 Catch:{ all -> 0x012b }
        if (r4 == 0) goto L_0x00ae;
    L_0x00ab:
        r4.disconnect();	 Catch:{ IOException -> 0x00bc }
    L_0x00ae:
        if (r1 == 0) goto L_0x00b6;
    L_0x00b0:
        r1.flush();	 Catch:{ IOException -> 0x00bc }
        r1.close();	 Catch:{ IOException -> 0x00bc }
    L_0x00b6:
        if (r2 == 0) goto L_0x009a;
    L_0x00b8:
        r2.close();	 Catch:{ IOException -> 0x00bc }
        goto L_0x009a;
    L_0x00bc:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x009a;
    L_0x00c1:
        r3 = "ZGP";
        r6 = "请求处理失败 ~";
        android.util.Log.e(r3, r6);	 Catch:{ Exception -> 0x0144, all -> 0x0120 }
        r3 = new java.lang.Exception;	 Catch:{ Exception -> 0x0144, all -> 0x0120 }
        r6 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0144, all -> 0x0120 }
        r7 = "请求失败:";
        r6.<init>(r7);	 Catch:{ Exception -> 0x0144, all -> 0x0120 }
        r6 = r6.append(r5);	 Catch:{ Exception -> 0x0144, all -> 0x0120 }
        r6 = r6.toString();	 Catch:{ Exception -> 0x0144, all -> 0x0120 }
        r3.<init>(r6);	 Catch:{ Exception -> 0x0144, all -> 0x0120 }
        r11.a(r5, r3);	 Catch:{ Exception -> 0x0144, all -> 0x0120 }
        if (r0 == 0) goto L_0x00e7;
    L_0x00e4:
        r0.disconnect();	 Catch:{ IOException -> 0x00f5 }
    L_0x00e7:
        if (r2 == 0) goto L_0x00ef;
    L_0x00e9:
        r1.flush();	 Catch:{ IOException -> 0x00f5 }
        r1.close();	 Catch:{ IOException -> 0x00f5 }
    L_0x00ef:
        if (r4 == 0) goto L_0x009a;
    L_0x00f1:
        r4.close();	 Catch:{ IOException -> 0x00f5 }
        goto L_0x009a;
    L_0x00f5:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x009a;
    L_0x00fa:
        r0 = move-exception;
        r4 = r2;
        r1 = r2;
    L_0x00fd:
        if (r1 == 0) goto L_0x0102;
    L_0x00ff:
        r1.disconnect();	 Catch:{ IOException -> 0x0110 }
    L_0x0102:
        if (r2 == 0) goto L_0x010a;
    L_0x0104:
        r2.flush();	 Catch:{ IOException -> 0x0110 }
        r2.close();	 Catch:{ IOException -> 0x0110 }
    L_0x010a:
        if (r4 == 0) goto L_0x010f;
    L_0x010c:
        r4.close();	 Catch:{ IOException -> 0x0110 }
    L_0x010f:
        throw r0;
    L_0x0110:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x010f;
    L_0x0115:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x009a;
    L_0x011a:
        r1 = move-exception;
        r4 = r2;
        r8 = r1;
        r1 = r0;
        r0 = r8;
        goto L_0x00fd;
    L_0x0120:
        r1 = move-exception;
        r8 = r1;
        r1 = r0;
        r0 = r8;
        goto L_0x00fd;
    L_0x0125:
        r1 = move-exception;
        r2 = r3;
        r8 = r1;
        r1 = r0;
        r0 = r8;
        goto L_0x00fd;
    L_0x012b:
        r0 = move-exception;
        r8 = r1;
        r1 = r4;
        r4 = r2;
        r2 = r8;
        goto L_0x00fd;
    L_0x0131:
        r0 = move-exception;
        r1 = r2;
        r4 = r2;
        goto L_0x00a6;
    L_0x0136:
        r1 = move-exception;
        r4 = r0;
        r0 = r1;
        r1 = r2;
        goto L_0x00a6;
    L_0x013c:
        r1 = move-exception;
        r8 = r1;
        r1 = r2;
        r2 = r4;
        r4 = r0;
        r0 = r8;
        goto L_0x00a6;
    L_0x0144:
        r1 = move-exception;
        r3 = r5;
        r8 = r2;
        r2 = r4;
        r4 = r0;
        r0 = r1;
        r1 = r8;
        goto L_0x00a6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mx.http.d.b(com.mx.http.j, com.mx.http.g):void");
    }
}
