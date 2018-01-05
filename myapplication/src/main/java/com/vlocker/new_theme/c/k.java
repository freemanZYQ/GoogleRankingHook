package com.vlocker.new_theme.c;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.vlocker.locker.R;
import com.vlocker.security.MoSecurityApplication;
import com.vlocker.theme.f.e;

class k implements OnClickListener {
    final /* synthetic */ j a;

    k(j jVar) {
        this.a = jVar;
    }

    public void onClick(View view) {
        if (!e.c(MoSecurityApplication.a())) {
            e.a(MoSecurityApplication.a(), MoSecurityApplication.a().getString(R.string.t_market_net_set), 0);
        }
        TextView textView = (TextView) this.a.ac.findViewById(R.id.theme_fetch_loading);
        ((ImageView) this.a.ac.findViewById(R.id.theme_fetch_loading_imageView1)).setVisibility(8);
        textView.setText(MoSecurityApplication.a().getString(R.string.t_market_online_data_loading));
        this.a.a(8194, 0);
    }
}
