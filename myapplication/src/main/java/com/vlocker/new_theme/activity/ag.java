package com.vlocker.new_theme.activity;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.vlocker.locker.R;
import com.vlocker.theme.f.e;

class ag implements OnClickListener {
    final /* synthetic */ ImageView a;
    final /* synthetic */ TextView b;
    final /* synthetic */ SpecialSingleItemActivity c;

    ag(SpecialSingleItemActivity specialSingleItemActivity, ImageView imageView, TextView textView) {
        this.c = specialSingleItemActivity;
        this.a = imageView;
        this.b = textView;
    }

    public void onClick(View view) {
        if (e.c(this.c)) {
            this.a.setVisibility(8);
            this.b.setVisibility(8);
            this.c.a(this.c.x);
            return;
        }
        e.a(this.c, this.c.getString(R.string.t_market_net_set), 0);
    }
}
