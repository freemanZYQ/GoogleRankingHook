package com.vlocker.setting.a;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;

final class c extends View {
    final /* synthetic */ Handler a;
    final /* synthetic */ WindowManager b;
    final /* synthetic */ e c;

    c(Context context, Handler handler, WindowManager windowManager, e eVar) {
        this.a = handler;
        this.b = windowManager;
        this.c = eVar;
        super(context);
    }

    public void onWindowFocusChanged(boolean z) {
        this.a.removeCallbacksAndMessages(null);
        if (getParent() != null) {
            this.b.removeView(this);
        }
        this.c.onResult(true);
    }
}
