package com.baidu.mobads.production.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Rect;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.webkit.CookieManager;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.interfaces.utils.IXAdCommonUtils;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import com.baidu.mobads.j.m;
import java.util.HashSet;
import java.util.Set;

public class b {
    private Set a;
    private Set b;
    private Set c;
    private CookieManager d;
    private IXAdSystemUtils e = m.a().n();
    private IXAdCommonUtils f = m.a().m();
    private Context g;
    private int h;
    private String i;

    public b(Context context, int i, String str) {
        this.g = context;
        this.h = i;
        this.i = str;
        this.d = CookieManager.getInstance();
        this.d.setAcceptCookie(true);
        b();
    }

    private String a(String str) {
        return str == null ? null : str.replace(":", "-");
    }

    private void a(String str, Object obj) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append("=");
        stringBuffer.append(obj);
        stringBuffer.append(";");
        this.d.setCookie("http://cpu.baidu.com/", stringBuffer.toString());
    }

    private void b() {
        this.a = new HashSet();
        this.a.add("46000");
        this.a.add("46002");
        this.a.add("46007");
        this.b = new HashSet();
        this.b.add("46001");
        this.b.add("46006");
        this.c = new HashSet();
        this.c.add("46003");
        this.c.add("46005");
    }

    private void c() {
        Object obj = null;
        int i = 0;
        Rect screenRect = this.f.getScreenRect(this.g);
        int height = screenRect.height();
        int width = screenRect.width();
        boolean d = d();
        Object a = d ? a(g()) : null;
        int e = d ? e() : 0;
        if (d) {
            obj = f();
        }
        if (d) {
            i = 1;
        }
        String cuid = this.e.getCUID(this.g);
        a(IXAdRequestInfo.V, h());
        a(IXAdRequestInfo.IMSI, this.e.getIMEI(this.g));
        a("aid", this.e.getAndroidId(this.g));
        a("m", a(this.e.getMacAddress(this.g)));
        a("cuid", cuid);
        a("ct", Integer.valueOf(a.a(this.g)));
        a("oi", Integer.valueOf(i()));
        a("src", Integer.valueOf(1));
        a(IXAdRequestInfo.HEIGHT, Integer.valueOf(height));
        a(IXAdRequestInfo.WIDTH, Integer.valueOf(width));
        a("apm", a);
        a("rssi", Integer.valueOf(e));
        a("apn", obj);
        a("isc", Integer.valueOf(i));
    }

    private boolean d() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.g.getSystemService("connectivity")).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.getType() == 1;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private int e() {
        try {
            WifiInfo connectionInfo = ((WifiManager) this.g.getSystemService(IXAdSystemUtils.NT_WIFI)).getConnectionInfo();
            return connectionInfo == null ? 0 : connectionInfo.getRssi();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    private String f() {
        try {
            WifiInfo connectionInfo = ((WifiManager) this.g.getSystemService(IXAdSystemUtils.NT_WIFI)).getConnectionInfo();
            String ssid = connectionInfo == null ? "" : connectionInfo.getSSID();
            if (ssid.startsWith("\"") && ssid.endsWith("\"")) {
                return ssid.substring(1, ssid.length() - 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    private String g() {
        try {
            WifiInfo connectionInfo = ((WifiManager) this.g.getSystemService(IXAdSystemUtils.NT_WIFI)).getConnectionInfo();
            return connectionInfo == null ? null : connectionInfo.getMacAddress();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private String h() {
        try {
            PackageInfo packageInfo = this.g.getPackageManager().getPackageInfo(this.g.getPackageName(), 0);
            String str = packageInfo == null ? null : packageInfo.versionName;
            return str != null ? str.replace(".", "-") : null;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    private int i() {
        String networkOperator = this.e.getNetworkOperator(this.g);
        return networkOperator == null ? 0 : this.a.contains(networkOperator) ? 1 : this.c.contains(networkOperator) ? 2 : this.b.contains(networkOperator) ? 3 : 99;
    }

    public String a() {
        c();
        return "http://cpu.baidu.com/" + this.h + "/" + this.i;
    }
}
