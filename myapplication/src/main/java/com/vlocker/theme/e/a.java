package com.vlocker.theme.e;

public class a {
    private String a() {
        return "/1080_810__40";
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.vlocker.ui.widget.az a(java.lang.String r17) {
        /*
        r16 = this;
        r1 = 0;
        r2 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x02a7, Exception -> 0x02ac }
        r0 = r17;
        r2.<init>(r0);	 Catch:{ JSONException -> 0x02a7, Exception -> 0x02ac }
        r3 = "code";
        r3 = r2.getInt(r3);	 Catch:{ JSONException -> 0x02a7, Exception -> 0x02ac }
        r4 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r3 != r4) goto L_0x02a6;
    L_0x0013:
        r3 = com.vlocker.security.MoSecurityApplication.a();	 Catch:{ JSONException -> 0x02a7, Exception -> 0x02ac }
        r3 = r3.getApplicationContext();	 Catch:{ JSONException -> 0x02a7, Exception -> 0x02ac }
        r3 = com.vlocker.c.a.a(r3);	 Catch:{ JSONException -> 0x02a7, Exception -> 0x02ac }
        r0 = r17;
        r3.D(r0);	 Catch:{ JSONException -> 0x02a7, Exception -> 0x02ac }
        r3 = "data";
        r5 = r2.getJSONObject(r3);	 Catch:{ JSONException -> 0x02a7, Exception -> 0x02ac }
        r2 = "banners";
        r2 = r5.has(r2);	 Catch:{ JSONException -> 0x02a7, Exception -> 0x02ac }
        if (r2 == 0) goto L_0x0183;
    L_0x0034:
        r2 = "banners";
        r6 = r5.getJSONArray(r2);	 Catch:{ JSONException -> 0x02a7, Exception -> 0x02ac }
        r7 = r6.length();	 Catch:{ JSONException -> 0x02a7, Exception -> 0x02ac }
        if (r7 <= 0) goto L_0x0183;
    L_0x0041:
        r2 = new com.vlocker.ui.widget.az;	 Catch:{ JSONException -> 0x02a7, Exception -> 0x02ac }
        r2.<init>();	 Catch:{ JSONException -> 0x02a7, Exception -> 0x02ac }
        r8 = new java.util.ArrayList;	 Catch:{ JSONException -> 0x02b6, Exception -> 0x02b1 }
        r8.<init>();	 Catch:{ JSONException -> 0x02b6, Exception -> 0x02b1 }
        r3 = 0;
        r1 = 0;
        r4 = r1;
    L_0x004e:
        if (r4 >= r7) goto L_0x017f;
    L_0x0050:
        r9 = r6.getJSONObject(r4);	 Catch:{ JSONException -> 0x02b6, Exception -> 0x02b1 }
        r1 = "fixed";
        r10 = 0;
        r1 = r9.optBoolean(r1, r10);	 Catch:{ JSONException -> 0x02b6, Exception -> 0x02b1 }
        r10 = new com.vlocker.ui.widget.ba;	 Catch:{ JSONException -> 0x02b6, Exception -> 0x02b1 }
        r11 = 0;
        r12 = "type";
        r12 = r9.optString(r12);	 Catch:{ JSONException -> 0x02b6, Exception -> 0x02b1 }
        r10.<init>(r11, r12, r1);	 Catch:{ JSONException -> 0x02b6, Exception -> 0x02b1 }
        r1 = new java.lang.StringBuilder;	 Catch:{ JSONException -> 0x02b6, Exception -> 0x02b1 }
        r1.<init>();	 Catch:{ JSONException -> 0x02b6, Exception -> 0x02b1 }
        r11 = "img";
        r11 = r9.optString(r11);	 Catch:{ JSONException -> 0x02b6, Exception -> 0x02b1 }
        r1 = r1.append(r11);	 Catch:{ JSONException -> 0x02b6, Exception -> 0x02b1 }
        r11 = r16.a();	 Catch:{ JSONException -> 0x02b6, Exception -> 0x02b1 }
        r1 = r1.append(r11);	 Catch:{ JSONException -> 0x02b6, Exception -> 0x02b1 }
        r1 = r1.toString();	 Catch:{ JSONException -> 0x02b6, Exception -> 0x02b1 }
        r10.a(r1);	 Catch:{ JSONException -> 0x02b6, Exception -> 0x02b1 }
        r1 = "tag";
        r1 = r9.optString(r1);	 Catch:{ JSONException -> 0x02b6, Exception -> 0x02b1 }
        r10.c(r1);	 Catch:{ JSONException -> 0x02b6, Exception -> 0x02b1 }
        r1 = "title";
        r1 = r9.optString(r1);	 Catch:{ JSONException -> 0x02b6, Exception -> 0x02b1 }
        r10.d(r1);	 Catch:{ JSONException -> 0x02b6, Exception -> 0x02b1 }
        r1 = "dataurl";
        r1 = r9.optString(r1);	 Catch:{ JSONException -> 0x02b6, Exception -> 0x02b1 }
        r10.e(r1);	 Catch:{ JSONException -> 0x02b6, Exception -> 0x02b1 }
        r1 = "sub_type";
        r1 = r9.optString(r1);	 Catch:{ JSONException -> 0x02b6, Exception -> 0x02b1 }
        r10.f(r1);	 Catch:{ JSONException -> 0x02b6, Exception -> 0x02b1 }
        r1 = "type";
        r11 = r9.optString(r1);	 Catch:{ JSONException -> 0x02b6, Exception -> 0x02b1 }
        r1 = android.text.TextUtils.isEmpty(r11);	 Catch:{ JSONException -> 0x02b6, Exception -> 0x02b1 }
        if (r1 != 0) goto L_0x00e0;
    L_0x00bd:
        r1 = "topic";
        r1 = r11.equals(r1);	 Catch:{ JSONException -> 0x02b6, Exception -> 0x02b1 }
        if (r1 == 0) goto L_0x00e0;
    L_0x00c6:
        r1 = new java.lang.StringBuilder;	 Catch:{ JSONException -> 0x02b6, Exception -> 0x02b1 }
        r1.<init>();	 Catch:{ JSONException -> 0x02b6, Exception -> 0x02b1 }
        r12 = "_";
        r12 = r1.append(r12);	 Catch:{ JSONException -> 0x02b6, Exception -> 0x02b1 }
        r1 = r3 + 1;
        r3 = r12.append(r3);	 Catch:{ JSONException -> 0x02b6, Exception -> 0x02b1 }
        r3 = r3.toString();	 Catch:{ JSONException -> 0x02b6, Exception -> 0x02b1 }
        r10.b(r3);	 Catch:{ JSONException -> 0x02b6, Exception -> 0x02b1 }
        r3 = r1;
    L_0x00e0:
        if (r11 == 0) goto L_0x0177;
    L_0x00e2:
        r1 = "apps";
        r1 = r11.equals(r1);	 Catch:{ JSONException -> 0x02b6, Exception -> 0x02b1 }
        if (r1 == 0) goto L_0x0177;
    L_0x00eb:
        r1 = "list";
        r9 = r9.getJSONArray(r1);	 Catch:{ Exception -> 0x02bb, JSONException -> 0x02b6 }
        if (r9 == 0) goto L_0x0177;
    L_0x00f4:
        r1 = r9.length();	 Catch:{ Exception -> 0x02bb, JSONException -> 0x02b6 }
        if (r1 <= 0) goto L_0x0177;
    L_0x00fa:
        r11 = new java.util.ArrayList;	 Catch:{ Exception -> 0x02bb, JSONException -> 0x02b6 }
        r11.<init>();	 Catch:{ Exception -> 0x02bb, JSONException -> 0x02b6 }
        r1 = 0;
    L_0x0100:
        r12 = r9.length();	 Catch:{ Exception -> 0x02bb, JSONException -> 0x02b6 }
        if (r1 >= r12) goto L_0x0174;
    L_0x0106:
        r12 = r9.getJSONObject(r1);	 Catch:{ Exception -> 0x02bb, JSONException -> 0x02b6 }
        r13 = new com.vlocker.update.UpdateApkParamBean;	 Catch:{ Exception -> 0x02bb, JSONException -> 0x02b6 }
        r13.<init>();	 Catch:{ Exception -> 0x02bb, JSONException -> 0x02b6 }
        r14 = "icon";
        r14 = r12.getString(r14);	 Catch:{ Exception -> 0x02bb, JSONException -> 0x02b6 }
        r13.k(r14);	 Catch:{ Exception -> 0x02bb, JSONException -> 0x02b6 }
        r14 = 0;
        r13.b(r14);	 Catch:{ Exception -> 0x02bb, JSONException -> 0x02b6 }
        r14 = "package";
        r14 = r12.getString(r14);	 Catch:{ Exception -> 0x02bb, JSONException -> 0x02b6 }
        r13.f(r14);	 Catch:{ Exception -> 0x02bb, JSONException -> 0x02b6 }
        r14 = com.vlocker.b.i.g;	 Catch:{ Exception -> 0x02bb, JSONException -> 0x02b6 }
        r13.g(r14);	 Catch:{ Exception -> 0x02bb, JSONException -> 0x02b6 }
        r14 = "name";
        r14 = r12.getString(r14);	 Catch:{ Exception -> 0x02bb, JSONException -> 0x02b6 }
        r13.i(r14);	 Catch:{ Exception -> 0x02bb, JSONException -> 0x02b6 }
        r14 = "desc";
        r14 = r12.getString(r14);	 Catch:{ Exception -> 0x02bb, JSONException -> 0x02b6 }
        r13.h(r14);	 Catch:{ Exception -> 0x02bb, JSONException -> 0x02b6 }
        r14 = "downnum";
        r14 = r12.getString(r14);	 Catch:{ Exception -> 0x02c4, JSONException -> 0x02b6 }
        r13.j(r14);	 Catch:{ Exception -> 0x02c4, JSONException -> 0x02b6 }
    L_0x014a:
        r14 = "size";
        r14 = r12.getString(r14);	 Catch:{ Exception -> 0x02c1, JSONException -> 0x02b6 }
        r13.m(r14);	 Catch:{ Exception -> 0x02c1, JSONException -> 0x02b6 }
    L_0x0154:
        r14 = "cover";
        r14 = r12.getString(r14);	 Catch:{ Exception -> 0x02be, JSONException -> 0x02b6 }
        r13.l(r14);	 Catch:{ Exception -> 0x02be, JSONException -> 0x02b6 }
    L_0x015e:
        r14 = 2130837800; // 0x7f020128 float:1.7280564E38 double:1.052773754E-314;
        r13.d(r14);	 Catch:{ Exception -> 0x02bb, JSONException -> 0x02b6 }
        r14 = "downurl";
        r12 = r12.getString(r14);	 Catch:{ Exception -> 0x02bb, JSONException -> 0x02b6 }
        r13.c(r12);	 Catch:{ Exception -> 0x02bb, JSONException -> 0x02b6 }
        r11.add(r13);	 Catch:{ Exception -> 0x02bb, JSONException -> 0x02b6 }
        r1 = r1 + 1;
        goto L_0x0100;
    L_0x0174:
        r10.a(r11);	 Catch:{ Exception -> 0x02bb, JSONException -> 0x02b6 }
    L_0x0177:
        r8.add(r10);	 Catch:{ JSONException -> 0x02b6, Exception -> 0x02b1 }
        r1 = r4 + 1;
        r4 = r1;
        goto L_0x004e;
    L_0x017f:
        r2.a(r8);	 Catch:{ JSONException -> 0x02b6, Exception -> 0x02b1 }
        r1 = r2;
    L_0x0183:
        r2 = "theme2";
        r2 = r5.has(r2);	 Catch:{ JSONException -> 0x02a7, Exception -> 0x02ac }
        if (r2 == 0) goto L_0x01a5;
    L_0x018c:
        r2 = "theme2";
        r2 = r5.getJSONObject(r2);	 Catch:{ JSONException -> 0x02a7, Exception -> 0x02ac }
        r3 = "dataurl";
        r3 = r2.getString(r3);	 Catch:{ JSONException -> 0x02a7, Exception -> 0x02ac }
        com.vlocker.b.i.a = r3;	 Catch:{ JSONException -> 0x02a7, Exception -> 0x02ac }
        r3 = "title";
        r2 = r2.getString(r3);	 Catch:{ JSONException -> 0x02a7, Exception -> 0x02ac }
        com.vlocker.b.i.b = r2;	 Catch:{ JSONException -> 0x02a7, Exception -> 0x02ac }
    L_0x01a5:
        r2 = new com.vlocker.new_theme.beans.g;	 Catch:{ JSONException -> 0x02a7, Exception -> 0x02ac }
        r2.<init>();	 Catch:{ JSONException -> 0x02a7, Exception -> 0x02ac }
        r3 = "topic";
        r3 = r5.has(r3);	 Catch:{ JSONException -> 0x02a7, Exception -> 0x02ac }
        if (r3 == 0) goto L_0x01c4;
    L_0x01b3:
        r3 = "topic";
        r3 = r5.getJSONObject(r3);	 Catch:{ JSONException -> 0x02a7, Exception -> 0x02ac }
        r4 = "dataurl";
        r3 = r3.getString(r4);	 Catch:{ JSONException -> 0x02a7, Exception -> 0x02ac }
        r2.c(r3);	 Catch:{ JSONException -> 0x02a7, Exception -> 0x02ac }
    L_0x01c4:
        r3 = "cate";
        r3 = r5.has(r3);	 Catch:{ JSONException -> 0x02a7, Exception -> 0x02ac }
        if (r3 == 0) goto L_0x01de;
    L_0x01cd:
        r3 = "cate";
        r3 = r5.getJSONObject(r3);	 Catch:{ JSONException -> 0x02a7, Exception -> 0x02ac }
        r4 = "dataurl";
        r3 = r3.getString(r4);	 Catch:{ JSONException -> 0x02a7, Exception -> 0x02ac }
        r2.a(r3);	 Catch:{ JSONException -> 0x02a7, Exception -> 0x02ac }
    L_0x01de:
        r3 = "digest";
        r3 = r5.has(r3);	 Catch:{ JSONException -> 0x02a7, Exception -> 0x02ac }
        if (r3 == 0) goto L_0x01f8;
    L_0x01e7:
        r3 = "digest";
        r3 = r5.getJSONObject(r3);	 Catch:{ JSONException -> 0x02a7, Exception -> 0x02ac }
        r4 = "dataurl";
        r3 = r3.getString(r4);	 Catch:{ JSONException -> 0x02a7, Exception -> 0x02ac }
        r2.b(r3);	 Catch:{ JSONException -> 0x02a7, Exception -> 0x02ac }
    L_0x01f8:
        r3 = "new";
        r3 = r5.has(r3);	 Catch:{ JSONException -> 0x02a7, Exception -> 0x02ac }
        if (r3 == 0) goto L_0x0212;
    L_0x0201:
        r3 = "new";
        r3 = r5.getJSONObject(r3);	 Catch:{ JSONException -> 0x02a7, Exception -> 0x02ac }
        r4 = "dataurl";
        r3 = r3.getString(r4);	 Catch:{ JSONException -> 0x02a7, Exception -> 0x02ac }
        r2.e(r3);	 Catch:{ JSONException -> 0x02a7, Exception -> 0x02ac }
    L_0x0212:
        r3 = "search";
        r3 = r5.has(r3);	 Catch:{ JSONException -> 0x02a7, Exception -> 0x02ac }
        if (r3 == 0) goto L_0x022c;
    L_0x021b:
        r3 = "search";
        r3 = r5.getJSONObject(r3);	 Catch:{ JSONException -> 0x02a7, Exception -> 0x02ac }
        r4 = "dataurl";
        r3 = r3.getString(r4);	 Catch:{ JSONException -> 0x02a7, Exception -> 0x02ac }
        r2.f(r3);	 Catch:{ JSONException -> 0x02a7, Exception -> 0x02ac }
    L_0x022c:
        r3 = "topic";
        r3 = r5.has(r3);	 Catch:{ JSONException -> 0x02a7, Exception -> 0x02ac }
        if (r3 == 0) goto L_0x0246;
    L_0x0235:
        r3 = "tags";
        r3 = r5.getJSONObject(r3);	 Catch:{ JSONException -> 0x02a7, Exception -> 0x02ac }
        r4 = "dataurl";
        r3 = r3.getString(r4);	 Catch:{ JSONException -> 0x02a7, Exception -> 0x02ac }
        r2.d(r3);	 Catch:{ JSONException -> 0x02a7, Exception -> 0x02ac }
    L_0x0246:
        com.vlocker.b.i.o = r2;	 Catch:{ JSONException -> 0x02a7, Exception -> 0x02ac }
        r3 = 0;
        r2 = 0;
        r4 = "switch";
        r4 = r5.has(r4);	 Catch:{ JSONException -> 0x02a7, Exception -> 0x02ac }
        if (r4 == 0) goto L_0x0288;
    L_0x0253:
        r4 = "switch";
        r4 = r5.getJSONObject(r4);	 Catch:{ JSONException -> 0x02a7, Exception -> 0x02ac }
        r5 = "vlocker_packet_notice_webview";
        r5 = r4.has(r5);	 Catch:{ JSONException -> 0x02a7, Exception -> 0x02ac }
        if (r5 == 0) goto L_0x0271;
    L_0x0263:
        r3 = "vlocker_packet_notice_webview";
        r3 = r4.getJSONObject(r3);	 Catch:{ JSONException -> 0x02a7, Exception -> 0x02ac }
        r5 = "force";
        r3 = r3.optBoolean(r5);	 Catch:{ JSONException -> 0x02a7, Exception -> 0x02ac }
    L_0x0271:
        r5 = "vlocker_packet_invite_webview";
        r5 = r4.has(r5);	 Catch:{ JSONException -> 0x02a7, Exception -> 0x02ac }
        if (r5 == 0) goto L_0x0288;
    L_0x027a:
        r2 = "vlocker_packet_invite_webview";
        r2 = r4.getJSONObject(r2);	 Catch:{ JSONException -> 0x02a7, Exception -> 0x02ac }
        r4 = "force";
        r2 = r2.optBoolean(r4);	 Catch:{ JSONException -> 0x02a7, Exception -> 0x02ac }
    L_0x0288:
        r4 = com.vlocker.security.MoSecurityApplication.a();	 Catch:{ JSONException -> 0x02a7, Exception -> 0x02ac }
        r4 = r4.getApplicationContext();	 Catch:{ JSONException -> 0x02a7, Exception -> 0x02ac }
        r4 = com.vlocker.c.a.a(r4);	 Catch:{ JSONException -> 0x02a7, Exception -> 0x02ac }
        r4.ak(r3);	 Catch:{ JSONException -> 0x02a7, Exception -> 0x02ac }
        r3 = com.vlocker.security.MoSecurityApplication.a();	 Catch:{ JSONException -> 0x02a7, Exception -> 0x02ac }
        r3 = r3.getApplicationContext();	 Catch:{ JSONException -> 0x02a7, Exception -> 0x02ac }
        r3 = com.vlocker.c.a.a(r3);	 Catch:{ JSONException -> 0x02a7, Exception -> 0x02ac }
        r3.al(r2);	 Catch:{ JSONException -> 0x02a7, Exception -> 0x02ac }
    L_0x02a6:
        return r1;
    L_0x02a7:
        r2 = move-exception;
    L_0x02a8:
        r2.printStackTrace();
        goto L_0x02a6;
    L_0x02ac:
        r2 = move-exception;
    L_0x02ad:
        r2.printStackTrace();
        goto L_0x02a6;
    L_0x02b1:
        r1 = move-exception;
        r15 = r1;
        r1 = r2;
        r2 = r15;
        goto L_0x02ad;
    L_0x02b6:
        r1 = move-exception;
        r15 = r1;
        r1 = r2;
        r2 = r15;
        goto L_0x02a8;
    L_0x02bb:
        r1 = move-exception;
        goto L_0x0177;
    L_0x02be:
        r14 = move-exception;
        goto L_0x015e;
    L_0x02c1:
        r14 = move-exception;
        goto L_0x0154;
    L_0x02c4:
        r14 = move-exception;
        goto L_0x014a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vlocker.theme.e.a.a(java.lang.String):com.vlocker.ui.widget.az");
    }
}
