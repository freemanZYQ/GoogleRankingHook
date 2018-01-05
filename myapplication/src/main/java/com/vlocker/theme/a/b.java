package com.vlocker.theme.a;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.vlocker.locker.R;
import com.vlocker.theme.f.d;
import com.vlocker.theme.imageloader.RecyclingImageView;
import com.vlocker.theme.model.a;
import java.util.List;

public class b extends BaseAdapter {
    List a;
    private Context b;
    private d c = null;
    private DisplayMetrics d;

    public b(Context context, List list) {
        this.b = context;
        this.a = list;
        a(context);
    }

    public void a(Context context) {
        this.d = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(this.d);
    }

    public void a(View view, int i) {
        a aVar = (a) this.a.get(i);
        if (view != null) {
            try {
                this.c = (d) view.getTag();
            } catch (Exception e) {
            }
        }
        if (view == null) {
            return;
        }
        if (aVar.b()) {
            this.c.e.setVisibility(0);
            this.c.f.setVisibility(0);
            return;
        }
        this.c.e.setVisibility(8);
        this.c.f.setVisibility(8);
    }

    public int getCount() {
        return this.a.size();
    }

    public Object getItem(int i) {
        return this.a.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        a aVar2 = new a();
        if (i > this.a.size() - 1) {
            aVar2.b("");
            aVar2.a(false);
            aVar = aVar2;
        } else {
            aVar = (a) this.a.get(i);
        }
        if (view == null) {
            view = LayoutInflater.from(this.b).inflate(R.layout.t_market_themelist_griditem, null);
            this.c = new d();
            this.c.a = (RecyclingImageView) view.findViewById(R.id.imgTheme);
            this.c.b = (RecyclingImageView) view.findViewById(R.id.market_themelist_griditem_bg_one2);
            this.c.c = (RecyclingImageView) view.findViewById(R.id.zhanweitu);
            this.c.e = (ImageView) view.findViewById(R.id.market_themelist_griditem_bg_check);
            this.c.f = (ImageView) view.findViewById(R.id.market_themelist_griditem_bg_checkicon);
            this.c.d = (RelativeLayout) view.findViewById(R.id.moxiu_detail_display);
            int i2 = this.d.widthPixels;
            int i3 = (i2 - 20) / 3;
            if (i2 <= 480) {
                i3 = i2 / 3;
            }
            LayoutParams layoutParams = this.c.a.getLayoutParams();
            layoutParams.width = i3;
            layoutParams.height = (int) (((float) i3) * 1.54f);
            layoutParams = this.c.b.getLayoutParams();
            layoutParams.width = i3;
            layoutParams.height = (int) (((float) i3) * 1.54f);
            layoutParams = this.c.c.getLayoutParams();
            layoutParams.width = i3;
            layoutParams.height = (int) (((float) i3) * 1.54f);
            layoutParams = this.c.e.getLayoutParams();
            layoutParams.width = i3;
            layoutParams.height = (int) (((float) i3) * 1.54f);
            view.setTag(this.c);
        } else {
            this.c = (d) view.getTag();
        }
        if (aVar.c().isEmpty()) {
            this.c.e.setVisibility(8);
            this.c.f.setVisibility(8);
            aVar.b(false);
            this.c.a.a("2130837584", 1, R.drawable.l_default_theme_cover);
        } else {
            if (aVar.b()) {
                this.c.e.setVisibility(0);
                this.c.f.setVisibility(0);
            } else {
                this.c.e.setVisibility(8);
                this.c.f.setVisibility(8);
            }
            this.c.a.b(aVar.c(), 1, 15);
        }
        return view;
    }
}
