package com.vlocker.search;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

class h implements OnKeyListener {
    final /* synthetic */ BaiduSearchActivity a;

    h(BaiduSearchActivity baiduSearchActivity) {
        this.a = baiduSearchActivity;
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == 66 && keyEvent.getAction() == 0) {
            this.a.h = true;
            ap.a(this.a, view);
            String obj = this.a.a.getText().toString();
            if (TextUtils.isEmpty(obj)) {
                this.a.a(this.a.a.getHint().toString(), this.a.f, "NoTyping");
            } else {
                this.a.a(obj, this.a.f, "InnerBarSearch");
            }
        }
        return false;
    }
}
