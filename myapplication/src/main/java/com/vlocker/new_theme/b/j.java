package com.vlocker.new_theme.b;

import android.view.View;
import android.view.View.OnClickListener;
import com.vlocker.new_theme.beans.e;
import com.vlocker.theme.c.a;

class j implements OnClickListener {
    final /* synthetic */ e a;
    final /* synthetic */ d b;

    j(d dVar, e eVar) {
        this.b = dVar;
        this.a = eVar;
    }

    public void onClick(View view) {
        a.b().a(this.a.h().get(2));
        this.b.b();
    }
}
