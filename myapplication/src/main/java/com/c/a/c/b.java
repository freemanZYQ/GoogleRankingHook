package com.c.a.c;

import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Messenger;
import android.util.Log;
import com.c.a.k.d;

public class b {
    private static ServiceConnection a;
    private static boolean b = false;
    private Handler c;
    private a d;
    private Messenger e;

    public b(a aVar) {
        if (aVar != null) {
            this.d = aVar;
        }
    }

    private void c() {
        try {
            if (a != null && b) {
                b = false;
                d.a().getApplicationContext().unbindService(a);
            }
        } catch (Throwable th) {
            Log.d("AppLink", th.toString());
        }
    }

    private void d() {
        this.c = new Handler(new c(this));
        this.e = new Messenger(this.c);
        a = new d(this);
    }

    public void a() {
        if (d.a() != null) {
            c();
            d();
            Intent intent = new Intent();
            intent.setAction("com.taobao.open.intent.action.AUTH");
            intent.setPackage("com.taobao.taobao");
            try {
                d.a().getApplicationContext().bindService(intent, a, 1);
                b = true;
            } catch (Throwable th) {
                Log.d("AppLink", th.toString());
            }
        }
    }
}
