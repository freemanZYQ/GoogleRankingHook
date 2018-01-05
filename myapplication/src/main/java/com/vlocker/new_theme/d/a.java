package com.vlocker.new_theme.d;

import com.vlocker.theme.model.b;

public class a implements b {
    public com.vlocker.theme.model.T_ThemeListPageInfo a(java.lang.String r17) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Exception block dominator not found, method:com.vlocker.new_theme.d.a.a(java.lang.String):com.vlocker.theme.model.T_ThemeListPageInfo. bs: [B:34:0x0180, B:150:0x0407]
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
        r16 = this;
        r3 = new com.vlocker.theme.model.T_ThemeListPageInfo;
        r3.<init>();
        r4 = new com.vlocker.theme.model.d;
        r4.<init>();
        r1 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r0 = r17;	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r1.<init>(r0);	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r2 = "code";	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r5 = r1.getInt(r2);	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        if (r5 != r2) goto L_0x0407;	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
    L_0x001c:
        r2 = "data";	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r6 = r1.getJSONObject(r2);	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r1 = "list";	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r7 = r6.getJSONArray(r1);	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r1 = r7.length();	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        if (r1 <= 0) goto L_0x02b9;	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
    L_0x0030:
        r1 = 0;	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r2 = r1;	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
    L_0x0032:
        r1 = r7.length();	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        if (r2 >= r1) goto L_0x02b9;	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
    L_0x0038:
        r8 = new com.vlocker.theme.model.T_ThemeItemInfo;	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r8.<init>();	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r9 = r7.getJSONObject(r2);	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r1 = "id";	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r1 = r9.getString(r1);	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r8.a(r1);	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r1 = "title";	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r1 = r9.getString(r1);	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r1 = com.vlocker.theme.f.e.b(r1);	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r8.b(r1);	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r1 = "tags";	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r1 = r9.getString(r1);	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r8.c(r1);	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r1 = "is_lockscreen";	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r1 = r9.getInt(r1);	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r8.b(r1);	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r1 = "status";	 Catch:{ Exception -> 0x0171, JSONException -> 0x0178 }
        r1 = r9.getInt(r1);	 Catch:{ Exception -> 0x0171, JSONException -> 0x0178 }
        r8.a(r1);	 Catch:{ Exception -> 0x0171, JSONException -> 0x0178 }
    L_0x0077:
        r1 = "desc";	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r1 = r9.getString(r1);	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r8.d(r1);	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r1 = "size";	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r1 = r9.getInt(r1);	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r8.c(r1);	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r1 = "downnum";	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r1 = r9.getInt(r1);	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r8.e(r1);	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r1 = "ctime";	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r1 = r9.getString(r1);	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r8.h(r1);	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r1 = "grade";	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r1 = r9.getInt(r1);	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r8.d(r1);	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r1 = "author";	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r1 = r9.getString(r1);	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r8.g(r1);	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r1 = "show";	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r1 = r9.getString(r1);	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r8.f(r1);	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r1 = "package";	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r1 = r9.getString(r1);	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r8.e(r1);	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r1 = new java.lang.StringBuilder;	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r1.<init>();	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r10 = "preview1";	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r10 = r9.getString(r10);	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r1 = r1.append(r10);	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r10 = 1;	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r10 = com.vlocker.theme.f.e.a(r10);	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r1 = r1.append(r10);	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r1 = r1.toString();	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r8.i(r1);	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r1 = new java.lang.StringBuilder;	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r1.<init>();	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r10 = "preview1";	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r10 = r9.getString(r10);	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r1 = r1.append(r10);	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r10 = 0;	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r10 = com.vlocker.theme.f.e.a(r10);	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r1 = r1.append(r10);	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r1 = r1.toString();	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r8.j(r1);	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r1 = new java.lang.StringBuilder;	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r1.<init>();	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r10 = "preview2";	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r10 = r9.getString(r10);	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r1 = r1.append(r10);	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r10 = 0;	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r10 = com.vlocker.theme.f.e.a(r10);	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r1 = r1.append(r10);	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r1 = r1.toString();	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r8.k(r1);	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r1 = "mpic";	 Catch:{ Exception -> 0x024f, JSONException -> 0x0178 }
        r10 = r9.getJSONArray(r1);	 Catch:{ Exception -> 0x024f, JSONException -> 0x0178 }
        if (r10 == 0) goto L_0x01e9;	 Catch:{ Exception -> 0x024f, JSONException -> 0x0178 }
    L_0x0130:
        r1 = r10.length();	 Catch:{ Exception -> 0x024f, JSONException -> 0x0178 }
        if (r1 <= 0) goto L_0x01e9;	 Catch:{ Exception -> 0x024f, JSONException -> 0x0178 }
    L_0x0136:
        r11 = new com.vlocker.theme.model.d;	 Catch:{ Exception -> 0x024f, JSONException -> 0x0178 }
        r11.<init>();	 Catch:{ Exception -> 0x024f, JSONException -> 0x0178 }
        r1 = 0;	 Catch:{ Exception -> 0x024f, JSONException -> 0x0178 }
    L_0x013c:
        r12 = r10.length();	 Catch:{ Exception -> 0x024f, JSONException -> 0x0178 }
        if (r1 >= r12) goto L_0x017d;	 Catch:{ Exception -> 0x024f, JSONException -> 0x0178 }
    L_0x0142:
        r12 = r10.getJSONObject(r1);	 Catch:{ Exception -> 0x024f, JSONException -> 0x0178 }
        r13 = new com.vlocker.theme.model.T_ThemePreviewParserInfo;	 Catch:{ Exception -> 0x024f, JSONException -> 0x0178 }
        r13.<init>();	 Catch:{ Exception -> 0x024f, JSONException -> 0x0178 }
        r14 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x024f, JSONException -> 0x0178 }
        r14.<init>();	 Catch:{ Exception -> 0x024f, JSONException -> 0x0178 }
        r15 = "preview";	 Catch:{ Exception -> 0x024f, JSONException -> 0x0178 }
        r12 = r12.getString(r15);	 Catch:{ Exception -> 0x024f, JSONException -> 0x0178 }
        r12 = r14.append(r12);	 Catch:{ Exception -> 0x024f, JSONException -> 0x0178 }
        r14 = 0;	 Catch:{ Exception -> 0x024f, JSONException -> 0x0178 }
        r14 = com.vlocker.theme.f.e.a(r14);	 Catch:{ Exception -> 0x024f, JSONException -> 0x0178 }
        r12 = r12.append(r14);	 Catch:{ Exception -> 0x024f, JSONException -> 0x0178 }
        r12 = r12.toString();	 Catch:{ Exception -> 0x024f, JSONException -> 0x0178 }
        r13.a(r12);	 Catch:{ Exception -> 0x024f, JSONException -> 0x0178 }
        r11.add(r13);	 Catch:{ Exception -> 0x024f, JSONException -> 0x0178 }
        r1 = r1 + 1;
        goto L_0x013c;
    L_0x0171:
        r1 = move-exception;
        r1 = 0;
        r8.a(r1);	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        goto L_0x0077;
    L_0x0178:
        r1 = move-exception;
        r1.printStackTrace();
    L_0x017c:
        return r3;
    L_0x017d:
        r8.a(r11);	 Catch:{ Exception -> 0x024f, JSONException -> 0x0178 }
    L_0x0180:
        r1 = "file";	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r1 = r9.getString(r1);	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r8.l(r1);	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r1 = "edit";	 Catch:{ Exception -> 0x041a, JSONException -> 0x0178 }
        r1 = r9.getInt(r1);	 Catch:{ Exception -> 0x041a, JSONException -> 0x0178 }
        r8.f(r1);	 Catch:{ Exception -> 0x041a, JSONException -> 0x0178 }
        r1 = "event";	 Catch:{ Exception -> 0x041a, JSONException -> 0x0178 }
        r1 = r9.getJSONObject(r1);	 Catch:{ Exception -> 0x041a, JSONException -> 0x0178 }
        if (r1 == 0) goto L_0x01bb;	 Catch:{ Exception -> 0x041a, JSONException -> 0x0178 }
    L_0x019d:
        r10 = "title";	 Catch:{ Exception -> 0x041a, JSONException -> 0x0178 }
        r10 = r1.getString(r10);	 Catch:{ Exception -> 0x041a, JSONException -> 0x0178 }
        r8.m(r10);	 Catch:{ Exception -> 0x041a, JSONException -> 0x0178 }
        r10 = "preview";	 Catch:{ Exception -> 0x041a, JSONException -> 0x0178 }
        r10 = r1.getString(r10);	 Catch:{ Exception -> 0x041a, JSONException -> 0x0178 }
        r8.n(r10);	 Catch:{ Exception -> 0x041a, JSONException -> 0x0178 }
        r10 = "dataurl";	 Catch:{ Exception -> 0x041a, JSONException -> 0x0178 }
        r1 = r1.getString(r10);	 Catch:{ Exception -> 0x041a, JSONException -> 0x0178 }
        r8.o(r1);	 Catch:{ Exception -> 0x041a, JSONException -> 0x0178 }
    L_0x01bb:
        r1 = "logurl";	 Catch:{ Exception -> 0x0417, JSONException -> 0x0178 }
        r1 = r9.getString(r1);	 Catch:{ Exception -> 0x0417, JSONException -> 0x0178 }
        if (r1 == 0) goto L_0x01ce;	 Catch:{ Exception -> 0x0417, JSONException -> 0x0178 }
    L_0x01c4:
        r1 = "logurl";	 Catch:{ Exception -> 0x0417, JSONException -> 0x0178 }
        r1 = r9.getString(r1);	 Catch:{ Exception -> 0x0417, JSONException -> 0x0178 }
        r8.p(r1);	 Catch:{ Exception -> 0x0417, JSONException -> 0x0178 }
    L_0x01ce:
        r1 = "diggnum";	 Catch:{ Exception -> 0x0414, JSONException -> 0x0178 }
        r1 = r9.getString(r1);	 Catch:{ Exception -> 0x0414, JSONException -> 0x0178 }
        if (r1 == 0) goto L_0x01e1;	 Catch:{ Exception -> 0x0414, JSONException -> 0x0178 }
    L_0x01d7:
        r1 = "diggnum";	 Catch:{ Exception -> 0x0414, JSONException -> 0x0178 }
        r1 = r9.getInt(r1);	 Catch:{ Exception -> 0x0414, JSONException -> 0x0178 }
        r8.g(r1);	 Catch:{ Exception -> 0x0414, JSONException -> 0x0178 }
    L_0x01e1:
        r4.add(r8);	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r1 = r2 + 1;
        r2 = r1;
        goto L_0x0032;
    L_0x01e9:
        r10 = new com.vlocker.theme.model.d;	 Catch:{ Exception -> 0x024f, JSONException -> 0x0178 }
        r10.<init>();	 Catch:{ Exception -> 0x024f, JSONException -> 0x0178 }
        r11 = new com.vlocker.theme.model.T_ThemePreviewParserInfo;	 Catch:{ Exception -> 0x024f, JSONException -> 0x0178 }
        r11.<init>();	 Catch:{ Exception -> 0x024f, JSONException -> 0x0178 }
        r12 = new com.vlocker.theme.model.T_ThemePreviewParserInfo;	 Catch:{ Exception -> 0x024f, JSONException -> 0x0178 }
        r12.<init>();	 Catch:{ Exception -> 0x024f, JSONException -> 0x0178 }
        r1 = 0;	 Catch:{ Exception -> 0x024f, JSONException -> 0x0178 }
    L_0x01f9:
        r13 = 2;	 Catch:{ Exception -> 0x024f, JSONException -> 0x0178 }
        if (r1 >= r13) goto L_0x024a;	 Catch:{ Exception -> 0x024f, JSONException -> 0x0178 }
    L_0x01fc:
        if (r1 != 0) goto L_0x0221;	 Catch:{ Exception -> 0x024f, JSONException -> 0x0178 }
    L_0x01fe:
        r13 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x024f, JSONException -> 0x0178 }
        r13.<init>();	 Catch:{ Exception -> 0x024f, JSONException -> 0x0178 }
        r14 = "preview1";	 Catch:{ Exception -> 0x024f, JSONException -> 0x0178 }
        r14 = r9.getString(r14);	 Catch:{ Exception -> 0x024f, JSONException -> 0x0178 }
        r13 = r13.append(r14);	 Catch:{ Exception -> 0x024f, JSONException -> 0x0178 }
        r14 = 0;	 Catch:{ Exception -> 0x024f, JSONException -> 0x0178 }
        r14 = com.vlocker.theme.f.e.a(r14);	 Catch:{ Exception -> 0x024f, JSONException -> 0x0178 }
        r13 = r13.append(r14);	 Catch:{ Exception -> 0x024f, JSONException -> 0x0178 }
        r13 = r13.toString();	 Catch:{ Exception -> 0x024f, JSONException -> 0x0178 }
        r11.a(r13);	 Catch:{ Exception -> 0x024f, JSONException -> 0x0178 }
        r10.add(r11);	 Catch:{ Exception -> 0x024f, JSONException -> 0x0178 }
    L_0x0221:
        r13 = 1;	 Catch:{ Exception -> 0x024f, JSONException -> 0x0178 }
        if (r1 != r13) goto L_0x0247;	 Catch:{ Exception -> 0x024f, JSONException -> 0x0178 }
    L_0x0224:
        r13 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x024f, JSONException -> 0x0178 }
        r13.<init>();	 Catch:{ Exception -> 0x024f, JSONException -> 0x0178 }
        r14 = "preview2";	 Catch:{ Exception -> 0x024f, JSONException -> 0x0178 }
        r14 = r9.getString(r14);	 Catch:{ Exception -> 0x024f, JSONException -> 0x0178 }
        r13 = r13.append(r14);	 Catch:{ Exception -> 0x024f, JSONException -> 0x0178 }
        r14 = 0;	 Catch:{ Exception -> 0x024f, JSONException -> 0x0178 }
        r14 = com.vlocker.theme.f.e.a(r14);	 Catch:{ Exception -> 0x024f, JSONException -> 0x0178 }
        r13 = r13.append(r14);	 Catch:{ Exception -> 0x024f, JSONException -> 0x0178 }
        r13 = r13.toString();	 Catch:{ Exception -> 0x024f, JSONException -> 0x0178 }
        r12.a(r13);	 Catch:{ Exception -> 0x024f, JSONException -> 0x0178 }
        r10.add(r12);	 Catch:{ Exception -> 0x024f, JSONException -> 0x0178 }
    L_0x0247:
        r1 = r1 + 1;	 Catch:{ Exception -> 0x024f, JSONException -> 0x0178 }
        goto L_0x01f9;	 Catch:{ Exception -> 0x024f, JSONException -> 0x0178 }
    L_0x024a:
        r8.a(r10);	 Catch:{ Exception -> 0x024f, JSONException -> 0x0178 }
        goto L_0x0180;
    L_0x024f:
        r1 = move-exception;
        r10 = new com.vlocker.theme.model.d;	 Catch:{ Exception -> 0x02b6, JSONException -> 0x0178 }
        r10.<init>();	 Catch:{ Exception -> 0x02b6, JSONException -> 0x0178 }
        r11 = new com.vlocker.theme.model.T_ThemePreviewParserInfo;	 Catch:{ Exception -> 0x02b6, JSONException -> 0x0178 }
        r11.<init>();	 Catch:{ Exception -> 0x02b6, JSONException -> 0x0178 }
        r12 = new com.vlocker.theme.model.T_ThemePreviewParserInfo;	 Catch:{ Exception -> 0x02b6, JSONException -> 0x0178 }
        r12.<init>();	 Catch:{ Exception -> 0x02b6, JSONException -> 0x0178 }
        r1 = 0;	 Catch:{ Exception -> 0x02b6, JSONException -> 0x0178 }
    L_0x0260:
        r13 = 2;	 Catch:{ Exception -> 0x02b6, JSONException -> 0x0178 }
        if (r1 >= r13) goto L_0x02b1;	 Catch:{ Exception -> 0x02b6, JSONException -> 0x0178 }
    L_0x0263:
        if (r1 != 0) goto L_0x0288;	 Catch:{ Exception -> 0x02b6, JSONException -> 0x0178 }
    L_0x0265:
        r13 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x02b6, JSONException -> 0x0178 }
        r13.<init>();	 Catch:{ Exception -> 0x02b6, JSONException -> 0x0178 }
        r14 = "preview1";	 Catch:{ Exception -> 0x02b6, JSONException -> 0x0178 }
        r14 = r9.getString(r14);	 Catch:{ Exception -> 0x02b6, JSONException -> 0x0178 }
        r13 = r13.append(r14);	 Catch:{ Exception -> 0x02b6, JSONException -> 0x0178 }
        r14 = 0;	 Catch:{ Exception -> 0x02b6, JSONException -> 0x0178 }
        r14 = com.vlocker.theme.f.e.a(r14);	 Catch:{ Exception -> 0x02b6, JSONException -> 0x0178 }
        r13 = r13.append(r14);	 Catch:{ Exception -> 0x02b6, JSONException -> 0x0178 }
        r13 = r13.toString();	 Catch:{ Exception -> 0x02b6, JSONException -> 0x0178 }
        r11.a(r13);	 Catch:{ Exception -> 0x02b6, JSONException -> 0x0178 }
        r10.add(r11);	 Catch:{ Exception -> 0x02b6, JSONException -> 0x0178 }
    L_0x0288:
        r13 = 1;	 Catch:{ Exception -> 0x02b6, JSONException -> 0x0178 }
        if (r1 != r13) goto L_0x02ae;	 Catch:{ Exception -> 0x02b6, JSONException -> 0x0178 }
    L_0x028b:
        r13 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x02b6, JSONException -> 0x0178 }
        r13.<init>();	 Catch:{ Exception -> 0x02b6, JSONException -> 0x0178 }
        r14 = "preview2";	 Catch:{ Exception -> 0x02b6, JSONException -> 0x0178 }
        r14 = r9.getString(r14);	 Catch:{ Exception -> 0x02b6, JSONException -> 0x0178 }
        r13 = r13.append(r14);	 Catch:{ Exception -> 0x02b6, JSONException -> 0x0178 }
        r14 = 0;	 Catch:{ Exception -> 0x02b6, JSONException -> 0x0178 }
        r14 = com.vlocker.theme.f.e.a(r14);	 Catch:{ Exception -> 0x02b6, JSONException -> 0x0178 }
        r13 = r13.append(r14);	 Catch:{ Exception -> 0x02b6, JSONException -> 0x0178 }
        r13 = r13.toString();	 Catch:{ Exception -> 0x02b6, JSONException -> 0x0178 }
        r12.a(r13);	 Catch:{ Exception -> 0x02b6, JSONException -> 0x0178 }
        r10.add(r12);	 Catch:{ Exception -> 0x02b6, JSONException -> 0x0178 }
    L_0x02ae:
        r1 = r1 + 1;	 Catch:{ Exception -> 0x02b6, JSONException -> 0x0178 }
        goto L_0x0260;	 Catch:{ Exception -> 0x02b6, JSONException -> 0x0178 }
    L_0x02b1:
        r8.a(r10);	 Catch:{ Exception -> 0x02b6, JSONException -> 0x0178 }
        goto L_0x0180;
    L_0x02b6:
        r1 = move-exception;
        goto L_0x0180;
    L_0x02b9:
        r1 = "meta";	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r2 = r6.getJSONObject(r1);	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r1 = "config";	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r1 = r6.getString(r1);	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r7 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r7.<init>(r1);	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r1 = "version";	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r1 = r7.getString(r1);	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r3.e(r1);	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r1 = "version";	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r1 = r7.getString(r1);	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r8 = "1";	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r1 = r1.equals(r8);	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        if (r1 == 0) goto L_0x032b;
    L_0x02e6:
        r1 = "text_tpl";	 Catch:{ Exception -> 0x0399, JSONException -> 0x0178 }
        r1 = r7.getJSONArray(r1);	 Catch:{ Exception -> 0x0399, JSONException -> 0x0178 }
        r8 = 0;	 Catch:{ Exception -> 0x0399, JSONException -> 0x0178 }
        r1 = r1.get(r8);	 Catch:{ Exception -> 0x0399, JSONException -> 0x0178 }
        r1 = r1.toString();	 Catch:{ Exception -> 0x0399, JSONException -> 0x0178 }
        r3.d(r1);	 Catch:{ Exception -> 0x0399, JSONException -> 0x0178 }
    L_0x02f9:
        r1 = "bannar_img";	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r1 = r7.getString(r1);	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r3.c(r1);	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r1 = "link_type";	 Catch:{ Exception -> 0x03b9, JSONException -> 0x0178 }
        r1 = r7.getString(r1);	 Catch:{ Exception -> 0x03b9, JSONException -> 0x0178 }
        if (r1 == 0) goto L_0x032b;	 Catch:{ Exception -> 0x03b9, JSONException -> 0x0178 }
    L_0x030c:
        r8 = "";	 Catch:{ Exception -> 0x03b9, JSONException -> 0x0178 }
        r8 = r1.equals(r8);	 Catch:{ Exception -> 0x03b9, JSONException -> 0x0178 }
        if (r8 != 0) goto L_0x032b;	 Catch:{ Exception -> 0x03b9, JSONException -> 0x0178 }
    L_0x0315:
        r3.a(r1);	 Catch:{ Exception -> 0x03b9, JSONException -> 0x0178 }
        r8 = "link_content";	 Catch:{ Exception -> 0x03b3, JSONException -> 0x0178 }
        r7 = r7.getString(r8);	 Catch:{ Exception -> 0x03b3, JSONException -> 0x0178 }
        r8 = "site";	 Catch:{ Exception -> 0x03b3, JSONException -> 0x0178 }
        r8 = r1.equals(r8);	 Catch:{ Exception -> 0x03b3, JSONException -> 0x0178 }
        if (r8 == 0) goto L_0x03a5;	 Catch:{ Exception -> 0x03b3, JSONException -> 0x0178 }
    L_0x0328:
        r3.b(r7);	 Catch:{ Exception -> 0x03b3, JSONException -> 0x0178 }
    L_0x032b:
        r1 = "pre";	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r7 = r2.getString(r1);	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r1 = "next";	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r8 = r2.getString(r1);	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r1 = "pages";	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r9 = r2.getInt(r1);	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r1 = "page";	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r10 = r2.getInt(r1);	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r1 = "total";	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r11 = r2.getInt(r1);	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r1 = "result";	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r2 = r2.getBoolean(r1);	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r1 = "tags";	 Catch:{ Exception -> 0x0412, JSONException -> 0x0178 }
        r6 = r6.getJSONArray(r1);	 Catch:{ Exception -> 0x0412, JSONException -> 0x0178 }
        if (r2 == 0) goto L_0x03ed;	 Catch:{ Exception -> 0x0412, JSONException -> 0x0178 }
    L_0x035e:
        r1 = 1;	 Catch:{ Exception -> 0x0412, JSONException -> 0x0178 }
        if (r10 != r1) goto L_0x03ed;	 Catch:{ Exception -> 0x0412, JSONException -> 0x0178 }
    L_0x0361:
        if (r6 == 0) goto L_0x03ed;	 Catch:{ Exception -> 0x0412, JSONException -> 0x0178 }
    L_0x0363:
        r1 = r6.length();	 Catch:{ Exception -> 0x0412, JSONException -> 0x0178 }
        r12 = 1;	 Catch:{ Exception -> 0x0412, JSONException -> 0x0178 }
        if (r1 <= r12) goto L_0x03ed;	 Catch:{ Exception -> 0x0412, JSONException -> 0x0178 }
    L_0x036a:
        r12 = new com.vlocker.theme.model.d;	 Catch:{ Exception -> 0x0412, JSONException -> 0x0178 }
        r12.<init>();	 Catch:{ Exception -> 0x0412, JSONException -> 0x0178 }
        r1 = 0;	 Catch:{ Exception -> 0x0412, JSONException -> 0x0178 }
    L_0x0370:
        r13 = r6.length();	 Catch:{ Exception -> 0x0412, JSONException -> 0x0178 }
        if (r1 >= r13) goto L_0x03ea;	 Catch:{ Exception -> 0x0412, JSONException -> 0x0178 }
    L_0x0376:
        r13 = r6.getJSONObject(r1);	 Catch:{ Exception -> 0x0412, JSONException -> 0x0178 }
        r14 = new com.vlocker.theme.model.T_SearchOrderInfo;	 Catch:{ Exception -> 0x0412, JSONException -> 0x0178 }
        r14.<init>();	 Catch:{ Exception -> 0x0412, JSONException -> 0x0178 }
        r15 = "title";	 Catch:{ Exception -> 0x0412, JSONException -> 0x0178 }
        r15 = r13.getString(r15);	 Catch:{ Exception -> 0x0412, JSONException -> 0x0178 }
        r14.a(r15);	 Catch:{ Exception -> 0x0412, JSONException -> 0x0178 }
        r15 = "dataurl";	 Catch:{ Exception -> 0x0412, JSONException -> 0x0178 }
        r13 = r13.getString(r15);	 Catch:{ Exception -> 0x0412, JSONException -> 0x0178 }
        r14.b(r13);	 Catch:{ Exception -> 0x0412, JSONException -> 0x0178 }
        r12.add(r14);	 Catch:{ Exception -> 0x0412, JSONException -> 0x0178 }
        r1 = r1 + 1;
        goto L_0x0370;
    L_0x0399:
        r1 = move-exception;
        r1.printStackTrace();	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        goto L_0x02f9;
    L_0x039f:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x017c;
    L_0x03a5:
        r8 = "list";	 Catch:{ Exception -> 0x03b3, JSONException -> 0x0178 }
        r8 = r1.equals(r8);	 Catch:{ Exception -> 0x03b3, JSONException -> 0x0178 }
        if (r8 == 0) goto L_0x03bf;	 Catch:{ Exception -> 0x03b3, JSONException -> 0x0178 }
    L_0x03ae:
        r3.b(r7);	 Catch:{ Exception -> 0x03b3, JSONException -> 0x0178 }
        goto L_0x032b;
    L_0x03b3:
        r1 = move-exception;
        r1.printStackTrace();	 Catch:{ Exception -> 0x03b9, JSONException -> 0x0178 }
        goto L_0x032b;
    L_0x03b9:
        r1 = move-exception;
        r1.printStackTrace();	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        goto L_0x032b;
    L_0x03bf:
        r8 = "theme";	 Catch:{ Exception -> 0x03b3, JSONException -> 0x0178 }
        r8 = r1.equals(r8);	 Catch:{ Exception -> 0x03b3, JSONException -> 0x0178 }
        if (r8 == 0) goto L_0x03dc;
    L_0x03c8:
        r1 = new org.json.JSONObject;	 Catch:{ Exception -> 0x03d6, JSONException -> 0x0178 }
        r1.<init>(r7);	 Catch:{ Exception -> 0x03d6, JSONException -> 0x0178 }
        r1 = com.vlocker.theme.f.e.a(r1);	 Catch:{ Exception -> 0x03d6, JSONException -> 0x0178 }
        r3.a(r1);	 Catch:{ Exception -> 0x03d6, JSONException -> 0x0178 }
        goto L_0x032b;
    L_0x03d6:
        r1 = move-exception;
        r1.printStackTrace();	 Catch:{ Exception -> 0x03b3, JSONException -> 0x0178 }
        goto L_0x032b;	 Catch:{ Exception -> 0x03b3, JSONException -> 0x0178 }
    L_0x03dc:
        r8 = "url";	 Catch:{ Exception -> 0x03b3, JSONException -> 0x0178 }
        r1 = r1.equals(r8);	 Catch:{ Exception -> 0x03b3, JSONException -> 0x0178 }
        if (r1 == 0) goto L_0x032b;	 Catch:{ Exception -> 0x03b3, JSONException -> 0x0178 }
    L_0x03e5:
        r3.b(r7);	 Catch:{ Exception -> 0x03b3, JSONException -> 0x0178 }
        goto L_0x032b;
    L_0x03ea:
        r3.a(r12);	 Catch:{ Exception -> 0x0412, JSONException -> 0x0178 }
    L_0x03ed:
        r3.b(r4);	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r3.f(r7);	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r3.g(r8);	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r3.a(r9);	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r3.b(r10);	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r3.c(r11);	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r3.a(r2);	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        r3.d(r5);	 Catch:{ JSONException -> 0x0178, Exception -> 0x039f }
        goto L_0x017c;
    L_0x0407:
        r2 = "message";	 Catch:{ Exception -> 0x040f, JSONException -> 0x0178 }
        r1.getString(r2);	 Catch:{ Exception -> 0x040f, JSONException -> 0x0178 }
        goto L_0x017c;
    L_0x040f:
        r1 = move-exception;
        goto L_0x017c;
    L_0x0412:
        r1 = move-exception;
        goto L_0x03ed;
    L_0x0414:
        r1 = move-exception;
        goto L_0x01e1;
    L_0x0417:
        r1 = move-exception;
        goto L_0x01ce;
    L_0x041a:
        r1 = move-exception;
        goto L_0x01bb;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vlocker.new_theme.d.a.a(java.lang.String):com.vlocker.theme.model.T_ThemeListPageInfo");
    }

    public /* synthetic */ b b(String str) {
        return a(str);
    }
}
