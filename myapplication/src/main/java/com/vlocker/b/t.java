package com.vlocker.b;

import android.content.Context;

final class t extends Thread {
    final /* synthetic */ Context a;

    t(Context context) {
        this.a = context;
    }

    public void run() {
        j.a(this.a.getApplicationContext(), j.a(8), "active_service");
    }
}
