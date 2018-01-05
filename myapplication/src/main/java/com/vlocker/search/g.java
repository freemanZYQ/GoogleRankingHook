package com.vlocker.search;

import android.view.View;
import android.view.View.OnClickListener;

class g implements OnClickListener {
    final /* synthetic */ BaiduSearchActivity a;

    g(BaiduSearchActivity baiduSearchActivity) {
        this.a = baiduSearchActivity;
    }

    public void onClick(View view) {
        this.a.a.setText("");
        this.a.o.setVisibility(8);
    }
}
