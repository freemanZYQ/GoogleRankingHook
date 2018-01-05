package com.vlocker.new_theme.c;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.vlocker.locker.R;
import com.vlocker.theme.f.e;

class i implements OnClickListener {
    final /* synthetic */ h a;

    i(h hVar) {
        this.a = hVar;
    }

    public void onClick(View view) {
        if (!e.c(this.a.b.c())) {
            e.a(this.a.b.c(), this.a.b.a((int) R.string.t_market_net_set), 0);
        }
        TextView textView = (TextView) this.a.b.ab.findViewById(R.id.theme_fetch_loading);
        ((ImageView) this.a.b.ab.findViewById(R.id.theme_fetch_loading_imageView1)).setVisibility(8);
        textView.setText(R.string.t_market_online_data_loading);
        this.a.b.b(0);
    }
}
