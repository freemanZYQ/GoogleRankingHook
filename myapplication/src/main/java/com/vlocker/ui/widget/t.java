package com.vlocker.ui.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.vlocker.ui.widget.MyAlertController.RecycleListView;

class t extends ArrayAdapter {
    final /* synthetic */ RecycleListView a;
    final /* synthetic */ s b;

    t(s sVar, Context context, int i, int i2, CharSequence[] charSequenceArr, RecycleListView recycleListView) {
        this.b = sVar;
        this.a = recycleListView;
        super(context, i, i2, charSequenceArr);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2 = super.getView(i, view, viewGroup);
        if (this.b.F != null && this.b.F[i]) {
            this.a.setItemChecked(i, true);
        }
        return view2;
    }
}
