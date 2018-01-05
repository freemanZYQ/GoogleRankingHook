package com.vlocker.search;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.vlocker.locker.R;
import com.vlocker.theme.model.d;

public class ah extends BaseAdapter {
    private BaiduSearchActivity a;
    private final int b = 0;
    private final int c = 1;
    private final int d = 2;
    private final String e = "HintSearch";
    private p f = null;
    private al g;
    private d h;
    private bk i;

    public ah(BaiduSearchActivity baiduSearchActivity, d dVar) {
        this.a = baiduSearchActivity;
        float f = (float) this.a.getResources().getDisplayMetrics().widthPixels;
        this.a.getResources().getDimension(R.dimen.t_market_digtagmargin);
        try {
            this.i = bk.a(baiduSearchActivity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.h = new d();
        this.h.addAll(dVar);
    }

    public void a(d dVar) {
        if (dVar != null && !dVar.isEmpty()) {
            if (this.h == null) {
                this.h = new d();
            }
            if (!this.h.isEmpty()) {
                this.h.clear();
            }
            this.h.addAll(dVar);
            notifyDataSetChanged();
        }
    }

    public int getCount() {
        return this.h == null ? 0 : this.h.size();
    }

    public Object getItem(int i) {
        return this.h == null ? null : (ac) this.h.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public int getItemViewType(int i) {
        if (this.h == null) {
            return super.getItemViewType(i);
        }
        String b = ((ac) this.h.get(i)).b();
        return "baidu".equals(b) ? 1 : "theme".equals(b) ? 2 : super.getItemViewType(i);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        Object obj = (ac) this.h.get(i);
        switch (getItemViewType(i)) {
            case 1:
                if (view == null) {
                    this.f = new r(this.a);
                } else {
                    this.f = (r) view.getTag();
                }
                this.f.b(obj);
                break;
        }
        return this.f.c();
    }

    public int getViewTypeCount() {
        return 6;
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        if (this.g != null) {
            this.g.notifyDataSetChanged();
        }
    }
}
