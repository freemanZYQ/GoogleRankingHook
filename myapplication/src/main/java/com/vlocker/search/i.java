package com.vlocker.search;

import android.text.Editable;
import android.text.TextWatcher;
import com.vlocker.b.j;
import java.util.regex.PatternSyntaxException;

class i implements TextWatcher {
    final /* synthetic */ BaiduSearchActivity a;

    i(BaiduSearchActivity baiduSearchActivity) {
        this.a = baiduSearchActivity;
    }

    public void afterTextChanged(Editable editable) {
        try {
            String trim = this.a.a.getText().toString().trim();
            if (trim == null || trim.length() <= 0) {
                this.a.o.setVisibility(8);
                this.a.e.setVisibility(8);
                this.a.d.setVisibility(0);
            }
            if (trim == null || trim.length() == 0) {
                this.a.A.removeMessages(0);
                this.a.A.sendEmptyMessageDelayed(0, 600);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        try {
            j.f(this.a);
            String a = ap.a(this.a.a.getText().toString());
            this.a.A.removeMessages(0);
            if (a == null || a.length() == 0) {
                this.a.A.sendEmptyMessageDelayed(0, 300);
                return;
            }
            if (this.a.o.getVisibility() == 8) {
                this.a.o.setVisibility(0);
            }
            this.a.a(a);
        } catch (PatternSyntaxException e) {
            e.printStackTrace();
        }
    }
}
