package com.baidu.location.b;

import android.content.Context;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Environment;
import android.text.TextUtils;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClientOption;
import com.baidu.location.f;
import com.baidu.location.h.a;
import com.baidu.location.h.c;
import com.baidu.location.h.d;
import com.baidu.location.h.g;
import com.baidu.location.h.i;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import com.qq.e.comm.constants.ErrorCode.InitError;
import java.io.File;
import java.io.FileInputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Calendar;
import java.util.Locale;

public class h {
    public static int A = 3;
    public static int B = 10;
    public static int C = 2;
    public static int D = 7;
    public static int E = 20;
    public static int F = 70;
    public static int G = 120;
    public static float H = 2.0f;
    public static float I = 10.0f;
    public static float J = 50.0f;
    public static float K = 200.0f;
    public static int L = 16;
    public static float M = 0.9f;
    public static int N = 10000;
    public static float O = 0.5f;
    public static float P = 0.0f;
    public static float Q = 0.1f;
    public static int R = 30;
    public static int S = 100;
    public static int T = 420000;
    public static boolean U = true;
    public static boolean V = true;
    public static int W = 20;
    public static int X = InitError.INIT_AD_ERROR;
    public static int Y = LocationClientOption.MIN_SCAN_SPAN;
    public static long Z = 900000;
    public static boolean a = false;
    public static long aa = 420000;
    public static long ab = 180000;
    public static long ac = 0;
    public static long ad = 15;
    public static long ae = 300000;
    public static int af = LocationClientOption.MIN_SCAN_SPAN;
    public static int ag = 0;
    public static int ah = 30000;
    public static int ai = 30000;
    public static float aj = 10.0f;
    public static float ak = 6.0f;
    public static float al = 10.0f;
    public static int am = 60;
    public static int an = 70;
    public static int ao = 6;
    private static String ap = "http://loc.map.baidu.com/sdk.php";
    private static String aq = "http://loc.map.baidu.com/user_err.php";
    private static String ar = "http://loc.map.baidu.com/oqur.php";
    private static String as = "http://loc.map.baidu.com/tcu.php";
    private static String at = "http://loc.map.baidu.com/iofd.php";
    private static String au = "https://sapi.skyhookwireless.com/wps2/location";
    private static String av = "http://loc.map.baidu.com/wloc";
    public static boolean b = false;
    public static boolean c = false;
    public static int d = 0;
    public static String e = "http://loc.map.baidu.com/sdk_ep.php";
    public static String f = "no";
    public static boolean g = false;
    public static boolean h = false;
    public static boolean i = false;
    public static boolean j = false;
    public static boolean k = false;
    public static String l = "gcj02";
    public static boolean m = true;
    public static int n = 3;
    public static double o = 0.0d;
    public static double p = 0.0d;
    public static double q = 0.0d;
    public static double r = 0.0d;
    public static int s = 0;
    public static byte[] t = null;
    public static boolean u = false;
    public static int v = 0;
    public static float w = 1.1f;
    public static float x = 2.2f;
    public static float y = 2.3f;
    public static float z = 3.8f;

    public static int a(String str, String str2, String str3) {
        int i = Integer.MIN_VALUE;
        if (!(str == null || str.equals(""))) {
            int indexOf = str.indexOf(str2);
            if (indexOf != -1) {
                indexOf += str2.length();
                int indexOf2 = str.indexOf(str3, indexOf);
                if (indexOf2 != -1) {
                    String substring = str.substring(indexOf, indexOf2);
                    if (!(substring == null || substring.equals(""))) {
                        try {
                            i = Integer.parseInt(substring);
                        } catch (NumberFormatException e) {
                        }
                    }
                }
            }
        }
        return i;
    }

    public static String a() {
        Calendar instance = Calendar.getInstance();
        int i = instance.get(5);
        int i2 = instance.get(1);
        int i3 = instance.get(2) + 1;
        int i4 = instance.get(11);
        int i5 = instance.get(12);
        int i6 = instance.get(13);
        return String.format(Locale.CHINA, "%d-%02d-%02d %02d:%02d:%02d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)});
    }

    public static String a(i iVar, g gVar, Location location, String str, int i) {
        String b;
        StringBuffer stringBuffer = new StringBuffer(IXAdIOUtils.BUFFER_SIZE);
        if (iVar != null) {
            b = c.a().b(iVar);
            if (b != null) {
                stringBuffer.append(b);
            }
        }
        if (gVar != null) {
            b = i == 0 ? gVar.b() : gVar.c();
            if (b != null) {
                stringBuffer.append(b);
            }
        }
        if (location != null) {
            b = (d == 0 || i == 0) ? a.b(location) : a.c(location);
            if (b != null) {
                stringBuffer.append(b);
            }
        }
        boolean z = false;
        if (i == 0) {
            z = true;
        }
        b = b.a().a(z);
        if (b != null) {
            stringBuffer.append(b);
        }
        if (str != null) {
            stringBuffer.append(str);
        }
        Object d = com.baidu.location.e.i.a().d();
        if (!TextUtils.isEmpty(d)) {
            stringBuffer.append("&bc=").append(d);
        }
        if (i == 0) {
            if (iVar != null) {
                b = d.a().a(iVar);
                if (b != null && b.length() + stringBuffer.length() < 750) {
                    stringBuffer.append(b);
                }
            }
            b = stringBuffer.toString();
            if (location != null || gVar == null) {
                n = 3;
            } else {
                try {
                    float speed = location.getSpeed();
                    int i2 = d;
                    int d2 = gVar.d();
                    int a = gVar.a();
                    boolean e = gVar.e();
                    if (speed < ak && ((i2 == 1 || i2 == 0) && (d2 < am || e))) {
                        n = 1;
                    } else if (speed >= al || (!(i2 == 1 || i2 == 0 || i2 == 3) || (d2 >= an && a <= ao))) {
                        n = 3;
                    } else {
                        n = 2;
                    }
                } catch (Exception e2) {
                    n = 3;
                }
            }
            return b;
        }
        if (iVar != null) {
            b = d.a().a(iVar);
            stringBuffer.append(b);
        }
        b = stringBuffer.toString();
        if (location != null) {
        }
        n = 3;
        return b;
    }

    public static String a(File file) {
        if (!file.isFile()) {
            return null;
        }
        byte[] bArr = new byte[IXAdIOUtils.BUFFER_SIZE];
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            FileInputStream fileInputStream = new FileInputStream(file);
            while (true) {
                int read = fileInputStream.read(bArr, 0, IXAdIOUtils.BUFFER_SIZE);
                if (read != -1) {
                    instance.update(bArr, 0, read);
                } else {
                    fileInputStream.close();
                    return new BigInteger(1, instance.digest()).toString(16);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean a(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return false;
        }
        NetworkInfo[] allNetworkInfo = connectivityManager.getAllNetworkInfo();
        if (allNetworkInfo == null) {
            return false;
        }
        for (NetworkInfo state : allNetworkInfo) {
            if (state.getState() == State.CONNECTED) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(BDLocation bDLocation) {
        int locType = bDLocation.getLocType();
        return locType > 100 && locType < 200;
    }

    public static String b() {
        return ap;
    }

    public static String c() {
        return au;
    }

    public static String d() {
        return as;
    }

    public static String e() {
        if (!Environment.getExternalStorageState().equals("mounted")) {
            return null;
        }
        try {
            String path = Environment.getExternalStorageDirectory().getPath();
            File file = new File(path + "/baidu/tempdata");
            if (file.exists()) {
                return path;
            }
            file.mkdirs();
            return path;
        } catch (Exception e) {
            return null;
        }
    }

    public static String f() {
        String e = e();
        return e == null ? null : e + "/baidu/tempdata";
    }

    public static String g() {
        try {
            File file = new File(f.getServiceContext().getFilesDir() + File.separator + "lldt");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file.getAbsolutePath();
        } catch (Exception e) {
            return null;
        }
    }
}
