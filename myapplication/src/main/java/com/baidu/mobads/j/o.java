package com.baidu.mobads.j;

import android.content.SharedPreferences;
import android.os.Build.VERSION;

class o implements Runnable {
    final /* synthetic */ SharedPreferences a;
    final /* synthetic */ String b;
    final /* synthetic */ n c;

    o(n nVar, SharedPreferences sharedPreferences, String str) {
        this.c = nVar;
        this.a = sharedPreferences;
        this.b = str;
    }

    public void run() {
        if (VERSION.SDK_INT >= 9) {
            this.a.edit().putString("imei", this.b).apply();
        } else {
            this.a.edit().putString("imei", this.b).commit();
        }
    }
}
