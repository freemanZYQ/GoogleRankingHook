package com.vlocker.new_theme.b;

import android.view.View;
import android.view.View.OnClickListener;
import com.vlocker.new_theme.beans.e;
import com.vlocker.theme.c.a;

class ad implements OnClickListener {
    final /* synthetic */ e a;
    final /* synthetic */ y b;

    ad(y yVar, e eVar) {
        this.b = yVar;
        this.a = eVar;
    }

    public void onClick(View view) {
        if (this.a.h().size() > 1) {
            a.b().a(this.a.h().get(1));
            this.b.b();
        }
    }
}
