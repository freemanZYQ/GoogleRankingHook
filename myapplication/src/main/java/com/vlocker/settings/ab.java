package com.vlocker.settings;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import com.vlocker.locker.R;

class ab implements TextWatcher {
    final /* synthetic */ FeedBackActivity a;

    ab(FeedBackActivity feedBackActivity) {
        this.a = feedBackActivity;
    }

    public void afterTextChanged(Editable editable) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (TextUtils.isEmpty(this.a.g.getEditableText().toString())) {
            this.a.d.setTextColor(this.a.getResources().getColor(R.color.v2_setting_alph127_white));
        } else {
            this.a.d.setTextColor(this.a.getResources().getColor(R.color.white));
        }
    }
}
