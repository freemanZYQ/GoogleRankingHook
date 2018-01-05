package com.vlocker.theme.activity;

import com.vlocker.theme.b.a;

class e implements a {
    final /* synthetic */ ThemeDetailActivity a;

    e(ThemeDetailActivity themeDetailActivity) {
        this.a = themeDetailActivity;
    }

    public void a(int i) {
        if (this.a.x != null) {
            this.a.x.sendEmptyMessage(i);
        }
    }
}
