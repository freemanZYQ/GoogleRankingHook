package com.vlocker.new_theme.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.vlocker.locker.R;
import com.vlocker.theme.f.e;

class u implements OnClickListener {
    final /* synthetic */ SearchResultActivity a;

    u(SearchResultActivity searchResultActivity) {
        this.a = searchResultActivity;
    }

    public void onClick(View view) {
        if (!this.a.A) {
            if (e.e(this.a)) {
                this.a.a(e.a() + ThemeMainActivity.n + "&q=" + e.b(this.a.y));
                this.a.u.setText(this.a.getString(R.string.t_market_shop_givetheme_loading_dip));
                return;
            }
            e.a(this.a, this.a.getString(R.string.t_market_net_set), 0);
        }
    }
}
