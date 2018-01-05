package com.vlocker.settings;

import android.view.View;
import android.view.View.OnClickListener;

class dj implements OnClickListener {
    final /* synthetic */ WeatherSettingsActivity a;

    dj(WeatherSettingsActivity weatherSettingsActivity) {
        this.a = weatherSettingsActivity;
    }

    public void onClick(View view) {
        this.a.e.dismiss();
    }
}
