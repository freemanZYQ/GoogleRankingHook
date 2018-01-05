package com.vlocker.search;

import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

class j implements OnScrollListener {
    final /* synthetic */ BaiduSearchActivity a;

    j(BaiduSearchActivity baiduSearchActivity) {
        this.a = baiduSearchActivity;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            ap.a(this.a, (View) absListView);
        }
    }
}
