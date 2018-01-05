package com.tencent.wxop.stat;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class as extends BroadcastReceiver {
    final /* synthetic */ z a;

    as(z zVar) {
        this.a = zVar;
    }

    public final void onReceive(Context context, Intent intent) {
        if (this.a.e != null) {
            this.a.e.a(new f(this));
        }
    }
}
