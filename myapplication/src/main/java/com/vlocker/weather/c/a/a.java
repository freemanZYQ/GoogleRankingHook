package com.vlocker.weather.c.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.vlocker.locker.R;
import com.vlocker.m.l;
import com.vlocker.ui.cover.g;
import com.vlocker.weather.a.q;
import com.vlocker.weather.c.c.b;
import com.vlocker.weather.c.d.c;
import com.vlocker.weather.e.d;
import java.util.ArrayList;

public class a extends BaseAdapter {
    public boolean a = false;
    private ArrayList b = new ArrayList();
    private Context c;
    private e d;

    public a(Context context, e eVar) {
        this.c = context;
        this.d = eVar;
    }

    private View a(int i) {
        switch (i) {
            case 1:
            case 3:
                return View.inflate(this.c, R.layout.weather_news_card_item, null);
            case 2:
                return View.inflate(this.c, R.layout.weather_news_card_item_imgs, null);
            case 4:
                return View.inflate(this.c, R.layout.weather_news_card_item_large, null);
            default:
                return null;
        }
    }

    private d a(int i, View view) {
        switch (i) {
            case 1:
                return new f(this, view);
            case 2:
                return new g(this, view);
            case 3:
                return new c(this, view, false);
            case 4:
                return new c(this, view, true);
            default:
                return null;
        }
    }

    private void a(ImageView imageView, boolean z) {
        int i = this.c.getResources().getDisplayMetrics().widthPixels;
        LayoutParams layoutParams = imageView.getLayoutParams();
        if (z) {
            layoutParams.height = (int) (((float) (i - l.a(64.0f))) / 1.9f);
        } else {
            layoutParams.width = ((i - l.a(64.0f)) / 3) - l.a(4.0f);
        }
        imageView.setLayoutParams(layoutParams);
    }

    private void a(b bVar, View view) {
        if (g.a() && !bVar.i() && !bVar.g() && q.b) {
            c.a().c().b(bVar);
            bVar.a(true);
        }
        if (bVar.i() && q.b) {
            com.moxiu.b.a.a a = ((com.vlocker.weather.c.c.a) bVar).a();
            if (a != null) {
                a.b(view);
                if (!bVar.g()) {
                    d.c(this.c, "1040", a.m(), a.n());
                    bVar.a(true);
                }
            }
        }
    }

    public void a(AbsListView absListView, int i) {
        try {
            int lastVisiblePosition = absListView.getLastVisiblePosition();
            if (q.b && lastVisiblePosition < 8) {
                for (int i2 = 0; i2 <= lastVisiblePosition; i2++) {
                    if (this.b.get(i2) instanceof com.vlocker.weather.c.c.a) {
                        com.moxiu.b.a.a a = ((com.vlocker.weather.c.c.a) this.b.get(i2)).a();
                        a.b(absListView.getChildAt(i2));
                        if (!((b) this.b.get(i2)).g()) {
                            d.c(this.c, "1040", a.m(), a.n());
                            ((b) this.b.get(i2)).a(true);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(ArrayList arrayList) {
        this.b.clear();
        this.b.addAll(arrayList);
        notifyDataSetChanged();
    }

    public int getCount() {
        return this.b.size();
    }

    public Object getItem(int i) {
        return this.b.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        d a;
        b bVar = (b) this.b.get(i);
        if (view == null || !(view == null || ((d) view.getTag()).h == bVar.h())) {
            view = a(bVar.h());
            a = a(bVar.h(), view);
        } else {
            a = (d) view.getTag();
        }
        a.a(bVar);
        a(bVar, view);
        view.setOnClickListener(new b(this, bVar));
        return view;
    }
}
