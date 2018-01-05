package com.vlocker.setting.ui;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

class e implements OnKeyListener {
    final /* synthetic */ b a;

    e(b bVar) {
        this.a = bVar;
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 0 && keyEvent.getRepeatCount() <= 1) {
            this.a.m.postDelayed(new f(this), 200);
            this.a.k();
        }
        return false;
    }
}
