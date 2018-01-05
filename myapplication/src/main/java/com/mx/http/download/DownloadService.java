package com.mx.http.download;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.Log;
import com.mx.http.a.a;
import com.mx.http.a.d;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;

public class DownloadService extends Service {
    private final int a = 5;
    private final int b = 1;
    private final int c = 2;
    private boolean d = false;
    private boolean e = false;
    private Thread f = null;
    private ConcurrentHashMap g = new ConcurrentHashMap();
    private ConcurrentHashMap h = new ConcurrentHashMap();
    private DownloadNotify i = null;
    private boolean j = false;
    private final Handler k = new d(this);

    private void a() {
        for (String a : d.a(this).keySet()) {
            a aVar = (a) d.a((Context) this, a, a.class);
            try {
                if (i.WAIT_INSTALL.equals(aVar.b()) && !a.b(aVar.f())) {
                    d.a(this, aVar.c());
                } else if (!a.b(aVar.f()) && !a.b(aVar.u()) && !this.g.contains(aVar.c()) && !this.h.contains(aVar.c())) {
                    d.a(this, aVar.c());
                } else if (i.DOWNLOAD_FAILED.equals(aVar.b()) && !a.b(aVar.u())) {
                    d.a(this, aVar.c());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void a(a aVar) {
        synchronized (this) {
            if (!this.e) {
                this.f = new e(this, aVar);
                this.f.setPriority(2);
                this.f.start();
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void a(com.mx.http.download.a r3, int r4) {
        /*
        r2 = this;
        monitor-enter(r2);
        if (r3 != 0) goto L_0x0005;
    L_0x0003:
        monitor-exit(r2);
        return;
    L_0x0005:
        switch(r4) {
            case 1: goto L_0x0009;
            case 2: goto L_0x001b;
            default: goto L_0x0008;
        };
    L_0x0008:
        goto L_0x0003;
    L_0x0009:
        r0 = r2.g;	 Catch:{ Exception -> 0x0013 }
        r1 = r3.c();	 Catch:{ Exception -> 0x0013 }
        r0.put(r1, r3);	 Catch:{ Exception -> 0x0013 }
        goto L_0x0003;
    L_0x0013:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ all -> 0x0018 }
        goto L_0x0003;
    L_0x0018:
        r0 = move-exception;
        monitor-exit(r2);
        throw r0;
    L_0x001b:
        r0 = r2.g;	 Catch:{ Exception -> 0x0013 }
        r1 = r3.c();	 Catch:{ Exception -> 0x0013 }
        r0.remove(r1);	 Catch:{ Exception -> 0x0013 }
        goto L_0x0003;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mx.http.download.DownloadService.a(com.mx.http.download.a, int):void");
    }

    private void a(a aVar, String str) {
        h.a((Context) this, 9004, null);
        this.d = false;
    }

    private void a(f fVar, int i) {
        if (fVar != null) {
            try {
                a a = fVar.a();
                switch (i) {
                    case 1:
                        this.h.put(a.c(), fVar);
                        return;
                    case 2:
                        this.h.remove(a.c());
                        return;
                    default:
                        return;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            e.printStackTrace();
        }
    }

    private void b() {
        try {
            for (Object obj : this.g.values()) {
                File file;
                try {
                    if (obj.A()) {
                        file = new File(obj.f());
                        if (file.exists()) {
                            file.delete();
                        }
                        d.a(this, obj.c());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (a.b(obj.f())) {
                    file = new File(obj.f());
                    obj.b(file.length());
                    obj.a(file.length());
                    obj.a(i.WAIT_UPDATE);
                    h.a((Context) this, "com.moxiu.http.download.task.state", (a) obj);
                    h.a((Context) this, 9002, (a) obj);
                    Object obj2 = (a) d.a((Context) this, obj.c(), a.class);
                    if (obj2 == null) {
                        d.a((Context) this, obj.c(), obj);
                    } else {
                        obj2.a(i.WAIT_UPDATE);
                        d.a((Context) this, obj2.c(), obj2);
                    }
                    this.g.remove(obj.c());
                    this.h.remove(obj.c());
                } else if (this.h.containsKey(obj.c())) {
                    this.g.remove(obj.c());
                } else {
                    c(obj);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void b(a aVar) {
        synchronized (this.f) {
            if (this.d) {
                try {
                    if (this.h.size() < 5 && aVar != null && aVar.b() == i.DOWNLOAD_PENDING) {
                        f fVar = new f(this, this.k, aVar);
                        fVar.b();
                        a(fVar, 1);
                        a(aVar, 2);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void c(a aVar) {
        try {
            if (!new File(aVar.u()).exists()) {
                aVar.b(0);
            }
            aVar.a(i.DOWNLOAD_PENDING);
            Object obj = (a) d.a((Context) this, aVar.c(), a.class);
            if (obj == null) {
                d.a((Context) this, aVar.c(), (Object) aVar);
                return;
            }
            obj.a(i.DOWNLOAD_PENDING);
            d.a((Context) this, obj.c(), obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Cannot bind to eoeMarket DownloadService");
    }

    public void onCreate() {
        super.onCreate();
        this.i = new DownloadNotify(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.moxiu.http.download.task.update");
        intentFilter.addAction("com.moxiu.http.download.task.state");
        intentFilter.addAction("com.moxiu.http.download.task.restart");
        intentFilter.addAction("com.moxiu.http.download.notification.cancel");
        intentFilter.addAction("com.moxiu.http.download.task.click");
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(this.i, intentFilter);
        intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
        intentFilter.addDataScheme("package");
        registerReceiver(this.i, intentFilter);
        if (!this.j) {
            h.a(this);
            this.j = true;
        }
    }

    public void onDestroy() {
        this.h.clear();
        this.g.clear();
        unregisterReceiver(this.i);
        this.d = false;
        try {
            for (f a : this.h.values()) {
                a.a().a(i.DOWNLOAD_PAUSE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.onDestroy();
    }

    public void onStart(Intent intent, int i) {
        a aVar;
        a aVar2;
        this.d = true;
        a();
        try {
            Bundle extras = intent.getExtras();
            if (!(extras == null || extras.getSerializable("itemdata") == null)) {
                aVar = (a) extras.getSerializable("itemdata");
                if (aVar != null) {
                    h.a((Context) this, 9004, null);
                    this.d = false;
                } else if (TextUtils.isEmpty(aVar.g())) {
                    a(aVar, "文件格式为空");
                    this.d = false;
                    return;
                } else if (TextUtils.isEmpty(aVar.a())) {
                    if (!(this.g.containsKey(aVar.c()) || this.h.containsKey(aVar.c()))) {
                        aVar2 = (a) d.a((Context) this, aVar.c(), a.class);
                        if (aVar2 == null) {
                            aVar2.a(i.DOWNLOAD_PENDING);
                            d.a((Context) this, aVar.c(), (Object) aVar2);
                        } else {
                            aVar2 = aVar;
                        }
                        aVar2.o(getApplicationContext().getPackageName());
                        this.g.put(aVar2.c(), aVar2);
                        aVar = aVar2;
                    }
                    b();
                    Log.e("ZGP", "等待下载队列数量：" + this.g.size());
                    if (this.g.size() > 0) {
                        this.g.size();
                        a(aVar);
                    }
                } else {
                    a(aVar, "文件名为空");
                    this.d = false;
                    return;
                }
                super.onStart(intent, i);
            }
        } catch (Exception e) {
            a(null, "接收到的数据为空!");
            this.d = false;
        }
        aVar = null;
        if (aVar != null) {
            h.a((Context) this, 9004, null);
            this.d = false;
        } else if (TextUtils.isEmpty(aVar.g())) {
            a(aVar, "文件格式为空");
            this.d = false;
            return;
        } else if (TextUtils.isEmpty(aVar.a())) {
            aVar2 = (a) d.a((Context) this, aVar.c(), a.class);
            if (aVar2 == null) {
                aVar2 = aVar;
            } else {
                aVar2.a(i.DOWNLOAD_PENDING);
                d.a((Context) this, aVar.c(), (Object) aVar2);
            }
            aVar2.o(getApplicationContext().getPackageName());
            this.g.put(aVar2.c(), aVar2);
            aVar = aVar2;
            b();
            Log.e("ZGP", "等待下载队列数量：" + this.g.size());
            if (this.g.size() > 0) {
                this.g.size();
                a(aVar);
            }
        } else {
            a(aVar, "文件名为空");
            this.d = false;
            return;
        }
        super.onStart(intent, i);
    }
}
