package com.baidu.mobads.openad.c;

import android.content.Context;
import com.baidu.mobads.d.a;
import com.baidu.mobads.interfaces.download.IXAdStaticImgDownloader;
import com.baidu.mobads.j.m;
import com.baidu.mobads.openad.a.b;
import com.baidu.mobads.openad.a.c;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloader;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloaderManager;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class d implements IOAdDownloaderManager {
    private static d b = null;
    protected Context a;
    private HashMap c = new HashMap();
    private c d;
    private AtomicBoolean e = new AtomicBoolean(false);

    protected d(Context context) {
        this.a = context;
    }

    public static d a(Context context) {
        if (b == null) {
            b = new d(context);
        }
        return b;
    }

    public void a(String str, IOAdDownloader iOAdDownloader) {
        synchronized (this.c) {
            this.c.put(str, iOAdDownloader);
        }
    }

    public synchronized IOAdDownloader createAdsApkDownloader(URL url, String str, String str2, int i, String str3, String str4) {
        IOAdDownloader aVar;
        aVar = new a(this.a, url, str, str2, i, str3, str4);
        a(str4, aVar);
        try {
            if (this.d == null) {
                this.d = new c(this.a);
                this.d.a(new b(this.d));
                this.d.addEventListener("network_changed", new e(this));
                this.d.a();
            }
        } catch (Throwable e) {
            m.a().f().d("OAdDownloadManager", e);
        }
        return aVar;
    }

    public IXAdStaticImgDownloader createImgHttpDownloader(URL url, String str, String str2) {
        return new a(this.a, url, str, str2);
    }

    public IOAdDownloader createSimpleFileDownloader(URL url, String str, String str2, boolean z) {
        return new f(this.a, url, str, str2, z);
    }

    public IOAdDownloader getAdsApkDownloader(String str) {
        IOAdDownloader iOAdDownloader;
        synchronized (this.c) {
            iOAdDownloader = (IOAdDownloader) this.c.get(str);
        }
        return iOAdDownloader;
    }

    public ArrayList getAllAdsApkDownloaderes() {
        ArrayList arrayList = null;
        synchronized (this.c) {
            Collection<IOAdDownloader> values = this.c.values();
            if (values.size() > 0) {
                ArrayList arrayList2 = new ArrayList();
                for (IOAdDownloader add : values) {
                    arrayList2.add(add);
                }
                arrayList = arrayList2;
            }
        }
        return arrayList;
    }

    public Boolean removeAdsApkDownloader(String str) {
        synchronized (this.c) {
            this.c.remove(str);
        }
        return Boolean.valueOf(true);
    }

    public void removeAllAdsApkDownloaderes() {
        synchronized (this.c) {
            this.c.clear();
        }
    }

    public void resumeUndownloadedAfterRestartApp(long j) {
        if (!this.e.getAndSet(true)) {
            List a = com.baidu.mobads.command.a.a(this.a, j);
            if (a != null && a.size() > 0) {
                for (int i = 0; i < a.size(); i++) {
                    String str = (String) a.get(i);
                    if (b.a(str) == null && getAdsApkDownloader(str) == null) {
                        com.baidu.mobads.command.a a2 = com.baidu.mobads.command.a.a(this.a, str);
                        if (a2 == null) {
                            m.a().f().d("OAdDownloadManager", "pack[" + str + "] has no local data, continue");
                        } else {
                            try {
                                IOAdDownloader createAdsApkDownloader = createAdsApkDownloader(new URL(a2.j), a2.c, a2.b, 1, a2.a, a2.i);
                                createAdsApkDownloader.addObserver(new b(this.a, a2));
                                createAdsApkDownloader.start();
                            } catch (Throwable e) {
                                m.a().f().d("OAdDownloadManager", e);
                                return;
                            }
                        }
                    }
                    m.a().f().d("OAdDownloadManager", "pack[" + str + "] has been stated before, continue");
                }
            }
        }
    }
}
