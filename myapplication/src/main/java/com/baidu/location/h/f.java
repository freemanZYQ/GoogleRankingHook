package com.baidu.location.h;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.baidu.location.e.r;
import com.baidu.location.e.u;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

public class f extends l {
    public static long a = 0;
    private static f b = null;
    private WifiManager c = null;
    private a d = null;
    private g e = null;
    private long f = 0;
    private long g = 0;
    private boolean h = false;
    private Object i = null;
    private Method j = null;
    private boolean k = true;

    class a extends BroadcastReceiver {
        final /* synthetic */ f a;

        private a(f fVar) {
            this.a = fVar;
        }

        public void onReceive(Context context, Intent intent) {
            if (context != null && intent.getAction().equals("android.net.wifi.SCAN_RESULTS")) {
                f.a = System.currentTimeMillis() / 1000;
                this.a.n();
                r.b().h();
                if (System.currentTimeMillis() - com.baidu.location.e.a.b() <= 5000) {
                    u.a(com.baidu.location.e.a.c(), this.a.j(), com.baidu.location.e.a.d(), com.baidu.location.e.a.a());
                }
            }
        }
    }

    private f() {
    }

    public static f a() {
        if (b == null) {
            b = new f();
        }
        return b;
    }

    public static boolean a(g gVar, g gVar2, float f) {
        if (gVar == null || gVar2 == null) {
            return false;
        }
        List list = gVar.a;
        List list2 = gVar2.a;
        if (list == list2) {
            return true;
        }
        if (list == null || list2 == null) {
            return false;
        }
        int size = list.size();
        int size2 = list2.size();
        float f2 = (float) (size + size2);
        if (size == 0 && size2 == 0) {
            return true;
        }
        if (size == 0 || size2 == 0) {
            return false;
        }
        int i = 0;
        int i2 = 0;
        while (i < size) {
            int i3;
            String str = ((ScanResult) list.get(i)).BSSID;
            if (str == null) {
                i3 = i2;
            } else {
                for (int i4 = 0; i4 < size2; i4++) {
                    if (str.equals(((ScanResult) list2.get(i4)).BSSID)) {
                        i3 = i2 + 1;
                        break;
                    }
                }
                i3 = i2;
            }
            i++;
            i2 = i3;
        }
        return ((float) (i2 * 2)) >= f2 * f;
    }

    private void n() {
        if (this.c != null) {
            try {
                g gVar = new g(this.c.getScanResults(), this.f);
                if (this.e == null || !gVar.a(this.e)) {
                    this.e = gVar;
                }
            } catch (Exception e) {
            }
        }
    }

    public boolean a(String str) {
        return super.a(str);
    }

    public synchronized void b() {
        if (!this.h) {
            if (com.baidu.location.f.isServing) {
                this.c = (WifiManager) com.baidu.location.f.getServiceContext().getSystemService(IXAdSystemUtils.NT_WIFI);
                this.d = new a();
                try {
                    com.baidu.location.f.getServiceContext().registerReceiver(this.d, new IntentFilter("android.net.wifi.SCAN_RESULTS"));
                } catch (Exception e) {
                }
                this.h = true;
                try {
                    Field declaredField = Class.forName("android.net.wifi.WifiManager").getDeclaredField("mService");
                    if (declaredField != null) {
                        declaredField.setAccessible(true);
                        this.i = declaredField.get(this.c);
                        this.i.getClass();
                    }
                } catch (Exception e2) {
                }
            }
        }
    }

    public synchronized void c() {
        if (this.h) {
            try {
                com.baidu.location.f.getServiceContext().unregisterReceiver(this.d);
                a = 0;
            } catch (Exception e) {
            }
            this.d = null;
            this.c = null;
            this.h = false;
        }
    }

    public boolean d() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.g <= 5000) {
            return false;
        }
        this.g = currentTimeMillis;
        return e();
    }

    public boolean e() {
        return (this.c != null && System.currentTimeMillis() - this.f > 3000) ? f() : false;
    }

    public boolean f() {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Exception block dominator not found, method:com.baidu.location.h.f.f():boolean. bs: [B:12:0x0020, B:21:0x0050]
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:86)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r7 = this;
        r1 = 1;
        r0 = 0;
        r2 = r7.c;	 Catch:{ NoSuchMethodError -> 0x0042, Exception -> 0x0056 }
        r2 = r2.isWifiEnabled();	 Catch:{ NoSuchMethodError -> 0x0042, Exception -> 0x0056 }
        if (r2 != 0) goto L_0x0018;	 Catch:{ NoSuchMethodError -> 0x0042, Exception -> 0x0056 }
    L_0x000a:
        r2 = android.os.Build.VERSION.SDK_INT;	 Catch:{ NoSuchMethodError -> 0x0042, Exception -> 0x0056 }
        r3 = 17;	 Catch:{ NoSuchMethodError -> 0x0042, Exception -> 0x0056 }
        if (r2 <= r3) goto L_0x003a;	 Catch:{ NoSuchMethodError -> 0x0042, Exception -> 0x0056 }
    L_0x0010:
        r2 = r7.c;	 Catch:{ NoSuchMethodError -> 0x0042, Exception -> 0x0056 }
        r2 = r2.isScanAlwaysAvailable();	 Catch:{ NoSuchMethodError -> 0x0042, Exception -> 0x0056 }
        if (r2 == 0) goto L_0x003a;	 Catch:{ NoSuchMethodError -> 0x0042, Exception -> 0x0056 }
    L_0x0018:
        r2 = r7.j;	 Catch:{ NoSuchMethodError -> 0x0042, Exception -> 0x0056 }
        if (r2 == 0) goto L_0x0050;	 Catch:{ NoSuchMethodError -> 0x0042, Exception -> 0x0056 }
    L_0x001c:
        r2 = r7.i;	 Catch:{ NoSuchMethodError -> 0x0042, Exception -> 0x0056 }
        if (r2 == 0) goto L_0x0050;
    L_0x0020:
        r2 = r7.j;	 Catch:{ Exception -> 0x003b, NoSuchMethodError -> 0x0042 }
        r3 = r7.i;	 Catch:{ Exception -> 0x003b, NoSuchMethodError -> 0x0042 }
        r4 = 1;	 Catch:{ Exception -> 0x003b, NoSuchMethodError -> 0x0042 }
        r4 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x003b, NoSuchMethodError -> 0x0042 }
        r5 = 0;	 Catch:{ Exception -> 0x003b, NoSuchMethodError -> 0x0042 }
        r6 = r7.k;	 Catch:{ Exception -> 0x003b, NoSuchMethodError -> 0x0042 }
        r6 = java.lang.Boolean.valueOf(r6);	 Catch:{ Exception -> 0x003b, NoSuchMethodError -> 0x0042 }
        r4[r5] = r6;	 Catch:{ Exception -> 0x003b, NoSuchMethodError -> 0x0042 }
        r2.invoke(r3, r4);	 Catch:{ Exception -> 0x003b, NoSuchMethodError -> 0x0042 }
    L_0x0033:
        r2 = java.lang.System.currentTimeMillis();	 Catch:{ NoSuchMethodError -> 0x0042, Exception -> 0x0056 }
        r7.f = r2;	 Catch:{ NoSuchMethodError -> 0x0042, Exception -> 0x0056 }
        r0 = r1;	 Catch:{ NoSuchMethodError -> 0x0042, Exception -> 0x0056 }
    L_0x003a:
        return r0;	 Catch:{ NoSuchMethodError -> 0x0042, Exception -> 0x0056 }
    L_0x003b:
        r2 = move-exception;	 Catch:{ NoSuchMethodError -> 0x0042, Exception -> 0x0056 }
        r2 = r7.c;	 Catch:{ NoSuchMethodError -> 0x0042, Exception -> 0x0056 }
        r2.startScan();	 Catch:{ NoSuchMethodError -> 0x0042, Exception -> 0x0056 }
        goto L_0x0033;
    L_0x0042:
        r0 = move-exception;
        r0 = r7.c;
        r0.startScan();
        r2 = java.lang.System.currentTimeMillis();
        r7.f = r2;
        r0 = r1;
        goto L_0x003a;
    L_0x0050:
        r2 = r7.c;	 Catch:{ NoSuchMethodError -> 0x0042, Exception -> 0x0056 }
        r2.startScan();	 Catch:{ NoSuchMethodError -> 0x0042, Exception -> 0x0056 }
        goto L_0x0033;
    L_0x0056:
        r1 = move-exception;
        goto L_0x003a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.h.f.f():boolean");
    }

    public boolean g() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) com.baidu.location.f.getServiceContext().getSystemService("connectivity")).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.getType() == 1;
        } catch (Exception e) {
            return false;
        }
    }

    public int h() {
        if (this.c == null) {
            return -1;
        }
        WifiInfo connectionInfo = this.c.getConnectionInfo();
        if (connectionInfo == null) {
            return -1;
        }
        try {
            String bssid = connectionInfo.getBSSID();
            int rssi = connectionInfo.getRssi();
            if (rssi < 0) {
                rssi = -rssi;
            }
            if (bssid != null) {
                bssid = bssid.replace(":", "");
                if ("000000000000".equals(bssid) || "".equals(bssid)) {
                    return -1;
                }
            }
            return rssi;
        } catch (Exception e) {
            return -1;
        }
    }

    public String i() {
        if (this.c == null) {
            return null;
        }
        WifiInfo connectionInfo = this.c.getConnectionInfo();
        if (connectionInfo == null) {
            return null;
        }
        try {
            String bssid = connectionInfo.getBSSID();
            if (bssid != null) {
                bssid = bssid.replace(":", "");
                if ("000000000000".equals(bssid) || "".equals(bssid)) {
                    return null;
                }
            }
            bssid = null;
            return bssid;
        } catch (Exception e) {
            return null;
        }
    }

    public g j() {
        return (this.e == null || !this.e.f()) ? l() : this.e;
    }

    public g k() {
        return (this.e == null || !this.e.g()) ? l() : this.e;
    }

    public g l() {
        if (this.c != null) {
            try {
                return new g(this.c.getScanResults(), this.f);
            } catch (Exception e) {
            }
        }
        return new g(null, 0);
    }

    public String m() {
        String str = null;
        try {
            WifiInfo connectionInfo = this.c.getConnectionInfo();
            if (connectionInfo != null) {
                str = connectionInfo.getMacAddress();
            }
        } catch (Exception e) {
        }
        return str;
    }
}
