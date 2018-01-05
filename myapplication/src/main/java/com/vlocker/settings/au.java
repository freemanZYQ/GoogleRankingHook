package com.vlocker.settings;

import android.view.View;
import android.view.View.OnClickListener;

class au implements OnClickListener {
    final /* synthetic */ LockNumberActivityNew a;

    au(LockNumberActivityNew lockNumberActivityNew) {
        this.a = lockNumberActivityNew;
    }

    public void onClick(View view) {
        this.a.finish();
    }
}
