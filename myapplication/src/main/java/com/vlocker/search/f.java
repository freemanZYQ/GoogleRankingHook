package com.vlocker.search;

import android.view.View;
import android.view.View.OnClickListener;

class f implements OnClickListener {
    final /* synthetic */ BaiduSearchActivity a;

    f(BaiduSearchActivity baiduSearchActivity) {
        this.a = baiduSearchActivity;
    }

    public void onClick(View view) {
        this.a.h = true;
        try {
            String trim = this.a.a.getText().toString().trim();
            if (trim == null || trim.length() <= 0) {
                this.a.a(this.a.a.getHint().toString(), this.a.f, "NoTyping");
            } else {
                this.a.a(trim, this.a.f, "ButtonSearch");
            }
            ap.a(this.a, view);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
