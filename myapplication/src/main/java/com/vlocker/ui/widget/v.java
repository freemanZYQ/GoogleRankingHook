package com.vlocker.ui.widget;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

class v implements OnItemClickListener {
    final /* synthetic */ MyAlertController a;
    final /* synthetic */ s b;

    v(s sVar, MyAlertController myAlertController) {
        this.b = sVar;
        this.a = myAlertController;
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.b.x.onClick(this.a.d, i);
        if (!this.b.H) {
            this.a.d.dismiss();
        }
    }
}
