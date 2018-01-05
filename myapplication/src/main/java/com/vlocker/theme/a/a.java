package com.vlocker.theme.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.vlocker.b.j;
import com.vlocker.locker.R;
import com.vlocker.m.aj;
import com.vlocker.new_theme.e.g;
import com.vlocker.security.MoSecurityApplication;
import com.vlocker.theme.f.c;
import com.vlocker.theme.imageloader.RecyclingImageView;

public class a extends BaseAdapter {
    boolean a = false;
    private Context b;
    private g c = null;
    private String d;
    private int e;

    public a(Context context, String str) {
        this.b = context;
        this.d = str;
        if (!"default".equals(str)) {
            this.a = c.a(context, str, "vlocker_widget_preview");
        }
        if (this.a) {
            this.e = 3;
        } else {
            this.e = 2;
        }
    }

    public int getCount() {
        return this.e;
    }

    public Object getItem(int i) {
        return null;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            this.c = new g();
            view = LayoutInflater.from(this.b).inflate(R.layout.t_market_onlinetheme_detail_preview_item, null);
            view.setTag(this.c);
        } else {
            this.c = (g) view.getTag();
        }
        this.c.a = (RecyclingImageView) view.findViewById(R.id.mypreview);
        if ((j.a(this.b, "com.moxiu.launcher") && aj.b(this.b, "com.moxiu.launcher") >= 533 && !MoSecurityApplication.a) || i == 0) {
            view.findViewById(R.id.moxiu_detail_mark).setVisibility(8);
        }
        if (this.e == 2) {
            if ("default".equals(this.d)) {
                if (i == 0) {
                    this.c.a.setImageResource(R.drawable.vlocker_widget_preview);
                } else if (i == 1) {
                    this.c.a.setImageResource(R.drawable.moxiu_preview);
                }
            } else if (i == 0) {
                this.c.a.b(this.d, 1, 9);
            } else if (i == 1) {
                this.c.a.b(this.d, 1, 10);
            }
        } else if (this.e == 3) {
            if (i == 0) {
                this.c.a.b(this.d, 1, 11);
            } else if (i == 1) {
                this.c.a.b(this.d, 1, 9);
            } else if (i == 2) {
                this.c.a.b(this.d, 1, 10);
            }
        }
        return view;
    }
}
