package com.baidu.mobads.h;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.baidu.mobads.interfaces.IXAdContainerFactory;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.j.m;
import java.io.File;
import java.io.IOException;
import java.lang.Thread.UncaughtExceptionHandler;

public class g {
    protected static UncaughtExceptionHandler a;
    protected static volatile a b = null;
    protected static volatile a c = null;
    protected static final Handler e = new h(Looper.getMainLooper());
    private static String h;
    protected String d = null;
    protected Handler f = e;
    @SuppressLint({"HandlerLeak"})
    protected final Handler g = new i(this, Looper.getMainLooper());
    private com.baidu.mobads.openad.e.a i;
    private e j;
    private final Context k;
    private IXAdLogger l = m.a().f();
    private c m;

    public final class a extends Exception {
        public a(String str) {
            m.a().f().e(str);
        }
    }

    public final class b extends Exception {
        public b(String str) {
            m.a().f().e(str);
        }
    }

    public interface c {
        void a(boolean z);
    }

    public g(Context context) {
        if (h == null) {
            h = "http://mobads.baidu.com/ads/pa/" + com.baidu.mobads.a.b.b() + "/__pasys_remote_banner.php";
        }
        this.k = context;
        this.d = context.getDir("baidu_ad_sdk", 0).getAbsolutePath() + "/";
        if (a == null) {
            a = q.a(context);
            q.a(context).a(new j(this));
        }
        if (!(Thread.getDefaultUncaughtExceptionHandler() instanceof q)) {
            Thread.setDefaultUncaughtExceptionHandler(a);
        }
    }

    private IXAdContainerFactory a(a aVar) {
        IXAdContainerFactory iXAdContainerFactory = null;
        if (aVar != null) {
            try {
                iXAdContainerFactory = aVar.a();
            } catch (Exception e) {
            }
        }
        return iXAdContainerFactory;
    }

    private void a(b bVar) {
        Class b = bVar.b();
        synchronized (this) {
            c = new a(b, this.k, com.baidu.mobads.a.b.a(), com.baidu.mobads.a.b.a);
        }
    }

    private void a(e eVar) {
        if (eVar.a().booleanValue()) {
            c a = c.a(this.k, eVar, this.d, this.g);
            if (a.isAlive()) {
                this.l.d("XAdApkLoader", "XApkDownloadThread already started");
                a.a(eVar.c());
                return;
            }
            this.l.d("XAdApkLoader", "XApkDownloadThread starting ...");
            a.start();
        }
    }

    private void a(boolean z) {
        Message obtainMessage = this.f.obtainMessage();
        Bundle bundle = new Bundle();
        bundle.putBoolean("success", z);
        obtainMessage.setData(bundle);
        obtainMessage.what = 0;
        this.f.sendMessage(obtainMessage);
    }

    private void a(boolean z, String str) {
        if (this.m != null) {
            this.m.a(z);
        }
    }

    private void b(b bVar) {
        Log.i("XAdApkLoader", "len=" + bVar.length() + ", path=" + bVar.getAbsolutePath());
        if (b == null) {
            b = new a(bVar.b(), this.k, com.baidu.mobads.a.b.a(), com.baidu.mobads.a.b.a);
            try {
                this.l.d("XAdApkLoader", "preloaded apk.version=" + b.a().getRemoteVersion());
                return;
            } catch (a e) {
                this.l.w("XAdApkLoader", "preload local apk " + bVar.getAbsolutePath() + " failed, msg:" + e.getMessage() + ", v=" + b.a);
                a(e.getMessage());
                throw e;
            }
        }
        this.l.w("XAdApkLoader", "mApkBuilder already initialized, version: " + b.a);
    }

    private void b(c cVar, Handler handler) {
        this.m = cVar;
        this.f = handler;
        if (b == null) {
            f();
        } else {
            b(true);
        }
    }

    private void b(boolean z) {
        a(z, z ? "apk Successfully Loaded" : "apk Load Failed");
        new Handler(Looper.getMainLooper()).postDelayed(new k(this, z), 5000);
    }

    private void c(b bVar) {
        synchronized (this) {
            b(bVar);
            this.l.d("XAdApkLoader", "loaded: " + bVar.getPath());
            b(true);
        }
    }

    private SharedPreferences j() {
        return this.k.getSharedPreferences("com.baidu.mobads.loader", 0);
    }

    private boolean k() {
        String string = j().getString("previousProxyVersion", null);
        return string == null || !string.equals(a());
    }

    private synchronized void l() {
        try {
            if (this.i != null) {
                this.i.removeAllListeners();
                this.i.a();
            }
            this.i = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final String a() {
        return "8.23";
    }

    public void a(c cVar) {
        a(cVar, e);
    }

    @TargetApi(9)
    public void a(c cVar, Handler handler) {
        new Thread(new n(this, cVar, handler)).start();
    }

    @TargetApi(9)
    protected void a(String str) {
        if (b != null) {
            Editor edit = j().edit();
            edit.putFloat("__badApkVersion__8.23", (float) b.a);
            if (VERSION.SDK_INT >= 9) {
                edit.apply();
            } else {
                edit.commit();
            }
        }
    }

    protected void b() {
        new File(e()).delete();
    }

    protected String c() {
        return this.d + "__xadsdk__remote__final__builtin__.jar";
    }

    protected void d() {
        String c = c();
        b bVar = new b(c, this.k);
        try {
            m.a().k().copyFileFromAssetsTo(this.k, "__xadsdk__remote__final__.jar", c);
            if (bVar.exists() && bVar.canRead()) {
                c(bVar);
                return;
            }
            throw new b("loadBuiltInApk failed: " + c);
        } catch (IOException e) {
            throw new b("loadBuiltInApk failed: " + e.toString());
        }
    }

    protected String e() {
        return this.d + "__xadsdk__remote__final__downloaded__.jar";
    }

    protected void f() {
        b bVar = new b(e(), this.k);
        Boolean valueOf = Boolean.valueOf(bVar.exists());
        Boolean valueOf2 = Boolean.valueOf(bVar.canRead());
        long length = bVar.length();
        if (valueOf.booleanValue() && valueOf2.booleanValue() && length > 0) {
            try {
                if (Boolean.valueOf(k()).booleanValue()) {
                    String str = "XAdApkLoader upgraded, drop stale downloaded file, use built-in instead";
                    throw new a("XAdApkLoader upgraded, drop stale downloaded file, use built-in instead");
                }
                synchronized (this) {
                    Log.i("XAdApkLoader", "loadDownloadedOrBuiltInApk len=" + bVar.length() + ", path=" + bVar.getAbsolutePath());
                    b(bVar);
                    double d = (double) j().getFloat("__badApkVersion__8.23", -1.0f);
                    this.l.d("XAdApkLoader", "downloadedApkFile.getApkVersion(): " + bVar.c() + ", badApkVersion: " + d);
                    if (bVar.c() == d) {
                        throw new a("downloaded file marked bad, drop it and use built-in");
                    }
                    this.l.d("XAdApkLoader", "loaded: " + bVar.getPath());
                    b(true);
                }
                return;
            } catch (a e) {
                this.l.e("XAdApkLoader", "load downloaded apk failed: " + e.toString() + ", fallback to built-in");
                if (bVar != null && bVar.exists()) {
                    bVar.delete();
                }
                h();
                try {
                    d();
                    return;
                } catch (b e2) {
                    throw new a("load built-in apk also failed" + e2.toString());
                }
            }
        }
        this.l.d("XAdApkLoader", "no downloaded file yet, use built-in apk file");
        try {
            d();
        } catch (b e22) {
            this.l.e("XAdApkLoader", "loadBuiltInApk failed: " + e22.toString());
            throw new a("load built-in apk failed" + e22.toString());
        }
    }

    public IXAdContainerFactory g() {
        return a(b);
    }

    protected void h() {
        if (b != null) {
            b.b();
            b = null;
        }
    }
}
