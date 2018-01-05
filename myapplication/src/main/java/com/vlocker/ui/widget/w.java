package com.vlocker.ui.widget;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.vlocker.ui.widget.MyAlertController.RecycleListView;

class w implements OnItemClickListener {
    final /* synthetic */ RecycleListView a;
    final /* synthetic */ MyAlertController b;
    final /* synthetic */ s c;

    w(s sVar, RecycleListView recycleListView, MyAlertController myAlertController) {
        this.c = sVar;
        this.a = recycleListView;
        this.b = myAlertController;
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        if (this.c.F != null) {
            this.c.F[i] = this.a.isItemChecked(i);
        }
        this.c.J.onClick(this.b.d, i, this.a.isItemChecked(i));
    }
}
