package com.vlocker.new_theme.d;

import android.content.Context;
import com.vlocker.b.i;
import com.vlocker.new_theme.beans.T_CateInfo;
import com.vlocker.new_theme.beans.T_CateItemTagInfo;
import com.vlocker.theme.d.a.b;
import com.vlocker.theme.e.a;
import com.vlocker.theme.f.e;
import com.vlocker.theme.model.d;
import com.vlocker.ui.widget.az;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class f {
    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized java.lang.String a(java.lang.String r6) {
        /*
        r1 = com.vlocker.new_theme.d.f.class;
        monitor-enter(r1);
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0076 }
        r2.<init>();	 Catch:{ all -> 0x0076 }
        r0 = new org.apache.http.impl.client.DefaultHttpClient;	 Catch:{ SocketTimeoutException -> 0x0071, ClientProtocolException -> 0x0079, IOException -> 0x007e, Exception -> 0x0083 }
        r0.<init>();	 Catch:{ SocketTimeoutException -> 0x0071, ClientProtocolException -> 0x0079, IOException -> 0x007e, Exception -> 0x0083 }
        r3 = r0.getParams();	 Catch:{ SocketTimeoutException -> 0x0071, ClientProtocolException -> 0x0079, IOException -> 0x007e, Exception -> 0x0083 }
        r4 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        org.apache.http.params.HttpConnectionParams.setConnectionTimeout(r3, r4);	 Catch:{ SocketTimeoutException -> 0x0071, ClientProtocolException -> 0x0079, IOException -> 0x007e, Exception -> 0x0083 }
        r4 = 8000; // 0x1f40 float:1.121E-41 double:3.9525E-320;
        org.apache.http.params.HttpConnectionParams.setSoTimeout(r3, r4);	 Catch:{ SocketTimeoutException -> 0x0071, ClientProtocolException -> 0x0079, IOException -> 0x007e, Exception -> 0x0083 }
        r3 = new org.apache.http.client.methods.HttpGet;	 Catch:{ SocketTimeoutException -> 0x0071, ClientProtocolException -> 0x0079, IOException -> 0x007e, Exception -> 0x0083 }
        r3.<init>(r6);	 Catch:{ SocketTimeoutException -> 0x0071, ClientProtocolException -> 0x0079, IOException -> 0x007e, Exception -> 0x0083 }
        r0 = r0.execute(r3);	 Catch:{ SocketTimeoutException -> 0x0071, ClientProtocolException -> 0x0079, IOException -> 0x007e, Exception -> 0x0083 }
        r3 = r0.getEntity();	 Catch:{ SocketTimeoutException -> 0x0071, ClientProtocolException -> 0x0079, IOException -> 0x007e, Exception -> 0x0083 }
        r0 = r0.getStatusLine();	 Catch:{ SocketTimeoutException -> 0x0071, ClientProtocolException -> 0x0079, IOException -> 0x007e, Exception -> 0x0083 }
        r0 = r0.getStatusCode();	 Catch:{ SocketTimeoutException -> 0x0071, ClientProtocolException -> 0x0079, IOException -> 0x007e, Exception -> 0x0083 }
        r4 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r0 != r4) goto L_0x006b;
    L_0x0034:
        if (r3 == 0) goto L_0x006b;
    L_0x0036:
        r0 = new java.io.BufferedReader;	 Catch:{ SocketTimeoutException -> 0x0071, ClientProtocolException -> 0x0079, IOException -> 0x007e, Exception -> 0x0083 }
        r4 = new java.io.InputStreamReader;	 Catch:{ SocketTimeoutException -> 0x0071, ClientProtocolException -> 0x0079, IOException -> 0x007e, Exception -> 0x0083 }
        r3 = r3.getContent();	 Catch:{ SocketTimeoutException -> 0x0071, ClientProtocolException -> 0x0079, IOException -> 0x007e, Exception -> 0x0083 }
        r5 = "UTF-8";
        r4.<init>(r3, r5);	 Catch:{ SocketTimeoutException -> 0x0071, ClientProtocolException -> 0x0079, IOException -> 0x007e, Exception -> 0x0083 }
        r3 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;
        r0.<init>(r4, r3);	 Catch:{ SocketTimeoutException -> 0x0071, ClientProtocolException -> 0x0079, IOException -> 0x007e, Exception -> 0x0083 }
    L_0x0049:
        r3 = r0.readLine();	 Catch:{ OutOfMemoryError -> 0x0067, Exception -> 0x0088, SocketTimeoutException -> 0x0071, ClientProtocolException -> 0x0079, IOException -> 0x007e }
        if (r3 == 0) goto L_0x0068;
    L_0x004f:
        r4 = new java.lang.StringBuilder;	 Catch:{ OutOfMemoryError -> 0x0067, Exception -> 0x0088, SocketTimeoutException -> 0x0071, ClientProtocolException -> 0x0079, IOException -> 0x007e }
        r4.<init>();	 Catch:{ OutOfMemoryError -> 0x0067, Exception -> 0x0088, SocketTimeoutException -> 0x0071, ClientProtocolException -> 0x0079, IOException -> 0x007e }
        r3 = r4.append(r3);	 Catch:{ OutOfMemoryError -> 0x0067, Exception -> 0x0088, SocketTimeoutException -> 0x0071, ClientProtocolException -> 0x0079, IOException -> 0x007e }
        r4 = "\n";
        r3 = r3.append(r4);	 Catch:{ OutOfMemoryError -> 0x0067, Exception -> 0x0088, SocketTimeoutException -> 0x0071, ClientProtocolException -> 0x0079, IOException -> 0x007e }
        r3 = r3.toString();	 Catch:{ OutOfMemoryError -> 0x0067, Exception -> 0x0088, SocketTimeoutException -> 0x0071, ClientProtocolException -> 0x0079, IOException -> 0x007e }
        r2.append(r3);	 Catch:{ OutOfMemoryError -> 0x0067, Exception -> 0x0088, SocketTimeoutException -> 0x0071, ClientProtocolException -> 0x0079, IOException -> 0x007e }
        goto L_0x0049;
    L_0x0067:
        r3 = move-exception;
    L_0x0068:
        r0.close();	 Catch:{ SocketTimeoutException -> 0x0071, ClientProtocolException -> 0x0079, IOException -> 0x007e, Exception -> 0x0083 }
    L_0x006b:
        r0 = r2.toString();	 Catch:{ all -> 0x0076 }
        monitor-exit(r1);
        return r0;
    L_0x0071:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ all -> 0x0076 }
        goto L_0x006b;
    L_0x0076:
        r0 = move-exception;
        monitor-exit(r1);
        throw r0;
    L_0x0079:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ all -> 0x0076 }
        goto L_0x006b;
    L_0x007e:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ all -> 0x0076 }
        goto L_0x006b;
    L_0x0083:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ all -> 0x0076 }
        goto L_0x006b;
    L_0x0088:
        r3 = move-exception;
        goto L_0x0068;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vlocker.new_theme.d.f.a(java.lang.String):java.lang.String");
    }

    public static List a(Context context, String str) {
        String str2 = "";
        str2 = a(str);
        if (str2.length() <= 10) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str2);
        if (jSONObject.getInt("code") != 200) {
            return null;
        }
        List arrayList = new ArrayList();
        JSONArray jSONArray = jSONObject.getJSONObject("data").getJSONArray("cates");
        for (int i = 0; i < jSONArray.length(); i++) {
            jSONObject = jSONArray.getJSONObject(i);
            T_CateInfo t_CateInfo = new T_CateInfo();
            t_CateInfo.a(jSONObject.getString("title"));
            t_CateInfo.e(jSONObject.getString("preview") + "/220_220");
            t_CateInfo.c(jSONObject.getString("desc"));
            t_CateInfo.f(jSONObject.getString("downurl"));
            t_CateInfo.g(jSONObject.getString("allurl"));
            t_CateInfo.h(jSONObject.getString("cmturl"));
            t_CateInfo.d(String.valueOf(jSONObject.getInt("mtime")));
            t_CateInfo.a(jSONObject.getInt("count"));
            t_CateInfo.b(e.f(context, jSONObject.getString("title")));
            try {
                t_CateInfo.b(jSONObject.getString("tag"));
            } catch (Exception e) {
            }
            try {
                JSONArray jSONArray2 = jSONObject.getJSONArray("tags");
                if (jSONArray2 != null && jSONArray2.length() > 0) {
                    d dVar = new d();
                    for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                        JSONObject jSONObject2 = jSONArray2.getJSONObject(i2);
                        T_CateItemTagInfo t_CateItemTagInfo = new T_CateItemTagInfo();
                        t_CateItemTagInfo.a(jSONObject2.getString("title"));
                        t_CateItemTagInfo.b(jSONObject2.getString("dataurl"));
                        dVar.add(t_CateItemTagInfo);
                    }
                    t_CateInfo.a(dVar);
                }
            } catch (Exception e2) {
            }
            arrayList.add(t_CateInfo);
        }
        try {
            return e.b(arrayList);
        } catch (Exception e3) {
            return arrayList;
        }
    }

    public static String b(String str) {
        String str2 = "";
        for (int i = 0; i < 3; i++) {
            str2 = a(i.a() + str);
            if (str2.length() >= 10) {
                return str2;
            }
            if (i == 2) {
                return null;
            }
            i.n++;
            if (i.n > 2) {
                i.n = 0;
            }
        }
        return str2;
    }

    public static List b(Context context, String str) {
        int i = 0;
        String str2 = "";
        Boolean.valueOf(false);
        str2 = a(str);
        if (str2.length() < 10) {
            str2 = a(str);
        }
        Boolean valueOf = Boolean.valueOf(true);
        if (str2.length() <= 10) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str2);
        if (jSONObject.getInt("code") != 200) {
            return null;
        }
        List arrayList = new ArrayList();
        JSONArray jSONArray = jSONObject.getJSONObject("data").getJSONArray("tags");
        while (i < jSONArray.length()) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            HashMap hashMap = new HashMap();
            hashMap.put("tagname", jSONObject2.getString("tagname"));
            arrayList.add(hashMap);
            i++;
        }
        if (valueOf.booleanValue()) {
            e.c(e.a, str2);
        }
        return arrayList;
    }

    public static az c(String str) {
        try {
            return new a().a(b(str));
        } catch (com.vlocker.theme.d.a.a e) {
            return null;
        } catch (b e2) {
            return null;
        }
    }
}
