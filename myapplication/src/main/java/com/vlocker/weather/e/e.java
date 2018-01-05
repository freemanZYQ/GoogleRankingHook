package com.vlocker.weather.e;

import android.content.Context;
import com.vlocker.b.j;

final class e extends Thread {
    final /* synthetic */ Context a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ String d;
    final /* synthetic */ String e;
    final /* synthetic */ String f;
    final /* synthetic */ String g;

    e(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        this.a = context;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = str4;
        this.f = str5;
        this.g = str6;
    }

    public void run() {
        j.a(this.a, d.b(this.a, this.b, this.c, this.d, this.e, this.f, this.g), j.a(8));
    }
}
