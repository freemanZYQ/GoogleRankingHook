package com.vlocker.search;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

class k implements OnScrollListener {
    final /* synthetic */ BaiduSearchActivity a;

    k(BaiduSearchActivity baiduSearchActivity) {
        this.a = baiduSearchActivity;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        int i4 = 230;
        int i5 = 0;
        try {
            if (!(ap.a() || i < 0 || this.a.w == i)) {
                if (i != 0) {
                    i5 = absListView.getChildAt(this.a.w).getMeasuredHeight();
                }
                if (this.a.w > i) {
                    this.a.v = this.a.v - i5;
                } else if (this.a.w < i) {
                    this.a.v = i5 + this.a.v;
                }
                this.a.w = i;
                if (this.a.v < 0 || i == 0) {
                    this.a.v = 0;
                }
                if (this.a.x > this.a.v) {
                    i5 = Math.abs((this.a.v * 100) / this.a.x);
                    if (i5 < 100) {
                        i4 = i5 + 130;
                    }
                    this.a.u.getBackground().setAlpha(i4);
                } else {
                    this.a.v = this.a.x;
                    this.a.u.getBackground().setAlpha(230);
                }
            }
            if (this.a.B != null) {
                this.a.B.a(absListView, i, i2, i3);
            }
        } catch (Exception e) {
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        ap.a(this.a, this.a.getCurrentFocus());
        if (this.a.B != null) {
            this.a.B.a(absListView, i);
        }
    }
}
