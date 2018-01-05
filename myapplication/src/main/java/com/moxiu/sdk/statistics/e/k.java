package com.moxiu.sdk.statistics.e;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.wifi.WifiManager;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage.IMediaObject;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Iterator;
import org.apache.http.conn.util.InetAddressUtils;

public class k {
    private static String a = "";
    private static String b = "";
    private static String c = "";
    private static int d = 0;
    private static int e = 0;
    private static int f = 0;
    private static String g = "";

    public static e a(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null) {
            try {
                NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
                if (networkInfo != null && networkInfo.getState() == State.CONNECTED) {
                    return e.wifiNetStatus;
                }
                NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
                if (networkInfo2 != null && networkInfo2.getState() == State.CONNECTED) {
                    return i(context) ? e.threeGNetStatus : e.twoGNetStatus;
                }
            } catch (Throwable th) {
                i.a("getCurNetWorkForWifiOrG Exception = ", th);
            }
        }
        return e.noNetStatus;
    }

    public static String a() {
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
        } catch (Exception e) {
            i.b("getLocalIpAddress Exception");
        }
        return "";
    }

    public static String b(Context context) {
        if (TextUtils.isEmpty(a)) {
            a = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        }
        return a;
    }

    public static String c(Context context) {
        if (TextUtils.isEmpty(c)) {
            try {
                c = "" + Secure.getString(context.getContentResolver(), "android_id");
            } catch (Throwable e) {
                i.a("getAndroidID Exception = ", e);
            }
        }
        return c;
    }

    public static String d(Context context) {
        if (TextUtils.isEmpty(b)) {
            b = ((WifiManager) context.getSystemService(IXAdSystemUtils.NT_WIFI)).getConnectionInfo().getMacAddress();
        }
        return b;
    }

    public static String e(Context context) {
        return j(context) + "*" + k(context);
    }

    public static String f(Context context) {
        try {
            return context.getResources().getConfiguration().locale.toString();
        } catch (Throwable e) {
            i.a("getLocale Exception = ", e);
            return "";
        }
    }

    public static int g(Context context) {
        if (f == 0) {
            l(context);
        }
        return f;
    }

    public static String h(Context context) {
        if (TextUtils.isEmpty(g)) {
            l(context);
        }
        return g;
    }

    private static boolean i(Context context) {
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

    private static int j(Context context) {
        if (d <= 0) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            displayMetrics = context.getResources().getDisplayMetrics();
            d = displayMetrics.widthPixels;
            e = displayMetrics.heightPixels;
        }
        return d;
    }

    private static int k(Context context) {
        if (e <= 0) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            displayMetrics = context.getResources().getDisplayMetrics();
            d = displayMetrics.widthPixels;
            e = displayMetrics.heightPixels;
        }
        return e;
    }

    private static void l(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            f = packageInfo.versionCode;
            g = packageInfo.versionName;
        } catch (Throwable e) {
            i.a("getVersionInfo Exception = ", e);
        }
    }
}
