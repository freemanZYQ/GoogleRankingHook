package com.vlocker.new_theme.e;

import android.content.Context;
import android.os.Handler;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.LinearLayout;
import com.vlocker.locker.R;

public class b implements OnScrollListener {
    Handler a = new c(this);
    private int b = 0;
    private int c = 0;
    private a d;
    private LinearLayout e;
    private String f = null;
    private Context g;
    private boolean h = false;

    public b(Context context, a aVar, LinearLayout linearLayout) {
        this.g = context;
        this.d = aVar;
        this.e = linearLayout;
    }

    public void a(String str) {
        this.f = str;
    }

    public void a(boolean z) {
        this.h = z;
    }

    public void b(boolean z) {
        if (this.e == null) {
            return;
        }
        if (z) {
            this.e.setVisibility(0);
        } else {
            this.e.setVisibility(8);
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0 || i == 2) {
            if (absListView.getLastVisiblePosition() == absListView.getCount() - 1) {
                int[] iArr = new int[2];
                try {
                    absListView.getChildAt(absListView.getChildCount() - 1).getLocationOnScreen(iArr);
                } catch (Exception e) {
                }
                int i2 = iArr[1];
                if (!(absListView.getLastVisiblePosition() == this.b || this.c == i2)) {
                    if (!this.h) {
                        this.d.a(this.g.getString(R.string.t_market_shop_givetheme_loading_dip), this.f, this.e);
                        return;
                    }
                    return;
                }
            }
            this.b = 0;
            this.c = 0;
        }
    }
}
