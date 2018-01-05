package com.vlocker.settings;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class di implements OnClickListener {
    final /* synthetic */ WeatherSettingsActivity a;

    di(WeatherSettingsActivity weatherSettingsActivity) {
        this.a = weatherSettingsActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        try {
            this.a.startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
        } catch (Exception e) {
        }
    }
}
