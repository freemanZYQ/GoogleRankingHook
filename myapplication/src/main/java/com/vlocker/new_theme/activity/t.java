package com.vlocker.new_theme.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.vlocker.locker.R;

class t implements OnClickListener {
    final /* synthetic */ SearchResultActivity a;

    t(SearchResultActivity searchResultActivity) {
        this.a = searchResultActivity;
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.themetab_searchdetail_back:
                this.a.i();
                return;
            case R.id.tv_search:
                this.a.r = true;
                this.a.o = false;
                this.a.j();
                return;
            default:
                return;
        }
    }
}
