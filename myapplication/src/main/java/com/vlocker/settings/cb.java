package com.vlocker.settings;

import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;

class cb implements OnValueChangeListener {
    final /* synthetic */ QuestionActivity a;

    cb(QuestionActivity questionActivity) {
        this.a = questionActivity;
    }

    public void onValueChange(NumberPicker numberPicker, int i, int i2) {
        if (!this.a.r) {
            this.a.c();
        }
        switch (i2) {
            case 2:
                this.a.d.setMaxValue(29);
                return;
            case 4:
                this.a.d.setMaxValue(30);
                return;
            case 6:
                this.a.d.setMaxValue(30);
                return;
            case 9:
                this.a.d.setMaxValue(30);
                return;
            case 11:
                this.a.d.setMaxValue(30);
                return;
            default:
                this.a.d.setMaxValue(31);
                return;
        }
    }
}
