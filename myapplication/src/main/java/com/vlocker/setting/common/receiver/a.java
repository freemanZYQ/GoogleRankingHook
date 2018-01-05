package com.vlocker.setting.common.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;

public abstract class a {
    protected Context a;
    protected Object b;
    private String c;
    private BroadcastReceiver d;

    protected a(Context context, String str) {
        this.a = context;
        this.c = str;
    }

    public void a() {
        if (this.d != null) {
            this.a.registerReceiver(this.d, new IntentFilter(this.c));
        }
    }

    protected void a(BroadcastReceiver broadcastReceiver, Object obj) {
        this.d = broadcastReceiver;
        this.b = obj;
    }

    public void b() {
        if (this.d != null) {
            this.a.unregisterReceiver(this.d);
        }
    }
}
