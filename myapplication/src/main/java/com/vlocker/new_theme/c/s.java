package com.vlocker.new_theme.c;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.vlocker.locker.R;
import com.vlocker.theme.f.e;

class s implements OnClickListener {
    final /* synthetic */ q a;

    s(q qVar) {
        this.a = qVar;
    }

    public void onClick(View view) {
        if (!e.c(this.a.c())) {
            e.a(this.a.c(), this.a.a((int) R.string.t_market_net_set), 0);
        }
        TextView textView = (TextView) this.a.ac.findViewById(R.id.theme_fetch_loading);
        ((ImageView) this.a.ac.findViewById(R.id.theme_fetch_loading_imageView1)).setVisibility(8);
        textView.setText(R.string.t_market_online_data_loading);
        this.a.a(8195, 0);
    }
}
