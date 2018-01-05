package com.vlocker.settings;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import com.vlocker.locker.R;
import com.vlocker.weather.b.a;
import java.util.ArrayList;

class f extends ArrayAdapter implements Filterable {
    ArrayList a;
    final /* synthetic */ CitySelectActivity b;

    public f(CitySelectActivity citySelectActivity, Context context) {
        this.b = citySelectActivity;
        super(context, R.layout.l_list_item, R.id.item_name);
    }

    public String a(int i) {
        return (this.a == null || i >= this.a.size()) ? null : ((a) this.a.get(i)).f();
    }

    public a b(int i) {
        return (this.a == null || i >= this.a.size()) ? null : (a) this.a.get(i);
    }

    public int getCount() {
        return this.a == null ? 0 : this.a.size();
    }

    public Filter getFilter() {
        return new g(this);
    }

    public /* synthetic */ Object getItem(int i) {
        return a(i);
    }
}
