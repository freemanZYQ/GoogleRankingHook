package com.vlocker.setting.ui;

import android.view.View;
import android.view.View.OnClickListener;

class c implements OnClickListener {
    final /* synthetic */ b a;

    c(b bVar) {
        this.a = bVar;
    }

    public void onClick(View view) {
        this.a.m.postDelayed(new d(this), 200);
        this.a.j();
    }
}
