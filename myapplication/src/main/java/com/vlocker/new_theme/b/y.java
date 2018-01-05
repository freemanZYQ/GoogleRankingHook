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
import android.widget.TextView;
import com.vlocker.locker.R;
import com.vlocker.theme.activity.ThemeDetailActivity;
import com.vlocker.theme.f.e;
import com.vlocker.theme.imageloader.RecyclingImageView;
import com.vlocker.theme.imageloader.t;
import com.vlocker.theme.model.T_ThemeItemInfo;
import com.vlocker.theme.model.d;
import java.util.List;

public class y extends BaseAdapter {
    int a = this.d.widthPixels;
    private Context b;
    private List c;
    private DisplayMetrics d;

    public y(Context context, d dVar) {
        this.b = context;
        this.c = dVar;
        a(context);
    }

    private void b() {
        if (e.c(this.b)) {
            System.gc();
            Bundle bundle = new Bundle();
            Intent intent = new Intent();
            intent.setClass(this.b, ThemeDetailActivity.class);
            bundle.putString("tag", "Search");
            intent.putExtras(bundle);
            this.b.startActivity(intent);
            return;
        }
        e.a(this.b, this.b.getString(R.string.t_market_net_set));
    }

    public List a() {
        return this.c;
    }

    public void a(Context context) {
        t tVar = new t(context);
        this.d = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(this.d);
        tVar.a(0.125f);
    }

    public void a(d dVar) {
        this.c = dVar;
    }

    public int getCount() {
        return this.c.size();
    }

    public Object getItem(int i) {
        return this.c.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public int getItemViewType(int i) {
        switch (((com.vlocker.new_theme.beans.e) this.c.get(i)).h().size()) {
            case 1:
                return 0;
            case 2:
                return 1;
            case 3:
                return 2;
            default:
                return 0;
        }
    }

    @SuppressLint({"CutPasteId"})
    public View getView(int i, View view, ViewGroup viewGroup) {
        com.vlocker.new_theme.beans.e eVar = (com.vlocker.new_theme.beans.e) this.c.get(i);
        ai aiVar;
        LayoutParams layoutParams;
        int dimension;
        switch (getItemViewType(i)) {
            case 0:
                ai aiVar2;
                if (view == null) {
                    aiVar = new ai(this);
                    view = LayoutInflater.from(this.b).inflate(R.layout.t_new_dig_list_itembottom, null);
                    aiVar.b = (TextView) view.findViewById(R.id.t_everythemetitle);
                    aiVar.c = (RecyclingImageView) view.findViewById(R.id.onlinetheme_similar01);
                    aiVar.d = (RecyclingImageView) view.findViewById(R.id.onlinetheme_similar02);
                    aiVar.e = (RecyclingImageView) view.findViewById(R.id.onlinetheme_similar03);
                    aiVar.c.setPressedDark(true);
                    aiVar.d.setPressedDark(true);
                    aiVar.e.setPressedDark(true);
                    layoutParams = aiVar.c.getLayoutParams();
                    dimension = (int) ((((float) this.a) - this.b.getResources().getDimension(R.dimen.t_market_digmarginbottom)) / 3.0f);
                    layoutParams.width = dimension;
                    layoutParams.height = (int) (((double) dimension) * 1.68d);
                    layoutParams = aiVar.d.getLayoutParams();
                    layoutParams.width = dimension;
                    layoutParams.height = (int) (((double) dimension) * 1.68d);
                    layoutParams = aiVar.e.getLayoutParams();
                    layoutParams.width = dimension;
                    layoutParams.height = (int) (((double) dimension) * 1.68d);
                    aiVar.d.setBackgroundColor(this.b.getResources().getColor(R.color.transparent));
                    aiVar.e.setBackgroundColor(this.b.getResources().getColor(R.color.transparent));
                    aiVar.d.setImageResource(this.b.getResources().getColor(R.color.transparent));
                    aiVar.e.setImageResource(this.b.getResources().getColor(R.color.transparent));
                    view.setTag(aiVar);
                    aiVar2 = aiVar;
                } else {
                    aiVar2 = (ai) view.getTag();
                }
                aiVar2.b.setVisibility(8);
                aiVar2.c.setOnClickListener(new z(this, eVar));
                aiVar2.d.setOnClickListener(new aa(this));
                aiVar2.e.setOnClickListener(new ab(this));
                if (eVar.d() == null || eVar.d().equals("")) {
                    aiVar2.b.setVisibility(8);
                } else {
                    aiVar2.b.setText(eVar.d());
                }
                try {
                    aiVar2.c.setScaleType(ScaleType.FIT_XY);
                    aiVar2.c.a(((T_ThemeItemInfo) eVar.h().get(0)).g(), 1, 0);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    break;
                }
                break;
            case 1:
                if (view == null) {
                    aiVar = new ai(this);
                    view = LayoutInflater.from(this.b).inflate(R.layout.t_new_dig_list_itembottom, null);
                    aiVar.b = (TextView) view.findViewById(R.id.t_everythemetitle);
                    aiVar.c = (RecyclingImageView) view.findViewById(R.id.onlinetheme_similar01);
                    aiVar.d = (RecyclingImageView) view.findViewById(R.id.onlinetheme_similar02);
                    aiVar.e = (RecyclingImageView) view.findViewById(R.id.onlinetheme_similar03);
                    aiVar.c.setPressedDark(true);
                    aiVar.d.setPressedDark(true);
                    aiVar.e.setPressedDark(true);
                    layoutParams = aiVar.c.getLayoutParams();
                    dimension = (int) ((((float) this.a) - this.b.getResources().getDimension(R.dimen.t_market_digmarginbottom)) / 3.0f);
                    layoutParams.width = dimension;
                    layoutParams.height = (int) (((double) dimension) * 1.68d);
                    layoutParams = aiVar.d.getLayoutParams();
                    layoutParams.width = dimension;
                    layoutParams.height = (int) (((double) dimension) * 1.68d);
                    layoutParams = aiVar.e.getLayoutParams();
                    layoutParams.width = dimension;
                    layoutParams.height = (int) (((double) dimension) * 1.68d);
                    aiVar.e.setBackgroundColor(0);
                    aiVar.e.setImageResource(this.b.getResources().getColor(R.color.transparent));
                    view.setTag(aiVar);
                } else {
                    aiVar = (ai) view.getTag();
                }
                aiVar.b.setVisibility(8);
                aiVar.c.setOnClickListener(new ac(this, eVar));
                aiVar.d.setOnClickListener(new ad(this, eVar));
                aiVar.e.setOnClickListener(new ae(this));
                if (eVar.d() == null || eVar.d().equals("")) {
                    aiVar.b.setVisibility(8);
                } else {
                    aiVar.b.setText(eVar.d());
                }
                try {
                    aiVar.c.setScaleType(ScaleType.FIT_XY);
                    aiVar.c.a(((T_ThemeItemInfo) eVar.h().get(0)).g(), 1, 0);
                    aiVar.d.setScaleType(ScaleType.FIT_XY);
                    aiVar.d.a(((T_ThemeItemInfo) eVar.h().get(1)).g(), 1, 0);
                    break;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    break;
                }
            case 2:
                if (view == null) {
                    aiVar = new ai(this);
                    view = LayoutInflater.from(this.b).inflate(R.layout.t_new_dig_list_itembottom, null);
                    aiVar.b = (TextView) view.findViewById(R.id.t_everythemetitle);
                    aiVar.c = (RecyclingImageView) view.findViewById(R.id.onlinetheme_similar01);
                    aiVar.d = (RecyclingImageView) view.findViewById(R.id.onlinetheme_similar02);
                    aiVar.e = (RecyclingImageView) view.findViewById(R.id.onlinetheme_similar03);
                    aiVar.c.setPressedDark(true);
                    aiVar.d.setPressedDark(true);
                    aiVar.e.setPressedDark(true);
                    layoutParams = aiVar.c.getLayoutParams();
                    dimension = (int) ((((float) this.a) - this.b.getResources().getDimension(R.dimen.t_market_digmarginbottom)) / 3.0f);
                    layoutParams.width = dimension;
                    layoutParams.height = (int) (((double) dimension) * 1.68d);
                    layoutParams = aiVar.d.getLayoutParams();
                    layoutParams.width = dimension;
                    layoutParams.height = (int) (((double) dimension) * 1.68d);
                    layoutParams = aiVar.e.getLayoutParams();
                    layoutParams.width = dimension;
                    layoutParams.height = (int) (((double) dimension) * 1.68d);
                    view.setTag(aiVar);
                } else {
                    aiVar = (ai) view.getTag();
                }
                aiVar.b.setVisibility(8);
                aiVar.c.setOnClickListener(new af(this, eVar));
                aiVar.d.setOnClickListener(new ag(this, eVar));
                aiVar.e.setOnClickListener(new ah(this, eVar));
                if (eVar.d() == null || eVar.d().equals("")) {
                    aiVar.b.setVisibility(8);
                } else {
                    aiVar.b.setText(eVar.d());
                }
                try {
                    aiVar.c.setScaleType(ScaleType.FIT_XY);
                    aiVar.c.a(((T_ThemeItemInfo) eVar.h().get(0)).g(), 1, 0);
                    aiVar.d.setScaleType(ScaleType.FIT_XY);
                    aiVar.d.a(((T_ThemeItemInfo) eVar.h().get(1)).g(), 1, 0);
                    aiVar.e.setScaleType(ScaleType.FIT_XY);
                    aiVar.e.a(((T_ThemeItemInfo) eVar.h().get(2)).g(), 1, 0);
                    break;
                } catch (Exception e22) {
                    e22.printStackTrace();
                    break;
                }
        }
        return view;
    }

    public int getViewTypeCount() {
        return 3;
    }
}
