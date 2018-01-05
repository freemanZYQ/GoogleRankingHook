package com.vlocker.weather;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;

class e implements OnClickListener {
    final /* synthetic */ a a;

    e(a aVar) {
        this.a = aVar;
    }

    public void onClick(View view) {
        if (!TextUtils.isEmpty(this.a.g)) {
            this.a.r.a(this.a, this.a.g);
        }
    }
}
