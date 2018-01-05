package com.vlocker.locker.b;

import android.view.View;
import android.view.View.OnLongClickListener;

class ak implements OnLongClickListener {
    final /* synthetic */ ag a;

    ak(ag agVar) {
        this.a = agVar;
    }

    public boolean onLongClick(View view) {
        if (!(this.a.b() || this.a.i || this.a.a)) {
            this.a.a = true;
            this.a.a(true);
            this.a.h.a(true);
        }
        return false;
    }
}
