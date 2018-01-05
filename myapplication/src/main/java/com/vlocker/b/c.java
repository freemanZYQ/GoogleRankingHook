package com.vlocker.b;

import android.content.Context;
import android.view.View;
import com.moxiu.b.a.a;

final class c implements Runnable {
    final /* synthetic */ a a;
    final /* synthetic */ View b;
    final /* synthetic */ Context c;
    final /* synthetic */ String d;
    final /* synthetic */ com.vlocker.weather.a e;

    c(a aVar, View view, Context context, String str, com.vlocker.weather.a aVar2) {
        this.a = aVar;
        this.b = view;
        this.c = context;
        this.d = str;
        this.e = aVar2;
    }

    public void run() {
        try {
            this.a.a(this.b);
        } catch (Throwable th) {
            a.b(this.c, this.a, this.d, this.e);
            th.printStackTrace();
        }
    }
}
