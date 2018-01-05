package com.vlocker.search;

import android.view.View;
import com.vlocker.b.j;
import com.vlocker.locker.R;

public class ar extends p {
    public ar(BaiduSearchActivity baiduSearchActivity, at atVar) {
        super(baiduSearchActivity, atVar);
    }

    protected View a() {
        return j.b(this.e, (int) R.layout.t_market_listview_footer);
    }

    public View c() {
        this.i.b();
        return super.c();
    }
}
