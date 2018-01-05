package com.vlocker.settings;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

class c implements OnEditorActionListener {
    final /* synthetic */ CitySelectActivity a;

    c(CitySelectActivity citySelectActivity) {
        this.a = citySelectActivity;
    }

    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 3) {
            return false;
        }
        this.a.a();
        return true;
    }
}
