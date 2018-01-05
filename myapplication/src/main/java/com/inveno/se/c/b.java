package com.inveno.se.c;

import android.content.Context;
import com.inveno.a.ai;
import com.inveno.se.e.c;

class b implements ai {
    final /* synthetic */ Context a;
    final /* synthetic */ a b;

    b(a aVar, Context context) {
        this.b = aVar;
        this.a = context;
    }

    public void a(String str) {
        int size = this.b.c.size();
        if (size != 0) {
            for (int i = 0; i < size; i++) {
                ((c) this.b.c.get(i)).b();
            }
        }
        this.b.c.clear();
        this.b.d = false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(org.json.JSONObject r6) {
        /*
        r5 = this;
        r2 = 0;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "获取到uid了：";
        r0 = r0.append(r1);
        r0 = r0.append(r6);
        r0 = r0.toString();
        com.inveno.se.f.a.b(r0);
        r0 = com.inveno.se.a.d.a(r6);	 Catch:{ JSONException -> 0x00ce }
        r1 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        r3 = r0.a();	 Catch:{ JSONException -> 0x00ce }
        if (r1 != r3) goto L_0x0105;
    L_0x0024:
        r1 = "uid";
        r1 = r6.getString(r1);	 Catch:{ JSONException -> 0x00ce }
        r1 = com.inveno.se.f.k.b(r1);	 Catch:{ JSONException -> 0x00ce }
        if (r1 == 0) goto L_0x0105;
    L_0x0031:
        r0 = r5.b;	 Catch:{ JSONException -> 0x00ce }
        r1 = "uid";
        r1 = r6.getString(r1);	 Catch:{ JSONException -> 0x00ce }
        r0.e = r1;	 Catch:{ JSONException -> 0x00ce }
        r0 = r6.toString();	 Catch:{ Exception -> 0x00c3 }
        r1 = r5.a;	 Catch:{ Exception -> 0x00c3 }
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00c3 }
        r3.<init>();	 Catch:{ Exception -> 0x00c3 }
        r4 = "config";
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x00c3 }
        r4 = java.io.File.separator;	 Catch:{ Exception -> 0x00c3 }
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x00c3 }
        r4 = "adam";
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x00c3 }
        r3 = r3.toString();	 Catch:{ Exception -> 0x00c3 }
        r1 = com.inveno.se.f.j.a(r1, r3);	 Catch:{ Exception -> 0x00c3 }
        com.inveno.se.f.k.a(r0, r1);	 Catch:{ Exception -> 0x00c3 }
    L_0x0067:
        r0 = com.inveno.a.l.a();	 Catch:{ JSONException -> 0x00ce }
        r0 = r0.A();	 Catch:{ JSONException -> 0x00ce }
        r0 = com.inveno.se.f.k.a(r0);	 Catch:{ JSONException -> 0x00ce }
        if (r0 == 0) goto L_0x0082;
    L_0x0075:
        r0 = com.inveno.a.l.a();	 Catch:{ JSONException -> 0x00ce }
        r1 = r5.b;	 Catch:{ JSONException -> 0x00ce }
        r1 = r1.e;	 Catch:{ JSONException -> 0x00ce }
        r0.q(r1);	 Catch:{ JSONException -> 0x00ce }
    L_0x0082:
        r0 = r5.a;	 Catch:{ JSONException -> 0x00ce }
        r0 = com.inveno.se.model.a.a(r0);	 Catch:{ JSONException -> 0x00ce }
        r0 = r0.a();	 Catch:{ JSONException -> 0x00ce }
        r0 = com.inveno.se.f.k.a(r0);	 Catch:{ JSONException -> 0x00ce }
        if (r0 == 0) goto L_0x00a1;
    L_0x0092:
        r0 = r5.a;	 Catch:{ JSONException -> 0x00ce }
        r0 = com.inveno.se.model.a.a(r0);	 Catch:{ JSONException -> 0x00ce }
        r1 = r5.b;	 Catch:{ JSONException -> 0x00ce }
        r1 = r1.e;	 Catch:{ JSONException -> 0x00ce }
        r0.a(r1);	 Catch:{ JSONException -> 0x00ce }
    L_0x00a1:
        r0 = r5.b;	 Catch:{ JSONException -> 0x00ce }
        r0 = r0.c;	 Catch:{ JSONException -> 0x00ce }
        r3 = r0.size();	 Catch:{ JSONException -> 0x00ce }
        if (r3 == 0) goto L_0x00ff;
    L_0x00ad:
        r1 = r2;
    L_0x00ae:
        if (r1 >= r3) goto L_0x00f6;
    L_0x00b0:
        r0 = r5.b;	 Catch:{ JSONException -> 0x00ce }
        r0 = r0.c;	 Catch:{ JSONException -> 0x00ce }
        r0 = r0.get(r1);	 Catch:{ JSONException -> 0x00ce }
        r0 = (com.inveno.se.e.c) r0;	 Catch:{ JSONException -> 0x00ce }
        r0.a();	 Catch:{ JSONException -> 0x00ce }
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x00ae;
    L_0x00c3:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ JSONException -> 0x00ce }
        r0 = "保存uid到本地失败";
        com.inveno.se.f.a.b(r0);	 Catch:{ JSONException -> 0x00ce }
        goto L_0x0067;
    L_0x00ce:
        r0 = move-exception;
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0136 }
        r1.<init>();	 Catch:{ all -> 0x0136 }
        r3 = "解析UIDjson数据异常";
        r1 = r1.append(r3);	 Catch:{ all -> 0x0136 }
        r1 = r1.append(r6);	 Catch:{ all -> 0x0136 }
        r1 = r1.toString();	 Catch:{ all -> 0x0136 }
        com.inveno.se.f.a.b(r1);	 Catch:{ all -> 0x0136 }
        com.inveno.se.f.o.a();	 Catch:{ all -> 0x0136 }
        r0 = r0.getMessage();	 Catch:{ all -> 0x0136 }
        r5.a(r0);	 Catch:{ all -> 0x0136 }
        r0 = r5.b;
        r0.d = r2;
    L_0x00f5:
        return;
    L_0x00f6:
        r0 = r5.b;	 Catch:{ JSONException -> 0x00ce }
        r0 = r0.c;	 Catch:{ JSONException -> 0x00ce }
        r0.clear();	 Catch:{ JSONException -> 0x00ce }
    L_0x00ff:
        r0 = r5.b;
        r0.d = r2;
        goto L_0x00f5;
    L_0x0105:
        r1 = new java.lang.StringBuilder;	 Catch:{ JSONException -> 0x00ce }
        r1.<init>();	 Catch:{ JSONException -> 0x00ce }
        r3 = "uid获取异常，服务器返回码为：";
        r1 = r1.append(r3);	 Catch:{ JSONException -> 0x00ce }
        r0 = r0.a();	 Catch:{ JSONException -> 0x00ce }
        r0 = r1.append(r0);	 Catch:{ JSONException -> 0x00ce }
        r0 = r0.toString();	 Catch:{ JSONException -> 0x00ce }
        com.inveno.se.f.a.b(r0);	 Catch:{ JSONException -> 0x00ce }
        r0 = r5.b;	 Catch:{ JSONException -> 0x00ce }
        r0 = r0.b;	 Catch:{ JSONException -> 0x00ce }
        r1 = 5;
        if (r0 > r1) goto L_0x013d;
    L_0x0129:
        r0 = r5.b;	 Catch:{ JSONException -> 0x00ce }
        r0.b = r0.b + 1;	 Catch:{ JSONException -> 0x00ce }
        r0 = r5.b;	 Catch:{ JSONException -> 0x00ce }
        r1 = r5.a;	 Catch:{ JSONException -> 0x00ce }
        r0.b(r1);	 Catch:{ JSONException -> 0x00ce }
        goto L_0x00ff;
    L_0x0136:
        r0 = move-exception;
        r1 = r5.b;
        r1.d = r2;
        throw r0;
    L_0x013d:
        r0 = r5.b;	 Catch:{ JSONException -> 0x00ce }
        r0 = r0.c;	 Catch:{ JSONException -> 0x00ce }
        r3 = r0.size();	 Catch:{ JSONException -> 0x00ce }
        if (r3 == 0) goto L_0x015f;
    L_0x0149:
        r1 = r2;
    L_0x014a:
        if (r1 >= r3) goto L_0x015f;
    L_0x014c:
        r0 = r5.b;	 Catch:{ JSONException -> 0x00ce }
        r0 = r0.c;	 Catch:{ JSONException -> 0x00ce }
        r0 = r0.get(r1);	 Catch:{ JSONException -> 0x00ce }
        r0 = (com.inveno.se.e.c) r0;	 Catch:{ JSONException -> 0x00ce }
        r0.b();	 Catch:{ JSONException -> 0x00ce }
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x014a;
    L_0x015f:
        r0 = r5.b;	 Catch:{ JSONException -> 0x00ce }
        r0 = r0.c;	 Catch:{ JSONException -> 0x00ce }
        r0.clear();	 Catch:{ JSONException -> 0x00ce }
        goto L_0x00ff;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inveno.se.c.b.a(org.json.JSONObject):void");
    }
}
