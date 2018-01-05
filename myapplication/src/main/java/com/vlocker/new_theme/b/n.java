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
import android.widget.BaseAdapter;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.vlocker.locker.R;
import com.vlocker.theme.activity.ThemeDetailActivity;
import com.vlocker.theme.f.e;
import com.vlocker.theme.imageloader.RecyclingImageView;
import com.vlocker.theme.imageloader.aa;
import com.vlocker.theme.imageloader.t;
import com.vlocker.theme.model.T_ThemeItemInfo;
import com.vlocker.theme.model.d;
import java.util.List;

public class n extends BaseAdapter {
    boolean a = false;
    int b;
    ListView c;
    private Context d;
    private List e;
    private int f = 0;
    private int g = 1;
    private int h = 2;
    private w i;
    private String j = "";
    private String k;
    private w l;
    private DisplayMetrics m;

    public n(Context context, d dVar, ListView listView) {
        this.d = context;
        this.e = dVar;
        a(context);
        this.b = this.m.widthPixels;
        this.c = listView;
    }

    private void a(String str) {
        if (e.c(this.d)) {
            System.gc();
            Bundle bundle = new Bundle();
            Intent intent = new Intent();
            intent.setClass(this.d, ThemeDetailActivity.class);
            bundle.putString("tag", "Goods");
            bundle.putString("tag_title", str);
            intent.putExtras(bundle);
            if (this.d != null) {
                this.d.startActivity(intent);
                return;
            }
            return;
        }
        e.a(this.d, this.d.getString(R.string.t_market_net_set));
    }

    public void a(Context context) {
        t tVar = new t(context);
        this.m = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(this.m);
        tVar.a(0.125f);
        this.j = "digest";
        this.k = "jingping";
    }

    public void a(d dVar) {
        this.e = dVar;
    }

    public void a(List list, LinearLayout linearLayout, Context context) {
        View linearLayout2 = new LinearLayout(context);
        linearLayout2.setLayoutParams(new LayoutParams(-2, -2));
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(17);
        int i = 0;
        View view = linearLayout2;
        while (i < list.size()) {
            View linearLayout3;
            com.vlocker.new_theme.beans.e eVar = (com.vlocker.new_theme.beans.e) list.get(i);
            View inflate = LayoutInflater.from(this.d).inflate(R.layout.t_hot_tag_item, null);
            RecyclingImageView recyclingImageView = (RecyclingImageView) inflate.findViewById(R.id.cate_image_view);
            TextView textView = (TextView) inflate.findViewById(R.id.cate_tag_name);
            int dimension = (int) ((((float) this.b) - this.d.getResources().getDimension(R.dimen.t_market_digtagmargin)) / 2.0f);
            ViewGroup.LayoutParams layoutParams = recyclingImageView.getLayoutParams();
            layoutParams.width = dimension;
            layoutParams.height = dimension / 2;
            layoutParams = ((RelativeLayout) inflate.findViewById(R.id.wp_img_relativlayout)).getLayoutParams();
            layoutParams.width = dimension;
            layoutParams.height = dimension / 2;
            recyclingImageView.setScaleType(ScaleType.FIT_XY);
            recyclingImageView.a(eVar.e(), 1, 0);
            textView.setText(eVar.d());
            view.addView(inflate);
            if (view.getChildCount() == 2) {
                linearLayout.addView(view);
                linearLayout3 = new LinearLayout(context);
                linearLayout3.setGravity(17);
                linearLayout3.setLayoutParams(new LayoutParams(-2, -2));
                linearLayout3.setOrientation(0);
            } else {
                linearLayout3 = view;
            }
            inflate.setOnClickListener(new v(this, eVar));
            i++;
            view = linearLayout3;
        }
    }

    public int getCount() {
        return this.e.size();
    }

    public Object getItem(int i) {
        return this.e.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public int getItemViewType(int i) {
        switch (((com.vlocker.new_theme.beans.e) this.e.get(i)).g()) {
            case 0:
                return this.f;
            case 1:
                return this.g;
            case 2:
                return this.h;
            default:
                return super.getItemViewType(i);
        }
    }

    @SuppressLint({"CutPasteId"})
    public View getView(int i, View view, ViewGroup viewGroup) {
        com.vlocker.new_theme.beans.e eVar = (com.vlocker.new_theme.beans.e) this.e.get(i);
        int g = ((com.vlocker.new_theme.beans.e) this.e.get(i)).g();
        if (view != null) {
            switch (g) {
                case 0:
                    this.i = (w) view.getTag();
                    break;
                case 1:
                    List c = eVar.c();
                    view = LayoutInflater.from(this.d).inflate(R.layout.t_digtaggrid, null);
                    a(c, (LinearLayout) view.findViewById(R.id.t_diglinearlayout), this.d);
                    break;
                case 2:
                    this.l = (w) view.getTag();
                    break;
                default:
                    break;
            }
        }
        int dimension = (int) ((((float) this.b) - this.d.getResources().getDimension(R.dimen.t_market_digmargin)) / 3.0f);
        ViewGroup.LayoutParams layoutParams;
        switch (g) {
            case 0:
                this.i = new w(this);
                view = LayoutInflater.from(this.d).inflate(R.layout.t_new_dig_list_item, null);
                this.i.b = (TextView) view.findViewById(R.id.t_everythemetitle);
                this.i.c = (RecyclingImageView) view.findViewById(R.id.onlinetheme_similar01);
                this.i.d = (RecyclingImageView) view.findViewById(R.id.onlinetheme_similar02);
                this.i.e = (RecyclingImageView) view.findViewById(R.id.onlinetheme_similar03);
                this.i.c.setPressedDark(true);
                this.i.d.setPressedDark(true);
                this.i.e.setPressedDark(true);
                this.i.f = (LinearLayout) view.findViewById(R.id.t_digright);
                layoutParams = this.i.c.getLayoutParams();
                layoutParams.width = dimension;
                layoutParams.height = (int) (((double) dimension) * 1.68d);
                layoutParams = this.i.d.getLayoutParams();
                layoutParams.width = dimension;
                layoutParams.height = (int) (((double) dimension) * 1.68d);
                layoutParams = this.i.e.getLayoutParams();
                layoutParams.width = dimension;
                layoutParams.height = (int) (((double) dimension) * 1.68d);
                view.setTag(this.i);
                break;
            case 1:
                c = eVar.c();
                view = LayoutInflater.from(this.d).inflate(R.layout.t_digtaggrid, null);
                LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.t_diglinearlayout);
                if (!(c == null || this.d == null)) {
                    a(c, linearLayout, this.d);
                    break;
                }
            case 2:
                this.l = new w(this);
                view = LayoutInflater.from(this.d).inflate(R.layout.t_new_dig_list_itembottom, null);
                this.l.b = (TextView) view.findViewById(R.id.t_everythemetitle);
                this.l.c = (RecyclingImageView) view.findViewById(R.id.onlinetheme_similar01);
                this.l.d = (RecyclingImageView) view.findViewById(R.id.onlinetheme_similar02);
                this.l.e = (RecyclingImageView) view.findViewById(R.id.onlinetheme_similar03);
                this.l.c.setPressedDark(true);
                this.l.d.setPressedDark(true);
                this.l.e.setPressedDark(true);
                layoutParams = this.l.c.getLayoutParams();
                dimension = (int) ((((float) this.b) - this.d.getResources().getDimension(R.dimen.t_market_digmarginbottom)) / 3.0f);
                layoutParams.width = dimension;
                layoutParams.height = (int) (((double) dimension) * 1.68d);
                layoutParams = this.l.d.getLayoutParams();
                layoutParams.width = dimension;
                layoutParams.height = (int) (((double) dimension) * 1.68d);
                layoutParams = this.l.e.getLayoutParams();
                layoutParams.width = dimension;
                layoutParams.height = (int) (((double) dimension) * 1.68d);
                view.setTag(this.l);
                break;
        }
        switch (g) {
            case 0:
                if (aa.c()) {
                    this.c.setDivider(null);
                }
                this.i.f.setOnClickListener(new o(this, eVar));
                this.i.c.setOnClickListener(new p(this, eVar));
                this.i.d.setOnClickListener(new q(this, eVar));
                this.i.e.setOnClickListener(new r(this, eVar));
                this.i.b.setText(eVar.d());
                try {
                    this.i.c.setScaleType(ScaleType.FIT_XY);
                    this.i.c.a(((T_ThemeItemInfo) eVar.h().get(0)).g(), 1, 0);
                    this.i.d.setScaleType(ScaleType.FIT_XY);
                    this.i.d.a(((T_ThemeItemInfo) eVar.h().get(1)).g(), 1, 0);
                    this.i.e.setScaleType(ScaleType.FIT_XY);
                    this.i.e.a(((T_ThemeItemInfo) eVar.h().get(2)).g(), 1, 0);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    break;
                }
            case 2:
                String str = "设计师新品";
                if (aa.c()) {
                    this.c.setDivider(null);
                }
                this.l.b.setVisibility(8);
                this.l.c.setOnClickListener(new s(this, eVar));
                this.l.d.setOnClickListener(new t(this, eVar));
                this.l.e.setOnClickListener(new u(this, eVar));
                if (eVar.d() == null || eVar.d().equals("")) {
                    this.l.b.setVisibility(8);
                } else {
                    this.l.b.setText(eVar.d());
                }
                try {
                    this.l.c.setScaleType(ScaleType.FIT_XY);
                    this.l.c.a(((T_ThemeItemInfo) eVar.h().get(0)).g(), 1, 0);
                    this.l.d.setScaleType(ScaleType.FIT_XY);
                    this.l.d.a(((T_ThemeItemInfo) eVar.h().get(1)).g(), 1, 0);
                    this.l.e.setScaleType(ScaleType.FIT_XY);
                    this.l.e.a(((T_ThemeItemInfo) eVar.h().get(2)).g(), 1, 0);
                    break;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    break;
                }
        }
        return view;
    }

    public int getViewTypeCount() {
        return 3;
    }
}
