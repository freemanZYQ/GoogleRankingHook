package com.vlocker.ui.widget;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;

class ae implements OnItemClickListener, OnItemLongClickListener {
    final /* synthetic */ MyGridView a;

    private ae(MyGridView myGridView) {
        this.a = myGridView;
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        if (this.a.b != null) {
            int headerViewCount = i - (this.a.getHeaderViewCount() * this.a.getNumColumnsCompatible());
            if (headerViewCount >= 0) {
                this.a.b.onItemClick(adapterView, view, headerViewCount, j);
            }
        }
    }

    public boolean onItemLongClick(AdapterView adapterView, View view, int i, long j) {
        if (this.a.c != null) {
            int headerViewCount = i - (this.a.getHeaderViewCount() * this.a.getNumColumnsCompatible());
            if (headerViewCount >= 0) {
                this.a.c.onItemLongClick(adapterView, view, headerViewCount, j);
            }
        }
        return true;
    }
}
