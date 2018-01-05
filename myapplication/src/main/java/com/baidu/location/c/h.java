package com.baidu.location.c;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import com.baidu.location.BDLocation;
import com.baidu.location.b.q;
import com.baidu.location.f;
import com.baidu.location.h.g;
import com.baidu.location.h.i;
import java.io.File;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class h {
    static final String a = "http://loc.map.baidu.com/offline_loc";
    static final String b = "com.baidu.lbs.offlinelocationprovider";
    private static Context c;
    private static h d;
    private final File e;
    private final q f;
    private final a g;
    private final k h;
    private final j i;

    enum a {
        NETWORK_UNKNOWN,
        NETWORK_WIFI,
        NETWORK_2G,
        NETWORK_3G,
        NETWORK_4G
    }

    public enum b {
        NEED_TO_LOG,
        NO_NEED_TO_LOG
    }

    public enum c {
        IS_MIX_MODE,
        IS_NOT_MIX_MODE
    }

    private h() {
        File file;
        try {
            file = new File(c.getFilesDir(), "ofld");
            try {
                if (!file.exists()) {
                    file.mkdir();
                }
            } catch (Exception e) {
            }
        } catch (Exception e2) {
            file = null;
        }
        this.e = file;
        this.g = new a(this);
        this.f = new q(this.g.a());
        this.i = new j(this, this.g.a());
        this.h = new k(this, this.g.a(), this.i.n());
    }

    private BDLocation a(String[] strArr) {
        BDLocation bDLocation = new BDLocation();
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        bDLocation = (FutureTask) newSingleThreadExecutor.submit(new i(this, strArr));
        try {
            bDLocation = (BDLocation) bDLocation.get(500, TimeUnit.MILLISECONDS);
            return bDLocation;
        } catch (InterruptedException e) {
            bDLocation.cancel(true);
            return null;
        } catch (ExecutionException e2) {
            bDLocation.cancel(true);
            return null;
        } catch (TimeoutException e3) {
            q.a().a("offlineLocation Timeout Exception!");
            bDLocation.cancel(true);
            return null;
        } finally {
            newSingleThreadExecutor.shutdown();
        }
    }

    public static h a() {
        if (d == null) {
            synchronized (h.class) {
                if (d == null) {
                    if (c == null) {
                        a(f.getServiceContext());
                    }
                    d = new h();
                }
            }
        }
        d.q();
        return d;
    }

    public static void a(Context context) {
        if (c == null) {
            c = context;
        }
    }

    private static final Uri c(String str) {
        return Uri.parse(String.format("content://%s/", new Object[]{str}));
    }

    private void q() {
        this.i.g();
    }

    private boolean r() {
        ProviderInfo providerInfo;
        String packageName = c.getPackageName();
        ProviderInfo resolveContentProvider = c.getPackageManager().resolveContentProvider(b, 0);
        if (resolveContentProvider == null) {
            String[] o = this.i.o();
            providerInfo = resolveContentProvider;
            for (String resolveContentProvider2 : o) {
                providerInfo = c.getPackageManager().resolveContentProvider(resolveContentProvider2, 0);
                if (providerInfo != null) {
                    break;
                }
            }
        } else {
            providerInfo = resolveContentProvider;
        }
        return providerInfo == null ? true : packageName.equals(providerInfo.packageName);
    }

    public long a(String str) {
        return this.i.a(str);
    }

    public BDLocation a(i iVar, g gVar, BDLocation bDLocation, c cVar, b bVar) {
        int a;
        String str;
        if (cVar == c.IS_MIX_MODE) {
            a = this.i.a();
            str = com.baidu.location.b.b.a().d() + "&mixMode=1";
        } else {
            str = com.baidu.location.b.b.a().d();
            a = 0;
        }
        String[] a2 = g.a(iVar, gVar, bDLocation, str, (bVar == b.NEED_TO_LOG ? Boolean.valueOf(true) : Boolean.valueOf(false)).booleanValue(), a);
        BDLocation bDLocation2 = null;
        if (a2.length > 0) {
            bDLocation2 = a(a2);
            if (bDLocation2 == null || bDLocation2.getLocType() != 67) {
                return bDLocation2;
            }
        }
        return bDLocation2;
    }

    Context b() {
        return c;
    }

    File c() {
        return this.e;
    }

    public boolean d() {
        return this.i.h();
    }

    public boolean e() {
        return this.i.i();
    }

    public boolean f() {
        return this.i.j();
    }

    public boolean g() {
        return this.i.k();
    }

    public boolean h() {
        return this.i.m();
    }

    public void i() {
        this.f.a();
    }

    q j() {
        return this.f;
    }

    k k() {
        return this.h;
    }

    j l() {
        return this.i;
    }

    public void m() {
        if (r()) {
            this.g.b();
        }
    }

    public void n() {
    }

    public double o() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) c.getSystemService("connectivity")).getActiveNetworkInfo();
        a aVar = a.NETWORK_UNKNOWN;
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            if (activeNetworkInfo.getType() == 1) {
                aVar = a.NETWORK_WIFI;
            }
            if (activeNetworkInfo.getType() == 0) {
                int subtype = activeNetworkInfo.getSubtype();
                if (subtype == 1 || subtype == 2 || subtype == 4 || subtype == 7 || subtype == 11) {
                    aVar = a.NETWORK_2G;
                } else if (subtype == 3 || subtype == 5 || subtype == 6 || subtype == 8 || subtype == 9 || subtype == 10 || subtype == 12 || subtype == 14 || subtype == 15) {
                    aVar = a.NETWORK_3G;
                } else if (subtype == 13) {
                    aVar = a.NETWORK_4G;
                }
            }
        }
        return aVar == a.NETWORK_UNKNOWN ? this.i.b() : aVar == a.NETWORK_WIFI ? this.i.c() : aVar == a.NETWORK_2G ? this.i.d() : aVar == a.NETWORK_3G ? this.i.e() : aVar == a.NETWORK_4G ? this.i.f() : 0.0d;
    }
}
