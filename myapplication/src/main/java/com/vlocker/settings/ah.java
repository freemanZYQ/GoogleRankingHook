package com.vlocker.settings;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

class ah implements OnItemClickListener {
    final /* synthetic */ GuideSettingListActivity a;

    ah(GuideSettingListActivity guideSettingListActivity) {
        this.a = guideSettingListActivity;
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.a.a(i);
    }
}
