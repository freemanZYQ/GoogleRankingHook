package com.vlocker.setting.a;

import android.os.Handler;
import android.view.View;
import android.view.WindowManager;

final class d implements Runnable {
    final /* synthetic */ WindowManager a;
    final /* synthetic */ View b;
    final /* synthetic */ Handler c;
    final /* synthetic */ e d;

    d(WindowManager windowManager, View view, Handler handler, e eVar) {
        this.a = windowManager;
        this.b = view;
        this.c = handler;
        this.d = eVar;
    }

    public void run() {
        try {
            this.a.removeView(this.b);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.c.removeCallbacksAndMessages(null);
        this.d.onResult(false);
    }
}
