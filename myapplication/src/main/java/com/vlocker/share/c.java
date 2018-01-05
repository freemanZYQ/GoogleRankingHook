package com.vlocker.share;

import com.tencent.tauth.b;
import com.tencent.tauth.d;

class c implements b {
    final /* synthetic */ ShareActivity a;

    c(ShareActivity shareActivity) {
        this.a = shareActivity;
    }

    public void onCancel() {
        this.a.finish();
    }

    public void onComplete(Object obj) {
        this.a.finish();
    }

    public void onError(d dVar) {
        this.a.finish();
    }
}
