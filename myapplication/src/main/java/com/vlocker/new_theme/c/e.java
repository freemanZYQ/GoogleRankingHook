package com.vlocker.new_theme.c;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.vlocker.locker.R;

class e implements OnClickListener {
    final /* synthetic */ a a;

    e(a aVar) {
        this.a = aVar;
    }

    public void onClick(View view) {
        System.gc();
        TextView textView;
        switch (view.getId()) {
            case R.id.allthemes_wait_layout:
                if (!com.vlocker.theme.f.e.c(this.a.c())) {
                    com.vlocker.theme.f.e.a(this.a.c(), this.a.a((int) R.string.t_market_net_set), 0);
                }
                try {
                    textView = (TextView) this.a.ab.findViewById(R.id.theme_fetch_loading);
                    ((ImageView) this.a.ab.findViewById(R.id.theme_fetch_loading_imageView1)).setVisibility(8);
                    this.a.ac.setVisibility(0);
                    textView.setText(R.string.t_market_online_data_loading);
                    this.a.M();
                    this.a.L();
                    this.a.b(com.vlocker.theme.f.e.b());
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            case R.id.theme_fetch_loading_imageView1:
                if (com.vlocker.theme.f.e.c(this.a.c())) {
                    try {
                        textView = (TextView) this.a.ab.findViewById(R.id.theme_fetch_loading);
                        ((ImageView) this.a.ab.findViewById(R.id.theme_fetch_loading_imageView1)).setVisibility(8);
                        textView.setText(R.string.t_market_online_data_loading);
                        this.a.M();
                        this.a.L();
                        this.a.b(com.vlocker.theme.f.e.b());
                        return;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        return;
                    }
                }
                com.vlocker.theme.f.e.a(this.a.c(), this.a.a((int) R.string.t_market_net_set), 0);
                return;
            case R.id.theme_fetch_loading:
                if (com.vlocker.theme.f.e.c(this.a.c())) {
                    try {
                        textView = (TextView) this.a.ab.findViewById(R.id.theme_fetch_loading);
                        ((ImageView) this.a.ab.findViewById(R.id.theme_fetch_loading_imageView1)).setVisibility(8);
                        textView.setText(R.string.t_market_online_data_loading);
                        this.a.M();
                        this.a.L();
                        this.a.b(com.vlocker.theme.f.e.b());
                        return;
                    } catch (Exception e22) {
                        e22.printStackTrace();
                        return;
                    }
                }
                com.vlocker.theme.f.e.a(this.a.c(), this.a.a((int) R.string.t_market_net_set), 0);
                return;
            default:
                return;
        }
    }
}
