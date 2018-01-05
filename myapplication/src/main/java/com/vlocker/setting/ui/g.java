package com.vlocker.setting.ui;

import android.view.View;
import android.view.View.OnClickListener;

class g implements OnClickListener {
    final /* synthetic */ b a;

    g(b bVar) {
        this.a = bVar;
    }

    public void onClick(View view) {
        this.a.m.postDelayed(new h(this), 200);
        this.a.k();
    }
}
