package com.vlocker.settings;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

class br implements OnItemClickListener {
    final /* synthetic */ NotifyAppsSelectActivity a;

    br(NotifyAppsSelectActivity notifyAppsSelectActivity) {
        this.a = notifyAppsSelectActivity;
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.a.a(view, i, this.a.g, this.a.j);
    }
}
