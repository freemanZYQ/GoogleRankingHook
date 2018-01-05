package com.vlocker.b;

import android.content.Context;
import android.content.Intent;
import com.moxiu.b.a.a;
import com.vlocker.msg.ao;

final class e implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ a b;
    final /* synthetic */ String c;

    e(Context context, a aVar, String str) {
        this.a = context;
        this.b = aVar;
        this.c = str;
    }

    public void run() {
        Intent a = ao.a(this.a, this.b.i());
        a.putExtra("tag", this.c);
        a.addFlags(268435456);
        this.a.startActivity(a);
    }
}
