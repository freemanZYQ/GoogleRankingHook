package com.vlocker.new_theme.b;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.vlocker.locker.R;
import com.vlocker.new_theme.e.g;
import com.vlocker.theme.imageloader.RecyclingImageView;
import com.vlocker.theme.model.T_ThemeItemInfo;

public class x extends a {
    boolean b = false;
    private Context c;
    private g d = null;
    private DisplayMetrics e;
    private Object f;

    public x(Context context) {
        super(context);
        this.c = context;
        a(context);
    }

    public x(Context context, Object obj) {
        super(context);
        this.c = context;
        a(context);
        this.f = obj;
    }

    public void a(Context context) {
        this.e = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(this.e);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        T_ThemeItemInfo t_ThemeItemInfo = (this.a == null || this.a.size() <= 0 || i >= this.a.size()) ? null : (T_ThemeItemInfo) this.a.get(i);
        if (view == null) {
            view = LayoutInflater.from(this.c).inflate(R.layout.t_market_themelist_griditem, null);
            this.d = new g();
            this.d.a = (RecyclingImageView) view.findViewById(R.id.imgTheme);
            this.d.f = (RecyclingImageView) view.findViewById(R.id.zhanweitu);
            this.d.a.setPressedDark(true);
            this.d.g = (RelativeLayout) view.findViewById(R.id.moxiu_detail_display);
            int dimension = (int) ((((float) this.e.widthPixels) - this.c.getResources().getDimension(R.dimen.t_market_main_more_helpchild_size)) / 3.0f);
            LayoutParams layoutParams = this.d.a.getLayoutParams();
            layoutParams.width = dimension;
            layoutParams.height = (int) (((double) dimension) * 1.6d);
            layoutParams = this.d.f.getLayoutParams();
            layoutParams.width = dimension;
            layoutParams.height = (int) (((double) dimension) * 1.6d);
            view.setTag(this.d);
        } else {
            this.d = (g) view.getTag();
        }
        if (!(t_ThemeItemInfo == null || t_ThemeItemInfo.g() == null)) {
            this.d.a.a(t_ThemeItemInfo.g(), 1, 0);
        }
        return view;
    }
}
