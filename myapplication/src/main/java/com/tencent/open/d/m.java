package com.tencent.open.d;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.open.a.j;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class m {
    private static Map a = Collections.synchronizedMap(new HashMap());
    private static String b = null;
    private Context c = null;
    private String d = null;
    private JSONObject e = null;
    private long f = 0;
    private int g = 0;
    private boolean h = true;

    private m(Context context, String str) {
        this.c = context.getApplicationContext();
        this.d = str;
        a();
        b();
    }

    public static m a(Context context, String str) {
        m mVar;
        synchronized (a) {
            j.a("openSDK_LOG.OpenConfig", "getInstance begin");
            if (str != null) {
                b = str;
            }
            if (str == null) {
                str = b != null ? b : "0";
            }
            mVar = (m) a.get(str);
            if (mVar == null) {
                mVar = new m(context, str);
                a.put(str, mVar);
            }
            j.a("openSDK_LOG.OpenConfig", "getInstance end");
        }
        return mVar;
    }

    private void a() {
        try {
            this.e = new JSONObject(c("com.tencent.open.config.json"));
        } catch (JSONException e) {
            this.e = new JSONObject();
        }
    }

    private void a(String str, String str2) {
        try {
            if (this.d != null) {
                str = str + "." + this.d;
            }
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(this.c.openFileOutput(str, 0), Charset.forName("UTF-8"));
            outputStreamWriter.write(str2);
            outputStreamWriter.flush();
            outputStreamWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void a(JSONObject jSONObject) {
        d("cgi back, do update");
        this.e = jSONObject;
        a("com.tencent.open.config.json", jSONObject.toString());
        this.f = SystemClock.elapsedRealtime();
    }

    private void b() {
        if (this.g != 0) {
            d("update thread is running, return");
            return;
        }
        this.g = 1;
        Bundle bundle = new Bundle();
        bundle.putString("appid", this.d);
        bundle.putString("appid_for_getting_config", this.d);
        bundle.putString("status_os", VERSION.RELEASE);
        bundle.putString("status_machine", Build.MODEL);
        bundle.putString("status_version", VERSION.SDK);
        bundle.putString("sdkv", "2.9.4.lite");
        bundle.putString("sdkp", "a");
        new n(this, bundle).start();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String c(java.lang.String r6) {
        /*
        r5 = this;
        r1 = "";
        r0 = r5.d;	 Catch:{ FileNotFoundException -> 0x0055 }
        if (r0 == 0) goto L_0x0053;
    L_0x0007:
        r0 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0055 }
        r0.<init>();	 Catch:{ FileNotFoundException -> 0x0055 }
        r0 = r0.append(r6);	 Catch:{ FileNotFoundException -> 0x0055 }
        r2 = ".";
        r0 = r0.append(r2);	 Catch:{ FileNotFoundException -> 0x0055 }
        r2 = r5.d;	 Catch:{ FileNotFoundException -> 0x0055 }
        r0 = r0.append(r2);	 Catch:{ FileNotFoundException -> 0x0055 }
        r0 = r0.toString();	 Catch:{ FileNotFoundException -> 0x0055 }
    L_0x0021:
        r2 = r5.c;	 Catch:{ FileNotFoundException -> 0x0055 }
        r0 = r2.openFileInput(r0);	 Catch:{ FileNotFoundException -> 0x0055 }
    L_0x0027:
        r3 = new java.io.BufferedReader;
        r2 = new java.io.InputStreamReader;
        r4 = "UTF-8";
        r4 = java.nio.charset.Charset.forName(r4);
        r2.<init>(r0, r4);
        r3.<init>(r2);
        r2 = new java.lang.StringBuffer;
        r2.<init>();
    L_0x003d:
        r4 = r3.readLine();	 Catch:{ IOException -> 0x0047 }
        if (r4 == 0) goto L_0x0067;
    L_0x0043:
        r2.append(r4);	 Catch:{ IOException -> 0x0047 }
        goto L_0x003d;
    L_0x0047:
        r2 = move-exception;
        r2.printStackTrace();	 Catch:{ all -> 0x007f }
        r0.close();	 Catch:{ IOException -> 0x0079 }
        r3.close();	 Catch:{ IOException -> 0x0079 }
        r0 = r1;
    L_0x0052:
        return r0;
    L_0x0053:
        r0 = r6;
        goto L_0x0021;
    L_0x0055:
        r0 = move-exception;
        r0 = r5.c;	 Catch:{ IOException -> 0x0061 }
        r0 = r0.getAssets();	 Catch:{ IOException -> 0x0061 }
        r0 = r0.open(r6);	 Catch:{ IOException -> 0x0061 }
        goto L_0x0027;
    L_0x0061:
        r0 = move-exception;
        r0.printStackTrace();
        r0 = r1;
        goto L_0x0052;
    L_0x0067:
        r1 = r2.toString();	 Catch:{ IOException -> 0x0047 }
        r0.close();	 Catch:{ IOException -> 0x0073 }
        r3.close();	 Catch:{ IOException -> 0x0073 }
        r0 = r1;
        goto L_0x0052;
    L_0x0073:
        r0 = move-exception;
        r0.printStackTrace();
        r0 = r1;
        goto L_0x0052;
    L_0x0079:
        r0 = move-exception;
        r0.printStackTrace();
        r0 = r1;
        goto L_0x0052;
    L_0x007f:
        r1 = move-exception;
        r0.close();	 Catch:{ IOException -> 0x0087 }
        r3.close();	 Catch:{ IOException -> 0x0087 }
    L_0x0086:
        throw r1;
    L_0x0087:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x0086;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.d.m.c(java.lang.String):java.lang.String");
    }

    private void c() {
        int optInt = this.e.optInt("Common_frequency");
        if (optInt == 0) {
            optInt = 1;
        }
        if (SystemClock.elapsedRealtime() - this.f >= ((long) (optInt * 3600000))) {
            b();
        }
    }

    private void d(String str) {
        if (this.h) {
            j.a("openSDK_LOG.OpenConfig", str + "; appid: " + this.d);
        }
    }

    public int a(String str) {
        d("get " + str);
        c();
        return this.e.optInt(str);
    }

    public boolean b(String str) {
        d("get " + str);
        c();
        Object opt = this.e.opt(str);
        if (opt == null) {
            return false;
        }
        if (!(opt instanceof Integer)) {
            return opt instanceof Boolean ? ((Boolean) opt).booleanValue() : false;
        } else {
            return !opt.equals(Integer.valueOf(0));
        }
    }
}
