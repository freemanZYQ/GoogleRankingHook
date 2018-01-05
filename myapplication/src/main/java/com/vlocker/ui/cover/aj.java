package com.vlocker.ui.cover;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

class aj implements OnKeyListener {
    final /* synthetic */ ai a;
    private int b = -1;

    aj(ai aiVar) {
        this.a = aiVar;
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 0) {
            if (keyEvent.getRepeatCount() <= 1 && this.a.a.u != null) {
                this.a.a.u.A();
                this.b = 4;
                return true;
            }
        } else if (i == 4 && keyEvent.getAction() == 1) {
            this.b = -1;
        } else if ((i == 25 || i == 24) && keyEvent.getAction() == 0 && this.a.a.i.at() && this.b == 4) {
            this.a.a.a(4);
            this.b = -1;
            return true;
        }
        return false;
    }
}
