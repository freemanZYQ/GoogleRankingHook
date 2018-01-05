package com.vlocker.settings;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

class bq implements OnItemClickListener {
    final /* synthetic */ NotifyAppsSelectActivity a;

    bq(NotifyAppsSelectActivity notifyAppsSelectActivity) {
        this.a = notifyAppsSelectActivity;
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.a.a(view, i, this.a.f, this.a.i);
    }
}
