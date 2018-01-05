package com.vlocker.settings;

import android.view.View;
import android.view.View.OnClickListener;

class dk implements OnClickListener {
    final /* synthetic */ WeatherSettingsActivity a;

    dk(WeatherSettingsActivity weatherSettingsActivity) {
        this.a = weatherSettingsActivity;
    }

    public void onClick(View view) {
        this.a.a(false);
        this.a.e.dismiss();
    }
}
