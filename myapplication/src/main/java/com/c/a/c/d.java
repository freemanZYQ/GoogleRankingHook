package com.c.a.c;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;

class d implements ServiceConnection {
    final /* synthetic */ b a;

    d(b bVar) {
        this.a = bVar;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Messenger messenger = new Messenger(iBinder);
        Message obtain = Message.obtain(null, 11801);
        obtain.replyTo = this.a.e;
        try {
            messenger.send(obtain);
        } catch (Throwable th) {
            Log.d("AppLink", th.toString());
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        Log.v("AppLink", "服务已断开");
        this.a.c();
        if (this.a.d != null) {
            this.a.d.a();
        }
        this.a.c = null;
        this.a.e = null;
        b.a = null;
    }
}
