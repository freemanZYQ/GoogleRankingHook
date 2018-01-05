package com.vlocker.search;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.moxiu.b.a.a;
import com.vlocker.locker.R;
import com.vlocker.theme.imageloader.RecyclingImageView;
import com.vlocker.theme.imageloader.t;
import java.util.ArrayList;
import java.util.List;

public class ai extends BaseAdapter {
    int a;
    List b = new ArrayList();
    private Context c;
    private DisplayMetrics d;
    private ak e;

    public ai(Context context, List list) {
        this.c = context;
        this.b = list;
        a(this.c);
        this.a = this.d.widthPixels;
    }

    public void a(Context context) {
        t tVar = new t(context);
        this.d = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(this.d);
        tVar.a(0.125f);
    }

    public void a(List list) {
        this.b = list;
        notifyDataSetChanged();
    }

    public int getCount() {
        return (this.b == null || this.b.size() <= 0) ? 0 : this.b.size();
    }

    public Object getItem(int i) {
        return this.b.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar = (a) this.b.get(i);
        if (view == null) {
            view = LayoutInflater.from(this.c).inflate(R.layout.m_bd_grid_item, null);
            this.e = new ak();
            this.e.b = (RecyclingImageView) view.findViewById(R.id.cate_image_view);
            this.e.a = (TextView) view.findViewById(R.id.cate_tag_name);
            view.setTag(this.e);
            aVar.b(view);
        } else {
            this.e = (ak) view.getTag();
        }
        this.e.b.setScaleType(ScaleType.FIT_XY);
        this.e.b.a(aVar.d(), 2, 0);
        this.e.b.setIsCircle(true);
        this.e.a.setText(aVar.h());
        return view;
    }
}
