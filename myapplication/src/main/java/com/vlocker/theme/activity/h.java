package com.vlocker.theme.activity;

import android.view.View;
import android.view.View.OnClickListener;

class h implements OnClickListener {
    final /* synthetic */ ThemeDetailActivity a;

    h(ThemeDetailActivity themeDetailActivity) {
        this.a = themeDetailActivity;
    }

    public void onClick(View view) {
        this.a.r();
        this.a.H.dismiss();
    }
}
