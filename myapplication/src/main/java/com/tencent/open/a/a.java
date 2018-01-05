package com.tencent.open.a;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class a extends m implements Callback {
    private b a;
    private FileWriter b;
    private File c;
    private char[] d;
    private volatile k e;
    private volatile k f;
    private volatile k g;
    private volatile k h;
    private volatile boolean i;
    private HandlerThread j;
    private Handler k;

    public a(int i, boolean z, l lVar, b bVar) {
        super(i, z, lVar);
        this.i = false;
        a(bVar);
        this.e = new k();
        this.f = new k();
        this.g = this.e;
        this.h = this.f;
        this.d = new char[bVar.d()];
        f();
        this.j = new HandlerThread(bVar.c(), bVar.f());
        if (this.j != null) {
            this.j.start();
        }
        if (this.j.isAlive() && this.j.getLooper() != null) {
            this.k = new Handler(this.j.getLooper(), this);
        }
    }

    public a(b bVar) {
        this(c.b, true, l.a, bVar);
    }

    private void e() {
        if (Thread.currentThread() == this.j && !this.i) {
            this.i = true;
            h();
            try {
                this.h.a(f(), this.d);
            } catch (IOException e) {
            } finally {
                this.h.b();
            }
            this.i = false;
        }
    }

    private Writer f() {
        File a = b().a();
        if (!(a == null || a.equals(this.c)) || (this.b == null && a != null)) {
            this.c = a;
            g();
            try {
                this.b = new FileWriter(this.c, true);
            } catch (IOException e) {
                return null;
            }
        }
        return this.b;
    }

    private void g() {
        try {
            if (this.b != null) {
                this.b.flush();
                this.b.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void h() {
        synchronized (this) {
            if (this.g == this.e) {
                this.g = this.f;
                this.h = this.e;
            } else {
                this.g = this.e;
                this.h = this.f;
            }
        }
    }

    public void a() {
        if (this.k.hasMessages(IXAdIOUtils.BUFFER_SIZE)) {
            this.k.removeMessages(IXAdIOUtils.BUFFER_SIZE);
        }
        this.k.sendEmptyMessage(IXAdIOUtils.BUFFER_SIZE);
    }

    protected void a(int i, Thread thread, long j, String str, String str2, Throwable th) {
        a(d().a(i, thread, j, str, str2, th));
    }

    public void a(b bVar) {
        this.a = bVar;
    }

    protected void a(String str) {
        this.g.a(str);
        if (this.g.a() >= b().d()) {
            a();
        }
    }

    public b b() {
        return this.a;
    }

    public boolean handleMessage(Message message) {
        switch (message.what) {
            case IXAdIOUtils.BUFFER_SIZE /*1024*/:
                e();
                break;
        }
        return true;
    }
}
