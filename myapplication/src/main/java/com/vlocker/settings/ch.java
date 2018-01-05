package com.vlocker.settings;

import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;

class ch implements OnValueChangeListener {
    final /* synthetic */ RedPacketActivity a;

    ch(RedPacketActivity redPacketActivity) {
        this.a = redPacketActivity;
    }

    public void onValueChange(NumberPicker numberPicker, int i, int i2) {
        this.a.m.setText(this.a.a(this.a.h.getValue()));
        this.a.n.setText(this.a.a(this.a.j.getValue()));
    }
}
