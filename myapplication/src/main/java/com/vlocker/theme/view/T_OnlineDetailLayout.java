package com.vlocker.theme.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.vlocker.theme.model.T_ThemeItemInfo;

public class T_OnlineDetailLayout extends LinearLayout {
    private Context a;
    private int b;
    private int c;
    private T_ThemeItemInfo d;
    private OnClickListener e;

    public T_OnlineDetailLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = context;
    }

    public void a(BaseAdapter baseAdapter, int i, int i2, T_ThemeItemInfo t_ThemeItemInfo) {
        int i3 = 0;
        removeAllViews();
        this.b = i;
        this.c = i2;
        this.d = t_ThemeItemInfo;
        while (i3 < baseAdapter.getCount()) {
            try {
                View view = baseAdapter.getView(i3, null, null);
                view.setPadding(0, 0, 8, 0);
                view.setId(i3);
                if (i3 > 0) {
                    view.setOnClickListener(this.e);
                }
                setOrientation(0);
                addView(view, new LayoutParams(-2, -1));
                i3++;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.e = onClickListener;
    }
}
