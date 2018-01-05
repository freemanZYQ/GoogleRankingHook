package com.baidu.location.e;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.LocationClientOption;
import com.baidu.location.b.g;
import com.baidu.location.b.h;
import com.baidu.location.b.j;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class v {
    private static Method e = null;
    private static Method f = null;
    private static Method g = null;
    private static Class h = null;
    d a = new d(this);
    private Context b = null;
    private TelephonyManager c = null;
    private b d = new b();
    private WifiManager i = null;
    private c j = null;
    private String k = null;
    private LocationClientOption l;
    private a m;
    private String n = null;

    public interface a {
        void onReceiveLocation(BDLocation bDLocation);
    }

    class b {
        public int a;
        public int b;
        public int c;
        public int d;
        public char e;
        final /* synthetic */ v f;

        private b(v vVar) {
            this.f = vVar;
            this.a = -1;
            this.b = -1;
            this.c = -1;
            this.d = -1;
            this.e = '\u0000';
        }

        private boolean b() {
            return this.a > -1 && this.b > 0;
        }

        public String a() {
            if (!b()) {
                return null;
            }
            StringBuffer stringBuffer = new StringBuffer(128);
            stringBuffer.append(this.b + 23);
            stringBuffer.append("H");
            stringBuffer.append(this.a + 45);
            stringBuffer.append("K");
            stringBuffer.append(this.d + 54);
            stringBuffer.append("Q");
            stringBuffer.append(this.c + 203);
            return stringBuffer.toString();
        }

        public String toString() {
            if (!b()) {
                return null;
            }
            StringBuffer stringBuffer = new StringBuffer(128);
            stringBuffer.append("&nw=");
            stringBuffer.append(this.e);
            stringBuffer.append(String.format(Locale.CHINA, "&cl=%d|%d|%d|%d", new Object[]{Integer.valueOf(this.c), Integer.valueOf(this.d), Integer.valueOf(this.a), Integer.valueOf(this.b)}));
            return stringBuffer.toString();
        }
    }

    public class c {
        public List a = null;
        final /* synthetic */ v b;
        private long c = 0;

        public c(v vVar, List list) {
            this.b = vVar;
            this.a = list;
            this.c = System.currentTimeMillis();
            b();
        }

        private void b() {
            if (a() >= 1) {
                Object obj = 1;
                for (int size = this.a.size() - 1; size >= 1 && r2 != null; size--) {
                    int i = 0;
                    obj = null;
                    while (i < size) {
                        Object obj2;
                        if (((ScanResult) this.a.get(i)).level < ((ScanResult) this.a.get(i + 1)).level) {
                            ScanResult scanResult = (ScanResult) this.a.get(i + 1);
                            this.a.set(i + 1, this.a.get(i));
                            this.a.set(i, scanResult);
                            obj2 = 1;
                        } else {
                            obj2 = obj;
                        }
                        i++;
                        obj = obj2;
                    }
                }
            }
        }

        public int a() {
            return this.a == null ? 0 : this.a.size();
        }

        public String a(int i) {
            if (a() < 2) {
                return null;
            }
            StringBuffer stringBuffer = new StringBuffer(512);
            int size = this.a.size();
            int i2 = 0;
            int i3 = 0;
            int i4 = 1;
            while (i2 < size) {
                int i5;
                if (((ScanResult) this.a.get(i2)).level == 0) {
                    i5 = i3;
                } else {
                    if (i4 != 0) {
                        stringBuffer.append("&wf=");
                        i4 = 0;
                    } else {
                        stringBuffer.append("|");
                    }
                    stringBuffer.append(((ScanResult) this.a.get(i2)).BSSID.replace(":", ""));
                    i5 = ((ScanResult) this.a.get(i2)).level;
                    if (i5 < 0) {
                        i5 = -i5;
                    }
                    stringBuffer.append(String.format(Locale.CHINA, ";%d;", new Object[]{Integer.valueOf(i5)}));
                    i5 = i3 + 1;
                    if (i5 > i) {
                        break;
                    }
                }
                i2++;
                i3 = i5;
            }
            return i4 != 0 ? null : stringBuffer.toString();
        }
    }

    class d extends j {
        String a;
        final /* synthetic */ v k;

        d(v vVar) {
            this.k = vVar;
            this.a = null;
            this.f = new ArrayList();
        }

        public void a() {
            this.c = h.b();
            String H = Jni.H(this.a);
            this.a = null;
            this.f.add(new BasicNameValuePair("bloc", H));
            StringBuffer stringBuffer = new StringBuffer(512);
            stringBuffer.append(String.format(Locale.CHINA, "&ki=%s&sn=%s", new Object[]{g.b(this.k.b), g.a(this.k.b)}));
            if (stringBuffer.length() > 0) {
                this.f.add(new BasicNameValuePair("ext", Jni.H(stringBuffer.toString())));
            }
            this.f.add(new BasicNameValuePair("trtm", String.format(Locale.CHINA, "%d", new Object[]{Long.valueOf(System.currentTimeMillis())})));
        }

        public void a(String str) {
            this.a = str;
            f();
        }

        public void a(boolean z) {
            if (z && this.e != null) {
                try {
                    BDLocation bDLocation;
                    try {
                        bDLocation = new BDLocation(EntityUtils.toString(this.e, "utf-8"));
                    } catch (Exception e) {
                        bDLocation = new BDLocation();
                        bDLocation.setLocType(63);
                    }
                    if (bDLocation != null) {
                        if (bDLocation.getLocType() == BDLocation.TypeNetWorkLocation) {
                            bDLocation.setCoorType(this.k.l.coorType);
                            this.k.m.onReceiveLocation(bDLocation);
                        }
                    }
                } catch (Exception e2) {
                }
            }
            if (this.f != null) {
                this.f.clear();
            }
        }
    }

    public v(Context context, LocationClientOption locationClientOption, a aVar) {
        String deviceId;
        String a;
        this.b = context.getApplicationContext();
        this.l = locationClientOption;
        this.m = aVar;
        String packageName = this.b.getPackageName();
        try {
            this.c = (TelephonyManager) this.b.getSystemService("phone");
            deviceId = this.c.getDeviceId();
        } catch (Exception e) {
            deviceId = null;
        }
        try {
            a = com.baidu.location.f.a.a.a(this.b);
        } catch (Exception e2) {
            a = null;
        }
        if (a != null) {
            this.k = "&prod=" + this.l.prodName + ":" + packageName + "|&cu=" + a + "&coor=" + locationClientOption.getCoorType();
        } else {
            this.k = "&prod=" + this.l.prodName + ":" + packageName + "|&im=" + deviceId + "&coor=" + locationClientOption.getCoorType();
        }
        StringBuffer stringBuffer = new StringBuffer(256);
        stringBuffer.append("&fw=");
        stringBuffer.append("6.05");
        stringBuffer.append("&lt=1");
        stringBuffer.append("&mb=");
        stringBuffer.append(Build.MODEL);
        stringBuffer.append("&resid=");
        stringBuffer.append("12");
        if (locationClientOption.getAddrType() != null) {
        }
        if (locationClientOption.getAddrType() != null && locationClientOption.getAddrType().equals("all")) {
            this.k += "&addr=all";
        }
        if (locationClientOption.isNeedAptag || locationClientOption.isNeedAptagd) {
            this.k += "&sema=";
            if (locationClientOption.isNeedAptag) {
                this.k += "aptag|";
            }
            if (locationClientOption.isNeedAptagd) {
                this.k += "aptagd|";
            }
        }
        stringBuffer.append("&first=1");
        stringBuffer.append(VERSION.SDK);
        this.k += stringBuffer.toString();
        this.i = (WifiManager) this.b.getSystemService(IXAdSystemUtils.NT_WIFI);
        Object a2 = a();
        if (!TextUtils.isEmpty(a2)) {
            a2 = a2.replace(":", "");
        }
        if (!TextUtils.isEmpty(a2)) {
            this.k += "&mac=" + a2;
        }
        b();
    }

    private String a(int i) {
        String bVar;
        String a;
        if (i < 3) {
            i = 3;
        }
        try {
            a(this.c.getCellLocation());
            bVar = this.d.toString();
        } catch (Exception e) {
            bVar = null;
        }
        try {
            if (this.j == null) {
                this.j = new c(this, this.i.getScanResults());
            }
            a = this.j.a(i);
        } catch (Exception e2) {
            a = null;
        }
        if (bVar == null && a == null) {
            this.n = null;
            return null;
        }
        if (a != null) {
            bVar = bVar + a;
        }
        if (bVar == null) {
            return null;
        }
        this.n = bVar + this.k;
        return bVar + this.k;
    }

    private void a(CellLocation cellLocation) {
        int i = 0;
        if (cellLocation != null && this.c != null) {
            b bVar = new b();
            String networkOperator = this.c.getNetworkOperator();
            if (networkOperator != null && networkOperator.length() > 0) {
                try {
                    if (networkOperator.length() >= 3) {
                        int intValue = Integer.valueOf(networkOperator.substring(0, 3)).intValue();
                        if (intValue < 0) {
                            intValue = this.d.c;
                        }
                        bVar.c = intValue;
                    }
                    String substring = networkOperator.substring(3);
                    if (substring != null) {
                        char[] toCharArray = substring.toCharArray();
                        while (i < toCharArray.length && Character.isDigit(toCharArray[i])) {
                            i++;
                        }
                    }
                    i = Integer.valueOf(substring.substring(0, i)).intValue();
                    if (i < 0) {
                        i = this.d.d;
                    }
                    bVar.d = i;
                } catch (Exception e) {
                }
            }
            if (cellLocation instanceof GsmCellLocation) {
                bVar.a = ((GsmCellLocation) cellLocation).getLac();
                bVar.b = ((GsmCellLocation) cellLocation).getCid();
                bVar.e = 'g';
            } else if (cellLocation instanceof CdmaCellLocation) {
                bVar.e = 'c';
                if (h == null) {
                    try {
                        h = Class.forName("android.telephony.cdma.CdmaCellLocation");
                        e = h.getMethod("getBaseStationId", new Class[0]);
                        f = h.getMethod("getNetworkId", new Class[0]);
                        g = h.getMethod("getSystemId", new Class[0]);
                    } catch (Exception e2) {
                        h = null;
                        return;
                    }
                }
                if (h != null && h.isInstance(cellLocation)) {
                    try {
                        i = ((Integer) g.invoke(cellLocation, new Object[0])).intValue();
                        if (i < 0) {
                            i = this.d.d;
                        }
                        bVar.d = i;
                        bVar.b = ((Integer) e.invoke(cellLocation, new Object[0])).intValue();
                        bVar.a = ((Integer) f.invoke(cellLocation, new Object[0])).intValue();
                    } catch (Exception e3) {
                        return;
                    }
                }
            }
            if (bVar.b()) {
                this.d = bVar;
            }
        }
    }

    public String a() {
        String str = null;
        try {
            WifiInfo connectionInfo = this.i.getConnectionInfo();
            if (connectionInfo != null) {
                str = connectionInfo.getMacAddress();
            }
        } catch (Exception e) {
        }
        return str;
    }

    public String b() {
        try {
            return a(15);
        } catch (Exception e) {
            return null;
        }
    }

    public void c() {
        if (this.n != null) {
            BDLocation bDLocation = null;
            if (!(this.l.scanSpan < LocationClientOption.MIN_SCAN_SPAN || this.l.getAddrType().equals("all") || this.l.isNeedAptag || this.l.isNeedAptagd)) {
                bDLocation = com.baidu.location.c.d.a().a(this.d.a(), this.i.getScanResults(), false);
                if (!this.l.coorType.equals("gcj02")) {
                    double longitude = bDLocation.getLongitude();
                    double latitude = bDLocation.getLatitude();
                    if (!(longitude == Double.MIN_VALUE || latitude == Double.MIN_VALUE)) {
                        double[] dArr = Jni.if(longitude, latitude, this.l.coorType);
                        bDLocation.setLongitude(dArr[0]);
                        bDLocation.setLatitude(dArr[1]);
                        bDLocation.setCoorType(this.l.coorType);
                    }
                }
                if (bDLocation.getLocType() == 66) {
                    this.m.onReceiveLocation(bDLocation);
                }
            }
            if (bDLocation == null) {
                this.a.a(this.n);
            }
        }
    }
}
