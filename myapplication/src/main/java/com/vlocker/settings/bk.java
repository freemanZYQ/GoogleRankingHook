package com.vlocker.settings;

import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;

class bk implements OnValueChangeListener {
    final /* synthetic */ NotificationLightActivity a;

    bk(NotificationLightActivity notificationLightActivity) {
        this.a = notificationLightActivity;
    }

    public void onValueChange(NumberPicker numberPicker, int i, int i2) {
        this.a.e.setText(this.a.a(this.a.l.getValue()));
        this.a.f.setText(this.a.a(this.a.n.getValue()));
    }
}
