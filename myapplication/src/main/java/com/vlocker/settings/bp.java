package com.vlocker.settings;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

class bp implements OnItemClickListener {
    final /* synthetic */ NotifyAppsSelectActivity a;

    bp(NotifyAppsSelectActivity notifyAppsSelectActivity) {
        this.a = notifyAppsSelectActivity;
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.a.a(view, i, this.a.e, this.a.h);
    }
}
