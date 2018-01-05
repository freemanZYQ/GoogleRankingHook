package com.vlocker.b;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.sqlite.SQLiteDiskIOException;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.Process;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.b.d.c;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage.IMediaObject;
import com.vlocker.c.a;
import com.vlocker.locker.R;
import com.vlocker.m.aj;
import com.vlocker.m.h;
import com.vlocker.m.o;
import com.vlocker.m.q;
import com.vlocker.search.ap;
import com.vlocker.security.MoSecurityApplication;
import com.vlocker.theme.f.e;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.Vector;
import java.util.zip.DeflaterOutputStream;
import org.apache.http.conn.util.InetAddressUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class j {
    public static String a = null;
    public static String b = null;
    public static final String c = null;
    public static final FileFilter d = new k();
    public static final int[][] e;
    public static final int f = VERSION.SDK_INT;
    private static String g = null;
    private static String h = null;
    private static String i = null;
    private static int j = 0;
    private static int k = 0;
    private static int l = 0;

    static {
        r0 = new int[10][];
        r0[0] = new int[]{Color.parseColor("#ffffff"), Color.parseColor("#ffffff"), Color.parseColor("#ffffff"), Color.parseColor("#ffffff"), Color.parseColor("#ffffff"), Color.parseColor("#ffffff"), Color.parseColor("#ffffff"), Color.parseColor("#ffffff"), Color.parseColor("#ffffff")};
        r0[1] = new int[]{Color.parseColor("#b3e3e7"), Color.parseColor("#d7ea8d"), Color.parseColor("#c9dbf0"), Color.parseColor("#f6b6ca"), Color.parseColor("#f8e192"), Color.parseColor("#ffc6b4"), Color.parseColor("#ebd1c2"), Color.parseColor("#dcd4f9"), Color.parseColor("#cbeed0")};
        r0[2] = new int[]{Color.parseColor("#d1b5e5"), Color.parseColor("#cdc5ed"), Color.parseColor("#f8d7ec"), Color.parseColor("#e4dde5"), Color.parseColor("#f8f7ee"), Color.parseColor("#d2bdde"), Color.parseColor("#d2dce8"), Color.parseColor("#a49edc"), Color.parseColor("#f2e4d9")};
        r0[3] = new int[]{Color.parseColor("#5cb3ea"), Color.parseColor("#52baf3"), Color.parseColor("#b7e2ef"), Color.parseColor("#bbe4fd"), Color.parseColor("#efe7de"), Color.parseColor("#f8e1c2"), Color.parseColor("#e5efd7"), Color.parseColor("#9adee1"), Color.parseColor("#67c4c9")};
        r0[4] = new int[]{Color.parseColor("#453f3f"), Color.parseColor("#9f948d"), Color.parseColor("#8c6d5e"), Color.parseColor("#7a706e"), Color.parseColor("#dad0cc"), Color.parseColor("#c6b1a8"), Color.parseColor("#a69693"), Color.parseColor("#869697"), Color.parseColor("#9a998d")};
        r0[5] = new int[]{Color.parseColor("#f4c1be"), Color.parseColor("#f08595"), Color.parseColor("#dc6878"), Color.parseColor("#f7a2b7"), Color.parseColor("#f0a4a8"), Color.parseColor("#ea8a8e"), Color.parseColor("#f8d3cb"), Color.parseColor("#f6ead6"), Color.parseColor("#eec6bc")};
        r0[6] = new int[]{Color.parseColor("#fff6c8"), Color.parseColor("#52726e"), Color.parseColor("#41a498"), Color.parseColor("#d57a70"), Color.parseColor("#719002"), Color.parseColor("#d2a416"), Color.parseColor("#829459"), Color.parseColor("#85b2b0"), Color.parseColor("#1e4f1d")};
        r0[7] = new int[]{Color.parseColor("#e7c88f"), Color.parseColor("#c3ba8f"), Color.parseColor("#c8c1af"), Color.parseColor("#cba581"), Color.parseColor("#50746a"), Color.parseColor("#91c2af"), Color.parseColor("#858b86"), Color.parseColor("#c8c1af"), Color.parseColor("#d7c188")};
        r0[8] = new int[]{Color.parseColor("#a4b39c"), Color.parseColor("#c7a5ab"), Color.parseColor("#e2f6f7"), Color.parseColor("#8e7094"), Color.parseColor("#7eadb9"), Color.parseColor("#608568"), Color.parseColor("#99d2c7"), Color.parseColor("#e6e7dc"), Color.parseColor("#6baea0")};
        r0[9] = new int[]{Color.parseColor("#e396c2"), Color.parseColor("#e9ddb3"), Color.parseColor("#b13865"), Color.parseColor("#ce5054"), Color.parseColor("#f9afa9"), Color.parseColor("#f5e2db"), Color.parseColor("#bb757f"), Color.parseColor("#ca4e84"), Color.parseColor("#ffc3e9")};
        e = r0;
    }

    public static View a(View view, int i) {
        return view.findViewById(i);
    }

    public static String a() {
        return "http://soft.moxiu.net/json.php?do=Last&packagename=com.moxiu.launcher&target_channel=w-suoping";
    }

    public static String a(int i) {
        String str = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < i; i2++) {
            stringBuffer.append(str.charAt(random.nextInt(str.length())));
        }
        return stringBuffer.toString();
    }

    public static String a(Context context) {
        return a(context, "com.moxiu.launcher") ? "yes" : "no";
    }

    public static String a(Context context, int i) {
        int i2;
        String string;
        int i3;
        NameNotFoundException e;
        String b = b();
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        String str = "default";
        try {
            i2 = packageManager.getPackageInfo(context.getApplicationContext().getPackageName(), 0).versionCode;
            try {
                Bundle bundle = packageManager.getApplicationInfo(context.getPackageName(), 128).metaData;
                string = context.getString(R.string.t_market_theme_manager_child);
                try {
                    i3 = VERSION.SDK_INT;
                    try {
                        if (((TelephonyManager) context.getSystemService("phone")).getDeviceId() == null) {
                            int pow = (int) Math.pow(10.0d, 14.0d);
                            (pow + new Random().nextInt(pow)) + "";
                        }
                    } catch (NameNotFoundException e2) {
                        e = e2;
                        e.printStackTrace();
                    } catch (Exception e3) {
                    }
                } catch (NameNotFoundException e4) {
                    e = e4;
                    i3 = 0;
                    e.printStackTrace();
                } catch (Exception e5) {
                    i3 = 0;
                }
            } catch (NameNotFoundException e6) {
                e = e6;
                string = str;
                i3 = 0;
                e.printStackTrace();
            } catch (Exception e7) {
                string = str;
                i3 = 0;
            }
        } catch (NameNotFoundException e8) {
            e = e8;
            i2 = 0;
            string = str;
            i3 = 0;
            e.printStackTrace();
        } catch (Exception e9) {
            i2 = 0;
            string = str;
            i3 = 0;
        }
        return b + "&version_code=" + i2 + "&channel=" + string + "&auto_update=" + (i == 1) + "&packagename=" + context.getPackageName() + "&sys_ver_code=" + i3;
    }

    public static String a(String str) {
        while (str.startsWith(" ")) {
            str = str.substring(1, str.length()).trim();
        }
        while (str.endsWith(" ")) {
            str = str.substring(0, str.length() - 1).trim();
        }
        return str;
    }

    public static String a(String str, Map map, q[] qVarArr) {
        try {
            String str2 = "\r\n";
            String str3 = "--";
            String str4 = "---------7d4a6d158c9";
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setReadTimeout(20000);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("connection", "Keep-Alive");
            httpURLConnection.setRequestProperty("Charsert", "UTF-8");
            httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data" + "; boundary=" + str4);
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            for (String str5 : map.keySet()) {
                try {
                    String str6 = (String) map.get(str5);
                    dataOutputStream.writeBytes(str3 + str4 + str2);
                    dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"" + str5 + "\"" + str2);
                    dataOutputStream.writeBytes(str2);
                    dataOutputStream.write(str6.getBytes("UTF-8"));
                    dataOutputStream.writeBytes(str2);
                } catch (Exception e) {
                }
            }
            if (qVarArr != null) {
                for (q qVar : qVarArr) {
                    if (qVar != null) {
                        dataOutputStream.writeBytes(str3 + str4 + str2);
                        dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"" + qVar.b() + "\"" + "; filename=\"" + qVar.c() + "\"" + str2);
                        dataOutputStream.writeBytes("Content-Type: application/octet-stream");
                        dataOutputStream.writeBytes(str2);
                        dataOutputStream.writeBytes(str2);
                        dataOutputStream.write(qVar.d());
                        dataOutputStream.writeBytes(str2);
                    }
                }
            }
            dataOutputStream.writeBytes(str3 + str4 + str3 + str2);
            dataOutputStream.flush();
            InputStream inputStream = httpURLConnection.getInputStream();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[IXAdIOUtils.BUFFER_SIZE];
            while (true) {
                int read = inputStream.read(bArr, 0, IXAdIOUtils.BUFFER_SIZE);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    dataOutputStream.close();
                    inputStream.close();
                    return byteArrayOutputStream.toString();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static JSONArray a(File file) {
        JSONArray jSONArray = new JSONArray();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String str = "";
            while (true) {
                str = bufferedReader.readLine();
                if (str == null) {
                    break;
                } else if (!(str == null || str.equals(""))) {
                    jSONArray.put(new JSONObject(str));
                }
            }
            bufferedReader.close();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return jSONArray;
    }

    public static void a(Activity activity) {
        if (VERSION.SDK_INT >= 21 && !Build.BRAND.toLowerCase().contains("huawei")) {
            try {
                Window window = activity.getWindow();
                LayoutParams attributes = window.getAttributes();
                attributes.systemUiVisibility |= 1792;
                window.clearFlags(201326592);
                window.addFlags(LayoutParams.class.getField("FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS").getInt(null));
                Method declaredMethod = Window.class.getDeclaredMethod("setStatusBarColor", new Class[]{Integer.TYPE});
                Method declaredMethod2 = Window.class.getDeclaredMethod("setNavigationBarColor", new Class[]{Integer.TYPE});
                declaredMethod.invoke(window, new Object[]{Integer.valueOf(0)});
                declaredMethod2.invoke(window, new Object[]{Integer.valueOf(0)});
            } catch (NoSuchFieldException e) {
            } catch (NoSuchMethodException e2) {
            } catch (IllegalAccessException e3) {
            } catch (IllegalArgumentException e4) {
            } catch (InvocationTargetException e5) {
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void a(android.content.Context r12, java.lang.String r13, java.lang.String r14) {
        /*
        r1 = 0;
        r10 = 1;
        r2 = 0;
        r4 = com.vlocker.b.j.class;
        monitor-enter(r4);
        r5 = com.vlocker.b.h.a(r13, r12);	 Catch:{ NullPointerException -> 0x0218, Exception -> 0x0215, all -> 0x020c }
        r6 = b(r12);	 Catch:{ NullPointerException -> 0x0218, Exception -> 0x0215, all -> 0x020c }
        r0 = g;	 Catch:{ NullPointerException -> 0x0218, Exception -> 0x0215, all -> 0x020c }
        if (r0 != 0) goto L_0x0021;
    L_0x0012:
        r0 = "phone";
        r0 = r12.getSystemService(r0);	 Catch:{ NullPointerException -> 0x0218, Exception -> 0x0215, all -> 0x020c }
        r0 = (android.telephony.TelephonyManager) r0;	 Catch:{ NullPointerException -> 0x0218, Exception -> 0x0215, all -> 0x020c }
        r0 = r0.getDeviceId();	 Catch:{ NullPointerException -> 0x0218, Exception -> 0x0215, all -> 0x020c }
        g = r0;	 Catch:{ NullPointerException -> 0x0218, Exception -> 0x0215, all -> 0x020c }
    L_0x0021:
        r0 = i;	 Catch:{ NullPointerException -> 0x0218, Exception -> 0x0215, all -> 0x020c }
        if (r0 != 0) goto L_0x0046;
    L_0x0025:
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x021b, NullPointerException -> 0x0218, all -> 0x020c }
        r0.<init>();	 Catch:{ Exception -> 0x021b, NullPointerException -> 0x0218, all -> 0x020c }
        r3 = "";
        r0 = r0.append(r3);	 Catch:{ Exception -> 0x021b, NullPointerException -> 0x0218, all -> 0x020c }
        r3 = r12.getContentResolver();	 Catch:{ Exception -> 0x021b, NullPointerException -> 0x0218, all -> 0x020c }
        r7 = "android_id";
        r3 = android.provider.Settings.Secure.getString(r3, r7);	 Catch:{ Exception -> 0x021b, NullPointerException -> 0x0218, all -> 0x020c }
        r0 = r0.append(r3);	 Catch:{ Exception -> 0x021b, NullPointerException -> 0x0218, all -> 0x020c }
        r0 = r0.toString();	 Catch:{ Exception -> 0x021b, NullPointerException -> 0x0218, all -> 0x020c }
        i = r0;	 Catch:{ Exception -> 0x021b, NullPointerException -> 0x0218, all -> 0x020c }
    L_0x0046:
        r0 = h;	 Catch:{ NullPointerException -> 0x0218, Exception -> 0x0215, all -> 0x020c }
        if (r0 != 0) goto L_0x005d;
    L_0x004a:
        r0 = "wifi";
        r0 = r12.getSystemService(r0);	 Catch:{ NullPointerException -> 0x0218, Exception -> 0x0215, all -> 0x020c }
        r0 = (android.net.wifi.WifiManager) r0;	 Catch:{ NullPointerException -> 0x0218, Exception -> 0x0215, all -> 0x020c }
        r0 = r0.getConnectionInfo();	 Catch:{ NullPointerException -> 0x0218, Exception -> 0x0215, all -> 0x020c }
        r0 = r0.getMacAddress();	 Catch:{ NullPointerException -> 0x0218, Exception -> 0x0215, all -> 0x020c }
        h = r0;	 Catch:{ NullPointerException -> 0x0218, Exception -> 0x0215, all -> 0x020c }
    L_0x005d:
        r7 = new org.json.JSONObject;	 Catch:{ NullPointerException -> 0x0218, Exception -> 0x0215, all -> 0x020c }
        r7.<init>();	 Catch:{ NullPointerException -> 0x0218, Exception -> 0x0215, all -> 0x020c }
        r0 = "act";
        r7.put(r0, r14);	 Catch:{ NullPointerException -> 0x0218, Exception -> 0x0215, all -> 0x020c }
        r0 = "timestamp";
        r8 = java.lang.System.currentTimeMillis();	 Catch:{ NullPointerException -> 0x0218, Exception -> 0x0215, all -> 0x020c }
        r7.put(r0, r8);	 Catch:{ NullPointerException -> 0x0218, Exception -> 0x0215, all -> 0x020c }
        r0 = "type";
        r3 = "base";
        r7.put(r0, r3);	 Catch:{ NullPointerException -> 0x0218, Exception -> 0x0215, all -> 0x020c }
        r0 = com.vlocker.b.o.noNetStatus;	 Catch:{ NullPointerException -> 0x0218, Exception -> 0x0215, all -> 0x020c }
        if (r6 != r0) goto L_0x008c;
    L_0x007f:
        r0 = r7.toString();	 Catch:{ NullPointerException -> 0x0218, Exception -> 0x0215, all -> 0x020c }
        r0 = r0.getBytes();	 Catch:{ NullPointerException -> 0x0218, Exception -> 0x0215, all -> 0x020c }
        com.vlocker.b.w.a(r0);	 Catch:{ NullPointerException -> 0x0218, Exception -> 0x0215, all -> 0x020c }
    L_0x008a:
        monitor-exit(r4);
        return;
    L_0x008c:
        r0 = r12.getPackageManager();	 Catch:{ UnsupportedEncodingException -> 0x01d8, ClientProtocolException -> 0x01fd, IOException -> 0x0206, Exception -> 0x020f, NullPointerException -> 0x01de, all -> 0x020c }
        r3 = r12.getPackageName();	 Catch:{ NameNotFoundException -> 0x01e1 }
        r8 = 0;
        r0 = r0.getPackageInfo(r3, r8);	 Catch:{ NameNotFoundException -> 0x01e1 }
        r2 = r0.versionCode;	 Catch:{ NameNotFoundException -> 0x01e1 }
        r0 = r0.versionName;	 Catch:{ NameNotFoundException -> 0x01e1 }
        r3 = r2;
        r2 = r0;
    L_0x009f:
        r0 = j;	 Catch:{ UnsupportedEncodingException -> 0x01d8, ClientProtocolException -> 0x01fd, IOException -> 0x0206, Exception -> 0x020f, NullPointerException -> 0x01de, all -> 0x020c }
        if (r0 >= r10) goto L_0x00b8;
    L_0x00a3:
        r0 = new android.util.DisplayMetrics;	 Catch:{ UnsupportedEncodingException -> 0x01d8, ClientProtocolException -> 0x01fd, IOException -> 0x0206, Exception -> 0x020f, NullPointerException -> 0x01de, all -> 0x020c }
        r0.<init>();	 Catch:{ UnsupportedEncodingException -> 0x01d8, ClientProtocolException -> 0x01fd, IOException -> 0x0206, Exception -> 0x020f, NullPointerException -> 0x01de, all -> 0x020c }
        r0 = r12.getResources();	 Catch:{ UnsupportedEncodingException -> 0x01d8, ClientProtocolException -> 0x01fd, IOException -> 0x0206, Exception -> 0x020f, NullPointerException -> 0x01de, all -> 0x020c }
        r0 = r0.getDisplayMetrics();	 Catch:{ UnsupportedEncodingException -> 0x01d8, ClientProtocolException -> 0x01fd, IOException -> 0x0206, Exception -> 0x020f, NullPointerException -> 0x01de, all -> 0x020c }
        r8 = r0.widthPixels;	 Catch:{ UnsupportedEncodingException -> 0x01d8, ClientProtocolException -> 0x01fd, IOException -> 0x0206, Exception -> 0x020f, NullPointerException -> 0x01de, all -> 0x020c }
        j = r8;	 Catch:{ UnsupportedEncodingException -> 0x01d8, ClientProtocolException -> 0x01fd, IOException -> 0x0206, Exception -> 0x020f, NullPointerException -> 0x01de, all -> 0x020c }
        r0 = r0.heightPixels;	 Catch:{ UnsupportedEncodingException -> 0x01d8, ClientProtocolException -> 0x01fd, IOException -> 0x0206, Exception -> 0x020f, NullPointerException -> 0x01de, all -> 0x020c }
        k = r0;	 Catch:{ UnsupportedEncodingException -> 0x01d8, ClientProtocolException -> 0x01fd, IOException -> 0x0206, Exception -> 0x020f, NullPointerException -> 0x01de, all -> 0x020c }
    L_0x00b8:
        r0 = r12.getResources();	 Catch:{ NullPointerException -> 0x01e9, Exception -> 0x01ed, UnsupportedEncodingException -> 0x01d8, ClientProtocolException -> 0x01fd, IOException -> 0x0206, all -> 0x020c }
        r0 = r0.getConfiguration();	 Catch:{ NullPointerException -> 0x01e9, Exception -> 0x01ed, UnsupportedEncodingException -> 0x01d8, ClientProtocolException -> 0x01fd, IOException -> 0x0206, all -> 0x020c }
        r0 = r0.locale;	 Catch:{ NullPointerException -> 0x01e9, Exception -> 0x01ed, UnsupportedEncodingException -> 0x01d8, ClientProtocolException -> 0x01fd, IOException -> 0x0206, all -> 0x020c }
        r0 = r0.toString();	 Catch:{ NullPointerException -> 0x01e9, Exception -> 0x01ed, UnsupportedEncodingException -> 0x01d8, ClientProtocolException -> 0x01fd, IOException -> 0x0206, all -> 0x020c }
    L_0x00c6:
        r1 = 2131296842; // 0x7f09024a float:1.8211612E38 double:1.0530005507E-314;
        r1 = r12.getString(r1);	 Catch:{ NotFoundException -> 0x01f1, Exception -> 0x01f7, UnsupportedEncodingException -> 0x01d8, ClientProtocolException -> 0x01fd, IOException -> 0x0206, NullPointerException -> 0x01de, all -> 0x020c }
    L_0x00cd:
        r8 = new org.json.JSONObject;	 Catch:{ UnsupportedEncodingException -> 0x01d8, ClientProtocolException -> 0x01fd, IOException -> 0x0206, Exception -> 0x020f, NullPointerException -> 0x01de, all -> 0x020c }
        r8.<init>();	 Catch:{ UnsupportedEncodingException -> 0x01d8, ClientProtocolException -> 0x01fd, IOException -> 0x0206, Exception -> 0x020f, NullPointerException -> 0x01de, all -> 0x020c }
        r9 = "imei";
        r10 = g;	 Catch:{ UnsupportedEncodingException -> 0x01d8, ClientProtocolException -> 0x01fd, IOException -> 0x0206, Exception -> 0x020f, NullPointerException -> 0x01de, all -> 0x020c }
        r8.put(r9, r10);	 Catch:{ UnsupportedEncodingException -> 0x01d8, ClientProtocolException -> 0x01fd, IOException -> 0x0206, Exception -> 0x020f, NullPointerException -> 0x01de, all -> 0x020c }
        r9 = "model";
        r10 = android.os.Build.MODEL;	 Catch:{ UnsupportedEncodingException -> 0x01d8, ClientProtocolException -> 0x01fd, IOException -> 0x0206, Exception -> 0x020f, NullPointerException -> 0x01de, all -> 0x020c }
        r8.put(r9, r10);	 Catch:{ UnsupportedEncodingException -> 0x01d8, ClientProtocolException -> 0x01fd, IOException -> 0x0206, Exception -> 0x020f, NullPointerException -> 0x01de, all -> 0x020c }
        r9 = "manufacturer";
        r10 = android.os.Build.MANUFACTURER;	 Catch:{ UnsupportedEncodingException -> 0x01d8, ClientProtocolException -> 0x01fd, IOException -> 0x0206, Exception -> 0x020f, NullPointerException -> 0x01de, all -> 0x020c }
        r8.put(r9, r10);	 Catch:{ UnsupportedEncodingException -> 0x01d8, ClientProtocolException -> 0x01fd, IOException -> 0x0206, Exception -> 0x020f, NullPointerException -> 0x01de, all -> 0x020c }
        r9 = "androidsdk";
        r10 = android.os.Build.VERSION.SDK_INT;	 Catch:{ UnsupportedEncodingException -> 0x01d8, ClientProtocolException -> 0x01fd, IOException -> 0x0206, Exception -> 0x020f, NullPointerException -> 0x01de, all -> 0x020c }
        r8.put(r9, r10);	 Catch:{ UnsupportedEncodingException -> 0x01d8, ClientProtocolException -> 0x01fd, IOException -> 0x0206, Exception -> 0x020f, NullPointerException -> 0x01de, all -> 0x020c }
        r9 = "display";
        r10 = new java.lang.StringBuilder;	 Catch:{ UnsupportedEncodingException -> 0x01d8, ClientProtocolException -> 0x01fd, IOException -> 0x0206, Exception -> 0x020f, NullPointerException -> 0x01de, all -> 0x020c }
        r10.<init>();	 Catch:{ UnsupportedEncodingException -> 0x01d8, ClientProtocolException -> 0x01fd, IOException -> 0x0206, Exception -> 0x020f, NullPointerException -> 0x01de, all -> 0x020c }
        r11 = j;	 Catch:{ UnsupportedEncodingException -> 0x01d8, ClientProtocolException -> 0x01fd, IOException -> 0x0206, Exception -> 0x020f, NullPointerException -> 0x01de, all -> 0x020c }
        r10 = r10.append(r11);	 Catch:{ UnsupportedEncodingException -> 0x01d8, ClientProtocolException -> 0x01fd, IOException -> 0x0206, Exception -> 0x020f, NullPointerException -> 0x01de, all -> 0x020c }
        r11 = "*";
        r10 = r10.append(r11);	 Catch:{ UnsupportedEncodingException -> 0x01d8, ClientProtocolException -> 0x01fd, IOException -> 0x0206, Exception -> 0x020f, NullPointerException -> 0x01de, all -> 0x020c }
        r11 = k;	 Catch:{ UnsupportedEncodingException -> 0x01d8, ClientProtocolException -> 0x01fd, IOException -> 0x0206, Exception -> 0x020f, NullPointerException -> 0x01de, all -> 0x020c }
        r10 = r10.append(r11);	 Catch:{ UnsupportedEncodingException -> 0x01d8, ClientProtocolException -> 0x01fd, IOException -> 0x0206, Exception -> 0x020f, NullPointerException -> 0x01de, all -> 0x020c }
        r10 = r10.toString();	 Catch:{ UnsupportedEncodingException -> 0x01d8, ClientProtocolException -> 0x01fd, IOException -> 0x0206, Exception -> 0x020f, NullPointerException -> 0x01de, all -> 0x020c }
        r8.put(r9, r10);	 Catch:{ UnsupportedEncodingException -> 0x01d8, ClientProtocolException -> 0x01fd, IOException -> 0x0206, Exception -> 0x020f, NullPointerException -> 0x01de, all -> 0x020c }
        r9 = "locale";
        r8.put(r9, r0);	 Catch:{ UnsupportedEncodingException -> 0x01d8, ClientProtocolException -> 0x01fd, IOException -> 0x0206, Exception -> 0x020f, NullPointerException -> 0x01de, all -> 0x020c }
        r0 = "install";
        r10 = 0;
        r8.put(r0, r10);	 Catch:{ UnsupportedEncodingException -> 0x01d8, ClientProtocolException -> 0x01fd, IOException -> 0x0206, Exception -> 0x020f, NullPointerException -> 0x01de, all -> 0x020c }
        r0 = "child";
        r8.put(r0, r1);	 Catch:{ UnsupportedEncodingException -> 0x01d8, ClientProtocolException -> 0x01fd, IOException -> 0x0206, Exception -> 0x020f, NullPointerException -> 0x01de, all -> 0x020c }
        r0 = "timestamp";
        r10 = java.lang.System.currentTimeMillis();	 Catch:{ UnsupportedEncodingException -> 0x01d8, ClientProtocolException -> 0x01fd, IOException -> 0x0206, Exception -> 0x020f, NullPointerException -> 0x01de, all -> 0x020c }
        r8.put(r0, r10);	 Catch:{ UnsupportedEncodingException -> 0x01d8, ClientProtocolException -> 0x01fd, IOException -> 0x0206, Exception -> 0x020f, NullPointerException -> 0x01de, all -> 0x020c }
        r0 = "net";
        r8.put(r0, r6);	 Catch:{ UnsupportedEncodingException -> 0x01d8, ClientProtocolException -> 0x01fd, IOException -> 0x0206, Exception -> 0x020f, NullPointerException -> 0x01de, all -> 0x020c }
        r0 = "mac";
        r1 = h;	 Catch:{ UnsupportedEncodingException -> 0x01d8, ClientProtocolException -> 0x01fd, IOException -> 0x0206, Exception -> 0x020f, NullPointerException -> 0x01de, all -> 0x020c }
        r8.put(r0, r1);	 Catch:{ UnsupportedEncodingException -> 0x01d8, ClientProtocolException -> 0x01fd, IOException -> 0x0206, Exception -> 0x020f, NullPointerException -> 0x01de, all -> 0x020c }
        r0 = "androidid";
        r1 = i;	 Catch:{ UnsupportedEncodingException -> 0x01d8, ClientProtocolException -> 0x01fd, IOException -> 0x0206, Exception -> 0x020f, NullPointerException -> 0x01de, all -> 0x020c }
        r8.put(r0, r1);	 Catch:{ UnsupportedEncodingException -> 0x01d8, ClientProtocolException -> 0x01fd, IOException -> 0x0206, Exception -> 0x020f, NullPointerException -> 0x01de, all -> 0x020c }
        r0 = "ipaddr";
        r1 = f();	 Catch:{ UnsupportedEncodingException -> 0x01d8, ClientProtocolException -> 0x01fd, IOException -> 0x0206, Exception -> 0x020f, NullPointerException -> 0x01de, all -> 0x020c }
        r8.put(r0, r1);	 Catch:{ UnsupportedEncodingException -> 0x01d8, ClientProtocolException -> 0x01fd, IOException -> 0x0206, Exception -> 0x020f, NullPointerException -> 0x01de, all -> 0x020c }
        r0 = "ver";
        r8.put(r0, r2);	 Catch:{ UnsupportedEncodingException -> 0x01d8, ClientProtocolException -> 0x01fd, IOException -> 0x0206, Exception -> 0x020f, NullPointerException -> 0x01de, all -> 0x020c }
        r0 = "vcode";
        r8.put(r0, r3);	 Catch:{ UnsupportedEncodingException -> 0x01d8, ClientProtocolException -> 0x01fd, IOException -> 0x0206, Exception -> 0x020f, NullPointerException -> 0x01de, all -> 0x020c }
        r0 = new org.json.JSONArray;	 Catch:{ UnsupportedEncodingException -> 0x01d8, ClientProtocolException -> 0x01fd, IOException -> 0x0206, Exception -> 0x020f, NullPointerException -> 0x01de, all -> 0x020c }
        r0.<init>();	 Catch:{ UnsupportedEncodingException -> 0x01d8, ClientProtocolException -> 0x01fd, IOException -> 0x0206, Exception -> 0x020f, NullPointerException -> 0x01de, all -> 0x020c }
        r0.put(r7);	 Catch:{ UnsupportedEncodingException -> 0x01d8, ClientProtocolException -> 0x01fd, IOException -> 0x0206, Exception -> 0x020f, NullPointerException -> 0x01de, all -> 0x020c }
        r1 = new org.json.JSONObject;	 Catch:{ UnsupportedEncodingException -> 0x01d8, ClientProtocolException -> 0x01fd, IOException -> 0x0206, Exception -> 0x020f, NullPointerException -> 0x01de, all -> 0x020c }
        r1.<init>();	 Catch:{ UnsupportedEncodingException -> 0x01d8, ClientProtocolException -> 0x01fd, IOException -> 0x0206, Exception -> 0x020f, NullPointerException -> 0x01de, all -> 0x020c }
        r2 = "base";
        r1.put(r2, r8);	 Catch:{ UnsupportedEncodingException -> 0x01d8, ClientProtocolException -> 0x01fd, IOException -> 0x0206, Exception -> 0x020f, NullPointerException -> 0x01de, all -> 0x020c }
        r2 = "content";
        r1.put(r2, r0);	 Catch:{ UnsupportedEncodingException -> 0x01d8, ClientProtocolException -> 0x01fd, IOException -> 0x0206, Exception -> 0x020f, NullPointerException -> 0x01de, all -> 0x020c }
        r0 = java.lang.String.valueOf(r1);	 Catch:{ UnsupportedEncodingException -> 0x01d8, ClientProtocolException -> 0x01fd, IOException -> 0x0206, Exception -> 0x020f, NullPointerException -> 0x01de, all -> 0x020c }
        r0 = com.vlocker.b.g.a(r0, r13);	 Catch:{ UnsupportedEncodingException -> 0x01d8, ClientProtocolException -> 0x01fd, IOException -> 0x0206, Exception -> 0x020f, NullPointerException -> 0x01de, all -> 0x020c }
        if (r0 == 0) goto L_0x0185;
    L_0x0181:
        r0 = a(r0);	 Catch:{ UnsupportedEncodingException -> 0x01d8, ClientProtocolException -> 0x01fd, IOException -> 0x0206, Exception -> 0x020f, NullPointerException -> 0x01de, all -> 0x020c }
    L_0x0185:
        r1 = r5.length;	 Catch:{ UnsupportedEncodingException -> 0x01d8, ClientProtocolException -> 0x01fd, IOException -> 0x0206, Exception -> 0x020f, NullPointerException -> 0x01de, all -> 0x020c }
        r2 = r0.length;	 Catch:{ UnsupportedEncodingException -> 0x01d8, ClientProtocolException -> 0x01fd, IOException -> 0x0206, Exception -> 0x020f, NullPointerException -> 0x01de, all -> 0x020c }
        r1 = a(r5, r1, r0, r2);	 Catch:{ UnsupportedEncodingException -> 0x01d8, ClientProtocolException -> 0x01fd, IOException -> 0x0206, Exception -> 0x020f, NullPointerException -> 0x01de, all -> 0x020c }
        r0 = new java.net.URL;	 Catch:{ UnsupportedEncodingException -> 0x01d8, ClientProtocolException -> 0x01fd, IOException -> 0x0206, Exception -> 0x020f, NullPointerException -> 0x01de, all -> 0x020c }
        r2 = "http://alc.imoxiu.com/collect/?app=556d0b43bb4d9b3c7a8b4567&key=557a53660183a2a37d66e390c3995424";
        r0.<init>(r2);	 Catch:{ UnsupportedEncodingException -> 0x01d8, ClientProtocolException -> 0x01fd, IOException -> 0x0206, Exception -> 0x020f, NullPointerException -> 0x01de, all -> 0x020c }
        r0 = r0.openConnection();	 Catch:{ UnsupportedEncodingException -> 0x01d8, ClientProtocolException -> 0x01fd, IOException -> 0x0206, Exception -> 0x020f, NullPointerException -> 0x01de, all -> 0x020c }
        r0 = (java.net.HttpURLConnection) r0;	 Catch:{ UnsupportedEncodingException -> 0x01d8, ClientProtocolException -> 0x01fd, IOException -> 0x0206, Exception -> 0x020f, NullPointerException -> 0x01de, all -> 0x020c }
        r2 = 5000; // 0x1388 float:7.006E-42 double:2.4703E-320;
        r0.setConnectTimeout(r2);	 Catch:{ UnsupportedEncodingException -> 0x01d8, ClientProtocolException -> 0x01fd, IOException -> 0x0206, Exception -> 0x020f, NullPointerException -> 0x01de, all -> 0x020c }
        r2 = "POST";
        r0.setRequestMethod(r2);	 Catch:{ UnsupportedEncodingException -> 0x01d8, ClientProtocolException -> 0x01fd, IOException -> 0x0206, Exception -> 0x020f, NullPointerException -> 0x01de, all -> 0x020c }
        r2 = "Content-Type";
        r3 = "application/x-www-form-urlencoded";
        r0.setRequestProperty(r2, r3);	 Catch:{ UnsupportedEncodingException -> 0x01d8, ClientProtocolException -> 0x01fd, IOException -> 0x0206, Exception -> 0x020f, NullPointerException -> 0x01de, all -> 0x020c }
        r2 = "Content-Length";
        r3 = new java.lang.StringBuilder;	 Catch:{ UnsupportedEncodingException -> 0x01d8, ClientProtocolException -> 0x01fd, IOException -> 0x0206, Exception -> 0x020f, NullPointerException -> 0x01de, all -> 0x020c }
        r3.<init>();	 Catch:{ UnsupportedEncodingException -> 0x01d8, ClientProtocolException -> 0x01fd, IOException -> 0x0206, Exception -> 0x020f, NullPointerException -> 0x01de, all -> 0x020c }
        r5 = r1.length;	 Catch:{ UnsupportedEncodingException -> 0x01d8, ClientProtocolException -> 0x01fd, IOException -> 0x0206, Exception -> 0x020f, NullPointerException -> 0x01de, all -> 0x020c }
        r3 = r3.append(r5);	 Catch:{ UnsupportedEncodingException -> 0x01d8, ClientProtocolException -> 0x01fd, IOException -> 0x0206, Exception -> 0x020f, NullPointerException -> 0x01de, all -> 0x020c }
        r5 = "";
        r3 = r3.append(r5);	 Catch:{ UnsupportedEncodingException -> 0x01d8, ClientProtocolException -> 0x01fd, IOException -> 0x0206, Exception -> 0x020f, NullPointerException -> 0x01de, all -> 0x020c }
        r3 = r3.toString();	 Catch:{ UnsupportedEncodingException -> 0x01d8, ClientProtocolException -> 0x01fd, IOException -> 0x0206, Exception -> 0x020f, NullPointerException -> 0x01de, all -> 0x020c }
        r0.setRequestProperty(r2, r3);	 Catch:{ UnsupportedEncodingException -> 0x01d8, ClientProtocolException -> 0x01fd, IOException -> 0x0206, Exception -> 0x020f, NullPointerException -> 0x01de, all -> 0x020c }
        r2 = 1;
        r0.setDoOutput(r2);	 Catch:{ UnsupportedEncodingException -> 0x01d8, ClientProtocolException -> 0x01fd, IOException -> 0x0206, Exception -> 0x020f, NullPointerException -> 0x01de, all -> 0x020c }
        r2 = r0.getOutputStream();	 Catch:{ UnsupportedEncodingException -> 0x01d8, ClientProtocolException -> 0x01fd, IOException -> 0x0206, Exception -> 0x020f, NullPointerException -> 0x01de, all -> 0x020c }
        r2.write(r1);	 Catch:{ UnsupportedEncodingException -> 0x01d8, ClientProtocolException -> 0x01fd, IOException -> 0x0206, Exception -> 0x020f, NullPointerException -> 0x01de, all -> 0x020c }
        r0.getResponseCode();	 Catch:{ UnsupportedEncodingException -> 0x01d8, ClientProtocolException -> 0x01fd, IOException -> 0x0206, Exception -> 0x020f, NullPointerException -> 0x01de, all -> 0x020c }
        goto L_0x008a;
    L_0x01d8:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ NullPointerException -> 0x01de, Exception -> 0x0203, all -> 0x020c }
        goto L_0x008a;
    L_0x01de:
        r0 = move-exception;
        goto L_0x008a;
    L_0x01e1:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ UnsupportedEncodingException -> 0x01d8, ClientProtocolException -> 0x01fd, IOException -> 0x0206, Exception -> 0x020f, NullPointerException -> 0x01de, all -> 0x020c }
        r3 = r2;
        r2 = r1;
        goto L_0x009f;
    L_0x01e9:
        r0 = move-exception;
        r0 = r1;
        goto L_0x00c6;
    L_0x01ed:
        r0 = move-exception;
        r0 = r1;
        goto L_0x00c6;
    L_0x01f1:
        r1 = move-exception;
        r1 = "new-moxiulauncher";
        goto L_0x00cd;
    L_0x01f7:
        r1 = move-exception;
        r1 = "new-moxiulauncher";
        goto L_0x00cd;
    L_0x01fd:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ NullPointerException -> 0x01de, Exception -> 0x0203, all -> 0x020c }
        goto L_0x008a;
    L_0x0203:
        r0 = move-exception;
        goto L_0x008a;
    L_0x0206:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ NullPointerException -> 0x01de, Exception -> 0x0203, all -> 0x020c }
        goto L_0x008a;
    L_0x020c:
        r0 = move-exception;
        monitor-exit(r4);
        throw r0;
    L_0x020f:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ NullPointerException -> 0x01de, Exception -> 0x0203, all -> 0x020c }
        goto L_0x008a;
    L_0x0215:
        r0 = move-exception;
        goto L_0x008a;
    L_0x0218:
        r0 = move-exception;
        goto L_0x008a;
    L_0x021b:
        r0 = move-exception;
        goto L_0x0046;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vlocker.b.j.a(android.content.Context, java.lang.String, java.lang.String):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void a(android.content.Context r11, org.json.JSONArray r12, java.lang.String r13, java.io.File r14) {
        /*
        r1 = 0;
        r8 = 1;
        r2 = 0;
        r4 = com.vlocker.b.j.class;
        monitor-enter(r4);
        r5 = com.vlocker.b.h.a(r13, r11);	 Catch:{ NullPointerException -> 0x01e8, Exception -> 0x01e6, all -> 0x01de }
        r6 = b(r11);	 Catch:{ NullPointerException -> 0x01e8, Exception -> 0x01e6, all -> 0x01de }
        r0 = g;	 Catch:{ NullPointerException -> 0x01e8, Exception -> 0x01e6, all -> 0x01de }
        if (r0 != 0) goto L_0x0021;
    L_0x0012:
        r0 = "phone";
        r0 = r11.getSystemService(r0);	 Catch:{ NullPointerException -> 0x01e8, Exception -> 0x01e6, all -> 0x01de }
        r0 = (android.telephony.TelephonyManager) r0;	 Catch:{ NullPointerException -> 0x01e8, Exception -> 0x01e6, all -> 0x01de }
        r0 = r0.getDeviceId();	 Catch:{ NullPointerException -> 0x01e8, Exception -> 0x01e6, all -> 0x01de }
        g = r0;	 Catch:{ NullPointerException -> 0x01e8, Exception -> 0x01e6, all -> 0x01de }
    L_0x0021:
        r0 = i;	 Catch:{ NullPointerException -> 0x01e8, Exception -> 0x01e6, all -> 0x01de }
        if (r0 != 0) goto L_0x0046;
    L_0x0025:
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x01ea, NullPointerException -> 0x01e8, all -> 0x01de }
        r0.<init>();	 Catch:{ Exception -> 0x01ea, NullPointerException -> 0x01e8, all -> 0x01de }
        r3 = "";
        r0 = r0.append(r3);	 Catch:{ Exception -> 0x01ea, NullPointerException -> 0x01e8, all -> 0x01de }
        r3 = r11.getContentResolver();	 Catch:{ Exception -> 0x01ea, NullPointerException -> 0x01e8, all -> 0x01de }
        r7 = "android_id";
        r3 = android.provider.Settings.Secure.getString(r3, r7);	 Catch:{ Exception -> 0x01ea, NullPointerException -> 0x01e8, all -> 0x01de }
        r0 = r0.append(r3);	 Catch:{ Exception -> 0x01ea, NullPointerException -> 0x01e8, all -> 0x01de }
        r0 = r0.toString();	 Catch:{ Exception -> 0x01ea, NullPointerException -> 0x01e8, all -> 0x01de }
        i = r0;	 Catch:{ Exception -> 0x01ea, NullPointerException -> 0x01e8, all -> 0x01de }
    L_0x0046:
        r0 = h;	 Catch:{ NullPointerException -> 0x01e8, Exception -> 0x01e6, all -> 0x01de }
        if (r0 != 0) goto L_0x005d;
    L_0x004a:
        r0 = "wifi";
        r0 = r11.getSystemService(r0);	 Catch:{ NullPointerException -> 0x01e8, Exception -> 0x01e6, all -> 0x01de }
        r0 = (android.net.wifi.WifiManager) r0;	 Catch:{ NullPointerException -> 0x01e8, Exception -> 0x01e6, all -> 0x01de }
        r0 = r0.getConnectionInfo();	 Catch:{ NullPointerException -> 0x01e8, Exception -> 0x01e6, all -> 0x01de }
        r0 = r0.getMacAddress();	 Catch:{ NullPointerException -> 0x01e8, Exception -> 0x01e6, all -> 0x01de }
        h = r0;	 Catch:{ NullPointerException -> 0x01e8, Exception -> 0x01e6, all -> 0x01de }
    L_0x005d:
        r0 = r11.getPackageManager();	 Catch:{ UnsupportedEncodingException -> 0x01cb, ClientProtocolException -> 0x01d2, IOException -> 0x01d9, Exception -> 0x01e1, NullPointerException -> 0x01d0, all -> 0x01de }
        r3 = r11.getPackageName();	 Catch:{ NameNotFoundException -> 0x01af }
        r7 = 0;
        r0 = r0.getPackageInfo(r3, r7);	 Catch:{ NameNotFoundException -> 0x01af }
        r2 = r0.versionCode;	 Catch:{ NameNotFoundException -> 0x01af }
        r0 = r0.versionName;	 Catch:{ NameNotFoundException -> 0x01af }
        r3 = r2;
        r2 = r0;
    L_0x0070:
        r0 = j;	 Catch:{ UnsupportedEncodingException -> 0x01cb, ClientProtocolException -> 0x01d2, IOException -> 0x01d9, Exception -> 0x01e1, NullPointerException -> 0x01d0, all -> 0x01de }
        if (r0 >= r8) goto L_0x0089;
    L_0x0074:
        r0 = new android.util.DisplayMetrics;	 Catch:{ UnsupportedEncodingException -> 0x01cb, ClientProtocolException -> 0x01d2, IOException -> 0x01d9, Exception -> 0x01e1, NullPointerException -> 0x01d0, all -> 0x01de }
        r0.<init>();	 Catch:{ UnsupportedEncodingException -> 0x01cb, ClientProtocolException -> 0x01d2, IOException -> 0x01d9, Exception -> 0x01e1, NullPointerException -> 0x01d0, all -> 0x01de }
        r0 = r11.getResources();	 Catch:{ UnsupportedEncodingException -> 0x01cb, ClientProtocolException -> 0x01d2, IOException -> 0x01d9, Exception -> 0x01e1, NullPointerException -> 0x01d0, all -> 0x01de }
        r0 = r0.getDisplayMetrics();	 Catch:{ UnsupportedEncodingException -> 0x01cb, ClientProtocolException -> 0x01d2, IOException -> 0x01d9, Exception -> 0x01e1, NullPointerException -> 0x01d0, all -> 0x01de }
        r7 = r0.widthPixels;	 Catch:{ UnsupportedEncodingException -> 0x01cb, ClientProtocolException -> 0x01d2, IOException -> 0x01d9, Exception -> 0x01e1, NullPointerException -> 0x01d0, all -> 0x01de }
        j = r7;	 Catch:{ UnsupportedEncodingException -> 0x01cb, ClientProtocolException -> 0x01d2, IOException -> 0x01d9, Exception -> 0x01e1, NullPointerException -> 0x01d0, all -> 0x01de }
        r0 = r0.heightPixels;	 Catch:{ UnsupportedEncodingException -> 0x01cb, ClientProtocolException -> 0x01d2, IOException -> 0x01d9, Exception -> 0x01e1, NullPointerException -> 0x01d0, all -> 0x01de }
        k = r0;	 Catch:{ UnsupportedEncodingException -> 0x01cb, ClientProtocolException -> 0x01d2, IOException -> 0x01d9, Exception -> 0x01e1, NullPointerException -> 0x01d0, all -> 0x01de }
    L_0x0089:
        r0 = r11.getResources();	 Catch:{ NullPointerException -> 0x01b7, Exception -> 0x01bb, UnsupportedEncodingException -> 0x01cb, ClientProtocolException -> 0x01d2, IOException -> 0x01d9, all -> 0x01de }
        r0 = r0.getConfiguration();	 Catch:{ NullPointerException -> 0x01b7, Exception -> 0x01bb, UnsupportedEncodingException -> 0x01cb, ClientProtocolException -> 0x01d2, IOException -> 0x01d9, all -> 0x01de }
        r0 = r0.locale;	 Catch:{ NullPointerException -> 0x01b7, Exception -> 0x01bb, UnsupportedEncodingException -> 0x01cb, ClientProtocolException -> 0x01d2, IOException -> 0x01d9, all -> 0x01de }
        r0 = r0.toString();	 Catch:{ NullPointerException -> 0x01b7, Exception -> 0x01bb, UnsupportedEncodingException -> 0x01cb, ClientProtocolException -> 0x01d2, IOException -> 0x01d9, all -> 0x01de }
    L_0x0097:
        r1 = 2131296842; // 0x7f09024a float:1.8211612E38 double:1.0530005507E-314;
        r1 = r11.getString(r1);	 Catch:{ NotFoundException -> 0x01bf, Exception -> 0x01c5, UnsupportedEncodingException -> 0x01cb, ClientProtocolException -> 0x01d2, IOException -> 0x01d9, NullPointerException -> 0x01d0, all -> 0x01de }
    L_0x009e:
        r7 = new org.json.JSONObject;	 Catch:{ UnsupportedEncodingException -> 0x01cb, ClientProtocolException -> 0x01d2, IOException -> 0x01d9, Exception -> 0x01e1, NullPointerException -> 0x01d0, all -> 0x01de }
        r7.<init>();	 Catch:{ UnsupportedEncodingException -> 0x01cb, ClientProtocolException -> 0x01d2, IOException -> 0x01d9, Exception -> 0x01e1, NullPointerException -> 0x01d0, all -> 0x01de }
        r8 = "imei";
        r9 = g;	 Catch:{ UnsupportedEncodingException -> 0x01cb, ClientProtocolException -> 0x01d2, IOException -> 0x01d9, Exception -> 0x01e1, NullPointerException -> 0x01d0, all -> 0x01de }
        r7.put(r8, r9);	 Catch:{ UnsupportedEncodingException -> 0x01cb, ClientProtocolException -> 0x01d2, IOException -> 0x01d9, Exception -> 0x01e1, NullPointerException -> 0x01d0, all -> 0x01de }
        r8 = "model";
        r9 = android.os.Build.MODEL;	 Catch:{ UnsupportedEncodingException -> 0x01cb, ClientProtocolException -> 0x01d2, IOException -> 0x01d9, Exception -> 0x01e1, NullPointerException -> 0x01d0, all -> 0x01de }
        r7.put(r8, r9);	 Catch:{ UnsupportedEncodingException -> 0x01cb, ClientProtocolException -> 0x01d2, IOException -> 0x01d9, Exception -> 0x01e1, NullPointerException -> 0x01d0, all -> 0x01de }
        r8 = "manufacturer";
        r9 = android.os.Build.MANUFACTURER;	 Catch:{ UnsupportedEncodingException -> 0x01cb, ClientProtocolException -> 0x01d2, IOException -> 0x01d9, Exception -> 0x01e1, NullPointerException -> 0x01d0, all -> 0x01de }
        r7.put(r8, r9);	 Catch:{ UnsupportedEncodingException -> 0x01cb, ClientProtocolException -> 0x01d2, IOException -> 0x01d9, Exception -> 0x01e1, NullPointerException -> 0x01d0, all -> 0x01de }
        r8 = "androidsdk";
        r9 = android.os.Build.VERSION.SDK_INT;	 Catch:{ UnsupportedEncodingException -> 0x01cb, ClientProtocolException -> 0x01d2, IOException -> 0x01d9, Exception -> 0x01e1, NullPointerException -> 0x01d0, all -> 0x01de }
        r7.put(r8, r9);	 Catch:{ UnsupportedEncodingException -> 0x01cb, ClientProtocolException -> 0x01d2, IOException -> 0x01d9, Exception -> 0x01e1, NullPointerException -> 0x01d0, all -> 0x01de }
        r8 = "display";
        r9 = new java.lang.StringBuilder;	 Catch:{ UnsupportedEncodingException -> 0x01cb, ClientProtocolException -> 0x01d2, IOException -> 0x01d9, Exception -> 0x01e1, NullPointerException -> 0x01d0, all -> 0x01de }
        r9.<init>();	 Catch:{ UnsupportedEncodingException -> 0x01cb, ClientProtocolException -> 0x01d2, IOException -> 0x01d9, Exception -> 0x01e1, NullPointerException -> 0x01d0, all -> 0x01de }
        r10 = j;	 Catch:{ UnsupportedEncodingException -> 0x01cb, ClientProtocolException -> 0x01d2, IOException -> 0x01d9, Exception -> 0x01e1, NullPointerException -> 0x01d0, all -> 0x01de }
        r9 = r9.append(r10);	 Catch:{ UnsupportedEncodingException -> 0x01cb, ClientProtocolException -> 0x01d2, IOException -> 0x01d9, Exception -> 0x01e1, NullPointerException -> 0x01d0, all -> 0x01de }
        r10 = "*";
        r9 = r9.append(r10);	 Catch:{ UnsupportedEncodingException -> 0x01cb, ClientProtocolException -> 0x01d2, IOException -> 0x01d9, Exception -> 0x01e1, NullPointerException -> 0x01d0, all -> 0x01de }
        r10 = k;	 Catch:{ UnsupportedEncodingException -> 0x01cb, ClientProtocolException -> 0x01d2, IOException -> 0x01d9, Exception -> 0x01e1, NullPointerException -> 0x01d0, all -> 0x01de }
        r9 = r9.append(r10);	 Catch:{ UnsupportedEncodingException -> 0x01cb, ClientProtocolException -> 0x01d2, IOException -> 0x01d9, Exception -> 0x01e1, NullPointerException -> 0x01d0, all -> 0x01de }
        r9 = r9.toString();	 Catch:{ UnsupportedEncodingException -> 0x01cb, ClientProtocolException -> 0x01d2, IOException -> 0x01d9, Exception -> 0x01e1, NullPointerException -> 0x01d0, all -> 0x01de }
        r7.put(r8, r9);	 Catch:{ UnsupportedEncodingException -> 0x01cb, ClientProtocolException -> 0x01d2, IOException -> 0x01d9, Exception -> 0x01e1, NullPointerException -> 0x01d0, all -> 0x01de }
        r8 = "locale";
        r7.put(r8, r0);	 Catch:{ UnsupportedEncodingException -> 0x01cb, ClientProtocolException -> 0x01d2, IOException -> 0x01d9, Exception -> 0x01e1, NullPointerException -> 0x01d0, all -> 0x01de }
        r0 = "install";
        r8 = 0;
        r7.put(r0, r8);	 Catch:{ UnsupportedEncodingException -> 0x01cb, ClientProtocolException -> 0x01d2, IOException -> 0x01d9, Exception -> 0x01e1, NullPointerException -> 0x01d0, all -> 0x01de }
        r0 = "child";
        r7.put(r0, r1);	 Catch:{ UnsupportedEncodingException -> 0x01cb, ClientProtocolException -> 0x01d2, IOException -> 0x01d9, Exception -> 0x01e1, NullPointerException -> 0x01d0, all -> 0x01de }
        r0 = "timestamp";
        r8 = java.lang.System.currentTimeMillis();	 Catch:{ UnsupportedEncodingException -> 0x01cb, ClientProtocolException -> 0x01d2, IOException -> 0x01d9, Exception -> 0x01e1, NullPointerException -> 0x01d0, all -> 0x01de }
        r7.put(r0, r8);	 Catch:{ UnsupportedEncodingException -> 0x01cb, ClientProtocolException -> 0x01d2, IOException -> 0x01d9, Exception -> 0x01e1, NullPointerException -> 0x01d0, all -> 0x01de }
        r0 = "net";
        r7.put(r0, r6);	 Catch:{ UnsupportedEncodingException -> 0x01cb, ClientProtocolException -> 0x01d2, IOException -> 0x01d9, Exception -> 0x01e1, NullPointerException -> 0x01d0, all -> 0x01de }
        r0 = "mac";
        r1 = h;	 Catch:{ UnsupportedEncodingException -> 0x01cb, ClientProtocolException -> 0x01d2, IOException -> 0x01d9, Exception -> 0x01e1, NullPointerException -> 0x01d0, all -> 0x01de }
        r7.put(r0, r1);	 Catch:{ UnsupportedEncodingException -> 0x01cb, ClientProtocolException -> 0x01d2, IOException -> 0x01d9, Exception -> 0x01e1, NullPointerException -> 0x01d0, all -> 0x01de }
        r0 = "androidid";
        r1 = i;	 Catch:{ UnsupportedEncodingException -> 0x01cb, ClientProtocolException -> 0x01d2, IOException -> 0x01d9, Exception -> 0x01e1, NullPointerException -> 0x01d0, all -> 0x01de }
        r7.put(r0, r1);	 Catch:{ UnsupportedEncodingException -> 0x01cb, ClientProtocolException -> 0x01d2, IOException -> 0x01d9, Exception -> 0x01e1, NullPointerException -> 0x01d0, all -> 0x01de }
        r0 = "ipaddr";
        r1 = f();	 Catch:{ UnsupportedEncodingException -> 0x01cb, ClientProtocolException -> 0x01d2, IOException -> 0x01d9, Exception -> 0x01e1, NullPointerException -> 0x01d0, all -> 0x01de }
        r7.put(r0, r1);	 Catch:{ UnsupportedEncodingException -> 0x01cb, ClientProtocolException -> 0x01d2, IOException -> 0x01d9, Exception -> 0x01e1, NullPointerException -> 0x01d0, all -> 0x01de }
        r0 = "ver";
        r7.put(r0, r2);	 Catch:{ UnsupportedEncodingException -> 0x01cb, ClientProtocolException -> 0x01d2, IOException -> 0x01d9, Exception -> 0x01e1, NullPointerException -> 0x01d0, all -> 0x01de }
        r0 = "vcode";
        r7.put(r0, r3);	 Catch:{ UnsupportedEncodingException -> 0x01cb, ClientProtocolException -> 0x01d2, IOException -> 0x01d9, Exception -> 0x01e1, NullPointerException -> 0x01d0, all -> 0x01de }
        r0 = new org.json.JSONObject;	 Catch:{ UnsupportedEncodingException -> 0x01cb, ClientProtocolException -> 0x01d2, IOException -> 0x01d9, Exception -> 0x01e1, NullPointerException -> 0x01d0, all -> 0x01de }
        r0.<init>();	 Catch:{ UnsupportedEncodingException -> 0x01cb, ClientProtocolException -> 0x01d2, IOException -> 0x01d9, Exception -> 0x01e1, NullPointerException -> 0x01d0, all -> 0x01de }
        r1 = "base";
        r0.put(r1, r7);	 Catch:{ UnsupportedEncodingException -> 0x01cb, ClientProtocolException -> 0x01d2, IOException -> 0x01d9, Exception -> 0x01e1, NullPointerException -> 0x01d0, all -> 0x01de }
        r1 = "content";
        r0.put(r1, r12);	 Catch:{ UnsupportedEncodingException -> 0x01cb, ClientProtocolException -> 0x01d2, IOException -> 0x01d9, Exception -> 0x01e1, NullPointerException -> 0x01d0, all -> 0x01de }
        r0 = java.lang.String.valueOf(r0);	 Catch:{ UnsupportedEncodingException -> 0x01cb, ClientProtocolException -> 0x01d2, IOException -> 0x01d9, Exception -> 0x01e1, NullPointerException -> 0x01d0, all -> 0x01de }
        r0 = com.vlocker.b.g.a(r0, r13);	 Catch:{ UnsupportedEncodingException -> 0x01cb, ClientProtocolException -> 0x01d2, IOException -> 0x01d9, Exception -> 0x01e1, NullPointerException -> 0x01d0, all -> 0x01de }
        if (r0 == 0) goto L_0x014e;
    L_0x014a:
        r0 = a(r0);	 Catch:{ UnsupportedEncodingException -> 0x01cb, ClientProtocolException -> 0x01d2, IOException -> 0x01d9, Exception -> 0x01e1, NullPointerException -> 0x01d0, all -> 0x01de }
    L_0x014e:
        r1 = r5.length;	 Catch:{ UnsupportedEncodingException -> 0x01cb, ClientProtocolException -> 0x01d2, IOException -> 0x01d9, Exception -> 0x01e1, NullPointerException -> 0x01d0, all -> 0x01de }
        r2 = r0.length;	 Catch:{ UnsupportedEncodingException -> 0x01cb, ClientProtocolException -> 0x01d2, IOException -> 0x01d9, Exception -> 0x01e1, NullPointerException -> 0x01d0, all -> 0x01de }
        r1 = a(r5, r1, r0, r2);	 Catch:{ UnsupportedEncodingException -> 0x01cb, ClientProtocolException -> 0x01d2, IOException -> 0x01d9, Exception -> 0x01e1, NullPointerException -> 0x01d0, all -> 0x01de }
        r0 = new java.net.URL;	 Catch:{ UnsupportedEncodingException -> 0x01cb, ClientProtocolException -> 0x01d2, IOException -> 0x01d9, Exception -> 0x01e1, NullPointerException -> 0x01d0, all -> 0x01de }
        r2 = "http://alc.imoxiu.com/collect/?app=556d0b43bb4d9b3c7a8b4567&key=557a53660183a2a37d66e390c3995424";
        r0.<init>(r2);	 Catch:{ UnsupportedEncodingException -> 0x01cb, ClientProtocolException -> 0x01d2, IOException -> 0x01d9, Exception -> 0x01e1, NullPointerException -> 0x01d0, all -> 0x01de }
        r0 = r0.openConnection();	 Catch:{ UnsupportedEncodingException -> 0x01cb, ClientProtocolException -> 0x01d2, IOException -> 0x01d9, Exception -> 0x01e1, NullPointerException -> 0x01d0, all -> 0x01de }
        r0 = (java.net.HttpURLConnection) r0;	 Catch:{ UnsupportedEncodingException -> 0x01cb, ClientProtocolException -> 0x01d2, IOException -> 0x01d9, Exception -> 0x01e1, NullPointerException -> 0x01d0, all -> 0x01de }
        r2 = 5000; // 0x1388 float:7.006E-42 double:2.4703E-320;
        r0.setConnectTimeout(r2);	 Catch:{ UnsupportedEncodingException -> 0x01cb, ClientProtocolException -> 0x01d2, IOException -> 0x01d9, Exception -> 0x01e1, NullPointerException -> 0x01d0, all -> 0x01de }
        r2 = "POST";
        r0.setRequestMethod(r2);	 Catch:{ UnsupportedEncodingException -> 0x01cb, ClientProtocolException -> 0x01d2, IOException -> 0x01d9, Exception -> 0x01e1, NullPointerException -> 0x01d0, all -> 0x01de }
        r2 = "Content-Type";
        r3 = "application/x-www-form-urlencoded";
        r0.setRequestProperty(r2, r3);	 Catch:{ UnsupportedEncodingException -> 0x01cb, ClientProtocolException -> 0x01d2, IOException -> 0x01d9, Exception -> 0x01e1, NullPointerException -> 0x01d0, all -> 0x01de }
        r2 = "Content-Length";
        r3 = new java.lang.StringBuilder;	 Catch:{ UnsupportedEncodingException -> 0x01cb, ClientProtocolException -> 0x01d2, IOException -> 0x01d9, Exception -> 0x01e1, NullPointerException -> 0x01d0, all -> 0x01de }
        r3.<init>();	 Catch:{ UnsupportedEncodingException -> 0x01cb, ClientProtocolException -> 0x01d2, IOException -> 0x01d9, Exception -> 0x01e1, NullPointerException -> 0x01d0, all -> 0x01de }
        r5 = r1.length;	 Catch:{ UnsupportedEncodingException -> 0x01cb, ClientProtocolException -> 0x01d2, IOException -> 0x01d9, Exception -> 0x01e1, NullPointerException -> 0x01d0, all -> 0x01de }
        r3 = r3.append(r5);	 Catch:{ UnsupportedEncodingException -> 0x01cb, ClientProtocolException -> 0x01d2, IOException -> 0x01d9, Exception -> 0x01e1, NullPointerException -> 0x01d0, all -> 0x01de }
        r5 = "";
        r3 = r3.append(r5);	 Catch:{ UnsupportedEncodingException -> 0x01cb, ClientProtocolException -> 0x01d2, IOException -> 0x01d9, Exception -> 0x01e1, NullPointerException -> 0x01d0, all -> 0x01de }
        r3 = r3.toString();	 Catch:{ UnsupportedEncodingException -> 0x01cb, ClientProtocolException -> 0x01d2, IOException -> 0x01d9, Exception -> 0x01e1, NullPointerException -> 0x01d0, all -> 0x01de }
        r0.setRequestProperty(r2, r3);	 Catch:{ UnsupportedEncodingException -> 0x01cb, ClientProtocolException -> 0x01d2, IOException -> 0x01d9, Exception -> 0x01e1, NullPointerException -> 0x01d0, all -> 0x01de }
        r2 = 1;
        r0.setDoOutput(r2);	 Catch:{ UnsupportedEncodingException -> 0x01cb, ClientProtocolException -> 0x01d2, IOException -> 0x01d9, Exception -> 0x01e1, NullPointerException -> 0x01d0, all -> 0x01de }
        r2 = r0.getOutputStream();	 Catch:{ UnsupportedEncodingException -> 0x01cb, ClientProtocolException -> 0x01d2, IOException -> 0x01d9, Exception -> 0x01e1, NullPointerException -> 0x01d0, all -> 0x01de }
        r2.write(r1);	 Catch:{ UnsupportedEncodingException -> 0x01cb, ClientProtocolException -> 0x01d2, IOException -> 0x01d9, Exception -> 0x01e1, NullPointerException -> 0x01d0, all -> 0x01de }
        r0 = r0.getResponseCode();	 Catch:{ UnsupportedEncodingException -> 0x01cb, ClientProtocolException -> 0x01d2, IOException -> 0x01d9, Exception -> 0x01e1, NullPointerException -> 0x01d0, all -> 0x01de }
        r1 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r0 != r1) goto L_0x01ad;
    L_0x01a4:
        r0 = r14.exists();	 Catch:{ UnsupportedEncodingException -> 0x01cb, ClientProtocolException -> 0x01d2, IOException -> 0x01d9, Exception -> 0x01e1, NullPointerException -> 0x01d0, all -> 0x01de }
        if (r0 == 0) goto L_0x01ad;
    L_0x01aa:
        r14.delete();	 Catch:{ UnsupportedEncodingException -> 0x01cb, ClientProtocolException -> 0x01d2, IOException -> 0x01d9, Exception -> 0x01e1, NullPointerException -> 0x01d0, all -> 0x01de }
    L_0x01ad:
        monitor-exit(r4);
        return;
    L_0x01af:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ UnsupportedEncodingException -> 0x01cb, ClientProtocolException -> 0x01d2, IOException -> 0x01d9, Exception -> 0x01e1, NullPointerException -> 0x01d0, all -> 0x01de }
        r3 = r2;
        r2 = r1;
        goto L_0x0070;
    L_0x01b7:
        r0 = move-exception;
        r0 = r1;
        goto L_0x0097;
    L_0x01bb:
        r0 = move-exception;
        r0 = r1;
        goto L_0x0097;
    L_0x01bf:
        r1 = move-exception;
        r1 = "new-moxiulauncher";
        goto L_0x009e;
    L_0x01c5:
        r1 = move-exception;
        r1 = "new-moxiulauncher";
        goto L_0x009e;
    L_0x01cb:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ NullPointerException -> 0x01d0, Exception -> 0x01d7, all -> 0x01de }
        goto L_0x01ad;
    L_0x01d0:
        r0 = move-exception;
        goto L_0x01ad;
    L_0x01d2:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ NullPointerException -> 0x01d0, Exception -> 0x01d7, all -> 0x01de }
        goto L_0x01ad;
    L_0x01d7:
        r0 = move-exception;
        goto L_0x01ad;
    L_0x01d9:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ NullPointerException -> 0x01d0, Exception -> 0x01d7, all -> 0x01de }
        goto L_0x01ad;
    L_0x01de:
        r0 = move-exception;
        monitor-exit(r4);
        throw r0;
    L_0x01e1:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ NullPointerException -> 0x01d0, Exception -> 0x01d7, all -> 0x01de }
        goto L_0x01ad;
    L_0x01e6:
        r0 = move-exception;
        goto L_0x01ad;
    L_0x01e8:
        r0 = move-exception;
        goto L_0x01ad;
    L_0x01ea:
        r0 = move-exception;
        goto L_0x0046;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vlocker.b.j.a(android.content.Context, org.json.JSONArray, java.lang.String, java.io.File):void");
    }

    public static void a(Context context, JSONObject jSONObject) {
        String str = "";
        String str2 = "";
        str = "";
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("dock");
            try {
                String str3;
                if (jSONObject2.isNull("target")) {
                    str3 = "default";
                } else {
                    str3 = jSONObject2.getString("target");
                    if (!jSONObject2.isNull("prefix")) {
                        str2 = jSONObject2.getString("prefix");
                    }
                    if (!jSONObject2.isNull("suggest")) {
                        str = jSONObject2.getString("suggest");
                    }
                }
                if (!TextUtils.isEmpty(str3)) {
                    ap.a(context, str2);
                    ap.a(context, str3, str);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void a(InputStream inputStream, OutputStream outputStream) {
        DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(outputStream);
        byte[] bArr = new byte[IXAdIOUtils.BUFFER_SIZE];
        while (true) {
            int read = inputStream.read(bArr, 0, IXAdIOUtils.BUFFER_SIZE);
            if (read != -1) {
                deflaterOutputStream.write(bArr, 0, read);
            } else {
                deflaterOutputStream.flush();
                deflaterOutputStream.close();
                return;
            }
        }
    }

    public static boolean a(int i, int i2) {
        if (i == 1) {
            return true;
        }
        if (i != 0) {
            return false;
        }
        switch (i2) {
            case 0:
                return false;
            case 1:
                return false;
            case 2:
                return false;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 13:
            case IMediaObject.TYPE_OLD_TV /*14*/:
            case 15:
                return true;
            case 4:
                return false;
            case 7:
                return false;
            case 11:
                return false;
            default:
                return false;
        }
    }

    public static boolean a(Context context, String str) {
        if (str == null || "".equals(str)) {
            return false;
        }
        try {
            context.getPackageManager().getApplicationInfo(str, 8192);
            return true;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized boolean a(android.content.Context r13, org.json.JSONObject r14, java.lang.String r15) {
        /*
        r1 = 1;
        r2 = 0;
        r5 = com.vlocker.b.j.class;
        monitor-enter(r5);
        r6 = com.vlocker.b.h.a(r15, r13);	 Catch:{ NullPointerException -> 0x01e4, Exception -> 0x01e1, all -> 0x01d8 }
        r7 = b(r13);	 Catch:{ NullPointerException -> 0x01e4, Exception -> 0x01e1, all -> 0x01d8 }
        r0 = g;	 Catch:{ NullPointerException -> 0x01e4, Exception -> 0x01e1, all -> 0x01d8 }
        if (r0 != 0) goto L_0x0020;
    L_0x0011:
        r0 = "phone";
        r0 = r13.getSystemService(r0);	 Catch:{ NullPointerException -> 0x01e4, Exception -> 0x01e1, all -> 0x01d8 }
        r0 = (android.telephony.TelephonyManager) r0;	 Catch:{ NullPointerException -> 0x01e4, Exception -> 0x01e1, all -> 0x01d8 }
        r0 = r0.getDeviceId();	 Catch:{ NullPointerException -> 0x01e4, Exception -> 0x01e1, all -> 0x01d8 }
        g = r0;	 Catch:{ NullPointerException -> 0x01e4, Exception -> 0x01e1, all -> 0x01d8 }
    L_0x0020:
        r0 = i;	 Catch:{ NullPointerException -> 0x01e4, Exception -> 0x01e1, all -> 0x01d8 }
        if (r0 != 0) goto L_0x0045;
    L_0x0024:
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x01e9, NullPointerException -> 0x01e4, all -> 0x01d8 }
        r0.<init>();	 Catch:{ Exception -> 0x01e9, NullPointerException -> 0x01e4, all -> 0x01d8 }
        r3 = "";
        r0 = r0.append(r3);	 Catch:{ Exception -> 0x01e9, NullPointerException -> 0x01e4, all -> 0x01d8 }
        r3 = r13.getContentResolver();	 Catch:{ Exception -> 0x01e9, NullPointerException -> 0x01e4, all -> 0x01d8 }
        r4 = "android_id";
        r3 = android.provider.Settings.Secure.getString(r3, r4);	 Catch:{ Exception -> 0x01e9, NullPointerException -> 0x01e4, all -> 0x01d8 }
        r0 = r0.append(r3);	 Catch:{ Exception -> 0x01e9, NullPointerException -> 0x01e4, all -> 0x01d8 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x01e9, NullPointerException -> 0x01e4, all -> 0x01d8 }
        i = r0;	 Catch:{ Exception -> 0x01e9, NullPointerException -> 0x01e4, all -> 0x01d8 }
    L_0x0045:
        r0 = h;	 Catch:{ NullPointerException -> 0x01e4, Exception -> 0x01e1, all -> 0x01d8 }
        if (r0 != 0) goto L_0x005c;
    L_0x0049:
        r0 = "wifi";
        r0 = r13.getSystemService(r0);	 Catch:{ NullPointerException -> 0x01e4, Exception -> 0x01e1, all -> 0x01d8 }
        r0 = (android.net.wifi.WifiManager) r0;	 Catch:{ NullPointerException -> 0x01e4, Exception -> 0x01e1, all -> 0x01d8 }
        r0 = r0.getConnectionInfo();	 Catch:{ NullPointerException -> 0x01e4, Exception -> 0x01e1, all -> 0x01d8 }
        r0 = r0.getMacAddress();	 Catch:{ NullPointerException -> 0x01e4, Exception -> 0x01e1, all -> 0x01d8 }
        h = r0;	 Catch:{ NullPointerException -> 0x01e4, Exception -> 0x01e1, all -> 0x01d8 }
    L_0x005c:
        r0 = com.vlocker.b.o.noNetStatus;	 Catch:{ NullPointerException -> 0x01e4, Exception -> 0x01e1, all -> 0x01d8 }
        if (r7 != r0) goto L_0x0062;
    L_0x0060:
        monitor-exit(r5);
        return r2;
    L_0x0062:
        r0 = r13.getPackageManager();	 Catch:{ UnsupportedEncodingException -> 0x01c0, ClientProtocolException -> 0x01c9, IOException -> 0x01d2, Exception -> 0x01db, NullPointerException -> 0x01c6, all -> 0x01d8 }
        r4 = 0;
        r3 = r13.getPackageName();	 Catch:{ NameNotFoundException -> 0x01a8 }
        r8 = 0;
        r0 = r0.getPackageInfo(r3, r8);	 Catch:{ NameNotFoundException -> 0x01a8 }
        r3 = r0.versionCode;	 Catch:{ NameNotFoundException -> 0x01a8 }
        r0 = r0.versionName;	 Catch:{ NameNotFoundException -> 0x01e7 }
        r4 = r3;
        r3 = r0;
    L_0x0076:
        r0 = j;	 Catch:{ UnsupportedEncodingException -> 0x01c0, ClientProtocolException -> 0x01c9, IOException -> 0x01d2, Exception -> 0x01db, NullPointerException -> 0x01c6, all -> 0x01d8 }
        if (r0 >= r1) goto L_0x008f;
    L_0x007a:
        r0 = new android.util.DisplayMetrics;	 Catch:{ UnsupportedEncodingException -> 0x01c0, ClientProtocolException -> 0x01c9, IOException -> 0x01d2, Exception -> 0x01db, NullPointerException -> 0x01c6, all -> 0x01d8 }
        r0.<init>();	 Catch:{ UnsupportedEncodingException -> 0x01c0, ClientProtocolException -> 0x01c9, IOException -> 0x01d2, Exception -> 0x01db, NullPointerException -> 0x01c6, all -> 0x01d8 }
        r0 = r13.getResources();	 Catch:{ UnsupportedEncodingException -> 0x01c0, ClientProtocolException -> 0x01c9, IOException -> 0x01d2, Exception -> 0x01db, NullPointerException -> 0x01c6, all -> 0x01d8 }
        r0 = r0.getDisplayMetrics();	 Catch:{ UnsupportedEncodingException -> 0x01c0, ClientProtocolException -> 0x01c9, IOException -> 0x01d2, Exception -> 0x01db, NullPointerException -> 0x01c6, all -> 0x01d8 }
        r8 = r0.widthPixels;	 Catch:{ UnsupportedEncodingException -> 0x01c0, ClientProtocolException -> 0x01c9, IOException -> 0x01d2, Exception -> 0x01db, NullPointerException -> 0x01c6, all -> 0x01d8 }
        j = r8;	 Catch:{ UnsupportedEncodingException -> 0x01c0, ClientProtocolException -> 0x01c9, IOException -> 0x01d2, Exception -> 0x01db, NullPointerException -> 0x01c6, all -> 0x01d8 }
        r0 = r0.heightPixels;	 Catch:{ UnsupportedEncodingException -> 0x01c0, ClientProtocolException -> 0x01c9, IOException -> 0x01d2, Exception -> 0x01db, NullPointerException -> 0x01c6, all -> 0x01d8 }
        k = r0;	 Catch:{ UnsupportedEncodingException -> 0x01c0, ClientProtocolException -> 0x01c9, IOException -> 0x01d2, Exception -> 0x01db, NullPointerException -> 0x01c6, all -> 0x01d8 }
    L_0x008f:
        r0 = 2131296842; // 0x7f09024a float:1.8211612E38 double:1.0530005507E-314;
        r0 = r13.getString(r0);	 Catch:{ NotFoundException -> 0x01b2, Exception -> 0x01b8, UnsupportedEncodingException -> 0x01c0, ClientProtocolException -> 0x01c9, IOException -> 0x01d2, NullPointerException -> 0x01c6, all -> 0x01d8 }
    L_0x0096:
        r8 = new com.vlocker.m.ai;	 Catch:{ UnsupportedEncodingException -> 0x01c0, ClientProtocolException -> 0x01c9, IOException -> 0x01d2, Exception -> 0x01db, NullPointerException -> 0x01c6, all -> 0x01d8 }
        r8.<init>();	 Catch:{ UnsupportedEncodingException -> 0x01c0, ClientProtocolException -> 0x01c9, IOException -> 0x01d2, Exception -> 0x01db, NullPointerException -> 0x01c6, all -> 0x01d8 }
        r9 = "imei";
        r10 = g;	 Catch:{ UnsupportedEncodingException -> 0x01c0, ClientProtocolException -> 0x01c9, IOException -> 0x01d2, Exception -> 0x01db, NullPointerException -> 0x01c6, all -> 0x01d8 }
        r8.put(r9, r10);	 Catch:{ UnsupportedEncodingException -> 0x01c0, ClientProtocolException -> 0x01c9, IOException -> 0x01d2, Exception -> 0x01db, NullPointerException -> 0x01c6, all -> 0x01d8 }
        r9 = "model";
        r10 = android.os.Build.MODEL;	 Catch:{ UnsupportedEncodingException -> 0x01c0, ClientProtocolException -> 0x01c9, IOException -> 0x01d2, Exception -> 0x01db, NullPointerException -> 0x01c6, all -> 0x01d8 }
        r8.put(r9, r10);	 Catch:{ UnsupportedEncodingException -> 0x01c0, ClientProtocolException -> 0x01c9, IOException -> 0x01d2, Exception -> 0x01db, NullPointerException -> 0x01c6, all -> 0x01d8 }
        r9 = "manufacturer";
        r10 = android.os.Build.MANUFACTURER;	 Catch:{ UnsupportedEncodingException -> 0x01c0, ClientProtocolException -> 0x01c9, IOException -> 0x01d2, Exception -> 0x01db, NullPointerException -> 0x01c6, all -> 0x01d8 }
        r8.put(r9, r10);	 Catch:{ UnsupportedEncodingException -> 0x01c0, ClientProtocolException -> 0x01c9, IOException -> 0x01d2, Exception -> 0x01db, NullPointerException -> 0x01c6, all -> 0x01d8 }
        r9 = "androidsdk";
        r10 = android.os.Build.VERSION.SDK_INT;	 Catch:{ UnsupportedEncodingException -> 0x01c0, ClientProtocolException -> 0x01c9, IOException -> 0x01d2, Exception -> 0x01db, NullPointerException -> 0x01c6, all -> 0x01d8 }
        r8.put(r9, r10);	 Catch:{ UnsupportedEncodingException -> 0x01c0, ClientProtocolException -> 0x01c9, IOException -> 0x01d2, Exception -> 0x01db, NullPointerException -> 0x01c6, all -> 0x01d8 }
        r9 = "display";
        r10 = new java.lang.StringBuilder;	 Catch:{ UnsupportedEncodingException -> 0x01c0, ClientProtocolException -> 0x01c9, IOException -> 0x01d2, Exception -> 0x01db, NullPointerException -> 0x01c6, all -> 0x01d8 }
        r10.<init>();	 Catch:{ UnsupportedEncodingException -> 0x01c0, ClientProtocolException -> 0x01c9, IOException -> 0x01d2, Exception -> 0x01db, NullPointerException -> 0x01c6, all -> 0x01d8 }
        r11 = j;	 Catch:{ UnsupportedEncodingException -> 0x01c0, ClientProtocolException -> 0x01c9, IOException -> 0x01d2, Exception -> 0x01db, NullPointerException -> 0x01c6, all -> 0x01d8 }
        r10 = r10.append(r11);	 Catch:{ UnsupportedEncodingException -> 0x01c0, ClientProtocolException -> 0x01c9, IOException -> 0x01d2, Exception -> 0x01db, NullPointerException -> 0x01c6, all -> 0x01d8 }
        r11 = "*";
        r10 = r10.append(r11);	 Catch:{ UnsupportedEncodingException -> 0x01c0, ClientProtocolException -> 0x01c9, IOException -> 0x01d2, Exception -> 0x01db, NullPointerException -> 0x01c6, all -> 0x01d8 }
        r11 = k;	 Catch:{ UnsupportedEncodingException -> 0x01c0, ClientProtocolException -> 0x01c9, IOException -> 0x01d2, Exception -> 0x01db, NullPointerException -> 0x01c6, all -> 0x01d8 }
        r10 = r10.append(r11);	 Catch:{ UnsupportedEncodingException -> 0x01c0, ClientProtocolException -> 0x01c9, IOException -> 0x01d2, Exception -> 0x01db, NullPointerException -> 0x01c6, all -> 0x01d8 }
        r10 = r10.toString();	 Catch:{ UnsupportedEncodingException -> 0x01c0, ClientProtocolException -> 0x01c9, IOException -> 0x01d2, Exception -> 0x01db, NullPointerException -> 0x01c6, all -> 0x01d8 }
        r8.put(r9, r10);	 Catch:{ UnsupportedEncodingException -> 0x01c0, ClientProtocolException -> 0x01c9, IOException -> 0x01d2, Exception -> 0x01db, NullPointerException -> 0x01c6, all -> 0x01d8 }
        r9 = "install";
        r10 = com.vlocker.c.a.a(r13);	 Catch:{ UnsupportedEncodingException -> 0x01c0, ClientProtocolException -> 0x01c9, IOException -> 0x01d2, Exception -> 0x01db, NullPointerException -> 0x01c6, all -> 0x01d8 }
        r10 = r10.M();	 Catch:{ UnsupportedEncodingException -> 0x01c0, ClientProtocolException -> 0x01c9, IOException -> 0x01d2, Exception -> 0x01db, NullPointerException -> 0x01c6, all -> 0x01d8 }
        r8.put(r9, r10);	 Catch:{ UnsupportedEncodingException -> 0x01c0, ClientProtocolException -> 0x01c9, IOException -> 0x01d2, Exception -> 0x01db, NullPointerException -> 0x01c6, all -> 0x01d8 }
        r9 = "child";
        r8.put(r9, r0);	 Catch:{ UnsupportedEncodingException -> 0x01c0, ClientProtocolException -> 0x01c9, IOException -> 0x01d2, Exception -> 0x01db, NullPointerException -> 0x01c6, all -> 0x01d8 }
        r0 = "timestamp";
        r10 = java.lang.System.currentTimeMillis();	 Catch:{ UnsupportedEncodingException -> 0x01c0, ClientProtocolException -> 0x01c9, IOException -> 0x01d2, Exception -> 0x01db, NullPointerException -> 0x01c6, all -> 0x01d8 }
        r8.put(r0, r10);	 Catch:{ UnsupportedEncodingException -> 0x01c0, ClientProtocolException -> 0x01c9, IOException -> 0x01d2, Exception -> 0x01db, NullPointerException -> 0x01c6, all -> 0x01d8 }
        r0 = "net";
        r8.put(r0, r7);	 Catch:{ UnsupportedEncodingException -> 0x01c0, ClientProtocolException -> 0x01c9, IOException -> 0x01d2, Exception -> 0x01db, NullPointerException -> 0x01c6, all -> 0x01d8 }
        r0 = "mac";
        r7 = h;	 Catch:{ UnsupportedEncodingException -> 0x01c0, ClientProtocolException -> 0x01c9, IOException -> 0x01d2, Exception -> 0x01db, NullPointerException -> 0x01c6, all -> 0x01d8 }
        r8.put(r0, r7);	 Catch:{ UnsupportedEncodingException -> 0x01c0, ClientProtocolException -> 0x01c9, IOException -> 0x01d2, Exception -> 0x01db, NullPointerException -> 0x01c6, all -> 0x01d8 }
        r0 = "androidid";
        r7 = i;	 Catch:{ UnsupportedEncodingException -> 0x01c0, ClientProtocolException -> 0x01c9, IOException -> 0x01d2, Exception -> 0x01db, NullPointerException -> 0x01c6, all -> 0x01d8 }
        r8.put(r0, r7);	 Catch:{ UnsupportedEncodingException -> 0x01c0, ClientProtocolException -> 0x01c9, IOException -> 0x01d2, Exception -> 0x01db, NullPointerException -> 0x01c6, all -> 0x01d8 }
        r0 = "ipaddr";
        r7 = f();	 Catch:{ UnsupportedEncodingException -> 0x01c0, ClientProtocolException -> 0x01c9, IOException -> 0x01d2, Exception -> 0x01db, NullPointerException -> 0x01c6, all -> 0x01d8 }
        r8.put(r0, r7);	 Catch:{ UnsupportedEncodingException -> 0x01c0, ClientProtocolException -> 0x01c9, IOException -> 0x01d2, Exception -> 0x01db, NullPointerException -> 0x01c6, all -> 0x01d8 }
        r0 = "ver";
        r8.put(r0, r3);	 Catch:{ UnsupportedEncodingException -> 0x01c0, ClientProtocolException -> 0x01c9, IOException -> 0x01d2, Exception -> 0x01db, NullPointerException -> 0x01c6, all -> 0x01d8 }
        r0 = "vcode";
        r8.put(r0, r4);	 Catch:{ UnsupportedEncodingException -> 0x01c0, ClientProtocolException -> 0x01c9, IOException -> 0x01d2, Exception -> 0x01db, NullPointerException -> 0x01c6, all -> 0x01d8 }
        r0 = new com.vlocker.m.ah;	 Catch:{ UnsupportedEncodingException -> 0x01c0, ClientProtocolException -> 0x01c9, IOException -> 0x01d2, Exception -> 0x01db, NullPointerException -> 0x01c6, all -> 0x01d8 }
        r0.<init>();	 Catch:{ UnsupportedEncodingException -> 0x01c0, ClientProtocolException -> 0x01c9, IOException -> 0x01d2, Exception -> 0x01db, NullPointerException -> 0x01c6, all -> 0x01d8 }
        r0.put(r14);	 Catch:{ UnsupportedEncodingException -> 0x01c0, ClientProtocolException -> 0x01c9, IOException -> 0x01d2, Exception -> 0x01db, NullPointerException -> 0x01c6, all -> 0x01d8 }
        r3 = new com.vlocker.m.ai;	 Catch:{ UnsupportedEncodingException -> 0x01c0, ClientProtocolException -> 0x01c9, IOException -> 0x01d2, Exception -> 0x01db, NullPointerException -> 0x01c6, all -> 0x01d8 }
        r3.<init>();	 Catch:{ UnsupportedEncodingException -> 0x01c0, ClientProtocolException -> 0x01c9, IOException -> 0x01d2, Exception -> 0x01db, NullPointerException -> 0x01c6, all -> 0x01d8 }
        r4 = "base";
        r3.put(r4, r8);	 Catch:{ UnsupportedEncodingException -> 0x01c0, ClientProtocolException -> 0x01c9, IOException -> 0x01d2, Exception -> 0x01db, NullPointerException -> 0x01c6, all -> 0x01d8 }
        r4 = "content";
        r3.put(r4, r0);	 Catch:{ UnsupportedEncodingException -> 0x01c0, ClientProtocolException -> 0x01c9, IOException -> 0x01d2, Exception -> 0x01db, NullPointerException -> 0x01c6, all -> 0x01d8 }
        r0 = java.lang.String.valueOf(r3);	 Catch:{ UnsupportedEncodingException -> 0x01c0, ClientProtocolException -> 0x01c9, IOException -> 0x01d2, Exception -> 0x01db, NullPointerException -> 0x01c6, all -> 0x01d8 }
        r0 = com.vlocker.b.g.a(r0, r15);	 Catch:{ UnsupportedEncodingException -> 0x01c0, ClientProtocolException -> 0x01c9, IOException -> 0x01d2, Exception -> 0x01db, NullPointerException -> 0x01c6, all -> 0x01d8 }
        if (r0 == 0) goto L_0x014e;
    L_0x014a:
        r0 = a(r0);	 Catch:{ UnsupportedEncodingException -> 0x01c0, ClientProtocolException -> 0x01c9, IOException -> 0x01d2, Exception -> 0x01db, NullPointerException -> 0x01c6, all -> 0x01d8 }
    L_0x014e:
        r3 = r6.length;	 Catch:{ UnsupportedEncodingException -> 0x01c0, ClientProtocolException -> 0x01c9, IOException -> 0x01d2, Exception -> 0x01db, NullPointerException -> 0x01c6, all -> 0x01d8 }
        r4 = r0.length;	 Catch:{ UnsupportedEncodingException -> 0x01c0, ClientProtocolException -> 0x01c9, IOException -> 0x01d2, Exception -> 0x01db, NullPointerException -> 0x01c6, all -> 0x01d8 }
        r3 = a(r6, r3, r0, r4);	 Catch:{ UnsupportedEncodingException -> 0x01c0, ClientProtocolException -> 0x01c9, IOException -> 0x01d2, Exception -> 0x01db, NullPointerException -> 0x01c6, all -> 0x01d8 }
        r0 = new java.net.URL;	 Catch:{ UnsupportedEncodingException -> 0x01c0, ClientProtocolException -> 0x01c9, IOException -> 0x01d2, Exception -> 0x01db, NullPointerException -> 0x01c6, all -> 0x01d8 }
        r4 = "http://alc.imoxiu.com/collect/?app=556d0b43bb4d9b3c7a8b4567&key=557a53660183a2a37d66e390c3995424";
        r0.<init>(r4);	 Catch:{ UnsupportedEncodingException -> 0x01c0, ClientProtocolException -> 0x01c9, IOException -> 0x01d2, Exception -> 0x01db, NullPointerException -> 0x01c6, all -> 0x01d8 }
        r0 = r0.openConnection();	 Catch:{ UnsupportedEncodingException -> 0x01c0, ClientProtocolException -> 0x01c9, IOException -> 0x01d2, Exception -> 0x01db, NullPointerException -> 0x01c6, all -> 0x01d8 }
        r0 = (java.net.HttpURLConnection) r0;	 Catch:{ UnsupportedEncodingException -> 0x01c0, ClientProtocolException -> 0x01c9, IOException -> 0x01d2, Exception -> 0x01db, NullPointerException -> 0x01c6, all -> 0x01d8 }
        r4 = 5000; // 0x1388 float:7.006E-42 double:2.4703E-320;
        r0.setConnectTimeout(r4);	 Catch:{ UnsupportedEncodingException -> 0x01c0, ClientProtocolException -> 0x01c9, IOException -> 0x01d2, Exception -> 0x01db, NullPointerException -> 0x01c6, all -> 0x01d8 }
        r4 = "POST";
        r0.setRequestMethod(r4);	 Catch:{ UnsupportedEncodingException -> 0x01c0, ClientProtocolException -> 0x01c9, IOException -> 0x01d2, Exception -> 0x01db, NullPointerException -> 0x01c6, all -> 0x01d8 }
        r4 = "Content-Type";
        r6 = "application/x-www-form-urlencoded";
        r0.setRequestProperty(r4, r6);	 Catch:{ UnsupportedEncodingException -> 0x01c0, ClientProtocolException -> 0x01c9, IOException -> 0x01d2, Exception -> 0x01db, NullPointerException -> 0x01c6, all -> 0x01d8 }
        r4 = "Content-Length";
        r6 = new java.lang.StringBuilder;	 Catch:{ UnsupportedEncodingException -> 0x01c0, ClientProtocolException -> 0x01c9, IOException -> 0x01d2, Exception -> 0x01db, NullPointerException -> 0x01c6, all -> 0x01d8 }
        r6.<init>();	 Catch:{ UnsupportedEncodingException -> 0x01c0, ClientProtocolException -> 0x01c9, IOException -> 0x01d2, Exception -> 0x01db, NullPointerException -> 0x01c6, all -> 0x01d8 }
        r7 = r3.length;	 Catch:{ UnsupportedEncodingException -> 0x01c0, ClientProtocolException -> 0x01c9, IOException -> 0x01d2, Exception -> 0x01db, NullPointerException -> 0x01c6, all -> 0x01d8 }
        r6 = r6.append(r7);	 Catch:{ UnsupportedEncodingException -> 0x01c0, ClientProtocolException -> 0x01c9, IOException -> 0x01d2, Exception -> 0x01db, NullPointerException -> 0x01c6, all -> 0x01d8 }
        r7 = "";
        r6 = r6.append(r7);	 Catch:{ UnsupportedEncodingException -> 0x01c0, ClientProtocolException -> 0x01c9, IOException -> 0x01d2, Exception -> 0x01db, NullPointerException -> 0x01c6, all -> 0x01d8 }
        r6 = r6.toString();	 Catch:{ UnsupportedEncodingException -> 0x01c0, ClientProtocolException -> 0x01c9, IOException -> 0x01d2, Exception -> 0x01db, NullPointerException -> 0x01c6, all -> 0x01d8 }
        r0.setRequestProperty(r4, r6);	 Catch:{ UnsupportedEncodingException -> 0x01c0, ClientProtocolException -> 0x01c9, IOException -> 0x01d2, Exception -> 0x01db, NullPointerException -> 0x01c6, all -> 0x01d8 }
        r4 = 1;
        r0.setDoOutput(r4);	 Catch:{ UnsupportedEncodingException -> 0x01c0, ClientProtocolException -> 0x01c9, IOException -> 0x01d2, Exception -> 0x01db, NullPointerException -> 0x01c6, all -> 0x01d8 }
        r4 = r0.getOutputStream();	 Catch:{ UnsupportedEncodingException -> 0x01c0, ClientProtocolException -> 0x01c9, IOException -> 0x01d2, Exception -> 0x01db, NullPointerException -> 0x01c6, all -> 0x01d8 }
        r4.write(r3);	 Catch:{ UnsupportedEncodingException -> 0x01c0, ClientProtocolException -> 0x01c9, IOException -> 0x01d2, Exception -> 0x01db, NullPointerException -> 0x01c6, all -> 0x01d8 }
        r0 = r0.getResponseCode();	 Catch:{ UnsupportedEncodingException -> 0x01c0, ClientProtocolException -> 0x01c9, IOException -> 0x01d2, Exception -> 0x01db, NullPointerException -> 0x01c6, all -> 0x01d8 }
        r3 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r0 != r3) goto L_0x01be;
    L_0x01a4:
        r0 = r1;
    L_0x01a5:
        r2 = r0;
        goto L_0x0060;
    L_0x01a8:
        r0 = move-exception;
        r3 = r2;
    L_0x01aa:
        r0.printStackTrace();	 Catch:{ UnsupportedEncodingException -> 0x01c0, ClientProtocolException -> 0x01c9, IOException -> 0x01d2, Exception -> 0x01db, NullPointerException -> 0x01c6, all -> 0x01d8 }
        r12 = r4;
        r4 = r3;
        r3 = r12;
        goto L_0x0076;
    L_0x01b2:
        r0 = move-exception;
        r0 = "new-moxiulauncher";
        goto L_0x0096;
    L_0x01b8:
        r0 = move-exception;
        r0 = "new-moxiulauncher";
        goto L_0x0096;
    L_0x01be:
        r0 = r2;
        goto L_0x01a5;
    L_0x01c0:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ NullPointerException -> 0x01c6, Exception -> 0x01cf, all -> 0x01d8 }
        goto L_0x0060;
    L_0x01c6:
        r0 = move-exception;
        goto L_0x0060;
    L_0x01c9:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ NullPointerException -> 0x01c6, Exception -> 0x01cf, all -> 0x01d8 }
        goto L_0x0060;
    L_0x01cf:
        r0 = move-exception;
        goto L_0x0060;
    L_0x01d2:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ NullPointerException -> 0x01c6, Exception -> 0x01cf, all -> 0x01d8 }
        goto L_0x0060;
    L_0x01d8:
        r0 = move-exception;
        monitor-exit(r5);
        throw r0;
    L_0x01db:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ NullPointerException -> 0x01c6, Exception -> 0x01cf, all -> 0x01d8 }
        goto L_0x0060;
    L_0x01e1:
        r0 = move-exception;
        goto L_0x0060;
    L_0x01e4:
        r0 = move-exception;
        goto L_0x0060;
    L_0x01e7:
        r0 = move-exception;
        goto L_0x01aa;
    L_0x01e9:
        r0 = move-exception;
        goto L_0x0045;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vlocker.b.j.a(android.content.Context, org.json.JSONObject, java.lang.String):boolean");
    }

    public static boolean a(WindowManager windowManager) {
        if (VERSION.SDK_INT < 19 || windowManager == null) {
            return false;
        }
        Display defaultDisplay = windowManager.getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getRealMetrics(displayMetrics);
        int i = displayMetrics.heightPixels;
        int i2 = displayMetrics.widthPixels;
        DisplayMetrics displayMetrics2 = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics2);
        int i3 = displayMetrics2.heightPixels;
        int i4 = displayMetrics2.widthPixels;
        l = i - i3;
        return i2 - i4 > 0 || i - i3 > 0;
    }

    public static boolean a(String str, int i) {
        return str != null && i >= 0 && str.length() > i && str.charAt(i) == '1';
    }

    public static byte[] a(byte[] bArr) {
        InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            a(byteArrayInputStream, byteArrayOutputStream);
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.flush();
            byteArrayOutputStream.close();
            byteArrayInputStream.close();
            return toByteArray;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
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

    public static View b(Context context, int i) {
        return View.inflate(context, i, null);
    }

    public static o b(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null) {
            try {
                NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
                if (networkInfo != null && networkInfo.getState() == State.CONNECTED) {
                    return o.wifiNetStatus;
                }
                NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
                if (networkInfo2 != null && networkInfo2.getState() == State.CONNECTED) {
                    return c(context) ? o.threeGNetStatus : o.twoGNetStatus;
                }
            } catch (Exception e) {
            }
        }
        return o.noNetStatus;
    }

    public static String b() {
        return "http://soft.vlocker.cn/json.php?do=Update";
    }

    public static boolean b(Context context, String str) {
        if (str == null || "".equals(str)) {
            return false;
        }
        try {
            context.getPackageManager().getApplicationInfo(str, 8192);
            return true;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    public static boolean b(String str) {
        String a = a(str);
        if (a.matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}")) {
            String[] split = a.split("\\.");
            if (Integer.parseInt(split[0]) < 255 && Integer.parseInt(split[1]) < 255 && Integer.parseInt(split[2]) < 255 && Integer.parseInt(split[3]) < 255) {
                return true;
            }
        }
        return false;
    }

    public static int c(String str) {
        int i;
        if (str != null) {
            try {
                Vector vector = new Vector();
                for (i = 0; i < str.length(); i++) {
                    if (str.substring(i, i + 1).equals("1")) {
                        vector.add("" + i);
                    }
                }
                if (vector.size() > 0) {
                    i = Integer.parseInt((String) vector.elementAt((int) (Math.random() * ((double) vector.size()))));
                    return i;
                }
            } catch (Exception e) {
                return -1;
            }
        }
        i = -1;
        return i;
    }

    public static String c() {
        return "http://mobile.moxiu.com/misc/?do=Vlocker.Ths";
    }

    public static boolean c(Context context) {
        switch (((TelephonyManager) context.getSystemService("phone")).getNetworkType()) {
            case 0:
                return false;
            case 1:
                return false;
            case 2:
                return false;
            case 3:
                return true;
            case 4:
                return false;
            case 5:
                return true;
            case 6:
                return true;
            case 7:
                return false;
            case 8:
                return true;
            case 9:
                return true;
            case 10:
                return true;
            case 11:
                return false;
            case 12:
                return true;
            case 13:
                return true;
            case IMediaObject.TYPE_OLD_TV /*14*/:
                return true;
            case 15:
                return true;
            default:
                return false;
        }
    }

    public static String d() {
        return i.e + "json.php?do=Weather.Detail";
    }

    public static String d(Context context) {
        String str;
        String str2;
        String str3;
        TelephonyManager telephonyManager;
        String str4;
        String str5;
        UUID uuid;
        int i;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            Enumeration networkInterfaces = NetworkInterface.getNetworkInterfaces();
            str = null;
            boolean z = false;
            while (networkInterfaces.hasMoreElements()) {
                try {
                    Enumeration inetAddresses = ((NetworkInterface) networkInterfaces.nextElement()).getInetAddresses();
                    boolean z2 = z;
                    str2 = str;
                    boolean z3 = z2;
                    while (inetAddresses.hasMoreElements()) {
                        try {
                            boolean z4;
                            InetAddress inetAddress = (InetAddress) inetAddresses.nextElement();
                            if (inetAddress.isLoopbackAddress()) {
                                z4 = z3;
                                str = str2;
                            } else {
                                str2 = inetAddress.getHostAddress().toString();
                                try {
                                    z4 = b(str2);
                                } catch (Exception e) {
                                    z4 = z3;
                                } catch (SocketException e2) {
                                    str3 = str2;
                                }
                                if (z4) {
                                    z3 = z4;
                                    str3 = str2;
                                    break;
                                }
                                str = str2;
                            }
                            str2 = str;
                            z3 = z4;
                        } catch (SocketException e22) {
                            str3 = str2;
                        } catch (Exception e3) {
                            str3 = str2;
                        }
                    }
                    str3 = str2;
                    if (z3) {
                        break;
                    }
                    z = z3;
                    str = str3;
                } catch (SocketException e4) {
                    str3 = str;
                } catch (Exception e5) {
                    str3 = str;
                }
            }
            str3 = str;
            str = str3;
        } catch (SocketException e6) {
            str3 = null;
            str = str3;
            Secure.getString(context.getContentResolver(), "android_id");
            telephonyManager = (TelephonyManager) context.getSystemService("phone");
            str4 = "" + telephonyManager.getDeviceId();
            str3 = "" + telephonyManager.getSimSerialNumber();
            str5 = "" + Secure.getString(context.getContentResolver(), "android_id");
            uuid = new UUID((long) str5.hashCode(), (((long) str4.hashCode()) << 32) | ((long) str3.hashCode()));
            i = 0;
            i = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
            str2 = "vlocker";
            if (c != null) {
                str2 = c;
            }
            b = "timestamp=" + currentTimeMillis + "&ipaddr=" + str + "&aid=" + str5 + "&imei=" + str4 + "&ver=" + i + "&cn=" + str2 + "&cl=" + context.getResources().getConfiguration().locale.toString() + "&apilevel=" + VERSION.SDK_INT + "&brand=" + Build.BRAND + "&model=" + Build.MODEL + "&root=0&mac=" + uuid.toString() + "\r\n";
            return b;
        } catch (Exception e7) {
            str3 = null;
            str = str3;
            Secure.getString(context.getContentResolver(), "android_id");
            telephonyManager = (TelephonyManager) context.getSystemService("phone");
            str4 = "" + telephonyManager.getDeviceId();
            str3 = "" + telephonyManager.getSimSerialNumber();
            str5 = "" + Secure.getString(context.getContentResolver(), "android_id");
            uuid = new UUID((long) str5.hashCode(), (((long) str4.hashCode()) << 32) | ((long) str3.hashCode()));
            i = 0;
            i = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
            str2 = "vlocker";
            if (c != null) {
                str2 = c;
            }
            b = "timestamp=" + currentTimeMillis + "&ipaddr=" + str + "&aid=" + str5 + "&imei=" + str4 + "&ver=" + i + "&cn=" + str2 + "&cl=" + context.getResources().getConfiguration().locale.toString() + "&apilevel=" + VERSION.SDK_INT + "&brand=" + Build.BRAND + "&model=" + Build.MODEL + "&root=0&mac=" + uuid.toString() + "\r\n";
            return b;
        }
        try {
            Secure.getString(context.getContentResolver(), "android_id");
        } catch (Exception e8) {
        }
        telephonyManager = (TelephonyManager) context.getSystemService("phone");
        str4 = "" + telephonyManager.getDeviceId();
        str3 = "" + telephonyManager.getSimSerialNumber();
        str5 = "" + Secure.getString(context.getContentResolver(), "android_id");
        uuid = new UUID((long) str5.hashCode(), (((long) str4.hashCode()) << 32) | ((long) str3.hashCode()));
        i = 0;
        try {
            i = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Exception e9) {
            e9.printStackTrace();
        }
        str2 = "vlocker";
        try {
            if (c != null) {
                str2 = c;
            }
        } catch (Exception e10) {
        }
        b = "timestamp=" + currentTimeMillis + "&ipaddr=" + str + "&aid=" + str5 + "&imei=" + str4 + "&ver=" + i + "&cn=" + str2 + "&cl=" + context.getResources().getConfiguration().locale.toString() + "&apilevel=" + VERSION.SDK_INT + "&brand=" + Build.BRAND + "&model=" + Build.MODEL + "&root=0&mac=" + uuid.toString() + "\r\n";
        return b;
    }

    public static String d(String str) {
        return str.replace(" ", "");
    }

    public static String e() {
        return "http://iccp.moxiu.com/json.php?do=Fortune&zodiac=";
    }

    public static boolean e(Context context) {
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            int intValue = ((Integer) PowerManager.class.getDeclaredField("PROXIMITY_SCREEN_OFF_WAKE_LOCK").get(null)).intValue();
            if (VERSION.SDK_INT < 17) {
                return (((Integer) powerManager.getClass().getDeclaredMethod("getSupportedWakeLockFlags", new Class[0]).invoke(powerManager, new Object[0])).intValue() & intValue) != 0;
            } else {
                return ((Boolean) powerManager.getClass().getDeclaredMethod("isWakeLockLevelSupported", new Class[]{Integer.TYPE}).invoke(powerManager, new Object[]{Integer.valueOf(intValue)})).booleanValue();
            }
        } catch (Exception e) {
            return false;
        }
    }

    public static String f() {
        try {
            Iterator it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
            while (it.hasNext()) {
                Iterator it2 = Collections.list(((NetworkInterface) it.next()).getInetAddresses()).iterator();
                while (it2.hasNext()) {
                    InetAddress inetAddress = (InetAddress) it2.next();
                    if (!inetAddress.isLoopbackAddress()) {
                        String hostAddress = inetAddress.getHostAddress();
                        if (InetAddressUtils.isIPv4Address(hostAddress)) {
                            return hostAddress;
                        }
                    }
                }
            }
        } catch (SocketException e) {
        } catch (Exception e2) {
        }
        return null;
    }

    public static boolean f(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return false;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return false;
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        return telephonyManager == null ? false : (telephonyManager.getDataState() == 2 || telephonyManager.getDataState() == 0) && activeNetworkInfo != null;
    }

    public static int g() {
        return l;
    }

    public static boolean g(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return false;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return false;
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        return telephonyManager == null ? false : ((telephonyManager.getDataState() == 2 || telephonyManager.getDataState() == 0) && activeNetworkInfo != null) ? a(activeNetworkInfo.getType(), telephonyManager.getNetworkType()) : false;
    }

    public static Boolean h(Context context) {
        try {
            if (State.CONNECTED == ((ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(1).getState()) {
                return Boolean.valueOf(true);
            }
        } catch (Exception e) {
        }
        return Boolean.valueOf(false);
    }

    public static boolean h() {
        return VERSION.SDK_INT >= 11;
    }

    public static int i() {
        return (!"Xiaomi".equals(Build.MANUFACTURER) || f <= 15) ? (!"Xiaomi".equals(Build.MANUFACTURER) || f > 15) ? f < 14 ? 2 : f >= 21 ? "LENOVO".equals(Build.MANUFACTURER) ? 6 : ("BBK".equals(Build.MANUFACTURER) || "vivo".equals(Build.MANUFACTURER)) ? 7 : 5 : f >= 14 ? 3 : 4 : 1 : 0;
    }

    public static boolean i(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        } catch (Exception e) {
            return false;
        }
    }

    public static String j(Context context) {
        String deviceId;
        try {
            deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        } catch (Exception e) {
            deviceId = null;
        }
        if (deviceId != null) {
            return deviceId;
        }
        int pow = (int) Math.pow(10.0d, 14.0d);
        return (pow + new Random().nextInt(pow)) + "";
    }

    public static void j() {
        Thread lVar = new l();
        lVar.setPriority(3);
        lVar.start();
    }

    public static String k(Context context) {
        int i = 0;
        try {
            i = context.getApplicationContext().getPackageManager().getPackageInfo(context.getApplicationContext().getPackageName(), 0).versionCode;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        } catch (OutOfMemoryError e2) {
        }
        return i + "";
    }

    public static void k() {
        new Thread(new n()).start();
    }

    public static String l() {
        return "http://mobile.moxiu.com/misc/?do=Vlocker.Policy.Tos";
    }

    public static String l(Context context) {
        return VERSION.SDK_INT + "";
    }

    public static String m() {
        return "http://mobile.moxiu.com/misc/?do=Vlocker.Policy.Privacy";
    }

    public static void m(Context context) {
        if (i(MoSecurityApplication.a().getApplicationContext())) {
            a a = a.a(MoSecurityApplication.a().getApplicationContext());
            int bN = a.bN();
            int date = new Date().getDate();
            if (bN != date) {
                c.a(context.getApplicationContext());
                new m("json.php?do=Vlocker.Main&app=vlocker" + n(MoSecurityApplication.a().getApplicationContext()), a, context, date).start();
            }
        }
    }

    public static String n() {
        return "http://feedback.vlocker.cn/json.php?do=Collect";
    }

    public static String n(Context context) {
        if (j < 1) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            displayMetrics = context.getResources().getDisplayMetrics();
            j = displayMetrics.widthPixels;
            k = displayMetrics.heightPixels;
        }
        if (i == null) {
            try {
                i = "" + Secure.getString(context.getContentResolver(), "android_id");
            } catch (Exception e) {
            }
        }
        if (h == null) {
            try {
                h = ((WifiManager) context.getSystemService(IXAdSystemUtils.NT_WIFI)).getConnectionInfo().getMacAddress();
            } catch (Exception e2) {
            }
        }
        String d = e.d(context);
        String c = h.c();
        if (c == null) {
            c = "cn";
        }
        o b = b(context);
        String str = "";
        try {
            str = URLEncoder.encode(Build.MODEL, "utf-8");
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        return "&imei=" + d + "&channel=" + p(context) + "&language=" + c + "&version=" + o.b(context) + "&ver=" + o.a(context) + "&android_sdk=" + VERSION.SDK_INT + "&net=" + b + "&ipaddr=" + f() + "&display=" + j + "*" + k + "&timestamp=" + System.currentTimeMillis() + "&model=" + str + "&manufacturer=" + Build.MANUFACTURER + "&mac=" + h + "&androidID=" + i + "&source=unlock";
    }

    public static String o(Context context) {
        if (j < 1) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            displayMetrics = context.getResources().getDisplayMetrics();
            j = displayMetrics.widthPixels;
            k = displayMetrics.heightPixels;
        }
        if (i == null) {
            try {
                i = "" + Secure.getString(context.getContentResolver(), "android_id");
            } catch (Exception e) {
            }
        }
        if (h == null) {
            try {
                h = ((WifiManager) context.getSystemService(IXAdSystemUtils.NT_WIFI)).getConnectionInfo().getMacAddress();
            } catch (Exception e2) {
            }
        }
        String c = h.c();
        if (c == null) {
            c = "cn";
        }
        String str = "";
        try {
            str = URLEncoder.encode(Build.MODEL, "utf-8");
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        return "&channel=" + p(context) + "&language=" + c + "&ver=" + o.a(context) + "&ipaddr=" + f() + "&display=" + j + "*" + k + "&model=" + str + "&manufacturer=" + Build.MANUFACTURER + "&mac=" + h + "&androidID=" + i;
    }

    public static void o() {
        ArrayList a = aj.a(MoSecurityApplication.a(), "com.moxiu.launcher");
        if (a != null) {
            Iterator it = a.iterator();
            while (it.hasNext()) {
                a.a(MoSecurityApplication.a()).c((String) it.next(), true);
            }
        }
    }

    public static String p(Context context) {
        return (String) context.getResources().getText(R.string.t_market_theme_manager_child);
    }

    public static String q(Context context) {
        String str = "0";
        o r = r(context);
        return r.equals(o.noNetStatus) ? "0" : r.equals(o.twoGNetStatus) ? "2" : r.equals(o.threeGNetStatus) ? "3" : r.equals(o.fourNetStatus) ? "4" : r.equals(o.wifiNetStatus) ? "1" : str;
    }

    private static void q() {
        try {
            List runningAppProcesses = ((ActivityManager) MoSecurityApplication.a().getSystemService("activity")).getRunningAppProcesses();
            for (int i = 0; i < runningAppProcesses.size(); i++) {
                RunningAppProcessInfo runningAppProcessInfo = (RunningAppProcessInfo) runningAppProcesses.get(i);
                if (runningAppProcessInfo.processName.contains("remote")) {
                    Process.killProcess(runningAppProcessInfo.pid);
                    return;
                }
            }
        } catch (IndexOutOfBoundsException e) {
        } catch (SQLiteDiskIOException e2) {
        } catch (Exception e3) {
        }
    }

    public static o r(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null) {
            try {
                NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
                if (networkInfo != null && networkInfo.getState() == State.CONNECTED) {
                    return o.wifiNetStatus;
                }
                NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
                if (networkInfo2 != null && networkInfo2.getState() == State.CONNECTED) {
                    return ((TelephonyManager) context.getSystemService("phone")).getNetworkType() == 13 ? o.fourNetStatus : c(context) ? o.threeGNetStatus : o.twoGNetStatus;
                }
            } catch (Exception e) {
            }
        }
        return o.noNetStatus;
    }

    public static boolean s(Context context) {
        try {
            System.currentTimeMillis();
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
                if (networkInfo != null) {
                    State state = networkInfo.getState();
                    if (state == State.CONNECTED || state == State.CONNECTING) {
                        System.currentTimeMillis();
                        return true;
                    }
                }
                NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
                if (networkInfo2 != null) {
                    State state2 = networkInfo2.getState();
                    if (state2 == State.CONNECTED || state2 == State.CONNECTING) {
                        System.currentTimeMillis();
                        return true;
                    }
                }
            }
            System.currentTimeMillis();
        } catch (Exception e) {
        }
        return false;
    }

    public static String t(Context context) {
        SharedPreferences sharedPreferences;
        String str;
        Exception e;
        String string;
        Object string2;
        int i = 0;
        String str2 = null;
        try {
            sharedPreferences = context.getSharedPreferences("moxiu_theme_config", 1);
        } catch (Exception e2) {
            e2.printStackTrace();
            Object obj = str2;
        }
        String string3 = sharedPreferences.getString("current_home_package_name", "com.android.adwlauncher");
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        String str3 = String.valueOf(windowManager.getDefaultDisplay().getWidth()) + "X" + String.valueOf(windowManager.getDefaultDisplay().getHeight());
        String deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        if (deviceId == null) {
            int pow = (int) Math.pow(10.0d, 14.0d);
            deviceId = (pow + new Random().nextInt(pow)) + "";
        }
        String str4 = Build.MODEL;
        String d = d(VERSION.RELEASE);
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            str = packageInfo.versionName;
            try {
                i = packageInfo.versionCode;
            } catch (Exception e3) {
                e = e3;
                e.printStackTrace();
                string = context.getResources().getString(R.string.t_market_theme_manager_child);
                str2 = URLEncoder.encode(str4, "utf-8");
                str2 = "&model=" + str2 + "&dpi=" + str3 + "&ver=" + str + "&vcode=" + i + "&imei=" + deviceId + "&release=" + d + "&child=" + string + "&curhome=" + string3 + "&from=" + "vlocker";
                if (context.getPackageManager().checkPermission("android.permission.ACCESS_WIFI_STATE", context.getPackageName()) == 0) {
                    obj = ((WifiManager) context.getSystemService(IXAdSystemUtils.NT_WIFI)).getConnectionInfo().getMacAddress();
                    if (!TextUtils.isEmpty(obj)) {
                        deviceId = str2 + "&mac=" + obj;
                        string2 = Secure.getString(context.getContentResolver(), "android_id");
                        if (!TextUtils.isEmpty(string2)) {
                            deviceId = deviceId + "&androidID=" + string2;
                        }
                        return d(deviceId);
                    }
                }
                deviceId = str2;
                string2 = Secure.getString(context.getContentResolver(), "android_id");
                if (TextUtils.isEmpty(string2)) {
                    deviceId = deviceId + "&androidID=" + string2;
                }
                return d(deviceId);
            }
        } catch (Exception e4) {
            e = e4;
            str = str2;
            e.printStackTrace();
            string = context.getResources().getString(R.string.t_market_theme_manager_child);
            str2 = URLEncoder.encode(str4, "utf-8");
            str2 = "&model=" + str2 + "&dpi=" + str3 + "&ver=" + str + "&vcode=" + i + "&imei=" + deviceId + "&release=" + d + "&child=" + string + "&curhome=" + string3 + "&from=" + "vlocker";
            if (context.getPackageManager().checkPermission("android.permission.ACCESS_WIFI_STATE", context.getPackageName()) == 0) {
                obj = ((WifiManager) context.getSystemService(IXAdSystemUtils.NT_WIFI)).getConnectionInfo().getMacAddress();
                if (TextUtils.isEmpty(obj)) {
                    deviceId = str2 + "&mac=" + obj;
                    string2 = Secure.getString(context.getContentResolver(), "android_id");
                    if (TextUtils.isEmpty(string2)) {
                        deviceId = deviceId + "&androidID=" + string2;
                    }
                    return d(deviceId);
                }
            }
            deviceId = str2;
            string2 = Secure.getString(context.getContentResolver(), "android_id");
            if (TextUtils.isEmpty(string2)) {
                deviceId = deviceId + "&androidID=" + string2;
            }
            return d(deviceId);
        }
        string = context.getResources().getString(R.string.t_market_theme_manager_child);
        try {
            str2 = URLEncoder.encode(str4, "utf-8");
        } catch (UnsupportedEncodingException e5) {
            e5.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        str2 = "&model=" + str2 + "&dpi=" + str3 + "&ver=" + str + "&vcode=" + i + "&imei=" + deviceId + "&release=" + d + "&child=" + string + "&curhome=" + string3 + "&from=" + "vlocker";
        try {
            if (context.getPackageManager().checkPermission("android.permission.ACCESS_WIFI_STATE", context.getPackageName()) == 0) {
                obj = ((WifiManager) context.getSystemService(IXAdSystemUtils.NT_WIFI)).getConnectionInfo().getMacAddress();
                if (TextUtils.isEmpty(obj)) {
                    deviceId = str2 + "&mac=" + obj;
                    string2 = Secure.getString(context.getContentResolver(), "android_id");
                    if (TextUtils.isEmpty(string2)) {
                        deviceId = deviceId + "&androidID=" + string2;
                    }
                    return d(deviceId);
                }
            }
            deviceId = str2;
        } catch (Exception e6) {
            deviceId = str2;
        }
        try {
            string2 = Secure.getString(context.getContentResolver(), "android_id");
            if (TextUtils.isEmpty(string2)) {
                deviceId = deviceId + "&androidID=" + string2;
            }
        } catch (Exception e7) {
        }
        return d(deviceId);
    }
}
