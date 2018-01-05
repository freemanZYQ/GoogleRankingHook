package com.vlocker.search;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.vlocker.locker.R;
import com.vlocker.theme.imageloader.RecyclingImageView;
import java.util.List;

public class al extends BaseAdapter {
    List a;
    private Context b;
    private PackageManager c;
    private an d;

    public Drawable a(String str) {
        try {
            return this.c.getApplicationInfo(str, 0).loadIcon(this.c);
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
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
        ab abVar = (ab) this.a.get(i);
        if (view == null) {
            view = LayoutInflater.from(this.b).inflate(R.layout.m_bd_grid_item, null);
            this.d = new an();
            this.d.b = (RecyclingImageView) view.findViewById(R.id.cate_image_view);
            this.d.a = (TextView) view.findViewById(R.id.cate_tag_name);
            view.setTag(this.d);
        } else {
            this.d = (an) view.getTag();
        }
        this.d.b.setScaleType(ScaleType.FIT_XY);
        this.d.b.setImageDrawable(a(abVar.b()));
        this.d.a.setText(abVar.a());
        return view;
    }
}
