package com.vlocker.weather.view;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

class w implements OnKeyListener {
    final /* synthetic */ v a;

    w(v vVar) {
        this.a = vVar;
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getAction() != 0 || keyEvent.getRepeatCount() > 1) {
            return false;
        }
        this.a.b();
        return true;
    }
}
