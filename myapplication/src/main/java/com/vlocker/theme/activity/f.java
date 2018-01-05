package com.vlocker.theme.activity;

import com.vlocker.d.c;
import com.vlocker.d.d;

class f implements d {
    final /* synthetic */ boolean a;
    final /* synthetic */ ThemeDetailActivity b;

    f(ThemeDetailActivity themeDetailActivity, boolean z) {
        this.b = themeDetailActivity;
        this.a = z;
    }

    public void a(c cVar) {
        this.b.b(this.a);
        cVar.dismiss();
    }

    public void b(c cVar) {
        cVar.dismiss();
    }
}
