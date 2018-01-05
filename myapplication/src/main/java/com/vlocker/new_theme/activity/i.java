package com.vlocker.new_theme.activity;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.vlocker.locker.R;
import com.vlocker.theme.f.e;

class i implements OnClickListener {
    final /* synthetic */ TextView a;
    final /* synthetic */ ImageView b;
    final /* synthetic */ h c;

    i(h hVar, TextView textView, ImageView imageView) {
        this.c = hVar;
        this.a = textView;
        this.b = imageView;
    }

    public void onClick(View view) {
        if (e.c(this.c.a)) {
            this.a.setVisibility(8);
            this.b.setVisibility(8);
            this.c.a.a(this.c.a.w, this.c.a.t);
            return;
        }
        e.a(this.c.a, this.c.a.getString(R.string.t_market_net_set), 0);
    }
}
