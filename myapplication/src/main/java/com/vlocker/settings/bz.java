package com.vlocker.settings;

import android.text.Editable;
import android.text.TextWatcher;

class bz implements TextWatcher {
    final /* synthetic */ QuestionActivity a;

    bz(QuestionActivity questionActivity) {
        this.a = questionActivity;
    }

    public void afterTextChanged(Editable editable) {
        this.a.c();
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
