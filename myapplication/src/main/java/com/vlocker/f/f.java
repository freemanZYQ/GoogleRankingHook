package com.vlocker.f;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

class f implements OnKeyListener {
    final /* synthetic */ b a;

    f(b bVar) {
        this.a = bVar;
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 0 && keyEvent.getRepeatCount() <= 1) {
            this.a.b();
        }
        return false;
    }
}
