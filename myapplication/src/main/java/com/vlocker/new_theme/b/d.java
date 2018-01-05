package com.vlocker.new_theme.b;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.location.LocationClientOption;
import com.vlocker.locker.R;
import com.vlocker.new_theme.beans.e;
import com.vlocker.theme.activity.ThemeDetailActivity;
import com.vlocker.theme.imageloader.RecyclingImageView;
import com.vlocker.theme.imageloader.t;
import com.vlocker.theme.model.T_ThemeItemInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class d extends BaseAdapter {
    boolean a = false;
    int b;
    private Context c;
    private List d;
    private int e = 0;
    private int f = 1;
    private String g;
    private l h;
    private k i;
    private DisplayMetrics j;

    public d(Context context, List list, String str) {
        this.c = context;
        this.d = list;
        a();
        a(context);
        this.b = this.j.widthPixels;
        this.g = str;
    }

    private void a() {
        Collection arrayList = new ArrayList();
        if (this.d != null) {
            int i = 0;
            while (i < this.d.size()) {
                if (!(((e) this.d.get(i)).g() == 0 || ((e) this.d.get(i)).g() == 1)) {
                    arrayList.add(this.d.get(i));
                }
                i++;
            }
            this.d.removeAll(arrayList);
        }
    }

    private void b() {
        if (com.vlocker.theme.f.e.c(this.c)) {
            System.gc();
            Bundle bundle = new Bundle();
            Intent intent = new Intent();
            intent.setClass(this.c, ThemeDetailActivity.class);
            bundle.putString("tag", "Goods");
            bundle.putString("tag_title", this.g);
            intent.putExtras(bundle);
            this.c.startActivity(intent);
            return;
        }
        com.vlocker.theme.f.e.a(this.c, this.c.getString(R.string.t_market_net_set), 0);
    }

    public void a(Context context) {
        t tVar = new t(context);
        this.j = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(this.j);
        tVar.a(0.125f);
    }

    public void a(com.vlocker.theme.model.d dVar) {
        this.d = dVar;
        a();
        notifyDataSetChanged();
    }

    public int getCount() {
        return this.d != null ? this.d.size() : 0;
    }

    public Object getItem(int i) {
        return this.d.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public int getItemViewType(int i) {
        switch (((e) this.d.get(i)).g()) {
            case 0:
                return this.e;
            case 1:
                return this.f;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            case 5:
                return 5;
            default:
                return super.getItemViewType(i);
        }
    }

    @SuppressLint({"CutPasteId"})
    public View getView(int i, View view, ViewGroup viewGroup) {
        e eVar = (e) this.d.get(i);
        int g = ((e) this.d.get(i)).g();
        if (view != null) {
            switch (g) {
                case 0:
                    this.h = (l) view.getTag();
                    break;
                case 1:
                    this.i = (k) view.getTag();
                    break;
                default:
                    break;
            }
        }
        switch (g) {
            case 0:
                this.h = new l(this);
                view = LayoutInflater.from(this.c).inflate(R.layout.t_new_dig_list_itembottom, null);
                this.h.b = (TextView) view.findViewById(R.id.t_everythemetitle);
                this.h.c = (TextView) view.findViewById(R.id.view_utils);
                this.h.d = (RecyclingImageView) view.findViewById(R.id.onlinetheme_similar01);
                this.h.e = (RecyclingImageView) view.findViewById(R.id.onlinetheme_similar02);
                this.h.f = (RecyclingImageView) view.findViewById(R.id.onlinetheme_similar03);
                this.h.d.setPressedDark(true);
                this.h.e.setPressedDark(true);
                this.h.f.setPressedDark(true);
                LayoutParams layoutParams = this.h.d.getLayoutParams();
                int dimension = (int) ((((float) this.b) - this.c.getResources().getDimension(R.dimen.t_market_digmarginbottom)) / 3.0f);
                layoutParams.width = dimension;
                layoutParams.height = (int) (((double) dimension) * 1.68d);
                layoutParams = this.h.e.getLayoutParams();
                layoutParams.width = dimension;
                layoutParams.height = (int) (((double) dimension) * 1.68d);
                layoutParams = this.h.f.getLayoutParams();
                layoutParams.width = dimension;
                layoutParams.height = (int) (((double) dimension) * 1.68d);
                view.setTag(this.h);
                break;
            case 1:
                this.i = new k(this);
                view = LayoutInflater.from(this.c).inflate(R.layout.t_digtagitem, null);
                this.i.g = (RelativeLayout) view.findViewById(R.id.wp_img_relativlayout);
                this.i.d = (RecyclingImageView) view.findViewById(R.id.cate_image_view);
                this.i.c = (TextView) view.findViewById(R.id.digtagtitletext);
                this.i.h = (RelativeLayout) view.findViewById(R.id.wp_img_relativlayout1);
                this.i.e = (RecyclingImageView) view.findViewById(R.id.cate_image_view1);
                this.i.i = (RelativeLayout) view.findViewById(R.id.wp_img_relativlayout2);
                this.i.f = (RecyclingImageView) view.findViewById(R.id.cate_image_view2);
                this.i.a = (TextView) view.findViewById(R.id.cate_tag_name2);
                int i2 = this.b > 720 ? (this.b - 86) / 3 : (this.b >= LocationClientOption.MIN_SCAN_SPAN || this.b < 720) ? (this.b < 480 || this.b >= 720) ? (this.b - 38) / 3 : (this.b - 48) / 3 : (this.b - 66) / 3;
                LayoutParams layoutParams2 = this.i.d.getLayoutParams();
                layoutParams2.width = i2;
                layoutParams2.height = i2;
                layoutParams2 = this.i.g.getLayoutParams();
                layoutParams2.width = i2;
                layoutParams2.height = i2;
                layoutParams2 = this.i.e.getLayoutParams();
                layoutParams2.width = i2;
                layoutParams2.height = i2;
                layoutParams2 = this.i.h.getLayoutParams();
                layoutParams2.width = i2;
                layoutParams2.height = i2;
                layoutParams2 = this.i.f.getLayoutParams();
                layoutParams2.width = i2;
                layoutParams2.height = i2;
                layoutParams2 = this.i.i.getLayoutParams();
                layoutParams2.width = i2;
                layoutParams2.height = i2;
                this.i.d.setScaleType(ScaleType.FIT_XY);
                this.i.e.setScaleType(ScaleType.FIT_XY);
                this.i.f.setScaleType(ScaleType.FIT_XY);
                view.setTag(this.i);
                break;
        }
        switch (g) {
            case 0:
                if (i < 1) {
                    this.h.c.setVisibility(0);
                } else {
                    this.h.c.setVisibility(8);
                }
                this.h.b.setVisibility(8);
                this.h.d.setOnClickListener(new h(this, eVar));
                this.h.e.setOnClickListener(new i(this, eVar));
                this.h.f.setOnClickListener(new j(this, eVar));
                if (eVar.d() == null || eVar.d().equals("")) {
                    this.h.b.setVisibility(8);
                } else {
                    this.h.b.setText(eVar.d());
                }
                try {
                    this.h.d.a(((T_ThemeItemInfo) eVar.h().get(0)).g(), 1, 0);
                    this.h.e.a(((T_ThemeItemInfo) eVar.h().get(1)).g(), 1, 0);
                    this.h.f.a(((T_ThemeItemInfo) eVar.h().get(2)).g(), 1, 0);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    break;
                }
                break;
            case 1:
                List c = eVar.c();
                dimension = c.size();
                this.i.d.setScaleType(ScaleType.FIT_XY);
                this.i.e.setScaleType(ScaleType.FIT_XY);
                this.i.f.setScaleType(ScaleType.FIT_XY);
                if (dimension > 0) {
                    this.i.d.a(((e) c.get(0)).e(), 1, 0);
                }
                if (dimension > 1) {
                    this.i.e.a(((e) c.get(1)).e(), 1, 0);
                }
                if (dimension > 2) {
                    this.i.a.setText(((e) c.get(2)).d());
                    this.i.f.a(((e) c.get(2)).e(), 1, 0);
                }
                if (eVar.d() == null || eVar.d().equals("")) {
                    this.i.c.setVisibility(8);
                } else {
                    this.i.c.setText(eVar.d());
                }
                this.i.g.setOnClickListener(new e(this, c));
                this.i.h.setOnClickListener(new f(this, c));
                this.i.i.setOnClickListener(new g(this, c));
                break;
        }
        return view;
    }

    public int getViewTypeCount() {
        return 6;
    }
}
