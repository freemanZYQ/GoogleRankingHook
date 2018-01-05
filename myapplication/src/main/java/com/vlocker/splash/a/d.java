package com.vlocker.splash.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.vlocker.b.a;
import com.vlocker.b.p;

class d implements OnClickListener {
    final /* synthetic */ c a;

    d(c cVar) {
        this.a = cVar;
    }

    public void onClick(View view) {
        a.a(this.a.f, this.a.b, this.a.a, "", null, false, null);
        p.a(this.a.f, this.a.b.m(), this.a.b.n());
        if (this.a.c != null) {
            this.a.c.sendEmptyMessageDelayed(40, 500);
        }
    }
}
