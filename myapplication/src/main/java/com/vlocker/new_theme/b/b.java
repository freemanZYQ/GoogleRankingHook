package com.vlocker.new_theme.b;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.vlocker.locker.R;
import com.vlocker.new_theme.beans.T_CateInfo;
import com.vlocker.new_theme.e.g;
import com.vlocker.theme.imageloader.RecyclingImageView;
import java.util.List;

public class b extends BaseAdapter {
    private Context a;
    private List b = null;
    private g c = null;
    private int d;

    public b(Context context, List list) {
        this.a = context;
        this.b = list;
        this.d = ((Activity) this.a).getWindowManager().getDefaultDisplay().getWidth();
    }

    public int getCount() {
        return (this.b == null || this.b.size() <= 0) ? 0 : this.b.size();
    }

    public Object getItem(int i) {
        return (this.b == null || this.b.size() <= 0) ? null : this.b.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            try {
                view = LayoutInflater.from(this.a).inflate(R.layout.t_market_categoryitm, null);
                this.c = new g();
                this.c.a = (RecyclingImageView) view.findViewById(R.id.themetab_category_imagelogo);
                this.c.a.setPressedDark(true);
                this.c.b = (TextView) view.findViewById(R.id.cate_title);
                this.c.g = (RelativeLayout) view.findViewById(R.id.moxiu_detail_layout);
                int dimension = (int) ((((float) this.d) - this.a.getResources().getDimension(R.dimen.t_market_catemargin)) / 3.0f);
                LayoutParams layoutParams = this.c.g.getLayoutParams();
                layoutParams.height = dimension;
                layoutParams.width = dimension;
                layoutParams = this.c.a.getLayoutParams();
                layoutParams.height = dimension;
                layoutParams.width = dimension;
                view.setTag(this.c);
            } catch (OutOfMemoryError e) {
                e.printStackTrace();
            }
        } else {
            this.c = (g) view.getTag();
        }
        this.c.g.setOnClickListener(new c(this, i));
        this.c.b.setText(((T_CateInfo) this.b.get(i)).a());
        this.c.b.setClickable(false);
        this.c.a.setTag(((T_CateInfo) this.b.get(i)).c());
        this.c.a.a(((T_CateInfo) this.b.get(i)).c(), 1, 0);
        return view;
    }
}
