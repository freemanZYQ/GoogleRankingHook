package com.vlocker.k;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

class g implements OnKeyListener {
    final /* synthetic */ e a;

    g(e eVar) {
        this.a = eVar;
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.a.b();
            this.a.a(false);
        }
        return false;
    }
}
