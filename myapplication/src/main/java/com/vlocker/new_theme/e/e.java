package com.vlocker.new_theme.e;

import android.content.Context;
import android.os.Handler;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.RelativeLayout;
import com.vlocker.locker.R;
import com.vlocker.theme.model.T_ThemeListPageInfo;

public class e implements OnScrollListener {
    Handler a = new f(this);
    private int b = 0;
    private int c = 0;
    private d d;
    private RelativeLayout e;
    private T_ThemeListPageInfo f = null;
    private Context g;
    private boolean h = false;

    public e(Context context, d dVar, RelativeLayout relativeLayout) {
        this.g = context;
        this.d = dVar;
        this.e = relativeLayout;
    }

    public void a(T_ThemeListPageInfo t_ThemeListPageInfo) {
        this.f = t_ThemeListPageInfo;
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
                        this.d.a(this.g.getString(R.string.t_market_shop_givetheme_loading_dip), this.f, this.e, Boolean.valueOf(true));
                        return;
                    }
                    return;
                }
            }
            this.b = 0;
            this.c = 0;
        } else if (i == 1) {
            this.d.a(this.g.getString(R.string.t_market_shop_givetheme_loading_dip), this.f, this.e, Boolean.valueOf(false));
        }
    }
}
