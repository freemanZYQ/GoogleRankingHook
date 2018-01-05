package com.baidu.location;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;

class c implements ServiceConnection {
    final /* synthetic */ LocationClient a;

    c(LocationClient locationClient) {
        this.a = locationClient;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.a.f = new Messenger(iBinder);
        if (this.a.f != null) {
            this.a.d = true;
            Log.d("baidu_location_client", "baidu location connected ...");
            if (this.a.x) {
                this.a.g.obtainMessage(2).sendToTarget();
                return;
            }
            try {
                Message obtain = Message.obtain(null, 11);
                obtain.replyTo = this.a.h;
                obtain.setData(this.a.d());
                this.a.f.send(obtain);
                this.a.d = true;
                if (this.a.c != null) {
                    if (this.a.A.booleanValue()) {
                        this.a.g.obtainMessage(4).sendToTarget();
                    } else {
                        this.a.g.obtainMessage(4).sendToTarget();
                    }
                }
            } catch (Exception e) {
            }
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        this.a.f = null;
        this.a.d = false;
    }
}
