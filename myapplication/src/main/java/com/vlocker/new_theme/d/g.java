package com.vlocker.new_theme.d;

import com.vlocker.theme.model.b;

public class g implements b {
    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.vlocker.new_theme.beans.T_SpecialThemePageInfo a(java.lang.String r11) {
        /*
        r10 = this;
        r1 = new com.vlocker.new_theme.beans.T_SpecialThemePageInfo;
        r1.<init>();
        r0 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x00c9, Exception -> 0x00ce }
        r0.<init>(r11);	 Catch:{ JSONException -> 0x00c9, Exception -> 0x00ce }
        r2 = "code";
        r0.getInt(r2);	 Catch:{ JSONException -> 0x00c9, Exception -> 0x00ce }
        r2 = "data";
        r2 = r0.getJSONObject(r2);	 Catch:{ JSONException -> 0x00c9, Exception -> 0x00ce }
        r0 = "list";
        r3 = r2.getJSONArray(r0);	 Catch:{ JSONException -> 0x00c9, Exception -> 0x00ce }
        r0 = r3.length();	 Catch:{ JSONException -> 0x00c9, Exception -> 0x00ce }
        if (r0 <= 0) goto L_0x00c8;
    L_0x0024:
        r4 = new com.vlocker.theme.model.d;	 Catch:{ JSONException -> 0x00c9, Exception -> 0x00ce }
        r4.<init>();	 Catch:{ JSONException -> 0x00c9, Exception -> 0x00ce }
        r0 = 0;
    L_0x002a:
        r5 = r3.length();	 Catch:{ JSONException -> 0x00c9, Exception -> 0x00ce }
        if (r0 >= r5) goto L_0x008c;
    L_0x0030:
        r5 = new com.vlocker.new_theme.beans.T_SpecialThemeInfo;	 Catch:{ JSONException -> 0x00c9, Exception -> 0x00ce }
        r5.<init>();	 Catch:{ JSONException -> 0x00c9, Exception -> 0x00ce }
        r6 = r3.getJSONObject(r0);	 Catch:{ JSONException -> 0x00c9, Exception -> 0x00ce }
        r7 = "id";
        r7 = r6.getInt(r7);	 Catch:{ JSONException -> 0x00c9, Exception -> 0x00ce }
        r7 = java.lang.String.valueOf(r7);	 Catch:{ JSONException -> 0x00c9, Exception -> 0x00ce }
        r5.a(r7);	 Catch:{ JSONException -> 0x00c9, Exception -> 0x00ce }
        r7 = "title";
        r7 = r6.getString(r7);	 Catch:{ JSONException -> 0x00c9, Exception -> 0x00ce }
        r5.c(r7);	 Catch:{ JSONException -> 0x00c9, Exception -> 0x00ce }
        r7 = "desc";
        r7 = r6.getString(r7);	 Catch:{ JSONException -> 0x00c9, Exception -> 0x00ce }
        r5.d(r7);	 Catch:{ JSONException -> 0x00c9, Exception -> 0x00ce }
        r7 = "preview";
        r7 = r6.getString(r7);	 Catch:{ JSONException -> 0x00c9, Exception -> 0x00ce }
        r5.b(r7);	 Catch:{ JSONException -> 0x00c9, Exception -> 0x00ce }
        r7 = "dataurl";
        r7 = r6.getString(r7);	 Catch:{ JSONException -> 0x00c9, Exception -> 0x00ce }
        r5.e(r7);	 Catch:{ JSONException -> 0x00c9, Exception -> 0x00ce }
        r7 = "count";
        r7 = r6.getInt(r7);	 Catch:{ JSONException -> 0x00c9, Exception -> 0x00ce }
        r5.a(r7);	 Catch:{ JSONException -> 0x00c9, Exception -> 0x00ce }
        r7 = "mtime";
        r6 = r6.getLong(r7);	 Catch:{ JSONException -> 0x00c9, Exception -> 0x00ce }
        r8 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r6 = r6 * r8;
        r5.a(r6);	 Catch:{ JSONException -> 0x00c9, Exception -> 0x00ce }
        r4.add(r5);	 Catch:{ JSONException -> 0x00c9, Exception -> 0x00ce }
        r0 = r0 + 1;
        goto L_0x002a;
    L_0x008c:
        r1.a(r4);	 Catch:{ JSONException -> 0x00c9, Exception -> 0x00ce }
        r0 = "meta";
        r0 = r2.getJSONObject(r0);	 Catch:{ Exception -> 0x00d3, JSONException -> 0x00c9 }
        r2 = "pre";
        r2 = r0.getString(r2);	 Catch:{ Exception -> 0x00d3, JSONException -> 0x00c9 }
        r3 = "next";
        r3 = r0.getString(r3);	 Catch:{ Exception -> 0x00d3, JSONException -> 0x00c9 }
        r4 = "page";
        r4 = r0.getInt(r4);	 Catch:{ Exception -> 0x00d3, JSONException -> 0x00c9 }
        r5 = "pages";
        r5 = r0.getInt(r5);	 Catch:{ Exception -> 0x00d3, JSONException -> 0x00c9 }
        r6 = "total";
        r0 = r0.getInt(r6);	 Catch:{ Exception -> 0x00d3, JSONException -> 0x00c9 }
        r1.a(r5);	 Catch:{ Exception -> 0x00d3, JSONException -> 0x00c9 }
        r1.a(r2);	 Catch:{ Exception -> 0x00d3, JSONException -> 0x00c9 }
        r1.b(r3);	 Catch:{ Exception -> 0x00d3, JSONException -> 0x00c9 }
        r1.b(r4);	 Catch:{ Exception -> 0x00d3, JSONException -> 0x00c9 }
        r1.c(r0);	 Catch:{ Exception -> 0x00d3, JSONException -> 0x00c9 }
    L_0x00c8:
        return r1;
    L_0x00c9:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x00c8;
    L_0x00ce:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x00c8;
    L_0x00d3:
        r0 = move-exception;
        goto L_0x00c8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vlocker.new_theme.d.g.a(java.lang.String):com.vlocker.new_theme.beans.T_SpecialThemePageInfo");
    }

    public /* synthetic */ b b(String str) {
        return a(str);
    }
}
