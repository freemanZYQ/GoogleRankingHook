package com.vlocker.settings;

import android.view.View;
import android.view.View.OnClickListener;

class e implements OnClickListener {
    final /* synthetic */ CitySelectActivity a;

    e(CitySelectActivity citySelectActivity) {
        this.a = citySelectActivity;
    }

    public void onClick(View view) {
        if (this.a.n != null && this.a.n.isShowing()) {
            this.a.n.dismiss();
        }
    }
}
