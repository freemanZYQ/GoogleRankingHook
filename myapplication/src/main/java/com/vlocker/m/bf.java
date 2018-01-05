package com.vlocker.m;

import android.content.Context;

final class bf extends Thread {
    final /* synthetic */ Context a;
    final /* synthetic */ String b;
    final /* synthetic */ boolean c;

    bf(Context context, String str, boolean z) {
        this.a = context;
        this.b = str;
        this.c = z;
    }

    public void run() {
        be.b(this.a, this.b, this.c);
    }
}
