package com.vlocker.new_theme.b;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.widget.BaseAdapter;
import com.vlocker.theme.model.d;

public abstract class a extends BaseAdapter {
    protected d a = null;
    private DisplayMetrics b;

    public a(Context context) {
    }

    public d a() {
        return this.a;
    }

    public void a(Context context) {
        this.b = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(this.b);
    }

    public void a(d dVar) {
        if (dVar != null) {
            this.a = dVar;
            notifyDataSetChanged();
        }
    }

    public int getCount() {
        return this.a == null ? 0 : this.a.size();
    }

    public Object getItem(int i) {
        return this.a.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public boolean hasStableIds() {
        return true;
    }

    public boolean isEmpty() {
        return this.a == null ? true : this.a.isEmpty();
    }
}
