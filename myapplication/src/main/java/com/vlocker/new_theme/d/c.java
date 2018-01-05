package com.vlocker.new_theme.d;

import com.vlocker.theme.model.b;

public class c implements b {
    private int a;
    private int b;

    public com.vlocker.new_theme.beans.f a(java.lang.String r19) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Exception block dominator not found, method:com.vlocker.new_theme.d.c.a(java.lang.String):com.vlocker.new_theme.beans.f. bs: [B:22:0x00e8, B:97:0x029e]
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:86)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r18 = this;
        r5 = new com.vlocker.new_theme.beans.f;
        r5.<init>();
        r6 = new com.vlocker.theme.model.d;
        r6.<init>();
        r7 = new com.vlocker.theme.model.d;
        r7.<init>();
        r1 = 5;
        r3 = new java.lang.String[r1];	 Catch:{ JSONException -> 0x01dd, Exception -> 0x0293 }
        r1 = 0;	 Catch:{ JSONException -> 0x01dd, Exception -> 0x0293 }
        r2 = "#5cc0aa";	 Catch:{ JSONException -> 0x01dd, Exception -> 0x0293 }
        r3[r1] = r2;	 Catch:{ JSONException -> 0x01dd, Exception -> 0x0293 }
        r1 = 1;	 Catch:{ JSONException -> 0x01dd, Exception -> 0x0293 }
        r2 = "#e3b573";	 Catch:{ JSONException -> 0x01dd, Exception -> 0x0293 }
        r3[r1] = r2;	 Catch:{ JSONException -> 0x01dd, Exception -> 0x0293 }
        r1 = 2;	 Catch:{ JSONException -> 0x01dd, Exception -> 0x0293 }
        r2 = "#7782d2";	 Catch:{ JSONException -> 0x01dd, Exception -> 0x0293 }
        r3[r1] = r2;	 Catch:{ JSONException -> 0x01dd, Exception -> 0x0293 }
        r1 = 3;	 Catch:{ JSONException -> 0x01dd, Exception -> 0x0293 }
        r2 = "#d56a6a";	 Catch:{ JSONException -> 0x01dd, Exception -> 0x0293 }
        r3[r1] = r2;	 Catch:{ JSONException -> 0x01dd, Exception -> 0x0293 }
        r1 = 4;	 Catch:{ JSONException -> 0x01dd, Exception -> 0x0293 }
        r2 = "#d46697";	 Catch:{ JSONException -> 0x01dd, Exception -> 0x0293 }
        r3[r1] = r2;	 Catch:{ JSONException -> 0x01dd, Exception -> 0x0293 }
        r1 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x01dd, Exception -> 0x0293 }
        r0 = r19;	 Catch:{ JSONException -> 0x01dd, Exception -> 0x0293 }
        r1.<init>(r0);	 Catch:{ JSONException -> 0x01dd, Exception -> 0x0293 }
        r2 = "code";	 Catch:{ JSONException -> 0x01dd, Exception -> 0x0293 }
        r2 = r1.getInt(r2);	 Catch:{ JSONException -> 0x01dd, Exception -> 0x0293 }
        r4 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;	 Catch:{ JSONException -> 0x01dd, Exception -> 0x0293 }
        if (r2 != r4) goto L_0x029e;	 Catch:{ JSONException -> 0x01dd, Exception -> 0x0293 }
    L_0x0042:
        r2 = "data";	 Catch:{ JSONException -> 0x01dd, Exception -> 0x0293 }
        r8 = r1.getJSONObject(r2);	 Catch:{ JSONException -> 0x01dd, Exception -> 0x0293 }
        r1 = "data";	 Catch:{ JSONException -> 0x01dd, Exception -> 0x0293 }
        r9 = r8.getJSONObject(r1);	 Catch:{ JSONException -> 0x01dd, Exception -> 0x0293 }
        r1 = "list";	 Catch:{ JSONException -> 0x01dd, Exception -> 0x0293 }
        r10 = r9.getJSONArray(r1);	 Catch:{ JSONException -> 0x01dd, Exception -> 0x0293 }
        r1 = "tags_normal";	 Catch:{ Exception -> 0x00e4, JSONException -> 0x01dd }
        r4 = r8.getJSONArray(r1);	 Catch:{ Exception -> 0x00e4, JSONException -> 0x01dd }
        r1 = 0;	 Catch:{ Exception -> 0x00e4, JSONException -> 0x01dd }
        r2 = r1;	 Catch:{ Exception -> 0x00e4, JSONException -> 0x01dd }
    L_0x0060:
        r1 = r4.length();	 Catch:{ Exception -> 0x00e4, JSONException -> 0x01dd }
        if (r2 >= r1) goto L_0x00e8;	 Catch:{ Exception -> 0x00e4, JSONException -> 0x01dd }
    L_0x0066:
        r11 = new com.vlocker.new_theme.beans.e;	 Catch:{ Exception -> 0x00e4, JSONException -> 0x01dd }
        r11.<init>();	 Catch:{ Exception -> 0x00e4, JSONException -> 0x01dd }
        r1 = r4.getJSONObject(r2);	 Catch:{ Exception -> 0x00e4, JSONException -> 0x01dd }
        r12 = "modules";	 Catch:{ Exception -> 0x00e4, JSONException -> 0x01dd }
        r12 = r1.getJSONArray(r12);	 Catch:{ Exception -> 0x00e4, JSONException -> 0x01dd }
        r13 = "rows";	 Catch:{ Exception -> 0x00e4, JSONException -> 0x01dd }
        r13 = r1.getInt(r13);	 Catch:{ Exception -> 0x00e4, JSONException -> 0x01dd }
        r0 = r18;	 Catch:{ Exception -> 0x00e4, JSONException -> 0x01dd }
        r0.b = r13;	 Catch:{ Exception -> 0x00e4, JSONException -> 0x01dd }
        r0 = r18;	 Catch:{ Exception -> 0x00e4, JSONException -> 0x01dd }
        r13 = r0.b;	 Catch:{ Exception -> 0x00e4, JSONException -> 0x01dd }
        r11.b(r13);	 Catch:{ Exception -> 0x00e4, JSONException -> 0x01dd }
        r13 = "title";	 Catch:{ Exception -> 0x00e4, JSONException -> 0x01dd }
        r1 = r1.getString(r13);	 Catch:{ Exception -> 0x00e4, JSONException -> 0x01dd }
        r11.b(r1);	 Catch:{ Exception -> 0x00e4, JSONException -> 0x01dd }
        r1 = r12.length();	 Catch:{ Exception -> 0x00e4, JSONException -> 0x01dd }
        if (r1 <= 0) goto L_0x00dc;	 Catch:{ Exception -> 0x00e4, JSONException -> 0x01dd }
    L_0x0098:
        r13 = new java.util.ArrayList;	 Catch:{ Exception -> 0x00e4, JSONException -> 0x01dd }
        r13.<init>();	 Catch:{ Exception -> 0x00e4, JSONException -> 0x01dd }
        r1 = 0;	 Catch:{ Exception -> 0x00e4, JSONException -> 0x01dd }
    L_0x009e:
        r14 = r12.length();	 Catch:{ Exception -> 0x00e4, JSONException -> 0x01dd }
        if (r1 >= r14) goto L_0x00d5;	 Catch:{ Exception -> 0x00e4, JSONException -> 0x01dd }
    L_0x00a4:
        r14 = new com.vlocker.new_theme.beans.e;	 Catch:{ Exception -> 0x00e4, JSONException -> 0x01dd }
        r14.<init>();	 Catch:{ Exception -> 0x00e4, JSONException -> 0x01dd }
        r15 = r12.getJSONObject(r1);	 Catch:{ Exception -> 0x00e4, JSONException -> 0x01dd }
        r16 = "title";	 Catch:{ Exception -> 0x00e4, JSONException -> 0x01dd }
        r16 = r15.getString(r16);	 Catch:{ Exception -> 0x00e4, JSONException -> 0x01dd }
        r0 = r16;	 Catch:{ Exception -> 0x00e4, JSONException -> 0x01dd }
        r14.b(r0);	 Catch:{ Exception -> 0x00e4, JSONException -> 0x01dd }
        r16 = "url";	 Catch:{ Exception -> 0x00e4, JSONException -> 0x01dd }
        r16 = r15.getString(r16);	 Catch:{ Exception -> 0x00e4, JSONException -> 0x01dd }
        r0 = r16;	 Catch:{ Exception -> 0x00e4, JSONException -> 0x01dd }
        r14.d(r0);	 Catch:{ Exception -> 0x00e4, JSONException -> 0x01dd }
        r16 = "logo";	 Catch:{ Exception -> 0x00e4, JSONException -> 0x01dd }
        r15 = r15.getString(r16);	 Catch:{ Exception -> 0x00e4, JSONException -> 0x01dd }
        r14.c(r15);	 Catch:{ Exception -> 0x00e4, JSONException -> 0x01dd }
        r13.add(r14);	 Catch:{ Exception -> 0x00e4, JSONException -> 0x01dd }
        r1 = r1 + 1;	 Catch:{ Exception -> 0x00e4, JSONException -> 0x01dd }
        goto L_0x009e;	 Catch:{ Exception -> 0x00e4, JSONException -> 0x01dd }
    L_0x00d5:
        r1 = 1;	 Catch:{ Exception -> 0x00e4, JSONException -> 0x01dd }
        r11.c(r1);	 Catch:{ Exception -> 0x00e4, JSONException -> 0x01dd }
        r11.a(r13);	 Catch:{ Exception -> 0x00e4, JSONException -> 0x01dd }
    L_0x00dc:
        r7.add(r11);	 Catch:{ Exception -> 0x00e4, JSONException -> 0x01dd }
        r1 = r2 + 1;
        r2 = r1;
        goto L_0x0060;
    L_0x00e4:
        r1 = move-exception;
        r1.printStackTrace();	 Catch:{ JSONException -> 0x01dd, Exception -> 0x0293 }
    L_0x00e8:
        r1 = "tags_simple";	 Catch:{ Exception -> 0x017f, JSONException -> 0x01dd }
        r4 = r8.getJSONArray(r1);	 Catch:{ Exception -> 0x017f, JSONException -> 0x01dd }
        r1 = 0;	 Catch:{ Exception -> 0x017f, JSONException -> 0x01dd }
        r2 = r1;	 Catch:{ Exception -> 0x017f, JSONException -> 0x01dd }
    L_0x00f1:
        r1 = r4.length();	 Catch:{ Exception -> 0x017f, JSONException -> 0x01dd }
        if (r2 >= r1) goto L_0x0183;	 Catch:{ Exception -> 0x017f, JSONException -> 0x01dd }
    L_0x00f7:
        r11 = new com.vlocker.new_theme.beans.e;	 Catch:{ Exception -> 0x017f, JSONException -> 0x01dd }
        r11.<init>();	 Catch:{ Exception -> 0x017f, JSONException -> 0x01dd }
        r1 = r4.getJSONObject(r2);	 Catch:{ Exception -> 0x017f, JSONException -> 0x01dd }
        r12 = "modules";	 Catch:{ Exception -> 0x017f, JSONException -> 0x01dd }
        r12 = r1.getJSONArray(r12);	 Catch:{ Exception -> 0x017f, JSONException -> 0x01dd }
        r13 = "rows";	 Catch:{ Exception -> 0x017f, JSONException -> 0x01dd }
        r13 = r1.getInt(r13);	 Catch:{ Exception -> 0x017f, JSONException -> 0x01dd }
        r0 = r18;	 Catch:{ Exception -> 0x017f, JSONException -> 0x01dd }
        r0.b = r13;	 Catch:{ Exception -> 0x017f, JSONException -> 0x01dd }
        r0 = r18;	 Catch:{ Exception -> 0x017f, JSONException -> 0x01dd }
        r13 = r0.b;	 Catch:{ Exception -> 0x017f, JSONException -> 0x01dd }
        r11.b(r13);	 Catch:{ Exception -> 0x017f, JSONException -> 0x01dd }
        r13 = "title";	 Catch:{ Exception -> 0x017f, JSONException -> 0x01dd }
        r1 = r1.getString(r13);	 Catch:{ Exception -> 0x017f, JSONException -> 0x01dd }
        r11.b(r1);	 Catch:{ Exception -> 0x017f, JSONException -> 0x01dd }
        r1 = r12.length();	 Catch:{ Exception -> 0x017f, JSONException -> 0x01dd }
        if (r1 <= 0) goto L_0x017b;	 Catch:{ Exception -> 0x017f, JSONException -> 0x01dd }
    L_0x0129:
        r13 = new java.util.ArrayList;	 Catch:{ Exception -> 0x017f, JSONException -> 0x01dd }
        r13.<init>();	 Catch:{ Exception -> 0x017f, JSONException -> 0x01dd }
        r14 = r12.length();	 Catch:{ Exception -> 0x017f, JSONException -> 0x01dd }
        r1 = 1;	 Catch:{ Exception -> 0x017f, JSONException -> 0x01dd }
        if (r14 != r1) goto L_0x0139;	 Catch:{ Exception -> 0x017f, JSONException -> 0x01dd }
    L_0x0135:
        r1 = r2 + 1;	 Catch:{ Exception -> 0x017f, JSONException -> 0x01dd }
        r2 = r1;	 Catch:{ Exception -> 0x017f, JSONException -> 0x01dd }
        goto L_0x00f1;	 Catch:{ Exception -> 0x017f, JSONException -> 0x01dd }
    L_0x0139:
        r1 = 0;	 Catch:{ Exception -> 0x017f, JSONException -> 0x01dd }
    L_0x013a:
        if (r1 >= r14) goto L_0x0171;	 Catch:{ Exception -> 0x017f, JSONException -> 0x01dd }
    L_0x013c:
        r15 = new com.vlocker.new_theme.beans.e;	 Catch:{ Exception -> 0x017f, JSONException -> 0x01dd }
        r15.<init>();	 Catch:{ Exception -> 0x017f, JSONException -> 0x01dd }
        r16 = r12.getJSONObject(r1);	 Catch:{ Exception -> 0x017f, JSONException -> 0x01dd }
        r17 = "title";	 Catch:{ Exception -> 0x017f, JSONException -> 0x01dd }
        r17 = r16.getString(r17);	 Catch:{ Exception -> 0x017f, JSONException -> 0x01dd }
        r0 = r17;	 Catch:{ Exception -> 0x017f, JSONException -> 0x01dd }
        r15.b(r0);	 Catch:{ Exception -> 0x017f, JSONException -> 0x01dd }
        r17 = "url";	 Catch:{ Exception -> 0x017f, JSONException -> 0x01dd }
        r16 = r16.getString(r17);	 Catch:{ Exception -> 0x017f, JSONException -> 0x01dd }
        r15.d(r16);	 Catch:{ Exception -> 0x017f, JSONException -> 0x01dd }
        r16 = new java.util.Random;	 Catch:{ Exception -> 0x017f, JSONException -> 0x01dd }
        r16.<init>();	 Catch:{ Exception -> 0x017f, JSONException -> 0x01dd }
        r17 = 5;	 Catch:{ Exception -> 0x017f, JSONException -> 0x01dd }
        r16 = r16.nextInt(r17);	 Catch:{ Exception -> 0x017f, JSONException -> 0x01dd }
        r16 = r3[r16];	 Catch:{ Exception -> 0x017f, JSONException -> 0x01dd }
        r15.a(r16);	 Catch:{ Exception -> 0x017f, JSONException -> 0x01dd }
        r13.add(r15);	 Catch:{ Exception -> 0x017f, JSONException -> 0x01dd }
        r1 = r1 + 1;	 Catch:{ Exception -> 0x017f, JSONException -> 0x01dd }
        goto L_0x013a;	 Catch:{ Exception -> 0x017f, JSONException -> 0x01dd }
    L_0x0171:
        switch(r14) {
            case 2: goto L_0x01d8;
            case 3: goto L_0x01e2;
            case 4: goto L_0x01e7;
            case 5: goto L_0x01ec;
            default: goto L_0x0174;
        };	 Catch:{ Exception -> 0x017f, JSONException -> 0x01dd }
    L_0x0174:
        r1 = 3;	 Catch:{ Exception -> 0x017f, JSONException -> 0x01dd }
        r11.c(r1);	 Catch:{ Exception -> 0x017f, JSONException -> 0x01dd }
    L_0x0178:
        r11.a(r13);	 Catch:{ Exception -> 0x017f, JSONException -> 0x01dd }
    L_0x017b:
        r7.add(r11);	 Catch:{ Exception -> 0x017f, JSONException -> 0x01dd }
        goto L_0x0135;
    L_0x017f:
        r1 = move-exception;
        r1.printStackTrace();	 Catch:{ JSONException -> 0x01dd, Exception -> 0x0293 }
    L_0x0183:
        r1 = r10.length();	 Catch:{ JSONException -> 0x01dd, Exception -> 0x0293 }
        if (r1 <= 0) goto L_0x01f1;	 Catch:{ JSONException -> 0x01dd, Exception -> 0x0293 }
    L_0x0189:
        r3 = new com.vlocker.new_theme.beans.e;	 Catch:{ JSONException -> 0x01dd, Exception -> 0x0293 }
        r3.<init>();	 Catch:{ JSONException -> 0x01dd, Exception -> 0x0293 }
        r2 = new com.vlocker.theme.model.d;	 Catch:{ JSONException -> 0x01dd, Exception -> 0x0293 }
        r2.<init>();	 Catch:{ JSONException -> 0x01dd, Exception -> 0x0293 }
        r1 = 0;	 Catch:{ JSONException -> 0x01dd, Exception -> 0x0293 }
        r4 = r1;	 Catch:{ JSONException -> 0x01dd, Exception -> 0x0293 }
    L_0x0195:
        r1 = r10.length();	 Catch:{ JSONException -> 0x01dd, Exception -> 0x0293 }
        if (r4 >= r1) goto L_0x01f1;	 Catch:{ JSONException -> 0x01dd, Exception -> 0x0293 }
    L_0x019b:
        r0 = r18;	 Catch:{ JSONException -> 0x01dd, Exception -> 0x0293 }
        r1 = r0.a;	 Catch:{ JSONException -> 0x01dd, Exception -> 0x0293 }
        r1 = r1 + 1;	 Catch:{ JSONException -> 0x01dd, Exception -> 0x0293 }
        r0 = r18;	 Catch:{ JSONException -> 0x01dd, Exception -> 0x0293 }
        r0.a = r1;	 Catch:{ JSONException -> 0x01dd, Exception -> 0x0293 }
        r1 = r10.get(r4);	 Catch:{ JSONException -> 0x01dd, Exception -> 0x0293 }
        r1 = (org.json.JSONObject) r1;	 Catch:{ JSONException -> 0x01dd, Exception -> 0x0293 }
        r1 = com.vlocker.theme.f.e.a(r1);	 Catch:{ JSONException -> 0x01dd, Exception -> 0x0293 }
        r2.add(r1);	 Catch:{ JSONException -> 0x01dd, Exception -> 0x0293 }
        r0 = r18;	 Catch:{ JSONException -> 0x01dd, Exception -> 0x0293 }
        r1 = r0.a;	 Catch:{ JSONException -> 0x01dd, Exception -> 0x0293 }
        r11 = 3;	 Catch:{ JSONException -> 0x01dd, Exception -> 0x0293 }
        if (r1 != r11) goto L_0x02a9;	 Catch:{ JSONException -> 0x01dd, Exception -> 0x0293 }
    L_0x01b9:
        r1 = 0;	 Catch:{ JSONException -> 0x01dd, Exception -> 0x0293 }
        r3.c(r1);	 Catch:{ JSONException -> 0x01dd, Exception -> 0x0293 }
        r3.a(r2);	 Catch:{ JSONException -> 0x01dd, Exception -> 0x0293 }
        r6.add(r3);	 Catch:{ JSONException -> 0x01dd, Exception -> 0x0293 }
        r2 = new com.vlocker.new_theme.beans.e;	 Catch:{ JSONException -> 0x01dd, Exception -> 0x0293 }
        r2.<init>();	 Catch:{ JSONException -> 0x01dd, Exception -> 0x0293 }
        r1 = 0;	 Catch:{ JSONException -> 0x01dd, Exception -> 0x0293 }
        r0 = r18;	 Catch:{ JSONException -> 0x01dd, Exception -> 0x0293 }
        r0.a = r1;	 Catch:{ JSONException -> 0x01dd, Exception -> 0x0293 }
        r1 = new com.vlocker.theme.model.d;	 Catch:{ JSONException -> 0x01dd, Exception -> 0x0293 }
        r1.<init>();	 Catch:{ JSONException -> 0x01dd, Exception -> 0x0293 }
    L_0x01d2:
        r3 = r4 + 1;
        r4 = r3;
        r3 = r2;
        r2 = r1;
        goto L_0x0195;
    L_0x01d8:
        r1 = 2;
        r11.c(r1);	 Catch:{ Exception -> 0x017f, JSONException -> 0x01dd }
        goto L_0x0178;
    L_0x01dd:
        r1 = move-exception;
        r1.printStackTrace();
    L_0x01e1:
        return r5;
    L_0x01e2:
        r1 = 3;
        r11.c(r1);	 Catch:{ Exception -> 0x017f, JSONException -> 0x01dd }
        goto L_0x0178;	 Catch:{ Exception -> 0x017f, JSONException -> 0x01dd }
    L_0x01e7:
        r1 = 4;	 Catch:{ Exception -> 0x017f, JSONException -> 0x01dd }
        r11.c(r1);	 Catch:{ Exception -> 0x017f, JSONException -> 0x01dd }
        goto L_0x0178;	 Catch:{ Exception -> 0x017f, JSONException -> 0x01dd }
    L_0x01ec:
        r1 = 5;	 Catch:{ Exception -> 0x017f, JSONException -> 0x01dd }
        r11.c(r1);	 Catch:{ Exception -> 0x017f, JSONException -> 0x01dd }
        goto L_0x0178;
    L_0x01f1:
        r1 = 0;
        r2 = r1;
    L_0x01f3:
        r1 = r7.size();	 Catch:{ Exception -> 0x020a, JSONException -> 0x01dd }
        if (r2 >= r1) goto L_0x020e;	 Catch:{ Exception -> 0x020a, JSONException -> 0x01dd }
    L_0x01f9:
        r1 = r7.get(r2);	 Catch:{ Exception -> 0x020a, JSONException -> 0x01dd }
        r1 = (com.vlocker.new_theme.beans.e) r1;	 Catch:{ Exception -> 0x020a, JSONException -> 0x01dd }
        r3 = r1.b();	 Catch:{ Exception -> 0x020a, JSONException -> 0x01dd }
        r6.add(r3, r1);	 Catch:{ Exception -> 0x020a, JSONException -> 0x01dd }
        r1 = r2 + 1;
        r2 = r1;
        goto L_0x01f3;
    L_0x020a:
        r1 = move-exception;
        r1.printStackTrace();	 Catch:{ JSONException -> 0x01dd, Exception -> 0x0293 }
    L_0x020e:
        r1 = "meta";	 Catch:{ JSONException -> 0x01dd, Exception -> 0x0293 }
        r1 = r9.getJSONObject(r1);	 Catch:{ JSONException -> 0x01dd, Exception -> 0x0293 }
        r2 = "pre";	 Catch:{ JSONException -> 0x01dd, Exception -> 0x0293 }
        r2 = r1.getString(r2);	 Catch:{ JSONException -> 0x01dd, Exception -> 0x0293 }
        r3 = "next";	 Catch:{ JSONException -> 0x01dd, Exception -> 0x0293 }
        r3 = r1.getString(r3);	 Catch:{ JSONException -> 0x01dd, Exception -> 0x0293 }
        r4 = "page";	 Catch:{ JSONException -> 0x01dd, Exception -> 0x0293 }
        r4 = r1.getInt(r4);	 Catch:{ JSONException -> 0x01dd, Exception -> 0x0293 }
        r7 = "total";	 Catch:{ JSONException -> 0x01dd, Exception -> 0x0293 }
        r7 = r1.getInt(r7);	 Catch:{ JSONException -> 0x01dd, Exception -> 0x0293 }
        r9 = "result";	 Catch:{ JSONException -> 0x01dd, Exception -> 0x0293 }
        r9 = r1.getBoolean(r9);	 Catch:{ JSONException -> 0x01dd, Exception -> 0x0293 }
        r1 = "modules";	 Catch:{ Exception -> 0x0299, JSONException -> 0x01dd }
        r8 = r8.getJSONArray(r1);	 Catch:{ Exception -> 0x0299, JSONException -> 0x01dd }
        if (r9 == 0) goto L_0x027f;	 Catch:{ Exception -> 0x0299, JSONException -> 0x01dd }
    L_0x0241:
        r1 = 1;	 Catch:{ Exception -> 0x0299, JSONException -> 0x01dd }
        if (r4 != r1) goto L_0x027f;	 Catch:{ Exception -> 0x0299, JSONException -> 0x01dd }
    L_0x0244:
        if (r8 == 0) goto L_0x027f;	 Catch:{ Exception -> 0x0299, JSONException -> 0x01dd }
    L_0x0246:
        r1 = r8.length();	 Catch:{ Exception -> 0x0299, JSONException -> 0x01dd }
        r10 = 1;	 Catch:{ Exception -> 0x0299, JSONException -> 0x01dd }
        if (r1 < r10) goto L_0x027f;	 Catch:{ Exception -> 0x0299, JSONException -> 0x01dd }
    L_0x024d:
        r10 = new com.vlocker.theme.model.d;	 Catch:{ Exception -> 0x0299, JSONException -> 0x01dd }
        r10.<init>();	 Catch:{ Exception -> 0x0299, JSONException -> 0x01dd }
        r1 = 0;	 Catch:{ Exception -> 0x0299, JSONException -> 0x01dd }
    L_0x0253:
        r11 = r8.length();	 Catch:{ Exception -> 0x0299, JSONException -> 0x01dd }
        if (r1 >= r11) goto L_0x027c;	 Catch:{ Exception -> 0x0299, JSONException -> 0x01dd }
    L_0x0259:
        r11 = r8.getJSONObject(r1);	 Catch:{ Exception -> 0x0299, JSONException -> 0x01dd }
        r12 = new com.vlocker.theme.model.T_SearchOrderInfo;	 Catch:{ Exception -> 0x0299, JSONException -> 0x01dd }
        r12.<init>();	 Catch:{ Exception -> 0x0299, JSONException -> 0x01dd }
        r13 = "title";	 Catch:{ Exception -> 0x0299, JSONException -> 0x01dd }
        r13 = r11.getString(r13);	 Catch:{ Exception -> 0x0299, JSONException -> 0x01dd }
        r12.a(r13);	 Catch:{ Exception -> 0x0299, JSONException -> 0x01dd }
        r13 = "url";	 Catch:{ Exception -> 0x0299, JSONException -> 0x01dd }
        r11 = r11.getString(r13);	 Catch:{ Exception -> 0x0299, JSONException -> 0x01dd }
        r12.b(r11);	 Catch:{ Exception -> 0x0299, JSONException -> 0x01dd }
        r10.add(r12);	 Catch:{ Exception -> 0x0299, JSONException -> 0x01dd }
        r1 = r1 + 1;	 Catch:{ Exception -> 0x0299, JSONException -> 0x01dd }
        goto L_0x0253;	 Catch:{ Exception -> 0x0299, JSONException -> 0x01dd }
    L_0x027c:
        r5.a(r10);	 Catch:{ Exception -> 0x0299, JSONException -> 0x01dd }
    L_0x027f:
        r5.b(r6);	 Catch:{ JSONException -> 0x01dd, Exception -> 0x0293 }
        r5.a(r2);	 Catch:{ JSONException -> 0x01dd, Exception -> 0x0293 }
        r5.b(r3);	 Catch:{ JSONException -> 0x01dd, Exception -> 0x0293 }
        r5.a(r4);	 Catch:{ JSONException -> 0x01dd, Exception -> 0x0293 }
        r5.b(r7);	 Catch:{ JSONException -> 0x01dd, Exception -> 0x0293 }
        r5.a(r9);	 Catch:{ JSONException -> 0x01dd, Exception -> 0x0293 }
        goto L_0x01e1;
    L_0x0293:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x01e1;
    L_0x0299:
        r1 = move-exception;
        r1.printStackTrace();	 Catch:{ JSONException -> 0x01dd, Exception -> 0x0293 }
        goto L_0x027f;
    L_0x029e:
        r2 = "message";	 Catch:{ Exception -> 0x02a6, JSONException -> 0x01dd }
        r1.getString(r2);	 Catch:{ Exception -> 0x02a6, JSONException -> 0x01dd }
        goto L_0x01e1;
    L_0x02a6:
        r1 = move-exception;
        goto L_0x01e1;
    L_0x02a9:
        r1 = r2;
        r2 = r3;
        goto L_0x01d2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vlocker.new_theme.d.c.a(java.lang.String):com.vlocker.new_theme.beans.f");
    }

    public /* synthetic */ b b(String str) {
        return a(str);
    }
}
