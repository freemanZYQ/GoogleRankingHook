package com.vlocker.share;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

class i implements OnKeyListener {
    final /* synthetic */ h a;

    i(h hVar) {
        this.a = hVar;
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 0 && keyEvent.getRepeatCount() <= 1) {
            this.a.a();
        }
        return false;
    }
}
