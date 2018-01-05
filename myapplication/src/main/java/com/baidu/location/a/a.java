package com.baidu.location.a;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.util.Log;
import com.baidu.location.LLSInterface;
import com.baidu.location.b.b;
import com.baidu.location.c.h;
import com.baidu.location.e.e;
import com.baidu.location.e.i;
import com.baidu.location.e.j;
import com.baidu.location.e.k;
import com.baidu.location.e.n;
import com.baidu.location.e.r;
import com.baidu.location.e.t;
import com.baidu.location.e.u;
import com.baidu.location.f;
import com.baidu.location.h.d;
import com.baidu.location.h.m;
import com.qq.e.comm.constants.ErrorCode.NetWorkError;

public class a extends Service implements LLSInterface {
    static a a = null;
    private static long f = 0;
    Messenger b = null;
    private Looper c;
    private HandlerThread d;
    private boolean e = false;

    public class a extends Handler {
        final /* synthetic */ a a;

        public a(a aVar, Looper looper) {
            this.a = aVar;
            super(looper);
        }

        public void handleMessage(Message message) {
            if (f.isServing) {
                switch (message.what) {
                    case 11:
                        this.a.a(message);
                        break;
                    case 12:
                        this.a.b(message);
                        break;
                    case 15:
                        this.a.c(message);
                        break;
                    case 22:
                        r.b().b(message);
                        break;
                    case 28:
                        r.b().j();
                        break;
                    case 41:
                        r.b().h();
                        break;
                    case NetWorkError.QUEUE_FULL_ERROR /*401*/:
                        try {
                            message.getData();
                            break;
                        } catch (Exception e) {
                            break;
                        }
                }
            }
            if (message.what == 1) {
                this.a.b();
            }
            if (message.what == 0) {
                this.a.a();
            }
            super.handleMessage(message);
        }
    }

    private void a() {
        d.a().b();
        m.a().b();
        b.a();
        r.b().c();
        com.baidu.location.c.d.a().b();
        i.a().b();
    }

    private void a(Message message) {
        com.baidu.location.e.d.a().a(message);
        h.a();
        j.a().c();
        e.b().c();
    }

    private void b() {
        d.a().c();
        r.b().d();
        u.e();
        com.baidu.location.e.d.a().b();
        k.a().b();
        if (!this.e) {
            Process.killProcess(Process.myPid());
        }
    }

    private void b(Message message) {
        com.baidu.location.e.d.a().b(message);
    }

    private void c(Message message) {
        com.baidu.location.e.d.a().c(message);
    }

    public double getVersion() {
        return 6.050000190734863d;
    }

    public IBinder onBind(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras != null) {
            b.j = extras.getString("key");
            b.i = extras.getString("sign");
            this.e = extras.getBoolean("kill_process");
        }
        return this.b.getBinder();
    }

    public void onCreate(Context context) {
        f = System.currentTimeMillis();
        this.d = t.a();
        this.c = this.d.getLooper();
        a = new a(this, this.c);
        this.b = new Messenger(a);
        a.sendEmptyMessage(0);
        Log.d("baidu_location_service", "baidu location service start1 ..." + Process.myPid());
    }

    public void onDestroy() {
        m.a().c();
        n.a().c();
        h.a().n();
        j.a().b();
        com.baidu.location.h.e.a().e();
        i.a().c();
        a.sendEmptyMessage(1);
        Log.d("baidu_location_service", "baidu location service stop ...");
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        return 1;
    }

    public boolean onUnBind(Intent intent) {
        return false;
    }
}
