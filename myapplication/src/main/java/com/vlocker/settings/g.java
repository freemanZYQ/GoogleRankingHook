package com.vlocker.settings;

import android.widget.Filter;
import android.widget.Filter.FilterResults;
import com.vlocker.weather.e.j;
import java.util.ArrayList;

class g extends Filter {
    final /* synthetic */ f a;

    g(f fVar) {
        this.a = fVar;
    }

    protected FilterResults performFiltering(CharSequence charSequence) {
        FilterResults filterResults = new FilterResults();
        if (charSequence != null) {
            ArrayList a = j.a(charSequence.toString(), this.a.b);
            filterResults.values = a;
            filterResults.count = a.size();
        }
        this.a.b.i = true;
        return filterResults;
    }

    protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
        if (filterResults == null || filterResults.count <= 0) {
            if (this.a.b.d.enoughToFilter()) {
                this.a.b.b();
            } else {
                this.a.b.c();
            }
            this.a.a = null;
            this.a.notifyDataSetInvalidated();
            return;
        }
        this.a.a = (ArrayList) filterResults.values;
        this.a.b.c();
        this.a.notifyDataSetChanged();
    }
}
