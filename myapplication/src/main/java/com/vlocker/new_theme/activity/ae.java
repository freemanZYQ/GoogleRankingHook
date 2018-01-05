package com.vlocker.new_theme.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.vlocker.locker.R;
import com.vlocker.theme.f.e;

class ae implements OnClickListener {
    final /* synthetic */ String a;
    final /* synthetic */ SpecialSingleItemActivity b;

    ae(SpecialSingleItemActivity specialSingleItemActivity, String str) {
        this.b = specialSingleItemActivity;
        this.a = str;
    }

    public void onClick(View view) {
        this.b.J.setVisibility(8);
        if (e.c(this.b)) {
            this.b.p = false;
            this.b.l();
            this.b.w = this.a + 16385;
            this.b.k();
            this.b.a(this.b.x);
            return;
        }
        e.a(this.b, this.b.getString(R.string.t_market_net_set), 0);
    }
}
