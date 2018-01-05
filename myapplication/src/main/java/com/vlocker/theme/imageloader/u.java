package com.vlocker.theme.imageloader;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.qq.e.comm.constants.ErrorCode.NetWorkError;
import com.vlocker.b.i;
import com.vlocker.b.j;
import com.vlocker.locker.R;
import com.vlocker.theme.f.e;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class u {
    public r a;
    public Context b;
    private boolean c;
    private final Object d = new Object();
    private boolean e;
    private Resources f;
    private l g;
    private File h;
    private int i = 240;
    private int j = 720;
    private final HashMap k = new HashMap();
    private int l;
    private boolean m = false;
    private Executor n;

    public u(Context context) {
        this.b = context;
        this.f = context.getResources();
        if (aa.c()) {
            this.m = true;
        } else {
            this.m = false;
        }
        this.n = Executors.newCachedThreadPool();
        this.h = new File(i.h);
        j();
    }

    private void a(RecyclingImageView recyclingImageView, Drawable drawable, int i) {
        if (i == 0) {
            recyclingImageView.setScaleType(ScaleType.FIT_CENTER);
        }
        if (this.m) {
            Drawable transitionDrawable = new TransitionDrawable(new Drawable[]{new ColorDrawable(17170445), drawable});
            recyclingImageView.setImageDrawable(transitionDrawable);
            transitionDrawable.startTransition(NetWorkError.STUB_NETWORK_ERROR);
            return;
        }
        recyclingImageView.setImageDrawable(drawable);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void a(java.lang.String r18, android.content.Context r19, java.lang.String r20, java.lang.String r21) {
        /*
        r8 = com.vlocker.theme.imageloader.u.class;
        monitor-enter(r8);
        r2 = "uploadtimes";
        r3 = 11;
        r0 = r19;
        r2 = com.vlocker.theme.f.a.a(r2, r0, r3);	 Catch:{ NullPointerException -> 0x023a, Exception -> 0x0237, all -> 0x022e }
        r3 = 10;
        if (r2 >= r3) goto L_0x00a6;
    L_0x0012:
        r3 = com.vlocker.b.j.f(r19);	 Catch:{ NullPointerException -> 0x023a, Exception -> 0x0237, all -> 0x022e }
        if (r3 == 0) goto L_0x00a6;
    L_0x0018:
        r3 = "uploadtimes";
        r2 = r2 + 1;
        r0 = r19;
        com.vlocker.theme.f.a.a(r3, r2, r0);	 Catch:{ NullPointerException -> 0x023a, Exception -> 0x0237, all -> 0x022e }
        r9 = com.vlocker.b.h.a(r18, r19);	 Catch:{ NullPointerException -> 0x023a, Exception -> 0x0237, all -> 0x022e }
        r10 = com.vlocker.b.j.b(r19);	 Catch:{ NullPointerException -> 0x023a, Exception -> 0x0237, all -> 0x022e }
        r2 = 0;
        if (r2 != 0) goto L_0x0246;
    L_0x002d:
        r2 = "phone";
        r0 = r19;
        r2 = r0.getSystemService(r2);	 Catch:{ NullPointerException -> 0x023a, Exception -> 0x0237, all -> 0x022e }
        r2 = (android.telephony.TelephonyManager) r2;	 Catch:{ NullPointerException -> 0x023a, Exception -> 0x0237, all -> 0x022e }
        r2 = r2.getDeviceId();	 Catch:{ NullPointerException -> 0x023a, Exception -> 0x0237, all -> 0x022e }
        r7 = r2;
    L_0x003d:
        r2 = 0;
        if (r2 != 0) goto L_0x0243;
    L_0x0040:
        r2 = "wifi";
        r0 = r19;
        r2 = r0.getSystemService(r2);	 Catch:{ NullPointerException -> 0x023a, Exception -> 0x0237, all -> 0x022e }
        r2 = (android.net.wifi.WifiManager) r2;	 Catch:{ NullPointerException -> 0x023a, Exception -> 0x0237, all -> 0x022e }
        r2 = r2.getConnectionInfo();	 Catch:{ NullPointerException -> 0x023a, Exception -> 0x0237, all -> 0x022e }
        r2 = r2.getMacAddress();	 Catch:{ NullPointerException -> 0x023a, Exception -> 0x0237, all -> 0x022e }
        r6 = r2;
    L_0x0054:
        r2 = java.lang.System.currentTimeMillis();	 Catch:{ NullPointerException -> 0x023a, Exception -> 0x0237, all -> 0x022e }
        r2 = java.lang.Long.valueOf(r2);	 Catch:{ NullPointerException -> 0x023a, Exception -> 0x0237, all -> 0x022e }
        r2 = r2.longValue();	 Catch:{ NullPointerException -> 0x023a, Exception -> 0x0237, all -> 0x022e }
        r4 = com.vlocker.c.a.a(r19);	 Catch:{ NullPointerException -> 0x023a, Exception -> 0x0237, all -> 0x022e }
        r4 = r4.ax();	 Catch:{ NullPointerException -> 0x023a, Exception -> 0x0237, all -> 0x022e }
        r2 = r2 - r4;
        java.lang.Long.valueOf(r2);	 Catch:{ NullPointerException -> 0x023a, Exception -> 0x0237, all -> 0x022e }
        r11 = new org.json.JSONObject;	 Catch:{ NullPointerException -> 0x023a, Exception -> 0x0237, all -> 0x022e }
        r11.<init>();	 Catch:{ NullPointerException -> 0x023a, Exception -> 0x0237, all -> 0x022e }
        r2 = "act";
        r3 = "image_load";
        r11.put(r2, r3);	 Catch:{ NullPointerException -> 0x023a, Exception -> 0x0237, all -> 0x022e }
        r2 = "timestamp";
        r4 = java.lang.System.currentTimeMillis();	 Catch:{ NullPointerException -> 0x023a, Exception -> 0x0237, all -> 0x022e }
        r11.put(r2, r4);	 Catch:{ NullPointerException -> 0x023a, Exception -> 0x0237, all -> 0x022e }
        r2 = "type";
        r3 = "exc";
        r11.put(r2, r3);	 Catch:{ NullPointerException -> 0x023a, Exception -> 0x0237, all -> 0x022e }
        r12 = new org.json.JSONObject;	 Catch:{ NullPointerException -> 0x023a, Exception -> 0x0237, all -> 0x022e }
        r12.<init>();	 Catch:{ NullPointerException -> 0x023a, Exception -> 0x0237, all -> 0x022e }
        r2 = "exeption";
        r0 = r20;
        r12.put(r2, r0);	 Catch:{ NullPointerException -> 0x023a, Exception -> 0x0237, all -> 0x022e }
        r2 = "url";
        r0 = r21;
        r12.put(r2, r0);	 Catch:{ NullPointerException -> 0x023a, Exception -> 0x0237, all -> 0x022e }
        r2 = com.vlocker.b.o.noNetStatus;	 Catch:{ NullPointerException -> 0x023a, Exception -> 0x0237, all -> 0x022e }
        if (r10 != r2) goto L_0x00a8;
    L_0x00a6:
        monitor-exit(r8);
        return;
    L_0x00a8:
        r2 = r19.getPackageManager();	 Catch:{ UnsupportedEncodingException -> 0x0203, ClientProtocolException -> 0x021f, IOException -> 0x0228, Exception -> 0x0231, NullPointerException -> 0x0209, all -> 0x022e }
        r3 = 0;
        r4 = 0;
        r5 = r19.getPackageName();	 Catch:{ NameNotFoundException -> 0x020c }
        r13 = 0;
        r2 = r2.getPackageInfo(r5, r13);	 Catch:{ NameNotFoundException -> 0x020c }
        r3 = r2.versionCode;	 Catch:{ NameNotFoundException -> 0x020c }
        r2 = r2.versionName;	 Catch:{ NameNotFoundException -> 0x020c }
        r4 = r2;
        r5 = r3;
    L_0x00bd:
        r0 = r19;
        r0 = (android.app.Activity) r0;	 Catch:{ UnsupportedEncodingException -> 0x0203, ClientProtocolException -> 0x021f, IOException -> 0x0228, Exception -> 0x0231, NullPointerException -> 0x0209, all -> 0x022e }
        r2 = r0;
        r2 = r2.getWindowManager();	 Catch:{ UnsupportedEncodingException -> 0x0203, ClientProtocolException -> 0x021f, IOException -> 0x0228, Exception -> 0x0231, NullPointerException -> 0x0209, all -> 0x022e }
        r2 = r2.getDefaultDisplay();	 Catch:{ UnsupportedEncodingException -> 0x0203, ClientProtocolException -> 0x021f, IOException -> 0x0228, Exception -> 0x0231, NullPointerException -> 0x0209, all -> 0x022e }
        r13 = r2.getWidth();	 Catch:{ UnsupportedEncodingException -> 0x0203, ClientProtocolException -> 0x021f, IOException -> 0x0228, Exception -> 0x0231, NullPointerException -> 0x0209, all -> 0x022e }
        r14 = r2.getHeight();	 Catch:{ UnsupportedEncodingException -> 0x0203, ClientProtocolException -> 0x021f, IOException -> 0x0228, Exception -> 0x0231, NullPointerException -> 0x0209, all -> 0x022e }
        r2 = 0;
        r3 = r19.getResources();	 Catch:{ NullPointerException -> 0x0240, Exception -> 0x023d, UnsupportedEncodingException -> 0x0203, ClientProtocolException -> 0x021f, IOException -> 0x0228, all -> 0x022e }
        r3 = r3.getConfiguration();	 Catch:{ NullPointerException -> 0x0240, Exception -> 0x023d, UnsupportedEncodingException -> 0x0203, ClientProtocolException -> 0x021f, IOException -> 0x0228, all -> 0x022e }
        r3 = r3.locale;	 Catch:{ NullPointerException -> 0x0240, Exception -> 0x023d, UnsupportedEncodingException -> 0x0203, ClientProtocolException -> 0x021f, IOException -> 0x0228, all -> 0x022e }
        r2 = r3.toString();	 Catch:{ NullPointerException -> 0x0240, Exception -> 0x023d, UnsupportedEncodingException -> 0x0203, ClientProtocolException -> 0x021f, IOException -> 0x0228, all -> 0x022e }
    L_0x00e1:
        r3 = 2131296842; // 0x7f09024a float:1.8211612E38 double:1.0530005507E-314;
        r0 = r19;
        r3 = r0.getString(r3);	 Catch:{ NotFoundException -> 0x0213, Exception -> 0x0219, UnsupportedEncodingException -> 0x0203, ClientProtocolException -> 0x021f, IOException -> 0x0228, NullPointerException -> 0x0209, all -> 0x022e }
    L_0x00ea:
        r15 = new org.json.JSONObject;	 Catch:{ UnsupportedEncodingException -> 0x0203, ClientProtocolException -> 0x021f, IOException -> 0x0228, Exception -> 0x0231, NullPointerException -> 0x0209, all -> 0x022e }
        r15.<init>();	 Catch:{ UnsupportedEncodingException -> 0x0203, ClientProtocolException -> 0x021f, IOException -> 0x0228, Exception -> 0x0231, NullPointerException -> 0x0209, all -> 0x022e }
        r16 = "imei";
        r0 = r16;
        r15.put(r0, r7);	 Catch:{ UnsupportedEncodingException -> 0x0203, ClientProtocolException -> 0x021f, IOException -> 0x0228, Exception -> 0x0231, NullPointerException -> 0x0209, all -> 0x022e }
        r7 = "model";
        r16 = android.os.Build.MODEL;	 Catch:{ UnsupportedEncodingException -> 0x0203, ClientProtocolException -> 0x021f, IOException -> 0x0228, Exception -> 0x0231, NullPointerException -> 0x0209, all -> 0x022e }
        r0 = r16;
        r15.put(r7, r0);	 Catch:{ UnsupportedEncodingException -> 0x0203, ClientProtocolException -> 0x021f, IOException -> 0x0228, Exception -> 0x0231, NullPointerException -> 0x0209, all -> 0x022e }
        r7 = "manufacturer";
        r16 = android.os.Build.MANUFACTURER;	 Catch:{ UnsupportedEncodingException -> 0x0203, ClientProtocolException -> 0x021f, IOException -> 0x0228, Exception -> 0x0231, NullPointerException -> 0x0209, all -> 0x022e }
        r0 = r16;
        r15.put(r7, r0);	 Catch:{ UnsupportedEncodingException -> 0x0203, ClientProtocolException -> 0x021f, IOException -> 0x0228, Exception -> 0x0231, NullPointerException -> 0x0209, all -> 0x022e }
        r7 = "androidsdk";
        r16 = android.os.Build.VERSION.SDK_INT;	 Catch:{ UnsupportedEncodingException -> 0x0203, ClientProtocolException -> 0x021f, IOException -> 0x0228, Exception -> 0x0231, NullPointerException -> 0x0209, all -> 0x022e }
        r0 = r16;
        r15.put(r7, r0);	 Catch:{ UnsupportedEncodingException -> 0x0203, ClientProtocolException -> 0x021f, IOException -> 0x0228, Exception -> 0x0231, NullPointerException -> 0x0209, all -> 0x022e }
        r7 = "display";
        r16 = new java.lang.StringBuilder;	 Catch:{ UnsupportedEncodingException -> 0x0203, ClientProtocolException -> 0x021f, IOException -> 0x0228, Exception -> 0x0231, NullPointerException -> 0x0209, all -> 0x022e }
        r16.<init>();	 Catch:{ UnsupportedEncodingException -> 0x0203, ClientProtocolException -> 0x021f, IOException -> 0x0228, Exception -> 0x0231, NullPointerException -> 0x0209, all -> 0x022e }
        r0 = r16;
        r13 = r0.append(r13);	 Catch:{ UnsupportedEncodingException -> 0x0203, ClientProtocolException -> 0x021f, IOException -> 0x0228, Exception -> 0x0231, NullPointerException -> 0x0209, all -> 0x022e }
        r16 = "*";
        r0 = r16;
        r13 = r13.append(r0);	 Catch:{ UnsupportedEncodingException -> 0x0203, ClientProtocolException -> 0x021f, IOException -> 0x0228, Exception -> 0x0231, NullPointerException -> 0x0209, all -> 0x022e }
        r13 = r13.append(r14);	 Catch:{ UnsupportedEncodingException -> 0x0203, ClientProtocolException -> 0x021f, IOException -> 0x0228, Exception -> 0x0231, NullPointerException -> 0x0209, all -> 0x022e }
        r13 = r13.toString();	 Catch:{ UnsupportedEncodingException -> 0x0203, ClientProtocolException -> 0x021f, IOException -> 0x0228, Exception -> 0x0231, NullPointerException -> 0x0209, all -> 0x022e }
        r15.put(r7, r13);	 Catch:{ UnsupportedEncodingException -> 0x0203, ClientProtocolException -> 0x021f, IOException -> 0x0228, Exception -> 0x0231, NullPointerException -> 0x0209, all -> 0x022e }
        r7 = "locale";
        r15.put(r7, r2);	 Catch:{ UnsupportedEncodingException -> 0x0203, ClientProtocolException -> 0x021f, IOException -> 0x0228, Exception -> 0x0231, NullPointerException -> 0x0209, all -> 0x022e }
        r2 = "install";
        r7 = com.vlocker.c.a.a(r19);	 Catch:{ UnsupportedEncodingException -> 0x0203, ClientProtocolException -> 0x021f, IOException -> 0x0228, Exception -> 0x0231, NullPointerException -> 0x0209, all -> 0x022e }
        r16 = r7.ax();	 Catch:{ UnsupportedEncodingException -> 0x0203, ClientProtocolException -> 0x021f, IOException -> 0x0228, Exception -> 0x0231, NullPointerException -> 0x0209, all -> 0x022e }
        r0 = r16;
        r15.put(r2, r0);	 Catch:{ UnsupportedEncodingException -> 0x0203, ClientProtocolException -> 0x021f, IOException -> 0x0228, Exception -> 0x0231, NullPointerException -> 0x0209, all -> 0x022e }
        r2 = "child";
        r15.put(r2, r3);	 Catch:{ UnsupportedEncodingException -> 0x0203, ClientProtocolException -> 0x021f, IOException -> 0x0228, Exception -> 0x0231, NullPointerException -> 0x0209, all -> 0x022e }
        r2 = "timestamp";
        r16 = java.lang.System.currentTimeMillis();	 Catch:{ UnsupportedEncodingException -> 0x0203, ClientProtocolException -> 0x021f, IOException -> 0x0228, Exception -> 0x0231, NullPointerException -> 0x0209, all -> 0x022e }
        r0 = r16;
        r15.put(r2, r0);	 Catch:{ UnsupportedEncodingException -> 0x0203, ClientProtocolException -> 0x021f, IOException -> 0x0228, Exception -> 0x0231, NullPointerException -> 0x0209, all -> 0x022e }
        r2 = "net";
        r15.put(r2, r10);	 Catch:{ UnsupportedEncodingException -> 0x0203, ClientProtocolException -> 0x021f, IOException -> 0x0228, Exception -> 0x0231, NullPointerException -> 0x0209, all -> 0x022e }
        r2 = "mac";
        r15.put(r2, r6);	 Catch:{ UnsupportedEncodingException -> 0x0203, ClientProtocolException -> 0x021f, IOException -> 0x0228, Exception -> 0x0231, NullPointerException -> 0x0209, all -> 0x022e }
        r2 = "ipaddr";
        r3 = com.vlocker.b.j.f();	 Catch:{ UnsupportedEncodingException -> 0x0203, ClientProtocolException -> 0x021f, IOException -> 0x0228, Exception -> 0x0231, NullPointerException -> 0x0209, all -> 0x022e }
        r15.put(r2, r3);	 Catch:{ UnsupportedEncodingException -> 0x0203, ClientProtocolException -> 0x021f, IOException -> 0x0228, Exception -> 0x0231, NullPointerException -> 0x0209, all -> 0x022e }
        r2 = "ver";
        r15.put(r2, r4);	 Catch:{ UnsupportedEncodingException -> 0x0203, ClientProtocolException -> 0x021f, IOException -> 0x0228, Exception -> 0x0231, NullPointerException -> 0x0209, all -> 0x022e }
        r2 = "vcode";
        r15.put(r2, r5);	 Catch:{ UnsupportedEncodingException -> 0x0203, ClientProtocolException -> 0x021f, IOException -> 0x0228, Exception -> 0x0231, NullPointerException -> 0x0209, all -> 0x022e }
        r2 = "e";
        r11.put(r2, r12);	 Catch:{ UnsupportedEncodingException -> 0x0203, ClientProtocolException -> 0x021f, IOException -> 0x0228, Exception -> 0x0231, NullPointerException -> 0x0209, all -> 0x022e }
        r2 = new org.json.JSONArray;	 Catch:{ UnsupportedEncodingException -> 0x0203, ClientProtocolException -> 0x021f, IOException -> 0x0228, Exception -> 0x0231, NullPointerException -> 0x0209, all -> 0x022e }
        r2.<init>();	 Catch:{ UnsupportedEncodingException -> 0x0203, ClientProtocolException -> 0x021f, IOException -> 0x0228, Exception -> 0x0231, NullPointerException -> 0x0209, all -> 0x022e }
        r2.put(r11);	 Catch:{ UnsupportedEncodingException -> 0x0203, ClientProtocolException -> 0x021f, IOException -> 0x0228, Exception -> 0x0231, NullPointerException -> 0x0209, all -> 0x022e }
        r3 = new org.json.JSONObject;	 Catch:{ UnsupportedEncodingException -> 0x0203, ClientProtocolException -> 0x021f, IOException -> 0x0228, Exception -> 0x0231, NullPointerException -> 0x0209, all -> 0x022e }
        r3.<init>();	 Catch:{ UnsupportedEncodingException -> 0x0203, ClientProtocolException -> 0x021f, IOException -> 0x0228, Exception -> 0x0231, NullPointerException -> 0x0209, all -> 0x022e }
        r4 = "base";
        r3.put(r4, r15);	 Catch:{ UnsupportedEncodingException -> 0x0203, ClientProtocolException -> 0x021f, IOException -> 0x0228, Exception -> 0x0231, NullPointerException -> 0x0209, all -> 0x022e }
        r4 = "content";
        r3.put(r4, r2);	 Catch:{ UnsupportedEncodingException -> 0x0203, ClientProtocolException -> 0x021f, IOException -> 0x0228, Exception -> 0x0231, NullPointerException -> 0x0209, all -> 0x022e }
        r2 = java.lang.String.valueOf(r3);	 Catch:{ UnsupportedEncodingException -> 0x0203, ClientProtocolException -> 0x021f, IOException -> 0x0228, Exception -> 0x0231, NullPointerException -> 0x0209, all -> 0x022e }
        r0 = r18;
        r2 = com.vlocker.b.g.a(r2, r0);	 Catch:{ UnsupportedEncodingException -> 0x0203, ClientProtocolException -> 0x021f, IOException -> 0x0228, Exception -> 0x0231, NullPointerException -> 0x0209, all -> 0x022e }
        if (r2 == 0) goto L_0x01b0;
    L_0x01ac:
        r2 = com.vlocker.b.j.a(r2);	 Catch:{ UnsupportedEncodingException -> 0x0203, ClientProtocolException -> 0x021f, IOException -> 0x0228, Exception -> 0x0231, NullPointerException -> 0x0209, all -> 0x022e }
    L_0x01b0:
        r3 = r9.length;	 Catch:{ UnsupportedEncodingException -> 0x0203, ClientProtocolException -> 0x021f, IOException -> 0x0228, Exception -> 0x0231, NullPointerException -> 0x0209, all -> 0x022e }
        r4 = r2.length;	 Catch:{ UnsupportedEncodingException -> 0x0203, ClientProtocolException -> 0x021f, IOException -> 0x0228, Exception -> 0x0231, NullPointerException -> 0x0209, all -> 0x022e }
        r3 = a(r9, r3, r2, r4);	 Catch:{ UnsupportedEncodingException -> 0x0203, ClientProtocolException -> 0x021f, IOException -> 0x0228, Exception -> 0x0231, NullPointerException -> 0x0209, all -> 0x022e }
        r2 = new java.net.URL;	 Catch:{ UnsupportedEncodingException -> 0x0203, ClientProtocolException -> 0x021f, IOException -> 0x0228, Exception -> 0x0231, NullPointerException -> 0x0209, all -> 0x022e }
        r4 = "http://alc.imoxiu.com/collect/?app=556d0b43bb4d9b3c7a8b4567&key=557a53660183a2a37d66e390c3995424";
        r2.<init>(r4);	 Catch:{ UnsupportedEncodingException -> 0x0203, ClientProtocolException -> 0x021f, IOException -> 0x0228, Exception -> 0x0231, NullPointerException -> 0x0209, all -> 0x022e }
        r2 = r2.openConnection();	 Catch:{ UnsupportedEncodingException -> 0x0203, ClientProtocolException -> 0x021f, IOException -> 0x0228, Exception -> 0x0231, NullPointerException -> 0x0209, all -> 0x022e }
        r2 = (java.net.HttpURLConnection) r2;	 Catch:{ UnsupportedEncodingException -> 0x0203, ClientProtocolException -> 0x021f, IOException -> 0x0228, Exception -> 0x0231, NullPointerException -> 0x0209, all -> 0x022e }
        r4 = 5000; // 0x1388 float:7.006E-42 double:2.4703E-320;
        r2.setConnectTimeout(r4);	 Catch:{ UnsupportedEncodingException -> 0x0203, ClientProtocolException -> 0x021f, IOException -> 0x0228, Exception -> 0x0231, NullPointerException -> 0x0209, all -> 0x022e }
        r4 = "POST";
        r2.setRequestMethod(r4);	 Catch:{ UnsupportedEncodingException -> 0x0203, ClientProtocolException -> 0x021f, IOException -> 0x0228, Exception -> 0x0231, NullPointerException -> 0x0209, all -> 0x022e }
        r4 = "Content-Type";
        r5 = "application/x-www-form-urlencoded";
        r2.setRequestProperty(r4, r5);	 Catch:{ UnsupportedEncodingException -> 0x0203, ClientProtocolException -> 0x021f, IOException -> 0x0228, Exception -> 0x0231, NullPointerException -> 0x0209, all -> 0x022e }
        r4 = "Content-Length";
        r5 = new java.lang.StringBuilder;	 Catch:{ UnsupportedEncodingException -> 0x0203, ClientProtocolException -> 0x021f, IOException -> 0x0228, Exception -> 0x0231, NullPointerException -> 0x0209, all -> 0x022e }
        r5.<init>();	 Catch:{ UnsupportedEncodingException -> 0x0203, ClientProtocolException -> 0x021f, IOException -> 0x0228, Exception -> 0x0231, NullPointerException -> 0x0209, all -> 0x022e }
        r6 = r3.length;	 Catch:{ UnsupportedEncodingException -> 0x0203, ClientProtocolException -> 0x021f, IOException -> 0x0228, Exception -> 0x0231, NullPointerException -> 0x0209, all -> 0x022e }
        r5 = r5.append(r6);	 Catch:{ UnsupportedEncodingException -> 0x0203, ClientProtocolException -> 0x021f, IOException -> 0x0228, Exception -> 0x0231, NullPointerException -> 0x0209, all -> 0x022e }
        r6 = "";
        r5 = r5.append(r6);	 Catch:{ UnsupportedEncodingException -> 0x0203, ClientProtocolException -> 0x021f, IOException -> 0x0228, Exception -> 0x0231, NullPointerException -> 0x0209, all -> 0x022e }
        r5 = r5.toString();	 Catch:{ UnsupportedEncodingException -> 0x0203, ClientProtocolException -> 0x021f, IOException -> 0x0228, Exception -> 0x0231, NullPointerException -> 0x0209, all -> 0x022e }
        r2.setRequestProperty(r4, r5);	 Catch:{ UnsupportedEncodingException -> 0x0203, ClientProtocolException -> 0x021f, IOException -> 0x0228, Exception -> 0x0231, NullPointerException -> 0x0209, all -> 0x022e }
        r4 = 1;
        r2.setDoOutput(r4);	 Catch:{ UnsupportedEncodingException -> 0x0203, ClientProtocolException -> 0x021f, IOException -> 0x0228, Exception -> 0x0231, NullPointerException -> 0x0209, all -> 0x022e }
        r4 = r2.getOutputStream();	 Catch:{ UnsupportedEncodingException -> 0x0203, ClientProtocolException -> 0x021f, IOException -> 0x0228, Exception -> 0x0231, NullPointerException -> 0x0209, all -> 0x022e }
        r4.write(r3);	 Catch:{ UnsupportedEncodingException -> 0x0203, ClientProtocolException -> 0x021f, IOException -> 0x0228, Exception -> 0x0231, NullPointerException -> 0x0209, all -> 0x022e }
        r2.getResponseCode();	 Catch:{ UnsupportedEncodingException -> 0x0203, ClientProtocolException -> 0x021f, IOException -> 0x0228, Exception -> 0x0231, NullPointerException -> 0x0209, all -> 0x022e }
        goto L_0x00a6;
    L_0x0203:
        r2 = move-exception;
        r2.printStackTrace();	 Catch:{ NullPointerException -> 0x0209, Exception -> 0x0225, all -> 0x022e }
        goto L_0x00a6;
    L_0x0209:
        r2 = move-exception;
        goto L_0x00a6;
    L_0x020c:
        r2 = move-exception;
        r2.printStackTrace();	 Catch:{ UnsupportedEncodingException -> 0x0203, ClientProtocolException -> 0x021f, IOException -> 0x0228, Exception -> 0x0231, NullPointerException -> 0x0209, all -> 0x022e }
        r5 = r3;
        goto L_0x00bd;
    L_0x0213:
        r3 = move-exception;
        r3 = "new-moxiulauncher";
        goto L_0x00ea;
    L_0x0219:
        r3 = move-exception;
        r3 = "new-moxiulauncher";
        goto L_0x00ea;
    L_0x021f:
        r2 = move-exception;
        r2.printStackTrace();	 Catch:{ NullPointerException -> 0x0209, Exception -> 0x0225, all -> 0x022e }
        goto L_0x00a6;
    L_0x0225:
        r2 = move-exception;
        goto L_0x00a6;
    L_0x0228:
        r2 = move-exception;
        r2.printStackTrace();	 Catch:{ NullPointerException -> 0x0209, Exception -> 0x0225, all -> 0x022e }
        goto L_0x00a6;
    L_0x022e:
        r2 = move-exception;
        monitor-exit(r8);
        throw r2;
    L_0x0231:
        r2 = move-exception;
        r2.printStackTrace();	 Catch:{ NullPointerException -> 0x0209, Exception -> 0x0225, all -> 0x022e }
        goto L_0x00a6;
    L_0x0237:
        r2 = move-exception;
        goto L_0x00a6;
    L_0x023a:
        r2 = move-exception;
        goto L_0x00a6;
    L_0x023d:
        r3 = move-exception;
        goto L_0x00e1;
    L_0x0240:
        r3 = move-exception;
        goto L_0x00e1;
    L_0x0243:
        r6 = r2;
        goto L_0x0054;
    L_0x0246:
        r7 = r2;
        goto L_0x003d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vlocker.theme.imageloader.u.a(java.lang.String, android.content.Context, java.lang.String, java.lang.String):void");
    }

    public static boolean a(InputStream inputStream, OutputStream outputStream, String str) {
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream;
        IOException e;
        Object obj;
        Throwable th;
        HttpURLConnection httpURLConnection = null;
        try {
            bufferedInputStream = new BufferedInputStream(inputStream, 8192);
            try {
                bufferedOutputStream = new BufferedOutputStream(outputStream, 8192);
                while (true) {
                    try {
                        int read = bufferedInputStream.read();
                        if (read == -1) {
                            break;
                        }
                        bufferedOutputStream.write(read);
                    } catch (IOException e2) {
                        e = e2;
                    }
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                if (bufferedOutputStream != null) {
                    try {
                        bufferedOutputStream.close();
                    } catch (IOException e3) {
                        a(j.a(8), e.a, e3.toString(), str);
                        return true;
                    }
                }
                if (bufferedInputStream == null) {
                    return true;
                }
                bufferedInputStream.close();
                return true;
            } catch (IOException e4) {
                e = e4;
                obj = httpURLConnection;
                try {
                    a(j.a(8), e.a, e.toString(), str);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException e5) {
                            a(j.a(8), e.a, e5.toString(), str);
                            return false;
                        }
                    }
                    if (bufferedInputStream != null) {
                        bufferedInputStream.close();
                    }
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException e32) {
                            a(j.a(8), e.a, e32.toString(), str);
                            throw th;
                        }
                    }
                    if (bufferedInputStream != null) {
                        bufferedInputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                obj = httpURLConnection;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                throw th;
            }
        } catch (IOException e6) {
            e5 = e6;
            Object obj2 = httpURLConnection;
            obj = httpURLConnection;
            a(j.a(8), e.a, e5.toString(), str);
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            if (bufferedOutputStream != null) {
                bufferedOutputStream.close();
            }
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            return false;
        } catch (Throwable th4) {
            th = th4;
            bufferedInputStream = httpURLConnection;
            bufferedOutputStream = httpURLConnection;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            if (bufferedOutputStream != null) {
                bufferedOutputStream.close();
            }
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            throw th;
        }
    }

    public static boolean a(Object obj, ImageView imageView) {
        w b = b(imageView);
        if (b == null) {
            return true;
        }
        Object a = b.h;
        if (a != null && a.equals(obj)) {
            return false;
        }
        b.a(true);
        return true;
    }

    public static byte[] a(byte[] bArr, int i, byte[] bArr2, int i2) {
        int i3 = 0;
        byte[] bArr3 = new byte[(i + i2)];
        for (int i4 = 0; i4 < i; i4++) {
            bArr3[i4] = bArr[i4];
        }
        while (i3 < i2) {
            bArr3[i + i3] = bArr2[i3];
            i3++;
        }
        return bArr3;
    }

    private static w b(ImageView imageView) {
        if (imageView != null) {
            Drawable drawable = imageView.getDrawable();
            if (drawable instanceof v) {
                return ((v) drawable).a();
            }
        }
        return null;
    }

    private void j() {
        if (!this.h.exists()) {
            this.h.mkdirs();
        }
        if (r.a(this.h) > 10485760) {
            try {
                this.g = l.a(this.h, 1, 1, 10485760);
            } catch (IOException e) {
                this.g = null;
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.graphics.Bitmap a(java.lang.String r9, int r10, int r11, int r12) {
        /*
        r8 = this;
        r2 = 0;
        r0 = 8;
        r4 = com.vlocker.b.j.a(r0);
        r0 = new java.net.URL;	 Catch:{ MalformedURLException -> 0x00d9, ProtocolException -> 0x00f0, IOException -> 0x00fb, Exception -> 0x0106 }
        r0.<init>(r9);	 Catch:{ MalformedURLException -> 0x00d9, ProtocolException -> 0x00f0, IOException -> 0x00fb, Exception -> 0x0106 }
        r0 = r0.openConnection();	 Catch:{ MalformedURLException -> 0x00d9, ProtocolException -> 0x00f0, IOException -> 0x00fb, Exception -> 0x0106 }
        r0 = (java.net.HttpURLConnection) r0;	 Catch:{ MalformedURLException -> 0x00d9, ProtocolException -> 0x00f0, IOException -> 0x00fb, Exception -> 0x0106 }
        r1 = "GET";
        r0.setRequestMethod(r1);	 Catch:{ MalformedURLException -> 0x00d9, ProtocolException -> 0x00f0, IOException -> 0x00fb, Exception -> 0x0106 }
        r1 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        r0.setConnectTimeout(r1);	 Catch:{ MalformedURLException -> 0x00d9, ProtocolException -> 0x00f0, IOException -> 0x00fb, Exception -> 0x0106 }
        r1 = r0.getInputStream();	 Catch:{ MalformedURLException -> 0x00d9, ProtocolException -> 0x00f0, IOException -> 0x00fb, Exception -> 0x0106 }
        r3 = com.vlocker.theme.imageloader.r.b(r9);	 Catch:{ MalformedURLException -> 0x00d9, ProtocolException -> 0x00f0, IOException -> 0x00fb, Exception -> 0x0106 }
        r0 = r8.g;	 Catch:{ MalformedURLException -> 0x00d9, ProtocolException -> 0x00f0, IOException -> 0x00fb, Exception -> 0x0106 }
        if (r0 == 0) goto L_0x00e5;
    L_0x0029:
        r0 = r8.g;	 Catch:{ IOException -> 0x0079, IllegalStateException -> 0x00b7, all -> 0x00ce }
        r0 = r0.a(r3);	 Catch:{ IOException -> 0x0079, IllegalStateException -> 0x00b7, all -> 0x00ce }
        if (r0 != 0) goto L_0x004d;
    L_0x0031:
        r0 = r8.g;	 Catch:{ IOException -> 0x0079, IllegalStateException -> 0x00b7, all -> 0x00ce }
        r0 = r0.b(r3);	 Catch:{ IOException -> 0x0079, IllegalStateException -> 0x00b7, all -> 0x00ce }
        if (r0 == 0) goto L_0x0047;
    L_0x0039:
        r5 = 0;
        r5 = r0.a(r5);	 Catch:{ IOException -> 0x0079, IllegalStateException -> 0x00b7, all -> 0x00ce }
        r1 = a(r1, r5, r9);	 Catch:{ IOException -> 0x0079, IllegalStateException -> 0x00b7, all -> 0x00ce }
        if (r1 == 0) goto L_0x0075;
    L_0x0044:
        r0.a();	 Catch:{ IOException -> 0x0079, IllegalStateException -> 0x00b7, all -> 0x00ce }
    L_0x0047:
        r0 = r8.g;	 Catch:{ IOException -> 0x0079, IllegalStateException -> 0x00b7, all -> 0x00ce }
        r0 = r0.a(r3);	 Catch:{ IOException -> 0x0079, IllegalStateException -> 0x00b7, all -> 0x00ce }
    L_0x004d:
        if (r0 == 0) goto L_0x0144;
    L_0x004f:
        r1 = 0;
        r0 = r0.a(r1);	 Catch:{ IOException -> 0x0079, IllegalStateException -> 0x00b7, all -> 0x00ce }
        r0 = (java.io.FileInputStream) r0;	 Catch:{ IOException -> 0x0079, IllegalStateException -> 0x00b7, all -> 0x00ce }
        if (r0 == 0) goto L_0x00a4;
    L_0x0058:
        r3 = r0.getFD();	 Catch:{ IOException -> 0x0133, IllegalStateException -> 0x012a, all -> 0x0119 }
        r1 = r0.available();	 Catch:{ IOException -> 0x0138, IllegalStateException -> 0x012e, all -> 0x011f }
        r5 = 10;
        if (r1 >= r5) goto L_0x0141;
    L_0x0064:
        r1 = com.vlocker.theme.f.e.a;	 Catch:{ IOException -> 0x0138, IllegalStateException -> 0x012e, all -> 0x011f }
        r5 = "该图片不是图片或者图片过小";
        a(r4, r1, r5, r9);	 Catch:{ IOException -> 0x0138, IllegalStateException -> 0x012e, all -> 0x011f }
        if (r3 != 0) goto L_0x0073;
    L_0x006e:
        if (r0 == 0) goto L_0x0073;
    L_0x0070:
        r0.close();	 Catch:{ IOException -> 0x0111, MalformedURLException -> 0x00d9, ProtocolException -> 0x00f0, Exception -> 0x0106 }
    L_0x0073:
        r0 = r2;
    L_0x0074:
        return r0;
    L_0x0075:
        r0.b();	 Catch:{ IOException -> 0x0079, IllegalStateException -> 0x00b7, all -> 0x00ce }
        goto L_0x0047;
    L_0x0079:
        r0 = move-exception;
        r3 = r0;
        r1 = r2;
        r0 = r2;
    L_0x007d:
        r5 = com.vlocker.theme.f.e.a;	 Catch:{ all -> 0x0124 }
        r3 = r3.toString();	 Catch:{ all -> 0x0124 }
        a(r4, r5, r3, r9);	 Catch:{ all -> 0x0124 }
        if (r1 != 0) goto L_0x008d;
    L_0x0088:
        if (r0 == 0) goto L_0x008d;
    L_0x008a:
        r0.close();	 Catch:{ IOException -> 0x0114, MalformedURLException -> 0x00d9, ProtocolException -> 0x00f0, Exception -> 0x0106 }
    L_0x008d:
        r7 = r0;
        r0 = r1;
        r1 = r7;
    L_0x0090:
        if (r0 == 0) goto L_0x013e;
    L_0x0092:
        r3 = r8.i;	 Catch:{ MalformedURLException -> 0x00d9, ProtocolException -> 0x00f0, IOException -> 0x00fb, Exception -> 0x0106 }
        r5 = r8.j;	 Catch:{ MalformedURLException -> 0x00d9, ProtocolException -> 0x00f0, IOException -> 0x00fb, Exception -> 0x0106 }
        r6 = r8.a;	 Catch:{ MalformedURLException -> 0x00d9, ProtocolException -> 0x00f0, IOException -> 0x00fb, Exception -> 0x0106 }
        r0 = com.vlocker.theme.imageloader.r.a(r0, r3, r5, r6, r12);	 Catch:{ MalformedURLException -> 0x00d9, ProtocolException -> 0x00f0, IOException -> 0x00fb, Exception -> 0x0106 }
    L_0x009c:
        if (r1 == 0) goto L_0x0074;
    L_0x009e:
        r1.close();	 Catch:{ IOException -> 0x00a2, MalformedURLException -> 0x00d9, ProtocolException -> 0x00f0, Exception -> 0x0106 }
        goto L_0x0074;
    L_0x00a2:
        r1 = move-exception;
        goto L_0x0074;
    L_0x00a4:
        r1 = r8.b;	 Catch:{ IOException -> 0x0133, IllegalStateException -> 0x012a, all -> 0x0119 }
        r3 = "该图片不是图片或者图片过小";
        a(r4, r1, r3, r9);	 Catch:{ IOException -> 0x0133, IllegalStateException -> 0x012a, all -> 0x0119 }
        r1 = r2;
    L_0x00ad:
        if (r1 != 0) goto L_0x008d;
    L_0x00af:
        if (r0 == 0) goto L_0x008d;
    L_0x00b1:
        r0.close();	 Catch:{ IOException -> 0x00b5, MalformedURLException -> 0x00d9, ProtocolException -> 0x00f0, Exception -> 0x0106 }
        goto L_0x008d;
    L_0x00b5:
        r3 = move-exception;
        goto L_0x008d;
    L_0x00b7:
        r0 = move-exception;
        r3 = r0;
        r1 = r2;
        r0 = r2;
    L_0x00bb:
        r5 = com.vlocker.theme.f.e.a;	 Catch:{ all -> 0x0124 }
        r3 = r3.toString();	 Catch:{ all -> 0x0124 }
        a(r4, r5, r3, r9);	 Catch:{ all -> 0x0124 }
        if (r1 != 0) goto L_0x008d;
    L_0x00c6:
        if (r0 == 0) goto L_0x008d;
    L_0x00c8:
        r0.close();	 Catch:{ IOException -> 0x00cc, MalformedURLException -> 0x00d9, ProtocolException -> 0x00f0, Exception -> 0x0106 }
        goto L_0x008d;
    L_0x00cc:
        r3 = move-exception;
        goto L_0x008d;
    L_0x00ce:
        r0 = move-exception;
        r1 = r2;
        r3 = r2;
    L_0x00d1:
        if (r3 != 0) goto L_0x00d8;
    L_0x00d3:
        if (r1 == 0) goto L_0x00d8;
    L_0x00d5:
        r1.close();	 Catch:{ IOException -> 0x0117, MalformedURLException -> 0x00d9, ProtocolException -> 0x00f0, Exception -> 0x0106 }
    L_0x00d8:
        throw r0;	 Catch:{ MalformedURLException -> 0x00d9, ProtocolException -> 0x00f0, IOException -> 0x00fb, Exception -> 0x0106 }
    L_0x00d9:
        r0 = move-exception;
        r1 = com.vlocker.theme.f.e.a;
        r0 = r0.toString();
        a(r4, r1, r0, r9);
    L_0x00e3:
        r0 = r2;
        goto L_0x0074;
    L_0x00e5:
        r0 = com.vlocker.theme.f.e.a;	 Catch:{ MalformedURLException -> 0x00d9, ProtocolException -> 0x00f0, IOException -> 0x00fb, Exception -> 0x0106 }
        r1 = "内存不足";
        a(r4, r0, r1, r9);	 Catch:{ MalformedURLException -> 0x00d9, ProtocolException -> 0x00f0, IOException -> 0x00fb, Exception -> 0x0106 }
        r1 = r2;
        r0 = r2;
        goto L_0x0090;
    L_0x00f0:
        r0 = move-exception;
        r1 = com.vlocker.theme.f.e.a;
        r0 = r0.toString();
        a(r4, r1, r0, r9);
        goto L_0x00e3;
    L_0x00fb:
        r0 = move-exception;
        r1 = com.vlocker.theme.f.e.a;
        r0 = r0.toString();
        a(r4, r1, r0, r9);
        goto L_0x00e3;
    L_0x0106:
        r0 = move-exception;
        r1 = com.vlocker.theme.f.e.a;
        r0 = r0.toString();
        a(r4, r1, r0, r9);
        goto L_0x00e3;
    L_0x0111:
        r0 = move-exception;
        goto L_0x0073;
    L_0x0114:
        r3 = move-exception;
        goto L_0x008d;
    L_0x0117:
        r1 = move-exception;
        goto L_0x00d8;
    L_0x0119:
        r1 = move-exception;
        r3 = r2;
        r7 = r0;
        r0 = r1;
        r1 = r7;
        goto L_0x00d1;
    L_0x011f:
        r1 = move-exception;
        r7 = r1;
        r1 = r0;
        r0 = r7;
        goto L_0x00d1;
    L_0x0124:
        r3 = move-exception;
        r7 = r3;
        r3 = r1;
        r1 = r0;
        r0 = r7;
        goto L_0x00d1;
    L_0x012a:
        r1 = move-exception;
        r3 = r1;
        r1 = r2;
        goto L_0x00bb;
    L_0x012e:
        r1 = move-exception;
        r7 = r1;
        r1 = r3;
        r3 = r7;
        goto L_0x00bb;
    L_0x0133:
        r1 = move-exception;
        r3 = r1;
        r1 = r2;
        goto L_0x007d;
    L_0x0138:
        r1 = move-exception;
        r7 = r1;
        r1 = r3;
        r3 = r7;
        goto L_0x007d;
    L_0x013e:
        r0 = r2;
        goto L_0x009c;
    L_0x0141:
        r1 = r3;
        goto L_0x00ad;
    L_0x0144:
        r0 = r2;
        r1 = r2;
        goto L_0x00ad;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vlocker.theme.imageloader.u.a(java.lang.String, int, int, int):android.graphics.Bitmap");
    }

    public l a() {
        return this.g;
    }

    public void a(t tVar) {
        this.a = new r(tVar);
        new x(this).c(Integer.valueOf(1));
        this.a.a();
    }

    public void a(Object obj, RecyclingImageView recyclingImageView, int i, boolean z) {
        Drawable drawable = null;
        if (obj != null) {
            if (this.a != null && z) {
                drawable = (i == 0 || i == 1 || i == 4 || i == 7 || i == 13 || i > 10000) ? this.a.a(String.valueOf(obj)) : this.a.a(String.valueOf(obj) + i);
            }
            if (drawable != null) {
                recyclingImageView.setImageDrawable(drawable);
            } else if (a(obj, recyclingImageView)) {
                w wVar = new w(this, obj, recyclingImageView, recyclingImageView.getWidth(), recyclingImageView.getHeight(), i, recyclingImageView.getScaleType());
                if (this.l == 0) {
                    this.l = R.drawable.t_market_theme_detail_imageloading;
                }
                try {
                    recyclingImageView.setImageDrawable(new v(this.f, null, wVar, this.l));
                } catch (OutOfMemoryError e) {
                    e.printStackTrace();
                }
                wVar.a(this.n, (Object[]) new Void[0]);
            }
        }
    }

    public void a(boolean z) {
        synchronized (this.d) {
            this.e = z;
            if (!this.e) {
                this.d.notifyAll();
            }
        }
    }

    public boolean b() {
        return this.c;
    }

    public boolean c() {
        return this.e;
    }

    protected void d() {
        if (this.a != null) {
            this.a.a();
        }
    }

    protected void e() {
        if (this.a != null) {
            this.a.b();
        }
    }

    protected void f() {
        if (this.a != null) {
            this.a.c();
        }
    }

    protected void g() {
        if (this.a != null) {
            this.a.d();
            this.a = null;
        }
    }

    public void h() {
        new x(this).c(Integer.valueOf(0));
    }

    public void i() {
        new x(this).c(Integer.valueOf(3));
    }
}
