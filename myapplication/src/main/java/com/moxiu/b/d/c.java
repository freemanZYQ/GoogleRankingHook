package com.moxiu.b.d;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import android.webkit.WebView;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import com.inveno.se.c.a;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage.IMediaObject;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

public class c {
    private static long a;

    public static String a(Context context) {
        String str;
        int i;
        Exception e;
        String c;
        int i2;
        int i3;
        int i4;
        StringBuffer stringBuffer;
        String str2 = "";
        String str3 = "";
        String str4 = "";
        String str5 = "";
        str3 = "";
        String str6 = "";
        String str7 = "";
        int i5 = 0;
        String str8 = "";
        String str9 = "";
        String str10 = "";
        String str11 = "";
        String str12 = "";
        String str13 = "";
        String str14 = "";
        String str15 = "";
        try {
            str8 = c(context);
            String str16 = Build.MODEL;
            str14 = Build.MANUFACTURER;
            str4 = a(VERSION.RELEASE);
            if (str4 == null || str4.length() == 0) {
                str4 = "xiaomi";
            }
            try {
                str6 = b.e(context);
            } catch (Exception e2) {
            }
            str9 = m(context);
            str11 = g(context);
            str10 = f(context);
            str12 = d(context);
            try {
                Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
                int width = defaultDisplay.getWidth();
                int height = defaultDisplay.getHeight();
                str5 = String.valueOf(width) + "X" + String.valueOf(height);
            } catch (Exception e3) {
            }
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                str2 = packageInfo.versionName;
                i5 = packageInfo.versionCode;
                str3 = packageInfo.packageName;
                str = str2;
                i = i5;
            } catch (Exception e4) {
                e4.printStackTrace();
                str = str2;
                i = i5;
            }
            try {
                str7 = c(str16);
                c = c(str14);
            } catch (Exception e5) {
                e4 = e5;
                c = str14;
                str14 = str11;
                str11 = str9;
                i2 = i;
                str2 = str12;
                str12 = str10;
                str10 = str8;
                str8 = str7;
                str7 = str6;
                str6 = str5;
                str5 = str4;
                str4 = str;
                e4.printStackTrace();
                str = str4;
                str4 = str5;
                str5 = str6;
                str6 = str7;
                str7 = str8;
                str8 = str10;
                str10 = str12;
                str12 = str2;
                str2 = c;
                c = str15;
                i3 = i2;
                str9 = str11;
                str11 = str14;
                i4 = i3;
                str3 = a.a(context).b();
                stringBuffer = new StringBuffer();
                stringBuffer.append("&model=").append(str7).append("&dpi=").append(str5).append("&ver=").append(str).append("&vcode=").append(i4).append("&child=").append(str6).append("&release=").append(str4).append("&conn=").append(str11).append("&carrier=").append(str10).append("&androidID=").append(str12).append("&imei=").append(str8).append("&mac=").append(str9).append("&extra=").append(str3).append("&vendor=").append(str2).append("&ua=").append(c);
                return stringBuffer.toString();
            }
            try {
                i4 = i;
                str2 = c;
                c = l(context);
            } catch (Exception e6) {
                e4 = e6;
                str14 = str11;
                str11 = str9;
                i2 = i;
                str2 = str12;
                str12 = str10;
                str10 = str8;
                str8 = str7;
                str7 = str6;
                str6 = str5;
                str5 = str4;
                str4 = str;
                e4.printStackTrace();
                str = str4;
                str4 = str5;
                str5 = str6;
                str6 = str7;
                str7 = str8;
                str8 = str10;
                str10 = str12;
                str12 = str2;
                str2 = c;
                c = str15;
                i3 = i2;
                str9 = str11;
                str11 = str14;
                i4 = i3;
                str3 = a.a(context).b();
                stringBuffer = new StringBuffer();
                stringBuffer.append("&model=").append(str7).append("&dpi=").append(str5).append("&ver=").append(str).append("&vcode=").append(i4).append("&child=").append(str6).append("&release=").append(str4).append("&conn=").append(str11).append("&carrier=").append(str10).append("&androidID=").append(str12).append("&imei=").append(str8).append("&mac=").append(str9).append("&extra=").append(str3).append("&vendor=").append(str2).append("&ua=").append(c);
                return stringBuffer.toString();
            }
        } catch (Exception e7) {
            e4 = e7;
            String str17 = str14;
            str14 = str11;
            str11 = str9;
            i2 = i5;
            c = str17;
            String str18 = str12;
            str12 = str10;
            str10 = str8;
            str8 = str7;
            str7 = str6;
            str6 = str5;
            str5 = str4;
            str4 = str2;
            str2 = str18;
            e4.printStackTrace();
            str = str4;
            str4 = str5;
            str5 = str6;
            str6 = str7;
            str7 = str8;
            str8 = str10;
            str10 = str12;
            str12 = str2;
            str2 = c;
            c = str15;
            i3 = i2;
            str9 = str11;
            str11 = str14;
            i4 = i3;
            str3 = a.a(context).b();
            stringBuffer = new StringBuffer();
            stringBuffer.append("&model=").append(str7).append("&dpi=").append(str5).append("&ver=").append(str).append("&vcode=").append(i4).append("&child=").append(str6).append("&release=").append(str4).append("&conn=").append(str11).append("&carrier=").append(str10).append("&androidID=").append(str12).append("&imei=").append(str8).append("&mac=").append(str9).append("&extra=").append(str3).append("&vendor=").append(str2).append("&ua=").append(c);
            return stringBuffer.toString();
        }
        try {
            str3 = a.a(context).b();
        } catch (Exception e42) {
            e42.printStackTrace();
            str3 = str13;
        }
        stringBuffer = new StringBuffer();
        stringBuffer.append("&model=").append(str7).append("&dpi=").append(str5).append("&ver=").append(str).append("&vcode=").append(i4).append("&child=").append(str6).append("&release=").append(str4).append("&conn=").append(str11).append("&carrier=").append(str10).append("&androidID=").append(str12).append("&imei=").append(str8).append("&mac=").append(str9).append("&extra=").append(str3).append("&vendor=").append(str2).append("&ua=").append(c);
        return stringBuffer.toString();
    }

    public static String a(Context context, String str) {
        String a = a(context);
        int e = e(context, str);
        StringBuffer stringBuffer = new StringBuffer(a.c(context));
        stringBuffer.append("&id=").append(str).append("&skips=").append(e).append(a);
        return stringBuffer.toString();
    }

    public static String a(Context context, List list) {
        String a = a(context);
        int b = b(context, list);
        StringBuffer stringBuffer = new StringBuffer(a.d(context));
        stringBuffer.append("&ids=");
        for (int i = 0; i < list.size(); i++) {
            stringBuffer.append((String) list.get(i));
            if (i != list.size() - 1) {
                stringBuffer.append(",");
            }
        }
        stringBuffer.append("&skips=").append(b).append(a);
        return stringBuffer.toString();
    }

    public static String a(Reader reader) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] cArr = new char[4096];
        int read = reader.read(cArr);
        while (read >= 0) {
            stringBuilder.append(cArr, 0, read);
            read = reader.read(cArr);
        }
        return stringBuilder.toString();
    }

    public static String a(String str) {
        return str == null ? "" : str.replace(" ", "");
    }

    public static void a(String str, String str2) {
    }

    public static boolean a() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - a;
        if (0 < j && j < 3000) {
            return true;
        }
        a = currentTimeMillis;
        return false;
    }

    public static boolean a(Context context, Intent intent) {
        try {
            return !context.getPackageManager().queryIntentActivities(intent, 0).isEmpty();
        } catch (Exception e) {
            return false;
        }
    }

    private static int b(Context context, List list) {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < list.size(); i++) {
                stringBuffer.append((String) list.get(i));
                if (i != list.size() - 1) {
                    stringBuffer.append("&");
                }
            }
            String stringBuffer2 = stringBuffer.toString();
            int i2 = Calendar.getInstance().get(7);
            if (i2 != b.d(context, stringBuffer2)) {
                b.b(context, stringBuffer2, 1);
                b.a(context, stringBuffer2, i2);
                return 1;
            }
            int e = b.e(context, stringBuffer2) + 1;
            b.b(context, stringBuffer2, e);
            b.a(context, stringBuffer2, i2);
            return e;
        } catch (Exception e2) {
            return 1;
        }
    }

    private static String b() {
        String str = "";
        String str2 = "";
        try {
            LineNumberReader lineNumberReader = new LineNumberReader(new InputStreamReader(Runtime.getRuntime().exec("cat /sys/class/net/wlan0/address ").getInputStream()));
            while (str != null) {
                str = lineNumberReader.readLine();
                if (str != null) {
                    str2 = str.trim();
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (str2 == null || "".equals(str2)) {
            try {
                str2 = d("/sys/class/net/eth0/address").toUpperCase().substring(0, 17);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return str2;
    }

    public static String b(Context context) {
        Exception e;
        String str;
        int i;
        String str2;
        String str3;
        StringBuffer stringBuffer;
        Exception exception;
        int i2 = 0;
        String str4 = "";
        String str5 = "";
        str5 = "";
        String str6 = "";
        String str7 = "";
        String str8 = "";
        try {
            str7 = c(context);
            str5 = Build.MODEL;
            str5 = a(VERSION.RELEASE);
            if (str5 == null || str5.length() == 0) {
                str5 = "xiaomi";
            }
            try {
                str6 = b.e(context);
            } catch (Exception e2) {
            }
            str8 = d(context);
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                str5 = packageInfo.versionName;
                try {
                    i2 = packageInfo.versionCode;
                } catch (Exception e3) {
                    e = e3;
                    try {
                        e.printStackTrace();
                        str = str8;
                        i = i2;
                        str2 = str;
                        str3 = str7;
                        str7 = str6;
                        str6 = str5;
                        str5 = str3;
                    } catch (Exception e4) {
                        e = e4;
                        str = str8;
                        str8 = str7;
                        str7 = str6;
                        str6 = str5;
                        str5 = str;
                        e.printStackTrace();
                        str = str5;
                        str5 = str8;
                        i = i2;
                        str2 = str;
                        stringBuffer = new StringBuffer();
                        stringBuffer.append("&ver=").append(str6).append("&vcode=").append(i).append("&child=").append(str7).append("&androidID=").append(str2).append("&imei=").append(str5);
                        return stringBuffer.toString();
                    }
                    stringBuffer = new StringBuffer();
                    stringBuffer.append("&ver=").append(str6).append("&vcode=").append(i).append("&child=").append(str7).append("&androidID=").append(str2).append("&imei=").append(str5);
                    return stringBuffer.toString();
                }
            } catch (Exception e5) {
                exception = e5;
                str5 = str4;
                e = exception;
                e.printStackTrace();
                str = str8;
                i = i2;
                str2 = str;
                str3 = str7;
                str7 = str6;
                str6 = str5;
                str5 = str3;
                stringBuffer = new StringBuffer();
                stringBuffer.append("&ver=").append(str6).append("&vcode=").append(i).append("&child=").append(str7).append("&androidID=").append(str2).append("&imei=").append(str5);
                return stringBuffer.toString();
            }
            str = str8;
            i = i2;
            str2 = str;
            str3 = str7;
            str7 = str6;
            str6 = str5;
            str5 = str3;
        } catch (Exception e52) {
            exception = e52;
            str5 = str8;
            str8 = str7;
            str7 = str6;
            str6 = str4;
            e = exception;
            e.printStackTrace();
            str = str5;
            str5 = str8;
            i = i2;
            str2 = str;
            stringBuffer = new StringBuffer();
            stringBuffer.append("&ver=").append(str6).append("&vcode=").append(i).append("&child=").append(str7).append("&androidID=").append(str2).append("&imei=").append(str5);
            return stringBuffer.toString();
        }
        stringBuffer = new StringBuffer();
        stringBuffer.append("&ver=").append(str6).append("&vcode=").append(i).append("&child=").append(str7).append("&androidID=").append(str2).append("&imei=").append(str5);
        return stringBuffer.toString();
    }

    public static String b(Context context, String str) {
        String a = a(context);
        StringBuffer stringBuffer = new StringBuffer(a.e(context));
        stringBuffer.append("&ids=").append(str);
        stringBuffer.append("&skips=").append("0").append(a);
        return stringBuffer.toString();
    }

    public static void b(String str) {
        a("green_gold", str);
    }

    public static String c(Context context) {
        String deviceId;
        String str = "";
        try {
            deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        } catch (Exception e) {
            deviceId = str;
        }
        if (!TextUtils.isEmpty(deviceId)) {
            return deviceId;
        }
        try {
            deviceId = b.g(context);
            if (deviceId == null || deviceId.length() >= 10) {
                return deviceId;
            }
            int pow = (int) Math.pow(10.0d, 14.0d);
            deviceId = (pow + new Random().nextInt(pow)) + "";
            b.h(context, deviceId);
            return deviceId;
        } catch (Exception e2) {
            return deviceId;
        }
    }

    public static String c(String str) {
        String encode;
        String str2 = "";
        try {
            encode = URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            encode = str2;
        } catch (Throwable th) {
            th.printStackTrace();
            encode = str2;
        }
        return encode == null ? "" : encode;
    }

    public static boolean c(Context context, String str) {
        try {
            context.getPackageManager().getApplicationInfo(str, 8192);
            return true;
        } catch (NameNotFoundException e) {
            return false;
        } catch (Exception e2) {
            return false;
        }
    }

    public static int d(Context context, String str) {
        int i;
        NameNotFoundException e;
        try {
            i = context.getPackageManager().getPackageInfo(str, 0).versionCode;
            try {
                b("get apk version-->" + str + " version-->" + i);
            } catch (NameNotFoundException e2) {
                e = e2;
                e.printStackTrace();
                return i;
            }
        } catch (NameNotFoundException e3) {
            NameNotFoundException nameNotFoundException = e3;
            i = 0;
            e = nameNotFoundException;
            e.printStackTrace();
            return i;
        }
        return i;
    }

    public static String d(Context context) {
        String string = System.getString(context.getContentResolver(), "android_id");
        return string == null ? "" : string;
    }

    public static String d(String str) {
        Reader fileReader = new FileReader(str);
        String a = a(fileReader);
        fileReader.close();
        return a;
    }

    private static int e(Context context, String str) {
        try {
            int i = Calendar.getInstance().get(7);
            if (i != b.d(context, str)) {
                b.b(context, str, 1);
                b.a(context, str, i);
                return 1;
            }
            int e = b.e(context, str) + 1;
            b.b(context, str, e);
            b.a(context, str, i);
            return e;
        } catch (Exception e2) {
            return 1;
        }
    }

    public static String e(Context context) {
        String str = "";
        try {
            WifiInfo connectionInfo = ((WifiManager) context.getSystemService(IXAdSystemUtils.NT_WIFI)).getConnectionInfo();
            return connectionInfo.getMacAddress() != null ? connectionInfo.getMacAddress() : "";
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    public static String f(Context context) {
        String str = "1";
        String subscriberId = ((TelephonyManager) context.getSystemService("phone")).getSubscriberId();
        if (subscriberId != null) {
            if (subscriberId.startsWith("46000") || subscriberId.startsWith("46002") || subscriberId.startsWith("46007")) {
                return "1";
            }
            if (subscriberId.startsWith("46001")) {
                return "2";
            }
            if (subscriberId.startsWith("46003")) {
                return "3";
            }
        }
        return str;
    }

    public static String g(Context context) {
        String str = "";
        d h = h(context);
        return h.equals(d.noNetStatus) ? "" : h.equals(d.twoGNetStatus) ? "2" : h.equals(d.threeGNetStatus) ? "3" : h.equals(d.fourNetStatus) ? "4" : h.equals(d.wifiNetStatus) ? "1" : str;
    }

    public static d h(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null) {
            try {
                NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
                if (networkInfo != null && networkInfo.getState() == State.CONNECTED) {
                    return d.wifiNetStatus;
                }
                NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
                if (networkInfo2 != null && networkInfo2.getState() == State.CONNECTED) {
                    return n(context);
                }
            } catch (Exception e) {
            }
        }
        return d.noNetStatus;
    }

    public static Boolean i(Context context) {
        String str = "";
        try {
            str = b.e(context);
        } catch (Exception e) {
        }
        return (str == null || str.length() <= 0) ? Boolean.valueOf(false) : (str.equals("B-oppo") || str.equals("B-huawei") || str.equals("B-lenovo") || str.equals("B-jinli")) ? Boolean.valueOf(false) : Boolean.valueOf(true);
    }

    public static Boolean j(Context context) {
        String str = "";
        try {
            str = b.e(context);
        } catch (Exception e) {
        }
        return (str == null || str.length() <= 0) ? Boolean.valueOf(false) : str.equals("A-goapk") ? Boolean.valueOf(false) : Boolean.valueOf(true);
    }

    public static int k(Context context) {
        int i = 0;
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            return i;
        }
    }

    public static String l(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("ad_preferences", b.a());
        Object string = sharedPreferences.getString("ad_plugin_ua", "");
        try {
            if (!TextUtils.isEmpty(string)) {
                return string;
            }
            WebView webView = new WebView(context);
            webView.layout(0, 0, 0, 0);
            String userAgentString = webView.getSettings().getUserAgentString();
            if (TextUtils.isEmpty(userAgentString)) {
                userAgentString = "Mozilla/5.0 (Linux; U; Android 3.1; en-us; Xoom Build/HMJ25) AppleWebKit/534.13 (KHTML, like Gecko) Version/4.0 Safari/534.13";
            }
            sharedPreferences.edit().putString("ad_plugin_ua", userAgentString).commit();
            return userAgentString;
        } catch (Exception e) {
            e.printStackTrace();
            return "Mozilla/5.0 (Linux; U; Android 3.1; en-us; Xoom Build/HMJ25) AppleWebKit/534.13 (KHTML, like Gecko) Version/4.0 Safari/534.13";
        }
    }

    public static String m(Context context) {
        String h = b.h(context);
        if (TextUtils.isEmpty(h)) {
            h = VERSION.SDK_INT > 22 ? b() : e(context);
            b.i(context, h);
        }
        return h;
    }

    private static d n(Context context) {
        switch (((TelephonyManager) context.getSystemService("phone")).getNetworkType()) {
            case 0:
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return d.twoGNetStatus;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case IMediaObject.TYPE_OLD_TV /*14*/:
            case 15:
                return d.threeGNetStatus;
            case 13:
                return d.fourNetStatus;
            default:
                return d.twoGNetStatus;
        }
    }
}
