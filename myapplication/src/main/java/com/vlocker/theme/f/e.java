package com.vlocker.theme.f;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import com.qq.e.comm.constants.ErrorCode.AdError;
import com.vlocker.b.i;
import com.vlocker.c.a;
import com.vlocker.locker.R;
import com.vlocker.new_theme.activity.ThemeMainActivity;
import com.vlocker.new_theme.d.f;
import com.vlocker.new_theme.e.h;
import com.vlocker.security.MoSecurityApplication;
import com.vlocker.theme.model.T_ThemeItemInfo;
import com.vlocker.theme.model.T_ThemePreviewParserInfo;
import com.vlocker.theme.model.d;
import java.io.File;
import java.io.FileFilter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class e {
    public static Context a;
    public static int b = -40;
    public static final FileFilter c = new f();
    public static boolean d = true;
    private static Display e = null;

    static {
        a = null;
        a = MoSecurityApplication.a();
    }

    public static T_ThemeItemInfo a(JSONObject jSONObject) {
        d dVar;
        T_ThemePreviewParserInfo t_ThemePreviewParserInfo;
        T_ThemePreviewParserInfo t_ThemePreviewParserInfo2;
        int i;
        PatternSyntaxException e;
        JSONException e2;
        T_ThemeItemInfo t_ThemeItemInfo;
        try {
            t_ThemeItemInfo = new T_ThemeItemInfo();
            try {
                t_ThemeItemInfo.a(jSONObject.getString("id"));
                t_ThemeItemInfo.b(b(jSONObject.getString("title")));
                t_ThemeItemInfo.c(jSONObject.getString("tags"));
                t_ThemeItemInfo.d(jSONObject.getString("desc"));
                t_ThemeItemInfo.c(jSONObject.getInt("size"));
                t_ThemeItemInfo.e(jSONObject.getInt("downnum"));
                t_ThemeItemInfo.h(jSONObject.getString("ctime"));
                t_ThemeItemInfo.d(jSONObject.getInt("grade"));
                t_ThemeItemInfo.g(jSONObject.getString("author"));
                t_ThemeItemInfo.f(jSONObject.getString("show"));
                t_ThemeItemInfo.e(jSONObject.getString("package"));
                t_ThemeItemInfo.i(jSONObject.getString("preview1") + a(1));
                t_ThemeItemInfo.b(jSONObject.getInt("is_lockscreen"));
                t_ThemeItemInfo.j(jSONObject.getString("preview1") + a(0));
                t_ThemeItemInfo.k(jSONObject.getString("preview2") + a(0));
                try {
                    JSONArray jSONArray = jSONObject.getJSONArray("mpic");
                    JSONObject jSONObject2;
                    if (jSONArray == null || jSONArray.length() <= 0) {
                        dVar = new d();
                        t_ThemePreviewParserInfo = new T_ThemePreviewParserInfo();
                        t_ThemePreviewParserInfo2 = new T_ThemePreviewParserInfo();
                        for (i = 0; i < 2; i++) {
                            if (i == 0) {
                                t_ThemePreviewParserInfo.a(jSONObject.getString("preview1") + a(0));
                                dVar.add(t_ThemePreviewParserInfo);
                            }
                            if (i == 1) {
                                t_ThemePreviewParserInfo2.a(jSONObject.getString("preview2") + a(0));
                                dVar.add(t_ThemePreviewParserInfo2);
                            }
                        }
                        t_ThemeItemInfo.a(dVar);
                        t_ThemeItemInfo.l(jSONObject.getString("file"));
                        try {
                            t_ThemeItemInfo.f(jSONObject.getInt("edit"));
                            jSONObject2 = jSONObject.getJSONObject("event");
                            if (jSONObject2 != null) {
                                t_ThemeItemInfo.m(jSONObject2.getString("title"));
                                t_ThemeItemInfo.n(jSONObject2.getString("preview"));
                                t_ThemeItemInfo.o(jSONObject2.getString("dataurl"));
                            }
                        } catch (Exception e3) {
                        }
                        try {
                            if (jSONObject.getString("logurl") != null) {
                                t_ThemeItemInfo.p(jSONObject.getString("logurl"));
                            }
                        } catch (Exception e4) {
                        }
                        try {
                            if (jSONObject.getString("diggnum") != null) {
                                t_ThemeItemInfo.g(jSONObject.getInt("diggnum"));
                            }
                        } catch (Exception e5) {
                        }
                        return t_ThemeItemInfo;
                    }
                    d dVar2 = new d();
                    for (i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject3 = jSONArray.getJSONObject(i);
                        T_ThemePreviewParserInfo t_ThemePreviewParserInfo3 = new T_ThemePreviewParserInfo();
                        t_ThemePreviewParserInfo3.a(jSONObject3.getString("preview") + a(0));
                        dVar2.add(t_ThemePreviewParserInfo3);
                    }
                    t_ThemeItemInfo.a(dVar2);
                    t_ThemeItemInfo.l(jSONObject.getString("file"));
                    t_ThemeItemInfo.f(jSONObject.getInt("edit"));
                    jSONObject2 = jSONObject.getJSONObject("event");
                    if (jSONObject2 != null) {
                        t_ThemeItemInfo.m(jSONObject2.getString("title"));
                        t_ThemeItemInfo.n(jSONObject2.getString("preview"));
                        t_ThemeItemInfo.o(jSONObject2.getString("dataurl"));
                    }
                    if (jSONObject.getString("logurl") != null) {
                        t_ThemeItemInfo.p(jSONObject.getString("logurl"));
                    }
                    if (jSONObject.getString("diggnum") != null) {
                        t_ThemeItemInfo.g(jSONObject.getInt("diggnum"));
                    }
                    return t_ThemeItemInfo;
                } catch (Exception e6) {
                    e6.printStackTrace();
                    try {
                        dVar = new d();
                        t_ThemePreviewParserInfo = new T_ThemePreviewParserInfo();
                        t_ThemePreviewParserInfo2 = new T_ThemePreviewParserInfo();
                        for (i = 0; i < 2; i++) {
                            if (i == 0) {
                                t_ThemePreviewParserInfo.a(jSONObject.getString("preview1") + a(0));
                                dVar.add(t_ThemePreviewParserInfo);
                            }
                            if (i == 1) {
                                t_ThemePreviewParserInfo2.a(jSONObject.getString("preview2") + a(0));
                                dVar.add(t_ThemePreviewParserInfo2);
                            }
                        }
                        t_ThemeItemInfo.a(dVar);
                    } catch (Exception e62) {
                        e62.printStackTrace();
                    }
                }
            } catch (PatternSyntaxException e7) {
                e = e7;
                e.printStackTrace();
                return t_ThemeItemInfo;
            } catch (JSONException e8) {
                e2 = e8;
                e2.printStackTrace();
                return t_ThemeItemInfo;
            }
        } catch (PatternSyntaxException e9) {
            PatternSyntaxException patternSyntaxException = e9;
            t_ThemeItemInfo = null;
            e = patternSyntaxException;
            e.printStackTrace();
            return t_ThemeItemInfo;
        } catch (JSONException e10) {
            JSONException jSONException = e10;
            t_ThemeItemInfo = null;
            e2 = jSONException;
            e2.printStackTrace();
            return t_ThemeItemInfo;
        }
    }

    public static String a() {
        Object e = i.o.e();
        return !TextUtils.isEmpty(e) ? e : i.a() + "json.php?do=Theme.Search&sort=downnumweek&app=vlocker";
    }

    public static String a(int i) {
        String str = "/p1611.webp";
        try {
            int ay = a.a(a).ay();
            return i == 0 ? ay <= AdError.PLACEMENT_ERROR ? "/336" + str : str : i == 1 ? ay > 720 ? b(a).booleanValue() ? "/336" + str : "/176" + str : "/176" + str : str;
        } catch (Exception e) {
            return str;
        }
    }

    public static String a(String str, String str2, String str3) {
        String str4 = "";
        Matcher matcher = Pattern.compile("[a-zA-Z一-龥][a-zA-Z0-9一-龥]+").matcher(str);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            stringBuffer.append(matcher.group());
        }
        return str3 + stringBuffer.toString() + str2;
    }

    public static List a(Context context, int i) {
        List arrayList = new ArrayList();
        try {
            arrayList = f.a(context, d(context, ThemeMainActivity.m));
        } catch (Exception e) {
            e.printStackTrace();
        } catch (OutOfMemoryError e2) {
            e2.printStackTrace();
        }
        return arrayList;
    }

    public static List a(List list) {
        Collections.sort(list, new com.vlocker.new_theme.e.i());
        return list;
    }

    public static void a(Context context) {
        if (a == null) {
            a = context;
        }
        a(i.h);
    }

    public static void a(Context context, CharSequence charSequence, int i) {
        if (context == null) {
            try {
                context = a;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        Toast toast = new Toast(context);
        View linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        linearLayout.setBackgroundResource(R.drawable.t_mareket_sign_toast);
        View textView = new TextView(context);
        textView.setPadding(10, 0, 10, 0);
        textView.setText(charSequence);
        textView.setGravity(17);
        textView.setTextColor(-1);
        textView.setTextSize(15.0f);
        linearLayout.addView(textView, new LayoutParams(-2, -2));
        toast.setView(linearLayout);
        toast.setGravity(80, 0, (int) context.getResources().getDimension(R.dimen.button_bar_height_plus_padding));
        toast.setDuration(i);
        toast.show();
    }

    public static void a(Context context, String str) {
        Toast makeText = Toast.makeText(context, str, 0);
        makeText.setGravity(17, 0, b);
        makeText.show();
    }

    public static void a(Context context, String str, String str2) {
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(new MemoryInfo());
    }

    public static void a(String str) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    public static Boolean b(Context context) {
        try {
            if (State.CONNECTED == ((ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(1).getState()) {
                return Boolean.valueOf(true);
            }
        } catch (Exception e) {
        }
        return Boolean.valueOf(false);
    }

    public static String b() {
        Object b = i.o.b();
        return !TextUtils.isEmpty(b) ? b : i.a() + "json.php?do=Topic.List&app=vlocker";
    }

    public static String b(Context context, String str) {
        return context.getSharedPreferences("moxiu.launcher.manager.preferences", 0).getString(str, "null");
    }

    public static String b(String str) {
        return Pattern.compile("[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]").matcher(str).replaceAll("").trim();
    }

    public static String b(String str, String str2, String str3) {
        return a(str, str2, str3) + ".tmp";
    }

    public static List b(Context context, int i) {
        List arrayList = new ArrayList();
        try {
            arrayList = f.b(context, e(context, ThemeMainActivity.m));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public static List b(List list) {
        Collections.sort(list, new h());
        return list;
    }

    public static String c() {
        Object d = i.o.d();
        return !TextUtils.isEmpty(d) ? d : i.a() + "json.php?do=Theme.List&sort=ctime&app=vlocker";
    }

    public static String c(String str) {
        return str.replace(" ", "");
    }

    public static String c(String str, String str2, String str3) {
        return a(str, str2, str3) + ".mx";
    }

    public static void c(Context context, String str) {
        try {
            context.getSharedPreferences("moxiu_setting_param", 1).edit().putString("moxiu_mainjson", str).commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean c(Context context) {
        try {
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
        } catch (Exception e) {
            return false;
        }
    }

    public static String d(Context context) {
        CharSequence charSequence = null;
        String str = Build.MODEL;
        String c = c(VERSION.RELEASE);
        try {
            charSequence = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        } catch (Exception e) {
        }
        if (!TextUtils.isEmpty(charSequence)) {
            return charSequence;
        }
        try {
            Object macAddress = ((WifiManager) context.getSystemService(IXAdSystemUtils.NT_WIFI)).getConnectionInfo().getMacAddress();
            if (!TextUtils.isEmpty(macAddress)) {
                return "rmac" + macAddress + str + c;
            }
            String aA = a.a(context).aA();
            try {
                if (aA.length() > 2) {
                    return aA;
                }
                int pow = (int) Math.pow(10.0d, 14.0d);
                aA = "rrand" + new Random().nextInt(pow) + pow + "";
                a.a(context).r(aA);
                return aA;
            } catch (Exception e2) {
                return aA;
            }
        } catch (Exception e3) {
            return charSequence;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String d(android.content.Context r2, java.lang.String r3) {
        /*
        if (r3 == 0) goto L_0x000b;
    L_0x0002:
        r0 = "";
        r0 = r3.equals(r0);	 Catch:{ Exception -> 0x0031 }
        if (r0 == 0) goto L_0x0013;
    L_0x000b:
        r0 = g(r2);	 Catch:{ Exception -> 0x0031 }
        com.vlocker.new_theme.activity.ThemeMainActivity.m = r0;	 Catch:{ Exception -> 0x0031 }
        r3 = com.vlocker.new_theme.activity.ThemeMainActivity.m;	 Catch:{ Exception -> 0x0031 }
    L_0x0013:
        r0 = com.vlocker.b.i.o;
        r0 = r0.a();
        r1 = android.text.TextUtils.isEmpty(r0);
        if (r1 != 0) goto L_0x0036;
    L_0x001f:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r0 = r1.append(r0);
        r0 = r0.append(r3);
        r0 = r0.toString();
    L_0x0030:
        return r0;
    L_0x0031:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x0013;
    L_0x0036:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = com.vlocker.b.i.a();
        r0 = r0.append(r1);
        r1 = "json.php?do=Cate.List&app=vlocker";
        r0 = r0.append(r1);
        r0 = r0.append(r3);
        r0 = r0.toString();
        goto L_0x0030;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vlocker.theme.f.e.d(android.content.Context, java.lang.String):java.lang.String");
    }

    public static String e(Context context, String str) {
        if (str == null || str.equals("")) {
            try {
                ThemeMainActivity.m = g(context);
                str = ThemeMainActivity.m;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Object c = i.o.c();
        return !TextUtils.isEmpty(c) ? c + str : i.a() + "json.php?do=Tag.List&app=vlocker" + str;
    }

    public static boolean e(Context context) {
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

    public static int f(Context context, String str) {
        return context.getSharedPreferences("com.moxiu", a.a()).getInt(str, 1);
    }

    public static Display f(Context context) {
        if (e == null) {
            e = ((Activity) context).getWindowManager().getDefaultDisplay();
        }
        return e;
    }

    public static String g(Context context) {
        SharedPreferences sharedPreferences;
        WindowManager windowManager;
        String encode;
        String encode2;
        String str;
        UnsupportedEncodingException e;
        TelephonyManager telephonyManager;
        String subscriberId;
        String str2;
        CharSequence deviceId;
        CharSequence charSequence;
        PackageInfo packageInfo;
        int i;
        String str3;
        Object obj;
        Exception exception;
        String str4 = null;
        try {
            sharedPreferences = context.getSharedPreferences("moxiu_theme_config", 1);
        } catch (Exception e2) {
            e2.printStackTrace();
            Object obj2 = str4;
        }
        String string = sharedPreferences.getString("current_home_package_name", "com.android.adwlauncher");
        try {
            windowManager = ((Activity) context).getWindowManager();
        } catch (Exception e3) {
            obj2 = str4;
        }
        Display defaultDisplay = windowManager.getDefaultDisplay();
        String str5 = String.valueOf(defaultDisplay.getWidth()) + "X" + String.valueOf(defaultDisplay.getHeight());
        String str6 = Build.MODEL;
        String c = c(VERSION.RELEASE);
        try {
            encode = URLEncoder.encode(str6, "utf-8");
            try {
                encode2 = URLEncoder.encode(b(context, "moxiu_user_mxauth"), "utf-8");
                str = encode;
            } catch (UnsupportedEncodingException e4) {
                e = e4;
                e.printStackTrace();
                str = encode;
                encode2 = str4;
                telephonyManager = (TelephonyManager) context.getSystemService("phone");
                subscriberId = telephonyManager.getSubscriberId();
                subscriberId = "none1103";
                str2 = subscriberId;
                deviceId = telephonyManager.getDeviceId();
                if (TextUtils.isEmpty(deviceId)) {
                    charSequence = deviceId;
                } else {
                    try {
                        obj2 = ((WifiManager) context.getSystemService(IXAdSystemUtils.NT_WIFI)).getConnectionInfo().getMacAddress();
                        if (!TextUtils.isEmpty(obj2)) {
                            deviceId = "rmac" + obj2 + str6 + c;
                        }
                        str6 = deviceId;
                    } catch (Exception e5) {
                        charSequence = deviceId;
                    }
                }
                packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                subscriberId = packageInfo.versionName;
                i = packageInfo.versionCode;
                str3 = "moxiulauncher";
                str3 = context.getResources().getString(R.string.t_market_theme_manager_child);
                if (!"null".equals(encode2)) {
                }
                str4 = "&model=" + str + "&dpi=" + str5 + "&ver=" + subscriberId + "&vcode=" + i + "&imsi=" + str2 + "&imei=" + str6 + "&release=" + c + "&child=" + str3 + "&curhome=" + string;
                ThemeMainActivity.n = c("&ver=" + subscriberId + "&vcode=" + i + "&imei=" + str6);
                return c(str4);
            } catch (Exception e6) {
                str = encode;
                encode2 = str4;
                telephonyManager = (TelephonyManager) context.getSystemService("phone");
                subscriberId = telephonyManager.getSubscriberId();
                subscriberId = "none1103";
                str2 = subscriberId;
                deviceId = telephonyManager.getDeviceId();
                if (TextUtils.isEmpty(deviceId)) {
                    obj2 = ((WifiManager) context.getSystemService(IXAdSystemUtils.NT_WIFI)).getConnectionInfo().getMacAddress();
                    if (TextUtils.isEmpty(obj2)) {
                        deviceId = "rmac" + obj2 + str6 + c;
                    }
                    str6 = deviceId;
                } else {
                    charSequence = deviceId;
                }
                packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                subscriberId = packageInfo.versionName;
                i = packageInfo.versionCode;
                str3 = "moxiulauncher";
                str3 = context.getResources().getString(R.string.t_market_theme_manager_child);
                if ("null".equals(encode2)) {
                }
                str4 = "&model=" + str + "&dpi=" + str5 + "&ver=" + subscriberId + "&vcode=" + i + "&imsi=" + str2 + "&imei=" + str6 + "&release=" + c + "&child=" + str3 + "&curhome=" + string;
                ThemeMainActivity.n = c("&ver=" + subscriberId + "&vcode=" + i + "&imei=" + str6);
                return c(str4);
            }
        } catch (UnsupportedEncodingException e7) {
            e = e7;
            encode = str4;
            e.printStackTrace();
            str = encode;
            encode2 = str4;
            telephonyManager = (TelephonyManager) context.getSystemService("phone");
            subscriberId = telephonyManager.getSubscriberId();
            subscriberId = "none1103";
            str2 = subscriberId;
            deviceId = telephonyManager.getDeviceId();
            if (TextUtils.isEmpty(deviceId)) {
                charSequence = deviceId;
            } else {
                obj2 = ((WifiManager) context.getSystemService(IXAdSystemUtils.NT_WIFI)).getConnectionInfo().getMacAddress();
                if (TextUtils.isEmpty(obj2)) {
                    deviceId = "rmac" + obj2 + str6 + c;
                }
                str6 = deviceId;
            }
            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            subscriberId = packageInfo.versionName;
            i = packageInfo.versionCode;
            str3 = "moxiulauncher";
            str3 = context.getResources().getString(R.string.t_market_theme_manager_child);
            if ("null".equals(encode2)) {
            }
            str4 = "&model=" + str + "&dpi=" + str5 + "&ver=" + subscriberId + "&vcode=" + i + "&imsi=" + str2 + "&imei=" + str6 + "&release=" + c + "&child=" + str3 + "&curhome=" + string;
            ThemeMainActivity.n = c("&ver=" + subscriberId + "&vcode=" + i + "&imei=" + str6);
            return c(str4);
        } catch (Exception e8) {
            encode = str4;
            str = encode;
            encode2 = str4;
            telephonyManager = (TelephonyManager) context.getSystemService("phone");
            subscriberId = telephonyManager.getSubscriberId();
            subscriberId = "none1103";
            str2 = subscriberId;
            deviceId = telephonyManager.getDeviceId();
            if (TextUtils.isEmpty(deviceId)) {
                obj2 = ((WifiManager) context.getSystemService(IXAdSystemUtils.NT_WIFI)).getConnectionInfo().getMacAddress();
                if (TextUtils.isEmpty(obj2)) {
                    deviceId = "rmac" + obj2 + str6 + c;
                }
                str6 = deviceId;
            } else {
                charSequence = deviceId;
            }
            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            subscriberId = packageInfo.versionName;
            i = packageInfo.versionCode;
            str3 = "moxiulauncher";
            str3 = context.getResources().getString(R.string.t_market_theme_manager_child);
            if ("null".equals(encode2)) {
            }
            str4 = "&model=" + str + "&dpi=" + str5 + "&ver=" + subscriberId + "&vcode=" + i + "&imsi=" + str2 + "&imei=" + str6 + "&release=" + c + "&child=" + str3 + "&curhome=" + string;
            ThemeMainActivity.n = c("&ver=" + subscriberId + "&vcode=" + i + "&imei=" + str6);
            return c(str4);
        }
        telephonyManager = (TelephonyManager) context.getSystemService("phone");
        try {
            subscriberId = telephonyManager.getSubscriberId();
            if (subscriberId == null || subscriberId.equals("")) {
                subscriberId = "none1103";
            }
            str2 = subscriberId;
        } catch (SecurityException e9) {
            str2 = "none1101";
        } catch (Exception e10) {
            str2 = "none1102";
        }
        try {
            deviceId = telephonyManager.getDeviceId();
        } catch (SecurityException e11) {
            obj = str4;
        } catch (Exception e12) {
            obj = str4;
        }
        if (TextUtils.isEmpty(deviceId)) {
            obj2 = ((WifiManager) context.getSystemService(IXAdSystemUtils.NT_WIFI)).getConnectionInfo().getMacAddress();
            if (TextUtils.isEmpty(obj2)) {
                deviceId = "rmac" + obj2 + str6 + c;
            }
            str6 = deviceId;
        } else {
            charSequence = deviceId;
        }
        try {
            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            subscriberId = packageInfo.versionName;
            try {
                i = packageInfo.versionCode;
            } catch (Exception e22) {
                Exception exception2 = e22;
                encode = subscriberId;
                exception = exception2;
                exception.printStackTrace();
                subscriberId = encode;
                i = 0;
                str3 = "moxiulauncher";
                str3 = context.getResources().getString(R.string.t_market_theme_manager_child);
                if ("null".equals(encode2)) {
                }
                str4 = "&model=" + str + "&dpi=" + str5 + "&ver=" + subscriberId + "&vcode=" + i + "&imsi=" + str2 + "&imei=" + str6 + "&release=" + c + "&child=" + str3 + "&curhome=" + string;
                ThemeMainActivity.n = c("&ver=" + subscriberId + "&vcode=" + i + "&imei=" + str6);
                return c(str4);
            }
        } catch (Exception e222) {
            exception = e222;
            encode = str4;
            exception.printStackTrace();
            subscriberId = encode;
            i = 0;
            str3 = "moxiulauncher";
            str3 = context.getResources().getString(R.string.t_market_theme_manager_child);
            if ("null".equals(encode2)) {
            }
            str4 = "&model=" + str + "&dpi=" + str5 + "&ver=" + subscriberId + "&vcode=" + i + "&imsi=" + str2 + "&imei=" + str6 + "&release=" + c + "&child=" + str3 + "&curhome=" + string;
            ThemeMainActivity.n = c("&ver=" + subscriberId + "&vcode=" + i + "&imei=" + str6);
            return c(str4);
        }
        str3 = "moxiulauncher";
        try {
            str3 = context.getResources().getString(R.string.t_market_theme_manager_child);
        } catch (Exception e13) {
        }
        try {
            if ("null".equals(encode2) || "".equals(encode2)) {
                str4 = "&model=" + str + "&dpi=" + str5 + "&ver=" + subscriberId + "&vcode=" + i + "&imsi=" + str2 + "&imei=" + str6 + "&release=" + c + "&child=" + str3 + "&curhome=" + string;
                ThemeMainActivity.n = c("&ver=" + subscriberId + "&vcode=" + i + "&imei=" + str6);
                return c(str4);
            }
            str4 = "&model=" + str + "&dpi=" + str5 + "&ver=" + subscriberId + "&vcode=" + i + "&imsi=" + str2 + "&imei=" + str6 + "&release=" + c + "&child=" + str3 + "&curhome=" + string + "&mxauth=" + encode2;
            ThemeMainActivity.n = c("&ver=" + subscriberId + "&vcode=" + i + "&imei=" + str6);
            return c(str4);
        } catch (Exception e14) {
        }
    }
}
