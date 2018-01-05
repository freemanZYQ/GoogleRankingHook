package com.vlocker.m;

import android.content.Context;
import com.vlocker.b.j;

final class ad extends Thread {
    final /* synthetic */ Context a;

    ad(Context context) {
        this.a = context;
    }

    public void run() {
        j.a(this.a, ab.c(this.a), j.a(8));
    }
}
